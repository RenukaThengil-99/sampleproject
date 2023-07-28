package Com.Ecommerce.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_Ecommerce_AddToCart;
import Com.Ecommerce.PageClasses.TC_Login;

public class TC_AddToCartTestCases  extends Eccommerce_BaseClass {

	
	
	@Test
	public void AddProduct() throws InterruptedException {
		TC_Login TEL= new TC_Login(driver);
		TEL.Email(Username);
		
		Thread.sleep(3000);
		logger.info("Enter Email");
		TEL.Password(Password);
		logger.info("Enter password");
		TEL.Login1();
		logger.info("clicked on logging button");
		
		TC_Ecommerce_AddToCart TEA= new TC_Ecommerce_AddToCart(driver);
		
		WebElement ele= driver.findElement(By.xpath("(//a[text()='Computers '])[1]"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		TEA.Notebookclick();
		TEA.SelectMacBook1();
		TEA.Addtocart1();
		TEA.ProductAdded();
		TEA.Close();
		
		WebElement Ele1=driver.findElement(By.xpath("//span[text()=\"Shopping cart\"]"));
		act.moveToElement(Ele1).build().perform();
		TEA.Product();
		
	}
}
