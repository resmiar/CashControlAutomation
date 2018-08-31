package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Initialization.GenerateRandomValue;

public class GLAccountStringBuilderPage {

	static By departmentCodeField = By.xpath("//select");
	static By naturalAccountCodeField = By.xpath("//div[3]/div/select");
	static By activityCenterCodeField = By.xpath("//div[5]/div/select");
	static By projectCodeField = By.xpath("//div[7]/div/select");
	static By okButton = By.xpath("//button[@name='btnOk']");
	static By stringField = By.xpath("//input[@type='text']");
	static int index ;
	
	public static void createString() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(departmentCodeField));
		index = GenerateRandomValue.generateRandomInteger();
		Select departmentCode = new Select(Browser.instance.findElement(departmentCodeField));
		departmentCode.selectByIndex(index);
		Select naturalAccountCode = new Select(Browser.instance.findElement(naturalAccountCodeField));
		naturalAccountCode.selectByIndex(index);
		Select activityCenterCode = new Select(Browser.instance.findElement(activityCenterCodeField));
		activityCenterCode.selectByIndex(index);
		Select projectCode = new Select(Browser.instance.findElement(projectCodeField));
		projectCode.selectByIndex(index);
		Browser.instance.findElement(okButton).click();
	}
	
	public static String createStringAndReturnString() {
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(departmentCodeField));
		index = GenerateRandomValue.generateRandomInteger();
		Select departmentCode = new Select(Browser.instance.findElement(departmentCodeField));
		departmentCode.selectByIndex(index);
		Select naturalAccountCode = new Select(Browser.instance.findElement(naturalAccountCodeField));
		naturalAccountCode.selectByIndex(index);
		Select activityCenterCode = new Select(Browser.instance.findElement(activityCenterCodeField));
		activityCenterCode.selectByIndex(index);
		Select projectCode = new Select(Browser.instance.findElement(projectCodeField));
		projectCode.selectByIndex(index);
		String glString = Browser.instance.findElement(stringField).getText();
		Browser.instance.findElement(okButton).click();
		return glString;
	}
}
