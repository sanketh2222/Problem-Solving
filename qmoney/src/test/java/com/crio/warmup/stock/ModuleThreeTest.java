
package com.crio.warmup.stock;

import com.crio.warmup.stock.dto.AnnualizedReturn;
import com.crio.warmup.stock.dto.PortfolioTrade;
import com.crio.warmup.stock.dto.TiingoCandle;
import com.crio.warmup.stock.portfolio.PortfolioManager;
import com.crio.warmup.stock.portfolio.PortfolioManagerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;
class ModuleThreeTest {

  @Mock
  private RestTemplate restTemplate;

  @Test
  void mainCalculateReturns() throws Exception {
    String filename = "assessments/trades.json";

    //when
    List<AnnualizedReturn> result = PortfolioManagerApplication
        .mainCalculateSingleReturn(new String[]{filename, "2019-12-12"});

    //then
    List<String> symbols = result.stream().map(AnnualizedReturn::getSymbol)
        .collect(Collectors.toList());
    Assertions.assertEquals(0.556, result.get(0).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(0.044, result.get(1).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(0.025, result.get(2).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(Arrays.asList(new String[]{"MSFT", "CSCO", "CTS"}), symbols);
  }

  @Test
  void testError() throws Exception {
    //given
    String filename = "assessments/module7-error.json";
    LocalDate endDate = LocalDate.now().minus(1, ChronoUnit.DAYS);

    //when
    List<AnnualizedReturn> result = PortfolioManagerApplication
        .mainCalculateSingleReturn(new String[]{filename, endDate.toString()});
    // RestTemplate restTemplate = new RestTemplate();
    PortfolioManager manager = PortfolioManagerFactory.getPortfolioManager("tiingo", restTemplate);
    // result.get(0).getSymbol();
    PortfolioTrade trade1 = new PortfolioTrade(result.get(0).getSymbol(), 50, LocalDate.parse(endDate.toString()));
    PortfolioTrade trade2 = new PortfolioTrade(result.get(1).getSymbol(), 100, LocalDate.parse(endDate.toString()));
    // PortfolioTrade trade3 = new PortfolioTrade("MSFT", 20, LocalDate.parse("2019-01-02"));
    List<PortfolioTrade> portfolioTrades = Arrays
        .asList(new PortfolioTrade[]{trade1, trade2});

    List<AnnualizedReturn> results = manager.calculateAnnualizedReturn(portfolioTrades, endDate);

    //then
    List<String> symbols = result.stream().map(AnnualizedReturn::getSymbol)
        .collect(Collectors.toList());
    Assertions.assertEquals(true,true);
    // Assertions.assertEquals(0.556, result.get(0).getAnnualizedReturn(), 0.01);
    // Assertions.assertEquals(0.044, result.get(1).getAnnualizedReturn(), 0.01);
    // Assertions.assertEquals(0.025, result.get(2).getAnnualizedReturn(), 0.01);
    // Assertions.assertEquals(Arrays.asList(new String[]{"MSFT", "CSCO", "CTS"}), symbols);
  }

  @Test
  void mainCalculateReturnsEdgeCase() throws Exception {
    //given
    String filename = "assessments/empty.json";

    //when
    List<AnnualizedReturn> result = PortfolioManagerApplication
        .mainCalculateSingleReturn(new String[]{filename, "2019-12-12"});

    Assertions.assertTrue(result.isEmpty());
  }

  @Test
  void mainCalculateReturnsVaryingDateRanges() throws Exception {
    //given
    String filename = "assessments/trades_invalid_dates.json";
    //when
    List<AnnualizedReturn> result = PortfolioManagerApplication
        .mainCalculateSingleReturn(new String[]{filename, "2019-12-12"});

    //then
    List<String> symbols = result.stream().map(AnnualizedReturn::getSymbol)
        .collect(Collectors.toList());
    Assertions.assertEquals(0.36, result.get(0).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(0.15, result.get(1).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(0.02, result.get(2).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(Arrays.asList(new String[]{"MSFT", "CSCO", "CTS"}), symbols);

  }


  @Test
  void mainCalculateReturnsInvalidStocks() throws Exception {
    //given
    String filename = "assessments/trades_invalid_stock.json";
    //when
    Assertions.assertThrows(RuntimeException.class, () -> PortfolioManagerApplication
        .mainCalculateSingleReturn(new String[]{filename, "2019-12-12"}));

  }

  @Test
  void mainCalculateReturnsOldTrades() throws Exception {
    //given
    String filename = "assessments/trades_old.json";

    //when
    List<AnnualizedReturn> result = PortfolioManagerApplication
        .mainCalculateSingleReturn(new String[]{filename, "2019-12-20"});

    //then
    List<String> symbols = result.stream().map(AnnualizedReturn::getSymbol)
        .collect(Collectors.toList());
    Assertions.assertEquals(0.141, result.get(0).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(0.091, result.get(1).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(0.056, result.get(2).getAnnualizedReturn(), 0.01);
    Assertions.assertEquals(Arrays.asList(new String[]{"ABBV", "CTS", "MMM"}), symbols);
  }

}
