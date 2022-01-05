package framework_test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Maintest extends Com_driver {
	Commonpage comm = new Commonpage();
	@Test
	//@Parameters("hobby1")
	public void register () throws InterruptedException, IOException{
		
		test=report.createTest("signup");
		comm.firstname(getdata("firstname"));//Here getdata() function fetches data from Excel file using ExcelRead.java
		comm.lastname(getdata("lastname"));
		comm.address(getdata("address"));
		comm.email(getdata("email"));
		comm.phone(getdata("phone"));
		comm.gender();
		comm.hobbies();
		scroll();
		comm.languages();
		comm.skills();
		comm.country();
		comm.selectdob();
		comm.password();
		comm.submit();
		//comm.catchalert();
		
		
	}
}
