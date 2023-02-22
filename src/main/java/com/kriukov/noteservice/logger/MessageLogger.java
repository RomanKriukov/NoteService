package com.kriukov.noteservice.logger;

public class MessageLogger implements Logger{
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
