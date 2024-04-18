package com.shopperstackGenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shopperStack.pm.HomePage;
import com.shopperStack.pm.LoginPage;
import com.shopperStack.pm.WelcomePage;

public class BaseTest {
	
	public WebDriver driver;
	
	public static WebDriver listenersDriver;
	public FileUtility file=new FileUtility();
	public WebdriverUtility webdriverutil=new WebdriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public JavaUtility java=new JavaUtility();
	public HomePage homePage;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
		spark=new ExtentSparkReporter("./Reports/"+java.localdateTime()+".html");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
		
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		String url=file.readPropertyData("url");
	
		String browser = file.readPropertyData("browser");
		reports=new ExtentReports();
		reports.attachReporter(spark);
		test=reports.createTest("Demo");
		
		System.out.println("BeforeClass");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Please Enter a valid Browser name");
		}
		listenersDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		homePage=new HomePage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("BeforeMethod");
		
		test.log(Status.INFO, "Navigated");
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.getLoginButton().click();
		
		test.log(Status.INFO, "In LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(file.readPropertyData("username"));
		loginPage.getPasswordField().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginButton().click();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		
		
		homePage.getaccountButton().click();
		homePage.getLogoutButton().click();
		test.log(Status.INFO, "Logout Successfully");
		
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("AfterClass");
		Thread.sleep(3000);
		driver.quit();
		reports.flush();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
}
