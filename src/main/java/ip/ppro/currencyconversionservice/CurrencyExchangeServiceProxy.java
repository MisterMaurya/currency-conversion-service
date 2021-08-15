package ip.ppro.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/***
 * @author Pawan Maurya
 * @since Aug 07, 2021
 */

// IF YOUR currency-exchange-service not connect with EUREKA THEN USE LIKE BE
// BUL IN THIS CASE URL WILL BE HARDCODED HERE
//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000/")

// IF YOUR currency-exchange-service connect with EUREKA THEN WE JUST NEED ("name") and LOAD BALANCE WILL be
// happen with RIBBON
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
// FEIGN REQUIRED API GATEWAY SERVER NAME IT MUST CONNECT WITH EUREKA
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {


    // WITHOUT API GATE SERVER

    /**
     * @GetMapping("/currency-exchange/from/{from}/to/{to}") public CurrencyConversionBean
     * retrieveExchangeValue(@PathVariable("from") String from,
     * @PathVariable("to") String to);
     */

    // IF YOUR USED ZUUL API GATE SERVER
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
                                                        @PathVariable("to") String to);
}
