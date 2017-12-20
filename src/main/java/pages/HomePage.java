package pages;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;

import utils.DataInputProviderPage1;
import utils.ProjectWrapper;
import wrapper.GenericWrappers;



public class HomePage extends ExtentManager {
	
	public RemoteWebDriver driver;
	
	public ExtentReports extent;

	public static ExtentTest test;
	
	public static String screenShotPath;
	
	
	//WebDriverWait wait = new WebDriverWait(driver,45);
	// WebDriverWait wait = new WebDriverWait(driver,30);
	//public static String Title="Property for Sale in Chennai | Properties in Chennai | Real Estate in Chennai | For Buy/Sale Residential Apartments, Flats, Independent Houses, Villas, Homes, Lands &amp; Plots in Chennai | IndiaProperty.com";
	public static String HomepageTitle;
	//public static  String ipurl="https://www.indiaproperty.com/";
	
	public  By closeIcon=By.xpath("//*[@id='modalcity-close']");
	
	//div[@id='hmpg_select_city']/a
	
	public By selectCity=By.xpath("//div[@id='hmpg_select_city']/a");
	
	//public By selectCity=By.xpath("//div[@class='select-city']/a");
	
	public By clickCitytextBox=By.id("searchval");
	
	public By selectCityFromCityDropdown=By.xpath("//li[@class='ui-menu-item']");
	
	public By searchBtn=By.id("home-searchbtn");
	
	public By relatedPropertiesText=By.xpath("//li[text()='Related Properties']");
	
	///clickByClassNamesCitySelectFromList("ui-menu-item");
	
	//li[@class='ui-menu-item']
	public HomePage(RemoteWebDriver driver,ExtentTest test){
		extent = ExtentManager.Instance();
		this.driver=driver;
		this.test=test;
		
	}
	
	
	
	//Browser selection
	
	public HomePage getIPUrl(String browser,String sUrl){
		
		if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	        			//driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);		
	        			//WebDriverWait wait = new WebDriverWait(driver, 120);
	        			
		}else{
			//System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver = new FirefoxDriver();
			
			//WebDriverWait wait = new WebDriverWait(driver, 120);
			
			
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);
		}
	

	
		
		
		return this;
	}
		
	
	
	

public HomePage getHomeIPUrl(String sUrl)  {
	
	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(sUrl);	
									
	     	return this;
		
		
		
	}
		
		
	//Close Strip icon in Home Page

	public HomePage closeStrip() throws IOException  {
		
		//test=extent.startTest("Closing of Change City Link");
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(closeIcon));	
		driver.findElement(closeIcon).click();
		
		//test.log(LogStatus.PASS, "Check whether the user able to close change City Strip", "User sucessfully closed the change city strip ");
		
		/*if(driver.findElement(closeIcon).isDisplayed()){
								
			
			
				test.log(LogStatus.PASS, "Check whether user close the city Strip", "User sucessfully close the strip");

				screenShotPath=ExtentManager.capture(driver, "Strip");
				
				test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
				
						
		     
		}
		
		else{
						
		test.log(LogStatus.FAIL, "Check whether user close the city Stripe", "User unable to close the strip");
		
		screenShotPath=ExtentManager.capture(driver, "Strip");
		
		test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
		
		}*/
		
		return this;
		
						
		
				
				
	}
	

	public HomePage selectCityClick() throws InterruptedException {
			
	//WebDriverWait wait =new WebDriverWait(driver,30);
				
		WebElement myDynamicElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(selectCity));
		
	//wait.until(ExpectedConditions.presenceOfElementLocated(selectCity));

		myDynamicElement.click();
		//Thread.sleep(5000);
		//driver.findElement(selectCity).click();
					
		return this;
		
				
				
				
	}
	
	
public HomePage clickCityTextboxValue(String cityName) throws InterruptedException, IOException{
	
	test=extent.startTest("Browser Launch and "+cityName +" Home Page Navigation");
	
	
	//WebDriverWait wait =new WebDriverWait(driver,30);
		WebElement myDynamicElement1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(clickCitytextBox));	
		
	//wait.until(ExpectedConditions.elementToBeClickable(clickCitytextBox));

		
		Thread.sleep(5000);
		
		//driver.findElement(clickCitytextBox).click();
		
		myDynamicElement1.click();
		
		myDynamicElement1.sendKeys(cityName,Keys.ENTER);
		
		
		
		WebElement myDynamicElement2 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(selectCityFromCityDropdown));	
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(selectCityFromCityDropdown));	
		Thread.sleep(5000);
		
		//driver.findElement(selectCityFromCityDropdown).click();
		myDynamicElement2.click();
		
				
		
		String exptHomePageTitleTier3City="Property in India, Buy, Sell, Rent Properties, Real Estate India, Online Property Sites in India";
		
		//String exptHomePageTitleTier1City="Property for Sale in "+cityName+" "+"| Properties in "+cityName +" "+"| Real Estate in "+cityName +" "+"| For Buy/Sale Residential Apartments, Flats, Independent Houses, Villas, Homes, Lands & Plots in "+cityName +" "+"| IndiaProperty.com";
		
		System.out.println("exptHomePageTitle "+exptHomePageTitleTier3City);
		//System.out.println("exptHomePageTitle "+exptHomePageTitleTier1City);
		
		HomepageTitle=driver.getTitle();
		
		System.out.println("HomepageTitle " +HomepageTitle);
		
		if(HomepageTitle.contains(exptHomePageTitleTier3City)){
		
		//if(HomepageTitle.contains(exptHomePageTitleTier1City)){
			
			
			System.out.println("User sucessfully Land to "+cityName +" " +"Home Page");
			
			
        test.log(LogStatus.PASS, "Check whether user navigated to the "+cityName + " Home Page ", "User sucessfully land to the "+cityName + " Home Page");
        
       
         screenShotPath=ExtentManager.capture(driver, "Strip");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
     	
				
			
		}
		
		else{
			
			System.out.println("User is not able to  Land to "+cityName +" " +"Home Page");
			
			test.log(LogStatus.FAIL, "Check whether user navigated to the "+cityName +" Home Page", "User unable to land to the "+cityName +" Home Page");
			
			screenShotPath=ExtentManager.capture(driver, "Strip");
			
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
			
		}
		
		
		return this;
	
		
				
	}
	






public HomePage selectCityName() throws InterruptedException{
	//WebDriverWait wait =new WebDriverWait(driver,30);
	
	//WebElement myDynamicElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(clickCitytextBox));	
	WebElement cityNameVal=driver.findElements(selectCityFromCityDropdown).get(0);
	
	
	WebElement myDynamicElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(cityNameVal));	
	
	//wait.until(ExpectedConditions.elementToBeClickable(cityNameVal));	

	//cityNameVal.click();
	myDynamicElement.click();
		
	return this;
		
			
			
}



	
public HomePage webDriverwait(By locator)	{
	
	 
	 WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
		
	return this;
	
}
	

/**
 * WebDriver driver = new FirefoxDriver();
driver.get("http://somedomain/url_that_delays_loading");
WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
 * @throws InterruptedException 
 * @throws IOException 
 
 * 
 */

public SearchPage searchBtnClick(String cityName ) throws InterruptedException, IOException	{
	
	//WebDriverWait wait =new WebDriverWait(driver,30);
	 
	WebElement myDynamicElement = (new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(searchBtn)));
	
	
	
	myDynamicElement.click();
	
	Thread.sleep(4000);
		
	
	/*
	 * Melchi Search Page navigation
	 * 
	 * 
	 */
	
	/*driver.get("https://www.indiaproperty.com/searchresults.php?q=");
	 
	 Actions act =new Actions(driver);
	
	act.sendKeys(Keys.ENTER);*/
	
	

	/*
	 * Existing Search Page navigation
	 * 
	 * 
	 */
	
	
	driver.get("https://www.indiaproperty.com/searchs/ci=alangudi&pt=allresidential&litype=sale&vm=ltrboqViZ6ufnNrKl%5E~%5ETrxOKkmtfecaWPm9bYydegldPppt7MmK6ni96io7GpWuHSp67qxt6XV%5E~%5ETimLKeX6ejnJ5rXaasYKagX6OrkaRn&frm=15&srchtype=quick-search&f=srch&withapi=2&view=grid");
	
	
	Actions act =new Actions(driver);
	
	act.sendKeys(Keys.ENTER);
	return new SearchPage(driver,cityName);
	

	
}






public HomePage delay5000() throws InterruptedException{
	
	Thread.sleep(5000);
	
	return this;

	
}



public HomePage closeAllBrowser(){
	
	driver.quit();
	return this;
	
}

}


