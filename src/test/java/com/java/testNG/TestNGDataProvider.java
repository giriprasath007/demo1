package com.java.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	
	

	@Test(dataProvider="datafetch")
	public void amazon(String email1,String password) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse_Workspace\\Sel\\exe\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fyour-account%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
		email.click();
		email.sendKeys(email1);
		WebElement emailclick = driver.findElement(By.xpath("//input[@id='continue']"));
		emailclick.click();
		Thread.sleep(5000);
		WebElement password1 = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password1.click();
		password1.sendKeys(password);
		WebElement passwordclick = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		passwordclick.click();
		Thread.sleep(5000);
		
}
	@org.testng.annotations.DataProvider
public Object [][] datafetch(){
		
		Object datum [][] = new Object [2][2];
			datum[0][0] = "giriprasath.07@gmail.com"	;
			datum[0][1] = "check"	;
			datum[1][0] = "giriprasath.07@gmail.com";
			datum[1][1] = "j"	;

		return datum;
		
	}}
