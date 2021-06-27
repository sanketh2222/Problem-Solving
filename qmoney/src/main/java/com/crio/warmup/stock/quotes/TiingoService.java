
package com.crio.warmup.stock.quotes;

import com.crio.warmup.stock.dto.AnnualizedReturn;
import com.crio.warmup.stock.dto.Candle;
import com.crio.warmup.stock.dto.PortfolioTrade;
import com.crio.warmup.stock.dto.TiingoCandle;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.crio.warmup.stock.exception.StockQuoteServiceException;


import org.springframework.web.client.RestTemplate;

public class TiingoService implements StockQuotesService {

  private RestTemplate restTemplate;

  protected TiingoService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public List<Candle> getStockQuote(String symbol, LocalDate from, LocalDate to) throws JsonProcessingException, StockQuoteServiceException {
    // TODO Auto-generated method stub
    List<Candle> candle = new ArrayList<>();
    String candles = restTemplate.getForObject(buildUri(symbol, from, to), String.class);

    if (candles == null) {
      throw new StockQuoteServiceException("ex occured");
    }
    if (candles.contains("Please")){
      throw new StockQuoteServiceException("ex occured");
    }
    ObjectMapper objectMapper = getObjectMapper();
    TiingoCandle[] tiingoCandles = objectMapper.readValue(candles, TiingoCandle[].class);
    for (TiingoCandle tiingoCandle : tiingoCandles) {
      candle.add(tiingoCandle);
    }
    return candle;

  }

  private ObjectMapper getObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper;
  }

  protected String buildUri(String symbol, LocalDate startDate, LocalDate endDate) {
    String uriTemplate = "https://api.tiingo.com/tiingo/daily/$SYMBOL/prices?"
        + "startDate=$STARTDATE&endDate=$ENDDATE&token=$APIKEY";

    return  uriTemplate.replace("$SYMBOL", symbol).replace("$STARTDATE", startDate.toString())
        .replace("$ENDDATE", endDate.toString()).replace("$APIKEY", "0175e650eb18193394fdc2c225b0c0ba954fa0a4");


  }

  public Double getSellPrice(PortfolioTrade trade, String endDate)
      throws   JsonProcessingException, StockQuoteServiceException {
    List<Candle> candle = getStockQuote(trade.getSymbol(), trade.getPurchaseDate(), LocalDate.parse(endDate));
    return candle.get(candle.size() - 1).getClose();

  }

  public Double getBuyPrice(PortfolioTrade trade, String endDate)
      throws  JsonProcessingException, StockQuoteServiceException {
    List<Candle> candle = getStockQuote(trade.getSymbol(), trade.getPurchaseDate(), LocalDate.parse(endDate));
    return candle.get(0).getOpen();
  }

  public static AnnualizedReturn calculateSingleAnnualizedReturns(LocalDate endDate, PortfolioTrade trade,
      Double buyPrice, Double sellPrice) {

    Double totalReturn = (sellPrice - buyPrice) / buyPrice;

    double total_num_years = trade.getPurchaseDate().until(endDate, ChronoUnit.DAYS) / 365.24;
    Double annualized_returns = Math.pow((1 + totalReturn), (1 / total_num_years)) - 1;

    return new AnnualizedReturn(trade.getSymbol(), annualized_returns, totalReturn);
  }

  public List<AnnualizedReturn> calculateAnnualizedReturn(List<PortfolioTrade> portfolioTrades, LocalDate endDate) throws StockQuoteServiceException {

    List<AnnualizedReturn> annualizedReturns = new ArrayList<>();
    for (PortfolioTrade trade : portfolioTrades) {

      try {

        Double buyPrice = getBuyPrice(trade, endDate.toString());
        Double sellPrice = getSellPrice(trade, endDate.toString());
        annualizedReturns.add(calculateSingleAnnualizedReturns(endDate, trade, buyPrice, sellPrice));

      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    Collections.sort(annualizedReturns, getComparator());
    return annualizedReturns;
  }

  private Comparator<AnnualizedReturn> getComparator() {
    return Comparator.comparing(AnnualizedReturn::getAnnualizedReturn).reversed();
  }

  // TODO: CRIO_TASK_MODULE_ADDITIONAL_REFACTOR
  // Implement getStockQuote method below that was also declared in the interface.

  // Note:
  // 1. You can move the code from PortfolioManagerImpl#getStockQuote inside newly
  // created method.
  // 2. Run the tests using command below and make sure it passes.
  // ./gradlew test --tests TiingoServiceTest

  // CHECKSTYLE:OFF

  // TODO: CRIO_TASK_MODULE_ADDITIONAL_REFACTOR
  // Write a method to create appropriate url to call the Tiingo API.





  // TODO: CRIO_TASK_MODULE_EXCEPTIONS
  //  1. Update the method signature to match the signature change in the interface.
  //     Start throwing new StockQuoteServiceException when you get some invalid response from
  //     Tiingo, or if Tiingo returns empty results for whatever reason, or you encounter
  //     a runtime exception during Json parsing.
  //  2. Make sure that the exception propagates all the way from
  //     PortfolioManager#calculateAnnualisedReturns so that the external user's of our API
  //     are able to explicitly handle this exception upfront.

  //CHECKSTYLE:OFF


}
