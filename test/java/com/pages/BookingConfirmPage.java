package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * @see Booling confirm page use base class
 * @author kaviy
 *
 */
public class BookingConfirmPage extends BaseClass {

	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
/**
 * @see To use xpath using book confirmation, order id
 */
	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement txtBookConfrimation;

	@FindBy(id = "order_no")
	private WebElement orderId;

	public WebElement getTxtBookConfrimation() {
		return txtBookConfrimation;
	}

	public WebElement getOrderId() {
		return orderId;
	}

	public String BookingConfrim(String Orderid) {
		String orderid = elementgetattribute(getOrderId());
		System.out.println(orderid);
		return orderid;
	}
}
