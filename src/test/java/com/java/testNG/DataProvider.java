
package com.java.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DataProvider extends WDE{

	
	@Test(dataProvider="getdata")
	public void dataProvider(String email1,String password)
	{

		
		driver.get("http://demo.automationtesting.in/SignIn.html"); //open URL
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
		email.click();
		email.sendKeys(email1);
		
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pass.click();
		pass.sendKeys(password);
	}
	
	
	@org.testng.annotations.DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "email1";
		data[0][1] = "pass1";
		
		data[1][0] = "email2";
		data[1][1] = "pass2";
		
		data[2][0]="email3";
		data[2][1]="pass3";
		
		return data;
	}
	
}