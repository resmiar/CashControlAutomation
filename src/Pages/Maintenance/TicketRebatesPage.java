package Pages.Maintenance;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.GenerateRandomValue;
import Pages.GLAccountStringBuilderPage;

public class TicketRebatesPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By rebatefield = By.name("txtRebate");
	static By rebateAmount = By.id("txtRebateAmount");
	static By glAccountLookup = By.xpath("(//button[@type='button'])[10]");
	static By rebateDropdown = By.name("ddlTicketRebates");
	static String rebateName = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[12]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void addNew() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(rebatefield).sendKeys(rebateName);
		Browser.instance.findElement(rebateAmount).sendKeys("1.00");
		Browser.instance.findElement(glAccountLookup).click();
		GLAccountStringBuilderPage.createString();
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the rebate: " +rebateName);
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
		Select regionValue = new Select(Browser.instance.findElement(rebateDropdown));
		regionValue.selectByVisibleText(rebateName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the region: " +rebateName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editRegion() {
		Select regionValue = new Select(Browser.instance.findElement(rebateDropdown));
		regionValue.selectByVisibleText(rebateName);
		rebateName = rebateName+"test";
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(editButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(rebatefield).clear();
		Browser.instance.findElement(rebatefield).sendKeys(rebateName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the region: " +rebateName);
		//regionName = regionName.substring(0, regionName.length() - 4);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Ticket Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Ticket Rebates")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static boolean isAdded() {
		Select regionValue = new Select(Browser.instance.findElement(rebateDropdown));
		Boolean found = false;
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(rebateName)) {
	                found = true;
	                System.out.println("The "+ rebateName +" has been added");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static boolean isEdited() {
		Select regionValue = new Select(Browser.instance.findElement(rebateDropdown));
		Boolean found = false;
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(rebateName)) {
	                found = true;
	                System.out.println("The "+ rebateName +" has been edited");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static void editAndCancelRebate() {
		Select regionValue = new Select(Browser.instance.findElement(rebateDropdown));
		regionValue.selectByVisibleText(rebateName);
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(rebatefield).clear();
		Browser.instance.findElement(rebatefield).sendKeys(rebateName+"test");
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +rebateName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	public static boolean checkProperErrorMessage() 
	{
		boolean returnValue = false;
		String textMessage;
		switch(errorMessageScenario) { 
    case 1: 
    	{textMessage = "Must select a valid GL Account.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		 returnValue = true;}
    	
    	break;}
    case 2: 
    	{textMessage = "Please enter ticket rebate description.";
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

	public static void addWithoutGLAccount() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(rebatefield).sendKeys(rebateName);
		Browser.instance.findElement(saveButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		errorMessageScenario = 1;
	}
	
	}



