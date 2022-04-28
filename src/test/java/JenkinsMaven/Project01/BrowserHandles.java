package JenkinsMaven.Project01;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandles {
   
  @Test
  public void TestCase01()
  {
	  WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
	  WebDriver driver = new ChromeDriver();
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
