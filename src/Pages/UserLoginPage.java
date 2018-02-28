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

public class UserLoginPage 
{
	static By userName = By.name("txtUsername");
	static By password = By.xpath("//input[@type = 'password']");
	static By loginButton = By.xpath("//button[@type = 'button']");
	static By domainLogin = By.xpath("//input[@type='submit']");
	
	public static void goTo() 
	{
	Browser.instance.get("http://192.168.6.197/CCS/");
	WebDriverWait wait = new WebDriverWait(Browser.instance,60);
	wait.until(ExpectedConditions.elementToBeClickable(userName));
	}

	public static void loginWithValidCredentials() 
	{
	Browser.instance.findElement(userName).sendKeys("SFtestuser_sysadmin");	
	Browser.instance.findElement(password).sendKeys("SFtestuser_sysadmin");
	Browser.instance.findElement(loginButton).click();
	}
}
