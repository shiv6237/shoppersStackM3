package com.shopperStack.pm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[contains(@class,'BaseBadge')])[1]")
	private WebElement accountButton;
	
	@FindBy(xpath="//li[text()='My Profile']")
	private WebElement myprofileButton;
	
	@FindBy(xpath="//li[text()='Logout']")
	private WebElement logoutButton;
	
	public WebElement getaccountButton() {
		return accountButton;	
	}
	
	public WebElement getMyProfileButton() {
		return myprofileButton;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
}
