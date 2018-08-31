package Pages.Maintenance;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;

public class CashControlPage {
	
	static By ccGroupfield = By.xpath("//select");
	static By dateValue = By.name("txtCcDate");
	static By okButton = By.xpath("//button[contains(text(),'OK')]");
	static Select ccGroup = new Select(Browser.instance.findElement(ccGroupfield));
	
	public static boolean isAt() 
	{		boolean ccLogin = false;
		try {
			Browser.instance.findElement(dateValue);
	        ccLogin = true;
	        System.out.println("End of try block"); }
	    catch(Exception e){
	    	System.out.println("Inside catch block");
	    	 ccLogin = false; }
		return ccLogin;
	}
	
	public static void loginToACCGroup() 
	{
		Browser.instance.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(dateValue));
		ccGroup.selectByIndex(0);
		Browser.instance.findElement(dateValue).sendKeys("05012018");
		Browser.instance.findElement(okButton).click();
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
