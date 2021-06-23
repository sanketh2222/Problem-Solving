
package com.crio.warmup.stock.portfolio;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.io.IOException;
import java.net.URISyntaxException;

import com.crio.warmup.stock.dto.AnnualizedReturn;
import com.crio.warmup.stock.dto.Candle;
import com.crio.warmup.stock.dto.PortfolioTrade;
import com.crio.warmup.stock.dto.TiingoCandle;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.crio.warmup.stock.quotes.StockQuotesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class PortfolioManagerImpl implements PortfolioManager {

  private RestTemplate restTemplate;

  private StockQuotesService quotesService;

  // Caution: Do not delete or modify the constructor, or else your build will
  // break!



  // Caution: Do not delete or modify the constructor, or else your build will break!
  // This is absolutely necessary for backward compatibility
  protected PortfolioManagerImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  protected PortfolioManagerImpl(StockQuotesService quotesService){
    this.quotesService = quotesService;
  }

  // TODO: CRIO_TASK_MODULE_REFACTOR
  // 1. Now we want to convert our code into a module, so we will not call it from
  // main anymore.
  // Copy your code from Module#3
  // PortfolioManagerApplication#calculateAnnualizedReturn
  // into #calculateAnnualizedReturn function here and ensure it follows the
  // method signature.
  // 2. Logic to read Json file and convert them into Objects will not be required
  // further as our
  // clients will take care of it, going forward.

  // Note:
  // Make sure to exercise the tests inside PortfolioManagerTest using command
  // below:
  // ./gradlew test --tests PortfolioManagerTest

 

  // TODO: CRIO_TASK_MODULE_REFACTOR
  // Extract the logic to call Tiingo third-party APIs to a separate function.
  // Remember to fill out the buildUri function and use that.

  

  // ¶TODO: CRIO_TASK_MODULE_ADDITIONAL_REFACTOR
  //  Modify the function #getStockQuote and start delegating to calls to
  //  stockQuoteService provided via newly added constructor of the class.
  //  You also have a liberty to completely get rid of that function itself, however, make sure
  //  that you do not delete the #getStockQuote function.

  public List<Candle> getStockQuote(String symbol, LocalDate from, LocalDate to) throws JsonProcessingException {

    //old
    // List<Candle> candle = new ArrayList<>();
    // TiingoCandle[] candles = restTemplate.getForObject(buildUri(symbol, from, to), TiingoCandle[].class);
    // for (TiingoCandle tiingoCandle : candles) {
    //   candle.add(tiingoCandle);
    // }
    // return candle;
    //new according to Open Close principle
    return quotesService.getStockQuote(symbol, from, to);
  }

  protected String buildUri(String symbol, LocalDate startDate, LocalDate endDate) {
    String uriTemplate = "https:api.tiingo.com/tiingo/daily/$SYMBOL/prices?"
        + "startDate=$STARTDATE&endDate=$ENDDATE&token=$APIKEY";

    String url = uriTemplate.replaceFirst("$SYMBOL", symbol).replaceAll("$STARTDATE", startDate.toString())
        .replaceAll("$ENDDATE", endDate.toString()).replaceAll("$APIKEY", "0175e650eb18193394fdc2c225b0c0ba954fa0a4");

    return url;
  }

  public  Double getSellPrice(PortfolioTrade trade, String endDate)
      throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
    List<Candle> candle = getStockQuote(trade.getSymbol(),trade.getPurchaseDate(),LocalDate.parse(endDate));
    return candle.get(candle.size() - 1).getClose();
    // return null;
  }

  public  Double getBuyPrice(PortfolioTrade trade, String endDate)
      throws JsonParseException, JsonMappingException, URISyntaxException, IOException {
    List<Candle> candle = getStockQuote(trade.getSymbol(),trade.getPurchaseDate(),LocalDate.parse(endDate));
    return candle.get(0).getOpen();
    // return null;
  }

  public static AnnualizedReturn calculateSingleAnnualizedReturns(LocalDate endDate, PortfolioTrade trade,
      Double buyPrice, Double sellPrice) {

    Double totalReturn = (sellPrice - buyPrice) / buyPrice;

    double total_num_years = trade.getPurchaseDate().until(endDate, ChronoUnit.DAYS) / 365.24;
    Double annualized_returns = Math.pow((1 + totalReturn), (1 / total_num_years)) - 1;

    return new AnnualizedReturn(trade.getSymbol(), annualized_returns, totalReturn);
  }

  @Override
  public List<AnnualizedReturn> calculateAnnualizedReturn(List<PortfolioTrade> portfolioTrades, LocalDate endDate) {

    List<AnnualizedReturn> annualizedReturns = new ArrayList<>();
    for (PortfolioTrade trade : portfolioTrades) {

      try {
        
        Double buyPrice = getBuyPrice(trade, endDate.toString());
        Double sellPrice = getSellPrice(trade, endDate.toString());
        annualizedReturns.add(calculateSingleAnnualizedReturns(endDate, trade, buyPrice, sellPrice));

      } catch (URISyntaxException | IOException e) {

        System.out.println("Exception Occured while finding buy or sell price");
        e.printStackTrace();
      }
     
    }
   
    Collections.sort(annualizedReturns, getComparator());
    return annualizedReturns;
  }


  private Comparator<AnnualizedReturn> getComparator() {
    return Comparator.comparing(AnnualizedReturn::getAnnualizedReturn).reversed();
  }



}
