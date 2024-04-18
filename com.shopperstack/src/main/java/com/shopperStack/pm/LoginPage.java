package com.shopperStack.pm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement passwordTextfield;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginButton;
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	public WebElement getPasswordField() {
		return passwordTextfield;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
		
	}
}
