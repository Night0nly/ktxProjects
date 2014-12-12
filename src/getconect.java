package ktx;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class getconect {
	private Connection a;
	public void setconnect(Connection a)
	{
		this.a=a;
	}
	public Connection getcon(){
		
		return this.a;
	}
	Connection a1;
	public getconect()
	{
		
	    	
	        try
	        {
	            Class.forName("org.postgresql.Driver");
	            a1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ktx",
	                   "postgres", "onlylike");
	            setconnect(a1);
	            
	        }
	        catch (Exception ex)
	        {
	        	 JOptionPane.showMessageDialog(null, "so ban qua den");
	            System.out.println(ex);
	        }
	    
	}
}
