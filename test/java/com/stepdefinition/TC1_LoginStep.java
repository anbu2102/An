package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @see To Use Baseclass 
 * @author kaviy
 *
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {
	}
	/**
	 * @see Login
	 * @param name
	 * @param password
	 */
	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String name, String password) {
		pom.getLoginPage().login(name, password);
	}
/**
 * @see Login with enter key
 * @param userName
 * @param password
 * @throws AWTException
 */
	@When("User should perform login {string},{string} with enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(userName, password);
	}
/**
 * @see Ecp login error message
 * @param expLoginErrorMessage
 */
	@Then("User should verify after login with invalid credentials error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialsErrorMessageContains(String expLoginErrorMessage) {
		WebElement element = pom.getLoginPage().getTextLoginErrorMsg();
		String gettext = elementGettext(element);
		boolean b = gettext.contains(expLoginErrorMessage);
		Assert.assertTrue("verify after login with invalid credentials error message contains", b);
	}

}
