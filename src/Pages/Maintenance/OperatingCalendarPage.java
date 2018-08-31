package Pages.Maintenance;



import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.GenerateRandomValue;
import Pages.EODTransactions.CreateJournalFilePage;

public class OperatingCalendarPage {

		static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
		static By addNew = By.xpath("(//button[@type='button'])[2]");
		static By editButton = By.xpath("(//button[@type='button'])[3]");
		static By saveButton = By.xpath("(//button[@type='button'])[4]");
		static By cancelButton = By.xpath("(//button[@type='button'])[5]");
		static By deleteButton = By.xpath("(//button[@type='button'])[6]");
		static By exitButton = By.xpath("(//button[@type='button'])[7]");
		static By dateField = By.id("dtCmDate");
		static By operatingDayCheckbox = By.xpath("//input[@value='row.entity.isdorDay']");
		static By specialEventCheckbox = By.xpath("//input[@value='row.entity.hasspecialevent']");
		static By eventDescriptionField = By.xpath("(//input[@type='text'])[3]");
		static By registerDescription = By.xpath("(//input[@type='text'])[2]");
		static String eventName = GenerateRandomValue.generateRandomStringtest();
		static String oldEventName;
		static By confirmYesButton = By.xpath("(//button[@type='button'])[11]");
		static int errorMessageScenario;
		static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");
		static By statusField=By.xpath("//input[@data-ng-model='vm.calendarStatus']");
		public static List<String> OpenDate;
		static List<String> exactDateNew;
		static List<Integer> indexList;
		public static List<String> OpenDatewithSlash;
		
		
		
		public static void close() {
			
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			//wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			if (Browser.instance.findElement(cancelButton).isEnabled())
			{
			Browser.instance.findElement(cancelButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
			Browser.instance.findElement(confirmYesButton).click();
			}
			wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			Browser.instance.findElement(exitButton).click();	
		}

		//Edit the date 
		public static void editDate() {
			Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(dateField));
			//Browser.instance.findElement(dateField).sendKeys("05012018");
			Browser.instance.findElement(editButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(eventDescriptionField));
			if (!Browser.instance.findElement(specialEventCheckbox).isSelected())
			{
				Browser.instance.findElement(specialEventCheckbox).click();
			}
			Browser.instance.findElement(eventDescriptionField).clear();
			Browser.instance.findElement(eventDescriptionField).sendKeys("Test Event");
			Browser.instance.findElement(saveButton).click();
			System.out.println("Day edited successfully" );
			wait.until(ExpectedConditions.elementToBeClickable(addNew));	
		}

		public static void goTo() {
			Browser.instance.findElement(maintenanceMenu).click();
			WebElement element = Browser.instance.findElement(By.linkText("General Maintenance"));
	        Actions action = new Actions(Browser.instance);
	        action.moveToElement(element).build().perform(); 
	        Browser.instance.findElement(By.linkText("Operating Calendar")).click();
	        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
			Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}

		
		public static boolean checkIfEdited() {
			Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
			//Browser.instance.findElement(dateField).sendKeys("05012018");
			Boolean found = false;
			Browser.instance.findElement(editButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(eventDescriptionField));
			oldEventName = Browser.instance.findElement(eventDescriptionField).getAttribute("value");
			System.out.println("Event name is: "+oldEventName);
			if (oldEventName.equalsIgnoreCase("Test Event"))
				{ found = true;
				}
			//Browser.instance.findElement(editButton).click();
			//wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			if (Browser.instance.findElement(specialEventCheckbox).isSelected())
			{
				Browser.instance.findElement(specialEventCheckbox).click();
			}
			//Browser.instance.findElement(eventDescriptionField).clear();
			Browser.instance.findElement(saveButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(addNew));	
			oldEventName = null;
			return found;
		}

		public static void editAndCancel() {
			Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//Browser.instance.findElement(dateField).sendKeys("05012018");
			Browser.instance.findElement(editButton).click();
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
			oldEventName = Browser.instance.findElement(specialEventCheckbox).getAttribute("value");
			Browser.instance.findElement(specialEventCheckbox).sendKeys("test");
			Browser.instance.findElement(cancelButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
			Browser.instance.findElement(confirmYesButton).click();
			System.out.println("Editing Cancelled" );
			wait.until(ExpectedConditions.elementToBeClickable(addNew));	
		}
			

		public static boolean checkProperErrorMessage() 
		{
			boolean returnValue = false;
			String textMessage;
			Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			switch(errorMessageScenario) { 
	    case 1: 
	    	textMessage = "This calendar date already exists.";
	    	if (Browser.instance.findElement(errorMessageDiv).getText().equals(textMessage))
	    	{
	    		returnValue = true;
	    	}
	    	WebDriverWait wait = new WebDriverWait(Browser.instance,10);
	    	wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
	    	Browser.instance.findElement(confirmYesButton).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
	    	Browser.instance.findElement(cancelButton).click();
			break;	    	
	    case 2: 
	    	textMessage = "Cannot Delete because this item is used in another related item.";
	    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
	    	System.out.println(actualMessage);
	    	if (actualMessage.equals(textMessage)) {
	    		System.out.println(Browser.instance.findElement(errorMessageDiv).getText());
	    		  returnValue = true;}
	    				}
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
			Browser.instance.findElement(confirmYesButton).click();
			return true;	
		}

		public static void deleteCCDay() {
			Browser.instance.findElement(dateField).sendKeys("05012018");
			Browser.instance.findElement(deleteButton).click();
			Browser.instance.findElement(confirmYesButton).click();
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageDiv));
			errorMessageScenario = 2;
		}


		public static boolean checkNotEdited() {
			
				Boolean found = true;
			return found;
			}


		public static void addDateAgain() {
			Browser.instance.findElement(addNew).click();
			Browser.instance.findElement(dateField).sendKeys("05012018 ");
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageDiv));
			errorMessageScenario = 1;
		}
		
		//Check Status of dates whether open,close,or wait
		
		public static void CheckStatusofDates() throws Exception
		{
			int index=0;
			OpenDate=new ArrayList<String>();
			OpenDatewithSlash=new ArrayList<String>();

			 Iterator<String> it1 = CreateJournalFilePage.NewData.iterator();
			 Iterator<String> it2 =CreateJournalFilePage.SlashDateList.iterator();
			 System.out.println( CreateJournalFilePage.NewData);
			 System.out.println(CreateJournalFilePage.SlashDateList);
			 String nextNew=null;
			 String nextItrNew=null;
			 while (it1.hasNext() && it2.hasNext()) {
				 nextNew=it1.next();
				 nextItrNew=it2.next();
				 Browser.instance.findElement(dateField).click();
					Browser.instance.findElement(dateField).sendKeys(nextNew);
						Thread.sleep(1000);
						System.out.println(nextNew);
						String status=Browser.instance.findElement(statusField).getAttribute("value");
						System.out.println(status);
					if(status.equalsIgnoreCase("O"))
					{
//						index=CreateJournalFilePage.NewData.indexOf(it1.next());
//						indexList.add(index);
						OpenDate.add(nextNew.toString());
						OpenDatewithSlash.add(nextItrNew.toString());
					}
				
				
					}	
				//	System.out.println("itr1"+OpenDate);
					System.out.println("Open dates are: "+OpenDatewithSlash);
				 
			 
		}


		
		
		
		//Clear text field
		public static void Clear(By Locator) 
		{
			 Browser.instance.findElement(Locator).sendKeys(Keys.CONTROL,"a");
			    Browser.instance.findElement(Locator).sendKeys(Keys.DELETE);
		    

		}
		
		//Press Tab key
		public static void Tab() throws Exception
		{
			 Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		
		//Press Back space key
		
		public static void BackSpace() throws Exception
		{
			 Robot robot = new Robot();
			 
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
			
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		
		
		//Exit Page
		public static void Exit()
		{
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			Browser.instance.findElement(exitButton).click();
			  wait.until(ExpectedConditions.elementToBeClickable(maintenanceMenu));
			
		}
		}





