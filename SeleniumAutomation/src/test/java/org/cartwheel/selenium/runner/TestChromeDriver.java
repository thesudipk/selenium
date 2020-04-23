package org.cartwheel.selenium.runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestChromeDriver {

	static ChromeDriverService service=null;
	public static void main(String[] args) throws MalformedURLException {
		
		
		
//		RestAssured.baseURI = "http://localhost:8081/Locator/webdriver";
//        RequestSpecification httpRequest = RestAssured.given();        
//        Response response = httpRequest.request(Method.GET);
//        
        
		//System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\FinalAutomationFramework\\AutoFrmwrkSpringBoot_v3\\SeleniumAutomationLocatorService\\src\\main\\resources\\chromedriver.exe");
		
		try {
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Workspace\\FinalAutomationFramework\\AutoFrmwrkSpringBoot_v3\\SeleniumAutomationLocatorService\\src\\main\\resources\\chromedriver.exe"
			 * ); ChromeOptions cop = new ChromeOptions();
			 * cop.setExperimentalOption("debuggerAddress","localhost:9223");
			 * 
			 * WebDriver dr = new ChromeDriver(cop); dr.get("http://www.walmart.com");
			 */
			
			
			
			
			
			
			//System.out.println("service url : "+service.getUrl());
			//System.out.println("is running ::" +service.isRunning());
			
			ChromeDriverService s1 = chdriverstart(9222);
			Capabilities cap = new DesiredCapabilities();
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9222"),cap);			
			driver.get("http://www.google.com");
			driver.close();			
			driver.quit();			
			System.out.println("---------------------");
			
			ChromeDriverService s2 = chdriverstart(9223);
			cap = new DesiredCapabilities();
			driver = new RemoteWebDriver(new URL("http://localhost:9223"),cap);			
			driver.get("http://www.walmart.com");
			driver.close();			
			driver.quit();
			
			System.out.println("---------------------");
			
			s1.stop();
			
			
			//service.stop();
			//System.out.println("service url : "+service.getUrl());
			//System.out.println("is running ::" +service.isRunning());
			
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		/*Capabilities cap = new DesiredCapabilities();
		// new URL("http://127.0.0.1:9515"), new ChromeOptions()
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515 "),cap);
		//WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();*/
	}
	
	public static ChromeDriverService chdriverstart(int port) throws IOException {
		
		 service=	new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("C:\\Workspace\\FinalAutomationFramework\\AutoFrmwrkSpringBoot_v3\\SeleniumAutomation\\src\\main\\resources\\chromedriver.exe"))
        .usingPort(port).withVerbose(true)
        //.usingAnyFreePort()
        .build();
		
    service.start();
    
    return service;
	}
	/*@AfterClass
	  public static void stopService() {
	    service.stop();
	  }

	  @Before
	  public void createDriver() {
	    driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
	  }

	  @After
	  public void quitDriver() {
	    driver.quit();
	  }

	  @Test
	  public void testGoogleSearch() {
	    driver.get("http://www.google.com");
	    // rest of the test...
	  }
*/
}
