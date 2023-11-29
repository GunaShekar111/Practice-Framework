package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;
import utilities.readXLSData;

public class FirstTest extends BaseTest{
	
	@Test(dataProviderClass = readXLSData.class,dataProvider = "TestData")
	public static void Login(String UserName , String passWord) throws InterruptedException {
		
		driver.findElement(By.linkText(Locators.getProperty("signin_link"))).click();
		System.out.println("Clicked on signin successfully");
		driver.findElement(By.id(Locators.getProperty("UserName_id"))).sendKeys(UserName);
		driver.findElement(By.id(Locators.getProperty("NextButton_id"))).click();
		Thread.sleep(3000);
		driver.findElement(By.id(Locators.getProperty("PassWord_id"))).sendKeys(passWord);
		System.out.println("entered the Username");
		driver.findElement(By.id(Locators.getProperty("NextButton_id"))).click();
		System.out.println("entered Password and cliked on signin");
		Thread.sleep(4000);
	}
	
}


