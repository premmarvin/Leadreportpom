package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProjectWrapper extends Capturescreeshots{

	public static ExtentReports extent;

	public static ExtentTest test;
	public static RemoteWebDriver driver;
	
	@BeforeClass

	//@BeforeTest

	public static ExtentReports startTest() {
		
		
		//String reportvalue = new SimpleDateFormat("yyyy-MM-dd hh").format(new Date());
		
		String reportvalue = new SimpleDateFormat("yyyyMMddHH").format(new Date());
		   
        System.out.println(reportvalue);

		extent = new ExtentReports( "./../"+reportvalue+"/index.html", true);

		extent.addSystemInfo("User Name", "MPrem").addSystemInfo("Host Name", "IndiaProperty")
				.addSystemInfo("Type Of Testing", "Sanity").addSystemInfo("Environment", "Production Site")
				.addSystemInfo("Author", "MPrem -QA");

		extent.loadConfig(
				new File(System.getProperty("user.dir") + "/src/main/java/supportFile/extent-config2.xml"));
		return extent;
		
		

	}

	@AfterMethod

	public void getResult() throws IOException {
		

	/*
	if (result2.getStatus() == ITestResult.FAILURE) {
		
		test.log(LogStatus.FAIL, "Testcase  Fail" + "  " + result2.getName());
		test.log(LogStatus.FAIL, "Testcase Fail" + "  " + result2.getThrowable());
	
	
		}

		else if (result2.getStatus() == ITestResult.SKIP) {
			
			
			
			
			test.log(LogStatus.FAIL, "Testcase Fail" + "  " + result2.getName());
			test.log(LogStatus.FAIL, "Testcase Fail" + "  " + result2.getThrowable());

		}

		*/
		
		
		

		extent.endTest(test);
		
}
		

	@AfterTest

	public void endReport() {
		// extent.endTest(test);
		// extent.endTest(test);
		
		
		extent.flush();
		// extent.endTest(test);
		// extent.close();
	}

}
