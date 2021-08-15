# Currency-conversion-service

## bootstrap.properties

```java
spring.application.name=currency-conversion-service
server.port=8100
spring.cloud.config.uri=http://localhost:8888/
eureka.client.service-url.default-zone=http://localhost:8761/eureka
feign.client.config.default.connectTimeout=160000000
feign.client.config.default.readTimeout=160000000
ribbon.ConnectTimeout=120000
ribbon.ReadTimeout=120000
#THE BELOW PROPERTY WILL BE USE IF ANY ONLY IF YOUR APPLICATION NOT CONNECT WITH EUREKA
#currency-exchange-service.ribbon.listOfServers=http://localhost:8001,http://localhost:8000```
```

## Main Class

```java

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
```

## pom.xml

```java
   <!--TO CONNECT WITH CONFIG SERVER-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>

        <!--TO TRACE THE REQUEST WITH UNIQUE ID-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-sleuth</artifactId>
        </dependency>

        <!--ITS HELPS TO CALL THE OTHER MICRO SERVICE BUT WE HAVE TO CREATE PROXY-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <!--TO CONNECT WITH DISCOVERY SERVER-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <!--ITS USE FOR CLIENTS SIDE LOAD BALANCING-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
        </dependency>
```
    