package Initialization;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser 
{

	public static WebDriver instance;
	
	public static void initialize(String browserName)
	{

		if (browserName.equalsIgnoreCase("Firefox")) 
		{
		System.setProperty("webdriver.gecko.driver", "E:\\Automation\\Selenium\\Drivers\\geckodriver.exe");
		instance = new FirefoxDriver();
		instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
		if (browserName.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Selenium\\Drivers\\chromeDriver.exe");
		instance = new ChromeDriver();
		instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
		if (browserName.equalsIgnoreCase("IE"))
		{
		System.setProperty("webdriver.ie.driver", "E:\\Automation\\Selenium\\Drivers\\IEDriverServer.exe");
		instance = new InternetExplorerDriver();
		instance.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		instance.manage().window().maximize();
	}
	
	public static void instanceClose()
	{
	//instance.close();
		instance.quit();
	}
}