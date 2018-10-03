package Pages.TellerTransactions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;

public class CheckInBagsPage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By bagIDField = By.id("bagAlias");
	static By BagCheckInButton=By.xpath("(//button[@type='button'])[5]");	
	static By BagIdItemSelectionList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid')]");
	static By SelectButton=By.xpath("//button[.='Select']");
	static By BufferImg=By.xpath("(//img)[1]");
	static By DiffWorkingDateConfirm=By.xpath("//button[.='OK']");
	
	
	//Go to Check In Bags Page
	public static void goTo() {
		try {
			Browser.instance.findElement(TransactionsMenu).click();
		}
		catch(Exception e)
		{
			System.out.println("Element not clickable exception handled for Transactions Menu");
			Browser.instance.findElement(TransactionsMenu).click();
		}
		
		WebElement element = Browser.instance.findElement(By.linkText("Teller Transactions"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Check In Bags")).click();
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
	
		}
	
	
	//Check in a Bag
	public static void CheckInBag() throws Exception
	{
		String BagID = TenderEntryPage.getBagID();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	   
		Browser.instance.findElement(bagIDField).click();
		Browser.instance.findElement(bagIDField).sendKeys(BagID);
		Browser.instance.findElement(bagIDField).sendKeys(Keys.TAB);
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		 //Robot robot = new Robot();
			//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		 
	}
	
	//Exit Page
	public static void Exit()
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(exitButton).click();
		  wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		
	}
	
	//Select a bag
	public static void SelectItem(String BagId,By Locator) {
		List<WebElement> rows = Browser.instance.findElements(Locator);
	    int iSize = rows.size();
	    if (iSize!=0) 
	    {
	    for (int i = 0; i < iSize; i++) 
	    {
	        String sValue = rows.get(i).getText(); 
	        
	                if (sValue.equalsIgnoreCase((BagId))) 
	                {
	                    rows.get(i).click();
	                    break;
	                }
	                }
	    }
	    else {
	    	System.out.println("Grid cell element not found");
	    }
	    
	    
	   }
	
}
