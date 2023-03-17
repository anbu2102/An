package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * @see To use Baseclass
 * @author kaviy
 *
 */
public class CancelBookingPage extends BaseClass {
/**
 * @see To cancel booking page
 */
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
/**
 * @see To find booked iterinery, order id, hutel id, cancel btn, cancell all, error msg 
 */
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnBookedItinery;

	@FindBy(id = "order_id_text")
	private WebElement txtOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[contains(@value,'Cancel')])[1]")
	private WebElement btnCancel;
	 @FindBy(name = "ids[]")
	 private WebElement btnSelect;
	
	 @FindBy(name = "cancelall")
	 private WebElement btnCancelSelect;
	 
	 @FindBy(id = "search_result_error")
		private WebElement errormsgs;

	public WebElement getErrormsgs() {
		return errormsgs;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBtnBookedItinery() {
		return btnBookedItinery;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtnCancelSelect() {
		return btnCancelSelect;
	}

	public void CancelBooking(String orderid) {

		elementclick(getBtnBookedItinery());
		ElementSendkeys(getTxtOrderId(), orderid);
		elementclick(getBtnGo());
		elementclick(getBtnCancel());
		clickokinalret();
		
	}

}
