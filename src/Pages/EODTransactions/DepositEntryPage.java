package Pages.EODTransactions;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Initialization.DatabaseConnection;

public class DepositEntryPage {
	
	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By saveButton=By.xpath("//span[.='Save']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By CancelConfirm=By.xpath("//button[.='Yes']");
	static By EntryProfileDropdown=By.xpath("//select[@name='ddlTE_EntryGroups']");
	static By BagSelectionButton=By.xpath("(//button[@class='btn-primary theme-commen-button'])[2]");
	static By depositInputField = By.xpath("//input[@data-ng-model='selectedObject.txtDepositNumber']");
	static By BufferImg=By.xpath("(//img)[1]");
	static By closedCCdayConfirm=By.xpath("//button[.='OK']");
	static By closedCCDayMsg=By.xpath("//div[@class='full-width-form']");
	static By DateConfirm=By.xpath("//button[.='OK']");
	
	static By ExistingTenderEntriesNewButton=By.xpath("//button[.='New']");
	static By ExistingTenderEntriesEditButton=By.xpath("//button[.='Edit']");
	static By ExistingTenderEntriesCancelButton=By.xpath("//button[.='Cancel']");
	static By ExistingTenderEntriesTitle=By.xpath("(//div[@class='col-sm-12 clear-padding'])[1]");
	static By ExistingTenderEntriesDropdown=By.xpath("//select[@ng-model='selectedObject.selectedDepositEntryDates']");
	
	static By BillsPickupQuantity=By.id("txtQty_DE_Page1_Column1_Row0");
	static WebElement BillsPickupQuantityNew;
	static By BillsPickupAmount=By.id("txtAmt_DE_Page1_Column1_Row0");
	static By RolledCoinsPenniesQty=By.id("txtQty_DE_Page1_Column2_Row0");
	static By RolledCoinsPenniesAmount=By.id("txtAmt_DE_Page1_Column2_Row0");
	static By RolledCoinsNickelsQty=By.id("txtQty_DE_Page1_Column2_Row1");
	static By RolledCoinsNickelsAmount=By.id("txtAmt_DE_Page1_Column2_Row1");
	static By RolledCoinsDimesQty=By.id("txtQty_DE_Page1_Column2_Row2");
	static By RolledCoinsDimesAmount=By.id("txtAmt_DE_Page1_Column2_Row2");
	static By RolledCoinsQuartersQty=By.id("txtQty_DE_Page1_Column2_Row3");
	static By RolledCoinsQuartersAmount=By.id("txtAmt_DE_Page1_Column2_Row3");
	static By LooseCoinAmount=By.id("txtAmt_DE_Page1_Column3_Row0");
	static By BillsTotalAmount=By.id("txtTotalAmt_Page_1_Column_1");
	static By RolledCoinsTotalAmount=By.id("txtTotalAmt_Page_1_Column_2");
	static By LooseCoinsTotalAmount=By.id("txtTotalAmt_Page_1_Column_3");
	static String output;
	static By ChecksTravellersAmount=By.id("txtAmt_DE_Page2_Column1_Row0");
	static By ChecksPersonalAmount=By.id("txtAmt_DE_Page2_Column1_Row1");
	
	static By TenderEntryRecordsFirst=By.id("txtAmount_0");
	static By TenderEntryRecordsLast=By.id("txtAmount_-1");
	static By TenderEntryRecordsOKButton=By.xpath("//button[.='OK']");
	static By ChecksTotalAmount=By.id("txtTotalAmt_Page_2_Column_1");

	
	static By CreditCardsAmount=By.id("txtAmt_DE_Page2_Column2_Row0");
	static By CreditCardsTicketOfficeAmount=By.id("txtAmt_DE_Page2_Column2_Row1");
	static By CreditCardsNonPOSAmount=By.id("txtAmt_DE_Page2_Column2_Row2");
	static By CreditCardsFunnyMoneyAmount=By.id("txtAmt_DE_Page2_Column2_Row3");
	static By CreditCardsTipsAmount=By.id("txtAmt_DE_Page2_Column2_Row4");
	static By BillsCoinsTab=By.xpath("(//a[@class='nav-link ng-binding'])[1]");
	static By ChecksCCTab=By.xpath("(//a[@class='nav-link ng-binding'])[2]");
	static By ARScripsTab=By.xpath("(//a[@class='nav-link ng-binding'])[3]");
	static By CreditCardsTotalAmount=By.id("txtTotalAmt_Page_2_Column_2");
	

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


	public static void goTo() {
		Browser.instance.findElement(TransactionsMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("End-of-Day Transactions"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Deposit Entry")).click();
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();}
	}

	public static void addNewEntry() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		
		Browser.instance.findElement(depositInputField).click();
		Browser.instance.findElement(depositInputField).clear();
		Browser.instance.findElement(depositInputField).sendKeys("AutoTestDeposit");
		Browser.instance.findElement(depositInputField).sendKeys(Keys.TAB);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
		
		Clear(BillsPickupQuantity);
		Browser.instance.findElement(BillsPickupQuantity).sendKeys("20");
		try {
			Tab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//cancel adding
	public static void cancelEntry() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(CancelConfirm));
		Browser.instance.findElement(CancelConfirm).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
	
	//save entry
	public static void saveEntry() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}

	//Select Drop down
	public static void SelectDropdown(By Locator,String s)
	{
		Select select=new Select(Browser.instance.findElement(Locator));
				select.selectByVisibleText(s);
	}

	//close the form
	public static void close() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(exitButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
	}

	
			
	//Entering the inputs
	public static void VerifyBillsandCoinsCalculations() {	
			
				Clear(BillsPickupQuantity);
				Browser.instance.findElement(BillsPickupQuantity).sendKeys("20");
				try {
					Tab();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Clear(RolledCoinsPenniesQty);
				Browser.instance.findElement(RolledCoinsPenniesQty).sendKeys("500");
				Clear(RolledCoinsNickelsQty);
				Browser.instance.findElement(RolledCoinsNickelsQty).sendKeys("300");
				Clear(RolledCoinsDimesQty);
				Browser.instance.findElement(RolledCoinsDimesQty).sendKeys("200");
				Clear(RolledCoinsQuartersQty);
				Browser.instance.findElement(RolledCoinsQuartersQty).sendKeys("100");
				try {
					Tab();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				Clear(LooseCoinAmount);
				Browser.instance.findElement(LooseCoinAmount).sendKeys("40");
				try {
					Tab();
				} catch (Exception e) {
		
					e.printStackTrace();
				}
				
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
	
	//Press Tab key
		public static void Tab() throws Exception
		{
			 Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}

		//Clear text field
		public static void Clear(By Locator) 
		{
			 Browser.instance.findElement(Locator).sendKeys(Keys.CONTROL,"a");
			    Browser.instance.findElement(Locator).sendKeys(Keys.DELETE);
		    

		}

	public static void VerifyChecksandCCCalculations() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		 
		Browser.instance.findElement(ChecksCCTab).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		Clear(ChecksTravellersAmount);
		Browser.instance.findElement(ChecksTravellersAmount).sendKeys("25");
		Clear(ChecksTravellersAmount);
		Browser.instance.findElement(ChecksPersonalAmount).sendKeys("25");
		 
		 Browser.instance.findElement(CreditCardsFunnyMoneyAmount).sendKeys("15.00");
		 Browser.instance.findElement(CreditCardsTipsAmount).sendKeys("32.00");
		 try {
			Tab();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
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

	public static void FinalCalculations() {
		String ActualTransactionTotal = Browser.instance.findElement(TransactionTotal).getAttribute("value");
		String ActualCompleteBagTotal = Browser.instance.findElement(CompleteBagTotal).getAttribute("value").replaceAll(",", "");
		

		
		  double ExpectedTransactionTotal = ExpectedBillsandCoinsTotalAmount+ExpectedChecksandCCTotalAmount+ExpectedARandScripsTotalAmount;
		 
		  NumberFormatterandVerifyCalculations(ExpectedTransactionTotal,ActualTransactionTotal);
		  
		  WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		  Browser.instance.findElement(cancelButton).click();
		  wait.until(ExpectedConditions.elementToBeClickable(CancelConfirm));
		  Browser.instance.findElement(CancelConfirm).click();
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}

	public static void VerifyARandScripsCalculations() {
		
		
	}

	public static void VerifyExistingEntries() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		SelectDropdown(EntryProfileDropdown,"Everything");
		Browser.instance.findElement(depositInputField).click();
		Browser.instance.findElement(depositInputField).clear();
		Browser.instance.findElement(depositInputField).sendKeys("AutoTestDeposit");
		Browser.instance.findElement(depositInputField).sendKeys(Keys.TAB);	
			
		 wait.until(ExpectedConditions.elementToBeClickable(ExistingTenderEntriesNewButton));
		 VerifyTitle(ExistingTenderEntriesTitle,"Existing Tender Entries");
		 Browser.instance.findElement(ExistingTenderEntriesNewButton).click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		 VerifyBillsandCoinsCalculations();
		 saveEntry();
	
		 Browser.instance.findElement(depositInputField).click();
		 Browser.instance.findElement(depositInputField).clear();
		 Browser.instance.findElement(depositInputField).sendKeys("AutoTestDeposit");
		 Browser.instance.findElement(depositInputField).sendKeys(Keys.TAB);
		 wait.until(ExpectedConditions.elementToBeClickable(ExistingTenderEntriesNewButton));
		 Select select=new Select(Browser.instance.findElement(ExistingTenderEntriesDropdown));
		 List<WebElement> Options = select.getOptions();
		 int iSize=Options.size();
		 System.out.println("No of Deposit Entries to this bag is "+iSize);
		 WebElement LastOption = Options.get(iSize-1);
		 LastOption.click();
		 try {
			 Thread.sleep(1000);
		 	} 
		 catch (InterruptedException e) {
			 e.printStackTrace();
		 	}
		 System.out.println("*******************Verifying values of existing Deposit entries**********************");
		 NumberFormatterandVerifyCalculations(ActualBillsTotalAmount,Browser.instance.findElement(ExistingTenderEntriesBillsAmount).getText());
		 //NumberFormatterandVerifyCalculations(ActualLooseCoinsTotalAmount,Browser.instance.findElement(ExistingTenderEntriesLooseCoinAmount).getText());
		 //NumberFormatterandVerifyCalculations(ActualRolledCoinsTotalAmount,Browser.instance.findElement(ExistingTenderEntriesRolledCoinAmount).getText());
		 Browser.instance.findElement(ExistingTenderEntriesCancelButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
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
	public static void EditAmountForExistingEntries() {
		
		
	}

	public static void VerifyTenderAmount() {
		
		
	}

	public static void cleanupDepositEntries() {
		String depositNumber = "AutoTestDeposit";
		DatabaseConnection.cleanupDepositEntries(depositNumber);
	}

}
