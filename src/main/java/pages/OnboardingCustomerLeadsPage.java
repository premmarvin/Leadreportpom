package pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;
import wrapper.GenericWrappers;



public class OnboardingCustomerLeadsPage extends ExtentManager{
	
	public static RemoteWebDriver driver;
	
	public static String currentSystemDate;
	
	public static String currentDate;
	public static String freshenqListingStatus;
	
	public static String listingStatusout;
	public static String lead_details = "";
	
	ArrayList<String> str = new ArrayList<String>();
	
	ArrayList<String> listingIdsInDuplicateEnqTable = new ArrayList<String>();
	
	ArrayList<String> listingIdCollection= new ArrayList<String>();
	
	ArrayList<String> fEnqListingStatus=new ArrayList<String>();
	public static String duplicateenqListingStatus;
	ArrayList<String> dEnqListingStatus=new ArrayList<String>();
	ArrayList<String> dateInFreshEnqTable = new ArrayList<String>();
	
	ArrayList<String> listingStatusCombined=new ArrayList<String>();
	ArrayList<String> dateInDuplicateEnqTable = new ArrayList<String>();
	ArrayList<String> enquiryTableDateCollection = new ArrayList<String>();
	
	public static int a;
	
	
	public By freshEnqInfo=By.xpath("//table[@id='freshleadlists']//following-sibling::tr/td//a[@class='mediumtxt clr1']");
	
	public By duplicateEnqInfo=By.xpath("//table[@id='duplicateleadlists']//following-sibling::tr/td//a[@class='mediumtxt clr1']");
	
	
	public By listingStatusFresh=By.xpath("//table[@id='freshleadlists']//following-sibling::tr/td[4]");
	
	public By listingStatusDuplicate=By.xpath("//table[@id='duplicateleadlists']//following-sibling::tr/td[4]");
	
    public By freshEnqDate=By.xpath("//table[@id='freshleadlists']//following-sibling::tr/td[10]");
    
    public By duplicateEnqDate=By.xpath("//table[@id='duplicateleadlists']//following-sibling::tr/td[8]");
    
	
	
    public OnboardingCustomerLeadsPage(RemoteWebDriver driver){
    	
    	this.driver=driver;
    }
    
    
	
public OnboardingCustomerLeadsPage sysDate() {
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy ");

		Date date = new Date();

		// Now format the date
		currentSystemDate = dateFormat.format(date);
		currentDate = currentSystemDate.trim();
		// Print the Date
				
		System.out.println(currentDate);
		
		
		return this;
		
			

	}
	
public OnboardingCustomerLeadsPage enqDetailsInFreshTable() {
	
		String leadInfo1 = "";

	int m = 0;
	int n = 0;

	ArrayList<String> ar = new ArrayList<String>();

	List<WebElement> freshEnqData = driver.findElements(freshEnqInfo);

	for (m = 0; m <= freshEnqData.size() - 1; m++) {

		leadInfo1 = freshEnqData.get(m).getText();

		ar.add(leadInfo1);

		String parts = leadInfo1.replaceAll(".*\\(|\\).*", "");

		str.add(parts);
		str.toString().trim();
		System.out.println(str);
			

	}

	
	System.out.println(str.size());
	return this;
}



public OnboardingCustomerLeadsPage enqDetailsInDuplicateTable() {
	
	//onbTableDuplicateEnq("//table[@id='duplicateleadlists']//following-sibling::tr/td//a[@class='mediumtxt clr1']");
	
	String leadInfo1 = "";

	int m = 0;
	int n = 0;

	ArrayList<String> ar = new ArrayList<String>();

	List<WebElement> duplicateEnqData = driver.findElements(duplicateEnqInfo);

	for (m = 0; m <= duplicateEnqData.size() - 1; m++) {

		leadInfo1 = duplicateEnqData.get(m).getText();

		ar.add(leadInfo1);

		String parts = leadInfo1.replaceAll(".*\\(|\\).*", "");

		listingIdsInDuplicateEnqTable.add(parts);
		listingIdsInDuplicateEnqTable.toString().trim();
		System.out.println(listingIdsInDuplicateEnqTable);
		
				
		

	}

	
	System.out.println(listingIdsInDuplicateEnqTable.size());
	return this;
}



public OnboardingCustomerLeadsPage listingStatusFresh(){
	
	List<WebElement>fListingStatus=driver.findElements(listingStatusFresh);

	
	
	
	for(int n=0;n<=fListingStatus.size()-1;n++){
		
		freshenqListingStatus=fListingStatus.get(n).getText();
		
		fEnqListingStatus.add(freshenqListingStatus);
		
		
		fEnqListingStatus.toString().trim();
		
		System.out.println(fEnqListingStatus);
	}
	return this;
		
		
		
	}


public OnboardingCustomerLeadsPage listingStatusDuplicate(){
	
	List<WebElement>dListingStatus=driver.findElements(listingStatusDuplicate);
	
	
	
	for(int n=0;n<=dListingStatus.size()-1;n++){
		
		duplicateenqListingStatus=dListingStatus.get(n).getText();
		dEnqListingStatus.add(duplicateenqListingStatus);
		
		dEnqListingStatus.toString().trim();
		
		System.out.println(dEnqListingStatus);
	}
	return this;
	
	
	
}


public OnboardingCustomerLeadsPage onbTableCombined() {
	

	

	
	listingIdCollection.addAll(str);
	
	listingIdCollection.addAll(listingIdsInDuplicateEnqTable);
	
	
	listingIdCollection.toString().trim();
	
	//**********************************
	
	listingStatusCombined.addAll(fEnqListingStatus);
	
	System.out.println(listingStatusCombined);
	
	listingStatusCombined.addAll(dEnqListingStatus);
	listingStatusCombined.toString().trim();
	
	
		System.out.println(listingIdCollection);
		
		System.out.println(listingIdCollection.size());
				
		
		System.out.println(listingStatusCombined.size());
		return this;
		
		

	}


public OnboardingCustomerLeadsPage onbTableStatusCombined() {
	

	

	
	
	
	
	listingStatusCombined.addAll(fEnqListingStatus);
	
	System.out.println(listingStatusCombined);
	
	listingStatusCombined.addAll(dEnqListingStatus);
	System.out.println(listingStatusCombined);
	listingStatusCombined.toString().trim();
	
				
		System.out.println(listingStatusCombined.size());
		return this;
		
		

	}


public OnboardingCustomerLeadsPage onbTableDate() {
	
	
	// onbTableDate("//table[@id='freshleadlists']//following-sibling::tr/td[10]");

	String dateInfo1 = "";

	int q = 0;

	List<WebElement> data2 = driver.findElements(freshEnqDate);

	for (q = 0; q <= data2.size() - 1; q++) {

		dateInfo1 = data2.get(q).getText();
		String[] dateFreshEnq=dateInfo1.split(" ");
		
		String Date = dateFreshEnq[0];
		//String Time = DateTime[1];
		//System.out.println(dateInfo);

		System.out.println("*****************************");
	
		dateInFreshEnqTable.add(Date);
		
		

		dateInFreshEnqTable.toString().trim();
		
		System.out.println(dateInFreshEnqTable);

	}
	return this;
		
	
}


public OnboardingCustomerLeadsPage onbTableDateDuplicate() {

	
	//onbTableDateDuplicate("//table[@id='duplicateleadlists']//following-sibling::tr/td[8]");
	
	String dateInfo2 = "";

	int q = 0;

	List<WebElement> data3 = driver.findElements(duplicateEnqDate);

	for (q = 0; q <= data3.size() - 1; q++) {

		dateInfo2 = data3.get(q).getText();
		String[] dateFreshEnq=dateInfo2.split(" ");
		String Date = dateFreshEnq[0];
		
		//System.out.println(dateInfo);

		System.out.println("*****************************");
	
		dateInDuplicateEnqTable.add(Date);
		
		

		dateInDuplicateEnqTable.toString().trim();
		
		System.out.println(dateInDuplicateEnqTable);

	}
	return this;
		
	
}


public OnboardingCustomerLeadsPage onbTableDateCombined() {
	

	

	
	enquiryTableDateCollection.addAll(dateInFreshEnqTable);
	
	System.out.println(enquiryTableDateCollection);
	
	enquiryTableDateCollection.addAll(dateInDuplicateEnqTable);
	
	
	enquiryTableDateCollection.toString().trim();
		System.out.println(enquiryTableDateCollection);
		
		System.out.println(enquiryTableDateCollection.size());
		return this;
		
		

	}


public OnboardingCustomerLeadsPage leadValidation() throws IOException, InterruptedException {

	test=extent.startTest("Lead Validation in Customer Lead Page");
		
	boolean flag_lead = false;

	if(!enquiryTableDateCollection.contains(currentDate)) {
		
		
		System.out.println("Date Not Captured and Hence Enquiry is not captured in Onboarding Interface ");
		
	driver.quit();
	}
	
	else{
		
		
	
	for ( a = 0; a <=listingIdCollection.size()-1; a++) {
		
		
		if(SearchPage.listingid1 != null){
	
		if(SearchPage.listingid1.equalsIgnoreCase(listingIdCollection.get(a))&&(currentDate.equalsIgnoreCase(enquiryTableDateCollection.get(a)))){
				
		
			flag_lead = true;
			
			listingStatusout=listingStatusCombined.get(a);
			
			System.out.println(listingStatusout);
					
		
			lead_details="Lead has  Capured in Onboarding Interface:" +"Listing Id : " +" "+listingIdCollection.get(a)+" "+"Last Enquired Date :"+" "+enquiryTableDateCollection.get(a);
						
			
	        	

				
			break;
			
			}
		}
	
		else if(SearchPage.melchilistingid1 != null){
				
			if(SearchPage.melchilistingid1.equalsIgnoreCase(listingIdCollection.get(a))&&(currentDate.equalsIgnoreCase(enquiryTableDateCollection.get(a)))){
				
				
				flag_lead = true;
				
				listingStatusout=listingStatusCombined.get(a);
				
				System.out.println(listingStatusout);
						
			
				lead_details="Lead has  Capured in Onboarding Interface:" +"Listing Id : " +" "+listingIdCollection.get(a)+" "+"Last Enquired Date :"+" "+enquiryTableDateCollection.get(a);
				
					
				
		        	

					
				break;
			}
		}
		else{
			flag_lead = false;
			
			lead_details="Lead has not Capured in Onboarding Interface:" +"Listing Id : " +" "+listingIdCollection.get(a)+" "+"Last Enquired Date :"+" "+enquiryTableDateCollection.get(a);
			
			
			

		}

				}
				

		if (flag_lead) {
		System.out.println(lead_details);

		test.log(LogStatus.PASS, "Check whether Posted Enquiry Captured in Customer Lead Page"," Lead has  Capured in Onboarding Interface:" +"Listing Id : " +" "+listingIdCollection.get(a)+" "+"Last Enquired Date :"+" "+enquiryTableDateCollection.get(a));
        
	       
        screenShotPath=ExtentManager.capturefull(driver, "Pass");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));

		} else {

		
		System.out.println(lead_details);

		test.log(LogStatus.FAIL, "Check whether Posted Enquiry Captured in Customer Lead Page"," Lead has  not Capured in Onboarding Interface:" +"Listing Id : " +" "+listingIdCollection.get(a)+" "+"Last Enquired Date :"+" "+enquiryTableDateCollection.get(a));
        
	       
        screenShotPath=ExtentManager.capturefull(driver, "Fail");
		
		test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	

		
		}
			
		
			
				
		}
	return this;	

}

}








	



