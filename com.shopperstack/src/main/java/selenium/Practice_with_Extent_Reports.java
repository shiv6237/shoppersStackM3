package selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Practice_with_Extent_Reports {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./Reports/screenshot.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test=report.createTest("Demo");
		WebDriver driver=new ChromeDriver();
		test.log(Status.INFO, "Browser Launched");
		driver.manage().window().maximize();
		test.log(Status.FAIL, "Browser maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		test.log(Status.PASS, "Navigate to Website");
		Thread.sleep(3000);
		String path = "./screenshots/second.png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileHandler.copy(temp, dest);
		test.addScreenCaptureFromPath("."+path);
		report.flush();
		Thread.sleep(3000);
		driver.quit();
	}
}
