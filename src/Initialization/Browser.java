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

		if (browserName.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", DataProvider.getValueOf("Driver Path")+"\\chromeDriver.exe");
		instance = new ChromeDriver();
		instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
		if (browserName.equalsIgnoreCase("IE"))
		{
		System.setProperty("webdriver.ie.driver", DataProvider.getValueOf("Driver Path")+"\\IEDriverServer.exe");
		instance = new InternetExplorerDriver();
		instance.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		
		else// (browserName.equalsIgnoreCase("Firefox")) 
		{
		System.setProperty("webdriver.gecko.driver", DataProvider.getValueOf("Driver Path")+"\\geckodriver.exe");
		instance = new FirefoxDriver();
		instance.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
		instance.manage().window().maximize();
	}
	
	public static void instanceClose()
	{
	//instance.close();
		instance.quit();
	}
}