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

public class ValidValuesPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By exitButton = By.xpath("(//button[@type='button'])[8]");
	static By tableNameDropdown = By.name("ddlTableNames");
	static By fieldNameDropdown = By.xpath("//div[2]/div/div/select");
	static By descriptionField = By.name("txtDescription");
	static By descriptionDropdown = By.xpath("//div[2]/div/select");
	static String newDescription;
	static String oldDescription;
	static String registerDescriptionValue = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[10]");
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("General Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Valid Values")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	public static void selectFieldName(String fieldNameValue) {
		Select tableValue = new Select(Browser.instance.findElement(tableNameDropdown));
		Select fieldValue = new Select(Browser.instance.findElement(fieldNameDropdown));
		String fieldName = fieldNameValue;
		switch (fieldName) {
		
		case ("ActivityType"):
		{
			tableValue.selectByVisibleText("BagActivity");
			fieldValue.selectByVisibleText("ActivityType");
			break;
		}
		case ("BagTime"):
		{
			tableValue.selectByVisibleText("CashTransactions");
			fieldValue.selectByVisibleText("BagTime");
			break;
		}
	}
	}

	public static void editValue() {
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		oldDescription = Browser.instance.findElement(descriptionField).getAttribute("value");
		System.out.println("Old description is: "+ oldDescription);
		newDescription = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(descriptionField).clear();
		Browser.instance.findElement(descriptionField).sendKeys(newDescription);
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
	}

	public static boolean checkIfEdited() {
		Select descriptionValue = new Select(Browser.instance.findElement(descriptionDropdown));
		Boolean found = false;
		List<WebElement> allOptions = descriptionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(newDescription)) {
	                found = true;
	                System.out.println("The "+ newDescription +" has been edited");
	                break loop;
	            }
	        }
		}
		descriptionValue.selectByVisibleText(newDescription);
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(descriptionField).clear();
		Browser.instance.findElement(descriptionField).sendKeys(oldDescription);
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		return found;
	}

	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();
	}

	public static void addBagTimeValue() {
		Browser.instance.findElement(addNew).click();
		newDescription = GenerateRandomValue.generateRandomStringtest();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		oldDescription = Browser.instance.findElement(descriptionField).getText();
		Browser.instance.findElement(descriptionField).sendKeys(newDescription);
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
	}

	public static boolean checkIfAdded() {
		Select descriptionValue = new Select(Browser.instance.findElement(descriptionDropdown));
		Boolean found = false;
		List<WebElement> allOptions = descriptionValue.getOptions();
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains(newDescription)) {
	                found = true;
	                System.out.println("The "+ newDescription +" has been added");
	                break loop;
	            }
	        }
		}
		return found;
	}

			
	
}
