package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * @see in search hote page use base class
 * @author kaviy
 *
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
/**
 * @see Search hotel details
 * @param location
 * @param hotel
 * @param roomtype
 * @param noofrooms
 * @param checkinDate
 * @param checkoutDate
 * @param adultsperroom
 * @param childperroom
 */
	@Then("User is to Search hotel details {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userIsToSearchHotelDetailsAnd(String location, String hotel, String roomtype, String noofrooms,
			String checkinDate, String checkoutDate, String adultsperroom, String childperroom) {
		pom.getSearchHotelPage().searchHotel(location, hotel, roomtype, noofrooms, checkinDate, checkoutDate, adultsperroom, childperroom);

	}
/**
 * @see Expect select success message
 * @param expSelectHotelSuccessMsg
 */
	@Then("User should verify after search success message {string}")
	public void userShouldVerifyAfterSearchSuccessMessage(String expSelectHotelSuccessMsg) {
	    WebElement txtSelectHotel = pom.getSelectHotelPage().getTxtSelectHotel();
	    String actSelectHotelSuccessMsg = elementGettext(txtSelectHotel);
	    Assert.assertEquals("verify after search success message", expSelectHotelSuccessMsg,actSelectHotelSuccessMsg);
	}
/**
 * @see Enter mandatory fields
 * @param location
 * @param noofrooms
 * @param checkinDate
 * @param checkoutDate
 * @param adultsperroom
 */
	@Then("User should enter only Mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFieldsAnd(String location, String noofrooms, String checkinDate,String checkoutDate, String adultsperroom) {
		pom.getSearchHotelPage().searchHotel(location, noofrooms, checkinDate, checkoutDate, adultsperroom);
	}
/**
 * @see Verify hotel with error message
 * @param expDateInErrorMessage
 * @param expDateOutErrorMessage
 */
	@Then("User should verify after search hotel with error message is {string} and {string}")
	public void userShouldVerifyAfterSearchHotelWithErrorMessageIs(String expDateInErrorMessage, String expDateOutErrorMessage) {
		WebElement checkInErrorMsg = pom.getSearchHotelPage().getCheckinDateErrormessage();
		String getCheckIn = elementGettext(checkInErrorMsg);
		Assert.assertEquals("verify after dateIn error messgae", getCheckIn, expDateInErrorMessage);

		WebElement checkOutErrorMsg = pom.getSearchHotelPage().getCheckoutDateErrormessage();
		String getCheckOut = elementGettext(checkOutErrorMsg);
		Assert.assertEquals("verify after dateout error messgae", getCheckOut, expDateOutErrorMessage);

	}
/**
 * @see Click search nutton
 */
	@Then("User should click Search button")
	public void userShouldClickSearchButton() {
		pom.getSearchHotelPage().searchHotel();
	}

	@Then("User should verify without enter any fields with error message is {string}")
	public void userShouldVerifyWithoutEnterAnyFieldsWithErrorMessageIs(String expErrorMessage) {
		pom.getSearchHotelPage().searchHotel();
		WebElement selectHotelErrorMsg = pom.getSearchHotelPage().getSearchErrorMessage();
		String gettext = elementGettext(selectHotelErrorMsg);
		Assert.assertEquals("verify after not enter any field in search hotel error message", gettext, expErrorMessage);

	}

}
