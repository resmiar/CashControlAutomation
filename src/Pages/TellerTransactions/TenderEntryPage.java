package Pages.TellerTransactions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;

public class TenderEntryPage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By saveButton=By.xpath("//span[.='Save']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By CancelConfirm=By.xpath("//button[.='Yes']");
	static By EntryProfileDropdown=By.xpath("//select[@name='ddlEntryProfile']");
	static By EntryTypeDropdown=By.xpath("//select[@ng-model='selectedObject.selectedEntryType']");
	static By TimeDropdown=By.xpath("//select[@ng-model='selectedObject.selectedEntryTime']");
	static By LocDropdown=By.xpath("//select[@ng-model='selectedObject.selectedLocationCode']");
	static By bagIdinputField = By.xpath("//input[@ng-model = 'selectedObject.txtBagNum']");
	static By BagSelectionButton=By.xpath("(//button[@class='btn-primary theme-commen-button'])[2]");
	static By BufferImg=By.xpath("(//img)[1]");
	static By DiffWorkingDateConfirm=By.xpath("//button[.='OK']");
	static By BagIdList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div/div[1][contains(@ng-dblclick,'grid.appScope.onDblClick(row)')]");
	static By selectButton=By.xpath("//button[.='Select']");
	static By closedCCdayConfirm=By.xpath("//button[.='OK']");
	static By closedCCDayMsg=By.xpath("//div[@class='full-width-form']");
	static By DateConfirm=By.xpath("//button[.='OK']");
	static By openCCDayConfirm=By.xpath("//button[.='Yes']");
	static By dateEntryLink=By.xpath("//span[@class='date-field ng-binding']");
	static By dateField=By.name("txtCcDate");
	static By BagCheckoutButton=By.xpath("//button[.='Bag Checkout']");
	static By BagCheckoutTitle=By.xpath("(//div[@class='col-sm-12 clear-padding ng-binding'])[1]");
	static By BagCheckoutExitButton=By.xpath("(//span[.='Exit'])[1]");
	static By EmployeesButton=By.xpath("//button[.='Employees']");
	static By EmployeeMaintenanceTitle=By.xpath("(//div[@class='col-sm-12 clear-padding ng-binding'])[1]");
	static By EmployeeMaintenanceExitButton=By.xpath("(//span[.='Exit'])[1]");
	static By ExistingTenderEntriesNewButton=By.xpath("//button[.='New']");
	static By ExistingTenderEntriesEditButton=By.xpath("//button[.='Edit']");
	static By ExistingTenderEntriesCancelButton=By.xpath("//button[.='Cancel']");
	static By ExistingTenderEntriesTitle=By.xpath("(//div[@class='col-sm-12 clear-padding'])[1]");
	static By ExistingTenderEntriesDropdown=By.xpath("//select[@ng-model='selectedObject.selectedCashTransEntryDates']");
	
	static By BillsPickupQuantity=By.id("txtQty_Page1_Column1_Row0");
	static WebElement BillsPickupQuantityNew;
	static By BillsPickupAmount=By.id("txtAmt_Page1_Column1_Row0");
	static By RolledCoinsPenniesQty=By.id("txtQty_Page1_Column2_Row0");
	static By RolledCoinsPenniesAmount=By.id("txtAmt_Page1_Column2_Row0");
	static By RolledCoinsNickelsQty=By.id("txtQty_Page1_Column2_Row1");
	static By RolledCoinsNickelsAmount=By.id("txtAmt_Page1_Column2_Row1");
	static By RolledCoinsDimesQty=By.id("txtQty_Page1_Column2_Row2");
	static By RolledCoinsDimesAmount=By.id("txtAmt_Page1_Column2_Row2");
	static By RolledCoinsQuartersQty=By.id("txtQty_Page1_Column2_Row3");
	static By RolledCoinsQuartersAmount=By.id("txtAmt_Page1_Column2_Row3");
	static By LooseCoinAmount=By.id("txtAmt_Page1_Column3_Row0");
	static By BillsTotalAmount=By.id("txtTotalAmt_Page_1_Column_1");
	static By RolledCoinsTotalAmount=By.id("txtTotalAmt_Page_1_Column_2");
	static By LooseCoinsTotalAmount=By.id("txtTotalAmt_Page_1_Column_3");
	static String output;
	static By ChecksTravellersAmount=By.id("txtAmt_Page2_Column1_Row0");
	static By ChecksPersonalButton=By.id("cmdCC_Details_Page2_Column1_Row1");
	static By ChecksPersonalAmount=By.id("txtAmt_Page2_Column1_Row1");
	
	static By TenderEntryRecordsFirst=By.id("txtAmount_0");
	static By TenderEntryRecordsLast=By.id("txtAmount_-1");
	static By TenderEntryRecordsOKButton=By.xpath("//button[.='OK']");
	static By ChecksTotalAmount=By.id("txtTotalAmt_Page_2_Column_1");

	
	static By CreditCardsAmount=By.id("txtAmt_Page2_Column2_Row0");
	static By CreditCardsTicketOfficeAmount=By.id("txtAmt_Page2_Column2_Row1");
	static By CreditCardsNonPOSButton=By.id("cmdCC_Details_Page2_Column2_Row2");
	static By CreditCardsNonPOSAmount=By.id("txtAmt_Page2_Column2_Row2");
	static By CreditCardsFunnyMoneyAmount=By.id("txtAmt_Page2_Column2_Row3");
	static By CreditCardsTipsAmount=By.id("txtAmt_Page2_Column2_Row4");
	static By BillsCoinsTab=By.xpath("(//a[@class='nav-link ng-binding'])[1]");
	static By ChecksCCTab=By.xpath("(//a[@class='nav-link ng-binding'])[2]");
	static By ARScripsTab=By.xpath("(//a[@class='nav-link ng-binding'])[3]");
	static By CreditCardsTotalAmount=By.id("txtTotalAmt_Page_2_Column_2");
	
	static By AcctsCodeDropdown=By.id("ddlCode_Page3_Column1_Row_tdCode");
	static By AcctsARDescriptionDropdown=By.id("ddlAr_Description_Page3_Column1_Row_tdDesc");
	static By AcctsAmount=By.xpath("(//input[@id='txtObj4Amt_Page3_Column1_Row_'])[1]");
	static By AcctsAmountGridList=By.xpath("//td[@class='ng-binding']/..//td[3]");
	
	static By ScripCaterMemoAmount=By.id("txtAmt_Page3_Column3_Row0");
	static By ScripVIPTourAmount=By.id("txtAmt_Page3_Column3_Row1");
	static By ScripDaffyDollarAmount=By.id("txtAmt_Page3_Column3_Row2");
	static By ScripBugsBucksAmount=By.id("txtAmt_Page3_Column3_Row3");
	static By ScripFoodsAmount=By.id("txtAmt_Page3_Column3_Row4");
	static By ScripGamesAmount=By.id("txtAmt_Page3_Column3_Row5");
	static By ScripFlashPassAmount=By.id("txtAmt_Page3_Column3_Row6");
	static By ScripPhotoAmount=By.id("txtAmt_Page3_Column3_Row7");
	static By ScripSkyCoasterAmount=By.id("txtAmt_Page3_Column3_Row8");
	static By ScripGiftCertPlayAmount=By.id("txtAmt_Page3_Column3_Row9");
	static By ScripFrightPassAmount=By.id("txtAmt_Page3_Column3_Row10");
	static By ScripRegularScripAmount=By.id("txtAmt_Page3_Column3_Row11");
	static By ScripRetailVoucherAmount=By.id("txtAmt_Page3_Column3_Row12");
	static By ScripASFPFlashPassAmount=By.id("txtAmt_Page3_Column3_Row13");
	
	static By AcctsTotalAmount=By.xpath("(//input[@id='txtObj4Amt_Page3_Column1_Row_'])[2]");
	static By ScripTotalAmount=By.id("txtTotalAmt_Page_3_Column_3");
	
	static By TransactionTotal=By.xpath("//input[@ng-model='selectedObject.txtTransTotal']");
	static By CompleteBagTotal=By.xpath("//input[@ng-model='selectedObject.txtCompleteTotal']");
	
	static int RandomNumber;
	static int RandomIndex;
	static String RandomNumberString;
	
	static double ExpectedBillsandCoinsTotalAmount;
	static double ExpectedChecksandCCTotalAmount;
	static double ExpectedARandScripsTotalAmount;
	
	static double ActualBillsTotalAmount;
	static double ActualRolledCoinsTotalAmount;
	static double ActualLooseCoinsTotalAmount;
	
	static By ExistingTenderEntriesBillsAmount=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[2]");
	static By ExistingTenderEntriesLooseCoinAmount=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
	static By ExistingTenderEntriesRolledCoinAmount=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[6]");
	
	static String NewCCDate;
	static String CurrentCCDate;
	static String bagID;
	
	//Goto Tender Entry Page
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
	    Browser.instance.findElement(By.linkText("Tender Entry")).click();
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
	
		}
	
	//Add an Entry with closed CC date
	public static void AddEntryClosedCCDate() throws Exception
	{
		
		SelectDropdown(EntryProfileDropdown,"Everything");
		SelectDropdown(EntryTypeDropdown,"Drop");
		SelectDropdown(TimeDropdown,"2:00 pm");
		//Thread.sleep(1000);
		Browser.instance.findElement(BagSelectionButton).click();
		SelectItem("3079",BagIdList);
		Browser.instance.findElement(selectButton).click();
		Thread.sleep(2000);
		 String Actual=Browser.instance.findElement(closedCCDayMsg).getText();
			
		 String Expected="This CC Day has been closed.";
		 WebDriverWait wait= new WebDriverWait(Browser.instance,60);
		 if(Actual.equalsIgnoreCase(Expected))
		 {
			 Browser.instance.findElement(closedCCdayConfirm).click();
			try {
				 Browser.instance.findElement(closedCCdayConfirm).click();
			}
			catch(Exception e)
			{
				 System.out.println("CC Day has been closed.Trying with new Date");
				 Thread.sleep(1000);
				 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
				 Browser.instance.findElement(exitButton).click();
			}
	
			}
		 
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		//Browser.instance.findElement(DiffWorkingDateConfirm).click();
	}
	
	//New CC Date
	public static void NewCCDate() throws Exception
	{
		NewCCDate="05062018";
		 Browser.instance.findElement(dateEntryLink).click();
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));

			 Thread.sleep(1000);
				Browser.instance.findElement(dateField).sendKeys(NewCCDate);
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
	
		
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));

	
	}
	
	//Add New Tender Entry
	public static void AddNewTenderEntry() throws Exception
	{
		System.out.println("Going to select the bag "+bagID);
		AddNewEntry(bagID,"3345");
	}
	
	//Add New Tender Entry
	public static void AddNewEntry(String BagId,String LocId) throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		SelectDropdown(EntryProfileDropdown,"Everything");
		SelectDropdown(EntryTypeDropdown,"Drop");
		SelectDropdown(TimeDropdown,"2:00 pm");
		Thread.sleep(2000);
		Browser.instance.findElement(bagIdinputField).click();
		Browser.instance.findElement(bagIdinputField).sendKeys(BagId);
		Browser.instance.findElement(bagIdinputField).sendKeys(Keys.TAB);
		//Browser.instance.findElement(BagSelectionButton).click();
		//SelectItem(BagId,BagIdList);
		//Thread.sleep(1000);
		//Browser.instance.findElement(selectButton).click();
		

		try {
			wait.until(ExpectedConditions.elementToBeClickable(DiffWorkingDateConfirm)).click();
			Thread.sleep(1000);
			Browser.instance.findElement(BagSelectionButton).click();
			SelectItem(BagId,BagIdList);
			Thread.sleep(1000);
			Browser.instance.findElement(selectButton).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		}
		catch(Exception h)
		{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		}
		
		
		try {
			SelectDropdown(LocDropdown,LocId);
		}
		catch(Exception g)
		{
			System.out.println("No exception");
		}
	}
	
	//Verify Bills And Coins Calculations
	
	public static void VerifyBillsandCoinsCalculations() throws Exception
	{
		//Entering the inputs
		
		
		
		Clear(BillsPickupQuantity);
		Browser.instance.findElement(BillsPickupQuantity).sendKeys("20");
		Tab();
		Browser.instance.findElement(RolledCoinsPenniesQty).sendKeys("500");
		Clear(RolledCoinsNickelsQty);
		Browser.instance.findElement(RolledCoinsNickelsQty).sendKeys("300");
		Clear(RolledCoinsDimesQty);
		Browser.instance.findElement(RolledCoinsDimesQty).sendKeys("200");
		Clear(RolledCoinsQuartersQty);
		Browser.instance.findElement(RolledCoinsQuartersQty).sendKeys("100");
		Tab();
		Browser.instance.findElement(LooseCoinAmount).sendKeys("40");
		Tab();
		
		//Getting Actual values
		
		 double ActualBillsPickupQty=	Double.parseDouble(Browser.instance.findElement(BillsPickupQuantity).getAttribute("value"));
		 double ActualRolledCoinsPenniesQty=Double.parseDouble(Browser.instance.findElement(RolledCoinsPenniesQty).getAttribute("value"));
		 double ActualRolledCoinsNickelsQty=Double.parseDouble(Browser.instance.findElement(RolledCoinsNickelsQty).getAttribute("value"));
		 double ActualRolledCoinsDimesQty=	Double.parseDouble(Browser.instance.findElement(RolledCoinsDimesQty).getAttribute("value"));
		 double ActualRolledCoinsQuartersQty=Double.parseDouble(Browser.instance.findElement(RolledCoinsQuartersQty).getAttribute("value"));
		
		
		 double ActualBillsPickupAmount = Double.parseDouble(Browser.instance.findElement(BillsPickupAmount).getAttribute("value"));
		 double ActualRolledCoinsPenniesAmount = Double.parseDouble(Browser.instance.findElement(RolledCoinsPenniesAmount).getAttribute("value").replaceAll(",", ""));
		 double ActualRolledCoinsNickelsAmount = Double.parseDouble(Browser.instance.findElement(RolledCoinsNickelsAmount).getAttribute("value").replaceAll(",", ""));
		 double ActualRolledCoinsDimesAmount = Double.parseDouble(Browser.instance.findElement(RolledCoinsDimesAmount).getAttribute("value").replaceAll(",", ""));
		 double ActualRolledCoinsQuartersAmount = Double.parseDouble(Browser.instance.findElement(RolledCoinsQuartersAmount).getAttribute("value").replaceAll(",", ""));
		 
		  ActualBillsTotalAmount = Double.parseDouble(Browser.instance.findElement(BillsTotalAmount).getAttribute("value").replaceAll(",", ""));
		 ActualRolledCoinsTotalAmount = Double.parseDouble(Browser.instance.findElement(RolledCoinsTotalAmount).getAttribute("value").replaceAll(",", ""));
		  ActualLooseCoinsTotalAmount = Double.parseDouble(Browser.instance.findElement(LooseCoinsTotalAmount).getAttribute("value").replaceAll(",", ""));
		 
		 
		 //Expected values
		
		 double ExpectedBillsPickupAmount = ActualBillsPickupQty*1;
		double ExpectedRolledCoinsPenniesAmount = ActualRolledCoinsPenniesQty*0.5;
		double ExpectedRolledCoinsNickelsAmount = ActualRolledCoinsNickelsQty*2;
		double ExpectedRolledCoinsDimesAmount = ActualRolledCoinsDimesQty*5;
		double ExpectedRolledCoinsQuartersAmount = ActualRolledCoinsQuartersQty*10;
		double ExpectedRolledCoinsTotalAmount = ActualRolledCoinsPenniesAmount+ActualRolledCoinsNickelsAmount+ActualRolledCoinsDimesAmount+ ActualRolledCoinsQuartersAmount;
		
		ExpectedBillsandCoinsTotalAmount = ActualBillsTotalAmount+ActualRolledCoinsTotalAmount+ActualLooseCoinsTotalAmount;
		
		//VerifyCalculations
	
		NumberFormatterandVerifyCalculations(ExpectedBillsPickupAmount,Browser.instance.findElement(BillsPickupAmount).getAttribute("value"));
		NumberFormatterandVerifyCalculations(ExpectedRolledCoinsPenniesAmount,Browser.instance.findElement(RolledCoinsPenniesAmount).getAttribute("value"));
		NumberFormatterandVerifyCalculations(ExpectedRolledCoinsNickelsAmount,Browser.instance.findElement(RolledCoinsNickelsAmount).getAttribute("value"));
		NumberFormatterandVerifyCalculations(ExpectedRolledCoinsDimesAmount,Browser.instance.findElement(RolledCoinsDimesAmount).getAttribute("value"));
		NumberFormatterandVerifyCalculations(ExpectedRolledCoinsQuartersAmount,Browser.instance.findElement(RolledCoinsQuartersAmount).getAttribute("value"));
		NumberFormatterandVerifyCalculations(ExpectedRolledCoinsTotalAmount,Browser.instance.findElement(RolledCoinsTotalAmount).getAttribute("value"));
	
	}
	//Verify Checks And CC Calculations
	
	public static void VerifyChecksandCCCalculations() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 
		Browser.instance.findElement(ChecksCCTab).click();
		Thread.sleep(1000);
		Clear(ChecksTravellersAmount);
		Browser.instance.findElement(ChecksTravellersAmount).sendKeys("25");
		Browser.instance.findElement(ChecksPersonalButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TenderEntryRecordsOKButton));
		 Browser.instance.findElement(TenderEntryRecordsFirst).sendKeys("10.00");
		 Browser.instance.findElement(TenderEntryRecordsOKButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(ChecksPersonalButton));
		 Browser.instance.findElement(ChecksPersonalButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TenderEntryRecordsOKButton));
		 Browser.instance.findElement(TenderEntryRecordsLast).sendKeys("40.00");
		 Browser.instance.findElement(TenderEntryRecordsOKButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(ChecksPersonalButton));
		 Browser.instance.findElement(ChecksPersonalButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TenderEntryRecordsOKButton));
		 Browser.instance.findElement(TenderEntryRecordsLast).sendKeys("250.00");
		 Browser.instance.findElement(TenderEntryRecordsOKButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(ChecksPersonalButton));
		 
		 
		 Browser.instance.findElement(CreditCardsAmount).sendKeys("45.00");
		 Browser.instance.findElement(CreditCardsTicketOfficeAmount).sendKeys("35.00");
		 Browser.instance.findElement(CreditCardsNonPOSButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TenderEntryRecordsOKButton));
		 Browser.instance.findElement(TenderEntryRecordsFirst).sendKeys("25.00");
		 Browser.instance.findElement(TenderEntryRecordsOKButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(CreditCardsNonPOSButton));
		 Browser.instance.findElement(CreditCardsNonPOSButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TenderEntryRecordsOKButton));
		 Browser.instance.findElement(TenderEntryRecordsLast).sendKeys("55.00");
		 Browser.instance.findElement(TenderEntryRecordsOKButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(CreditCardsNonPOSButton));
		 Browser.instance.findElement(CreditCardsNonPOSButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(TenderEntryRecordsOKButton));
		 Browser.instance.findElement(TenderEntryRecordsFirst).sendKeys("102.00");
		 Browser.instance.findElement(TenderEntryRecordsOKButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(CreditCardsNonPOSButton));
		 
		 Browser.instance.findElement(CreditCardsFunnyMoneyAmount).sendKeys("15.00");
		 Browser.instance.findElement(CreditCardsTipsAmount).sendKeys("32.00");
		 Tab();
		 
		 //Actual Total Value
	double ActualChecksTravellersAmount= Double.parseDouble(Browser.instance.findElement(ChecksTravellersAmount).getAttribute("value"));
	double ActualChecksPersonalAmount = Double.parseDouble(Browser.instance.findElement(ChecksPersonalAmount).getAttribute("value"));
	double ActualChecksTotalAmount=Double.parseDouble(Browser.instance.findElement(ChecksTotalAmount).getAttribute("value").replaceAll(",", ""));
	
	double ActualCreditCardsAmount = Double.parseDouble(Browser.instance.findElement(CreditCardsAmount).getAttribute("value").replaceAll(",", ""));
	double ActualCreditCardsTicketOfficeAmount = Double.parseDouble(Browser.instance.findElement(CreditCardsTicketOfficeAmount).getAttribute("value").replaceAll(",", ""));
	double ActualCreditCardsNonPOSAmount = Double.parseDouble(Browser.instance.findElement(CreditCardsNonPOSAmount).getAttribute("value").replaceAll(",", ""));
	double ActualCreditCardsFunnyMoneyAmount = Double.parseDouble(Browser.instance.findElement(CreditCardsFunnyMoneyAmount).getAttribute("value").replaceAll(",", ""));
	double ActualCreditCardsTipsAmount = Double.parseDouble(Browser.instance.findElement(CreditCardsTipsAmount).getAttribute("value").replaceAll(",", ""));
	double ActualCreditCardsTotalAmount = Double.parseDouble(Browser.instance.findElement(CreditCardsTotalAmount).getAttribute("value").replaceAll(",", ""));
	
		 //Expected Total Value
	
	double ExpectedChecksTotalAmount=ActualChecksTravellersAmount+ ActualChecksPersonalAmount;
	double ExpectedCreditCardsTotalAmount=ActualCreditCardsAmount+ActualCreditCardsTicketOfficeAmount+  ActualCreditCardsNonPOSAmount+ ActualCreditCardsFunnyMoneyAmount+ActualCreditCardsTipsAmount;
	
	 ExpectedChecksandCCTotalAmount=ActualChecksTotalAmount+ActualCreditCardsTotalAmount;
	
	//Verify Calculations
	
	 NumberFormatterandVerifyCalculations(ExpectedChecksTotalAmount,Browser.instance.findElement(ChecksTotalAmount).getAttribute("value"));
	 NumberFormatterandVerifyCalculations(ExpectedCreditCardsTotalAmount,Browser.instance.findElement(CreditCardsTotalAmount).getAttribute("value"));
		
	}
	
	
	//Verify AR and Scrips Calculations 
	public static void VerifyARandScripsCalculations() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 RandomNumber=generateRandomInteger();
		String RandomNumberString=String.valueOf(RandomNumber);
		 Browser.instance.findElement(ARScripsTab).click();
		Thread.sleep(1000);
		Select dropdown = new Select(Browser.instance.findElement(AcctsARDescriptionDropdown));
		List<WebElement>Options = dropdown.getOptions();
		int iSize=Options.size();
		for(int i=0;i<4;i++)
		{
		RandomIndex=generateRandomIndex(iSize-1);
		 RandomNumber=generateRandomInteger();
		 RandomNumberString=String.valueOf(RandomNumber);
		SelectDropdownByIndex(AcctsARDescriptionDropdown,RandomIndex);
		Browser.instance.findElement(AcctsAmount).sendKeys(RandomNumberString);
		
		Tab();
		}
		Thread.sleep(1000);
	Browser.instance.findElement(ScripCaterMemoAmount).sendKeys("25");
	Browser.instance.findElement(ScripVIPTourAmount).sendKeys("50");
	Browser.instance.findElement(ScripDaffyDollarAmount).sendKeys("320");
	Browser.instance.findElement(ScripBugsBucksAmount).sendKeys("111");
	Browser.instance.findElement(ScripFoodsAmount).sendKeys("15");
	Browser.instance.findElement(ScripGamesAmount).sendKeys("125");
	Browser.instance.findElement(ScripFlashPassAmount).sendKeys("824");
	Browser.instance.findElement(ScripPhotoAmount).sendKeys("222");
	Browser.instance.findElement(ScripSkyCoasterAmount).sendKeys("777");
	Browser.instance.findElement(ScripGiftCertPlayAmount).sendKeys("333");
	Browser.instance.findElement(ScripFrightPassAmount).sendKeys("425");
	Browser.instance.findElement(ScripRegularScripAmount).sendKeys("920");
	Browser.instance.findElement(ScripRetailVoucherAmount).sendKeys("570");
	Browser.instance.findElement(ScripASFPFlashPassAmount).sendKeys("650");
	Tab();
	
	
	//Expected Acctstotal Amount 
	
	 List<WebElement> column3 = Browser.instance.findElements(AcctsAmountGridList);
	  System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column3 .size());
	  int row_num=1;
	double ExpectedAcctsTotalAmount=0.0d;

	  for (WebElement tdElement : column3 ) 
	  {
	      //  System.out.println("row # " + row_num + ", val=" +tdElement.getText());
		 String value=tdElement.getText();
		 System.out.println(value);
		
		 ExpectedAcctsTotalAmount=ExpectedAcctsTotalAmount+Double.parseDouble(value);
	      

	   row_num++;
	  }
	
	  //ActualCalculations for Accts
 double ActualAcctsTotalAmount = Double.parseDouble(Browser.instance.findElement(AcctsTotalAmount).getAttribute("value").replaceAll(",", ""));

//ActualCalculations for Scrip
double ActualScripCaterMemoAmount = Double.parseDouble(Browser.instance.findElement(ScripCaterMemoAmount).getAttribute("value"));
double ActualScripVIPTourAmount = Double.parseDouble(Browser.instance.findElement(ScripVIPTourAmount).getAttribute("value"));
double ActualScripDaffyDollarAmount = Double.parseDouble(Browser.instance.findElement(ScripDaffyDollarAmount).getAttribute("value"));
double ActualScripBugsBucksAmount = Double.parseDouble(Browser.instance.findElement(ScripBugsBucksAmount).getAttribute("value"));
double ActualScripFoodsAmount = Double.parseDouble(Browser.instance.findElement(ScripFoodsAmount).getAttribute("value"));
double ActualScripGamesAmount = Double.parseDouble(Browser.instance.findElement(ScripGamesAmount).getAttribute("value"));
double ActualScripFlashPassAmount = Double.parseDouble(Browser.instance.findElement(ScripFlashPassAmount).getAttribute("value"));
double ActualScripPhotoAmount = Double.parseDouble(Browser.instance.findElement(ScripPhotoAmount).getAttribute("value"));
double ActualScripSkyCoasterAmount = Double.parseDouble(Browser.instance.findElement(ScripSkyCoasterAmount).getAttribute("value"));
double ActualScripGiftCertPlayAmount = Double.parseDouble(Browser.instance.findElement(ScripGiftCertPlayAmount).getAttribute("value"));
double ActualScripFrightPassAmount = Double.parseDouble(Browser.instance.findElement(ScripFrightPassAmount).getAttribute("value"));
double ActualScripRegularScripAmount = Double.parseDouble(Browser.instance.findElement(ScripRegularScripAmount).getAttribute("value"));
double ActualScripRetailVoucherAmount = Double.parseDouble(Browser.instance.findElement(ScripRetailVoucherAmount).getAttribute("value"));
double ActualScripASFPFlashPassAmount = Double.parseDouble(Browser.instance.findElement(ScripASFPFlashPassAmount).getAttribute("value"));

 double ActualScripTotalAmount = Double.parseDouble(Browser.instance.findElement(ScripTotalAmount).getAttribute("value").replaceAll(",", ""));

//Expected Calculations for Scrip

double ExpectedScripTotalAmount = ActualScripCaterMemoAmount+ActualScripVIPTourAmount+ActualScripDaffyDollarAmount+ActualScripBugsBucksAmount+ActualScripFoodsAmount+ActualScripGamesAmount+ActualScripFlashPassAmount+ActualScripPhotoAmount+ActualScripSkyCoasterAmount+ActualScripGiftCertPlayAmount+ActualScripFrightPassAmount+ActualScripRegularScripAmount+ActualScripRetailVoucherAmount+ActualScripASFPFlashPassAmount;

 ExpectedARandScripsTotalAmount = ActualAcctsTotalAmount+ActualScripTotalAmount;

 //VerifyCalculations

NumberFormatterandVerifyCalculations(ExpectedAcctsTotalAmount,Browser.instance.findElement(AcctsTotalAmount).getAttribute("value"));
NumberFormatterandVerifyCalculations(ExpectedScripTotalAmount,Browser.instance.findElement(ScripTotalAmount).getAttribute("value"));

	  
}
	
	//Verify Final Calculations
	
	public static void FinalCalculations()
	{
	 String ActualTransactionTotal = Browser.instance.findElement(TransactionTotal).getAttribute("value");
	String ActualCompleteBagTotal = Browser.instance.findElement(CompleteBagTotal).getAttribute("value").replaceAll(",", "");
	

	
	  double ExpectedTransactionTotal = ExpectedBillsandCoinsTotalAmount+ExpectedChecksandCCTotalAmount+ExpectedARandScripsTotalAmount;
	 
	  NumberFormatterandVerifyCalculations(ExpectedTransactionTotal,ActualTransactionTotal);
	  
	  WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	  Browser.instance.findElement(saveButton).click();
	  //Browser.instance.findElement(cancelButton).click();
	  //wait.until(ExpectedConditions.elementToBeClickable(CancelConfirm));
	  //Browser.instance.findElement(CancelConfirm).click();
	 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	  
	}

	//Verify Employee Page is displayed or not
	public static void VerifyEmployees() throws Exception
	{
		 WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(EmployeesButton).click();
		  wait.until(ExpectedConditions.elementToBeClickable(EmployeeMaintenanceExitButton));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(BufferImg));
		 VerifyTitle(EmployeeMaintenanceTitle,"Employee Maintenance");
		 Thread.sleep(5000);
		  Browser.instance.findElement(EmployeeMaintenanceExitButton).click();
	}
	
	//Verify Bag Checkout Page is displayed or not
	public static void VerifyBagCheckOut() throws Exception
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(BagCheckoutButton));
		Browser.instance.findElement(BagCheckoutButton).click();
		  wait.until(ExpectedConditions.elementToBeClickable(BagCheckoutExitButton));
		 VerifyTitle(BagCheckoutTitle,"Bag Checkout");
		  Browser.instance.findElement(BagCheckoutExitButton).click();
		  wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		  
	}
	
	//Verify values of Existing Tender Entries
public static void VerifyExistingEntries() throws Exception
{
	WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	SelectDropdown(EntryProfileDropdown,"Everything");
		SelectDropdown(EntryTypeDropdown,"Drop");
		SelectDropdown(TimeDropdown,"2:00 pm");
		Thread.sleep(2000);
		//Browser.instance.findElement(BagSelectionButton).click();
		//SelectItem(bagID,BagIdList);
		//Thread.sleep(1000);
		//Browser.instance.findElement(selectButton).click();
		Browser.instance.findElement(bagIdinputField).clear();
		Browser.instance.findElement(bagIdinputField).sendKeys(bagID);
		Browser.instance.findElement(bagIdinputField).sendKeys(Keys.TAB);
	 wait.until(ExpectedConditions.elementToBeClickable(ExistingTenderEntriesNewButton));
	 VerifyTitle(ExistingTenderEntriesTitle,"Existing Tender Entries");
	 Browser.instance.findElement(ExistingTenderEntriesNewButton).click();
	 wait.until(ExpectedConditions.elementToBeClickable(BufferImg));
	 wait.until(ExpectedConditions.elementToBeClickable(BillsCoinsTab));
	 VerifyBillsandCoinsCalculations();
	 Browser.instance.findElement(saveButton).click();
	 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	 //Browser.instance.findElement(BagSelectionButton).click();
	 //SelectItem(bagID,BagIdList);
	 Browser.instance.findElement(bagIdinputField).click();
		Browser.instance.findElement(bagIdinputField).sendKeys(bagID);
		Browser.instance.findElement(bagIdinputField).sendKeys(Keys.TAB);
	 Thread.sleep(1000);
	 
 wait.until(ExpectedConditions.elementToBeClickable(ExistingTenderEntriesNewButton));
 Select select=new Select(Browser.instance.findElement(ExistingTenderEntriesDropdown));
List<WebElement> Options = select.getOptions();
int iSize=Options.size();
System.out.println("No of Tender Entries to this bag is "+iSize);
WebElement LastOption = Options.get(iSize-1);
LastOption.click();
Thread.sleep(1000);
System.out.println("*******************Verifying values of existing Tender entries**********************");
NumberFormatterandVerifyCalculations(ActualBillsTotalAmount,Browser.instance.findElement(ExistingTenderEntriesBillsAmount).getText());
NumberFormatterandVerifyCalculations(ActualLooseCoinsTotalAmount,Browser.instance.findElement(ExistingTenderEntriesLooseCoinAmount).getText());
NumberFormatterandVerifyCalculations(ActualRolledCoinsTotalAmount,Browser.instance.findElement(ExistingTenderEntriesRolledCoinAmount).getText());
Browser.instance.findElement(ExistingTenderEntriesCancelButton).click();
wait.until(ExpectedConditions.elementToBeClickable(exitButton));

}

//Exit Page
	public static void Exit()
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(exitButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		
		
	}
	
	//Fetch Current CCDate
	public static void GetCurrentCCDate() throws Exception
	{
		
	Browser.instance.findElement(dateEntryLink).click();
	WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	 wait.until(ExpectedConditions.elementToBeClickable(DateConfirm));

	 Thread.sleep(1000);
		CurrentCCDate=Browser.instance.findElement(dateField).getAttribute("value");
	 Browser.instance.findElement(DateConfirm).click();
	Thread.sleep(1000);
	}
	
//Verify Title
	public static void VerifyTitle(By Locator,String str)
	{
		  String actual=Browser.instance.findElement(Locator).getText();
		  String Expected=str;
		  if(actual.equalsIgnoreCase(Expected))
		  {
			  System.out.println(actual+" window is verified");
		  }
		  else
		  {
			  System.out.println("Invalid Page ");
		  }
		  
	}
	
	//Verify Calculations
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
			System.out.println("Output is "+output+" and result is "+Result);
			System.out.println("Calculations are invalid");
		}
		
	}
	//Select Dropdown
	public static void SelectDropdown(By Locator,String s)
	{
		Select select=new Select(Browser.instance.findElement(Locator));
				select.selectByVisibleText(s);
	}
	
	
	public static void SelectDropdownByIndex(By Locator,int x)
	{
		Select select=new Select(Browser.instance.findElement(Locator));
		select.selectByIndex(x);
	}
	
	//Select a Bag
	public static void SelectItem(String BagId,By Locator) {
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
	
	//Get RandomInteger
	 public static int generateRandomInteger() {
	    	int min = 0;
	    	int max = 500;
	    		
	    		Random random = new Random();
	    		return random.nextInt((max - min) + 1) + min;   
	    }
	 
	 
	 public  static int generateRandomIndex(int x)
	 {
		 int min = 0;
	    	int max = x;
	    		
	    		Random random = new Random();
	    		return random.nextInt((max - min) + 1) + min;   
	 }
	//Clear text field
	public static void Clear(By Locator) 
	{
		 Browser.instance.findElement(Locator).sendKeys(Keys.CONTROL,"a");
		    Browser.instance.findElement(Locator).sendKeys(Keys.DELETE);
	    

	}
	
	//Press Tab key
	public static void Tab() throws Exception
	{
		 Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public static void checkOutBagForTrans() {
			bagID= CheckoutBagsPage.BuildBagForCheckout();
			CheckoutBagsPage.goTo();
			CheckoutBagsPage.selectBadgeAndLoc();
			CheckoutBagsPage.selectBag();
			CheckoutBagsPage.saveCheckout();
			CheckoutBagsPage.close();
		}

	public static String getBagID() {
		
		return bagID;
	}
		
		
		
	}

	
	
	

