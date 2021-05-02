package com.threads.multi;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.LoggerFactory;
//import com.sun.org.slf4j.internal.LoggerFactory;

@SpringBootApplication
public class MultiApplication {
	
	public static Logger logger = LoggerFactory.getLogger(MultiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MultiApplication.class, args);
		logger.info("your application has started !!!");
	}

}
