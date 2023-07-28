package Com.Ecommerce.PageClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;

public class TC_NewRegistration extends Eccommerce_BaseClass{
	
	
	
	public TC_NewRegistration(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),\"Register\")]")
	WebElement Register;
	
	@FindBy(id="gender-male")
	WebElement Gender;
	
	@FindBy(id="FirstName")
	WebElement firstname;
	
	@FindBy(id="LastName")
	WebElement lastname;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pass;
	
	@FindBy(id="ConfirmPassword")
	WebElement confpass;
	
	@FindBy(id="register-button")
	WebElement regbutton;
	
	public void Register1() {
		Register.click();
    }
	
	public void SelectGender() {
		Gender.click();
	}
	
	public void Firstname(String Name) {
		firstname.sendKeys(Name);
	}
	
	public void Lastname(String Name) {
		lastname.sendKeys(Name);
	}
	
	public void Email1(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void Pass(String pass1) {
		pass.sendKeys(pass1);
	}
	
	public void ConfPass(String pass1) {
		confpass.sendKeys(pass1);
	}
	
	public void RegButton() {
		regbutton.click();
	}


}
