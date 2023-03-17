package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @see in cancel booking step using Basecalss
 * @author kaviy
 *
 */
public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
/**
 * @see generate order id
 */

	@Then("User should cancel the generated order id")
	public void userShouldCancelTheGeneratedOrderId() {

		WebElement orderId = pom.getBookConfirmPage().getOrderId();
		String generatedOrderId = elementgetattribute(orderId);
		pom.getCancelBookingPage().CancelBooking(generatedOrderId);
		System.out.println(generatedOrderId);
	}
/**
 * @see verify after cancel success message
 * @param expCancelMsg
 */
	@Then("User should verify after cancel success message {string}")
	public void userShouldVerifyAfterCancelSuccessMessage(String expCancelMsg) {
		WebElement cancelMsg = pom.getCancelBookingPage().getErrormsgs();
		String aclerrormsg = elementGettext(cancelMsg);
		Assert.assertEquals("Verify after cancel order id success message", aclerrormsg, expCancelMsg);
	}
/**
 * @see Cancel existing order id
 * @param orderid
 */
	@Then("User should cancel the existing order id {string}")
	public void userShouldCancelTheExistingOrderId(String orderid) {
		pom.getCancelBookingPage().CancelBooking(orderid);
	
	}

}
