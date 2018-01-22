package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import Initialization.Browser;

public class CashControlPage {
	
	static By ccGroupfield = By.xpath("//select");
	static By dateValue = By.name("txtCcDate");
	static By okButton = By.xpath("//button[contains(text(),'OK')]");
	static Select ccGroup = new Select(Browser.instance.findElement(ccGroupfield));
	
	public static boolean isAt() 
	{		
		// TODO Auto-generated method stub
		return true;
	}
	
	public static void loginToACCGroup() 
	{
		ccGroup.selectByIndex(0);
		Browser.instance.findElement(dateValue).sendKeys("01012018");
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
