package Com.Eccomerce.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;

public class GenericUtils extends Eccommerce_BaseClass {

	public static String GetScreenShotAs(String TestCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		 File source= ts.getScreenshotAs(OutputType.FILE);
		 
		 String Timestamp= new SimpleDateFormat("YYYY.MM.DD.HH.SS").format(new Date());
		 String Name= "--screenshot--"+Timestamp;
		 
		 Path Resourcedirectory= Paths.get("src", "test", "resources");
		 String Absolutepath= Resourcedirectory.toFile().getAbsolutePath();
		 System.out.println(Absolutepath);
		 
		 String destination= Absolutepath +"/ScreenShots/"+TestCaseName+" "+Name+".png";
		 
		 FileUtils.copyFile(source, new File(destination));
		 
		 return destination;
	}
	
	public static void ClickelementusingJavascript(WebDriver driver,WebElement Element) {
		
		JavascriptExecutor Js= (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].click();", Element);
	}
	
	public static WebElement WaitiforElement(WebDriver driver, By Locator, int Timeout) {
		
		WebDriverWait Mywait= new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		Mywait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		return driver.findElement(Locator);
		
	}
	
	
}
