package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigurationRead;

public class BasePage {
	
	public  WebDriver driver;
	ConfigurationRead prop;
	
	public void initDriver(String browserName) {
		
		
		prop = new ConfigurationRead();
		String driversPath=System.getProperty("user.dir")+"\\src\\test\\resources\\drivers";
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driversPath+"\\chromedriver.exe");
			this.driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driversPath+"\\geckodriver.exe");
			this.driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void launchApp() throws IOException {
		 this.driver.get(prop.readProperties().getProperty("URL"));
	}
	
	

}
