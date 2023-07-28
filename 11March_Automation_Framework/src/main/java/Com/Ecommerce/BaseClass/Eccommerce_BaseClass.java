package Com.Ecommerce.BaseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Eccomerce.Utilities.ReadConfig;

public class Eccommerce_BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	ReadConfig readconfig= new ReadConfig();
	
	public String BaseUrl=readconfig.GetUrl();
	public String Username=readconfig.Username1();
	public String Password=readconfig.Password1();
	
	
	
	@BeforeMethod
	@Parameters("browser")
	public void Setup(String br) {
		
		logger=logger.getLogger("Ecommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
	     System.setProperty("webdriver.chrome.driver","C:\\Users\\renuka.thengil\\eclipse-workspace\\11March_Automation_Framework\\src\\test\\resources\\Drivers\\chromedriver.exe");
	     driver = new ChromeDriver();
		}else if(br.equals("FireFox")) {
			
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\renuka.thengil\\eclipse-workspace\\11March_Automation_Framework\\src\\test\\resources\\Drivers\\geckodriver.exe");
		     driver = new FirefoxDriver();
		}
	
        
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	driver.get(BaseUrl);
	logger.info("Enter URL");
	driver.manage().window().maximize();
	logger.info("Maximize browser");
	
	}
	
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
}
