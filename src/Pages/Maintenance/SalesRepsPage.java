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

public class SalesRepsPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By firsrNamefield = By.name("txtFirstName");
	static By lastNamefield = By.xpath("(//input[@type='text'])[2]");
	static By nameDropdown = By.name("ddlSalesReps");
	static String firstame = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[11]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void addNew() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(firsrNamefield).clear();
		Browser.instance.findElement(firsrNamefield).sendKeys(firstame);
		Browser.instance.findElement(lastNamefield).clear();
		Browser.instance.findElement(lastNamefield).sendKeys("1");
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the region: " +firstame);
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
		Select regionValue = new Select(Browser.instance.findElement(nameDropdown));
		regionValue.selectByVisibleText("1, " +firstame);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the region: " +firstame);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editRegion() {
		Select regionValue = new Select(Browser.instance.findElement(nameDropdown));
		regionValue.selectByVisibleText("1, " +firstame);
		firstame = firstame+"test";
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(firsrNamefield).sendKeys(firstame);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the region: " +firstame);
		//regionName = regionName.substring(0, regionName.length() - 4);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Ticket Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Sales Reps")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static boolean isAdded() {
		Select regionValue = new Select(Browser.instance.findElement(nameDropdown));
		Boolean found = false;
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains("1, " +firstame)) {
	                found = true;
	                System.out.println("The "+ firstame +" has been added");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static boolean isEdited() {
		Select regionValue = new Select(Browser.instance.findElement(nameDropdown));
		Boolean found = false;
		List<WebElement> allOptions = regionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(firstame)) {
	                found = true;
	                System.out.println("The "+ firstame +" has been edited");
	                break loop;
	            }
	        }
		}
		return found;
	}

	public static void editAndCancelRegion() {
		Select regionValue = new Select(Browser.instance.findElement(nameDropdown));
		regionValue.selectByVisibleText("1, " +firstame);
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(firsrNamefield).sendKeys(firstame+"test");
		Browser.instance.findElement(cancelButton).click();
				wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +firstame);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	
	}




