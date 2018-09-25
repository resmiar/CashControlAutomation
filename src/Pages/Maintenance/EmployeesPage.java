package Pages.Maintenance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Initialization.GenerateRandomValue;

public class EmployeesPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By eidfield = By.id("txtSSNNo");
	static By badgeDropdown = By.xpath("//select[@ng-model='selectedObject.selectedBadge']");
	static By firstNameField = By.xpath("//input[@type='text']");
	static By lastNameField = By.xpath("(//input[@type='text'])[2]");
	static By addBadgeButton = By.xpath("(//button[@type='button'])[10]");
	static By badgeField = By.id("txtBadgeNumber");
	static By badgeConfirmationButton = By.xpath("(//button[@type='button'])[19]");
	static By editBadgeButton=By.xpath("//button[@data-ng-disabled='disableCtrls.btnBtmEdit']");
	static By badgeActiveCheckBox = By.xpath("//input[@type='checkbox']");
	static By saveBadgeButton = By.xpath("(//button[@type='button'])[2]");
	static String eIDValue = GenerateRandomValue.generateRandomStringtest();
	static String badgeIDValue= GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[15]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void addNew()  {
		Browser.instance.findElement(addNew).click();
		//badgeIDValue = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(firstNameField).sendKeys(eIDValue);
		Browser.instance.findElement(lastNameField).sendKeys(eIDValue);
		Browser.instance.findElement(eidfield).sendKeys(eIDValue);
		Browser.instance.findElement(eidfield).sendKeys(Keys.TAB);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(addBadgeButton));
		Browser.instance.findElement(addBadgeButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(badgeField));
		Browser.instance.findElement(badgeField).click();
		Browser.instance.findElement(badgeField).sendKeys(badgeIDValue);
		Browser.instance.findElement(badgeField).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.elementToBeClickable(badgeConfirmationButton));
		Browser.instance.findElement(badgeConfirmationButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBadgeButton));
		Browser.instance.findElement(saveBadgeButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the region: " +badgeIDValue);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed the wait");
	}

	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();	
	}

	public static void deleteLastAdded() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Select regionValue = new Select(Browser.instance.findElement(badgeDropdown));
		regionValue.selectByVisibleText(badgeIDValue);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the region: " +badgeIDValue);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editEmployees() {
		Select regionValue = new Select(Browser.instance.findElement(badgeDropdown));
		regionValue.selectByVisibleText(badgeIDValue);
		badgeIDValue = badgeIDValue+"test";
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addBadgeButton));
		Browser.instance.findElement(editBadgeButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(badgeField));
		Browser.instance.findElement(badgeField).click();
		Browser.instance.findElement(badgeField).clear();
		Browser.instance.findElement(badgeField).sendKeys(badgeIDValue);
		Browser.instance.findElement(badgeField).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.elementToBeClickable(badgeConfirmationButton));
		Browser.instance.findElement(badgeConfirmationButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBadgeButton));
		Browser.instance.findElement(saveBadgeButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the region: " +badgeIDValue);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed the wait");	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("General Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Employees")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static boolean isAdded() {
		Select regionValue = new Select(Browser.instance.findElement(badgeDropdown));
		Boolean found = false;
		System.out.println(regionValue.getFirstSelectedOption().getText());
		String actualValue = regionValue.getFirstSelectedOption().getText();
		if (badgeIDValue.equals(actualValue))
		{
			found = true;
			System.out.println("The "+ badgeIDValue +" has been added");
		}
		else
		{
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(badgeIDValue)) {
	                found = true;
	                System.out.println("The "+ badgeIDValue +" has been added");
	                break loop;
	            }
	        }
		}
		}
		return found;
	}

	public static boolean isEdited() {
		Select regionValue = new Select(Browser.instance.findElement(badgeDropdown));
		Boolean found = false;
		try {
			regionValue.selectByVisibleText(badgeIDValue);
			found=true;
		}
		catch (NoSuchElementException e) {
			found=false;
		}

		return found;
	}

	public static void editAndCancelEmployee() {
		Select regionValue = new Select(Browser.instance.findElement(badgeDropdown));
		regionValue.selectByVisibleText(badgeIDValue);
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(eidfield).sendKeys(badgeIDValue+"test");
		Browser.instance.findElement(cancelButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +badgeIDValue);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	public static boolean checkProperErrorMessage() 
	{
		boolean returnValue = false;
		String textMessage;
		switch(errorMessageScenario) { 
    case 1: 
    	{textMessage = "Cannot save [ Employee ] record. There is already one with this EID.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		 returnValue = true;}
    	
    	break;}
    case 2: 
    	{textMessage = "There can only be (1) active badge.";
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


	public static void addEmployeeAgain() {
		Browser.instance.findElement(addNew).click();
		//badgeIDValue = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(firstNameField).sendKeys(eIDValue);
		Browser.instance.findElement(lastNameField).sendKeys(eIDValue);
		Browser.instance.findElement(eidfield).sendKeys(eIDValue);
		Browser.instance.findElement(eidfield).sendKeys(Keys.TAB);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		errorMessageScenario = 1;
	}

	public static void addBadgeAgain() {
		Select regionValue = new Select(Browser.instance.findElement(badgeDropdown));
		regionValue.selectByVisibleText(badgeIDValue);
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addBadgeButton));
		Browser.instance.findElement(addBadgeButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(badgeField));
		Browser.instance.findElement(badgeField).click();
		Browser.instance.findElement(badgeField).sendKeys(badgeIDValue+"1");
		Browser.instance.findElement(badgeField).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.elementToBeClickable(badgeConfirmationButton));
		Browser.instance.findElement(badgeConfirmationButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBadgeButton));
		Browser.instance.findElement(saveBadgeButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		errorMessageScenario = 2;
	}

	
	
}
