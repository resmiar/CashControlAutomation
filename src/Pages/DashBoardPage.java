package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;

public class DashBoardPage {
	
	static By userNameDisplay = By.xpath("//div[@id='navbar']/ul[2]/li[3]/a/span[2]");
	static By logoutLink = By.xpath("//a[contains(text(),'Logout')]");

	public static void checkLoginUserName() {
		// TODO Auto-generated method stub
		
	}

	public static void logOut() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(userNameDisplay));
		Browser.instance.findElement(userNameDisplay).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
		Browser.instance.findElement(logoutLink).click();
		
	}

}
