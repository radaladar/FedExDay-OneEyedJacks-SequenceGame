package com.sequencegame.oneeyedjacks.fedexday.greenfox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ${SzilviaB} on 2017. 01. 26..
 */
@Configuration
public class AppJavaConfig {

    @Bean(name = "stringPrintWriter") @Scope("prototype")
    public PrintWriter printWriter(){
        // useful when dumping stack trace to file
        return new PrintWriter(new StringWriter());
    }

}
