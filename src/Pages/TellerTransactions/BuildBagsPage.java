package Pages.TellerTransactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Pages.Maintenance.BagTypePage;

public class BuildBagsPage {
	static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
	static By BuildBtn=By.xpath("//span[.='Build']");
	static By BagTypeDropdown=By.xpath("//select[@name='ddlBagTypes']");
	static By saveButton=By.xpath("//span[.='Save']");
	static By cancelButton=By.xpath("//span[.='Cancel']");
	static By exitButton=By.xpath("//span[.='Exit']");
	static By EmptyToBuiltArrow=By.xpath("//button[@data-ng-if='isLeft']");
	static By BuiltToEmptyArrow=By.xpath("//button[@data-ng-if='!isLeft']");
	static By EmptyBagsList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']");
	static By BuiltBagsList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']");
	static By CountBuiltBags=By.xpath("(//span[contains(@class,'blue-text ng-binding')])[2]");
	static By CountEmptyBags=By.xpath("(//span[contains(@class,'blue-text ng-binding')])[1]");
	static String Select=null;
	static By confirmYesButton = By.xpath("(//button[@type='button'])[10]");
	static String BagID = null;
	
	public static void goTo() 
	{		
		Browser.instance.findElement(TransactionsMenu).click();
		WebElement element = Browser.instance.findElement(By.linkText("Teller Transactions"));
	    Actions action = new Actions(Browser.instance);
	    action.moveToElement(element).build().perform(); 
	    Browser.instance.findElement(By.linkText("Build Bags")).click();
	   // WebDriverWait wait = new WebDriverWait(Browser.instance,10);
	    WebDriverWait wait = new WebDriverWait(Browser.instance,30);
		wait.until(ExpectedConditions.elementToBeClickable(BagTypeDropdown));
		Browser.instance.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	public static void EmptyToBuilt()
	{
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDropdown));
		BagTypeDescription.selectByVisibleText("CERT");
		wait.until(ExpectedConditions.elementToBeClickable(BuildBtn));
		Browser.instance.findElement(BuildBtn).click();
		List<WebElement> rows = Browser.instance.findElements(EmptyBagsList);
	    int iSize = rows.size();
	    //System.out.println("No: of empty bags:"+iSize);
//	    if (iSize!=0)
//	    {
	    for (int i = 0; i < iSize; i++)
	    {
	    	String Select=rows.get(0).getText();
	    	rows.get(0).click();
	    	 Browser.instance.findElement(EmptyToBuiltArrow).click();
	    	 System.out.println(Select+" Bag is converted to built");
	 	    
	        break;
                }
	    
	   // wait.until(ExpectedConditions.elementToBeClickable(EmptyToBuiltArrow));
//	    Browser.instance.findElement(EmptyToBuiltArrow).click();
	    
	   // }
	    
	    //System.out.println(" Bag is converted to built"+Select);
	    
	   Browser.instance.findElement(saveButton).click();
	   wait.until(ExpectedConditions.elementToBeClickable(exitButton));
	   Browser.instance.findElement(exitButton).click();
	   //Browser.instance.findElement(exitButton).click();
	   
		}
	//Verify The Empty Bag
	
		public static void VerifyEmptyBag() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDropdown));
			BagTypeDescription.selectByVisibleText("GREYBOX");
			Browser.instance.findElement(BuildBtn).click();
			Thread.sleep(2000);
			List<WebElement> EmptyBags = Browser.instance.findElements(EmptyBagsList);
			
		    int ListSize = EmptyBags.size();
		
			if (ListSize!=0) 
		    {
		    	
			for(int i=0;i<ListSize;i++)
			{
				String sValue = EmptyBags.get(i).getText(); 
	            if (sValue.equalsIgnoreCase(BagTypePage.GetRandomBagId)) 
	            {
	            	EmptyBags.get(i).click();
	            	System.out.println("Bag is found in Empty Bags List");
	                break;
	            }
			}
		    }
	else

		System.out.println("Grid cell element not found");


	}	
		
		
		//Convert to Built
		public static void ConvertToBuit()
		{
			Browser.instance.findElement(EmptyToBuiltArrow).click();
			Browser.instance.findElement(saveButton).click();
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		}

		//Method to Select bag
		public static void SelectBag(String BagType)
		{
			Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDropdown));
			BagTypeDescription.selectByVisibleText(BagType);
		}
		
		//Select New Bag
		public static void SelectNewBag() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(Browser.instance,10);
			SelectBag("GREYBOX");
			Browser.instance.findElement(BuildBtn).click();
			Thread.sleep(2000);
		
	List<WebElement> EmptyBags1 = Browser.instance.findElements(EmptyBagsList);
			
		    int ListSize = EmptyBags1.size();
			//System.out.println("No of EmptyBags to this BagType is "+ListSize);
			if (ListSize!=0) 
		    {
		    	
			for(int i=0;i<ListSize;i++)
			{
				String sValue = EmptyBags1.get(i).getText(); 
	            if (sValue.equalsIgnoreCase(BagTypePage.GetRandomBagId)) 
	            {
	            	EmptyBags1.get(i).click();
	            	System.out.println("Bag is found in Empty Bags List");
	                break;
	            }
			}
		    }
		}
		
		//Exit Page
		public static void Exit()
		{
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			Browser.instance.findElement(exitButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
			
		}

	public static void close() {
		Browser.instance.findElement(exitButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
		
	}

	public static void selectBagType() {
		Select bagTypeValue = new Select(Browser.instance.findElement(BagTypeDropdown));
		bagTypeValue.selectByVisibleText("AutomationTestBagType");
		
		
	}

	public static boolean isBagTypeDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean isBagMakeUpCorrect() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void buildOnebag() {
		Browser.instance.findElement(BuildBtn).click();
		
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		//BagID= null;
		
		List<WebElement> ids = Browser.instance.findElements(EmptyBagsList);
	    //int iSize = ids.size();
	    for (WebElement we : ids) 
	    {
	    	BagID = we.getText();
	    	we.click();
	    	//ids.get(0).click();
	    	//String BagID=ids.get(0).getText();
	    	Browser.instance.findElement(EmptyToBuiltArrow).click();
	 	    
	        break;
                }
	    Browser.instance.findElement(saveButton).click();
	    wait.until(ExpectedConditions.elementToBeClickable(BuildBtn));
	    System.out.println("The Bag built is: " +BagID);
	}

	public static boolean isBagStatusUpdated() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void emptyOnebag() {
Browser.instance.findElement(BuildBtn).click();
		
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		List<WebElement> rows = Browser.instance.findElements(BuiltBagsList);
	    int iSize = rows.size();
	    for (int i = 0; i < iSize; i++) 
	    {
	    	//String Select=rows.get(0).getText();
	    	rows.get(0).click();
	    	 Browser.instance.findElement(BuiltToEmptyArrow).click();
	 	    
	        break;
                }
	    Browser.instance.findElement(saveButton).click();
	    wait.until(ExpectedConditions.elementToBeClickable(BuildBtn));
	}

	public static boolean isCheckedOutBagDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean isChangesNotSaved() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void buildAndCancel() {
Browser.instance.findElement(BuildBtn).click();
		
		WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		List<WebElement> rows = Browser.instance.findElements(EmptyBagsList);
	    int iSize = rows.size();
	    for (int i = 0; i < iSize; i++) 
	    {
	    	//String Select=rows.get(0).getText();
	    	rows.get(0).click();
	    	 Browser.instance.findElement(EmptyToBuiltArrow).click();
	 	    
	        break;
                }
	    Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(BuildBtn));
	}

	public static String BuildBagForCheckout() {
		//BagID = null;
		selectBagType();
		buildOnebag();
		return BagID;
		// TODO Auto-generated method stub
		
	}

	public static void checkoutbagToCheckStatus() {
		// TODO Auto-generated method stub
		CheckoutBagsPage.checkoutbagToCheckStatus(BagID);
	}

	public static void checkReturnedStatus() {
		// TODO Auto-generated method stub
		
	}



}