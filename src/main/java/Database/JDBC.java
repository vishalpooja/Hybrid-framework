package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class JDBC {
	 private Connection connection;
	   private static Statement statement;
	   private static ResultSet rs; 
	   public Connection con;
	   public Statement stmt;
	  
	   
	    @BeforeClass
	    public void setUp() {
	            String databaseURL = "jdbc:mysql://turf-dev-db.cfh6odmitnju.us-west-2.rds.amazonaws.com:3306/turfdevdb";
	            String user = "turfdevdb";
	            String password = "12345678";
	            connection = null;
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
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
	    @Test
	    public void getEmployeesFromDataBase() {
	        try {
	            String query = "select * from user";
	            statement = connection.createStatement();
	            rs = statement.executeQuery(query);
	            
	            java.sql.DatabaseMetaData meta = connection.getMetaData();
	            ResultSet schemas = meta.getSchemas();
	            while (schemas.next()) {
	              String tableSchema = schemas.getString(1);    // "TABLE_SCHEM"
	              String tableCatalog = schemas.getString(2); //"TABLE_CATALOG"
	              System.out.println("tableSchema"+tableSchema + tableCatalog);
	            }
	            
	            
	            while(rs.next()){
	                int EmpId= rs.getInt("id");
	                String EmpName= rs.getString("firstname");       
	                System.out.println("ID :    "+EmpId+ "\t"+"Name:   "+EmpName);
	            }
	        } catch (SQLException ex) {
	           ex.printStackTrace();
	        }
	    	
	    }
	    @AfterClass
	    public void tearDown() {
	      if (connection != null) {
	                try {
	                    System.out.println("Closing Database Connection...");
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	      }

}
