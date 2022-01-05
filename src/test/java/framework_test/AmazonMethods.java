package framework_test;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class AmazonMethods extends Com_driver{
	
	public By signinbtn = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	public By userid = By.id("ap_email");
	public By useridsubmit = By.id("continue");
	public By password = By.id("ap_password");
	public By passwordsubmit = By.id("signInSubmit");
	public By cart = By.xpath("//span[@class='nav-cart-icon nav-sprite']");
	public String cartcount = "//span[@id='sc-subtotal-label-activecart']";
	public By deletebtns = By.xpath("//*[contains(@data-sc-item-action, 'active') and contains(@data-sc-item-action, 'delete')]");
	public By searchbox = By.id("twotabsearchtextbox");
	public By searchbtn = By.id("nav-search-submit-button");
	public String searchitem = "Samsung S21 ultra";
	public By firstitem = By.xpath("(//span[@class = 'a-size-medium a-color-base a-text-normal'])[2]");
	public By MRP = By.xpath("//span[@class = 'priceBlockStrikePriceString a-text-strike']");
	public By price = By.xpath("//span[@id='priceblock_ourprice']");
	public By productname = By.xpath("//span[@id='productTitle']");
	public By addtocartbtn = By.xpath("//input[@id='add-to-cart-button']");
	public By proceedcheckout = By.id("#hlb-ptc-btn-native");
	public By cart2 = By.xpath("//a[@href='/gp/cart/view.html/ref=lh_cart']");
	public By productnameincart = By.xpath("//span[@class='a-truncate-cut']");
	public String spaces = "**************************************************************************";
	public String emptycart = "Your Amazon Cart is empty.";
	
	public void launch() {
		driver.get("https://www.amazon.in");}
	
	
    public void signin() {
    	
	clickElement(signinbtn);
	
	
	System.out.println("Input your username: ");
	Scanner scan1 = new Scanner(System.in);
	String input1 = scan1.nextLine();
	sendInput(userid, input1);
	clickElement(useridsubmit);
	
	System.out.println("Input your password: ");
	Scanner scan2 = new Scanner(System.in);
	String input2 = scan1.nextLine();
	sendInput(password, input2);
	clickElement(passwordsubmit);
}	
    
public void chkNclrcart() {
	clickElement(cart);
	try {
	WebElement emptycart = driver.findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']"));
	
		System.out.println(emptycart.getText());
	}
	catch(NoSuchElementException e) {
		
		java.util.List<WebElement> cartitems = driver.findElements(deletebtns);
		int d = cartitems.size();
		System.out.println("Cart contains "+d+" items and all items will be cleared");
		for(int i = 0;i<d;i++) {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(presenceOfElementLocated((driver.findElements(deletebtns).get(0)))); 
			//wait1.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath(deletebtns)).get(0)));
			driver.findElements(deletebtns).get(0).click();
            clickElement(cart);		    
		
		}
		if((driver.findElement(By.xpath("//h1[contains(text(),'Your Amazon Cart is empty.')]")).getText().equalsIgnoreCase(emptycart))) {}
		
		System.out.println("All items in the cart are cleared");
		
	}
}
public void searchNbuy() {
	sendInput(searchbox, searchitem);
	clickElement(searchbtn);
	
	
	String titleresp = "Amazon.in : "+searchitem;
	if(driver.getTitle().equals(titleresp)) {
		System.out.println("Page loaded with correct search results");}
	clickElement(firstitem);
	
	String Parent = driver.getWindowHandle();
	Set<String> set = driver.getWindowHandles();
	ArrayList<String> childw = new ArrayList(set);
	driver.switchTo().window(childw.get(1));
	System.out.println(spaces);
	driver.navigate().refresh();
	System.out.println("Product name is "+elementtxt(productname));
	String Producttitle = elementtxt(productname);
	System.out.println(spaces);
	System.out.println("Product MRP is INR "+elementtxt(MRP));
	System.out.println(spaces);
	System.out.println("Product sale price is INR "+elementtxt(price));
	System.out.println(spaces);
	scroll();
	clickElement(addtocartbtn);
	clickElement(cart2);
	
	
	WebDriverWait wait = new WebDriverWait(driver, 20); 
	wait.until(ExpectedConditions.presenceOfElementLocated(productnameincart));
	System.out.println(spaces);
	System.out.println("Product name at cart is "+elementtxt(productnameincart));
	System.out.println(spaces);
	if(Producttitle.equals(elementtxt(productnameincart))){
		System.out.println("Product name in cart is same as the product added from search page");
		System.out.println(spaces);
	}
	
	}
	
}



	



