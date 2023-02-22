package com.kriukov.noteservice.configuration;

import com.kriukov.noteservice.logger.Logger;
import com.kriukov.noteservice.logger.MessageLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Logger getLogger(){
        return new MessageLogger();
    }
}
