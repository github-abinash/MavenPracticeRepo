package JenkinsMaven.Project01;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandles 
{
	ExtentReports extent;
	
	@BeforeTest
	public void Reports()
	{
		String reportLocation = System.getProperty("user.dir")+"\\reports";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportLocation);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	
  @Parameters("BrowserInput")
  @Test
  public void TestCase01(String browserName)
  { 
	  ExtentTest logger = extent.createTest("TestCase01");
	  WebDriver driver=null;
	  if(browserName.contains("Chrome"))
	  {
		  WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
		  driver = new ChromeDriver();
		  logger.log(Status.INFO, "Chrome Browser Opened");
	  }
	  else if(browserName.contains("Edge"))
	  {
		  WebDriverManager.edgedriver().driverVersion("101.0.1210.32").setup();
		  driver = new EdgeDriver();
		  logger.log(Status.INFO, "Edge Browser Opened");
	  }
	  
	  
	  driver.get("https://www.google.co.in/");
	  driver.manage().window().maximize();
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertTrue("Title is not matching", title.contains("Google"));
	  
	  driver.close();
	  System.out.println("Browser closed successfully");
	  driver.quit();
	  System.out.println("Browser Session closed successfully");
	  
	  System.out.println("Edited from GitHub - 2nd attempt");

  }
  
  
}
