package org.cartwheel.selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages="org.cartwheel")
public class SeleniumAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumAutomationApplication.class, args);
	}

}
