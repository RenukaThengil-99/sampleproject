package Com.Ecommerce.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;

public class TC_Login extends Eccommerce_BaseClass{
	
	public TC_Login(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="Email")
	public WebElement Useremail;
	
	@FindBy(id="Password")
	public WebElement Userpass;
	
	@FindBy(xpath="//button[contains(text(),\"Log in\")]")
	public WebElement Login;
	
	@FindBy(xpath="//a[text()=\"Log out\"]")
	public WebElement Logout;
	
	@FindBy(xpath="//img[@alt=\"nopCommerce demo store\"]")
	public WebElement VerifyLogin;
	
	
	public void Email(String email) {
		Useremail.sendKeys(email);
	}
	public void Password(String pass) {
		Userpass.sendKeys(pass);
	}
	
	public void Login1() {
		Login.click();
	}
	

	public void Logout() {
		Logout.click();
	}
	
	public void VerifyLogin() {
		boolean value= VerifyLogin.isDisplayed();
		if(value==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	
	
}
