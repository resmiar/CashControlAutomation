package Pages.Maintenance;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.GenerateRandomValue;

public class PLUsPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addButton = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By pludropdown = By.name("ddlPlueCodes");
	static By plufield = By.name("txtPluCode");
	static By pluDescriptionField = By.xpath("//input[@ng-model='selectedObjects.txtPLUDescription']");
	static By notTaxableOption = By.id("rdbNotTaxAble");
	static By includeTaxOption = By.id("rdbIncludeTax");
	static By plusTaxOption = By.id("rdbPlusTax");
	static By taxScheduleDropdown;
	static By rebateDropdown;
	static By admissionField = By.id("txtAdmission");
	static By revenueValue;
	static By rebateValue;
	static By taxValue;
	static By priceValue;
	static By removeTicketPartButton;
	static String descriptionString;
	static By loadingIcon = By.xpath("//div[@class='data-loading-PLU ng-hide']");
	static By confirmYesButton = By.xpath("(//button[@type='button'])[18]");
	
	

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Ticket Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("PLU's")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(addButton));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));						
	}

	public static void addNewPLU() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(addButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		descriptionString = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(plufield).sendKeys(descriptionString);
		Browser.instance.findElement(pluDescriptionField).sendKeys(descriptionString);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the PLU: " +descriptionString);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	}

	public static boolean checkIfAdded() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean checkIfEdited() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void editPLU() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Select regionValue = new Select(Browser.instance.findElement(pludropdown));
		regionValue.selectByVisibleText(descriptionString.toUpperCase());
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(editButton).click();
		
	}

	public static void deletePLU() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Select regionValue = new Select(Browser.instance.findElement(pludropdown));
		regionValue.selectByVisibleText(descriptionString.toUpperCase());
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the Concessionaire: " +descriptionString);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		
	}

	
	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();
		
	}

	public static void clickEdit() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Select regionValue = new Select(Browser.instance.findElement(pludropdown));
		regionValue.selectByVisibleText(descriptionString.toUpperCase());
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(editButton).click();
	}

	public static void deleteTicketPart() {
		// TODO Auto-generated method stub
		
	}

	public static void closeTheMessage() {
		// TODO Auto-generated method stub
		
	}

	public static void cancelEditing() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Select regionValue = new Select(Browser.instance.findElement(pludropdown));
		regionValue.selectByVisibleText(descriptionString.toUpperCase());
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(editButton).click();
	}

	public static void addPLUAgain() {
		// TODO Auto-generated method stub
		
	}

	public static void verifyErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	public static void clickAdd() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(addButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	}

	public static void setValuesForTaxAndRebate() {
		// TODO Auto-generated method stub
		
	}

	public static void checkCalculationForNoTax() {
		// TODO Auto-generated method stub
		
	}
	

	public static void checkCalculationForTaxIncluded() {
		// TODO Auto-generated method stub
		
	}

	public static void checkCalculationForPlusTax() {
		// TODO Auto-generated method stub
		
	}

	public static void cleanUpTaxAndRebate() {
		// TODO Auto-generated method stub
		
	}

}
