package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * @see in login Base use base class
 * @author kaviy
 *
 */
public class LoginPage extends BaseClass {

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}
/**
 * @see To find username, password, loging, login errormsg
 */
	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement textLoginErrorMsg;

	public WebElement getTextLoginErrorMsg() {
		return textLoginErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void loginCommonStep(String userName, String password) {
		ElementSendkeys(getTxtUserName(), userName);
		ElementSendkeys(getTxtPassword(), password);
	}

	public void login(String userName, String password) {
		loginCommonStep(userName, password);
		elementclick(getBtnLogin());

	}

	public void loginWithEnter(String userName, String password) throws AWTException {
		loginCommonStep(userName, password);
		doubleTapWithEnter();
	}

}
