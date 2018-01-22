package Initialization;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser 
{

	public static WebDriver instance;
	
	public static void initialize()
	{
	System.setProperty("webdriver.gecko.driver", "E:\\Automation\\Selenium\\Drivers\\geckodriver.exe");
	instance = new FirefoxDriver();
	instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void instanceClose()
	{
	instance.close();
	}
}