
package com.crio.warmup.stock;

import com.crio.warmup.stock.dto.AnnualizedReturn;
import com.crio.warmup.stock.dto.Candle;
import com.crio.warmup.stock.dto.PortfolioTrade;
import com.crio.warmup.stock.dto.TiingoCandle;
import com.crio.warmup.stock.dto.TotalReturnsDto;
import com.crio.warmup.stock.log.UncaughtExceptionHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileWriter;

import com.crio.warmup.stock.portfolio.PortfolioManager;
import com.crio.warmup.stock.portfolio.PortfolioManagerFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.client.RestTemplate;

public class PortfolioManagerApplication {

  private static PortfolioManager portfolioManager;

  //
  public static List<String> mainReadFile(String[] args) throws IOException, URISyntaxException {

    PortfolioTrade[] trade = readPortfolioTrades(args);

    List<String> trades = new ArrayList<>();

    for (PortfolioTrade portfolioTrade : trade) {
      trades.add(portfolioTrade.getSymbol());
    }

    return trades;
  }

  // First arg is Json filename
  public static PortfolioTrade[] readPortfolioTrades(String[] args)
      throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
    ObjectMapper objectMapper = getObjectMapper();

    File file = resolveFileFromResources(args[0]);
    PortfolioTrade[] trade = objectMapper.readValue(file, PortfolioTrade[].class);
    return trade;
  }

  public static List<String> debugOutputs() {

    String valueOfArgument0 = "trades.json";
    String resultOfResolveFilePathArgs0 = "trades.json";
    String toStringOfObjectMapper = "ObjectMapper";
    String functionNameFromTestFileInStackTrace = "mainReadFile";
    String lineNumberFromTestFileInStackTrace = "";

    return Arrays.asList(new String[] { valueOfArgument0, resultOfResolveFilePathArgs0, toStringOfObjectMapper,
        functionNameFromTestFileInStackTrace, lineNumberFromTestFileInStackTrace });
  }

  public static List<String> sortStocks(Map<Double, String>  stocksMap) {
    TreeMap<Double, String> stockMap = new TreeMap<>();
    List<String> stocksList = new ArrayList<>();
    stockMap.putAll(stocksMap);
    // for (Map.Entry<Double,String> entry : stockMap.entrySet()){
    // stocksList.add
    // }
    stocksList.addAll(stockMap.values());

    return stocksList;
  }

  public static TiingoCandle[] readTiingoCandles(PortfolioTrade trade, String endDate)
      throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
    String uriTemplate = "https://api.tiingo.com/tiingo/daily/$SYMBOL/prices?"
        + "startDate=$STARTDATE&endDate=$ENDDATE&token=$APIKEY";

    RestTemplate rest = new RestTemplate();

    String url = uriTemplate.replace("$SYMBOL", trade.getSymbol())
        .replace("$STARTDATE", trade.getPurchaseDate().toString()).replace("$ENDDATE", endDate)
        .replace("$APIKEY", "0175e650eb18193394fdc2c225b0c0ba954fa0a4");

    TiingoCandle[] candle = rest.getForObject(url, TiingoCandle[].class);

    return candle;
  }

  public static Double getBuyPrice(PortfolioTrade trade, String endDate)
      throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
    TiingoCandle[] candle = readTiingoCandles(trade, endDate);
    return candle[0].getOpen();
    // return null;
  }

  public static Double getSellPrice(PortfolioTrade trade, String endDate)
      throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
    TiingoCandle[] candle = readTiingoCandles(trade, endDate);
    return candle[candle.length - 1].getClose();
    // return null;
  }

  // Note:
  // Remember to confirm that you are getting same results for annualized returns
  // as in Module 3.
  public static List<String> mainReadQuotes(String[] args) throws IOException, URISyntaxException {
    Map<Double, String> stocksMap = new HashMap<>();
    // File file = resolveFileFromResources(args[0]);
    String uriTemplate = "https://api.tiingo.com/tiingo/daily/$SYMBOL/prices?"
        + "startDate=$STARTDATE&endDate=$ENDDATE&token=$APIKEY";

    RestTemplate rest = new RestTemplate();
    // ObjectMapper mapper = getObjectMapper();
    PortfolioTrade[] portfolioTrade = readPortfolioTrades(args);

    for (PortfolioTrade trade : portfolioTrade) {

      String url = uriTemplate.replace("$SYMBOL", trade.getSymbol())
          .replace("$STARTDATE", trade.getPurchaseDate().toString()).replace("$ENDDATE", args[1])
          .replace("$APIKEY", "0175e650eb18193394fdc2c225b0c0ba954fa0a4");

      TiingoCandle[] candles = rest.getForObject(url, TiingoCandle[].class);

      stocksMap.put(candles[candles.length - 1].getClose(), trade.getSymbol());

      // EXTRACT THE CLOSING PRICE FOR EACH SYMBOL
      // Then sort them based on the closing price

    }

    return sortStocks(stocksMap);

  }

  public static List<AnnualizedReturn> mainCalculateSingleReturn(String[] args) throws IOException, URISyntaxException {
    // gets 1 filename(ex. trades.json) and endate
    List<AnnualizedReturn> annualizedReturns = new ArrayList<>();
    PortfolioTrade[] trades = readPortfolioTrades(args);
    for (PortfolioTrade portfolioTrade : trades) {
      Double buyPrice = getBuyPrice(portfolioTrade, args[1]);
      Double sellPrice = getSellPrice(portfolioTrade, args[1]);
      annualizedReturns.add(calculateAnnualizedReturns(LocalDate.parse(args[1]), portfolioTrade, buyPrice, sellPrice));
    }
    List<AnnualizedReturn> sAnnualizedReturns = annualizedReturns.stream()
        .sorted(Comparator.comparing(AnnualizedReturn::getAnnualizedReturn).reversed()).collect(Collectors.toList());
    return sAnnualizedReturns;
  }

  public static AnnualizedReturn calculateAnnualizedReturns(LocalDate endDate, PortfolioTrade trade, Double buyPrice,
      Double sellPrice) {

    Double totalReturn = (sellPrice - buyPrice) / buyPrice;

    double total_num_years = trade.getPurchaseDate().until(endDate, ChronoUnit.DAYS) / 365.24;
    Double annualized_returns = Math.pow((1 + totalReturn), (1 / total_num_years)) - 1;

    return new AnnualizedReturn(trade.getSymbol(), annualized_returns, totalReturn);
  }

  private static ObjectMapper getObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper;
  }

  private static File resolveFileFromResources(String filename) throws URISyntaxException {
    return Paths.get(Thread.currentThread().getContextClassLoader().getResource(filename).toURI()).toFile();
  }


  

  // TODO: CRIO_TASK_MODULE_REFACTOR
  // Once you are done with the implementation inside PortfolioManagerImpl and
  // PortfolioManagerFactory, create PortfolioManager using
  // PortfolioManagerFactory.
  // Refer to the code from previous modules to get the List<PortfolioTrades> and
  // endDate, and
  // call the newly implemented method in PortfolioManager to calculate the
  // annualized returns.

  // Note:
  // Remember to confirm that you are getting same results for annualized returns
  // as in Module 3.

  public static List<AnnualizedReturn> mainCalculateReturnsAfterRefactor(String[] args) throws Exception {
    File file = resolveFileFromResources(args[0]);

    LocalDate endDate = LocalDate.parse(args[1]);
    // String contents = readFileAsString(file);
    ObjectMapper objectMapper = getObjectMapper();
    PortfolioTrade[] portfolioTrades = objectMapper.readValue(file, PortfolioTrade[].class);

    return portfolioManager.calculateAnnualizedReturn(Arrays.asList(portfolioTrades), endDate);
  }

  private static String readFileAsString(String file) throws URISyntaxException {
    return resolveFileFromResources(file).toString();
  }

  public static void main(String[] args) throws Exception {
    Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
    ThreadContext.put("runId", UUID.randomUUID().toString());
    String[] s = {"trades.json","2019-12-12"};
    mainCalculateReturnsAfterRefactor(s);
  }
}



