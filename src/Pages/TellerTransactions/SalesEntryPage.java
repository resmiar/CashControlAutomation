package Pages.TellerTransactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;

public class SalesEntryPage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By exitBagUsageButton=By.xpath("(//span[.='Exit'])[1]");
	static By saveButton=By.xpath("//span[.='Save']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By CancelConfirm=By.xpath("//button[.='Yes']");
	static By bagEntryField =By.id("bagAlias");
	static By ItemSelectionButton=By.xpath("//button[@name='btnBagItems']");
	static By BagIdList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div/div[1][contains(@ng-dblclick,'grid.appScope.onDblClick(row)')]");
	static By BagTypeList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[2]");
	static By LocCodeDropdown=By.xpath("(//select[@data-ng-model='lstLocCodes.locationId'])[2]");
	static By DateOutList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[3]");
	static By BufferImg=By.xpath("(//img)[1]");
	static By selectButton=By.xpath("//button[.='Select']");
	static By RetrieveButton=By.xpath("//button[.='Retrieve']");
	static By dateField=By.name("txtCcDate");
	static By closedCCDayMsg=By.xpath("//div[@class='full-width-form']");
	static By DiffWorkingDateMsg=By.xpath("//div[@class='full-width-form']");
	static By CannotSaveMsg=By.xpath("//div[@class='full-width-form']");
	static By CannotSaveConfirm=By.xpath("//button[.='OK']");
	static By DiffWorkingDateConfirm=By.xpath("//button[.='OK']");
	static By closedCCdayConfirm=By.xpath("//button[.='OK']");
	static By DateConfirm=By.xpath("//button[.='OK']");
	static By openCCDayConfirm=By.xpath("//button[.='Yes']");
	static By dateEntryLink=By.xpath("//span[@class='date-field ng-binding']");
	static By QtyEndReading=By.xpath("//input[@data-ng-model='endReadQty']");
	static By QtyBeginningReading=By.xpath("//input[@data-ng-model='begReadQty']");
	static By QtyTotals=By.xpath("//input[@data-ng-model='regQty']");
	static By GrossAmtEndReading=By.xpath("//input[@data-ng-model='endReadAmt']");
	static By GrossAmtBeginningReading=By.xpath("//input[@data-ng-model='begReadAmt']");
	static By GrossAmtTotals=By.xpath("//input[@data-ng-model='gsAmt']");
	static By SalesTaxEndReading=By.xpath("//input[@data-ng-model='stEndReadAmt']");
	static By SalesTaxBeginningReading=By.xpath("//input[@data-ng-model='stbegReadAmt']");
	static By SalesTaxTotals=By.xpath("//input[@data-ng-model='salesTaxAmt']");
	static By NetAmtTotals=By.xpath("//input[@data-ng-model='netSales']");
	static By QtyUnAdjustedTotals=By.xpath("//input[@data-ng-model='acdQty']");
	static By QtyTotalLineAdjustments=By.xpath("//input[@data-ng-model='totAdjQty']");
	static By QtyAdjustedTotals=By.xpath("//input[@data-ng-model='adjQty']");
	static By GrossAmtUnAdjustedTotals=By.xpath("//input[@data-ng-model='acdGross']");
	static By GrossAmtTotalLineAdjustments=By.xpath("//input[@data-ng-model='totAdjAmt']");
	static By GrossAmtAdjustedTotals=By.xpath("//input[@data-ng-model='adjGross']");
	static By SalesTaxUnAdjustedTotals=By.xpath("//input[@data-ng-model='acdTax']");
	static By SalesTaxTotalLineAdjustments=By.xpath("//input[@data-ng-model='totAdjTax']");
	static By SalesTaxAdjustedTotals=By.xpath("//input[@data-ng-model='adjTax']");
	static By NetAmtUnAdjustedTotals=By.xpath("//input[@data-ng-model='acdNet']");
	static By NetAmtTotalLineAdjustments=By.xpath("//input[@data-ng-model='totAdjNet']");
	static By NetAmtAdjustedTotals=By.xpath("//input[@data-ng-model='adjNet']");
	static By ActCenterDetailsEnding=By.id("txtEndRead_0");
	static By ActCenterDetailsBeginning=By.id("txtBeginRead_0");
	static By ActCenterDetailsNetSales=By.id("txtUnAdjNet_0");
	static By ActCenterDetailsSalesTax=By.id("txtUnAdjTax_0");
	static By ActCenterDetailsOverride=By.id("txtTaxOverride_0");
	static By ActCenterDetailsGrossSales=By.id("txtUnAdjGross_0");
	static By ActCenterDetailsQty=By.id("txtAdjQty_0");
	static By ActCenterDetailsGross=By.id("txtAdjGross_0");
	static By ActCenterDetailsAdjustmentsTax=By.id("txtAdjTax_0");
	static By ActCenterDetailsNet=By.id("txtAdjNet_0");
	static By ActCenterDetailsTaxVariance=By.xpath("//input[@data-ng-model='varTax']");
	static By ActCenterDetailsReadingVariance=By.xpath("//input[@data-ng-model='varGross']");
	static double TaxScheduleRate;
	static String output;
	static By newExistingSalesButton=By.xpath("//button[.='New']");
	static By editExistingSalesButton=By.xpath("//button[.='Edit']");
	static By cancelExistingSalesButton=By.xpath("//button[.='Cancel']");
	static By existingLastSalesEntriesList=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[last()]");
	static By CalendarMaintenanceExitButton=By.xpath("//span[.='Exit']");
	static By CalendarMaintenanceButton=By.id("btnCalendarMaintenance");
	static By DateFieldCalendar=By.id("dtCmDate");
	static By editButton=By.xpath("//span[.='Edit']");
	static By SpecialEventCheckBox=By.xpath("(//input[@type='checkbox'])[4]");
	static By eventDropdown=By.xpath("//select[@data-ng-model='events.eventId']");
	static By BagUsageButton=By.xpath("//button[.='Bag Usage']");
	static By ExclusiveLocationCheckbox=By.xpath("(//input[@type='checkbox'])[2]");
	static By saveBagUsageButton=By.xpath("(//span[.='Save'])[1]");
	static By BagUsageItemSelectionButton=By.xpath("(//button[@class='btn-primary theme-commen-button'])[1]");
	static By BagUsageBagIdList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div/div[1][contains(@class,'ui-grid-coluiGrid-005N')]");
	static By BagUsageLocationDropdown=By.xpath("//select[@data-ng-model='upperLocCodes.upperLocCodeId']");
	static By ClearButton=By.xpath("//button[.='Clear']");
	static By LocationExclusiveMsg=By.xpath("//label[@class='lblLocatinMarked ng-binding']");
	static By AutoSalesCheckbox=By.xpath("(//input[@type='checkbox'])[1]");	
	static By AutoSalesInvalidMsg=By.xpath("//div[@class='full-width-form']");
	static By AutoSalesConfirmButton=By.xpath("//button[.='OK']");
	static By AutoSalesOnlyMsg=By.xpath("//div[@class='full-width-form']");
	static By AutoSalesOnlyConfirmButton=By.xpath("//button[.='OK']");
	static By ApplyAllSalesToBagCheckbox=By.xpath("//input[@data-ng-model='applyAllSalesToBag']");
	static By loadingIcon = By.xpath("//div[@class='data-loading-PLU ng-hide']");
	static String bagID;
	
	
	
	
	
	
	//Goto Sales Entry Page
	public static void goTo() {
		try {
			Browser.instance.findElement(TransactionsMenu).click();
		}
		catch(Exception e)
		{
			System.out.println("Element not clickable exception handled for Transactions Menu");
			Browser.instance.findElement(TransactionsMenu).click();
		}
		
		WebElement element = Browser.instance.findElement(By.linkText("Teller Transactions"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Sales Entry")).click();
	    Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		
	
		}
	
	//Verify Bag with Closed CC Date
	public static void ItemSelectionClosedCCDate() throws Exception
	{
		//5620.03.015
		WebDriverWait wait= new WebDriverWait(Browser.instance,60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		Browser.instance.findElement(ItemSelectionButton).click();
	

wait.until(ExpectedConditions.elementToBeClickable(selectButton));
		
		selectItem(bagID,BagIdList);
		Browser.instance.findElement(selectButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(RetrieveButton));
		Browser.instance.findElement(RetrieveButton).click();
		Thread.sleep(1000);
		 String Actual=Browser.instance.findElement(closedCCDayMsg).getText();
		
		 String Expected="This CC Day has been closed.";

		 if(Actual.equalsIgnoreCase(Expected))
		 {
			
			 Browser.instance.findElement(closedCCdayConfirm).click();
			 System.out.println("CC Day has been closed.Trying with new Date");
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			 Browser.instance.findElement(exitButton).click();
			 wait.until(ExpectedConditions.elementToBeClickable(dateEntryLink));
	}
		 else
		 {
			 System.out.println("Invalid message");
		 }
	}
	
	//Verify Bag with New CC Date
	public static void ItemSelectionNewCCDate() throws Exception
	{
		 Browser.instance.findElement(dateEntryLink).click();
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));

			 Thread.sleep(1000);
				Browser.instance.findElement(dateField).sendKeys("05062018");
			 Browser.instance.findElement(DateConfirm).click();
			 
			 
		try {

			Browser.instance.findElement(openCCDayConfirm).click();
	
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
			goTo();
			System.out.println("Reopened with new CCDate");
		}
		catch(Exception e)
		{
			goTo();
			System.out.println("Reopened with new CCDate");
		}
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		try {
			Browser.instance.findElement(ItemSelectionButton).click();
		}
		catch(Exception e)
		{
			System.out.println("Click Intercepted Exception handled successfully");
			Browser.instance.findElement(ItemSelectionButton).click();
		}
	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
		selectItem(bagID,BagIdList);
	
		Browser.instance.findElement(selectButton).click();
		Thread.sleep(1000);
		 String Actual=Browser.instance.findElement(DiffWorkingDateMsg).getText();
		
		 String Expected="Current working date is different than the date this bag was checked out: ";

		 if(Actual.contains(Expected))
		 {
			
			 Browser.instance.findElement(DiffWorkingDateConfirm).click();
			 System.out.println("Current Working Date is different than the date this bag was checked out");
			 Thread.sleep(1000);
			
	}
		 else
		 {
			 System.out.println("Invalid message");
		 }
		 wait.until(ExpectedConditions.elementToBeClickable(RetrieveButton));
		 Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
		 //LocCode.selectByVisibleText("3100");
		 LocCode.selectByIndex(2);;
		Browser.instance.findElement(RetrieveButton).click();
		
	
	}
	

	//Verify Register Calculations
	public static void RegisterVerifyCalculations() throws Exception
	{
//		  Thread.sleep(2000);
				
//		 Browser.instance.findElement(QtyEndReading).sendKeys("1000");
//			 Clear(QtyBeginningReading);
//				 Browser.instance.findElement(QtyBeginningReading).sendKeys("500");
//				 Browser.instance.findElement(GrossAmtEndReading).sendKeys("700.00");
//				 Browser.instance.findElement(GrossAmtBeginningReading).sendKeys("300.00");
//				 Tab();
				  int ActualQtyEndReading = Integer.parseInt(Browser.instance.findElement(QtyEndReading).getAttribute("value"));
				  int ActualQtyBeginningReading = Integer.parseInt(Browser.instance.findElement(QtyBeginningReading).getAttribute("value"));
				double ActualGrossAmtEndReading = Double.parseDouble(Browser.instance.findElement(GrossAmtEndReading).getAttribute("value"));
				double ActualGrossAmtBeginningReading = Double.parseDouble(Browser.instance.findElement(GrossAmtBeginningReading).getAttribute("value"));
				int ActualQtyTotals=Integer.parseInt(Browser.instance.findElement(QtyTotals).getAttribute("value"));
				double ActualGrossAmtTotals = Double.parseDouble(Browser.instance.findElement(GrossAmtTotals).getAttribute("value"));
				double ActualSalesTaxTotals = Double.parseDouble(Browser.instance.findElement(SalesTaxTotals).getAttribute("value"));
				double ActualNetAmtTotals = Double.parseDouble(Browser.instance.findElement(NetAmtTotals).getAttribute("value"));
					int	ExpectedQtyTotals= ActualQtyEndReading-ActualQtyBeginningReading;
					double ExpectedGrossAmtTotals=ActualGrossAmtEndReading- ActualGrossAmtBeginningReading;
					double ExpectedNetAmtTotals=  ActualGrossAmtTotals-ActualSalesTaxTotals;
					
					
					
				System.out.println("-----------------Calculations when Register is applied------------------");
			IntegerCalculations(ExpectedQtyTotals,Browser.instance.findElement(QtyTotals).getAttribute("value"));
				 NumberFormatterandVerifyCalculations(ExpectedGrossAmtTotals,Browser.instance.findElement(GrossAmtTotals).getAttribute("value"));
				 NumberFormatterandVerifyCalculations(ExpectedNetAmtTotals,Browser.instance.findElement(NetAmtTotals).getAttribute("value"));
				
//				 IntegerCalculations(ExpectedQtyUnAdjustedTotals,Browser.instance.findElement(QtyUnAdjustedTotals).getAttribute("value"));
//				 NumberFormatterandVerifyCalculations(ExpectedGrossAmtUnAdjustedTotalsFromRegister,Browser.instance.findElement(GrossAmtUnAdjustedTotals).getAttribute("value"));
//				 NumberFormatterandVerifyCalculations(ExpectedNetAmtUnAdjustedTotals1,Browser.instance.findElement(NetAmtUnAdjustedTotals).getAttribute("value"));
				
	}
	//Verify ACDetailsAndActCenterDetailsCalculations
	public static void ACDetailsAndActCenterDetailsCalculations() throws Exception
	{
		
		//Applying Override,Quantity,Gross
		
			 Browser.instance.findElement(ActCenterDetailsEnding).sendKeys("400.00");
			 Browser.instance.findElement(ActCenterDetailsBeginning).sendKeys("250.00");
			//Browser.instance.findElement(ActCenterDetailsOverride).sendKeys("45.00");
			//Browser.instance.findElement(ActCenterDetailsQty).sendKeys("5");
			//Browser.instance.findElement(ActCenterDetailsGross).sendKeys("200.00");
			Tab();
			Thread.sleep(1000);
			double ActualGrossAmtEndReading = Double.parseDouble(Browser.instance.findElement(GrossAmtEndReading).getAttribute("value"));
			double ActualActCenterDetailsEnding = Double.parseDouble(Browser.instance.findElement(ActCenterDetailsEnding).getAttribute("value"));
			double ActualGrossAmtBeginningReading = Double.parseDouble(Browser.instance.findElement(GrossAmtBeginningReading).getAttribute("value"));
			double ActualActCenterDetailsBeginning = Double.parseDouble(Browser.instance.findElement(ActCenterDetailsBeginning).getAttribute("value"));
			double ActualActCenterDetailsGrossSales = Double.parseDouble(Browser.instance.findElement(ActCenterDetailsGrossSales).getAttribute("value"));
			double ActualActCenterDetailsSalesTax = Double.parseDouble(Browser.instance.findElement(ActCenterDetailsSalesTax).getAttribute("value"));
			double ActualGrossAmtUnAdjustedTotals = Double.parseDouble(Browser.instance.findElement(GrossAmtUnAdjustedTotals).getAttribute("value"));
			double ActualSalesTaxUnAdjustedTotals = Double.parseDouble(Browser.instance.findElement(SalesTaxUnAdjustedTotals).getAttribute("value"));
			double ActualActCenterDetailsOverride = Double.parseDouble(Browser.instance.findElement(ActCenterDetailsOverride).getAttribute("value"));
			 double ActualGrossAmtTotalLineAdjustments = Double.parseDouble(Browser.instance.findElement(GrossAmtTotalLineAdjustments).getAttribute("value"));
			 double ActualSalesTaxTotalLineAdjustments = Double.parseDouble(Browser.instance.findElement(SalesTaxTotalLineAdjustments).getAttribute("value"));
			 int ActualQtyUnAdjustedTotals = Integer.parseInt(Browser.instance.findElement(QtyUnAdjustedTotals).getAttribute("value"));
			 int ActualQtyTotalLineAdjustments = Integer.parseInt(Browser.instance.findElement(QtyTotalLineAdjustments).getAttribute("value"));
			 double ActualNetAmtUnAdjustedTotals = Double.parseDouble(Browser.instance.findElement(NetAmtUnAdjustedTotals).getAttribute("value"));
			 double ActualNetAmtTotalLineAdjustments = Double.parseDouble(Browser.instance.findElement(NetAmtTotalLineAdjustments).getAttribute("value"));
			 double ActualGrossAmtAdjustedTotals = Double.parseDouble(Browser.instance.findElement(GrossAmtAdjustedTotals).getAttribute("value"));
				double ActualSalesTaxAdjustedTotals = Double.parseDouble(Browser.instance.findElement(SalesTaxAdjustedTotals).getAttribute("value"));
				
			double ExpectedActCenterDetailsReadingVariance=(ActualGrossAmtEndReading-ActualActCenterDetailsEnding)-(ActualGrossAmtBeginningReading-ActualActCenterDetailsBeginning);
			double ExpectedActCenterDetailsNetSales= ActualActCenterDetailsGrossSales- ActualActCenterDetailsSalesTax;
			double ExpectedGrossAmtUnAdjustedTotalsFromActCenterDetails=ActualActCenterDetailsEnding-ActualActCenterDetailsBeginning;
			double ExpectedNetAmtUnAdjustedTotals2=ActualGrossAmtUnAdjustedTotals-ActualSalesTaxUnAdjustedTotals;
			double ExpectedSalesTaxUnAdjustedTotals2=ActualActCenterDetailsSalesTax+ActualActCenterDetailsOverride;
			double ExpectedNetAmtTotalLineAdjustments= ActualGrossAmtTotalLineAdjustments- ActualSalesTaxTotalLineAdjustments;
			int ExpectedQtyAdjustedTotals=ActualQtyUnAdjustedTotals-ActualQtyTotalLineAdjustments;
			double ExpectedGrossAmtAdjustedTotals=ActualGrossAmtUnAdjustedTotals-ActualGrossAmtTotalLineAdjustments;
			double ExpectedSalesTaxAdjustedTotals= ActualSalesTaxUnAdjustedTotals-ActualSalesTaxTotalLineAdjustments ;
			double ExpectedNetAmtAdjustedTotals1=ActualNetAmtUnAdjustedTotals-ActualNetAmtTotalLineAdjustments;
			double ExpectedNetAmtAdjustedTotals2=ActualGrossAmtAdjustedTotals-ActualSalesTaxAdjustedTotals;
			
	System.out.println("-----------------Calculations when ActivityCenterDetails is applied---------------------");
			
			NumberFormatterandVerifyCalculations(ExpectedActCenterDetailsReadingVariance,Browser.instance.findElement(ActCenterDetailsReadingVariance).getAttribute("value"));
			//NumberFormatterandVerifyCalculations(ExpectedActCenterDetailsNetSales,Browser.instance.findElement(ActCenterDetailsNetSales).getAttribute("value"));
			NumberFormatterandVerifyCalculations(ExpectedGrossAmtUnAdjustedTotalsFromActCenterDetails,Browser.instance.findElement(GrossAmtUnAdjustedTotals).getAttribute("value"));
			NumberFormatterandVerifyCalculations(ExpectedNetAmtUnAdjustedTotals2,Browser.instance.findElement(NetAmtUnAdjustedTotals).getAttribute("value"));
			
			System.out.println("...........Calculations after Applying Override,Quantity,Gross..........");
			NumberFormatterandVerifyCalculations(ExpectedSalesTaxUnAdjustedTotals2,Browser.instance.findElement(SalesTaxUnAdjustedTotals).getAttribute("value"));
			NumberFormatterandVerifyCalculations(ExpectedNetAmtTotalLineAdjustments,Browser.instance.findElement(NetAmtTotalLineAdjustments).getAttribute("value"));
			IntegerCalculations(ExpectedQtyAdjustedTotals,Browser.instance.findElement(QtyAdjustedTotals).getAttribute("value"));
			NumberFormatterandVerifyCalculations(ExpectedGrossAmtAdjustedTotals,Browser.instance.findElement(GrossAmtAdjustedTotals).getAttribute("value"));
		NumberFormatterandVerifyCalculations(ExpectedSalesTaxAdjustedTotals,Browser.instance.findElement(SalesTaxAdjustedTotals).getAttribute("value"));
			NumberFormatterandVerifyCalculations(ExpectedNetAmtAdjustedTotals1,Browser.instance.findElement(NetAmtAdjustedTotals).getAttribute("value"));
			NumberFormatterandVerifyCalculations(ExpectedNetAmtAdjustedTotals2,Browser.instance.findElement(NetAmtAdjustedTotals).getAttribute("value"));
			
			
			
			}
	
	//Verify New Calculations
	public static void NewCalculations() throws Exception
	{
		Thread.sleep(2000);
		 Browser.instance.findElement(QtyEndReading).sendKeys("1000");
			 Clear(QtyBeginningReading);
				 Browser.instance.findElement(QtyBeginningReading).sendKeys("500");
				 Browser.instance.findElement(GrossAmtEndReading).sendKeys("700.00");
				 Browser.instance.findElement(GrossAmtBeginningReading).sendKeys("300.00");
				 Tab();
	}
	
	//Verify Edited Calculations
	public static void EditedCalculations() throws Exception
	{
		Thread.sleep(2000);
		Clear(QtyEndReading);
		 Browser.instance.findElement(QtyEndReading).sendKeys("5000");
			 Clear(QtyBeginningReading);
				 Browser.instance.findElement(QtyBeginningReading).sendKeys("1000");
				 Browser.instance.findElement(GrossAmtEndReading).sendKeys("250.00");
				 Browser.instance.findElement(GrossAmtBeginningReading).sendKeys("920.00");
				 Tab();
	}
	
	//Save Entries
	public static void SaveEntries() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(saveButton).click();
		String actual=Browser.instance.findElement(CannotSaveMsg).getText();
		String expected="In order to save, the Net Variance must be [0].";
		if(actual.equalsIgnoreCase(expected))
		{
			 Browser.instance.findElement(CannotSaveConfirm).click();
			 System.out.println("In order to save, the Net Variance must be [0].");
			 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			 Clear(ActCenterDetailsEnding);
			 Clear(ActCenterDetailsBeginning);	
			String GrossAmtEndReadingNew = Browser.instance.findElement(GrossAmtEndReading).getAttribute("value");
			String GrossAmtBeginningReadingNew=Browser.instance.findElement(GrossAmtBeginningReading).getAttribute("value");
			Browser.instance.findElement(ActCenterDetailsEnding).sendKeys(GrossAmtEndReadingNew);
			Browser.instance.findElement(ActCenterDetailsBeginning).sendKeys(GrossAmtBeginningReadingNew);
			Tab();
			Browser.instance.findElement(saveButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		 }
		 else
		 {
			 System.out.println("Invalid error message for net Variance");
		 
	}
		
}
	//Cancel Entries
	public static void CancelEntries()
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(CancelConfirm));
		Browser.instance.findElement(CancelConfirm).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
		
	}
	//Add a new Entry Entry
	public static void AddNewtoExistingEntry() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		//Thread.sleep(1000);
		//try {
			//Browser.instance.findElement(ItemSelectionButton).click();
		//}
		//catch(Exception e)
		//{
		//	System.out.println("Click Intercepted Exception handled successfully");
		//	Browser.instance.findElement(ItemSelectionButton).click();
		//}
	
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
		//selectItem("1026",BagIdList);
	
		//Browser.instance.findElement(selectButton).click();
		//Thread.sleep(2000);

		 //Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
		/// LocCode.selectByVisibleText("4790");
		// try {
		//	 Browser.instance.findElement(RetrieveButton).click();
		// }
		//catch(Exception e){
		//	Browser.instance.findElement(RetrieveButton).click();
		//}
	selectBag();
		
	wait.until(ExpectedConditions.elementToBeClickable(newExistingSalesButton));
	Browser.instance.findElement(newExistingSalesButton).click();
	System.out.println("**************************Adding NEW to existing Sales Entries****************************");
	}
	
	//Edit existing entry
	public static void EditExistingEntry() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		//Thread.sleep(1000);
		
		//try {
		//	Browser.instance.findElement(ItemSelectionButton).click();
		//}
		//catch(Exception e)
		//{
		//	System.out.println("Click Intercepted Exception handled successfully");
		//	Browser.instance.findElement(ItemSelectionButton).click();
		//}
	
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
		//selectItem("1026",BagIdList);
	
		//Browser.instance.findElement(selectButton).click();
		//Thread.sleep(2000);
		//try {
		//	Browser.instance.findElement(DiffWorkingDateConfirm).click();
		//	 Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
			 
		//	 LocCode.selectByVisibleText("3290");
		//}
		// catch(Exception e)
		//{
		//Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
		 
		// LocCode.selectByVisibleText("3290");
		//}


		 //try {
			 //Browser.instance.findElement(RetrieveButton).click();
		 //}
		//catch(Exception d){
		//	Browser.instance.findElement(RetrieveButton).click();
		//}
		selectBag();
	wait.until(ExpectedConditions.elementToBeClickable(editExistingSalesButton));
	Browser.instance.findElement(existingLastSalesEntriesList).click();
	Browser.instance.findElement(editExistingSalesButton).click();
	System.out.println("**************************EDIT to existing Sales Entries****************************");
	}

	//Verify Special Event option is displayed or not
	public static void VerifySpecialEvent() throws Exception
	{
		Browser.instance.findElement(exitButton).click();
		 WebDriverWait wait= new WebDriverWait(Browser.instance,30);
		wait.until(ExpectedConditions.elementToBeClickable(dateEntryLink));
		 Browser.instance.findElement(dateEntryLink).click();
		 wait.until(ExpectedConditions.visibilityOf(Browser.instance.findElement(CalendarMaintenanceButton)));
		 try {
			 Browser.instance.findElement(CalendarMaintenanceButton).click();
		 }
		 catch(Exception s)
		 {
			 System.out.println("Calendar Maintenance button is not clickable");
			 Browser.instance.findElement(CalendarMaintenanceButton).click();
		 }
		 
		 wait.until(ExpectedConditions.elementToBeClickable(editButton));
		 Browser.instance.findElement(DateFieldCalendar).sendKeys("05062018");
		 Thread.sleep(2000);
		 Browser.instance.findElement(editButton).click();
		Thread.sleep(1000);
		if(Browser.instance.findElement(SpecialEventCheckBox).isSelected()==false)
		{
			Browser.instance.findElement(SpecialEventCheckBox).click();
			Browser.instance.findElement(saveButton).click();
			 //wait.until(ExpectedConditions.elementToBeClickable(CalendarMaintenanceExitButton));
			Thread.sleep(1000);
			 try {
				 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
			 }
			 catch(Exception e){
				 System.out.println("Element not clickable exception handled successfully");
				 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
			 }
			 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
			 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));
			 Browser.instance.findElement(DateConfirm).click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
			 SalesEntryPage.goTo();
			 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg)); 
		}
		else
		{
		
		Browser.instance.findElement(saveButton).click();
		 //wait.until(ExpectedConditions.elementToBeClickable(CalendarMaintenanceExitButton));
		Thread.sleep(1000);
		 try {
			 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
		 }
		 catch(Exception g){
			 System.out.println("Element not clickable exception handled successfully");
			 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
		 }
		 //Browser.instance.findElement(CalendarMaintenanceExitButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));
		 Browser.instance.findElement(DateConfirm).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		SalesEntryPage.goTo();
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg)); 
		}
		}
	
	//Verify Exclusive Used Location
	public static void VerifyExclusiveUsedLoc() throws Exception
	{
		for(int i=0;i<2;i++)
	
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
//		Thread.sleep(1000);
		try {
		Browser.instance.findElement(ClearButton).click();
		}
		catch(Exception t){
			
			Browser.instance.findElement(ClearButton).click();
		}
		Thread.sleep(1000);
		try {
			Browser.instance.findElement(ItemSelectionButton).click();
		}
		catch(Exception a)
		{
			System.out.println("Click Intercepted Exception handled successfully");
			Browser.instance.findElement(ItemSelectionButton).click();
		}
	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
		selectItem(bagID,BagIdList);
		try {
			Browser.instance.findElement(selectButton).click();
			Thread.sleep(1000);
			
		}
		catch(Exception s)
		{	
			//Browser.instance.findElement(DiffWorkingDateConfirm).click();
			//selectItem("3002",BagIdList);
			Browser.instance.findElement(DiffWorkingDateConfirm).click();
			Browser.instance.findElement(selectButton).click();
			Thread.sleep(1000);
		}
		
	try {
		String actual=Browser.instance.findElement(LocationExclusiveMsg).getText();
		String expected="Location Marked Exclusive";
		
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println(expected+"Message is verified");
		}
		else {
			System.out.println("Location is not made exclusive");
		}
	
	}
	catch(Exception w)
	{
		System.out.println("Exclusive to Location checkbox is not enabled");
	}
				
				
				try {
			 Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
			 
			// LocCode.selectByVisibleText("3290");
			 LocCode.selectByIndex(1);
		}
		 catch(Exception e)
		{

		 Browser.instance.findElement(DiffWorkingDateConfirm).click();
		 Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
		 
		 //LocCode.selectByVisibleText("3290");
		 LocCode.selectByIndex(1);
		}
		 Browser.instance.findElement(BagUsageButton).click();
		Thread.sleep(2000);
		 Browser.instance.findElement(editButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		 Thread.sleep(1000);
		 Select Loc=new Select(Browser.instance.findElement(BagUsageLocationDropdown));
		 //Loc.selectByVisibleText("3290");
		 Loc.selectByIndex(1);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveLocationCheckbox));
		 if(Browser.instance.findElement(ExclusiveLocationCheckbox).isSelected()==false)
			  {
			try
			{
			 Browser.instance.findElement(ExclusiveLocationCheckbox).click();
			}
			catch(Exception f)
			{
				Browser.instance.findElement(ExclusiveLocationCheckbox).click();
				
			}
			 System.out.println("Location checkbox is not enabled.Thus enabling it...");
			 Browser.instance.findElement(saveBagUsageButton).click();

		 }
		 else
		 {
			 System.out.println("Location checkbox is already enabled");
			 Browser.instance.findElement(ExclusiveLocationCheckbox).click();
			 Thread.sleep(1000);
			 Select Loc1=new Select(Browser.instance.findElement(BagUsageLocationDropdown));
			 Loc1.selectByIndex(1);
			 //Loc1.selectByVisibleText("3290");
			 Browser.instance.findElement(saveBagUsageButton).click();

		 }

		Thread.sleep(1000);
		 Browser.instance.findElement(exitBagUsageButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
	}
	
//Enable AutoSales option and Verify	
	public static void AutoSalesEnable() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);

		Browser.instance.findElement(ClearButton).click();
	
	
		
		
			Browser.instance.findElement(ItemSelectionButton).click();

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
			selectItem(bagID,BagIdList);
	
		Browser.instance.findElement(selectButton).click();
Thread.sleep(1000);

			 Select LocCode=new Select(Browser.instance.findElement(LocCodeDropdown));
			 
			 //LocCode.selectByVisibleText("0125");
			 LocCode.selectByIndex(1);

		 Browser.instance.findElement(BagUsageButton).click();
			Thread.sleep(2000);
			 Browser.instance.findElement(editButton).click();
//			 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(BagUsageLocationDropdown));
			 
Select LocCode1=new Select(Browser.instance.findElement(BagUsageLocationDropdown));
			 
			 //LocCode1.selectByVisibleText("0125");
			 LocCode1.selectByIndex(2);
			 Thread.sleep(1000);
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(AutoSalesCheckbox));
			 if(Browser.instance.findElement(AutoSalesCheckbox).isSelected()==false)
				  {
				try
				{
				 Browser.instance.findElement(AutoSalesCheckbox).click();
				 String actual=Browser.instance.findElement(AutoSalesInvalidMsg).getText();
				 String expected="Auto sales requires both an exclusive location and no non-Auto Sales transactions associated with the bag.";
				 if(actual.equalsIgnoreCase(expected))
				 {
					System.out.println(expected+"msg is verified"); 
					Browser.instance.findElement(AutoSalesConfirmButton).click();
					Thread.sleep(1000);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveLocationCheckbox));
					 Browser.instance.findElement(ExclusiveLocationCheckbox).click();
					 Thread.sleep(1000);
					 Browser.instance.findElement(AutoSalesCheckbox).click();
				 }
				}
				catch(Exception f)
				{
					 wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveLocationCheckbox));
					Browser.instance.findElement(ExclusiveLocationCheckbox).click();
					 Thread.sleep(1000);
					Browser.instance.findElement(AutoSalesCheckbox).click();
					
				}
				 System.out.println("AutoSales checkbox is not enabled.Thus enabling it...");
				 Browser.instance.findElement(saveBagUsageButton).click();
				 
				
			 }
			 else
			 {
				 System.out.println("AutoSales checkbox is already enabled");
				 Browser.instance.findElement(AutoSalesCheckbox).click();
				 Thread.sleep(1000);

				 Browser.instance.findElement(saveBagUsageButton).click();
				 

			 }

			Thread.sleep(1000);
			try {
				 Browser.instance.findElement(DiffWorkingDateConfirm).click();
				 Thread.sleep(1000);
				//LocCode1.selectByVisibleText("3050");
				 LocCode1.selectByIndex(1);
				 Browser.instance.findElement(saveBagUsageButton).click();
				Thread.sleep(1000);
				 Browser.instance.findElement(exitBagUsageButton).click();
				 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			}
			catch(Exception q)
			{
				System.out.println("Exception handled");
			}
			 
		}
			 
	//Verify Auto Sales option
public static void VerifyAutoSales() throws Exception
{
	WebDriverWait wait= new WebDriverWait(Browser.instance,10);

	Browser.instance.findElement(ClearButton).click();


	
	
		Browser.instance.findElement(ItemSelectionButton).click();
		Thread.sleep(1000);
		try
		{
			
		 Browser.instance.findElement(DiffWorkingDateConfirm).click();
		 System.out.println("Inside try");
		 Thread.sleep(1000);
		 Browser.instance.findElement(DiffWorkingDateConfirm).click();
		 Thread.sleep(1000);
		
		}
		catch(Exception e)
		{
			Browser.instance.findElement(DiffWorkingDateConfirm).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
		selectItem(bagID,BagIdList);
		}
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
		selectItem(bagID,BagIdList);
		Browser.instance.findElement(selectButton).click();
		Thread.sleep(1000);
		String actual=Browser.instance.findElement(AutoSalesOnlyMsg).getText();
		String expected="This bag is designated for Auto Sales only.";
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println(expected+"Msg is verified successfully");
			Browser.instance.findElement(AutoSalesOnlyConfirmButton).click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Invalid Auto Sales msg");
		}
		 Browser.instance.findElement(BagUsageButton).click();
			Thread.sleep(1000);
			 Browser.instance.findElement(editButton).click();
			 wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(AutoSalesCheckbox));
			 Browser.instance.findElement(AutoSalesCheckbox).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveLocationCheckbox));
			 Browser.instance.findElement(ExclusiveLocationCheckbox).click();
			 Thread.sleep(1000);
			 Browser.instance.findElement(saveBagUsageButton).click();
			 Thread.sleep(1000);
			 Browser.instance.findElement(exitBagUsageButton).click();
			 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			 Browser.instance.findElement(ClearButton).click();
					 
					 
					 
	
	
		

}


//Verify System Options

public static void VerifySystemOptions() throws Exception
{
	WebDriverWait wait= new WebDriverWait(Browser.instance,60);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
	try {
		Browser.instance.findElement(ItemSelectionButton).click();
	}
	catch(Exception e)
	{
		System.out.println("Click Intercepted Exception handled successfully");
		Browser.instance.findElement(ItemSelectionButton).click();
	}

	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BagIdList));
	selectItem(bagID,BagIdList);

	Browser.instance.findElement(selectButton).click();
	Thread.sleep(2000);
	if(Browser.instance.findElement(ApplyAllSalesToBagCheckbox).isSelected()==true)
	{
		System.out.println("SalestoBag checkbox is selected from options module");
	}
	else
	{
		System.out.println("SalestoBag checkbox is not selected ");
	}
	
}


//Number formatter and Verify Calculations

	public static void NumberFormatterandVerifyCalculations(double val,String Result)
	{
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		output = formatter.format(val);
	
		if(output.equalsIgnoreCase(Result))
		{
			System.out.println("The Result is"+output+" :Verified Successfully");
			
		}
		else
		{
			System.out.println(output);
			System.out.println("Calculations are invalid");
		}
		
	}
	
	//Integer type Calculations
	public static void IntegerCalculations(int val,String Result)
	{
		output=Integer.toString(val);
		if(output.equalsIgnoreCase(Result))
		{
			System.out.println("The Result is"+output+" :Verified Successfully");
		}
		else
		{
			System.out.println(output);
			System.out.println("Calculations are invalid");
		}
		
	}
	
	//Select A bag
	public static void selectItem(String BagId,By Locator) {
		List<WebElement> rows = Browser.instance.findElements(Locator);
	    int iSize = rows.size();
	    if (iSize!=0) 
	    {
	    for (int i = 0; i < iSize; i++) 
	    {
	        String sValue = rows.get(i).getText(); 
	        
	                if (sValue.equalsIgnoreCase((BagId))) 
	                {
	                    rows.get(i).click();
	                    break;
	                }
	                }
	    }
	    else {
	    	System.out.println("Grid cell element not found");
	    }
	    
	    
	   }
	
	//Verify whether a string is added or not
	   public static boolean VerifyAdded(String s)
	   {
		   
		   Select select =new Select(Browser.instance.findElement(eventDropdown));
				   Boolean found = false;
		   List<WebElement> allOptions = select.getOptions();
		 
		   for (WebElement we : allOptions) {
			     
	            if (we.getText().contains(s)) {
	                found = true;
		          
		           System.out.println(s+" Value exists ");
		           break;
		       }
		   }
		  return found;
	   }


//Clear text field
public static void Clear(By Locator) 
{
	 Browser.instance.findElement(Locator).sendKeys(Keys.CONTROL,"a");
	    Browser.instance.findElement(Locator).sendKeys(Keys.DELETE);
    

}

//Press Tab Key
public static void Tab() throws Exception
{
	 Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
}

public static void selectBag() {
	WebDriverWait wait= new WebDriverWait(Browser.instance,60);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	Browser.instance.findElement(bagEntryField).clear();
	Browser.instance.findElement(bagEntryField).sendKeys(bagID);
	Browser.instance.findElement(bagEntryField).sendKeys(Keys.TAB);
	wait.until(ExpectedConditions.elementToBeClickable(RetrieveButton)); 
	Browser.instance.findElement(LocCodeDropdown).click();
	Browser.instance.findElement(RetrieveButton).click();
	wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	
}

public static void checkoutBag() {
	bagID= CheckoutBagsPage.BuildBagForCheckout();
	CheckoutBagsPage.goTo();
	CheckoutBagsPage.selectBadgeAndLoc();
	CheckoutBagsPage.selectBag();
	CheckoutBagsPage.saveCheckout();
	CheckoutBagsPage.close();
}





}