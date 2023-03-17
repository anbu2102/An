package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseclass.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**
 * @see To use Baseclass
 * @author kaviy
 *
 */
public class HooksClass extends BaseClass {
	@Before
/**
 * @see To get Propertyfile and url	
 * @throws FileNotFoundException
 * @throws IOException
 */
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		enterappurl(getPropertyFileValue("url"));
		MaxizimizeWindow();
		implicitwait();
	}

	@After
/**
 * @see To get imgae to use TakeScreenshot
 * @param scenario
 */
	public void afterScenario(Scenario scenario) {
	scenario.embed(screenshot(), "image/png");
		quitewindow();
	}

}
