package Pages;

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
	static By regionfield = By.name("txtRegion");
	static By regionDropdown = By.name("ddlRegions");
	static String regionName = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[12]");

	public static void addNew() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(regionfield).sendKeys(regionName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Region added successfully: " +regionName);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void close() {
		Browser.instance.findElement(exitButton).click();	
	}

	public static void deleteLastAdded() {
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		regionValue.selectByVisibleText(regionName);
		Browser.instance.findElement(deleteButton).click();
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Region deleted successfully: " +regionName);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editRegion() {
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		regionValue.selectByVisibleText(regionName);
		regionName = regionName+"test";
		Browser.instance.findElement(editButton).click();
		Browser.instance.findElement(regionfield).sendKeys(regionName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Region edited successfully: " +regionName);
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
		Select regionValue = new Select(Browser.instance.findElement(regionDropdown));
		regionValue.selectByVisibleText(regionName);
		return true;
	}

	public static boolean isEdited() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void editAndCancelRegion() {
		// TODO Auto-generated method stub
		
	}

	public static boolean checkProperErrorMessage() {
		// use switch case for 2 scenarios - blank desc and duplicate - use same method
		return false;
	}

	public static void addNewWithBlankDescription() {
		// TODO Auto-generated method stub
		
	}
	
	}






