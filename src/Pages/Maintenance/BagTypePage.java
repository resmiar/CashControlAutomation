package Pages.Maintenance;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialization.Browser;
import Initialization.GenerateRandomValue;
import Pages.TellerTransactions.BuildBagsPage;


public class BagTypePage {
	
static By maintenanceMenu = By.xpath("//a[contains(text(),'Maintenance')]");
static By newButton= By.xpath("//span[.='New']");
static By editButton=By.xpath("//span[.='Edit']");
static By cancelButton=By.xpath("//span[.='Cancel']");
static By deleteButton=By.xpath("//span[.='Delete']");
static By TransactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
static By exitButton=By.xpath("//span[.='Exit']");
static By saveButton=By.xpath("//span[.='Save']");
static By viewButton=By.xpath("//button[.='View']");
static By BagTypeDescField=By.id("txtBagDesc");
static By BagTypeDescriptionDropdown=By.xpath("//select[contains(@name,'ddlBagDesc')]");
static By BagCodeField=By.name("txtBagCode");
static By addButton=By.xpath("//button[.='Add']");
static By tenderFieldDropdown=By.xpath("//select[@name='ddlTender']");
static By tenderQty=By.xpath("//input[contains(@data-ng-blur,'tenderQty')]");
static By BagTypeSaveBtn=By.xpath("(//button[.='Save'])[1]");
static By BagIdSaveBtn=By.xpath("(//button[.='Save'])[2]");
static By BagTypeCancelBtn=By.xpath("(//button[.='Cancel'])[1]");
static By BagIdCancelBtn=By.xpath("(//button[.='Cancel'])[2]");
static By BagTypeDetailsAddBtn=By.xpath("//button[.='Add']");
static By BagTypeDetailseditBtn=By.xpath("//button[.='Edit']");
static By BagTypeDetailsdeleteBtn=By.xpath("//button[.='Delete']");
static By confirmYesButton=By.xpath("//button[.='Yes']");
static By confirmNoButton=By.xpath("//button[.='No']");
static By BagValueSum=By.xpath("//input[@data-ng-model='vm.bagValue']");
static By BagsTab=By.xpath("//a[.='Bags']");
static By BagTypeDetailsTab=By.xpath("//a[.='Bag Type Details']");
static By BagsField=By.xpath("//*[@id=\"tenderQtyContent\"]/div[2]/div[3]/div/div[1]/div/div[1]/div/div[1]/input");
static By ActiveCheckBox=By.xpath("(//input[@type='checkbox'])[1]");
static By DuplicateBagConfirm=By.xpath("//button[.='OK']");
static By DuplicateBagMsg=By.xpath("//div[@class='full-width-form']");
static By BagIdStatusList=By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])/../../..//div[3]");
static By BagsTest=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..");
static String RandomStringUpdated;
static String RandomString;
static String RandomList;
static int RandomId;
static String output;
static String currentUrl;
static int SumVal=0;
static String SumStr=null;
static By BagTypeColumn=By.xpath("//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope')]");
public static String menuUrl;
static By BagGrid=By.xpath("//div[@id='1523743526831-0-uiGrid-00L1-cell']/../../../..");
public static String selecttender="U.S. Dollar - Accts Recv - Twix Voucher";
public static String selecttender1="U.S. Dollar - Accts Recv - Groupon";
public static String selecttender2="U.S. Dollar - Accts Recv - Feed The Children";
static By ValueList=By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']/../../..//div[3][contains(@class,'000B')]");
static int RandomIdNew;
public static String GetRandomBagId;

public static void goTo() {
//	menuUrl=Browser.instance.getCurrentUrl();
//	System.out.println("Url of Menu is:" +menuUrl);
	Browser.instance.findElement(maintenanceMenu).click();
	WebElement element = Browser.instance.findElement(By.linkText("Tender and Bag Maintenance"));
    Actions action = new Actions(Browser.instance);
    action.moveToElement(element).build().perform(); 
    Browser.instance.findElement(By.linkText("Bag Types")).click();
   // WebDriverWait wait = new WebDriverWait(Browser.instance,10);
    WebDriverWait wait = new WebDriverWait(Browser.instance,10);
	wait.until(ExpectedConditions.elementToBeClickable(editButton));
//	Browser.instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}


//Adding BagTypeDetails

public static void AddBagTypeDetails()
{
	
	WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	wait.until(ExpectedConditions.visibilityOfAllElements(Browser.instance.findElements(BagTypeDescriptionDropdown)));
	Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
	BagTypeDescription.selectByVisibleText("CERT");
	Browser.instance.findElement(editButton).click();
	
	for(int i=0;i<2;i++)
	{

	wait.until(ExpectedConditions.elementToBeClickable(addButton));
	Browser.instance.findElement(addButton).click();

	wait.until(ExpectedConditions.elementToBeClickable(BagTypeSaveBtn));
	Select TenderFieldDescription=new Select(Browser.instance.findElement(tenderFieldDropdown));
	TenderFieldDescription.selectByVisibleText(selecttender);

	Browser.instance.findElement(tenderQty).clear();
	Browser.instance.findElement(tenderQty).sendKeys("20");
	
	Browser.instance.findElement(BagTypeSaveBtn).click();
	
	
	
	wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
	}



	
	}

//Checking whether added or not
public static boolean isAdded() {
	Select BagTypeDesc = new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
	Boolean found = false;
	List<WebElement> allOptions = BagTypeDesc.getOptions();
	loop:
	for (WebElement we : allOptions) {
      
            if (we.getText().contains(RandomString)) {
                found = true;
                System.out.println("The "+ RandomString +" has been added to BagType description");
                break loop;
            
        }
	}
	return found;
}

//Checking whether edited or not
public static boolean isEdited() {
	Select BagTypeDesc = new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
	Boolean found = false;
	List<WebElement> allOptions = BagTypeDesc.getOptions();
	loop:
	for (WebElement we : allOptions) {
     
            if (we.getText().contains(RandomStringUpdated)) {
                found = true;
                System.out.println("The "+ RandomStringUpdated +" has been edited");
                break loop;
            
        }
	}
	return found;
}


//Check the Bag Value is matching with the sum of Bag Values
public static void CheckBagValue()

{
	 List<WebElement> column3 = Browser.instance.findElements(ValueList);
	  System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column3 .size());
	  int row_num=1;
	double SumVal=0.0d;

	  for (WebElement tdElement : column3 ) 
	  {
	      
		 String val=tdElement.getText();
		 System.out.println(val);
	      SumVal=SumVal+Double.parseDouble(val);
	      

	   row_num++;
	  }
	
      NumberFormat formatter = NumberFormat.getNumberInstance();
      formatter.setMinimumFractionDigits(2);
      formatter.setMaximumFractionDigits(2);
      output = formatter.format(SumVal);
      //SumStr= Double.toString(SumVal);
	 System.out.println("Total BagValue is:" +output);
}

//Verifying whether the sum of Bag Value is matching or not
	 public static void VerifySum()
	 {
	 WebElement BagSum = Browser.instance.findElement(BagValueSum);
	
	 if(BagSum.getAttribute("value").equals(output))
	 {
		System.out.println("Bag Value Sum is Matching"); 
	 } 
	 else
	 {
		 System.out.println("Bag Value Sum is not matching");
	 }

		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		Browser.instance.findElement(cancelButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		Browser.instance.findElement(confirmYesButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));

}
	 //Deleting the BagType
	 
public static void DeleteBagTypeDetails()
{
	
	selectBagTypeDetails(selecttender);
	Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Browser.instance.findElement(BagTypeDetailsdeleteBtn).click();
	//Confirm Delete

	WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));

	Browser.instance.findElement(confirmYesButton).click();
	
	
	wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	Browser.instance.findElement(saveButton).click();
	
	System.out.println("BagType deleted:"+selecttender);
	
	//System.out.println("Recently added BagType is deleted");
	wait.until(ExpectedConditions.elementToBeClickable(editButton));
}



public static void selectBagType(String BagTypeName) {
	Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
	List<WebElement> Options = BagTypeDescription.getOptions();
	

    int iSize = Options.size();
    
    System.out.println("Total No of BagTypes:"+iSize);
 
    for (int i = 0; i < iSize; i++) {
    	   	if (BagTypeName.equals(Options.get(i).getText())) {
    	   		//System.out.println("BagTypeName Viewed Successfully");
    	   		Options.get(i).click();
    	   		break;
                }
    }
}

//View newly created BagType
public static void ViewNewBagType()
{


	selectBagType(RandomString);
	System.out.println("BagTypeName Viewed Successfully");
	
}


//Editing BagTypeDescription
public static void EditBagTypeDescription()
{
	WebDriverWait wait5=new WebDriverWait(Browser.instance,10);

	RandomStringUpdated=RandomString+"test12";
	Browser.instance.findElement(editButton).click();
	wait5.until(ExpectedConditions.elementToBeClickable(cancelButton));
	
	Browser.instance.findElement(BagTypeDescField).clear();
	Browser.instance.findElement(BagTypeDescField).sendKeys(RandomStringUpdated);
	System.out.println("BagType edited Successfully:"+RandomString);
	Browser.instance.findElement(saveButton).click();
	
	wait5.until(ExpectedConditions.elementToBeClickable(editButton));
	
}


//Deleting BagType Description

public static void  DeleteBagTypeDescription()
{
	
	WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	
	Browser.instance.findElement(deleteButton).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
	Browser.instance.findElement(confirmYesButton).click();
	System.out.println(RandomStringUpdated+" BagType Description is deleted");
	wait.until(ExpectedConditions.elementToBeClickable(editButton));
	
	
}
//public static void VerifyEditBag()
//{
//	WebDriverWait wait=new WebDriverWait(Browser.instance,10);
//	wait.until(ExpectedConditions.elementToBeClickable(exitButton));
//	selectBagType(RandomStringUpdated);
//	System.out.println("Edited Bag is viewed successfully:"+RandomStringUpdated);
//	
//}


//Create New BagType Description
public static void NewBagTypeDescription() throws Exception
{
	
	Browser.instance.findElement(newButton).click();
	
 RandomString = GenerateRandomValue.generateRandomStringtest();

	WebDriverWait wait12=new WebDriverWait(Browser.instance,10);
	wait12.until(ExpectedConditions.elementToBeClickable(cancelButton));
	Thread.sleep(1000);

	Browser.instance.findElement(BagTypeDescField).sendKeys(RandomString);
	//System.out.println("New BagType added successfully:"+RandomString);
	Browser.instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	int RandomCode = GenerateRandomValue.generateRandomInteger();
	Browser.instance.findElement(BagCodeField).sendKeys(RandomCode+"");
	

	

	
	Browser.instance.findElement(saveButton).click();
	wait12.until(ExpectedConditions.elementToBeClickable(deleteButton));
	
	
}

//Exiting BagType

public static void ExitPage()
{
	WebDriverWait wait1=new WebDriverWait(Browser.instance,10);
	wait1.until(ExpectedConditions.elementToBeClickable(deleteButton));
	Browser.instance.findElement(exitButton).click();
	currentUrl = Browser.instance.getCurrentUrl();
	System.out.println("Current Url is:"+currentUrl);

	if(currentUrl.contains("dashboard"))
	{
		System.out.println("Bag Type page got exit and returned to dashboard");
	}
	else
	{
		System.out.println("Url not matching");
	}
	
}

//Selecting BagTypeDetails
public static void selectBagTypeDetails(String TenderDesc) {
	List<WebElement> rows = Browser.instance.findElements(BagTypeColumn);
    int iSize = rows.size();
    if (iSize!=0) 
    {
    	
    for (int i = 0; i < iSize; i++) 
    {
        String sValue = rows.get(i).getText(); 
                if (sValue.equalsIgnoreCase(TenderDesc)) 
                {
                    rows.get(i).click();
                    break;
                }
                }
    }
    else
    	System.out.println("Grid cell element not found");
    
	}


//Checking the Duplicate id Message is coming or not

public static void CreateduplicateBagIdVerify() 
{
	Browser.instance.findElement(editButton).click();
	WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	wait.until(ExpectedConditions.elementToBeClickable(addButton));
	RandomId=GenerateRandomValue.generateRandomInteger();
	
	Browser.instance.findElement(BagsTab).click();
	
	Browser.instance.findElement(addButton).click();
	
	
	wait.until(ExpectedConditions.elementToBeClickable(BagIdCancelBtn));
	//Browser.instance.findElement(BagsField).sendKeys(RandomId+"");
	Browser.instance.findElement(BagsField).sendKeys("10");
	Browser.instance.findElement(ActiveCheckBox).click();
	
		
		try
		{
		Browser.instance.findElement(BagIdSaveBtn).click();
		//Browser.instance.findElement(BagIdSaveBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		
		Browser.instance.findElement(editButton).click();
		

		}


		catch(Exception e)
		{
			System.out.println("Exception Handled Successfully");
		
	
		String Actual= Browser.instance.findElement(DuplicateBagMsg).getText();
		String Expected="This Bag ID is duplicate. Can NOT save.";
		if(Actual.equalsIgnoreCase(Expected))
				{
					System.out.println("Bag Id Duplicate Msg is verified successfully");
					Browser.instance.findElement(DuplicateBagConfirm).click();
					wait.until(ExpectedConditions.elementToBeClickable(BagIdCancelBtn));
					Browser.instance.findElement(BagIdCancelBtn).click();
					
					
					}
		else
		{
			System.out.println("No message is verified about duplicate Bag Id");

		}
		}

	}

//Creating new Bagid
public static void CreateBagId() 
{
	
	WebDriverWait wait=new WebDriverWait(Browser.instance,10);
	wait.until(ExpectedConditions.elementToBeClickable(addButton));
	RandomId=GenerateRandomValue.generateRandomInteger();
	
	Browser.instance.findElement(BagsTab).click();
	
	Browser.instance.findElement(addButton).click();
	
	
	wait.until(ExpectedConditions.elementToBeClickable(BagIdCancelBtn));
	Browser.instance.findElement(BagsField).sendKeys(RandomId+"");
	
	Browser.instance.findElement(ActiveCheckBox).click();
	Browser.instance.findElement(BagIdSaveBtn).click();
	try {
		
		
		Browser.instance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Browser.instance.findElement(saveButton).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
	}
	catch(Exception e)
	{
		Browser.instance.findElement(BagIdSaveBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(saveButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
	}

}
	
//Count the Number of Bags Built
	public static void CountBagBuilt()
	{

		Browser.instance.findElement(editButton).click();
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		 List<WebElement> column3 = Browser.instance.findElements(BagIdStatusList);
		 // System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column3 .size());
		  int row_num=0;
		 
		  for (WebElement tdElement : column3 ) 
		  {
			
			  if(tdElement.getText().equalsIgnoreCase("Built"))
			  {
		   row_num++;
		  }
		  }
	
		 System.out.println("No of bags Built in the bag List that contains "+column3.size()+" Bagid's are "+row_num);
		 Browser.instance.findElement(saveButton).click();
		 wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			
	
	}
	//Closing the page
	public static void close() 
	{
		WebDriverWait wait = new WebDriverWait(Browser.instance,20);
		wait.until(ExpectedConditions.elementToBeClickable(exitButton));
		Browser.instance.findElement(exitButton).click();	
	}
	
	
	//Converting empty Bags to Built from Build Bags
	public static void ConvertToBuilt()
	{
		 Browser.instance.findElement(exitButton).click();
		BuildBagsPage.goTo();
		BuildBagsPage.EmptyToBuilt();
		
		
	}
	//Verifying whether Bag is Built
	public static void VerifyBagBuilt()
	{
			
		Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
		BagTypeDescription.selectByVisibleText("CERT");
		Browser.instance.findElement(BagsTab).click();
		
		CountBagBuilt();
		
	
		Browser.instance.findElement(BagTypeDetailsTab).click();
		
		
		}
	
	
//Create New Bag
	public static void CreateNewBag() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(Browser.instance,10);
		wait.until(ExpectedConditions.visibilityOfAllElements(Browser.instance.findElements(BagTypeDescriptionDropdown)));
		Select BagTypeDescription=new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
		BagTypeDescription.selectByVisibleText("GREYBOX");
		Browser.instance.findElement(editButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		Browser.instance.findElement(BagsTab).click();
		Browser.instance.findElement(addButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(BagIdCancelBtn));
		RandomIdNew=GenerateRandomValue.generateRandomInteger();
		Browser.instance.findElement(BagsField).sendKeys(RandomId+"");
		Browser.instance.findElement(ActiveCheckBox).click();
		Thread.sleep(1000);
		try {
			GetRandomBagId=Browser.instance.findElement(BagsField).getAttribute("value");
			Browser.instance.findElement(BagIdSaveBtn).click();
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			Browser.instance.findElement(saveButton).click();
		}
		catch(Exception e)
		{
			Browser.instance.findElement(DuplicateBagConfirm).click();
			wait.until(ExpectedConditions.elementToBeClickable(BagIdCancelBtn));
			Browser.instance.findElement(BagIdCancelBtn).click();
			wait.until(ExpectedConditions.elementToBeClickable(addButton));
			wait.until(ExpectedConditions.elementToBeClickable(BagIdCancelBtn));
			RandomIdNew=GenerateRandomValue.generateRandomInteger();
			Browser.instance.findElement(BagsField).sendKeys(RandomId+"");
			Browser.instance.findElement(ActiveCheckBox).click();
			Thread.sleep(1000);
			GetRandomBagId=Browser.instance.findElement(BagsField).getAttribute("value");
			Browser.instance.findElement(BagIdSaveBtn).click();
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			Browser.instance.findElement(saveButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(exitButton));
			
		}
		
		
	}
	//Exit Page
		public static void Exit()
		{
			WebDriverWait wait= new WebDriverWait(Browser.instance,10);
			Browser.instance.findElement(exitButton).click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionsMenu));
			
			
		}
		public static void createBagTypeForTellerTransaction() {
			
			Select BagTypeValue = new Select(Browser.instance.findElement(BagTypeDescriptionDropdown));
			try {
				BagTypeValue.selectByVisibleText("AutomationTestBagType");
			}
			catch(Exception e)
			{
				System.out.println("automation test bag type does not exists");
				
				Browser.instance.findElement(newButton).click();			
				WebDriverWait wait = new WebDriverWait(Browser.instance,20);
				wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
				
				Browser.instance.findElement(BagTypeDescField).sendKeys("AutomationTestBagType");
				int RandomCode = GenerateRandomValue.generateRandomInteger();
				Browser.instance.findElement(BagCodeField).sendKeys(RandomCode+"");
				
				Browser.instance.findElement(addButton).click();
				wait.until(ExpectedConditions.elementToBeClickable(BagTypeSaveBtn));
				Select TenderFieldDescription=new Select(Browser.instance.findElement(tenderFieldDropdown));
				TenderFieldDescription.selectByVisibleText(selecttender);
				Browser.instance.findElement(tenderQty).clear();
				Browser.instance.findElement(tenderQty).sendKeys("20");
				
				Browser.instance.findElement(BagTypeSaveBtn).click();			
				wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
				
				Browser.instance.findElement(saveButton).click();			
				wait.until(ExpectedConditions.elementToBeClickable(newButton));
			}
				
				selectBagTypeDetails("AutomationTestBagType");
				Browser.instance.findElement(editButton).click();
				WebDriverWait wait=new WebDriverWait(Browser.instance,10);
				wait.until(ExpectedConditions.elementToBeClickable(saveButton));
				CreateBagId() ;
			//List<WebElement> allOptions = BagTypeValue.getOptions();
			//loop:
			//for (WebElement we : allOptions) {
		        //for (int i = 0; i < allOptions.size(); i++) {
		           // if (we.getText().contains("AutomationTestBagType")) {               
		              //  break loop;
		            //}
		        //}
			//}
			}
}





