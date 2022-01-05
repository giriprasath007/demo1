package framework_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;

import test_utilities.ExcelRead;

public class Com_driver {
	public WebElement element1;
	public static WebDriver driver;
	public HashMap<String, String> map=new HashMap<String, String>();
	public DataFormatter format= new DataFormatter();
	public static ExcelRead read = new ExcelRead();
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports report;
	public static ExtentTest test;
	public String browser;
	public String url;

	
	@BeforeMethod
	public void launchbrowser() throws IOException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_Workspace\\Sel\\exe\\chromedriver.exe");	
			driver= new ChromeDriver();
			driver.manage().window().maximize(); 
			 driver.get(url);
		}
		
	
		else if(browser.equalsIgnoreCase("firefox")) {
			    System.setProperty("webdriver.gecko.driver", "D:\\Eclipse_Workspace\\Sel\\exe\\geckodriver.exe");
		        driver = new FirefoxDriver();
		        driver.manage().window().maximize();
		        driver.get(url);
		        
		}
       
       
	}	
@BeforeTest
	public void loadprop() throws IOException {
		htmlreporter = new ExtentHtmlReporter("newtestreport.html");
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		
		File f = new File("D:\\Eclipse_Workspace\\Mavencheck\\src\\test\\java\\com\\config\\config.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		browser = prop.getProperty("browser");
		url = prop.getProperty("URL");
		
	}
	
	public void clickElement(By locator) {
		driver.findElement(locator).click();
	}
	
	public void clearElement(By locator) {
		driver.findElement(locator).clear();}
		
	public void sendInput(By locator, String Value) {
			driver.findElement(locator).sendKeys(Value);
			
		}
	public void selectlist(By locator, String Value) {
		
		WebElement dropdown = driver.findElement(locator);
		Select selector = new Select(dropdown);
		selector.selectByValue(Value);
		
	
		}
	@SuppressWarnings("deprecation")
	public void wait5sec() {
		
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public String elementtxt(By locator) {
		
		return driver.findElement(locator).getText();
	}
	
	public void scroll() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	public  WebElement findElement(By locator) {
		WebElement element1 = driver.findElement(locator);

			
	
		return element1;
	}
	
	public String getdata(String key) throws IOException {
		
		return read.getmapvalue(key);
		
		
	}
	
	
	protected static Function<WebDriver,WebElement> presenceOfElementLocated(final WebElement elementZ) {
        return new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return elementZ;
            }
        };
    }
	protected static Function<WebDriver,java.util.List<WebElement>> presenceOfElementsLocated(final By locator) {
        return new Function<WebDriver, java.util.List<WebElement>>() {
            public java.util.List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        
    };
	
}
	@AfterMethod
public void endreport() {
		report.flush();
		//driver.close();
	
	
}	
}
		
	

