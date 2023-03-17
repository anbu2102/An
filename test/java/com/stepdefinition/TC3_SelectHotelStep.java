package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @see in select hotel page use baseclass
 * @author kaviy
 *
 */
public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
/**
 * @see Select hotel
 */
	@Then("User should select the hotel")
	public void userShouldSelectTheHotel() {
		pom.getSelectHotelPage().selecthotel();
	}
/**
 * @see Verify after success message
 * @param expSelectHotelSuccessMessage
 */
	@Then("User should verify the after continue success message {string}")
	public void userShouldVerifyTheAfterContinueSuccessMessage(String expSelectHotelSuccessMessage) {
		WebElement bookingMsg = pom.getBookHotel().getTxtBookaHotel();
		String getBooking = elementGettext(bookingMsg);
		Assert.assertEquals("Verify after select hotel success message", getBooking, expSelectHotelSuccessMessage);

	}
/**
 * @see Click continue
 */
	@Then("User should click continue")
	public void userShouldClickContinue() {
		pom.getSelectHotelPage().withOutSelectHotel();
	}
/**
 * @see Verify after error message
 * @param expSelectHotelErrorMessage
 */
	@Then("User should verify after continue error message {string}")
	public void userShouldVerifyAfterContinueErrorMessage(String expSelectHotelErrorMessage) {
		WebElement bookingErrorMsg = pom.getSelectHotelPage().getContinueErrorMess();
		String gettext = elementGettext(bookingErrorMsg);
		Assert.assertEquals("Verify after select hotel error message", gettext, expSelectHotelErrorMessage);

	}

}
