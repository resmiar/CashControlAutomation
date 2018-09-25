package Pages.Maintenance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;

public class OptionsPage {



	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
    static By editButton=By.xpath("//span[.='Edit']");
    static By saveButton=By.xpath("//span[.='Save']");
    static By exitButton=By.xpath("//span[.='Exit']");
    static By TransactionsTab=By.xpath("(//a[.='Transactions'])[2]");
    static By ExclusiveLocationCheckBox=By.xpath("//input[@data-ng-model='defByLocation']");
    static By ApplySalestoBagCheckBox=By.xpath("//input[@data-ng-model='defByBag']");
    
    //Go To Options Page
	public static void goTo() {

		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("General Maintenance"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Options")).click();
	   // WebDriverWait wait = new WebDriverWait(Browser.instance,10);
	    WebDriverWait wait = new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	}
	
	
	//Enable Transaction checkboxes
	public static void EnableTransactionsCheckboxes() throws Exception
	{
		
		
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		try {
			Browser.instance.findElement(editButton).click();
			 Thread.sleep(1000);
		}
		catch(Exception w)
		{
			Browser.instance.findElement(editButton).click();
		}
		
		  Thread.sleep(1000);
		Browser.instance.findElement(TransactionsTab).click();
		Thread.sleep(1000);
		Browser.instance.findElement(editButton).click();
		  Thread.sleep(1000);
		if(Browser.instance.findElement(ExclusiveLocationCheckBox).isSelected()==false)
		{
			System.out.println("Clicking Exclusive Location checkbox ");
			
				Browser.instance.findElement(ExclusiveLocationCheckBox).click();
			Browser.instance.findElement(saveButton).click();
		
			}
		
		else
		{
			System.out.println("Exclusive Location checkbox is already clicked");
			Browser.instance.findElement(saveButton).click();
			
		}
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(editButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		if(Browser.instance.findElement(ApplySalestoBagCheckBox).isSelected()==false)
		{
			Browser.instance.findElement(ApplySalestoBagCheckBox).click();
			System.out.println("Clicking on Apply sales to bag checkbox ");
			Browser.instance.findElement(saveButton).click();
			
			
		}
		else
		{
			System.out.println("Apply sales to bag checkbox  is already clicked");
			Browser.instance.findElement(saveButton).click();
			
			
		}
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(maintenanceMenu));
		
		
	}
	
	


}





