package com.java.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class WDE {
	public WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
	
		
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse_Workspace\\Sel\\exe\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
	
	}
}
