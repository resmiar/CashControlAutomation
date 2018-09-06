package Pages.TellerTransactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Initialization.Browser;

public class BagUsagePage {

	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By BagSelectButton=By.xpath("//button[@class='btn-primary theme-commen-button']");	
	static By BagIdItemSelectionList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid')]");
	static By SelectButton=By.xpath("//button[.='Select']");
	static By BufferImg=By.xpath("(//img)[1]");
	static By DiffWorkingDateConfirm=By.xpath("//button[.='OK']");
	static By CheckInDate=By.xpath("(//input[contains(@class,' ui-datepicker text-right')])[2]");
	static By BagIdTextField=By.name("txtBagAliasBu");
	static By TenderEntriesList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid-003X')]");
	static By FirstTenderEntry=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid-003X')])[1]");
	static By LastTenderEntry=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid-003X')])[last()]");
	static By TenderEntriesListNew=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid-0067')]");
	static By FirstTenderEntryNew=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid-0067')])[1]");
	static By LastTenderEntryNew=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[1][contains(@class,'coluiGrid-0067')])[last()]");
	static By TotalTender=By.id("txtTenderTotal");
	static By TenderEntrySaveButton=By.xpath("(//span[.='Save'])[1]");
	static By TenderEntryExitButton=By.xpath("(//span[.='Exit'])[1]");
	static By editButton = By.xpath("//span[.='Edit']");
	static By returnButton = By.xpath("//span[.='Return']");
	static By confirmYesButton = By.xpath("//button[.='Yes']");
	static String output,bagID;
	static int RandomNumber;
	static By currentBadge = By.name("txtUpperBadge");
	static By saveButton = By.xpath("//span[.='Save']");
	static By cancelButton = By.xpath("//span[.='Cancel']");
	
	//Go to Bag Usage Page
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
	    Browser.instance.findElement(By.linkText("Bag Usage")).click();
	    WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		
	}
	
	//Verify whether Check In Dates are matching
	
	public static void VerifyCheckInDates() throws Exception
	{
		Browser.instance.findElement(BagIdTextField).sendKeys("3002");
		 Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(1000);

	String BagUsageCheckInDate=Browser.instance.findElement(CheckInDate).getAttribute("value");
	
		if(BagUsageCheckInDate.equalsIgnoreCase(TenderEntryPage.CurrentCCDate))
		{
			System.out.println("CheckIn Date is Verified successfully as"+TenderEntryPage.CurrentCCDate);
		}
		else
		{
			System.out.println("Invalid Date"+TenderEntryPage.CurrentCCDate);
			System.out.println(BagUsageCheckInDate);
		}
	}
	
	//Edit the amount for an existing Tender Entry
	public static void EditAmountForExistingTenderEntries() throws Exception
	{
		RandomNumber=TenderEntryPage.generateRandomInteger();
		String RandomNumberString=String.valueOf(RandomNumber);
		 WebDriverWait wait= new WebDriverWait(Browser.instance,60);
		    
		 Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstTenderEntry));
		 List<WebElement> TenderList = Browser.instance.findElements(TenderEntriesList);
		 int ListSize = TenderList.size();
		System.out.println("No of Tender Entries to this Location is "+ListSize);
		
		for(int i=0;i<ListSize;i++)
		{
			TenderList.get(ListSize-1).click();
			break;
			
		}
		//Actions action = new Actions(Browser.instance).doubleClick(Browser.instance.findElement(LastTenderEntry));
		Actions action = new Actions(Browser.instance);
		action.doubleClick();
		action.build().perform();
		
		
wait.until(ExpectedConditions.visibilityOfElementLocated(BufferImg));
wait.until(ExpectedConditions.elementToBeClickable(TenderEntryPage.BillsCoinsTab));
Clear(TenderEntryPage.BillsPickupQuantity);
Browser.instance.findElement(TenderEntryPage.BillsPickupQuantity).sendKeys(RandomNumberString);
Browser.instance.findElement(TenderEntrySaveButton).click();
wait.until(ExpectedConditions.elementToBeClickable(TenderEntryExitButton));
Browser.instance.findElement(TenderEntryExitButton).click();
wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	}
	
	//Verify the total Tender Entry Amount
	public static void VerifyTenderAmount() throws Exception
	{
		Browser.instance.findElement(BagIdTextField).sendKeys("3002");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(FirstTenderEntryNew));
	    List<WebElement> TenderList1 = Browser.instance.findElements(TenderEntriesListNew);
	 
		  int row_num=1;
			double ExpectedTotalTender=0.0d;
			
			  for (WebElement tdElement : TenderList1 ) 
			  {
			      //  System.out.println("row # " + row_num + ", val=" +tdElement.getText());
				 String value=tdElement.getText();
				 String segments[] = value.split(" ");
					String Amount = segments[segments.length - 1];
					System.out.println(Amount);
					ExpectedTotalTender=ExpectedTotalTender+Double.parseDouble(Amount);
			      row_num++;
			  }
			  String ActualTotalTender = Browser.instance.findElement(TotalTender).getAttribute("value");
			  NumberFormatterandVerifyCalculations(ExpectedTotalTender,ActualTotalTender);
			  
	}
	
	
	//Select an item
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
	
	
	//Number formatter and Verify the Calculations
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
	
	//Clear text field
	public static void Clear(By Locator) 
	{
		 Browser.instance.findElement(Locator).sendKeys(Keys.CONTROL,"a");
		    Browser.instance.findElement(Locator).sendKeys(Keys.DELETE);
	    

	}
	
	//Exit Page
	public static void Exit()
	{
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(exitButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		
		
	}

	public static void checkoutBag() {
		bagID= CheckoutBagsPage.BuildBagForCheckout();
		CheckoutBagsPage.goTo();
		CheckoutBagsPage.selectBadgeAndLoc();
		CheckoutBagsPage.selectBag();
		CheckoutBagsPage.saveCheckout();
		CheckoutBagsPage.close();
	}

	public static void returnBag() {
		Browser.instance.findElement(BagIdTextField).sendKeys(bagID);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(returnButton));
		Browser.instance.findElement(returnButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		
		
		
	}

	public static void close() {
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		Browser.instance.findElement(exitButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
	}

	public static void editAndSaveBag() {
		
		Browser.instance.findElement(BagIdTextField).sendKeys(bagID);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		
		
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
	}

	public static boolean isBagUpdated() {

		return true;
	}

	public static void editAndCancelBag() {
		Browser.instance.findElement(BagIdTextField).sendKeys(bagID);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Browser.instance.findElement(editButton).click();
		WebDriverWait wait= new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		
		
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		
	}

	public static void checkReturnedStatus() {
		BuildBagsPage.checkReturnedStatus(bagID);
		
	}
	}
