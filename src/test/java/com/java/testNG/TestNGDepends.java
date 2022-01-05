package com.java.testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNGDepends {
	
	@Test(dependsOnMethods = ("Screenshot"))
	public void drag1() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse_Workspace\\Sel\\exe\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Actions act = new Actions(driver);
		WebElement n5k= driver.findElement(By.xpath("//a[text()=' SALES ']"));
		WebElement dest=driver.findElement(By.id("loan"));
		//act.moveToElement(n5k);

		act.dragAndDrop(n5k,dest).build().perform();
	}
	@Test
	public static void Screenshot() throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "D:\\Eclipse_Workspace\\Sel\\exe\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Fram.html");//wrong url
		TakesScreenshot SS= (TakesScreenshot)driver;
		File src = SS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Eclipse_Workspace\\Sel\\screenshots\\ss1.png"));
		WebElement logo = driver.findElement(By.xpath("//img[@src='original.png']"));
		File imglogo = logo.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imglogo, new File ("D:\\Eclipse_Workspace\\Sel\\screenshots\\sslogo.png"));
	}
	
}
