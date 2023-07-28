package Com.Ecommerce.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Eccomerce.Utilities.GenericUtils;
import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;

public class TC_Ecommerce_AddToCart extends Eccommerce_BaseClass{
	
	
	public TC_Ecommerce_AddToCart(WebDriver driver) {
	
	    PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="(//a[contains(text(),\"Computers\")])[1]")
	public WebElement com;
	
	@FindBy(xpath="(//a[contains(text(),\"Notebooks\")])[1]")
	public WebElement Notebook;
	
	@FindBy(xpath="//a[contains(text(),'Apple MacBook Pro 13-inch')]")
	public WebElement SelectMacbook;
	
    @FindBy(xpath="//button[@id=\"add-to-cart-button-4\"]")
    public WebElement Addtocart;
    
    @FindBy(xpath="//p[text()='The product has been added to your ']")
    public WebElement Message;
    
    @FindBy(xpath="//span[@class=\"close\"]")
    public WebElement closetab;
    
    
    public void Notebookclick() {
    	Notebook.click();
    }
    
    public void SelectMacBook1() {
    	GenericUtils.ClickelementusingJavascript(driver,SelectMacbook);
    }
    
    public void Addtocart1() {
    	Addtocart.click();
    }
    
    public void ProductAdded() {
    	Message.isDisplayed();
    }
    
    public void Close() {
    	closetab.click();
    }
    
    public void Product() {
    	By input1=By.xpath("(//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"])[2]");
    	Boolean result=GenericUtils.WaitiforElement(driver,input1,20).isDisplayed();
    	
    	if(result==true) {
    		logger.info("add to cart test case succesful");
    		Assert.assertTrue(true);
    	}else {
    		logger.info("add to cart test case failed");
    		Assert.assertTrue(false);
    	}
    }
    
}
