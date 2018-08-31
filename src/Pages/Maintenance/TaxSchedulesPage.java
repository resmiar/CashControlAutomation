package Pages.Maintenance;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.GenerateRandomValue;

public class TaxSchedulesPage   {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By arrowButton = By.xpath("(//button[@type='button'])[10]");
	static By taxSchedulefield = By.name("txtTaxSchedule");
	static By taxScheduleDropdown = By.name("ddlTaxSchedule");
	static By availableTaxCodes = By.xpath("(//div[@class='ui-grid-viewport ng-isolate-scope'])");
	static String scheduleName;
	static By confirmYesButton = By.xpath("(//button[@type='button'])[12]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");
	static By availableTaxNameColumn = By.xpath("//*[contains(@class,'ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid')]//div");
	
	public static void addNew() {
		Browser.instance.findElement(addNew).click();
		scheduleName = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(taxSchedulefield).sendKeys(scheduleName);
		selectTaxCode("Sales Tax");
		Browser.instance.findElement(arrowButton).click();
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the region: " +scheduleName);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();	
	}

	public static void deleteLastAdded() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Select taxScheduleValue = new Select(Browser.instance.findElement(taxScheduleDropdown));
		taxScheduleValue.selectByVisibleText(scheduleName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the region: " +scheduleName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editRegion() {
		Select taxScheduleValue = new Select(Browser.instance.findElement(taxScheduleDropdown));
		taxScheduleValue.selectByVisibleText(scheduleName);
		scheduleName = scheduleName+"test";
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(taxSchedulefield).clear();
		Browser.instance.findElement(taxSchedulefield).sendKeys(scheduleName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the region: " +scheduleName);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Sales and Tax Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Tax Schedules")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static boolean isAdded() {
		Select taxScheduleValue = new Select(Browser.instance.findElement(taxScheduleDropdown));
		Boolean found = false;
		List<WebElement> allOptions = taxScheduleValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(scheduleName)) {
	                found = true;
	                System.out.println("The "+ scheduleName +" has been added");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static boolean isEdited() {
		
		Select taxScheduleValue = new Select(Browser.instance.findElement(taxScheduleDropdown));
		Boolean found = false;
		List<WebElement> allOptions = taxScheduleValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(scheduleName)) {
	                found = true;
	                System.out.println("The "+ scheduleName +" has been edited");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static void editAndCancelRegion() {
		Select taxScheduleValue = new Select(Browser.instance.findElement(taxScheduleDropdown));
		taxScheduleValue.selectByVisibleText(scheduleName);
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(taxSchedulefield).sendKeys(scheduleName+"test");
		Browser.instance.findElement(cancelButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +scheduleName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	public static boolean checkProperErrorMessage() 
	{
		boolean returnValue = false;
		String textMessage;
		switch(errorMessageScenario) { 
    case 1: 
    	{textMessage = "Please select tax code.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	System.out.println(actualMessage);
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		 returnValue = true;}
    	
    	break;}
    case 2: 
    	{textMessage = "Please enter tax schedule.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	System.out.println(actualMessage);
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		returnValue = true;}
    		break;}
		}
		Browser.instance.findElement(confirmYesButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println(returnValue);
		return returnValue;	
	}

	public static void addNewWithBlankDescription() {
		Browser.instance.findElement(addNew).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		errorMessageScenario = 2;
		
	}

	public static void addTaxScheduleWithoutTaxCode() {
		Browser.instance.findElement(addNew).click();
		scheduleName = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(taxSchedulefield).sendKeys(scheduleName);
		Browser.instance.findElement(saveButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		errorMessageScenario = 1;
	}
	
	public static void selectTaxCode(String taxCodeName) {
	List<WebElement> rows = Browser.instance.findElements(availableTaxNameColumn);
    int iSize = rows.size();
    if (iSize!=0) {
    for (int i = 0; i < iSize; i++) 
    {
        String sValue = rows.get(i).getText(); 
                if (sValue.equalsIgnoreCase(taxCodeName)) 
                {
                    rows.get(i).click();
                    break;
                }
                }
    }
    else System.out.println("Grid cell element not found");
    
	}
	
	}






