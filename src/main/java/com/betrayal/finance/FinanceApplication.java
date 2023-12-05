package com.betrayal.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		SpringApplication.run(FinanceApplication.class, args);
	}

}
