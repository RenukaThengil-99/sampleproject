package Com.Ecommerce.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Eccomerce.Utilities.GenericUtils;
import Com.Eccomerce.Utilities.XLSUtils;
import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_Login;

public class TC_LoginTestcasesDDT extends Eccommerce_BaseClass {

	
	@Test(dataProvider="Logindata")
	public void LoginTest(String Username, String Password, String Exp) throws InterruptedException, IOException {
		
		TC_Login TEL= new TC_Login(driver);
		TEL.Email(Username);
		
		Thread.sleep(3000);
		logger.info("Enter Email");
		TEL.Password(Password);
		logger.info("Enter password");
		TEL.Login1();
		logger.info("clicked on logging button");
		
		String Actual_Title= driver.getTitle();
		String Exp_Title="nopCommerce demo store";
		
		if(Exp.equals("Valid")) {
			if(Exp_Title.equals(Actual_Title)) {
				TEL.Logout();
				Assert.assertTrue(true);
				logger.info("login test case pass");
			}else {
				Assert.assertTrue(false);
			}
		}
			else if(Exp.equals("Invalid")){
				if(Exp_Title.equals(Actual_Title)) {
					TEL.Logout();
					Thread.sleep(3000);
					Assert.assertTrue(false);
					GenericUtils.GetScreenShotAs("Login test case fail", driver);
				}else {
					Assert.assertTrue(true);
				}
			}
	}

	
	
	@DataProvider(name="Logindata")
	public String[][] Logindata() throws IOException {
		
		String path="C:\\Users\\renuka.thengil\\eclipse-workspace\\11March_Automation_Framework\\src\\main\\java\\Com\\Ecommerce\\TestData\\11Match_TestData.xlsx";
		int row=XLSUtils.GetRowcount(path, "Sheet1");
		int cell=XLSUtils.getcellcount(path,"Sheet1", 1);
		
		String Logindataarr[][]= new String [row][cell];
		
		for(int i=1;i<=row;i++) {
			for(int j=0;j<cell;j++) {
				Logindataarr[i-1][j]=XLSUtils.getCelldata(path, "Sheet1", i, j);
				
			}
		}
		return Logindataarr;
		
	}
	
	}
