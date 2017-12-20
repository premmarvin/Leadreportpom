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



public class SellerDashboard extends ExtentManager{
	
		
	RemoteWebDriver driver;
	
	public static String value;	
	
	public static String value2;
	
	public static String recentLeadListing;
	
	ArrayList<String> expiredListing=new ArrayList<String>();
	ArrayList<String> expenqCount=new ArrayList<String>();
	public static  int countEnqTemp;
	ArrayList<Integer>   countEnq=new ArrayList<Integer>();
	
	
	public By recentLeadNameMobileNo=By.xpath("//div[@class='txt12 left']");
	
	public By recentLeadEnqListingId=By.xpath("//div[@class='txt12 right']/a");
	
	public By myLeadsLinkName=By.linkText("My Leads");
	
	public By sublinkSaleLeads=By.xpath("//div[@id='subMenu']/a[2]");
	
	
	
	 
	
	
	
	
	public SellerDashboard(RemoteWebDriver driver) throws InterruptedException, IOException{
		
		test=extent.startTest("Seller Dashboard Navigation");
		this.driver=driver;
		
		
		ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs4.get(4));


     Thread.sleep(4000);
		
		

		String userDashboardActual=driver.getTitle();
		
	String userDashboardexpected="My Properties - Properties & Real Estate in India - India Property Portal";
	
	if(SearchPage.listingid1 != null){
	
	if(userDashboardexpected.equalsIgnoreCase(userDashboardActual)){
		
		System.out.println("User sucessfully land to user dashboard."+" "+"Seller Listing Id"+" : "+SearchPage.listingid1);	
		
		test.log(LogStatus.PASS, "Check whether user navigated Respective Seller Dashboard Page", "User sucessfully to land to user dashboard."+" "+" Seller Listing Id"+" : "+SearchPage.listingid1);
        
	       
        screenShotPath=ExtentManager.capture(driver, "Pass");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
		
		
	}
	}
	
	else if(SearchPage.melchilistingid1 != null){
		
		if(userDashboardexpected.equalsIgnoreCase(userDashboardActual)){
			
			System.out.println("User sucessfully land to user dashboard."+" "+"Seller Listing Id"+" : "+SearchPage.melchilistingid1);	
			
			test.log(LogStatus.PASS, "Check whether user navigated Respective Seller Dashboard Page", "User sucessfully to land to user dashboard."+" "+" Seller Listing Id"+" : "+SearchPage.listingid1);
	        
		       
	        screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
		
	}
	}
	else{
		
		
		//System.out.println("User unable to land to user dashboard"+"User Listing Id"+SearchPage.listingid1);
		
		System.out.println("User unable to land to user dashboard");
		
	//	test.log(LogStatus.FAIL, "Check whether user navigated Respective Seller Dashboard Page", "User unable to land to user dashboard."+" "+" Seller Listing Id"+" : "+SearchPage.listingid1);
        
		test.log(LogStatus.FAIL, "Check whether user navigated Respective Seller Dashboard Page", "User unable to land to user dashboard.");
	       
        screenShotPath=ExtentManager.capture(driver, "Fail");
		
		test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
		
			
		
		
	}
	}
	
	
	
	
	public SellerDashboard pageScrollup(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		return this;
		
		
	}
		
public SellerDashboard pageScrollDown(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)", "");
		return this;
		
		
	}
	
	

	
public SellerDashboard LeadValidationInDashboard(String recentName,String recentMobileNumber) throws InterruptedException, IOException{
		
	if(OnboardingCustomerLeadsPage.listingStatusout.equalsIgnoreCase("Active")){

	
	List<WebElement> nameMobile=driver.findElements(recentLeadNameMobileNo);
	List<WebElement> listingId=driver.findElements(recentLeadEnqListingId);

int val=nameMobile.size();


for(int i=0;i<val-4;i++){
	
	
	value=nameMobile.get(0).getText();
	
	
	System.out.println(value);
	
	
	


}

int val2=listingId.size();

for(int j=0;j<=val2-5;j++){
	
	 					
value2=listingId.get(0).getText();


System.out.println(value2);



String[] recentEnqDashboard = value2.split("(?<=\\D)(?=\\d)");
System.out.println(recentEnqDashboard[0]);
System.out.println(recentEnqDashboard[1]);


System.out.println(recentEnqDashboard);


recentLeadListing=recentEnqDashboard[1].trim();


System.out.println("recentLeadListing"+recentLeadListing);

System.out.println(recentName+" "+"+91-"+recentMobileNumber);



if(SearchPage.listingid1 != null){

if(value.equalsIgnoreCase(recentName+","+" "+"+91-"+recentMobileNumber)&&recentLeadListing.equalsIgnoreCase(SearchPage.listingid1)){
	
	
	System.out.println("Posted Enquiry is captured in Recent Lead section in Dashboard");
	
	
	System.out.println( "Name & Mobile Number of the enquired user"+" : "+value);
	
	System.out.println( "Enquired Listing id"+" : "+SearchPage.listingid1);
	
	  
	
}
}

else if(SearchPage.melchilistingid1 != null){
	
	if(value.equalsIgnoreCase(recentName+","+" "+"+91-"+recentMobileNumber)&&recentLeadListing.equalsIgnoreCase(SearchPage.melchilistingid1)){
		
		
		System.out.println("Posted Enquiry is captured in Recent Lead section in Dashboard");
		
		
		System.out.println( "Name & Mobile Number of the enquired user"+" : "+value);
		
		System.out.println( "Enquired Listing id"+" : "+SearchPage.melchilistingid1);
		
		  
		
	}
	
	
}

else{
	
	System.out.println( "Posted Enquiry is not captured in Recent Lead section in Dashboard");
	
	
}

}
	}
	
	else{
		
		
		
 if(OnboardingCustomerLeadsPage.listingStatusout.equalsIgnoreCase("Expired")){
    		 
    		 test.log(LogStatus.INFO, "User click Expired Enquiry link in Dashboard");
    		 
    		 screenShotPath=ExtentManager.capturefull(driver, "Pass");
    			
    			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
    		 
    		//String screenShotPath = Capturescreeshotsfull.capture(driver, "screenShotName12");
				//test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));
    		 
    		 driver.findElementByXPath("//div[contains(text(),'Expired Listing Leads  ')]/span/a").click();
    		 
    		 Thread.sleep(3000);
    		 
    		
    		 driver.findElementByXPath("//input[@id='startdate']/following::img[@class='ui-datepicker-trigger']").click();
    		 Thread.sleep(5000);
    		 
    		 
    		
    		 
    		 test.log(LogStatus.INFO, "User select the  start date (Today Date) in a Calender");
    		 
    		 screenShotPath=ExtentManager.capturefull(driver, "Pass");
    		 test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
    		 
    		driver.findElementByXPath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a").click();
    		
    		 Thread.sleep(10000);
    		driver.findElementByXPath("//input[@id='enddate']/following::img[@class='ui-datepicker-trigger']").click();
    		 
    		 Thread.sleep(5000);
    		 
    		 test.log(LogStatus.INFO, "User select the  end date (Today Date) in a Calender");
    		 
    		 screenShotPath=ExtentManager.capturefull(driver, "Pass");
    		 test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
    		 driver.findElementByXPath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a").click();
    		 Thread.sleep(10000);
    		 
    		 
    		 
    		
    		 
    		 driver.findElementByClassName("blueBtn1").click();
    		 
    		// test.log(LogStatus.INFO, "User submit the form");
    		
    		 
    		 Thread.sleep(10000);
    		 
              
    		
    		
    		
    		List<WebElement> expiredListingidvalue=driver.findElementsByXPath("//tr[@class='bgclr3']/td[1]");
    		
    		
    		List<WebElement> enqCountArray=driver.findElementsByXPath("//td[@class='nosuggmatch boldtxt textcenter']/following::tr[@class='bgclr3']/td[3]");
    		

    		
    		for(int k=0;k<expiredListingidvalue.size()-1;k++){
    			
    			String expiredListingids=expiredListingidvalue.get(k).getText();
    			
    			
    			String[] part = expiredListingids.split("(?<=\\D)(?=\\d)");
    			System.out.println(part[0]);
    			System.out.println(part[1]);
    			
    			
    			System.out.println(expiredListingids);
    			
    			
    			part[1].trim();
    			expiredListing.add(part[1]);
    			
    			System.out.println(expiredListing);
    			
    		}
    		
    		System.out.println("*******************");
    		System.out.println(expiredListing);
    		
    		System.out.println("*******************");
    		for(int m=0;m<enqCountArray.size()-1;m++){
    			
    			String enqCountvalue=enqCountArray.get(m).getText().trim();
    			
    			expenqCount.add(enqCountvalue);
    			
    			System.out.println(expenqCount);
    			
    			countEnqTemp= Integer.parseInt( expenqCount.get(m));
    			
    			countEnq.add(countEnqTemp);
    			
    			System.out.println(countEnq);
    		}
    			
    		System.out.println("*******************");
    		System.out.println(countEnq);
    		System.out.println("*******************");
    		/*}
    		}*/
    		
    		
    		
    		
    		
    		
    	    
    	    for ( int expvalidation = 0; expvalidation <=expiredListing.size()-1; expvalidation++) {
    	    	
    	    	if(SearchPage.listingid1 != null){
    	    	
    	      if(expiredListing.get(expvalidation).equalsIgnoreCase(SearchPage.listingid1)&& (countEnq.get(expvalidation)>0)){
    	    	  
    	    	
    	    	  
    	    	  System.out.println(SearchPage.listingid1+"****"+countEnq);
    	    	  
    	    	  
    	    	  System.out.println("Enquired Listing Id "+": "+expiredListing.get(expvalidation)+ ", "+"Enquiry Count"+" : "+countEnq.get(expvalidation));
    	    		  
    	    		  System.out.println("Expired Listing enquiry is captured in Expired enq table");
    	    	    	
    	    		  
    	    		  test.log(LogStatus.INFO, ("Enquired Listing Id "+": "+expiredListing.get(expvalidation)+ ", "+"Enquiry Count"+" : "+countEnq.get(expvalidation)));
    	      	       	     		
    	     		 
    	    		  screenShotPath=ExtentManager.capturefull(driver, "Pass");
    	    		  test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
    	     		   
    	    		  driver.quit();
    	    	  
    	      }    
    	        
    	    	}
    	    	else if(SearchPage.melchilistingid1 != null){
    	    		
    	    		if(expiredListing.get(expvalidation).equalsIgnoreCase(SearchPage.melchilistingid1)&& (countEnq.get(expvalidation)>0)){
    	    	    	  
    	    	    	
    	    	    	  
    	    	    	  System.out.println(SearchPage.listingid1+"****"+countEnq);
    	    	    	  
    	    	    	  
    	    	    	  System.out.println("Enquired Listing Id "+": "+expiredListing.get(expvalidation)+ ", "+"Enquiry Count"+" : "+countEnq.get(expvalidation));
    	    	    		  
    	    	    		  System.out.println("Expired Listing enquiry is captured in Expired enq table");
    	    	    	    	
    	    	    		  
    	    	    		  test.log(LogStatus.INFO, ("Enquired Listing Id "+": "+expiredListing.get(expvalidation)+ ", "+"Enquiry Count"+" : "+countEnq.get(expvalidation)));
    	    	      	       	     		
    	    	     		 
    	    	    		  screenShotPath=ExtentManager.capturefull(driver, "Pass");
    	    	    		  test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
    	    	     		   
    	    	    		  driver.quit();
    	    	    	  
    	    	      }    
    	    	  
    	    	  
    	    	  
    	      }
    	      
    	      
    	    }
    	   	     	    	
    		 
    	 }
			
    	 }
       
       	
		

	
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
