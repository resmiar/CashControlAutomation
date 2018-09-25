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
	           
	    	String databaseURL=  "jdbc:sqlserver://192.168.6.204\\MSSQLSERVER2016;databaseName=SFOT_MCCC;";
	            String user = "MacUser";
	            String password = "MacUser";
	            
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

			
			
		}


