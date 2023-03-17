package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * @see  To use Base class
 * @author kaviy
 *
 */
public class CommonStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMsg) {
		WebElement element= pom.getSearchHotelPage().getTxtWelcomeMsg();
		
		String actLoginSuccessMsg=elementgetattribute(element);
		Assert.assertEquals("verify after login success message",expLoginSuccessMsg,actLoginSuccessMsg);
}
	

	@Then("User should verify after Book hotel success message {string} and save the generated order id")
	public void userShouldVerifyAfterBookHotelSuccessMessageAndSaveTheGeneratedOrderId(String expSuccessMessage) throws InterruptedException {
		Thread.sleep(10000);
		WebElement bookingConfrmMsg = pom.getBookConfirmPage().getTxtBookConfrimation();
		String getBookingConfirmMsg = elementGettext(bookingConfrmMsg);
		Assert.assertEquals("Verify after book hotel success message", getBookingConfirmMsg, expSuccessMessage);
	}
}
