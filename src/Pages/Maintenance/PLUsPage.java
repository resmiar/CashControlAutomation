package Pages.Maintenance;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	static By taxScheduleDropdown=By.xpath("//select[@ng-model='selectedObjects.selectedTaxSchedule']");
	static By rebateDropdown=By.xpath("//select[@ng-model='selectedObjects.selectedPLURebates']");
	static By admissionField = By.id("txtAdmission");
	static By revenueValue=By.xpath("//input[@ng-model='selectedObjects.txtRevenue']");
	static By rebateAmountValue=By.xpath("//input[@ng-model='selectedObjects.txtRebate']");
	static By taxValue=By.xpath("//input[@ng-model='selectedObjects.txtTotalTax']");
	static By priceValue=By.xpath("//input[@ng-model='selectedObjects.txtTotalPrice']");
	static By removeTicketPartButton=By.xpath("//button[@ng-click='btnRemovePLUPartClick();']");
	static String descriptionString;
	static By loadingIcon = By.xpath("//div[@class='data-loading-PLU ng-hide']");
	static By confirmYesButton = By.xpath("(//button[@type='button'])[18]");
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");
	static double rebateAmount, taxAmount,revenueAmount,totalPrice, revenueExpectedAmount;
	

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
		boolean result = true;
		Select regionValue = new Select(Browser.instance.findElement(pludropdown));
		try {
			regionValue.selectByVisibleText(descriptionString.toUpperCase());
			}
		catch(Exception e){
			result = false;
		}
		
		return result;
	}

	public static boolean checkIfEdited() {
		boolean result = true;
		Select regionValue = new Select(Browser.instance.findElement(pludropdown));
		try {
			regionValue.selectByVisibleText(descriptionString.toUpperCase());
			}
		catch(Exception e){
			result = false;
		}
		
		return result;
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
		Browser.instance.findElement(removeTicketPartButton).click();
		
	}

	public static boolean checkTheMessage() {
		boolean returnValue = false;
		String textMessage; 
    	textMessage = "There must be a PLU Part assigned to PLU.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		 returnValue = true;
    	}
		Browser.instance.findElement(confirmYesButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		return returnValue;
	}

	public static void cancelEditing() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
	}

	public static void addPLUAgain() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(addButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(plufield).sendKeys(descriptionString);
		Browser.instance.findElement(plufield).sendKeys(Keys.TAB);
		System.out.println("Trying to add: " +descriptionString+" again");
		
	}

	public static boolean verifyErrorMessage() {
		boolean returnValue = false;
		String textMessage;
		 
    	textMessage = "There is already a PLU with this code.";
    	String actualMessage = Browser.instance.findElement(errorMessageDiv).getText();
    	if (actualMessage.equals(textMessage)) {
    		System.out.println("Inside if block");
    		 returnValue = true;
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

	public static void clickAdd() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		Browser.instance.findElement(addButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	}

	public static void setValuesForTaxAndRebate() {
		Select taxScheduleValue = new Select(Browser.instance.findElement(taxScheduleDropdown));
		taxScheduleValue.selectByIndex(1);
		Select rebateValue = new Select(Browser.instance.findElement(rebateDropdown));
		rebateValue.selectByIndex(2);
		
		Browser.instance.findElement(admissionField).clear();
		Browser.instance.findElement(admissionField).sendKeys("10");
		String temp = Browser.instance.findElement(rebateAmountValue).getAttribute("value");
		//System.out.println(temp+"temp value");
		rebateAmount = Double.parseDouble(temp);
		//rebateAmount=0.00;
	}

	public static boolean checkCalculationForNoTax() {
		boolean returnValue= false;
		Browser.instance.findElement(notTaxableOption).click();
		totalPrice = Double.parseDouble(Browser.instance.findElement(priceValue).getAttribute("value")); 
		revenueAmount=Double.parseDouble(Browser.instance.findElement(revenueValue).getAttribute("value"));
		taxAmount=Double.parseDouble(Browser.instance.findElement(taxValue).getAttribute("value"));
		revenueExpectedAmount = (totalPrice-rebateAmount);
		
		if(totalPrice==10.00 &&taxAmount== 0.00) {
			if(revenueAmount==revenueExpectedAmount) {
				returnValue = true;
			}
			
		}
		
		return returnValue;
		
		
	}
	

	public static boolean checkCalculationForTaxIncluded() {
		Browser.instance.findElement(includeTaxOption).click();
		boolean returnValue= false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalPrice = Double.parseDouble(Browser.instance.findElement(priceValue).getAttribute("value")); 
		revenueAmount=Double.parseDouble(Browser.instance.findElement(revenueValue).getAttribute("value"));
		taxAmount=Double.parseDouble(Browser.instance.findElement(taxValue).getAttribute("value"));
		totalPrice = Math.round(totalPrice*100D)/100D;
		revenueAmount=Math.round(revenueAmount*100D)/100D;
		taxAmount=Math.round(taxAmount*100D)/100D;
		revenueExpectedAmount = (totalPrice-(rebateAmount+taxAmount));
		revenueExpectedAmount=Math.round(revenueExpectedAmount*100D)/100D;
		System.out.println("expected revenue value is: "+revenueExpectedAmount);
		if(totalPrice==10.00) {
			if(revenueAmount==revenueExpectedAmount) {
				returnValue = true;
			}
			
		}
		
		return returnValue;
		
	}

	public static boolean checkCalculationForPlusTax() {
		Browser.instance.findElement(plusTaxOption).click();
		boolean returnValue= false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalPrice = Double.parseDouble(Browser.instance.findElement(priceValue).getAttribute("value"));
		revenueAmount=Double.parseDouble(Browser.instance.findElement(revenueValue).getAttribute("value"));
		taxAmount=Double.parseDouble(Browser.instance.findElement(taxValue).getAttribute("value"));
		revenueExpectedAmount = (10.00-rebateAmount);
		
		if(totalPrice==(10.00+taxAmount)) {
			if(revenueAmount==revenueExpectedAmount) {
				returnValue = true;
			}
			
		}
		
		return returnValue;
		
	}

	

}
