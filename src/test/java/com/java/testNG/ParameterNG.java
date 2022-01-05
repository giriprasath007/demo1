package com.java.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterNG extends WDE{
	@Test
	@Parameters({"email","password"})

	public void dataProvider(String email1,String password) throws InterruptedException
	{

		
		driver.get("http://demo.automationtesting.in/SignIn.html"); //open URL
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
		email.click();
		email.sendKeys(email1);
		
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pass.click();
		pass.sendKeys(password);
		Thread.sleep(5000);
	}
	

}
