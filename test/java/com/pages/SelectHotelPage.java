package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * @see in select hotel page use base class
 * @author kaviy
 *
 */
public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
/**
 * @see To find select hotel, Errormsg
 */
	@FindBy(xpath = "//td[contains(text(),'Select Hotel')]")
	private WebElement txtSelectHotel;

	@FindBy(id = "radiobutton_0")
	private WebElement btnSelect;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(xpath = "//label[text() = 'Please Select a Hotel']")
	private WebElement continueErrorMsg;

	public WebElement getTxtSelectHotel() {
		return txtSelectHotel;
	}

	public WebElement getContinueErrorMess() {
		return continueErrorMsg;
	}

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selecthotel() {
		elementclick(getBtnSelect());
		elementclick(getBtnContinue());

	}

	public void withOutSelectHotel() {
		elementclick(getBtnContinue());
	}

}