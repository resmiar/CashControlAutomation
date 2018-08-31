/*
*UserLoginPage
*
*Version 1.00
*/
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.DataProvider;

public class UserLoginPage 
{
	static By userName = By.name("txtUsername");
	static By password = By.xpath("//input[@type = 'password']");
	static By loginButton = By.xpath("//button[@type = 'button']");
	static By domainLogin = By.xpath("//input[@type='submit']");
	
	public static void goTo() 
	{
	Browser.instance.get(DataProvider.getValueOf("Application URL"));
	WebDriverWait wait = new WebDriverWait(Browser.instance,60);
	wait.until(ExpectedConditions.elementToBeClickable(userName));
	}

	public static void loginWithValidCredentials() 
	{
	Browser.instance.findElement(userName).sendKeys(DataProvider.getValueOf("CCS UserName"));	
	Browser.instance.findElement(password).sendKeys(DataProvider.getValueOf("Password"));
	Browser.instance.findElement(loginButton).click();
	}
}
