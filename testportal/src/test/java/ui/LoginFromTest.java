package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFromTest {
	
	@BeforeTest
	public void logintoApplication()
	{
	System.out.println("Login to application");
	}
	@AfterTest
	public void logoutfromApplication()
	{
	System.out.println("Log out from application");
	}
	@BeforeMethod
	public void connectDB()
	{
		System.out.println("Connected to DB");
	}
	@AfterMethod
	public void disconnectDB()
	{
		System.out.println("DisConnected to DB");
	}
	
	@Test(priority=1)
		public void bloginTest() {
			System.out.println("Login is succesfull");
		}
	    
	   @Test(priority=2)
	   public void alogouttest()
	   {
		   System.out.println("Logout is succesfull");
	   }

	}



