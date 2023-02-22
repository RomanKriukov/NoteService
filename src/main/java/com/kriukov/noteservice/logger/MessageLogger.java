package com.kriukov.noteservice.logger;

import org.springframework.stereotype.Component;

@Component
public class MessageLogger implements Logger{
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
