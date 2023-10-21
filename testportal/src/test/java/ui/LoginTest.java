package ui;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(priority=1,description="This is login test")
	public void bloginTest() {
		System.out.println("Login is succesfull");
	}
    
   @Test(priority=2,description="This is login test")
   public void alogouttest()
   {
	   System.out.println("Logout is succesfull");
   }

}
