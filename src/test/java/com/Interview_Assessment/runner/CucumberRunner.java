package com.Interview_Assessment.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Interview_Assessment.common.WebDriverSetup;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = ".\\src\\test\\resources\\com\\features\\FeatureFiles",
				glue = "com.Interview_Assessment.stepDefinitions", monochrome = true, dryRun = false,
				tags = "", 
				plugin = { "pretty", "html:Report/extentreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class CucumberRunner {

	private static TestNGCucumberRunner testNGCucumberRunner;
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	@Parameters({"browserType"})
	public void setUpClass(String browser) {
	    testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    driver = WebDriverSetup.getDriver();
	}

	@Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature){
	testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}
	@DataProvider
	public Object[][] scenarios() {
	    return testNGCucumberRunner.provideScenarios();
	}

	@AfterTest(alwaysRun = true)
	public void tearDownClass() {
	    testNGCucumberRunner.finish();
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
