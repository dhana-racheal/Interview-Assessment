package com.Interview_Assessment.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Interview_Assessment.common.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage{
	
	@Before
	public void before(Scenario scenario) {
		System.out.println("Scenario started Successfully : "+scenario.getName());
	}

	@After
	public void after(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			final byte[] scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png",scenario.getName() );
		
		
		}
		
	}

}
