package com.Interview_Assessment.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.Interview_Assessment.common.BasePage;
import com.Interview_Assessment.common.ExcelUtils;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	List<String> profile_list;
	List<String> title_list;
	List<String> loc_list;
	List<String> category_list;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='post']")
	private List<WebElement> home_feeds_list;
	@FindBy(xpath = "//div[@class='location detail-item']//div[@class='name']")
	private List<WebElement> location_details_list;
	@FindBy(xpath = "//span[text() = 'Klips']")
	private WebElement klips_btn;
	@FindBy(xpath = "//div[@class='header']/a/div")
	private List<WebElement> profile_name_list;
	@FindBy(xpath = "//div[@class='content-details']/div/p[1]")
	private List<WebElement> content_title_list;
	@FindBy(xpath = "//div[@class='location detail-item']/div")
	private List<WebElement> location_list;
	@FindBy(xpath = "//div[@class='category detail-item']/div")
	private List<WebElement> category_name_list;

	public void scrollHomeFeeds() {
		for (int i = 0; i < 4; i++) {
			scrollIntoView(driver, home_feeds_list.get(i));
		}
	}

	public void verifyFeedLocation() {
		List<String> locations = new ArrayList<>();
		SoftAssert s = new SoftAssert();
		for (int i = 0; i < 3; i++) {
			locations.add(getText(location_details_list.get(i)));

			if (Locations.AnnaNagar.getLocation().equals(getText(location_details_list.get(i)))) {
				s.assertEquals(Locations.AnnaNagar.getLocation(), getText(location_details_list.get(i)));
			} else if (Locations.Mylapore.getLocation().equals(getText(location_details_list.get(i)))) {
				s.assertEquals(Locations.Mylapore.getLocation(), getText(location_details_list.get(i)));
			} else if (Locations.TNagar.getLocation().equals(getText(location_details_list.get(i)))) {
				s.assertEquals(Locations.TNagar.getLocation(), getText(location_details_list.get(i)));
			} else {
				s.assertTrue(false);
			}
		}
		s.assertAll();
	}

	public void switchToKlips() {
		clickElement(driver, klips_btn);
	}

	public void getProfileName() {
		profile_list = new ArrayList<>();
		

			try {
				profile_list = ExcelUtils.readAllExcelData(".\\src\\main\\resources\\kynhood.xlsx", "klips_data");
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 3; i++) {
				if(profile_list.contains(getText(profile_name_list.get(i)))) {
					Assert.assertTrue(true);
				System.out.println("##############"+getText(profile_name_list.get(i)));
				}
				else if(profile_list.contains(getText(content_title_list.get(i)))) {
					Assert.assertTrue(true);
					System.out.println("##############"+getText(content_title_list.get(i)));
				}
					
				else if(profile_list.contains(getText(location_list.get(i)))) {
					System.out.println("##############"+getText(location_list.get(i)));
					Assert.assertTrue(true);
				}
					
				else if(profile_list.contains(getText(category_name_list.get(i)))) {
					Assert.assertTrue(true);
					System.out.println("##############"+getText(category_name_list.get(i)));
				}
					
			}
			System.out.println(profile_list);
			
			
		}
		
	

}
