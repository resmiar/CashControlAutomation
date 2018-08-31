package Pages.TellerTransactions;

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

public class CheckoutBagsPage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By BadgeDropdown=By.xpath("//select[@name='ddlBadge']");
	static By saveButton=By.name("btnSave");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By locationDropdown = By.xpath("//select[@data-ng-model='lstSelectedLocCodes.locationId']");
	static By locationAllRadio = By.id("rdoAll");
	static By locationRecentRadio = By.id("rdoRecent");
	static By bagTypeDropdown = By.xpath("//select[@data-ng-model='lstBagTypes.bagTypeId']");
	static By systemBags = By.id("rdoSystemBag");
	static By parkAssignedBags = By.id("rdoParkAssigned");
	static By bagField = By.id("bagAlias");
	static By bagQty = By.name("bagsQty");
	static By bagLookup = By.name("btnBagItems");
	static String Select=null;
	static By confirmYesButton = By.xpath("(//button[@type='button'])[8]");
	static String bagID;
	static By clearFormCheckBox = By.xpath("//input[@data-ng-model='clearScreenControls']");
	
	public static void goTo() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,30);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(exitButton));
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		Browser.instance.findElement(TransactionsMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Teller Transactions"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Check Out Bags")).click();
	    //WebDriverWait wait = new WebDriverWait(Browser.instance,30);
		wait.until(ExpectedConditions.elementToBeClickable(BadgeDropdown));
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}

	public static void checkoutbagToCheckStatus(String BagID) {
		bagID = BagID;
		selectBadgeAndLoc();
		WebDriverWait wait = new WebDriverWait(Browser.instance,40);
		wait.until(ExpectedConditions.elementToBeClickable(bagTypeDropdown));
		selectBag();
		System.out.println("Going to enter the bag value: " +bagID);
		Browser.instance.findElement(bagField).click();
		Browser.instance.findElement(bagField).clear();
		Browser.instance.findElement(bagField).sendKeys(bagID);
		Browser.instance.findElement(bagField).sendKeys(Keys.TAB);
		saveCheckout();
	}

	public static void close() {
		//if (Browser.instance.findElement(confirmYesButton).isDisplayed())
		//{
		//	Browser.instance.findElement(confirmYesButton).click();
		//}
		Browser.instance.findElement(exitButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
	}

	public static void selectBadgeAndLoc() {
		Select badgeValue= new Select(Browser.instance.findElement(BadgeDropdown));
		badgeValue.selectByIndex(GenerateRandomValue.generateRandomNumber());
		Browser.instance.findElement(locationRecentRadio).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select locationValue= new Select(Browser.instance.findElement(locationDropdown));
		locationValue.selectByIndex(1);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void selectBag() {
		Select bagTypeValue= new Select(Browser.instance.findElement(bagTypeDropdown));
		bagTypeValue.selectByVisibleText("AutomationTestBagType");
		System.out.println("Going to enter the bag value: " +bagID);
		Browser.instance.findElement(bagField).click();
		Browser.instance.findElement(bagField).clear();
		Browser.instance.findElement(bagField).sendKeys(bagID);
		Browser.instance.findElement(bagField).sendKeys(Keys.TAB);
		
		
	}

	public static void saveCheckout() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Browser.instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Browser.instance.findElement(saveButton).click();
		//Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//if (Browser.instance.findElement(confirmYesButton).isDisplayed())
		//{
		//	Browser.instance.findElement(confirmYesButton).click();
		//}
		WebDriverWait wait = new WebDriverWait(Browser.instance,40);
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(saveButton)));
		//wait.until(ExpectedConditions.attributeToBe(saveButton, "disabled", "disabled"));
	}

	public static boolean isBagCheckedOut() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void selectSystemBag(int i) {
		Browser.instance.findElement(systemBags).click();
		System.out.println("Going to enter the bag value: " +i);
		Browser.instance.findElement(bagQty).click();
		Browser.instance.findElement(bagQty).clear();
		Browser.instance.findElement(bagQty).sendKeys(String.valueOf(i));
		Browser.instance.findElement(bagQty).sendKeys(Keys.TAB);
	}

	public static void selectBadgeAndRecentLoc() {
		Select badgeValue= new Select(Browser.instance.findElement(BadgeDropdown));
		badgeValue.selectByIndex(GenerateRandomValue.generateRandomNumber());
		Browser.instance.findElement(locationAllRadio).click();
		//WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		//wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select locationValue= new Select(Browser.instance.findElement(locationDropdown));
		locationValue.selectByIndex(2);
		//locationValue.selectByIndex(GenerateRandomValue.generateRandomNumber());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void BuildBagForCheckout() {
		BuildBagsPage.goTo();
		bagID = BuildBagsPage.BuildBagForCheckout();
		BuildBagsPage.close();
	}

}
