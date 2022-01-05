package test_utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static void main(String[] args) {
	
	ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("extentreport.html");
	ExtentReports report = new ExtentReports();
	report.attachReporter(htmlreporter);
	
	ExtentTest test = report.createTest("Testing for test");
	test.log(Status.PASS, "Testcase passed");
	test.log(Status.FAIL, "Testcase failed");
	test.log(Status.INFO, "Testcase information");
	
	report.flush();
	}
}
