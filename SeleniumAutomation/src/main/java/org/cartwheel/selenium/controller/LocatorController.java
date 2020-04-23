
package org.cartwheel.selenium.controller;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Locator")
public class LocatorController {

	@Autowired
	Environment environment;

	@RequestMapping(method = RequestMethod.GET, value = "/webdriver", produces = { "application/json" })
	public String getwebdriver() {

		ChromeDriver chdriver = loadchromedriver();
		chdriver.navigate().to("https://sg.freddiemac.com/pages/welcome");
		return "{\"x\" : \"I am here\" }";

	}
	
	private ChromeDriver loadchromedriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		ChromeDriver chdriver = new ChromeDriver(options);
		
		return chdriver;
		
	}
}
