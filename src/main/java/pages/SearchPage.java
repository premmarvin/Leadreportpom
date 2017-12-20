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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;
import wrapper.GenericWrappers;



public class SearchPage extends ExtentManager{
	
		
	RemoteWebDriver driver;
	
	//Set<String> childwindow;
	
	 //List<String> listListingNumbers;
	 
	 ArrayList<String> listListingNumbers = new ArrayList<String>();
	
	 List<WebElement> listingsinSearch;
	 List<WebElement> melchilistingsinSearch;
	 List<WebElement> melchilistingsinSearchAdditianlInfo;
	 	
	//String listingCollection="";
	 ArrayList<String> listingCollection = new ArrayList<String>();
	// String listingCollection;
	ArrayList<String> listingarryCollection = new ArrayList<String>();
	ArrayList<String> splitString = new ArrayList<String>();
	
	ArrayList<String> list= new ArrayList<String>();
	
	ArrayList<String> listAfterSplit= new ArrayList<String>();
	
	List<WebElement> myDynamicElement;
	int j;
	String ListingsValue = "";
	
	String[] arr = new String[11];
	String[] arry = new String[11];
	int y = 0;
	int z = 0;
	String[] replaceListingIds = new String[11];
	
	String[] replaceListingIdsTemp = new String[11];
	
	int[] iplistingmelchi=new int[11];
	int[] iplisting=new int[11];
	int[] iplistingTemp=new int[11];
	
	int[] iplistingTempmelchi=new int[11];
	String[] melchiReplaceListingIds = new String[11];
	
	String listingIds1;
	public static String parent;
	
	public static int select;
	public static int melchiselect;
	
	String listingIds ="";
	
	public static String melchilistingid1;
	public static String listingid1;
	public static String SearchPageTitle;

	public static String vdpUrl;
	public static String pageTitle;
	
	//WebDriverWait wait = new WebDriverWait(driver, 60);
	
	//WebDriverWait wait = new WebDriverWait(driver,45);
	//public By relatedPropertiesText=By.xpath("//li[text()='Related Properties']");
	
	
	public By searchlistingIds=By.xpath("//div[@class='col-xs-4']/div[@class='propety-item property-item-grid anchor-block']/div");
	
	
	public By firstElement=By.xpath("//div[@class='vdplv1-box-txt1']/div/div/h2/b/span/a");
	
	//public By searchListings=By.xpath("//div[@class='vdplv1-box-txt1']/div/div/h2/b/span/a");
	
	public By searchListings=By.xpath("//div[@class='propety-images']");
	
	public By melchiSearchListings=By.xpath("//div[@class='col-md-4 col-sm-6 col-lg-4 col-xs-12 ng-scope']/div/a[1]");
	
	public By melchiSearchListingsAddElement=By.xpath("//div[@class='col-md-4 col-sm-6 col-lg-4 col-xs-12 ng-scope']//div[@class='mdl-card__supporting-text']");
	
	public By melchiSearchListingsAddElementTemp=By.xpath("//div[@class='col-md-4 col-sm-6 col-lg-4 col-xs-12 ng-scope']//div[@class='mdl-card__supporting-text']/a");
	
	
	public By otherClickElement=By.xpath("//div[@class='form-main dark-style header-search']");
	
	//div[@class='col-md-4 col-sm-6 col-lg-4 col-xs-12 ng-scope']
	
	
	//public By searchListings=By.xpath("//div[@class='vdplv1-box-txt1']");
	
	//public By searchListings=By.xpath("//div[@class='col-xs-4']/div/div");
	
	//public By searchListings=By.xpath("//div[@class='propety-item property-item-grid anchor-block']/div");
	
	
	//public By searchListings=By.xpath("//div[@class='propety-item property-item-grid anchor-block']/child::div[1]");
	
	//public By searchListings=driver.findElementsByXPath("//div[@class='col-xs-4']/div[@class='propety-item property-item-grid anchor-block']/div[@id='propety-images"+i+"']");
	
	//public By searchListings=driver.findElementsByXPath("//div[@class='col-xs-4']/div[@class='propety-item property-item-grid anchor-block']/div[@id='propety-images"+i+"']");
	
	public SearchPage(RemoteWebDriver driver,String cityName) throws InterruptedException, IOException{
		
		test=extent.startTest("Search Page Navigation");
				
		this.driver=driver;
		
		Thread.sleep(8000);
		
		SearchPageTitle=driver.getTitle();
		
		String melchiSearchTitle="Property - Real Estate - India Property - Properties India - Property Sites";
		
		System.out.println("SearchPageTitle : "+SearchPageTitle);
		
		if(driver.findElements(searchListings).size() != 0){
		
		if(SearchPageTitle.equalsIgnoreCase("Buy All Residential in "+ cityName)){
			
			System.out.println("User sucessfully land to"+" " +cityName+" " +"Search Page");
			
			test.log(LogStatus.PASS, "Check whether user land to " +cityName + " Search Page ", "User sucessfully Land to "+cityName + " Search Page");

			screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
			
		}
			
		else{
			
			System.out.println("User unable to land to "+" " +cityName+" " +"Search Page");
			
			
			test.log(LogStatus.FAIL, "Check whether user land to " +cityName + " Search Page ", "User unable to Land to "+cityName + " Search Page");

			screenShotPath=ExtentManager.capture(driver, "Fail");
			
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
			
		}
		
		}
		
		else{
			
			if(SearchPageTitle.equalsIgnoreCase(melchiSearchTitle)){
				
				System.out.println("User sucessfully land to"+" " +cityName+" " +"Search Page");
				
				test.log(LogStatus.PASS, "Check whether user land to " +cityName + " Search Page ", "User sucessfully Land to "+cityName + " Search Page");

				screenShotPath=ExtentManager.capture(driver, "Pass");
				
				test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
				
			}
			else{
				
				System.out.println("User unable to land to "+" " +cityName+" " +"Search Page");
				
				
				test.log(LogStatus.FAIL, "Check whether user land to " +cityName + " Search Page ", "User unable to Land to "+cityName + " Search Page");

				screenShotPath=ExtentManager.capture(driver, "Fail");
				
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
			}
			
			
		}
		
		
	}
	
	
	
	public SearchPage(RemoteWebDriver driver) throws InterruptedException{
		
		System.out.println("user is in the search page");
		this.driver=driver; 
		
			  System.out.println(driver.getTitle());
		
	
		
		
	}
	
	

	public SearchPage delay5000() throws InterruptedException{
		
		Thread.sleep(5000);
		
		return this;

		
	}
	
	public SearchPage closeAllBrowser(){
		
		driver.quit();
		return this;
		
	}
	
public SearchPage listingInfo() throws InterruptedException{
	
	Thread.sleep(2000);
	
	if(driver.findElements(searchListings).size() != 0)
		
	{ 
	
		
	listingsinSearch=driver.findElements(searchListings);
	
	System.out.println(listingsinSearch.size());
	
	for(int i=0;i<listingsinSearch.size()-1;i++){
		
		listingIds=listingsinSearch.get(i).getAttribute("onclick");
		
		arr[i]=listingIds;
		
		//System.out.println("arr[y]"+arr[y]);
		
		String[] parts = arr[i].split("(?==)");
		String part1 = parts[0];
		
		//System.out.println("part1"+part1);
		
       String []  part2=part1.split("(?=www)");
		
		String part2Of2=part2[1]; 
		
		//System.out.println("part2 "+part2Of2);
		
			
		
		String[] part3=part2Of2.split("\\?");
				String part3Of3=part3[0];
		
		
		//System.out.println("part3 "+part3Of3);
		
		
		String[] part4=part3Of3.split("(?=in-)");
		
		String part4Of4=part4[1];
		
		
		System.out.println("Random Listing Url : "+part3Of3);
			
		
		
		
	
		replaceListingIds[i]=part4Of4.replaceAll("[^0-9]","");
		
		iplisting[i]=Integer.parseInt(replaceListingIds[i]);
		
		
		iplistingTemp[i]=iplisting[i] % 10000000;
		
		System.out.println("iplistingTemp[i]"+iplistingTemp[i]);
		
		replaceListingIds[i]=Integer.toString(iplistingTemp[i]);
		
		System.out.println("replaceListingIds[i] "+replaceListingIds[i]);
				
		
		System.out.println("Search ListingIds : "+replaceListingIds[i]);
		
			
		
	}
	
	}
	
	
	
	else{
		
                Thread.sleep(5000);
		
		driver.findElementById("header-searchbtn").click();
		
		System.out.println("header search is clicked");
		
		
		//melchilistingsinSearch=driver.findElements(melchiSearchListings);
		
		melchilistingsinSearch=driver.findElements(melchiSearchListings);
		
		//melchiSearchListingsAddElementTemp
		
		
		System.out.println(melchilistingsinSearch.size());
		
		for(int i=0;i<melchilistingsinSearch.size()-4;i++){
			
			listingIds=melchilistingsinSearch.get(i).getAttribute("href");
			
			arry[i]=listingIds;
			
			System.out.println("arry[i]"+arry[i]);
			
		
			
            String[] part4=arry[i].split("(?=in-)");
			
			String part4Of4=part4[1];
			System.out.println("Random Listing Url : "+part4Of4);
				
			
			
			//melchiReplaceListingIds[i]
		
			replaceListingIdsTemp[i]=part4Of4.replaceAll("[^0-9]","");
			
			iplistingmelchi[i]=Integer.parseInt(replaceListingIdsTemp[i]);
						
					
			iplistingTempmelchi[i]=iplistingmelchi[i] % 10000000;
					
					System.out.println("iplistingTempmelchi[i]"+iplistingTempmelchi[i]);
					
					melchiReplaceListingIds[i]=Integer.toString(iplistingTempmelchi[i]);
					
					System.out.println("melchiReplaceListingIds[i]] "+melchiReplaceListingIds[i]);
			
			System.out.println("Search ListingIds : "+melchiReplaceListingIds[i]);
		
					
		
		
		
	}
	Thread.sleep(3000);
	
	 if(driver.findElements(By.xpath("//button[@class='close palert-close']/span")).size() != 0){
		//System.out.println("Property Alert Form is Displayed");
		driver.findElements(By.xpath("//button[@class='close palert-close']/span")).get(0).click();

		}else{
		//System.out.println("Property Alert Form is not Displayed");
		}
	
	
}
	
	return this;
}
	
public SearchPage randomListing() throws InterruptedException, IOException{
	 WebDriverWait wait = new WebDriverWait(driver, 60);
	 
		Random r = new Random();
	test=extent.startTest("Random Navigation to VDP Page");
	
	parent = driver.getWindowHandle();
	
	
	
	if(driver.findElements(searchListings).size() != 0){
	
	
		
	select = r.nextInt(replaceListingIds.length);
	System.out.println(select);

	
	System.out.println(replaceListingIds[select]);

	listingid1 = replaceListingIds[select];

	System.out.println(listingid1);
	
	if(driver.findElements(By.xpath("//button[@class='close palert-close']/span")).size() != 0){
		System.out.println("Property Alert Form is Displayed");
		driver.findElements(By.xpath("//button[@class='close palert-close']/span")).get(0).click();

		}else{
		System.out.println("Property Alert Form is not Displayed");
		}
	
		

	Thread.sleep(10000);
		
	listingsinSearch.get(select).click();
	
	//driver.switchTo().window(parent).close();
	
	
	}
	
	else 
	{
		//if(SearchPage.melchilistingid1 != null){
		
		int secondRowCount=3;
		
		Thread.sleep(3000);
		
		melchiselect = r.nextInt(melchiReplaceListingIds.length);
		System.out.println(melchiselect);
		
		if(melchiselect<secondRowCount){

		melchiselect=melchiselect+secondRowCount;
		
		System.out.println("melchiselect+3" + melchiselect);
		
		System.out.println(melchiReplaceListingIds[melchiselect]);

		melchilistingid1 = melchiReplaceListingIds[melchiselect];

		System.out.println(melchilistingid1);
		}
		
		else{
			
			System.out.println(melchiReplaceListingIds[melchiselect]);

			melchilistingid1 = melchiReplaceListingIds[melchiselect];

			System.out.println(melchilistingid1);
			
		}
		//System.out.println("melchiselect2" + melchiselect);
		
		
	
		
	
	

	
	if(driver.findElements(By.xpath("//button[@class='close palert-close']/span")).size() != 0){
		System.out.println("Property Alert Form is Displayed");
		driver.findElements(By.xpath("//button[@class='close palert-close']/span")).get(0).click();

		}else{
		System.out.println("Property Alert Form is not Displayed");
		}
	
	
	// driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
	// JavascriptExecutor jse = (JavascriptExecutor)driver;
			 
			 
	 
	Thread.sleep(5000);
	
/*WebElement elementToblur=driver.findElementByXPath("//input[@class='ng-pristine ng-valid ng-empty ng-touched']");
	
	
	
WebElement elementToblur=driver.findElementByXPath("//div[@class='form-main dark-style header-search']");
	Actions actions = new Actions(driver);

	  actions.moveToElement(elementToblur).sendKeys(Keys.TAB);*/
	
	
	//WebElement elementToblur=driver.findElementByXPath("//div[@class='form-main dark-style header-search']");

	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
	
	System.out.println("melchilistingsinSearch.get(melchiselect)" + melchilistingsinSearch.get(melchiselect));
	
	
	WebElement element = melchilistingsinSearch.get(melchiselect);
	
	System.out.println("element" + element);
	
	
	//Thread.sleep(13000);
	
		
	
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	//driver.findElementByXPath("//div[@class='form-main dark-style header-search']").sendKeys(Keys.TAB);
	

	
	//driver.navigate().refresh();
		
	/*JavascriptExecutor jse = (JavascriptExecutor)driver;
	
		jse.executeScript("scroll(0, 100)");*/

	//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	
	/*Point poistion=driver.manage().window().getPosition();
	
	poistion.getX();
	
	poistion.getY();
	
	
	
	System.out.println("Position"+poistion.getX()+poistion.getY());
	
	poistion.move(1, 1);*/
	
	//poistion.move(-4, -4);
	
	//System.out.println(driver.manage().window().getSize());
	
	//Dimension dimen=new Dimension(400,600);
	
	//driver.manage().window().setSize(dimen);
	
	//((JavascriptExecutor)driver).executeScript("window.resizeTo(1382,702);");
	
	
	
	//driver.switchTo().activeElement().sendKeys(Keys.TAB);
	
	//driver.manage().window().maximize();
	
	Thread.sleep(15000);
	
	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	//jse.executeScript("arguments[0].scrollIntoView();", element);
	
	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	
	//((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+element.getLocation().getY()+")");
	
	//Thread.sleep(5000);
	
	element.click();
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	//jse.executeScript("scroll(0, 25)");
	
	/* Thread.sleep(5000);
	
   jse.executeScript("arguments[0].scrollIntoView()", element);*/
	
   //Thread.sleep(5000);*/
   
	//element.click();
	
	/* Actions actions = new Actions(driver);

	  actions.moveToElement(element).click().perform();*/
	  
	 
	  
	//  Thread.sleep(4000);
	
	//Thread.sleep(5000);
	
	/*WebElement element = melchilistingsinSearch.get(melchiselect);
	Thread.sleep(15000);*/

	
	
	
	

	//jse.executeScript("scroll(250, 0)"); // if the element is on top.

	/*jse.executeScript("scroll(0, 25)"); // if the element is on bottom.
	
    Thread.sleep(4000);
	

	jse.executeScript("arguments[0].scrollIntoView()", element);
	
	element.click();
	*/

	 
	/*  Actions actions = new Actions(driver);

	  actions.moveToElement(element).click().perform();*/
	  
	 
	  
	//  Thread.sleep(4000);
	  
	  
	  
	 // driver.switchTo().window(parent).close();
	  
  }
	return this;
	
	
	

	 
//}
	

}
	public SearchPage SWITCHING() throws InterruptedException, IOException{
	
	
	
	Thread.sleep(4000);
	
	driver.switchTo().window(parent).close();
	
	Thread.sleep(5000);
	
 Set<String> childwindow = driver.getWindowHandles();

	for (String newWindow : childwindow) {
		
		

     if (newWindow != parent) {
    	 
    	 
    	 
    	 
    	 Thread.sleep(10000);
			

			
			driver.switchTo().window(newWindow);
			
			System.out.println("control is switched to child window");

			Thread.sleep(10000);
			
			/*if(driver.findElements(By.xpath("//button[@id='propclose']/span")).size() != 0){
				System.out.println("Property Alert Form is Displayed");
				
				driver.findElements(By.xpath("//button[@id='propclose']/span")).get(0).click();

				}else{
				System.out.println("Property Alert Form is not Displayed");
				}*/
				
			
			
			Thread.sleep(3000);
			
			/*
			 * for Staging
			 * 
			 */
			
			//driver.navigate().to("http://www.indiaproperty.com/tata-santorini-in-poonamallee-chennai-pl5399715?fr=sres");
/*
 * 
 * 
 */
			System.out.println(driver.getTitle());
			
            vdpUrl = driver.getCurrentUrl();
			
     }		
			
	}		
			Thread.sleep(10000);
			if(listingsinSearch != null){
				
			
			if(vdpUrl.contains(listingid1)){
				
				System.out.println("User sucessfully Land to VDP Page"+vdpUrl);
				
				test.log(LogStatus.PASS, "Check whether user land following VDP Page" + vdpUrl , "User sucessfully Land to  VDP Page"+ vdpUrl);

				screenShotPath=ExtentManager.capture(driver, "Pass");
				
				test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
					
							
				
				
			}
			
			}
			else if  (melchilistingsinSearch != null){
				
				
			
			
			if (vdpUrl.contains(melchilistingid1)) {
				
				
             System.out.println("User sucessfully Land to VDP Page"+vdpUrl);
				
				test.log(LogStatus.PASS, "Check whether user land following VDP Page" + vdpUrl , "User sucessfully Land to  VDP Page"+ vdpUrl);

				screenShotPath=ExtentManager.capture(driver, "Pass");
				
				test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
								
				
				
				
			}
	
			}
			
			
			
			
				
			
			
			
			
			else{
				
				System.out.println("User unable to Land to VDP Page"+vdpUrl);
				
				
				
				test.log(LogStatus.FAIL, "Check whether user land following VDP Page " + vdpUrl, "User unable to Land to VDP Page " + vdpUrl);

				screenShotPath=ExtentManager.capture(driver, "Fail");
				
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
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
