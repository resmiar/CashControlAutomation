package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.GenerateRandomValue;

public class RegistersPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By exitButton = By.xpath("(//button[@type='button'])[8]");
	static By registerfield = By.name("txtRegister");
	static By registerDropdown = By.name("ddlRegister");
	static By registerDescription = By.xpath("(//input[@type='text'])[2]");
	static String registerName = GenerateRandomValue.generateRandomStringtest();
	static String registerDescriptionValue = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[10]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void addNew() {
		registerName = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(registerfield).sendKeys(registerName);
		Browser.instance.findElement(registerDescription).sendKeys(registerDescriptionValue);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Region added successfully: " +registerName);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();	
	}

	
	public static void editRegion() {
		Select regionValue = new Select(Browser.instance.findElement(registerDropdown));
		regionValue.selectByVisibleText(registerName);
		registerName = registerName+"test";
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(registerfield).sendKeys(registerName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Region edited successfully: " +registerName);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Location Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("POS / Registers")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	public static boolean isAdded() {
		Select regionValue = new Select(Browser.instance.findElement(registerDropdown));
		regionValue.selectByVisibleText(registerName);
		return true;
	}

	public static boolean isEdited() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void editAndCancelRegister() {
		Select regionValue = new Select(Browser.instance.findElement(registerDropdown));
		regionValue.selectByVisibleText(registerName);
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(registerfield).sendKeys(registerName+"test");
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +registerName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	public static boolean checkProperErrorMessage() 
	{
		boolean returnValue = false;
		String textMessage;
		switch(errorMessageScenario) { 
    case 1: 
    	textMessage = "Region already exist.";
    	if (Browser.instance.findElement(errorMessageDiv).getText()==textMessage)
    		 returnValue = true;
    	else returnValue = false;
    	
    case 2: 
    	textMessage = "Please enter region.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	System.out.println(actualMessage);
    	if (actualMessage==textMessage) {
    		System.out.println(Browser.instance.findElement(errorMessageDiv).getText());
    		  returnValue = true;}
    		
		}
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(cancelButton).click();
		Browser.instance.findElement(confirmYesButton).click();
		return true;	
	}

	public static void addNewWithBlankDescription() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(saveButton).click();
		errorMessageScenario = 2;
		
	}

	public static void addRegisterAgain() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(registerfield).sendKeys(registerName);
		Browser.instance.findElement(saveButton).click();
		errorMessageScenario = 1;
	}
	
	}



