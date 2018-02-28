package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.GenerateRandomValue;

public class SalesRepsPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By regionfield = By.name("txtRegion");
	static By regionDropdown = By.name("ddlRegions");
	static String regionName = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[11]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void addNew() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(regionfield).sendKeys(regionName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the region: " +regionName);
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
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		regionValue.selectByVisibleText(regionName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the region: " +regionName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editRegion() {
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		regionValue.selectByVisibleText(regionName);
		regionName = regionName+"test";
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(regionfield).sendKeys(regionName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the region: " +regionName);
		//regionName = regionName.substring(0, regionName.length() - 4);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Location Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Regions")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static boolean isAdded() {
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		Boolean found = false;
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(regionName)) {
	                found = true;
	                System.out.println("The "+ regionName +" has been added");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static boolean isEdited() {
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		Boolean found = false;
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(regionName)) {
	                found = true;
	                System.out.println("The "+ regionName +" has been edited");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static void editAndCancelRegion() {
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		regionValue.selectByVisibleText(regionName);
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(regionfield).sendKeys(regionName+"test");
		Browser.instance.findElement(cancelButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +regionName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	public static boolean checkProperErrorMessage() 
	{
		boolean returnValue = false;
		String textMessage;
		switch(errorMessageScenario) { 
    case 1: 
    	{textMessage = "Region already exist.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		 returnValue = true;}
    	
    	break;}
    case 2: 
    	{textMessage = "Please enter region.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
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

	public static void addRegionAgain() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(regionfield).sendKeys(regionName);
		Browser.instance.findElement(saveButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		errorMessageScenario = 1;
	}
	
	}




