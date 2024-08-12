package com.Interview_Assessment.common;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;                                                    
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;

public abstract class BasePage {
	
	public static WebDriver driver = WebDriverSetup.getDriver();
	WebDriverWait driverWait;
	public static final Logger LOGGER = LogManager.getLogger(BasePage.class);

	public static void launchUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected static void inputValues(WebDriver driver,WebElement Element, String Value ) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)) 
			.until(ExpectedConditions.elementToBeClickable(Element))
			.sendKeys(Value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void clickElement(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15)) 
			.until(ExpectedConditions.elementToBeClickable(element))
			.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public static void clickjs(WebDriver driver,WebElement element ) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
		
	public void exitBrowser(WebDriver driver) {
		driver.quit();

	}
	
}
