package com.my.practo.practo.configuration;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PractoConfig {

    @Value("${mailApiKey}")
    private String apiKey;

    @Bean
    public SendGrid sendGrid(){
        return new SendGrid(apiKey);
    }

}
