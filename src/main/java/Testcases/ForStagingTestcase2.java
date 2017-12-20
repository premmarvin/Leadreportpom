package Testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.IPAdminPageLogin;
import pages.OnBoardingPage;
import pages.OnboardingCustomerLeadsPage;
import pages.SearchPage;
import pages.SellerDashBoardMyLeads;
import pages.SellerDashboard;
import pages.VDPPage;
import supportFile.ExtentManager;
import utils.DataInputProviderPage1;
import utils.ForStagingDataInputProviderPage;
import utils.ProjectWrapper;



public class ForStagingTestcase2 extends DataInputProviderPage1 {

	public static RemoteWebDriver driver;
	
	public static ExtentReports extent;

	public static  ExtentTest test;
	
	/*
	@BeforeSuite
	
	public void reporter(){
		
		extent=ExtentManager1.Instance();
		
	}
	
	
	@AfterSuite
	public void afterSuite(){
		
		extent.flush();
		extent.close();
	}*/
	
	@BeforeMethod
	 	  public void beforeMethod() {
		
		/*FirefoxOptions options=new FirefoxOptions();
		
		options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		  
		capabilities.setCapability("moz:firefoxOptions", options);*/
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		  
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		//System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");       
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//driver=new FirefoxDriver(capabilities);
	       driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	  
	        WebDriverWait wait = (new WebDriverWait(driver, 60));
	        
	        extent = ExtentManager.Instance();
	       	
	}
	
	
	
	
	
	
	@Test(priority=1,dataProvider="getData",dataProviderClass=ForStagingDataInputProviderPage.class)
	public static void init(String cityName,String buyerName,String buyerEmail,String buyerMobile,String onboardingUserlogin,String onboardingUserPwd) throws InterruptedException, IOException{
			
	
		new HomePage(driver,test)
					
		 .getHomeIPUrl("https://www.indiaproperty.com/")
		//.closeStrip()
		//.selectCityClick()
		
		.clickCityTextboxValue(cityName)
		
			
		
		.searchBtnClick(cityName)
		.delay5000();
				
				
		//new SearchPage(driver,cityName);
		new SearchPage(driver)
	   .listingInfo()
	
	   
	   
		.randomListing()
					
		.SWITCHING();
		
		new VDPPage(driver)
		.pageScroll()
		.submitEnquiryForm(buyerName,buyerEmail,buyerMobile)
		.verifypopup();
		
		/*
		
		new OnBoardingPage(driver)
	.onboardingLanding("window.open('http://onboarding.indiaproperty.com/','_blank');", 1)
	.onboardingLogin(onboardingUserlogin, onboardingUserPwd)
	
	.customerLeadPage("window.open(' http://onboarding.indiaproperty.com/customervalidation/1675845','_blank');", 2);
		
		new OnboardingCustomerLeadsPage(driver)
		
		
		.sysDate()
		.enqDetailsInFreshTable()
		.enqDetailsInDuplicateTable()
		.listingStatusFresh()
		.listingStatusDuplicate()
		.onbTableCombined()
		.onbTableStatusCombined()
	    .onbTableDate()
		.onbTableDateDuplicate()
				
		.onbTableDateCombined()
		
		.leadValidation();
		
		
		new IPAdminPageLogin(driver)
		
		.openNewTabForAdminPage("window.open('http://premkumar.m@indiaproperty.com:Elshaddaikr22@www.indiaproperty.com/admin/login_page.php','_blank');", 3)
		.IPADminLogin(onboardingUserlogin,onboardingUserPwd)
		.verifyloggedAdmin()
		.autoLogin();
		
		new SellerDashboard(driver)
		.pageScrollDown()
		
		.LeadValidationInDashboard(buyerName,buyerMobile);
		new SellerDashBoardMyLeads(driver)
		. pageScrollup()
		.saleLeads()
		
		
		
		.currentDate()
		.enqValidationinDashboardTable(buyerEmail,buyerMobile)
		
		 				
		
		.closeAllBrowser();
		
		
		*/
		
		new SellerDashBoardMyLeads(driver)
		.closeAllBrowser();
	}
		/*@Test(priority=2)
		public static void searchListing() throws InterruptedException{
			
			new SearchPage(driver,cityName)
			.listingInfo()
			.randomListing()
			
			.closeAllBrowser();
		}*/
		
		
		
		
		//new SearchPage(driver,"Alangudi");
		//.verifyTitle("Alangudi");
		
		//.selectCityName();
		

	
		
	/*@AfterTest
	public static void closeBrowsersss(){
		
		driver.quit();
		
		
	}
	*/
	   
	   
	
}
