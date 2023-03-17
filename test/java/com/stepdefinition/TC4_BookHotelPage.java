package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

/**
 * @see in book hotel page use baseclass
 * @author kaviy
 *
 */
public class TC4_BookHotelPage extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
/**
 * @see Enter details
 * @param firstName
 * @param lastName
 * @param billingAddress
 * @param dataTable
 */
	@Then("User should enter details {string},{string} and {string}")
	public void userShouldEnterDetailsAnd(String firstName, String lastName, String billingAddress, DataTable dataTable) {
		pom.getBookHotel().bookHotel(firstName, lastName, billingAddress);
		List<Map<String, String>> asMaps = (List<Map<String, String>>)dataTable.asMaps();
        Map<String, String> map = asMaps.get(2);
        String ccNum = map.get("creditCardNo");
        String ccType = map.get("creditCardType");
        String expMonth = map.get("expiryMonth");
        String expYear = map.get("expiryYear");
        String cvv = map.get("cvvNumber");
        ElementSendkeys(pom.getBookHotel().getTxtCreditCardNo(), ccNum);
        selectoptionByText(pom.getBookHotel().getDropDownCardType(), ccType);
        selectoptionByText(pom.getBookHotel().getDropDownExpMonth(), expMonth);
        selectoptionByText(pom.getBookHotel().getDropDownExpYear(), expYear);
        ElementSendkeys(pom.getBookHotel().getTxtCvvNo(), cvv);
        pom.getBookHotel().withOutEnterAnyFeild();
    }
	
	/**
	 * @see Book hotel without enter ant details
	 */

	@Then("User should book hotel without enter any fields")
	public void userShouldBookHotelWithoutEnterAnyFields() {
		pom.getBookHotel().withOutEnterAnyFeild();
	}

/**
 * @see verify booking after error message
 * @param expfirstnameerroemsg
 * @param explastnameErrorMsg
 * @param expaddressErrorMsg
 * @param expcccardnoErrorMsg
 * @param expCCTypeErrorMsg
 * @param expExpMnthMsg
 * @param expCVVErrorMsg
 */
	@Then("User should verify after Booking error message {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterBookingErrorMessageAnd(String expfirstnameerroemsg,
			String explastnameErrorMsg, String expaddressErrorMsg,
			String expcccardnoErrorMsg, String expCCTypeErrorMsg,
			String expExpMnthMsg, String expCVVErrorMsg) {
		WebElement element = pom.getBookHotel().getErrorfirstname();
		String actlfristnameerrormsg = elementGettext(element);
		Assert.assertEquals("verify after book hotel error message", actlfristnameerrormsg, expfirstnameerroemsg);

		WebElement element2 = pom.getBookHotel().getErrorlastname();
		String lNameErrormsg = elementGettext(element2);
		Assert.assertEquals("verify after book hotel error message", lNameErrormsg, explastnameErrorMsg);

		WebElement addresserror = pom.getBookHotel().getErroraddress();
		String actladdErrormsg = elementGettext(addresserror);
		Assert.assertEquals("verify after book hotel error message", actladdErrormsg, expaddressErrorMsg);

		WebElement ccardnoerror = pom.getBookHotel().getErrorcardno();
		String ccnoErrormsg = elementGettext(ccardnoerror);
		Assert.assertEquals("verify after book hotel error message", ccnoErrormsg, expcccardnoErrorMsg);

		WebElement CCTypeErrorMsg = pom.getBookHotel().getErrorcardtype();
		String actlccTypeErrormsg = elementGettext(CCTypeErrorMsg);
		Assert.assertEquals("verify after book hotel error message", actlccTypeErrormsg, expCCTypeErrorMsg);

		WebElement ExpMnthMsg = pom.getBookHotel().getErrorexpirymonth();
		String expMnthErrormsg = elementGettext(ExpMnthMsg);
		Assert.assertEquals("verify after book hotel error message", expMnthErrormsg, expExpMnthMsg);

		WebElement CVVErrorMsg = pom.getBookHotel().getErrorcvv();
		String cvvErrormsg = elementGettext(CVVErrorMsg);
		Assert.assertEquals("verify after book hotel error message", cvvErrormsg, expCVVErrorMsg);
	}

}
