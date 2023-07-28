package Com.Ecommerce.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_NewRegistration;
import net.bytebuddy.utility.RandomString;

public class TC_NewRegistrationTestCases extends Eccommerce_BaseClass {
	
	
	
	@Test
	public void Registration() throws InterruptedException {
	
	TC_NewRegistration TNR= new TC_NewRegistration(driver);
	TNR.Register1();
	logger.info("clicked on register button");
	TNR.SelectGender();
	logger.info("Select Gender");
	TNR.Firstname("Ketan");
	logger.info("Enter First Name");
	TNR.Lastname("patil");
	logger.info("Enter Last Name");
	String name= RandomString.make(5);
	TNR.Email1(name+"ketan@gmail.com");
    Thread.sleep(3000);
	logger.info("Enter Email Address");
	TNR.Pass("Ketan@@123");
	logger.info("Enter Password");
	TNR.ConfPass("Ketan@@123");
	logger.info("Enter confirm Password");
	TNR.RegButton();
	
	Thread.sleep(3000);
	
	Boolean test= driver.findElement(By.xpath("//div[contains(text(),\"Your registration completed\")]")).isDisplayed();
	
	if(test==true) {
	
		logger.info("Created user succesfully");
	  Assert.assertTrue(true);
	}
	else {
		logger.info("User creation fails");
		  Assert.assertTrue(false);
	}
}
}
