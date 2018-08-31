package Pages.EODTransactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;

import Initialization.Browser;
import Initialization.DatabaseConnection;

public class CreateJournalFilePage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//button[.='Exit']");
	static By GenerateButton=By.name("btnGenerate");
	static By StartDateField=By.name("txtCcFromDate");
	static By EndDateField=By.name("txtCcToDate");
	static String StartDate;
	static String EndDate;
	static  List<String> stringDates;
	public static  List<String> exactDate;
	public static List<String> NewData;
	public static  List<String> SlashDateList;
	
	//Go to Create Journal File Page
	
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
			    Browser.instance.findElement(By.linkText("Create Journal File")).click();
			    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		}
		
		
		//Get days between start and end date for Validate status of dates
		public static void getDaysBetweenDates() throws Exception
		{
			Thread.sleep(2000);
			StartDate = Browser.instance.findElement(StartDateField).getAttribute("value");
			EndDate = Browser.instance.findElement(EndDateField).getAttribute("value");
		
			
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		        String Start = StartDate;
		        String End = EndDate;
		        
		        LocalDate localDateStart = LocalDate.parse(Start, formatter);
		        LocalDate localDateEnd = LocalDate.parse(End, formatter);
	     
		        System.out.println("Starting date is "+localDateStart);
		        System.out.println("Ending date is "+localDateEnd);
		        List<LocalDate> totalDates = new ArrayList<>();
		        //totalDates.add(localDateStart);
		        while (!localDateStart.isAfter(localDateEnd))
		        	
		        {
		            totalDates.add(localDateStart);
		            localDateStart = localDateStart.plusDays(1);
		           
		        }
		     
		       
		        
		        String str=null;
		        stringDates = Lists.transform(totalDates, Functions.toStringFunction());
		   
//		      stringDates.remove(0);
		     // stringDates.remove(stringDates.size()-1);
		      
		      System.out.println(stringDates);
		      
		      String NewDate=null;
		      String NewDateWithSlash=null;
		      SlashDateList=new ArrayList<String>();
		       NewData=new ArrayList<String>();
		   for(String NewList:stringDates)
		   {
			  str= NewList.replaceAll("-", "/");
			    String str1[]=str.split("/");
			  NewDateWithSlash=str1[1]+"/"+str1[2]+"/"+str1[0];
			    NewDate=str1[1]+str1[2]+str1[0];
			   NewData.add(NewDate);
			   SlashDateList.add(NewDateWithSlash);
			   
		   }

		   
	//System.out.println("Without slash"+NewData);
	System.out.println("Dates are: "+SlashDateList);
		}	 
		
		
		
		
	//Generate Journal file	
public static void generateJournalFile() throws Exception
{
	Thread.sleep(2000);
	String parentwinHandle = Browser.instance.getWindowHandle();
	Browser.instance.findElement(GenerateButton).click();

	Thread.sleep(1000);

	for(String winHandle : Browser.instance.getWindowHandles())
	{
		Browser.instance.switchTo().window(winHandle);
	}
	Browser.instance.close();
	Browser.instance.switchTo().window(parentwinHandle);
	
	


}

//Revert changes made after creating journal back to normal from db
public static void RevertChanges()
{
	int result = DatabaseConnection.updateDatatoDb("UPDATE dbo.CC_Calendar set JESent='0' where ActualDate>='2018-01-01 00:00:00.000'");
	System.out.println(result);

}
		


//Exit Page
		public static void Exit()
		{
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			Browser.instance.findElement(exitButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
			
			
		}
		
		//closing a window
		public static void Close() throws Exception
		{
			 Robot robot = new Robot();
			 robot.keyPress(KeyEvent.VK_ALT);
			 robot.keyPress(KeyEvent.VK_F4);
			 robot.keyRelease(KeyEvent.VK_ALT);
			 robot.keyRelease(KeyEvent.VK_F4);
		}
		
		
		
		
		
		       

		   
		
		
		
		
}	








		 

			

		
		
			
		   
		   
	
		
				




















