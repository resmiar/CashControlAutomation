package Pages.Maintenance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class TendersPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By exchangeRateButton = By.xpath("(//button[@type='button'])[10]");
	static By addExchangeRateButton = By.xpath("(//button[@type='button'])[4]");
	static By effectiveRatefield = By.id("txtEffectiveRate");
	static By effectiveDatefield = By.name("txtEffectiveDate");		
	static By currencyDropdown = By.name("ddlCurrency");
	static By tenderClassDropdown = By.xpath("//div[3]/div/div/div/select");
	static String descriptionString;
	static By confirmYesButton = By.xpath("(//button[@type='button'])[17]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");
	static By addTenderButton = By.xpath("//button[@name='btnAddBtm']");
	static By editTenderButton = By.xpath("(//button[@type='button'])[13]");
	static By deleteTenderButton = By.xpath("(//button[@type='button'])[14]");
	static By viewTenderButton =  By.xpath("(//button[@type='button'])[15]");
	static By saveTenderButton = By.xpath("(//button[@type='button'])[2]");
	static By cancelTenderButton = By.xpath("(//button[@type='button'])[3]");
	static By tenderDescriptionField = By.name("txtTenderDescription");
			

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Tender and Bag Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Currencies/Tenders")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}

	public static void addNewTenderToAR() {
		Select currencyValue = new Select(Browser.instance.findElement(currencyDropdown));
		currencyValue.selectByVisibleText("U.S. Dollar");
		Select tenderClassValue = new Select(Browser.instance.findElement(tenderClassDropdown));
		tenderClassValue.selectByVisibleText("Accts Recv");
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(addTenderButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(cancelTenderButton));
		
		descriptionString = GenerateRandomValue.generateRandomStringtest();
		Browser.instance.findElement(tenderDescriptionField).sendKeys(descriptionString);
		Browser.instance.findElement(saveTenderButton).click();
		Browser.instance.findElement(saveButton).click();
		System.out.println("Tender added successfully: " +descriptionString);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		
	}

	public static void viewNewlyAddedTender() {
		Select currencyValue = new Select(Browser.instance.findElement(currencyDropdown));
		currencyValue.selectByVisibleText("U.S. Dollar");
		Select tenderClassValue = new Select(Browser.instance.findElement(tenderClassDropdown));
		tenderClassValue.selectByVisibleText("Accts Recv");
		selectTender(descriptionString);
		Browser.instance.findElement(viewTenderButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelTenderButton));
		if (descriptionString.equalsIgnoreCase(Browser.instance.findElement(tenderDescriptionField).getText())){
			System.out.println("Tender viewed successfully: " +descriptionString);
		}
		Browser.instance.findElement(cancelTenderButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
	}

	private static void selectTender(String tenderName) {
		List<WebElement> rows = Browser.instance.findElements(By.xpath("//*[contains(@class,'ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-0005')]//div"));
	    int iSize = rows.size();
	    System.out.println(iSize);
	    for (int i = 0; i < iSize; i++) {
	    	   	if (tenderName.equals(rows.get(i).getText())) {
	    	   		rows.get(i).click();
	    	   		break;
	                }
	           
	            }
	}

	public static void editTenderInAR() {
		Select currencyValue = new Select(Browser.instance.findElement(currencyDropdown));
		currencyValue.selectByVisibleText("U.S. Dollar");
		Select tenderClassValue = new Select(Browser.instance.findElement(tenderClassDropdown));
		tenderClassValue.selectByVisibleText("Accts Recv");
		Browser.instance.findElement(editButton).click();
		selectTender(descriptionString);
		Browser.instance.findElement(editTenderButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelTenderButton));
		descriptionString = descriptionString+"test";
		Browser.instance.findElement(tenderDescriptionField).clear();
		Browser.instance.findElement(tenderDescriptionField).sendKeys(descriptionString);
		Browser.instance.findElement(saveTenderButton).click();
		Browser.instance.findElement(saveButton).click();
		System.out.println("Tender edited successfully: " +descriptionString);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
			
	}

	public static boolean checkIfEdited() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void deleteTenderFromAR() {
		Select currencyValue = new Select(Browser.instance.findElement(currencyDropdown));
		currencyValue.selectByVisibleText("U.S. Dollar");
		Select tenderClassValue = new Select(Browser.instance.findElement(tenderClassDropdown));
		tenderClassValue.selectByVisibleText("Accts Recv");
		Browser.instance.findElement(editButton).click();
		selectTender(descriptionString);
		Browser.instance.findElement(deleteTenderButton).click();
		Browser.instance.findElement(confirmYesButton).click();
		
		
	}

	

	public static void selectUSDollar() {
		Select currencyValue = new Select(Browser.instance.findElement(currencyDropdown));
		currencyValue.selectByVisibleText("U.S. Dollar");
		
	}

	public static void openExchangeRateForm() {
		Browser.instance.findElement(exchangeRateButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addExchangeRateButton));
		
	}

	public static void addNewRate() {
		Browser.instance.findElement(addExchangeRateButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(effectiveRatefield));
		Browser.instance.findElement(effectiveRatefield).sendKeys("1");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 	 		 
		String dateString = dateFormat.format(date);
		Browser.instance.findElement(effectiveDatefield).sendKeys(dateString);
		Browser.instance.findElement(saveTenderButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveTenderButton));
		
		
	}

	public static boolean checkIfRateAdded() {
		// find the rate and also delete it
		return true;
	}

	public static void closeRateForm() {
		Browser.instance.findElement(saveTenderButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(exchangeRateButton));
		
	}
	
	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		if(Browser.instance.findElement(exitButton).isDisplayed())
		{
			if(Browser.instance.findElement(exitButton).isEnabled())
			{
				Browser.instance.findElement(exitButton).click();
			}
			else
			{
				Browser.instance.findElement(cancelButton).click();
				wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
				Browser.instance.findElement(confirmYesButton).click();
				wait.until(ExpectedConditions.elementToBeClickable(editButton));
				Browser.instance.findElement(exitButton).click();
			}
		}
		else
		{ 
			wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
			wait.until(ExpectedConditions.elementToBeClickable(editButton));
			Browser.instance.findElement(exitButton).click();
		}
					
	}

}
