package org.cartwheel.selenium.stepdefinition;

import java.net.URL;

import org.cartwheel.selenium.CucumberRoot;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDef extends CucumberRoot {

	@Autowired
	protected TestRestTemplate template;


	
	@Given("^user id and password$")
	public void user_id_and_password() throws Exception {
		Capabilities cap = new DesiredCapabilities();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515 "), cap);
		driver.get("http://www.google.com");
		driver.quit();
	}

	@Then("^I log into application$")
	public void i_log_into_application() throws Exception {
	    
	}
	
	
	 

}
