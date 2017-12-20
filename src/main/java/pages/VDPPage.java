package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;
import wrapper.GenericWrappers;



public class VDPPage extends ExtentManager {
	
		
	RemoteWebDriver driver;
	
	 	
	public By enquirerName=By.id("strname");
	
	public By enquirerEmail=By.id("stremail");
	
	public By enquirerMobile=By.id("mobileno");
	
	public By submitEnqForm=By.id("agent-enquiry-submit");
	
	
	public By vdpMap=By.xpath("//div[@class='lightV-top-blue-box pointer']/a/img");
	
	
	public By viewMapimg=By.xpath("//div[@class='lightV-top-blue-box pointer']");
	
	public By ClickcontactBtn=By.xpath("//li[@class='font-0']/span");
	
	public By submitEnqFormAgentOrIndivType=By.id("enquiry-submit");
	
	public By enqThankYouPopup=By.xpath("//h2[text()='Thank you, for Showing Interest in this Property.']");
	
	public By enqAlreadyRequestedPopup=By.xpath("//p[text()='You Have Already Requested / Enquired About This Property']");
	
	
	public By enqMaximumReachedPopup=By.xpath("//div[text()='We are unable to accept your Enquiry.']");
	
	public By thankYouPopup=By.xpath("//div[@class='popup-main']/div/div/button/following::h2[text()='Thank you for your interest in this property']");
	
	
	public By siteVisitpopup=By.xpath("//div[@class='popup-main']/div/div/button/following::h2[text()='Thank you for your interest in this property.']");
	
	
	
	
	public VDPPage(RemoteWebDriver driver) throws IOException, InterruptedException{
		
		//test=extent.startTest("Randomly Navigate to VDP Page");
		try {
			this.driver=driver;
			
			String currentVDPUrl=driver.getCurrentUrl();
			
			Thread.sleep(5000);
			

			if(driver.findElements(By.xpath("//button[@id='propclose']/span")).size() != 0){
				System.out.println("Property Alert Form is Displayed");
				
				Thread.sleep(10000);
				driver.findElement(By.xpath("//button[@id='propclose']/span")).click();

				}else{
				System.out.println("Property Alert Form is not Displayed");
				}
			
			if(SearchPage.listingid1 != null){
			
			if(currentVDPUrl.contains(SearchPage.listingid1)){
				
				System.out.println("User Sucessfully Land to VDP Page through existing search Page");
				
				
							
			}
			}
			else if(SearchPage.melchilistingid1 != null){
				
				if(currentVDPUrl.contains(SearchPage.melchilistingid1))
					
					System.out.println("User Sucessfully Land to VDP Page through melchi search Page");	
			}
			
			else{
				
				System.out.println("User unable to  Land to VDP Page");
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	



public VDPPage submitEnquiryForm(String buyerName,String buyerEmail,String buyerMobile) throws InterruptedException, IOException{

	   Thread.sleep(5000);
	   
	 
			test=extent.startTest("Buyer enquiry form entires");
						
			 Thread.sleep(5000);
	
		if(!driver.findElements(By.xpath("//a[@id='title_view_on_map']/img")).isEmpty()){
		 
		
		 System.out.println("View Map Element is displayed");
    	 //Thread.sleep(3000);
    	 
    	 driver.findElement(enquirerName).sendKeys(buyerName);
    	 
    	 System.out.println("User Sucessfully enter the buyername");
    	 driver.findElement(enquirerEmail).sendKeys(buyerEmail);
    	 
    	 System.out.println("User Sucessfully enter the buyerEmail");
    	 driver.findElement(enquirerMobile).sendKeys(buyerMobile);
    	 
    	 System.out.println("User Sucessfully enter the buyerMobile");
    	 
    	 screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
    	 
    	 
    	 driver.findElement(submitEnqForm).click();
    	 
    	 System.out.println("User Sucessfully Submit the Form");
    	 
    	
    	 
    	 Thread.sleep(3000);
	 }
    	 else{
    		 
    		 Thread.sleep(5000);
    		 
    		 System.out.println("View Map Element is not displayed");
    		    		    		 
    		 
    		 
    		 driver.findElement(ClickcontactBtn).click();
    		 
    		 //Thread.sleep(3000);
    		 
    		 driver.findElement(enquirerName).sendKeys(buyerName);
    		 System.out.println("User Sucessfully enter the buyername");
        	 driver.findElement(enquirerEmail).sendKeys(buyerEmail);
        	 System.out.println("User Sucessfully enter the buyerEmail");
        	 driver.findElement(enquirerMobile).sendKeys(buyerMobile);
        	 System.out.println("User Sucessfully enter the buyerMobileNumber");
        	 screenShotPath=ExtentManager.capture(driver, "Pass");
 			
 			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        	 
        	 driver.findElement(submitEnqFormAgentOrIndivType).click();
        	 
        	 System.out.println("User Sucessfully Submit the Form");
        	 
    		   		   		    		 
        	 Thread.sleep(3000);
    		 
    	 }
		 
	 

	
	return this;
	
	
	
}

public VDPPage pageScroll(){
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,280)", "");
	
	return this;
	
	
	
}




public VDPPage verifypopup() throws IOException, InterruptedException{
	test=extent.startTest("Verification of Post Enquiry Popup");
	 Thread.sleep(5000);


	if(driver.findElements(enqThankYouPopup).size() != 0){
		 Thread.sleep(5000);
		System.out.println("Thank You Popup is displayed");
		
		test.log(LogStatus.INFO, "Thank You Popup is displayed ");
		
		screenShotPath=ExtentManager.capture(driver, "Pass");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
      /* screenShotPath=ExtentManager.capture(driver, "Strip");
		
		test.log(LogStatus.INFO, "Thank You Popup is displayed " + test.addScreenCapture(screenShotPath));
				*/
		
	}
	
	else if(driver.findElements(thankYouPopup).size() != 0){
		
		 Thread.sleep(5000);
			System.out.println("Thank You Popup is displayed");
			
			test.log(LogStatus.INFO, "Thank You Popup is displayed ");
			
			screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
		
	}
	
	
	//siteVisitpopup
	
	else if(driver.findElements(siteVisitpopup).size() != 0){
		
		 Thread.sleep(5000);
			System.out.println("Site Visit  Popup is displayed");
			
			test.log(LogStatus.INFO, "Thank You -Site Visit Popup is displayed ");
			
			screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
		
	}
	
	else if(driver.findElements(enqAlreadyRequestedPopup).size() != 0){
		
		 Thread.sleep(5000);
		System.out.println("Already enquired about this property is displayed");
		
test.log(LogStatus.INFO, "Already enquired about this property is displayed ");
		
		screenShotPath=ExtentManager.capture(driver, "Pass");
		
	test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
   /* screenShotPath=ExtentManager.capture(driver, "Strip");
		
		test.log(LogStatus.INFO, "Already enquired about this property is displayed and Hence Closed the Browser " + test.addScreenCapture(screenShotPath));*/
		
		driver.quit();
    
		}
	

	else if (driver.findElements(enqMaximumReachedPopup).size() != 0){
		
		 Thread.sleep(5000);
		System.out.println("Reached Maximam enquiry of the day is displayed");
		
       test.log(LogStatus.INFO, "Reached Maximam enquiry of the day is displayed");
		
		screenShotPath=ExtentManager.capture(driver, "Pass");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
/*screenShotPath=ExtentManager.capture(driver, "Strip");
		
		test.log(LogStatus.INFO, "Reached Maximam enquiry of the day Popup is displayed and Hence Closed the Browser" + test.addScreenCapture(screenShotPath));*/
				
		driver.quit();
		

		}
	return this;
	
/*	else{
		
		 Thread.sleep(5000);
		System.out.println("None Of the Popup is displayed & Hence Closing the driver");
		
		test.log(LogStatus.INFO, "None Of the Popup is displayed & Hence Closing the driver");
		
		driver.quit();
		Thread.sleep(2000);
		}
	return this; */
	
}




	

     
}

/**
 * WebDriver driver = new FirefoxDriver();
driver.get("http://somedomain/url_that_delays_loading");
WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
 
 * 
 */
