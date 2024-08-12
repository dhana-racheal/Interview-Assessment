package com.Interview_Assessment.stepDefinitions;

import com.Interview_Assessment.common.BasePage;
import com.Interview_Assessment.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BasePage{
	
	HomePage home_page;
	
	@Given("User is on the Home page {string}")
	public void user_is_on_the_home_page(String url) {
	    launchUrl(url);
	    LOGGER.info("url launched succesfully");
	}

	@When("User scroll through the Home feed contents")
	public void user_scroll_through_the_home_feed_contents() {
	   home_page = new HomePage(driver);
	   home_page.scrollHomeFeeds();
	   LOGGER.info("Home page feeds Scrolled");
	}

	@When("User verify the location mapped to these contents is either {string} or {string} or {string}")
	public void user_verify_the_location_mapped_to_these_contents_is_either_or_or(String string, String string2, String string3) {
		home_page.verifyFeedLocation();
		LOGGER.info("Location mapped to contents are verified");
	}

	@When("User switch to the klips screen")
	public void user_switch_to_the_klips_screen() {
		home_page = new HomePage(driver);
		home_page.switchToKlips();
		LOGGER.info("User switched to video klips successfully");
	}

	@Then("User validate the title and user profile name of the first two or three klips")
	public void user_validate_the_title_and_user_profile_name_of_the_first_two_or_three_klips() {
		home_page.getProfileName();
		LOGGER.info("Title and profile name validated");
	}


}
