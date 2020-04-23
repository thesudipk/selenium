package org.cartwheel.selenium.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features"},
		glue = {"org.cartwheel.selenium"},
		plugin= {"pretty","json:target/JSON/cucumber.json"},
		tags= {"@login"}
		)

public class Testrunner {

}
