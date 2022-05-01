package JenkinsMaven.Project01;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandles {
  @Parameters("BrowserInput")
  @Test
  public void TestCase01(String browserName)
  {
	  WebDriver driver=null;
	  if(browserName.contains("Chrome"))
	  {
		  WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
		  driver = new ChromeDriver();
	  }
	  else if(browserName.contains("Edge"))
	  {
		  WebDriverManager.edgedriver().driverVersion("101.0.1210.32").setup();
		  driver = new EdgeDriver();
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

  }
  
  
}
