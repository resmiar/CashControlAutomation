package Pages.TellerTransactions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Pages.Maintenance.OperatingCalendarPage;

public class WeatherEntryPage {

	
	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By editButton=By.xpath("//span[.='Edit']");
	static By newButton=By.xpath("//span[.='New']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By saveButton=By.xpath("//span[.='Save']");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By DORWeatherDescriptionDropdown=By.xpath("//select[@name='ddlWeatherTypes']");
	static By DORTemperatureVal=By.xpath("//input[@data-ng-model='calendarDetail.temperature']");
	static By DORComment=By.xpath("(//input[@type='text'])[2]");
	static By errorConfirm=By.xpath("//button[.='OK']");
	static String text;
	static String temp;
	static int RandomTemp;
	static By DateConfirm=By.xpath("//button[.='OK']");
	static By openCCDayConfirm=By.xpath("//button[.='Yes']");
	static By dateEntryLink=By.xpath("//span[@class='date-field ng-binding']");
	static By dateField=By.name("txtCcDate");
	
	
	//navigate to weather entry page
public static void goTo() {
		
		
		
	Browser.instance.findElement(TransactionsMenu).click();
	WebElement element = Browser.instance.findElement(By.linkText("Teller Transactions"));
    Actions action = new Actions(Browser.instance);
    action.moveToElement(element).build().perform(); 
    Browser.instance.findElement(By.linkText("Weather Entry")).click();
    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
    wait.until(ExpectedConditions.elementToBeClickable(editButton));
	//Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	try {
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

//Edit the weather 

public static void EditWeather() throws Exception
{
	
	

	Browser.instance.findElement(editButton).click();


	try {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		 Browser.instance.findElement(saveButton);


	}
	catch(Exception e)
	{
//		System.out.println("UnExpected Error");
		
		if(Browser.instance.findElement(errorConfirm).isDisplayed()==true)
		{
		Browser.instance.findElement(errorConfirm).click();
		}
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(editButton));
		 Browser.instance.findElement(editButton).click();
		
	}
	 
	    Select Weather=new Select(Browser.instance.findElement(DORWeatherDescriptionDropdown));
	    Weather.selectByVisibleText("Sunny");
	    WebElement option = Weather.getFirstSelectedOption();
	     text = option.getText();
	 

	     if(text.equalsIgnoreCase("Sunny"))
	     {
	 System.out.println("Selected Dropdown is verified successfully: "+text);
	     }
	     else
	     {
	    	 System.out.println("Invalid weather dropdown selection");
	     }

}


//Edit the temperature
public static void Temp() throws Exception
{
	RandomTemp=generateRandomInteger();
		    Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    Browser.instance.findElement(DORTemperatureVal).sendKeys(Keys.CONTROL,"a");
	    Browser.instance.findElement(DORTemperatureVal).sendKeys(Keys.DELETE);
	    //Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Browser.instance.findElement(DORTemperatureVal).sendKeys(RandomTemp+"");
	  temp=  Browser.instance.findElement(DORTemperatureVal).getAttribute("value");

	  if(temp.equalsIgnoreCase(RandomTemp+""))

	   {
		   System.out.println("Verified the temperature added successfully: "+temp);
	   }
	   else
	   {
		   System.out.println("Invalid temperature description");
	   }
	   Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Browser.instance.findElement(DORComment).clear();
	   Browser.instance.findElement(DORComment).sendKeys("Its a "+text+" weather of temperature"+temp);


	   Browser.instance.findElement(saveButton).click();
	   WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	   wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	   

	    
	    
	    
}
//Add Weather entries to open dates of the week for creating journal file
public static void AddnewWeatherEntries() throws Exception
{
	for(String WeatherEntryToDates:OperatingCalendarPage.OpenDate)
	{
	 Browser.instance.findElement(dateEntryLink).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));

		 Thread.sleep(1000);
			Browser.instance.findElement(dateField).sendKeys(WeatherEntryToDates);
		 Browser.instance.findElement(DateConfirm).click();	
		 Thread.sleep(1000);
		 try {
			 goTo();
		 }
		 catch(Exception e)
		 {
		 goTo();
		 }
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(editButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		SelectWeather();
		Clear(DORTemperatureVal);
		AddTemp();
		Thread.sleep(500);
		try {
		Browser.instance.findElement(saveButton).click();
		}
		catch(Exception e)
		{
			Browser.instance.findElement(saveButton).click();
		}
		Thread.sleep(1000);

		Exit();
	}
	System.out.println("Weather entry has been added to all "+OperatingCalendarPage.OpenDate.size()+" open dates");
}





//Generating random Integer
public static int generateRandomInteger() {
	int min = 0;
	int max = 999;
		
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;   
}


//Exit Page
		public static void Exit()
		{
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			try {
			Browser.instance.findElement(exitButton).click();
			}
			catch(Exception e)
			{
				Browser.instance.findElement(exitButton).click();
			}
		
			
			  wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
			
		}

//Select a weather from dropdown 
public static void SelectWeather()
{
	Select Weather=new Select(Browser.instance.findElement(DORWeatherDescriptionDropdown));
    Weather.selectByVisibleText("Sunny");
}
//Clear text field
public static void Clear(By Locator) 
{
	 Browser.instance.findElement(Locator).sendKeys(Keys.CONTROL,"a");
	    Browser.instance.findElement(Locator).sendKeys(Keys.DELETE);
    

}
//Enter the temperature
public static void AddTemp()
{
	Browser.instance.findElement(DORTemperatureVal).sendKeys("20");
}
}
