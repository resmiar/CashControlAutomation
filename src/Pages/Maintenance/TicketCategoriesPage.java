package Pages.Maintenance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Pages.GLAccountStringBuilderPage;

public class TicketCategoriesPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By editButton = By.xpath("(//button[@type='button'])[4]");
	static By saveButton = By.xpath("(//button[@type='button'])[5]");
	static By cancelButton = By.xpath("(//button[@type='button'])[6]");
	static By exitButton = By.xpath("(//button[@type='button'])[7]");
	static By ticketCategoryField = By.name("ddlCategories");
	static By attendanceGLStringButton = By.xpath("(//button[@type='button'])[8]");
	static By revenueGLStringButton = By.xpath("(//button[@type='button'])[9]");
	static By attendanceGLStringField = By.xpath("(//button[@type='button'])[8]");
	static By revenueGLStringField = By.xpath("(//button[@type='button'])[9]");
	static By confirmYesButton = By.xpath("(//button[@type='button'])[11]");
	static String newString, initialString, ticketCategoryName;
	static int scenario;

	
	public static void close() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();	
	}

	public static void editAttendanceString() {
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		scenario = 1;
		
		ticketCategoryName = Browser.instance.findElement(ticketCategoryField).getText();
		getTheInitialStringValue();
		Browser.instance.findElement(revenueGLStringButton).click();
		newString = GLAccountStringBuilderPage.createStringAndReturnString();
		
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the attendance account string: ");
		wait.until(ExpectedConditions.elementToBeClickable(editButton));	
	}
	
	public static void editRevenueString() {
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		scenario = 2;
		
		ticketCategoryName = Browser.instance.findElement(ticketCategoryField).getText();
		getTheInitialStringValue();
		Browser.instance.findElement(attendanceGLStringButton).click();
		newString = GLAccountStringBuilderPage.createStringAndReturnString();
		
		Browser.instance.findElement(saveButton).click();
		System.out.println("Edited the revenue account string: ");
		wait.until(ExpectedConditions.elementToBeClickable(editButton));	
	}

	private static String getTheInitialStringValue() {
		return Browser.instance.findElement(attendanceGLStringField).getText();
	}

	public static void goTo() {
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Ticket Maintenance"));
        Actions action = new Actions(Browser.instance);
        action.moveToElement(element).build().perform();
        
        Browser.instance.findElement(By.linkText("Ticket Categories")).click();
        WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
	}

	public static boolean isEdited() {
		boolean found = false;
		switch(scenario) { 
	    case 1: 
	    {if (newString.equals(Browser.instance.findElement(attendanceGLStringField).getText()))
	    	found = true; 
	    	resetAttendanceStringValue();
	    	break;}
	    case 2: 
	    {if (newString.equals(Browser.instance.findElement(revenueGLStringField).getText()))
	    	found = true; 
	    	resetRevenueStringValue();
	    	break;}
	}
		return found;
	}

	private static void resetRevenueStringValue() {
		// TODO Auto-generated method stub
		
	}

	private static void resetAttendanceStringValue() {
		// TODO Auto-generated method stub
		
	}

	public static void editAndCancelCategory() {
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		ticketCategoryName = Browser.instance.findElement(ticketCategoryField).getText();
		newString = getTheInitialStringValue();
		Browser.instance.findElement(attendanceGLStringButton).click();
		GLAccountStringBuilderPage.createStringAndReturnString();
		scenario = 1;
		
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		System.out.println("Cancelled editing the revenue account string: ");
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
			
	}
	
}
