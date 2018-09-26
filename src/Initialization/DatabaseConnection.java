package Initialization;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
public static Connection connection;
public static Statement statement;
public static ResultSet rs;
static String data1=null;
static int data2=0;
	 
	    public static void dataBaseSetUp() {
	           
	    		//String databaseURL=  "jdbc:sqlserver://192.168.6.204\\MSSQLSERVER2016;databaseName=SFOT_MCCC;";
	            //String user = "MacUser";
	            //String password = "MacUser";
	            String databaseURL=  DataProvider.getValueOf("DB URL");
	            String user = DataProvider.getValueOf("DB User ID");
	            String password = DataProvider.getValueOf("DB Password");
	            
	            connection = null;
	            try {
	            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                //Class.forName("com.mysql.jdbc.Driver");
	                System.out.println("Connecting to Database...");
	                connection = DriverManager.getConnection(databaseURL, user, password);
	                if (connection != null) {
	                    System.out.println("Connected to the Database...");
	                }
	            } catch (SQLException ex) {
	               ex.printStackTrace();
	            }
	            catch (ClassNotFoundException ex) {
	               ex.printStackTrace();
	            }
	    }

	
	    public static ResultSet getDataFromDb(String inputQuery,String str) {
	    	
	        try {
	        	dataBaseSetUp();
	        	String query = inputQuery;
	            statement = connection.createStatement();
	            rs = statement.executeQuery(query);
	         
	           
				
				while(rs.next())
	            {
	            	//int EmpId= rs.getInt("CCGroupID");
	            	 data1=rs.getString(str);
	            //	String data2=rs.getString("PLUDescription");
	               // System.out.println((data1+"|"+data2));
	            	 System.out.println(data1);
	               }
	         
			 } 
	        catch (SQLException ex) {
	           ex.printStackTrace();
	        }
			return rs;
	    
	       // tearDown();
			
	    }
	    
public static int updateDatatoDb(String inputQuery) {
	    	
	int status=0;
	
	        try {
	        	System.out.println("inside db");
	        	dataBaseSetUp();
	        	String query = inputQuery;
	            statement = connection.createStatement();
	           status = statement.executeUpdate(query);
			 } 
	        catch (SQLException ex) {
	           ex.printStackTrace();
	        }
			return status;
	    
	       // tearDown();
			
	    }

	public static String returnString(String selectQuery) {
		String resultString = null;
		try {
			dataBaseSetUp();
			System.out.println("query: "+selectQuery);
			statement = connection.createStatement();
			rs = statement.executeQuery(selectQuery);
			while (rs.next()) {
			 resultString=rs.getString("DepositID");}
			}
		catch (SQLException ex) {
	           ex.printStackTrace();}
		

		//String resultString = rs.toString(); 
		System.out.println("The result string is "+resultString);
		return resultString;						
		}
	
	public static String returnBagUsageID(String selectQuery) {
		String resultString = null;
		try {
			dataBaseSetUp();
			System.out.println("query: "+selectQuery);
			statement = connection.createStatement();
			rs = statement.executeQuery(selectQuery);
			while (rs.next()) {
			 resultString=rs.getString("bagUsageID");}
			}
		catch (SQLException ex) {
	           ex.printStackTrace();}
		

		//String resultString = rs.toString(); 
		System.out.println("The result string is "+resultString);
		return resultString;						
		}
	
	public static String returnBagTypeID(String selectQuery) {
		String resultString = null;
		try {
			dataBaseSetUp();
			System.out.println("query: "+selectQuery);
			statement = connection.createStatement();
			rs = statement.executeQuery(selectQuery);
			while (rs.next()) {
			 resultString=rs.getString("bagtypeID");}
			}
		catch (SQLException ex) {
	           ex.printStackTrace();}
		

		//String resultString = rs.toString(); 
		System.out.println("The result string is "+resultString);
		return resultString;						
		}

	 
	    public static void tearDown() {
	      if (connection != null) {
	                try {
	                    System.out.println("Closing Database Connection...");
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	      }
	    


		public static void cleanupDepositEntries(String depositNumber) {
			String depositID = returnString("select DepositID from deposits where DepositNumber = '" +depositNumber+"'");  
			
			if (depositID!=null) {
				updateDatatoDb("delete from depositDetails where DepositID = '"+depositID+"'" );
				updateDatatoDb("delete from deposits where DepositID = '"+depositID+"'");
				System.out.println("Deposit entries deleted");
			}
		}
			public static void deleteAddedBag() {
				
				try {
					dataBaseSetUp();
					statement = connection.createStatement();
					rs = statement.executeQuery("delete from bags where BagAlias='1009998'");
					
					}
				catch (SQLException ex) {
			           ex.printStackTrace();}
				System.out.println("Deleted 1009998 ba successsfully");						
				}


			public static void cleanupTrans() {
				String bagUsageIDValue = returnBagUsageID("select bagUsageID from bagUsage where bagAlias = 'BAGFORTEST'");  
				
				if (bagUsageIDValue!=null) {
					updateDatatoDb("delete from SalesTransactions where bagUsageID = '"+bagUsageIDValue+"'" );
					updateDatatoDb("delete from CashTransDetails where bagUsageID = '"+bagUsageIDValue+"'" );
					updateDatatoDb("delete from CashTransactions where bagUsageID = '"+bagUsageIDValue+"'");
					updateDatatoDb("delete from bagusage where bagUsageID = '"+bagUsageIDValue+"'");
					
					System.out.println("Transaction entries deleted for BagForTest");
				}
					
				 bagUsageIDValue = returnBagUsageID("select bagUsageID from bagUsage where bagAlias = 'BAGFORTEST1'");  
					
					if (bagUsageIDValue!=null) {
						updateDatatoDb("delete from SalesTransactions where bagUsageID = '"+bagUsageIDValue+"'" );
						updateDatatoDb("delete from CashTransDetails where bagUsageID = '"+bagUsageIDValue+"'" );
						updateDatatoDb("delete from CashTransactions where bagUsageID = '"+bagUsageIDValue+"'");
						updateDatatoDb("delete from bagusage where bagUsageID = '"+bagUsageIDValue+"'");
						
						System.out.println("Transaction entries deleted for bagForTest1");
				}
			}


			public static void deleteBagType() {
				String bagTypeIDValue = returnBagTypeID("select bagtypeID from bagtypes where Bagdesc='AutomationTestBagType'");  
				
				if (bagTypeIDValue!=null) {
					updateDatatoDb("delete from bags where bagTypeID = '"+bagTypeIDValue+"'" );
					updateDatatoDb("delete from bagTypes where bagTypeID = '"+bagTypeIDValue+"'");
					
					System.out.println("Deleted test bag type");
				}
				
				
			}


			public static void disableAC(String ACCode) {
				String ActivityCenterID = returnACID("Select ActivityCenterID from ActivityCenters where AC_Code= '"+ACCode+"'");  
				
				if (ActivityCenterID!=null) {
					updateDatatoDb("delete from AC_SG where ActivityCenterID = '"+ActivityCenterID+"'" );
					updateDatatoDb("update ActivityCenters set ActiveFlag = 0 where ActivityCenterID = '"+ActivityCenterID+"'" );
					
					System.out.println("Deleted AC SG");
				}
			}


			public static void removeLocation(String addingACCode) {
				String ActivityCenterID = returnACID("Select ActivityCenterID from ActivityCenters where AC_Code= '"+addingACCode+"'");  
				
				if (ActivityCenterID!=null) {
					updateDatatoDb("delete from AC_SG where ActivityCenterID = '"+ActivityCenterID+"'" );
					updateDatatoDb("update ActivityCenters set ActiveFlag = 0 where ActivityCenterID = '"+ActivityCenterID+"'" );
					updateDatatoDb("delete from Locations where ActivityCenterID = '"+ActivityCenterID+"'" );
					
					System.out.println("Deleted AC SG");
				}
			}
			
			public static String returnACID(String selectQuery) {
				String resultString = null;
				try {
					dataBaseSetUp();
					System.out.println("query: "+selectQuery);
					statement = connection.createStatement();
					rs = statement.executeQuery(selectQuery);
					while (rs.next()) {
					 resultString=rs.getString("ActivityCenterID");}
					}
				catch (SQLException ex) {
			           ex.printStackTrace();}
				

				//String resultString = rs.toString(); 
				System.out.println("The result string is "+resultString);
				return resultString;						
				}

			
			
		}


