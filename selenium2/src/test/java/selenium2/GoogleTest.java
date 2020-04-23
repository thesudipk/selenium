package selenium2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

@Test
public class GoogleTest {

	//public static void main(String[] args) throws MalformedURLException {
	
	@Test
	public void test() {
		 
		
	 
		try {
			Capabilities cap = new DesiredCapabilities();
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"),cap);			
			driver.get("http://www.google.com");
			driver.close();			
			driver.quit();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
