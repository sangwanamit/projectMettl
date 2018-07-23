package genericLib;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;

public class Base {
	public static WebDriver driver ; 

	@BeforeClass
	public void setUp() {

		HashMap<String,String> configData =  ExcelLib.getConfigData();	//Config Data fetched from the Excel File and stored into HashMap
		
		String Browser = configData.get("BROWSER");
		
		switch (Browser) {
		case "Chrome": 
			System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver" );
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			break ;
		
		case "Safari":

			driver = new SafariDriver();	// Remote automation have to be enabled from Safari Settings.
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
			break;
		
		case "FireFox":
			System.setProperty("webdriver.gecko.driver",".//drivers//geckodriver" );
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
			break;
			
		default: System.out.println("No browser selected");
		
		}
		
		driver.get(configData.get("URL"));
		
		
		
		
		
	}

}
