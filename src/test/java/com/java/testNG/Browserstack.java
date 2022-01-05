package com.java.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Browserstack {
  public static final String AUTOMATE_USERNAME = "giriprasath_1xghj5";
  public static final String AUTOMATE_ACCESS_KEY = "ZCy8cMUraHEQaHmRzU6i";
  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
  
  @Test
  @Parameters({"os_version","browser","browser_version"})
  public void browsertest(String osVersion, String browser,String browserVersion) throws MalformedURLException  {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("os_version", osVersion);
    caps.setCapability("resolution", "1920x1080");
    caps.setCapability("browser", browser);
    caps.setCapability("browser_version", browserVersion);
    caps.setCapability("os", "Windows");
    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
driver.manage().window().maximize();
driver.get("http://demo.automationtesting.in/Frames.html");
driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
WebElement parentframe1 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
driver.switchTo().frame(parentframe1);
WebElement childframe1 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
driver.switchTo().frame(childframe1);
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("check");
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//a[@href='#Single']")).click();
driver.quit();}}
