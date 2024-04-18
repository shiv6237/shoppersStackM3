
package com.shopperstackGenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
	
public class WebdriverUtility implements Frameworkconstant {
	Select sel;
	File temp;
	File dest;
	JavaUtility javautil = new JavaUtility();
	
	public void screenshotWebpage(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		temp=ts.getScreenshotAs(OutputType.FILE);
		dest=new File(screenshotPath + javautil.localdateTime() + ".png");
		FileHandler.copy(temp, dest);
	}
	
	public void screenshotWebelement(WebElement element) throws IOException {
		temp=element.getScreenshotAs(OutputType.FILE);
		dest=new File(screenshotPath + javautil.localdateTime() + ".png");
		FileHandler.copy(temp, dest);
	}
	
	public void selectname(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectByValue(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectBytext(WebElement element,String text) {
		sel=new Select(element);
		sel.selectByValue(text);
	}
	
	public void selectByIndex(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void deselectByValue(WebElement element,String value) {
		sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void deselectBytext(WebElement element,String text) {
		sel=new Select(element);
		sel.selectByValue(text);
	}
	
	public void deselectAll(WebElement element) {
		sel=new Select(element);
		sel.deselectAll();
	}
}
