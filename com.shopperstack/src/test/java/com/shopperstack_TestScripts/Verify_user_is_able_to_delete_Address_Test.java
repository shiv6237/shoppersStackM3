package com.shopperstack_TestScripts;

import org.testng.annotations.Test;

import com.shopperStack.pm.MyAddressPage;
import com.shopperStack.pm.MyProfilePage;
import com.shopperstackGenericUtility.BaseTest;

public class Verify_user_is_able_to_delete_Address_Test extends BaseTest {
	
	
	@Test
	public void deleteAddress() throws InterruptedException  {
		
		homePage.getaccountButton().click();
		homePage.getMyProfileButton().click();
		
		MyProfilePage myprofilepage=new MyProfilePage(driver);
		myprofilepage.getAddressBtn().click();
		
		MyAddressPage myaddressPage=new MyAddressPage(driver);
		Thread.sleep(3000);
		myaddressPage.getGetDeleteBtn().click();
		Thread.sleep(3000);
		myaddressPage.getGetYesbtn().click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		homePage.getaccountButton().click();
		homePage.getLogoutButton().click();
	}
}
