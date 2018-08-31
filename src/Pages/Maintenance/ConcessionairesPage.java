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

public class ConcessionairesPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By addNew = By.xpath("(//button[@type='button'])[4]");
	static By editButton = By.xpath("(//button[@type='button'])[5]");
	static By saveButton = By.xpath("(//button[@type='button'])[6]");
	static By cancelButton = By.xpath("(//button[@type='button'])[7]");
	static By deleteButton = By.xpath("(//button[@type='button'])[8]");
	static By exitButton = By.xpath("(//button[@type='button'])[9]");
	static By concField = By.xpath("//input[@type='text']");
	static By concDropdown = By.name("ddlConcessionaire");
	static String concName = GenerateRandomValue.generateRandomStringtest();
	static By confirmYesButton = By.xpath("(//button[@type='button'])[13]");
	static int errorMessageScenario;
	static By errorMessageDiv = By.xpath("//div[@class='full-width-form']");

	public static void addNew() {
		Browser.instance.findElement(addNew).click();
		Browser.instance.findElement(concField).sendKeys(concName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Added the Concessionaire: " +concName);
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
		Select regionValue = new Select(Browser.instance.findElement(concDropdown));
		regionValue.selectByVisibleText(concName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
		Browser.instance.findElement(deleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Deleted the Concessionaire: " +concName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static void editRegion() {
		Select concValue = new Select(Browser.instance.findElement(concDropdown));
		concValue.selectByVisibleText(concName);
		concName = concName+"test";
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(concField));
		Browser.instance.findElement(concField).clear();
		Browser.instance.findElement(concField).sendKeys(concName);
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the Concessionaire: " +concName);
		//regionName = regionName.substring(0, regionName.length() - 4);
				wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Sales and Tax Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform(); 
        Browser.instance.findElement(By.linkText("Concessionaires")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));
	}

	public static boolean isAdded() {
		Select concValue = new Select(Browser.instance.findElement(concDropdown));
		Boolean found = false;
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		if (concName.equals(concValue.getFirstSelectedOption().getText()))
		{
			found = true;
		}
		else
		{
			List<WebElement> allOptions = concValue.getOptions();
			loop:
				for (WebElement we : allOptions) {
					for (int i = 0; i < allOptions.size(); i++) {
						if (we.getText().contains(concName)) {
							found = true;
							System.out.println("The "+ concName +" has been added");
							break loop;
						}
					}
				}
		}
		return found;
	}

	public static boolean isEdited() {
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Select concValue = new Select(Browser.instance.findElement(concDropdown));
		Boolean found = false;
		if (concName.equals(concValue.getFirstSelectedOption().getText()))
		{
			found = true;
		}
		else
		{
			List<WebElement> allOptions = concValue.getOptions();
			loop:
				for (WebElement we : allOptions) {
					for (int i = 0; i < allOptions.size(); i++) {
						if (we.getText().contains(concName)) {
							found = true;
							System.out.println("The "+ concName +" has been edited");
							break loop;
						}
					}
				}
		}
		return found;
	}

	public static void editAndCancelRegion() {
		Select concValue = new Select(Browser.instance.findElement(concDropdown));
		concValue.selectByVisibleText(concName);
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(concField));
		Browser.instance.findElement(concField).clear();
		Browser.instance.findElement(concField).sendKeys(concName+"test");
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Editing Cancelled for: " +concName);
		wait.until(ExpectedConditions.elementToBeClickable(addNew));	
	}
		

	

	
}
