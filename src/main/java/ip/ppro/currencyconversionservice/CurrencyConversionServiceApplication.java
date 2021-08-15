package ip.ppro.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

// WE HAVE TO PROVIDE Feign CLIENT DIRECTORY PACKAGE TO SCAN
@EnableFeignClients("ip.ppro.currencyconversionservice")
@SpringBootApplication
// TO CONNECT WITH DISCOVERY CLIENT
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionServiceApplication.class, args);
    }


    //IT WILL INTERCEPT ALL THE REQUEST
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
