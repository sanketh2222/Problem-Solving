package com.crio.xmeme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class XmemeApplication  {

	public static void main(String[] args) {

		SpringApplication.run(XmemeApplication.class, args);
		log.info("XMEME App server has started!!");
	}

}
