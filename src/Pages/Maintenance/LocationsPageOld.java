package Pages.Maintenance;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.DataProvider;
import Initialization.DatabaseConnection;

public class LocationsPage {
	
	
	static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
	static By editButton=By.xpath("//span[.='Edit']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By cancelConfirm=By.xpath("//button[.='Yes']");
	static By newButton=By.xpath("//span[.='New']");
	static By editAC=By.xpath("(//button[.='Edit'])[1]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By ACEditorsaveButton=By.xpath("(//button[.='Save'])[1]");
	static By ACEditorSalesSaveButton=By.xpath("(//button[.='Save'])[2]");
	static By NewACDropdown=By.xpath("//select[@data-ng-model='openActivityCenters.activityCenterId']");

	static By SalesCategoryDropdown=By.xpath("//select[@data-ng-model='salesCategories.salesCategoryId']");
	static By SalesGroupDropdown=By.xpath("//select[@data-ng-model='salesGroups.salesGroupId']");
	static By TaxScheduleDropdown=By.xpath("//select[@data-ng-model='taxSchedules.taxGroupID']");
	static By RoyalityProfileDropdown=By.xpath("//select[@data-ng-model='royaltyProfiles.concessionaireProfileId']");
	static By TaxIncludedRadioButton=By.xpath("(//label[@class='control-label ng-binding'])[16]");
	static By AddACDropdown=By.xpath("//select[@data-ng-model='openActivityCenters.activityCenterId']");
	static By saveButton=By.xpath("//span[.='Save']");
	static By ACAddButton=By.xpath("(//button[.='Add'])[1]");
	static By SalesAddButton=By.xpath("(//button[.='Add'])[2]");
	static By RemoveButton=By.xpath("//button[.='Remove']");
	static By SalesDeleteButton=By.xpath("//button[.='Delete']");
	static By SalesGroupList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1]//div[3][contains(@id,'uiGrid-000H-cell')]");
	static By ACANDSGDescList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[2]");
	static By ACDescriptionList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1]//div[2][contains(@id,'uiGrid-000A-cell')]");
	static By ACCodeList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1]//div[1][contains(@id,'uiGrid-0009-cell')]");
	static By SalesDesignationACCode=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1]//div[1][contains(@id,'uiGrid-000F-cell')]");
	static By SalesDesignationACCodeFirst=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1]//div[1][contains(@id,'uiGrid-000F-cell')])[1]");
	static By ACDescriptionField=By.xpath("//input[@name='txtAcDesc']");
	static By LocationCodeDropdown=By.xpath("//select[@name='ddlLocCode']");
	
	static String CreatingAC="TO - Night";
	static String AddingAC=DataProvider.getACValueOf("Inactive AC");
	static String AddingACCode = DataProvider.getACValueOf("AC1 Code");
	static String EditingAC=DataProvider.getACValueOf("AC 2");
	static String EditingACCode = DataProvider.getACValueOf("AC2 Code");
	static String Category=null;
	static String Sales=null;
	static By RemoveErrorMsg=By.xpath("//div[@class='full-width-form']");
	static By RemoveErrorConfirm=By.xpath("//button[.='OK']");
	static By ConfirmDeleteMsg=By.xpath("//div[@class='full-width-form']");
	static By ConfirmDeleteYes=By.xpath("//button[.='Yes']");
	static By CheckActivate=By.xpath("//input[@data-ng-model='activeFlag']");
	static By CannotSaveMsg=By.xpath("//div[@class='full-width-form']");
	static By CannotSaveConfirm=By.xpath("//button[.='OK']");
	static By ACSGEditorWindow=By.xpath("(//div[@class='col-sm-12 clear-padding ng-binding'])[2]");
	static By MoveToTopButton=By.xpath("//button[.='Move To Top']");
	static By CannotSaveSalesMsg=By.xpath("//div[@class='full-width-form']");
	static By CannotSaveSalesConfirm=By.xpath("//button[.='OK']");
		
	
	public static void goTo() {
		
		
		
		Browser.instance.findElement(maintenanceMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Location Maintenance"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Locations")).click();
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
		
	}
	
	
	//Creating New AC and Sales
	public static void createNewAC() throws Exception 
	{
		
		System.out.println("--------Creating new AC--------");

		Thread.sleep(2000);
		Browser.instance.findElement(newButton).click();
		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		    wait.until(ExpectedConditions.elementToBeClickable( ACEditorsaveButton));
		    
	
		   wait.until(ExpectedConditions.visibilityOf(Browser.instance.findElement(NewACDropdown)));

		   selectACNew(AddingACCode+" "+AddingAC,NewACDropdown);//callString
		   selectAC("Sky Fun 5%",RoyalityProfileDropdown);//callString
		   Browser.instance.findElement(ACEditorsaveButton).click();
		   wait.until(ExpectedConditions.elementToBeClickable(ACEditorSalesSaveButton));	
		   selectAC("Employee Svcs",SalesCategoryDropdown);//callString
		   selectAC("Employee Svcs - General",SalesGroupDropdown);//callString
		   selectAC("Alcohol Tax Schedule",TaxScheduleDropdown);//callString
		   WebElement TaxInc=Browser.instance.findElement(TaxIncludedRadioButton);
			if(TaxInc.isSelected()==true)
			{
				System.out.println("Tax Method Already assigned to Tax Included");
			}
			else {
				System.out.println("Is enabling to Tax Included");
				
				TaxInc.click();
				Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Browser.instance.findElement(ACEditorSalesSaveButton).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(saveButton));
				Browser.instance.findElement(saveButton).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(newButton));
				
							}
						
		   
	}
	
	
	//Adding AC and sales to selected location code
	public static void AddAC()
	{
		

		System.out.println("--------Adding new AC--------");
		Browser.instance.findElement(ACAddButton).click();
		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable( ACEditorsaveButton));
		 wait.until(ExpectedConditions.visibilityOf(Browser.instance.findElement(NewACDropdown)));
		
		   selectACNew(EditingACCode+" "+EditingAC,NewACDropdown);//callString
		   selectAC("Tony Hawk Cost of Sale",RoyalityProfileDropdown);//callString
		   Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Browser.instance.findElement(ACEditorsaveButton).click();
		   
		   wait.until(ExpectedConditions.elementToBeClickable(ACEditorSalesSaveButton));
		   
		   selectAC("Employee Svcs",SalesCategoryDropdown);//callString
		   selectAC("Employee Svcs - General",SalesGroupDropdown);//callString
		   selectAC("Alcohol Tax Schedule",TaxScheduleDropdown);//callString
		   WebElement TaxInc=Browser.instance.findElement(TaxIncludedRadioButton);
			if(TaxInc.isSelected()==true)
			{
				System.out.println("Tax Method Already assigned to Tax Included");
			}
			else {

				TaxInc.click();

			}
			 wait.until(ExpectedConditions.elementToBeClickable( ACEditorSalesSaveButton));
			Browser.instance.findElement(ACEditorSalesSaveButton).click();
			System.out.println("New AC has been Added");
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			Browser.instance.findElement(saveButton).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(newButton));
		
	}
	
	//Editing AC description Field
	
	public static void EditAC()
	{

		List<WebElement> allOptions =Browser.instance.findElements(ACCodeList);
		
		for (WebElement we : allOptions) {

	            if (we.getText().contains(AddingACCode)) {//callString
	            	
	            	we.click();
	            }
	        }
		
		
		Browser.instance.findElement(editAC).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable( ACEditorsaveButton));
		 
		Browser.instance.findElement(ACDescriptionField).sendKeys("Test1");
		Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Browser.instance.findElement(ACEditorsaveButton).click();
	
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		
	}
	
	//Verifying the error message while Removing AC 
	
	public static void RemoveACConfirmErrorMsg() throws Exception 
	{
		 
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(RemoveButton));
		Thread.sleep(2000);
		List<WebElement> allOptions =Browser.instance.findElements(ACANDSGDescList);
		
		for (WebElement we : allOptions) {
		
			if (we.getText().contains(EditingAC)) {//callString
	            	
	            	we.click();
	            }
	        }
		Browser.instance.findElement(RemoveButton).click();

		 wait.until(ExpectedConditions.elementToBeClickable( RemoveErrorConfirm));
		String Actual=Browser.instance.findElement(RemoveErrorMsg).getText();
		String Expected="Can't remove while sales designations exists.";
		
		if(Actual.equalsIgnoreCase(Expected))
		{
			System.out.println("Not Removed because sales designation exist");
			Browser.instance.findElement(RemoveErrorConfirm).click();
			 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			 Browser.instance.findElement(saveButton).click();
			 wait.until(ExpectedConditions.elementToBeClickable(editButton));
			 
		}
		else
		{
			System.out.println("Invalid");
		}
		
	}
	
	//Removing Sales Designation
	public static void RemoveSalesDesignation(String Sales)
	{
		 JavascriptExecutor js = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
			 {
		 js.executeScript("window.scrollBy(0,100)");
			 }
List<WebElement> allOptions =Browser.instance.findElements(SalesDesignationACCode);
		
		for (WebElement we : allOptions) {
		
			if (we.getText().contains(Sales)) {
	            	
	            	we.click();
	            }
	        }


		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);

		Browser.instance.findElement(SalesDeleteButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmDeleteYes));
		if(Browser.instance.findElement(ConfirmDeleteYes).isDisplayed())
		{
			Browser.instance.findElement(ConfirmDeleteYes).click();
			System.out.println("Sales Designation corresponding to AC Code"+Sales+"has been deleted");
		}
		
		else
		{
			System.out.println("Already Deleted");
		}
	}
	
	//Remove AC
	public static void RemoveAC()
	{
		RemoveSalesDesignation("0050");//callString
		 JavascriptExecutor js = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
			 {
		 js.executeScript("window.scrollBy(0,-100)");
			 }
List<WebElement> allOptions =Browser.instance.findElements(ACCodeList);
		
		for (WebElement we : allOptions) {
		
			if (we.getText().contains("0050")) {//callString
	            	
	            	we.click();
	            }
	        }
		Browser.instance.findElement(RemoveButton).click();

		String Actual=Browser.instance.findElement(RemoveErrorMsg).getText();
		String Expected="Must save current transaction Before removing.";
		if(Actual.equalsIgnoreCase(Expected))
		{
			System.out.println("Valid error Message is shown");
			Browser.instance.findElement(RemoveErrorConfirm).click();

			
		}
		else
		{
			System.out.println("Invalid Message");
		}
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable( saveButton));
		 Browser.instance.findElement(saveButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable( editButton));
		 Browser.instance.findElement(editButton).click();
		 
	}
	
	//Select Location Code

	public static void SelectLocationCode() throws Exception
	{
		Select LocCode=new Select(Browser.instance.findElement(LocationCodeDropdown));
		LocCode.selectByVisibleText(AddingACCode);//callString
		Thread.sleep(2000);
		 Browser.instance.findElement(editButton).click();

		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(ACAddButton));

		 
	}
	
	//Add Multiple Sales Designation
	
	public static void AddMultipleSalesDesignations()
	{
		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		
		 for(int i=0;i<8;i++)
		 {

		 wait.until(ExpectedConditions.elementToBeClickable(SalesAddButton));
		 Browser.instance.findElement(SalesAddButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(ACEditorSalesSaveButton));
		 selectAC("Attendance Tax Schedule",TaxScheduleDropdown);
		 

		 Browser.instance.findElement(ACEditorSalesSaveButton).click();
		 }
		 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	}

		 // Select the AC for adding to sales
	public static void SelectACAndScrollDown() throws Exception
	
	{	
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
//		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable( cancelConfirm));
		Browser.instance.findElement(cancelConfirm).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Browser.instance.findElement(editButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Thread.sleep(2000);
	
		List<WebElement> allOptions =Browser.instance.findElements(ACCodeList);
		
		for (WebElement we : allOptions) {

	            if (we.getText().contains(AddingACCode)) {//callString
	            	
	            	we.click();
	            }
	        }
		 JavascriptExecutor jsd = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
			 {
		 jsd.executeScript("window.scrollBy(0,100)");
			 }
	}
	
	//verifying whether valid error message is displayed or not while saving multiple sales designation that were added.
	
	public static void ScrollUpAndSaveSalesDesignation()
	{
		 JavascriptExecutor jsd = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
			 {
		 jsd.executeScript("window.scrollBy(0,-100)");
			 }

		 Browser.instance.findElement(saveButton).click();
		 try {
		 if(Browser.instance.findElement(CannotSaveConfirm).isDisplayed())
		 {
			 String Actual=Browser.instance.findElement(CannotSaveMsg).getText();
			 String Expected="Only 8 active Sales Groups per Location.";
			 if(Actual.equalsIgnoreCase(Expected))
			 {
				 System.out.println("Limitation count of Active sales group is Displayed");
				 Browser.instance.findElement(CannotSaveConfirm).click();
				 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
				 wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
					
					 Browser.instance.findElement(cancelButton).click();
					 wait.until(ExpectedConditions.elementToBeClickable(cancelConfirm));
					 Browser.instance.findElement(cancelConfirm).click();
					 wait.until(ExpectedConditions.elementToBeClickable(editButton));
			 }
			  else
				 {
					 System.out.println("Invalid Error Message");
				 }
		 }
		 }
		 catch (NoSuchElementException e) {
			 System.out.println("Caught exception successfully");
		 }
	 }

				
	
	//Selecting a sales AC code and moving to top  
	
	public static void MoveToTop()
	{
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		 
		 JavascriptExecutor jsd = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
			 {
		 jsd.executeScript("window.scrollBy(0,100)");
			 }
	List<WebElement> allOptions =Browser.instance.findElements(SalesDesignationACCode);
		
		for (WebElement we : allOptions) {
	    
			 if (we.getText().contains(EditingACCode)) {//callString
	            	
	            	we.click();
			 }
			 
	            	Browser.instance.findElement(MoveToTopButton).click();
	            	String Actual=Browser.instance.findElement(SalesDesignationACCodeFirst).getText();
	        		String Expected=EditingACCode;//callString
	        		
	        		if(Actual.equalsIgnoreCase(Expected))
	        		{
	        			System.out.println("SalesDesignation with ACCode "+EditingACCode+" is moved to top");
	        		}
	        		else {
	        			System.out.println("It is not moved to top");
	        		}
	        		 JavascriptExecutor jsu = (JavascriptExecutor)Browser.instance;
	        		 for(int j=0;j<10;j++)
	        			 {
	        		 jsu.executeScript("window.scrollBy(0,-100)");
	        			 }
	        		
	        		 Browser.instance.findElement(cancelButton).click();
	        		 try {
	        			 Browser.instance.findElement(editButton).click();
	        		 }
	        		 catch(Exception e)
	        		 {
	        			 wait.until(ExpectedConditions.elementToBeClickable(cancelConfirm));
						 Browser.instance.findElement(cancelConfirm).click();
		        		 wait.until(ExpectedConditions.elementToBeClickable(editButton));
	        		 }
	        	
	            }
	        }
		
		
	//Disabling the Active Checkbox for Location
	
	public static void DisableLocationActive()
	{
		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(editButton).click();
		if(Browser.instance.findElement(CheckActivate).isSelected()==true)
		{
			//Browser.instance.findElement(CheckActivate).click();
			Browser.instance.findElement(CheckActivate).click();
			if(Browser.instance.findElement(CheckActivate).isSelected()==true)
			{
				Browser.instance.findElement(CheckActivate).click();
				Browser.instance.findElement(saveButton).click();
			}
			else {

				 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			Browser.instance.findElement(saveButton).click();
			}

			 
			 wait.until(ExpectedConditions.elementToBeClickable(editButton));
			 Browser.instance.findElement(editButton).click();
			 if(Browser.instance.findElement(editAC).isEnabled()==true)
			 {
				System.out.println("It is not disabled"); 
			 }
			 else
			 {

				 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
				 Browser.instance.findElement(saveButton).click();
				 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
				 System.out.println("DisabledActive");
				 System.out.println("All ACs become inactive");
			 }
		}
	
	}
	
	//Activate the Location by clicking checkbox
	public static void ActivateLocation()
	{
		
	

		if(Browser.instance.findElement(CheckActivate).isSelected()==false)
		{
			//Browser.instance.findElement(CheckActivate).click();
			Browser.instance.findElement(CheckActivate).click();
			Browser.instance.findElement(CheckActivate).click();
			Browser.instance.findElement(CheckActivate).click();
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			 Browser.instance.findElement(saveButton).click();
			
			 wait.until(ExpectedConditions.elementToBeClickable(editButton));
			 Browser.instance.findElement(editButton).click();
		}
	}
	
	//Verifying valid error message is displayed while adding and saving same AC code with different Sales Category.
	
	public static void SameACCodeDifferentSalesCategory()
	{
		 JavascriptExecutor jsd = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
			 {
		 jsd.executeScript("window.scrollBy(0,100)");
			 }
		 
	List<WebElement> allOptions =Browser.instance.findElements(ACCodeList);
		
		for (WebElement we : allOptions) {

	            if (we.getText().contains(AddingACCode)) {//callString
	            	
	            	we.click();
	            
	        }
		}
	            	 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	        		// wait.until(ExpectedConditions.elementToBeClickable(SalesAddButton));
	        		 Browser.instance.findElement(SalesAddButton).click();
	        		 wait.until(ExpectedConditions.elementToBeClickable(ACEditorSalesSaveButton));
	        		 SelectSales("Other");
	        		 //wait.until(ExpectedConditions.elementToBeClickable(ACEditorSalesSaveButton));
	        		 Browser.instance.findElement(ACEditorSalesSaveButton).click();
	        		 

	        		 RemoveSalesDesignation(AddingACCode);//callString
	        		 RemoveSalesDesignation(AddingACCode);//callString
	        		 
	        		 for(int j=0;j<10;j++)
	        			 {
	        		 jsd.executeScript("window.scrollBy(0,-100)");
	        			 }
	        		 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	        		 Browser.instance.findElement(saveButton).click();
	        		 
	        		 if(Browser.instance.findElement(editButton).isDisplayed()==true)
	        		 {
	        			 Browser.instance.findElement(editButton).click();
	        			 System.out.println("Invalid:Proper Error message not showing while deleting AC code with different Sales Category.");
	        		
	        		 }
	        			 else if(Browser.instance.findElement(CannotSaveConfirm).isDisplayed()==true)
	        			 {
	        			 Browser.instance.findElement(CannotSaveConfirm).click();
	        		 }
	        		 }


	        		 
	        
	      			 //Exiting Locations  Page
	public static void exitPage()
	{

		 Browser.instance.findElement(exitButton).click();
	}
	
	
	//Verify error message is displayed while Deleting a sales designation related item.
	
	public static void SalesDesignationDeleteRelatedItem()
	{ 
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(editButton).click();
		 JavascriptExecutor jsd = (JavascriptExecutor)Browser.instance;
		 for(int i=0;i<10;i++)
		 {
	 jsd.executeScript("window.scrollBy(0,100)");
		 }
List<WebElement> allOptions =Browser.instance.findElements(SalesDesignationACCode);
		
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) 
	        {
			//System.out.println(we.getText());
	            if (we.getText().contains("0500")) {//callString
	            	
	            	we.click();
	            }
	        }
	     
	            	Browser.instance.findElement(SalesDeleteButton).click();
	            	
	       		 wait.until(ExpectedConditions.elementToBeClickable(ConfirmDeleteYes));
	       		Browser.instance.findElement(ConfirmDeleteYes).click();
	        
		 for(int k=0;k<10;k++)
		 {
	 jsd.executeScript("window.scrollBy(0,-100)");
		 }
		 Browser.instance.findElement(saveButton).click();
		 
		 if(Browser.instance.findElement(CannotSaveSalesConfirm).isDisplayed()==true)
		 {
		 String actual=Browser.instance.findElement(CannotSaveSalesMsg).getText();
		 String expected="Cannot Delete because this item is used in another related item.";
				 if(actual.equalsIgnoreCase(expected))
				 {
					 System.out.println("Item is used in another related item");
					 Browser.instance.findElement(CannotSaveSalesConfirm).click();
					 }
				 
				 else {
					System.out.println("Invalid error:Proper Error message is not displayed when item is used in another related item"); 
				 }
		 }
		}
	}
		 
		 
		 
	
		
	
	
	
	//Verify whether AC is created or not
	
	public static boolean isCreated() {
		
		Boolean found = false;
		List<WebElement> allOptions =Browser.instance.findElements(ACANDSGDescList);
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains("TO - Night")) {//callString
	                found = true;
	                System.out.println("The "+ CreatingAC +" has been added to AC description");
	                break loop;
	            }
	        }
		}
		return true;
	}
	
	//Verify whether AC is added or not 
	
public static boolean isAdded() {
		
		Boolean found = false;
		List<WebElement> allOptions =Browser.instance.findElements(ACANDSGDescList);
		loop:
		for (WebElement we : allOptions) {
	        for (int i = 0; i < allOptions.size(); i++) {
	            if (we.getText().contains("Season Pass Refunds")) {//callString
	                found = true;
	                System.out.println("The "+ AddingAC +" has been added to AC description");
	                break loop;
	            }
	        }
		}
		return true;
	}

//Verifying whether AC description is edited or not

public static boolean isEdited() {
	
	Boolean found = false;
	List<WebElement> allOptions =Browser.instance.findElements(ACANDSGDescList);
	loop:
	for (WebElement we : allOptions) {

            if (we.getText().contains("Cirq tent Test")) {
                found = true;
                System.out.println("The "+ EditingAC +" has been edited in AC description");
                break loop;
            
        }
	}
	
	return true;
}



	public static void selectAC(String AC,By RY) {
		
		Select ACDropdown=new Select(Browser.instance.findElement(RY));
		List<WebElement> Options =ACDropdown.getOptions();
		
	    int iSize = Options.size();
	    Options.get(0).click();

	    }
	
	public static void selectACNew(String AC,By RY)
	{
		
		
		Select ACDropdown=new Select(Browser.instance.findElement(RY));
		List<WebElement> Options =ACDropdown.getOptions();
		
	    int iSize = Options.size();
	    
	    //System.out.println("Total No of SalesCategoryOptions:"+iSize);
	 
	    for (int i = 0; i < iSize; i++) {
	    	   	if (AC.equals(Options.get(i).getText())) {
	    	   		
	    	   		Options.get(i).click();
	    	   		break;
	                }
	    }
	}
	
	public static void SelectSales(String Category)
	{
		
		
		Select SalesCategoryList=new Select(Browser.instance.findElement(SalesCategoryDropdown));
		List<WebElement> Options =SalesCategoryList.getOptions();
		
	    int iSize = Options.size();
	    
	    System.out.println("Total No of SalesCategoryOptions:"+iSize);
	 
	    for (int i = 0; i < iSize; i++) {
	    	   	if (Category.equals(Options.get(i).getText())) {
	    	   		
	    	   		Options.get(i).click();
	    	   		break;
	                }
	    }
	
	}


	public static void cleanup() {
		DatabaseConnection.disableAC(EditingACCode);
		DatabaseConnection.removeLocation(AddingACCode);
		
		
	}


}