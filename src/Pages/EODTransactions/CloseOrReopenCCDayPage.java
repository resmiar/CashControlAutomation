package Pages.EODTransactions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Initialization.DatabaseConnection;
import Pages.Maintenance.OperatingCalendarPage;

public class CloseOrReopenCCDayPage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By CloseCCDayButton=By.xpath("//button[@name='btnClose']");
	static String CloseCCDayDate;
	static By ReopenCCDayButton=By.xpath("//button[@name='btnReOpen']");
	static String ReopenCCDayDate;
	static By BufferImg=By.xpath("(//img)[1]");
	static By ClosedDayMsg=By.xpath("//div[@class='full-width-form']");
	static By ClosedDayConfirm=By.xpath("//button[.='OK']");
	static By ParksUploadConfirm=By.xpath("//button[.='OK']");
	static By ReopenedDayMsg=By.xpath("//div[@class='full-width-form']");
	static By ReopenedDayConfirm=By.xpath("//button[.='OK']");
	static By WeatherNotEnteredMsg=By.xpath("//div[@class='full-width-form']");
	static By WeatherNotEnteredConfirm=By.xpath("//button[.='Yes']");
	
	
	//Go to Close or ReopenCCDay Page
		
	public static void goTo() {
			try {
				Browser.instance.findElement(TransactionsMenu).click();
			}
			catch(Exception e)
			{
				System.out.println("Element not clickable exception handled for Transactions Menu");
				Browser.instance.findElement(TransactionsMenu).click();
			}
			
			WebElement element = Browser.instance.findElement(By.linkText("End-of-Day Transactions"));
		    Actions action = new Actions(Browser.instance);
		    action.moveToElement(element).build().perform(); 
		    Browser.instance.findElement(By.linkText("Close/Re-Open CC Day")).click();
		    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
	
	
	//Close CC Day
	
	public static void CloseCCDay()
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,5);
	CloseCCDayDate=Browser.instance.findElement(CloseCCDayButton).getText();
try
{
	Browser.instance.findElement(CloseCCDayButton).click();	
}
	catch(Exception z)
{
		Browser.instance.findElement(CloseCCDayButton).click();
}
		
		
		  try
		  {
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
			  
			  String ClosedDayActual=Browser.instance.findElement(ClosedDayMsg).getText();
			  String ClosedDayExpected="The Day has been Closed";
			  if (ClosedDayActual.equalsIgnoreCase(ClosedDayExpected))
			  {
				  System.out.println(ClosedDayExpected+" Msg is Verified");
				  Browser.instance.findElement(ClosedDayConfirm).click();
				  wait.until(ExpectedConditions.elementToBeClickable(ParksUploadConfirm));
				  Browser.instance.findElement(ParksUploadConfirm).click();
			  }
			  else
			  {
				  System.out.println("Msg is not verified");
				  System.out.println(ClosedDayActual);
			  }
			  
		  }		
			  catch(Exception e)
			  {
				  wait.until(ExpectedConditions.elementToBeClickable(WeatherNotEnteredConfirm));
				  if(Browser.instance.findElement(WeatherNotEnteredConfirm).isDisplayed()==true) 
					{
						 String WeatherEntryMissActual=Browser.instance.findElement(WeatherNotEnteredMsg).getText();
						  String WeatherEntryMissExpected="Weather Information is Missing. Do you want to close day anyway?";
					
				
					 if(WeatherEntryMissActual.equalsIgnoreCase(WeatherEntryMissExpected))
							 {
						 System.out.println(WeatherEntryMissExpected+" Message is Verified");
						Browser.instance.findElement(WeatherNotEnteredConfirm).click();
						WebDriverWait wait1= new WebDriverWait(Browser.instance,10);
						wait1.until(ExpectedConditions.elementToBeClickable(ClosedDayConfirm));
						 String ClosedDayActual=Browser.instance.findElement(ClosedDayMsg).getText();
						  String ClosedDayExpected="The Day has been Closed";
						  
						  if (ClosedDayActual.equalsIgnoreCase(ClosedDayExpected))
						  {
							  System.out.println(ClosedDayExpected+" Msg is Verified Successfully");
							  Browser.instance.findElement(ClosedDayConfirm).click();
							  wait1.until(ExpectedConditions.elementToBeClickable(ParksUploadConfirm));
							  Browser.instance.findElement(ParksUploadConfirm).click();
							  wait1.until(ExpectedConditions.elementToBeClickable(exitButton));
						  }
						  else
						  {
							  System.out.println(ClosedDayExpected+"Msg is not verified");
						  }
			
								 }
				 
				  }
			  
		  }
		  
		  System.out.println("Closed CC Date is "+CloseCCDayDate);
	}
	
	//Reopen CC day
	
	public static void ReopenCCDay() throws Exception 
	{
	
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Thread.sleep(1000);
		try
		{
		
			ReopenCCDayDate=Browser.instance.findElement(ReopenCCDayButton).getText();
			Browser.instance.findElement(ReopenCCDayButton).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
			String ActualReopenedMsg=Browser.instance.findElement(ReopenedDayMsg).getText();
			String ExpectedReopenedMsg="The Day has been Re-Opened";
			if(ActualReopenedMsg.equalsIgnoreCase(ExpectedReopenedMsg))
			{
			System.out.println(ActualReopenedMsg+"Msg is Verified Successfully");
			Browser.instance.findElement(ReopenedDayConfirm).click();
			System.out.println("Reopened CC Date is "+ReopenCCDayDate);
			}
			else
			{
				System.out.println(ActualReopenedMsg);
				System.out.println("Re-opened Message is not verified succeessfully");
				
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		}
		catch(Exception e)
		{
			if(Browser.instance.findElement(ReopenCCDayButton).isEnabled()==false)
			{
			System.out.println("Day cannot be reopened since Journal is created");
			}
			else
			{
				System.out.println("Can't be reopened");
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
	
	//Close CC Dates till the last open day in the week
	
	public static void CloseCCDaysInaWeek() throws Exception
	{
	
		for( String CloseDays:OperatingCalendarPage.OpenDatewithSlash)
		{ 
			
			Thread.sleep(2000);
	
			if(Browser.instance.findElement(CloseCCDayButton).getText().equalsIgnoreCase(CloseDays))
	        {
	           CloseCCDay(); 
	        }
			else
			{
				System.out.println("Not able to close");
				break;
			}
	    }
		
	
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
		
		
	
	//Revert the changes made after creating Journal file from db;	
	public static void RevertChanges()
	{
		int result = DatabaseConnection.updateDatatoDb("UPDATE dbo.CC_Calendar set JESent='0' where ActualDate>='2018-01-01 00:00:00.000'");
		System.out.println(result);
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
	
	//Exit the page
	public static void Exit()
	{
		try {
			Browser.instance.findElement(exitButton).click();
		}
		catch(Exception e)
		{
			Browser.instance.findElement(exitButton).click();

		}
	
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		  wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		
	}
	
	}
	
	
		
	
