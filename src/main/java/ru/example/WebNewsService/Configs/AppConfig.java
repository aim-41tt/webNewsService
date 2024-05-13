package ru.example.WebNewsService.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import ru.example.WebNewsService.services.MicroserviceClientCreatorNews;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public MicroserviceClientCreatorNews microserviceClient() {
        return new MicroserviceClientCreatorNews(restTemplate());
    }
}
