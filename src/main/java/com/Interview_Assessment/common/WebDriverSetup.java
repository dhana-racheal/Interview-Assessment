package com.Interview_Assessment.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("incognito");
			driver = new ChromeDriver(opt);
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			driver = browserLaunch("chrome");
			return driver;
		}else {
			return driver;
		}
		
	}
}
