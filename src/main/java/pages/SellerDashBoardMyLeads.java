package pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;
import wrapper.GenericWrappers;



public class SellerDashBoardMyLeads extends ExtentManager{
	
	String currentSystemDate;
	String currentDate;
	
	
	
	RemoteWebDriver driver;
	
	
	
	public By myLeadsLinkText=By.linkText("My Leads");
	
	
	public By saleLeadsLinkText=By.xpath("//div[@id='subMenu']/a[2]");
	
	public By enquiryCountLink=By.xpath("//tr[@class='bgclr3']/td/a/following::td/a");
	
	public By listingIdInDropDownList=By.id("listingid");
	
	public By calenderStartDate=By.xpath("//input[@id='startdate4']/following::img[@class='ui-datepicker-trigger']");
	
	
	public By calenderCurrentDate=By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a");
	
	
	public By calenderFollowingDate=By.xpath("//input[@id='enddate4']/following::img[@class='ui-datepicker-trigger']");
	
	
	//driver.findElementByXPath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a").click();
	
	public By calenderEndDate=By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a");
	
	public By submitBtn=By.className("blueBtn1");
	
	
	public By enqDateinTable=By.xpath("//tr[@class='bgclr3']/td[2]");
	
//String enqDateinTable=driver.findElementByXPath("//tr[@class='bgclr3']/td[2]").getText().trim();
	
	//System.out.println(enqDateinTable);
	
	
	public By enqNameinTable=By.xpath("//tr[@class='bgclr3']/td[3]");
	//String enqNameinTable=driver.findElementByXPath("//tr[@class='bgclr3']/td[3]").getText().trim();
	//System.out.println(enqNameinTable);
	
	
	public By enqEmailinTable=By.xpath("//tr[@class='bgclr3']/td[4]");
	//String enqEmailinTable=driver.findElementByXPath("//tr[@class='bgclr3']/td[4]").getText().trim();
	//System.out.println(enqEmailinTable);
	
	
	public By enqMobileinTable=By.xpath("//tr[@class='bgclr3']/td[5]");
	//String enqMobileinTable=driver.findElementByXPath("//tr[@class='bgclr3']/td[5]").getText().trim();
	//System.out.println(enqMobileinTable);
	
	
	
	
	
	
	// driver.findElementByClassName("blueBtn1").click();
	
	//driver.findElementByXPath("//input[@id='enddate4']/following::img[@class='ui-datepicker-trigger']").click();
	
	
	
	//driver.findElementByXPath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a").click();
			
			//driver.findElementByXPath("//input[@id='startdate4']/following::img[@class='ui-datepicker-trigger']").click();
	
	
	public SellerDashBoardMyLeads(RemoteWebDriver driver) throws IOException{
		test=extent.startTest("Navigation Of My Properties Page");
		this.driver=driver;
		
		String MyPropertiesPageTitle="My Properties - Properties & Real Estate in India - India Property Portal";
		
		String expectedTitle=driver.getTitle();
		
		System.out.println(expectedTitle);
		
		if(MyPropertiesPageTitle.equalsIgnoreCase(expectedTitle)){
			
			System.out.println("User  Sucessfully Land to the My Properties Page");
			
			test.log(LogStatus.PASS, "Check whether user navigated My Properties Page", "User sucessfully land to My PropertiesPage");
	        
		       
	         screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
			
			
			}
			
			else{
				
				
				System.out.println("User unbale to  Land to the My Lead Page");
				
				
				test.log(LogStatus.FAIL, "Check whether user navigated My Properties Page", "User unable land to My Properties Page");
		        
			       
		         screenShotPath=ExtentManager.capture(driver, "Fail");
				
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
							
				
			}
		
		
		
	}
	
	
	public SellerDashBoardMyLeads pageScrollup(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,-250)", "");
		return this;
	
	}
	
	public SellerDashBoardMyLeads saleLeads() throws InterruptedException, IOException{
		test=extent.startTest("Navigation Of My Leads Page");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.findElement(myLeadsLinkText).click();
		
		Thread.sleep(3000);
		
String MyLeadsPageTitle="My Leads - Properties & Real Estate in India - India Property Portal";
		
		String expectedTitle=driver.getTitle();
		
		System.out.println(expectedTitle);
		
		if(MyLeadsPageTitle.equalsIgnoreCase(expectedTitle)){
			
			System.out.println("User  Sucessfully Land to the My Lead Page");
			
			test.log(LogStatus.PASS, "Check whether user navigated My Leads Page", "User sucessfully land to My Leads Page");
	        
		       
	         screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
				
			
			
			}
			
			else{
				
				
				System.out.println("User unable to  Land to the My Lead Page");
				
				
				
				test.log(LogStatus.FAIL, "Check whether user navigated My Leads Page", "User unable to land to My Leads Page");
		        
			       
		         screenShotPath=ExtentManager.capture(driver, "Fail");
				
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
							
				
			}
		
		
		
	WebDriverWait waitElement=new WebDriverWait(driver,120);
	//Thread.sleep(5000);
	waitElement.until(ExpectedConditions.elementToBeClickable(saleLeadsLinkText));
	Thread.sleep(3000);
	driver.findElement(saleLeadsLinkText).click();
	Thread.sleep(3000);
	
	
		
	Select listingiddropdown= new Select(driver.findElement(listingIdInDropDownList));
	
	
	
	Thread.sleep(3000);
		
	if(SearchPage.listingid1 != null){
	
	listingiddropdown.selectByValue(SearchPage.listingid1);
	Thread.sleep(5000);
	}
	
	
	else if(SearchPage.melchilistingid1 != null){
		
		listingiddropdown.selectByValue(SearchPage.melchilistingid1);
		Thread.sleep(4000);
		}	
		
		
	js.executeScript("window.scrollBy(0,400)", "");
	
	driver.findElement(enquiryCountLink).click();
	
	
	Thread.sleep(4000);
	
	js.executeScript("window.scrollBy(0,400)", "");
	return this;
	
	
	}
	
	public SellerDashBoardMyLeads currentDate(){
		
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");

	Date date = new Date();

	// Now format the date
	currentSystemDate = dateFormat.format(dateFormat);
	currentDate = currentSystemDate.trim();
	// Print the current Date
		
	System.out.println(currentDate);
		
	return this;
	
	
	}
	
	public SellerDashBoardMyLeads enqValidationinDashboardTable(String buyerEmail,String buyerMobile) throws InterruptedException, IOException{
		
		test=extent.startTest("Validation  Of Posted Lead");
		
		WebDriverWait wait=new WebDriverWait(driver,120);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(calenderStartDate));
		
		driver.findElement(calenderStartDate).click();
	
	
	 Thread.sleep(5000);
	    		    		
	 wait.until(ExpectedConditions.visibilityOfElementLocated(calenderCurrentDate));
	 driver.findElement(calenderCurrentDate).click();
	 
	
	 
	
	 Thread.sleep(5000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(calenderFollowingDate));
	 driver.findElement(calenderFollowingDate).click();
	 
	 Thread.sleep(5000);
	 
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(calenderEndDate));
	 driver.findElement(calenderEndDate).click();
	 Thread.sleep(2000);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
	 driver.findElement(submitBtn).click();
	
	 
	
	 
	
	 
	 Thread.sleep(2000);
	
	 WebDriverWait waiting=new WebDriverWait(driver,120);
	 
	 waiting.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(enqDateinTable));
	 
	 String enqDateTextinTable=driver.findElement(enqDateinTable).getText().trim();
	
	//String enqDateinTable=driver.findElementByXPath("//tr[@class='bgclr3']/td[2]").getText().trim();
	
	System.out.println(enqDateTextinTable);
	
	waiting.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(enqNameinTable));
	
	String enqNameTextinTable=driver.findElement(enqNameinTable).getText().trim();
	System.out.println(enqNameTextinTable);
	
	waiting.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(enqEmailinTable));
	
	String enqEmailTextinTable=driver.findElement(enqEmailinTable).getText().trim();
	System.out.println(enqEmailTextinTable);
	
	
	waiting.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(enqMobileinTable));
	String enqMobileTextinTable=driver.findElement(enqMobileinTable).getText().trim();
	System.out.println(enqMobileTextinTable);
	


	
	if(currentDate.equalsIgnoreCase(enqDateTextinTable)&&(enqEmailTextinTable.equalsIgnoreCase(buyerEmail)&&(enqMobileTextinTable.equalsIgnoreCase("(+91)"+"-"+buyerMobile)))){
		
		System.out.println("Lead has Captured in My Leads Page");
						
		System.out.println("Posted Enquiry is Captured in My Leads Page");
		
		test.log(LogStatus.PASS, "Check whether posted Enquiry Captured in My Leads Page", "Posted Enquiry is Captured in My Leads Page");
        
	       
        screenShotPath=ExtentManager.capturefull(driver, "Pass");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
		
		test.log(LogStatus.INFO, "Enquired Listing Id"+"  " + SearchPage.listingid1);
		
		test.log(LogStatus.INFO, "Enquired Date" +"  " +  enqDateTextinTable);
		
		test.log(LogStatus.INFO, "Enquired EmailId" + "  " + buyerEmail);
		
		test.log(LogStatus.INFO, "Mobile Number " + "  " + "(+91)"+"-"+buyerMobile);
		
		
		driver.quit();
		
		
	}
	
	else{
		
		
		System.out.println("Posted Enquiry is not Captured in My Leads Page");
		
		
		test.log(LogStatus.FAIL, "Check whether posted Enquiry Captured in My Leads Page", "Posted Enquiry is not Captured in My Leads Page");
        
	       
        screenShotPath=ExtentManager.capturefull(driver, "Fail");
		
		test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
		
		
		//driver.quit();
	}
	return this;
	
	
	}
	
	
	public SellerDashBoardMyLeads closeAllBrowser(){
		
		
		driver.quit();
		
		
		return this;
		
		
		
	}
}
	
		

     


/**
 * WebDriver driver = new FirefoxDriver();
driver.get("http://somedomain/url_that_delays_loading");
WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
 
 * 
 */
