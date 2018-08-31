package Pages.TellerTransactions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;
import Initialization.DatabaseConnection;
//import org.apache.xerces.util.SynchronizedSymbolTable;

public class AttendanceEntryPage {
	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By editButton=By.xpath("//span[.='Edit']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By cancelConfirmButton=By.xpath("//button[.='Yes']");
	static By deleteButton=By.xpath("//span[.='Delete']");
	static By newButton=By.xpath("//span[.='New']");
	static By RemoveButton=By.xpath("//button[.='Remove']");
	static By ConfirmDeleteButton=By.xpath("//button[.='Yes']");
	static By DateFieldCalendar=By.id("dtCmDate");
	static By AttendanceBatchDescriptionField=By.xpath("//input[@type='text'][1]");
	static By AttendanceBatchDropdownList=By.xpath("//select[@name='attendanceBatches']");
	static By clearButton=By.xpath("//button[.='Clear']");
	static By saveButton=By.xpath("//span[.='Save']");
	static By PLUGateRadioButton=By.xpath("(//label[@class='control-label ng-binding'])[1]");
	static By PLUdropdownlist=By.xpath("//select[@id='ddlPluPart']");
	static By dateEntryLink=By.xpath("//span[@class='date-field ng-binding']");
	static By dateField=By.name("txtCcDate");
	static By closedCCDayMsg=By.xpath("//div[@class='full-width-form']");
	static By closedCCdayConfirm=By.xpath("//button[.='OK']");
	static By DateConfirm=By.xpath("//button[.='OK']");
	static By openCCDayConfirm=By.xpath("//button[.='Yes']");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By CalendarMaintenanceExitButton=By.xpath("//span[.='Exit']");
	static By QuantityField=By.id("txtQty");
	static By AdmissionField=By.id("txtAdmission");
	static By RevenuePerTicket=By.id("txtRevenue");
	static By RevenueTotal=By.id("txtRevenueTotal");
	static By RebatePerTicket=By.id("txtRebate");
	static By RebateTotal=By.id("txtRebateTotal");
	static By TaxPerTicket=By.id("txtTax");
	static By TotalTax=By.id("txtTaxTotal");
	static By PricePerTicket=By.id("txtTprice");
	static By TotalPrice=By.id("txtTpriceTotal");
	static By PLUDesc=By.id("txtPluDesc");
	static By addButton=By.xpath("//button[.='Add']");
	static By BufferImg=By.xpath("(//img)[1]");
	static By TaxCode1=By.id("txtTaxCode1");
	static By TaxCode2=By.id("txtTaxCode2");
	static By TaxCode3=By.id("txtTaxCode3");
	static By CalendarMaintenanceButton=By.id("btnCalendarMaintenance");
	static By eventDropdown=By.xpath("//select[@data-ng-model='events.eventId']");
	static String QuantityHeader;
	static String Quantity;
	static int QtyVal;
	static By SpecialEventCheckBox=By.xpath("(//input[@type='checkbox'])[4]");
	static By PLUIdGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div/div[1][contains(@class,'ui-grid-coluiGrid-0005')]");
	static By PLUDescGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[2]");
	static By LastPLUDescGridList=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[2])[last()]");
	static By QuantityGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[3]");
	static By RevenueGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[4]");
	static By TaxGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[5]");
	static By RebateGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[6]");
	static By TotalGridList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[7]");
	static By QtyHeaderGrid=By.xpath("(//span[@class='ui-grid-header-cell-label ng-binding'])[3]");
	static By RevenueHeaderGrid=By.xpath("(//span[@class='ui-grid-header-cell-label ng-binding'])[4]");
	static By TaxHeaderGrid=By.xpath("(//span[@class='ui-grid-header-cell-label ng-binding'])[5]");
	static By RebateHeaderGrid=By.xpath("(//span[@class='ui-grid-header-cell-label ng-binding'])[6]");
	static By TotalHeaderGrid=By.xpath("(//span[@class='ui-grid-header-cell-label ng-binding'])[7]");
	static By SumQuantityGrid=By.xpath("(//input[@class='form-control form-control-xs text-right ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	static By SumRevenueGrid=By.xpath("(//input[@class='form-control form-control-xs text-right ng-pristine ng-untouched ng-valid ng-not-empty'])[2]");
	static By SumTaxGrid=By.xpath("(//input[@class='form-control form-control-xs text-right ng-pristine ng-untouched ng-valid ng-not-empty'])[3]");
	static By SumRebateGrid=By.xpath("(//input[@class='form-control form-control-xs text-right ng-pristine ng-untouched ng-valid ng-not-empty'])[4]");
	static By SumTotalValueGrid=By.xpath("(//input[@class='form-control form-control-xs text-right ng-pristine ng-untouched ng-valid ng-not-empty'])[5]");
	static String output;
	static String Query;
	static By EntryModeAllRadioButton=By.xpath("(//input[@type='radio'])[4]");
	 static String Desc=null;
	 static int PLU=0;
	static By RegisterDropdown=By.xpath("//select[@data-ng-model='registers.registerId']");
	
	//Entering to Attendance Entry Module
	
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
	    Browser.instance.findElement(By.linkText("Attendance Entry")).click();
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
		//Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
		
	}
	
	//Open Attendance Entry with closed CC Date
public static void ClosedCCDay() throws Exception
{
	 
	   WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	   
	 Browser.instance.findElement(newButton).click();
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
		 System.out.println("Invalid dates");
	 
}
	
	 
}

	//Reopen Attendance Entry with New date
	public static void ReOpenCCDay() throws Exception
	{
	
	
		 Browser.instance.findElement(dateEntryLink).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));
		 Thread.sleep(1000);
			Browser.instance.findElement(dateField).sendKeys("05052018");
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
	
	
	
}
	
	//Adding a new entry 
	
	public static void NewAttendanceEntry() throws Exception
	{
		
		
		Browser.instance.findElement(newButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		  Browser.instance.findElement(PLUGateRadioButton).click();
		  Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Browser.instance.findElement(AttendanceBatchDescriptionField).sendKeys("Test");

		   Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   Browser.instance.findElement(clearButton).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(PLUdropdownlist));
		SelectPLUAndAddFields("10000 | Main Gate Regular");
			   
		     
		     }
			   
	//Method to Select PLU and add Fields
	public static void SelectPLUAndAddFields(String s) throws Exception
	{
	Select PLUdropdown=new Select(Browser.instance.findElement(PLUdropdownlist)); 	
	PLUdropdown.selectByVisibleText(s);
		   Thread.sleep(2000);
		   Browser.instance.findElement(QuantityField).sendKeys(Keys.CONTROL,"a");
		    Browser.instance.findElement(QuantityField).sendKeys(Keys.DELETE);
			 Browser.instance.findElement(QuantityField).sendKeys("100");
			   Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   Browser.instance.findElement(AdmissionField).click();  
	}	
	
	//Verify the calculations with inputs that were added before
	
	
	public static void VerifyCalculations()
	{
		Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 double ActualRebatePerTicket = Double.parseDouble(Browser.instance.findElement(RebatePerTicket).getAttribute("value"));

 double ActualTotalRebateValue= Double.parseDouble(Browser.instance.findElement(RebateTotal).getAttribute("value"));
 double ActualTotalTaxCode=Double.parseDouble(Browser.instance.findElement(TotalTax).getAttribute("value"));
 double ActualTotalPrice=Double.parseDouble(Browser.instance.findElement(TotalPrice).getAttribute("value").replaceAll(",", ""));
int ActualQuantity =Integer.parseInt(Browser.instance.findElement(QuantityField).getAttribute("value"));
		
double ActualAdmissionValue = Double.parseDouble(Browser.instance.findElement(AdmissionField).getAttribute("value").replaceAll(",", ""));

double ActualTaxCode1 = Double.parseDouble(Browser.instance.findElement(TaxCode1).getAttribute("value"));
double ActualTaxCode2 = Double.parseDouble(Browser.instance.findElement(TaxCode2).getAttribute("value"));
double ActualTaxCode3 = Double.parseDouble(Browser.instance.findElement(TaxCode3).getAttribute("value"));

  double ExpectedTotalRebateValue = ActualRebatePerTicket*ActualQuantity;
double ExpectedTotalRevenueValue= ActualAdmissionValue-ExpectedTotalRebateValue;

 double ExpectedTotalTaxCode=ActualTaxCode1+ActualTaxCode2+ActualTaxCode3;
 
double ExpectedTotalPrice= ExpectedTotalRebateValue+ExpectedTotalRevenueValue+ExpectedTotalTaxCode;
System.out.println("-----------------Total Price ----------------");
NumberFormatterandVerifyCalculations(ExpectedTotalPrice,Browser.instance.findElement(TotalPrice).getAttribute("value"));
System.out.println("------------------Total Rebate Value------------------");
NumberFormatterandVerifyCalculations(ExpectedTotalRebateValue,Browser.instance.findElement(RebateTotal).getAttribute("value"));
System.out.println("------------------Total Revenue Value------------------");
NumberFormatterandVerifyCalculations(ExpectedTotalRevenueValue,Browser.instance.findElement(RevenueTotal).getAttribute("value"));
System.out.println("------------------Total Tax Code------------------");
NumberFormatterandVerifyCalculations(ExpectedTotalTaxCode,Browser.instance.findElement(TotalTax).getAttribute("value"));



}
	//Adding the entry to grid
	
	public static void AddtoGrid()
	{
		Browser.instance.findElement(addButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));

	}
	
	//Add multiple PLU to grid and Verifying the calculations.
	
	public static void AddmultiplePLUandVerifyCalculationsGrid() throws Exception
	{

		AddandVerifyNewPLU("100 | Parking Refund");
				
		}
	
	//Method to Add and Verify New PLU Grid Calculations
	public static void AddandVerifyNewPLU(String q) throws Exception
	{
	String RevenueHeader = Browser.instance.findElement(RevenueHeaderGrid).getText();
	String TaxHeader = Browser.instance.findElement(TaxHeaderGrid).getText();
	String RebateHeader = Browser.instance.findElement(RebateHeaderGrid).getText();
	String TotalHeader = Browser.instance.findElement(TotalHeaderGrid).getText();
	
	 WebElement SumRevenue = Browser.instance.findElement(SumRevenueGrid);
	 WebElement SumTax = Browser.instance.findElement(SumTaxGrid);
	 WebElement SumRebate = Browser.instance.findElement(SumRebateGrid);
	 WebElement SumTotalValue = Browser.instance.findElement(SumTotalValueGrid);
	
	
	 		SelectPLUAndAddFields(q);
		   Browser.instance.findElement(addButton).click();
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));

			QuantityGridCalculations();
			GridListCalculations(RevenueHeader,Browser.instance.findElements(RevenueGridList),SumRevenue.getAttribute("value"));
		
			GridListCalculations(TaxHeader,Browser.instance.findElements(TaxGridList),SumTax.getAttribute("value"));
			GridListCalculations(RebateHeader,Browser.instance.findElements(RebateGridList),SumRebate.getAttribute("value"));
			GridListCalculations(TotalHeader,Browser.instance.findElements(TotalGridList),SumTotalValue.getAttribute("value"));
	}
	//Removing one PLU from grid
	
	public static void RemovePLUFromGrid()
	{
		
	    
	Actions action = new Actions(Browser.instance).doubleClick(Browser.instance.findElement(LastPLUDescGridList));
		action.build().perform();
		
		Browser.instance.findElement(QuantityField).click();
		Browser.instance.findElement(QuantityField).click();
		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		    wait.until(ExpectedConditions.elementToBeClickable(RemoveButton));
		     Browser.instance.findElement(RemoveButton).click();
		     Browser.instance.findElement(saveButton).click();
		     wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
	}
	
	//Editing the added PLU 
	
	public static void EditPLU() throws Exception
	{
		
		Thread.sleep(1000);
	


		 Browser.instance.findElement(editButton).click();

		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	    WebElement wb = Browser.instance.findElement(AttendanceBatchDescriptionField);
	    System.out.println(wb.isDisplayed());
	    wb.click();
	    wb.clear();

	    Browser.instance.findElement(AttendanceBatchDescriptionField).sendKeys("TestEdited");
	    Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Browser.instance.findElement(clearButton).click();
		 Select PLUdropdown=new Select(Browser.instance.findElement(PLUdropdownlist));
	
  PLUdropdown.selectByVisibleText("1000 | Bring-a-Friend-Free Ticket Voucher");

	   Thread.sleep(2000);
	   Browser.instance.findElement(QuantityField).sendKeys(Keys.CONTROL,"a");
	    Browser.instance.findElement(QuantityField).sendKeys(Keys.DELETE);
		 Browser.instance.findElement(QuantityField).sendKeys("100");
		   Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Browser.instance.findElement(AdmissionField).click();  
			Browser.instance.findElement(addButton).click();
		
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			Browser.instance.findElement(saveButton).click();
			 wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

		
	}
	
	//Delete the created Attendance Entry
	
	public static void DeleteAttendanceBatch() throws Exception
	{
		Thread.sleep(1000);
		 Select PLUdropdown=new Select(Browser.instance.findElement(AttendanceBatchDropdownList));

   	   PLUdropdown.selectByVisibleText("Test");
   	Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	Browser.instance.findElement(deleteButton).click();
   	if(Browser.instance.findElement(ConfirmDeleteButton).isDisplayed())
   	{
   		Browser.instance.findElement(ConfirmDeleteButton).click();
   	 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
   		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
   	}
   	else
   	{
   		System.out.println("Invalid delete confirmation");
   	}
   	   }
	
	
	//Verify Special Event is enabled or not 
	
	public static void VerifySpecialEvent() throws Exception
	{
		Browser.instance.findElement(exitButton).click();
		 WebDriverWait wait= new WebDriverWait(Browser.instance,60);
		wait.until(ExpectedConditions.elementToBeClickable(dateEntryLink));
		 Browser.instance.findElement(dateEntryLink).click();
		
		 Thread.sleep(1000);
		 try {
			 Browser.instance.findElement(CalendarMaintenanceButton).click();
		 }
		 catch(Exception s)
		 {
			 System.out.println("Calendar Maintenance button is not clickable");
			 Browser.instance.findElement(CalendarMaintenanceButton).click();
		 }
		 
		 wait.until(ExpectedConditions.elementToBeClickable(editButton));
		 Browser.instance.findElement(DateFieldCalendar).sendKeys("05052018");
		 Thread.sleep(2000);
		 Browser.instance.findElement(editButton).click();
		Thread.sleep(1000);
		if(Browser.instance.findElement(SpecialEventCheckBox).isSelected()==false)
		{
			Browser.instance.findElement(SpecialEventCheckBox).click();
			Browser.instance.findElement(saveButton).click();
			 
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
			 AttendanceEntryPage.goTo();
			 wait.until(ExpectedConditions.elementToBeClickable(newButton));
			 Browser.instance.findElement(newButton).click();
		}
		else
		{
		
		Browser.instance.findElement(saveButton).click();
		
		Thread.sleep(1000);
		 try {
			 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
		 }
		 catch(Exception g){
			 System.out.println("Element not clickable exception handled successfully");
			 Browser.instance.findElement(CalendarMaintenanceExitButton).click();
		 }

		 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));
		 Browser.instance.findElement(DateConfirm).click();
		
		 Thread.sleep(1000);
		 AttendanceEntryPage.goTo();
		 wait.until(ExpectedConditions.elementToBeClickable(newButton));
		 try {
			 Browser.instance.findElement(newButton).click(); 
		 }
		catch(Exception g)
		 {
			System.out.println("Not clickable exception handled");
			 Browser.instance.findElement(newButton).click();
		 }
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg)); 
		}

	}
	
	//Adding a new Entry with Entry Mode as All
	
	public static void EntryModeAll() throws Exception
	{
		 WebDriverWait wait= new WebDriverWait(Browser.instance,60);
		 
		 Browser.instance.findElement(newButton).click();
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg)); 
		 
		 
		Browser.instance.findElement(AttendanceBatchDescriptionField).sendKeys("TestEntryModeAll");
		  Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Browser.instance.findElement(clearButton).click();
			 Browser.instance.findElement(EntryModeAllRadioButton).click();
			Select PLUdropdown=new Select(Browser.instance.findElement(PLUdropdownlist));
	  	  PLUdropdown.selectByVisibleText("10000 | Main Gate Regular");

			   Thread.sleep(2000);
			   Browser.instance.findElement(QuantityField).sendKeys(Keys.CONTROL,"a");
			    Browser.instance.findElement(QuantityField).sendKeys(Keys.DELETE);
				 Browser.instance.findElement(QuantityField).sendKeys("100");
 
				   Tab();
				   Thread.sleep(1000);
				   Clear(TaxCode1);
				   Browser.instance.findElement(TaxCode1).sendKeys("725.00");
				   Tab();
				   System.out.println("------------------------Calculations For Entry Mode All------------------------");
				   
				   VerifyCalculations();
				   AddtoGrid();
				   AddandVerifyNewPLU("10043559 | AAA NAtional Summer Sale SFOT");
				   Browser.instance.findElement(cancelButton).click();
				   wait.until(ExpectedConditions.elementToBeClickable(cancelConfirmButton));
				   Browser.instance.findElement(cancelConfirmButton).click();
				   wait.until(ExpectedConditions.elementToBeClickable(exitButton));
				   Browser.instance.findElement(exitButton).click();
	
	}
	
	
	
	
	//Verify Grid List Calculations
	
	public static void GridListCalculations(String HeaderName,List<WebElement> Grid,String Sum)
	{

			 List<WebElement> column3 =  Grid;
		 int row_num=1;
		double SumVal=0.0d;

		  for (WebElement tdElement1 : column3 ) 
		  {
			 
		        System.out.println(HeaderName+ " for row # " + row_num + ", totalval=" +tdElement1.getText());
			 String totalval=tdElement1.getText().replaceAll(",", "");

		      SumVal=SumVal+Double.parseDouble(totalval);
		      
		      

		   row_num++;
		  }
		 
	      NumberFormat formatter = NumberFormat.getNumberInstance();
	      formatter.setMinimumFractionDigits(2);
	      formatter.setMaximumFractionDigits(2);
	      output = formatter.format(SumVal);
	      //SumStr= Double.toString(SumVal);
		 System.out.println("Total Value for "+HeaderName+ " is:" +output);
		 
		
	
	
	if(output.equalsIgnoreCase(Sum))

		{
			System.out.println("The Grid sum for "+HeaderName+" is matching");
		}
		else {
			System.out.println("Invalid grid sum for "+HeaderName);
		}
	}
	
	
	// GridCalculations for Quantity
	public static void QuantityGridCalculations()
	{
		String QuantityHeader = Browser.instance.findElement(QtyHeaderGrid).getText();
		 WebElement SumQuantity = Browser.instance.findElement(SumQuantityGrid);
		 List<WebElement> column3 = Browser.instance.findElements(QuantityGridList);
		 int row_num=1;
		int SumValue=0;

		  for (WebElement tdElement1 : column3 ) 
		  {
			 
		        System.out.println("Quantity for row # " + row_num + ", totalval=" +tdElement1.getText());
			 String totalval=tdElement1.getText();

		      SumValue=SumValue+Integer.parseInt(totalval);
		      
		    Quantity= String.valueOf(SumValue);

		   row_num++;
		  }
		  
		 System.out.println("Total Quantity is: "+Quantity);
		  if(Quantity.equalsIgnoreCase(SumQuantity.getAttribute("value")))
				{
					System.out.println("The Grid sum for "+QuantityHeader+" is matching");
				}
				else {
					System.out.println("Invalid grid sum for "+QuantityHeader);
				}
			}
	
	//Verify the Calculations
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
			System.out.println("Calculations are invalid");
		}
		
	}
	
	//Convert String to Numeric Value
	public static double StringtoNumeric(String Val)
	{
			try
		  { 
		     return Double.parseDouble(Val);
		  }
		 catch(Exception E) 
		  {
		     return 0; 
		  }
		}

		
//Verify whether a data is added or not
	   public static boolean VerifyAdded(String s)
	   {
		   
		   Select select =new Select(Browser.instance.findElement(eventDropdown));
				   Boolean found = false;
		   List<WebElement> allOptions = select.getOptions();
		  // System.out.println(allOptions.size());
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
	   
	   //Pressing tab key
	   public static void Tab() throws Exception
	   {
	   	 Robot robot = new Robot();
	   		robot.keyPress(KeyEvent.VK_TAB);
	   	robot.keyRelease(KeyEvent.VK_TAB);
	   }

	//Selcting from dropdown using part of visible Text
	   
	   public static void PartialTextDropdown(String db)
	   {
		   List <WebElement> optionsInnerText= Browser.instance.findElements(By.tagName("option"));

		     for(WebElement text: optionsInnerText){

		    String textContent = text.getAttribute("label");

		    if(textContent.toLowerCase().contains(db.toLowerCase()))
		    	text.click();
		    break;
		          
		    }
	   }
	
	}























