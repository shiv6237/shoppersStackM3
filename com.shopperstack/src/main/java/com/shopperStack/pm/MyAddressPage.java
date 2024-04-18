package com.shopperStack.pm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {
	
	public MyAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAddressBtn ;
	
	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	private WebElement getDeletBtn;
	
	@FindBy(xpath = "//button[text()='Yes']")
	public WebElement getYesBtn;
	
	public WebElement getGetYesbtn() {
		return getYesBtn;
	}
	
	public WebElement getGetDeleteBtn() {
		return getDeletBtn;
	}
	public WebElement getAddAddress() {
		return addAddressBtn;
	}
	}
	
