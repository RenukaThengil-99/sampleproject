package Com.Ecommerce.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_Login;

public class TC_NewLoginTestCases extends Eccommerce_BaseClass {

	
	@Test
	public void LoginTest() throws InterruptedException {
		
	
	TC_Login TEL= new TC_Login(driver);
		TEL.Email(Username);
		
		Thread.sleep(3000);
		logger.info("Enter Email");
		TEL.Password(Password);
		logger.info("Enter password");
		TEL.Login1();
		logger.info("clicked on logging button");
		
		String Title= driver.getTitle();
		
		if(Title.equals("nopCommerce demo store")) {
			Assert.assertTrue(true);
			logger.info("Login Test pass");
		}else {
			Assert.assertTrue(false);
			logger.info("Login Test fail");
		}
		
	}
}
