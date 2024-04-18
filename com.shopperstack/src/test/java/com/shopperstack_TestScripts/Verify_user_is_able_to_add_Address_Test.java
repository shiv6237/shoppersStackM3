package com.shopperstack_TestScripts;

import java.io.IOException;	

import org.testng.annotations.Test;

import com.shopperStack.pm.AddressFormPage;
import com.shopperStack.pm.MyAddressPage;
import com.shopperStack.pm.MyProfilePage;
import com.shopperstackGenericUtility.BaseTest;

public class Verify_user_is_able_to_add_Address_Test extends BaseTest {
	
	
	@Test
	public void addAddress() throws IOException {
		
	homePage.getaccountButton().click();
	homePage.getMyProfileButton().click();
	
	MyProfilePage myProfilePage=new MyProfilePage(driver);
	myProfilePage.getAddressBtn().click();
	
	
	MyAddressPage myAddressPage=new MyAddressPage(driver);
	myAddressPage.getAddAddressBtn().click();
	
	AddressFormPage addressFormPage=new AddressFormPage(driver);
	addressFormPage.getNameField().sendKeys(file.readExcelData("Sheet1", 1, 0));
	addressFormPage.getOfficeInfoField().sendKeys(file.readExcelData("Sheet1", 1, 1));
	addressFormPage.getStreetInfoField().sendKeys(file.readExcelData("Sheet1", 1, 2));
	addressFormPage.getLandmarkField().sendKeys(file.readExcelData("Sheet1", 1, 3));
	
	
	webdriverutil.selectByValue(addressFormPage.getCountryField(),file.readPropertyData("country"));
	webdriverutil.selectByValue(addressFormPage.getStateField(), file.readPropertyData("state"));
	webdriverutil.selectByValue(addressFormPage.getCityField(), file.readPropertyData("city"));
	
	addressFormPage.getPincodeField().sendKeys(file.readExcelData("Sheet1", 1, 4));
	addressFormPage.getPhoneNumberField().sendKeys(file.readExcelData("Sheet1", 1, 5));
	addressFormPage.getAddressBtn().click();
	
	homePage.getaccountButton().click();
	homePage.getLogoutButton().click();
	
	
	}	
}
