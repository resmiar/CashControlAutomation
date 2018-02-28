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

public class ActivityCenterGroupsPage {
		
		static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
		static By addNew = By.xpath("(//button[@type='button'])[4]");
		static By editButton = By.xpath("(//button[@type='button'])[5]");
		static By saveButton = By.xpath("(//button[@type='button'])[6]");
		static By cancelButton = By.xpath("(//button[@type='button'])[7]");
		static By deleteButton = By.xpath("(//button[@type='button'])[8]");
		static By exitButton = By.xpath("(//button[@type='button'])[9]");
		static By acGroupfield = By.name("txtAcGroupDesc");
		static By acGroupDropdown = By.xpath("//div[2]/div/select");
		static By ownedRadio = By.xpath("//input[@name='optionsRadios']");	
		static By LeasedRadio = By.xpath("(//input[@name='optionsRadios'])[2]");
		static By parkDropdown = By.name("ddlPark");
		static By activeCheckbox = By.xpath("//div[2]/div/div/div/label/input");
		static String ACGroupName; 
		static By confirmYesButton = By.xpath("(//button[@type='button'])[11]");
		static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");
		static String errorMessage; 

		public static void addAsActiveAndOwnedACGroup() {
			Browser.instance.findElement(addNew).click();
			ACGroupName = GenerateRandomValue.generateRandomStringtest();
			Browser.instance.findElement(acGroupfield).sendKeys(ACGroupName);
			Browser.instance.findElement(ownedRadio).click(); 
			Browser.instance.findElement(saveButton).click();
			System.out.println("AC Group has been added successfully: " +ACGroupName);
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
		}
		public static void addAsInactiveAndLeasedACGroup() {
			Browser.instance.findElement(addNew).click();
			ACGroupName = GenerateRandomValue.generateRandomStringtest();
			Browser.instance.findElement(acGroupfield).sendKeys(ACGroupName);
			Browser.instance.findElement(LeasedRadio).click(); 
			Browser.instance.findElement(activeCheckbox).click(); 
			Browser.instance.findElement(saveButton).click();
			System.out.println("AC Group has been added successfully: " +ACGroupName);
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
		}

		public static void closeACGroup() {
			Browser.instance.findElement(exitButton).click();	
		}

		public static void deleteLastAddedACGroup() {
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
			
			Select acGroupValue = new Select(Browser.instance.findElement(acGroupDropdown));
			acGroupValue.selectByVisibleText(ACGroupName);
			String currentValue = acGroupValue.getFirstSelectedOption().getText();
			
			if(currentValue.equalsIgnoreCase(ACGroupName)) {
			Browser.instance.findElement(deleteButton).click();
			Browser.instance.findElement(confirmYesButton).click();
			System.out.println("AC Group has been deleted successfully: " +ACGroupName);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));}
		}

		public static void editACGroup() {
			Select acGroupValue = new Select(Browser.instance.findElement(acGroupDropdown));
			acGroupValue.selectByVisibleText(ACGroupName);
			ACGroupName = ACGroupName+"test";
			Browser.instance.findElement(editButton).click();
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			Browser.instance.findElement(acGroupfield).clear();
			Browser.instance.findElement(acGroupfield).sendKeys(ACGroupName);
			Browser.instance.findElement(saveButton).click();
			System.out.println("AC Group has been edited successfully: " +ACGroupName);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
		}

		public static void goTo() {
			Browser.instance.findElement(maintenanceMenu).click();
			WebElement element = Browser.instance.findElement(By.linkText("Location Maintenance"));
	        Actions action = new Actions(Browser.instance);
	        action.moveToElement(element).build().perform(); 
	        Browser.instance.findElement(By.linkText("Activity Center Groups")).click();
	        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
		}

		public static boolean isAdded() {
			Select acGroupValue = new Select(Browser.instance.findElement(acGroupDropdown));
			Boolean found = false;
			List<WebElement> allOptions = acGroupValue.getOptions();
			loop:
			for (WebElement we : allOptions) {
		        for (int i = 0; i < allOptions.size(); i++) {
		        	    if (we.getText().contains(ACGroupName)) {
		                found = true;
		                System.out.println("The "+ ACGroupName +" has been added");
		                break loop;
		            }
		        }
			}
			
			return found;
		}

		public static boolean isEdited() {
			Select acGroupValue = new Select(Browser.instance.findElement(acGroupDropdown));
			Boolean found = false;
			System.out.println("Checking for "+ ACGroupName );
			List<WebElement> allOptions = acGroupValue.getOptions();
			loop:
			for (WebElement we : allOptions) {
		        for (int i = 0; i < allOptions.size(); i++) {
		            if (we.getText().contains(ACGroupName)) {
		                found = true;
		                System.out.println("The "+ ACGroupName +" has been edited");
		                break loop;
		            }
		        }
			}
			System.out.println("value of found is " +found);
			return found;
		}

		public static void editAndCancelACGroup() {
			Select acGroupValue = new Select(Browser.instance.findElement(acGroupDropdown));
			acGroupValue.selectByVisibleText(ACGroupName);
			Browser.instance.findElement(editButton).click();
			
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			
			Browser.instance.findElement(acGroupfield).clear();
			Browser.instance.findElement(acGroupfield).sendKeys(ACGroupName+"test");
			Browser.instance.findElement(cancelButton).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
			Browser.instance.findElement(confirmYesButton).click();
			System.out.println("Editing Cancelled for: " +ACGroupName);
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
			
		}

		public static boolean checkProperErrorMessageACGroup() {
			errorMessage = "This AC Group already exist.";
			System.out.println(Browser.instance.findElement(errorMessageDiv).getText());
			String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
			System.out.println(Browser.instance.findElement(errorMessageDiv).getText());
			
			Browser.instance.findElement(confirmYesButton).click();
			
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
			
			Browser.instance.findElement(cancelButton).click();
			Browser.instance.findElement(confirmYesButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(addNew));
			
			if (actualMessage.equals(errorMessage)) {
				return true;
			} 
			else return false;
		}
	    	
		public static void addACGroupAgain() {
			Browser.instance.findElement(addNew).click();
			Browser.instance.findElement(acGroupfield).sendKeys(ACGroupName);
			Browser.instance.findElement(ownedRadio).click(); 
			Browser.instance.findElement(saveButton).click();	
		}
		
		public static boolean checkProperDeleteErrorMessageACGroup() {
			
			errorMessage = "Cannot Delete because this item is used in another related item.";
			Browser.instance.findElement(deleteButton).click();
			Browser.instance.findElement(confirmYesButton).click();
			
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
			
			String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
	    	System.out.println(Browser.instance.findElement(errorMessageDiv).getText());
			
	    	Browser.instance.findElement(confirmYesButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			if (actualMessage.equals(errorMessage)) { 
			return true;}
			else return false;
		}


}
