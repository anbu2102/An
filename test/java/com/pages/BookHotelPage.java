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
public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
/**
 * @see to find book hotel, first name, last name, address, creditcard num, card type, card expiry month and year
 */
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement txtBookaHotel;

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNo;

	@FindBy(id = "cc_type")
	private WebElement ddnCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement ddnExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement ddnExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNo;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	
	@FindBy(xpath = "//label[text()='Please Enter your First Name']")
	private WebElement errorfirstname;
	
	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement errorlastname;
	
	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement erroraddress;
	
	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement errorcardno;
	
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement errorcardtype;
	
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement errorexpirymonth;
	
	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement errorcvv;
	
	public WebElement getErrorfirstname() {
		return errorfirstname;
	}

	public WebElement getErrorlastname() {
		return errorlastname;
	}

	public WebElement getErroraddress() {
		return erroraddress;
	}

	public WebElement getErrorcardno() {
		return errorcardno;
	}

	public WebElement getErrorcardtype() {
		return errorcardtype;
	}

	public WebElement getErrorexpirymonth() {
		return errorexpirymonth;
	}

	public WebElement getErrorcvv() {
		return errorcvv;
	}

	public WebElement getTxtBookaHotel() {
		return txtBookaHotel;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getDropDownCardType() {
		return ddnCardType;
	}

	public WebElement getDropDownExpMonth() {
		return ddnExpMonth;
	}

	public WebElement getDropDownExpYear() {
		return ddnExpYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookHotel(String FirstName, String LastName, String Address) {
		ElementSendkeys(getTxtFirstName(), FirstName);
		ElementSendkeys(getTxtLastName(), LastName);
		ElementSendkeys(getTxtAddress(), Address);
	}
	public void withOutEnterAnyFeild() {
		elementclick(getBtnBookNow());
	}

}
