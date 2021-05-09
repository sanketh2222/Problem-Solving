package com.crio.xmeme;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class XmemeApplication  {

	public static void main(String[] args) {

		SpringApplication.run(XmemeApplication.class, args);
		log.info("XMEME App server has started!!");


	}

	@Bean // Want a new obj every time
	@Scope("prototype")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
