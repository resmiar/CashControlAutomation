package Pages.Maintenance;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Initialization.DataProvider;

public class GLAccountsPage {
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By editButton=By.xpath("//span[.='Edit']");
	static By GLAcCentersTab=By.xpath("//a[.='GL Activity Centers']");
	static By GLAcCentersList=By.xpath("//div[@id='GlActivityCenters']//div[contains(@class, 'ui-grid-cell-contents ng-binding ng-scope')]/../../..//div[3]");
	static By GLDeptList=By.xpath("//div[@id='GlDepartments']//div[contains(@class, 'ui-grid-cell-contents ng-binding ng-scope')]/../../..//div[3]");
	static By GLAcCentersLast=By.xpath("(//div[@id='GlActivityCenters']//div[contains(@class, 'ui-grid-cell-contents ng-binding ng-scope')]/../../..//div[3])[last()]");
	static By GLAcCentersActivateButton=By.xpath("(//button[.='Activate'])[3]");
	static By GLAcCentersFirst=By.xpath("(//div[@id='GlActivityCenters']//div[contains(@class, 'ui-grid-cell-contents ng-binding ng-scope')]/../../..//div[3])[first()]");
	static By GMTAX=By.xpath("(//div[@id='GlActivityCenters']//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope')]/../../..//div[3])[3]");
	static By ActivityBtnAlert=By.xpath("//button[.='OK']");
	static By NeitherLocationCheckbox=By.xpath("//label[.='Neither']");
	static By ActivateSaveButton=By.xpath("(//span[.='Save'])[1]");
	static By saveButton=By.xpath("//span[.='Save']");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By view=By.xpath("(//div[@role='rowgroup'])[6]");
	static By Test=By.xpath("(//div[.='Employee Sales'])[2]");
	static By gLHotSyncButton = By.xpath("//button[@ng-click = 'btnGlHotSyncClick();']");
	static By closeButton = By.xpath("//button[@ng-click='closeMe();']");
	static By cancelButton = By.xpath("//button[@ng-click='btnCancelClick();']");
	static By confirmYesButton =By.xpath("//button[@data-bb-handler='Success']");
	static By viewButton = By.xpath("//button[@ng-click='btnViewBtmClick();']");
	static By viewACButton = By.xpath("//button[@ng-click='btnViewActivityCenterClick();']");
	static String acDescription = DataProvider.getACValueOf("Inactive AC");
	static String ac2Description =DataProvider.getACValueOf("AC 2");
	
	
	public static void goTo() {
		
			Browser.instance.findElement(maintenanceMenu).click();
			WebElement element = Browser.instance.findElement(By.linkText("Location Maintenance"));
		    Actions action = new Actions(Browser.instance);
		    action.moveToElement(element).build().perform(); 
		    Browser.instance.findElement(By.linkText("GL Accounts")).click();
		   // WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		    WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(editButton));
			Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
		
		
	}
	 
//Activating AC Description 
	
	public static  void ActivateACDescription() throws Exception 
	{
		Browser.instance.findElement(GLAcCentersTab).click();
		Browser.instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Browser.instance.findElement(editButton).click();
	
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GLAcCentersList));
		
	List<WebElement> ACDescription =Browser.instance.findElements(GLAcCentersList);

		for (WebElement we : ACDescription) {

			
	            if (we.getText().contains(acDescription)) {
	            	
	            	we.click();
	           
	        }
		}
		wait.until(ExpectedConditions.elementToBeClickable(GLAcCentersActivateButton));
				Browser.instance.findElement(GLAcCentersActivateButton).click();
				
				wait.until(ExpectedConditions.visibilityOf(Browser.instance.findElement(ActivityBtnAlert)));
				Browser.instance.findElement(ActivityBtnAlert).click();
				
					
					
				
//				wait.until(ExpectedConditions.elementToBeClickable(ActivateSaveButton));
				Thread.sleep(2000);
				try {
					
				
			WebElement Neither=Browser.instance.findElement(NeitherLocationCheckbox);
			if(Neither.isSelected()==true)
			{
				System.out.println("Location Already assigned to Neither");
			}
			else {
				System.out.println("Is enabling to Neither");
				wait.until(ExpectedConditions.elementToBeClickable(NeitherLocationCheckbox));
				Neither.click();
				Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Browser.instance.findElement(ActivateSaveButton).click();
				//wait.until(ExpectedConditions.elementToBeClickable(saveButton));
				wait.until(ExpectedConditions.elementToBeClickable(saveButton));
				Browser.instance.findElement(saveButton).click();
				wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			}			
	            
				}
				catch(Exception e)
				{
					Browser.instance.findElement(saveButton).click();
					wait.until(ExpectedConditions.elementToBeClickable(exitButton));
					Browser.instance.findElement(exitButton).click();
				}
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GLAcCentersList));
				
				List<WebElement> ACDescription2 =Browser.instance.findElements(GLAcCentersList);

					for (WebElement we : ACDescription2) {

						
				            if (we.getText().contains(ac2Description)) {
				            	
				            	we.click();
				           
				        }
					}
					wait.until(ExpectedConditions.elementToBeClickable(GLAcCentersActivateButton));
							Browser.instance.findElement(GLAcCentersActivateButton).click();
							
							wait.until(ExpectedConditions.visibilityOf(Browser.instance.findElement(ActivityBtnAlert)));
							Browser.instance.findElement(ActivityBtnAlert).click();
							
								
								
							
//							wait.until(ExpectedConditions.elementToBeClickable(ActivateSaveButton));
							Thread.sleep(2000);
							try {
								
							
						WebElement Neither=Browser.instance.findElement(NeitherLocationCheckbox);
						if(Neither.isSelected()==true)
						{
							System.out.println("Location Already assigned to Neither");
						}
						else {
							System.out.println("Is enabling to Neither");
							wait.until(ExpectedConditions.elementToBeClickable(NeitherLocationCheckbox));
							Neither.click();
							Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Browser.instance.findElement(ActivateSaveButton).click();
							//wait.until(ExpectedConditions.elementToBeClickable(saveButton));
							wait.until(ExpectedConditions.elementToBeClickable(saveButton));
							Browser.instance.findElement(saveButton).click();
							wait.until(ExpectedConditions.elementToBeClickable(exitButton));
						}			
				            
							}
							catch(Exception e)
							{
								Browser.instance.findElement(saveButton).click();
								wait.until(ExpectedConditions.elementToBeClickable(exitButton));
								Browser.instance.findElement(exitButton).click();
							}
			
		}
		
	//Exit GL Accounts Page
	
	public static void Exit()
	{

		Browser.instance.findElement(exitButton).click();
		Browser.instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(maintenanceMenu));
	}

	public static void editAndSaveCompany() {
		Browser.instance.findElement(GLAcCentersTab).click();
		Browser.instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Browser.instance.findElement(editButton).click();
	
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GLAcCentersList));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	
	}

	public static void openImportForm() {
		Browser.instance.findElement(gLHotSyncButton).click();
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		System.out.println("Opened the import window");
		Browser.instance.findElement(closeButton).click();
			
	}

	public static void editAndCancelCompany() {
		Browser.instance.findElement(GLAcCentersTab).click();
		Browser.instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Browser.instance.findElement(editButton).click();
	
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GLAcCentersList));
	    wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
	}

	public static void viewDepartment() {
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GLDeptList));
	    wait.until(ExpectedConditions.elementToBeClickable(viewButton));
		Browser.instance.findElement(viewButton).click();	
		Browser.instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		Browser.instance.findElement(closeButton).click();
	}

	public static void viewActivityCenter() {
		Browser.instance.findElement(GLAcCentersTab).click();
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GLAcCentersList));
		Browser.instance.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.elementToBeClickable(viewACButton));
		Browser.instance.findElement(viewACButton).click();	
	    wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		Browser.instance.findElement(closeButton).click();
	}


}
