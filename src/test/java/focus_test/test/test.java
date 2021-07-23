package focus_test.test;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class test {
	WebDriver driver;
	
  @Test
  public void focus() throws InterruptedException {
	  	driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Focus Services");
	  	Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/center[1]/input[1]")).click();
		Thread.sleep(1000);
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		softAssert.assertEquals(true, driver.findElement(By.partialLinkText("https://www.focusservices.com")).isDisplayed());
		driver.findElement(By.partialLinkText("https://www.focusservices.com")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Now Hiring!")) );
		Thread.sleep(1000);
		softAssert.assertEquals(true, driver.findElement(By.linkText("Now Hiring!")).isDisplayed());
		driver.findElement(By.xpath("//span[contains(text(),'Locations')]")).click();
		Thread.sleep(2000);
		softAssert.assertEquals(true, driver.findElement(By.xpath("//span[contains(text(),'North America')]")).isDisplayed());
		driver.findElement(By.xpath("//span[contains(text(),'Central America')]")).click();
		Thread.sleep(2000);
		softAssert.assertEquals(true, driver.findElement(By.xpath("//h2[contains(text(),'El Salvador & Nicaragua')]")).isDisplayed());
		driver.findElement(By.xpath("//span[contains(text(),'Asia')]")).click();
		Thread.sleep(2000);
		softAssert.assertEquals(true, driver.findElement(By.xpath("//b[contains(text(),'Bacolod City, Philippines')]")).isDisplayed());
		softAssert.assertAll();
  }
  @BeforeClass
  public void beforeClass() {
	  	System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
