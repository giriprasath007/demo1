package framework_test;

import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.security.auth.callback.PasswordCallback;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.java.testNG.DataProvider;

public class Commonpage extends Com_driver{
	
	public By firstname = By.xpath("//input[@placeholder='First Name']");
	public By lastname = By.xpath("//input[@placeholder='Last Name']");
	public By address = By.xpath("//textarea[@ng-model='Adress']");
	public By phone = By.xpath("//input[@ng-model='Phone']");
	public By email = By.xpath("//input[@type='email']");
	public By male = By.xpath("//input[@value='Male']");
	public By female = By.xpath("//input[@value='FeMale']");
	public By year = By.xpath("//select[@ng-model='yearbox']");
	public By month = By.xpath("//select[@ng-model='monthbox']");
	public By date = By.xpath("//select[@ng-model='daybox']");
    public By hobbies = By.xpath("//input[@type='checkbox']");
	public By skills = By.id("Skills");
	public By country = By.xpath("//span[@class='select2-selection select2-selection--single']");
	public By languagelist = By.xpath("//div[@id='msdd']");
	public By password = By.id("firstpassword");
	public By confirmpassword = By.id("secondpassword");
	
	
	
public void firstname(String input) {
clickElement(firstname);
clearElement(firstname);
sendInput(firstname, input);	
	}
	
	
public void lastname(String input) {
clickElement(lastname);
clearElement(lastname);
sendInput(lastname, input);	
			}
public void address(String input) {
clickElement(address);
clearElement(address);
sendInput(address, input);	
			}

public void email(String input) {
clickElement(email);
clearElement(email);
sendInput(email, input);	
			}
public void phone(String input) {
clickElement(phone);
clearElement(phone);
sendInput(phone, input);	
			}

public void gender() {
	WebElement malebutton = driver.findElement(male);
	if(!malebutton.isSelected()) {
	clickElement(male);
	    if (malebutton.isSelected())	{
		System.out.println("Male button is selected");
		clickElement(female);
		    if(!malebutton.isSelected()) {
			System.out.println("Female button is selected");
		}}}}


public void hobbies()
{
	List<WebElement> hobbylist = driver.findElements(hobbies);
	
	for(int i=0;i<=2;i++)
	{
	WebElement element3 = hobbylist.get(i);
	element3.click();
	if(element3.isSelected()) {
	System.out.println(element3.getAttribute("value")+ " checkbox clicked");}
	element3.click();
	if(!element3.isSelected()) {
	System.out.println(element3.getAttribute("value")+ " checkbox cleared");}
	}
}

public void languages() throws InterruptedException {
	
	clickElement(languagelist);
	driver.findElement(By.xpath("//a[text()='Arabic']")).click();
	driver.findElement(By.xpath("//a[text()='English']")).click();
	driver.findElement(By.xpath("//a[text()='Spanish']")).click();	

	Thread.sleep(5000);
	driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-close'])[1]")).click();	
	List<WebElement> selected = driver.findElements(By.xpath("//div[@class='ui-autocomplete-multiselect-item']"));
		Iterator<WebElement> it = selected.iterator();
		while (it.hasNext()){
			WebElement ele = (WebElement) it.next();
			System.out.println("Selected language is "+ele.getText());
		
	}
driver.findElement(By.xpath("//label[text()='Languages']")).click();}

public void skills () {
	WebElement dropdownlist = driver.findElement(skills);
	Select dropdown = new Select(dropdownlist);
	dropdown.selectByVisibleText("Android");
}


public void country () {
	clickElement(country);
	driver.findElement(By.xpath("//li[text()='India']")).click();
}
public void selectdob() {
	selectlist(year, "1993");
	selectlist(month, "July");
	selectlist(date, "7");;}
public void password() {
	sendInput(password, "12345678");
	sendInput(confirmpassword, "12345678");
}
public void submit() {
	clickElement(By.id("submitbtn"));
}
public void catchalert() {
	//Alert alert = driver.switchTo().alert();
	//String catchedphrase = alert.getText();
	WebElement alert = driver.findElement(By.xpath("//a[@href='Alerts.html']"));
	System.out.println("Error alert says : "+alert.getText());
}
}

