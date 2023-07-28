package Com.Ecommerce.TestCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;

public class TC_BrokenLinks extends Eccommerce_BaseClass {

	
	@Test
	public void BrokenLinks() throws MalformedURLException, IOException {
		
		List<WebElement> Linkdlist=driver.findElements(By.tagName("a"));	
		
		Linkdlist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total Links-->"+Linkdlist.size());
		int brokenlink=0;
	     List<WebElement> ActiveLinks= new ArrayList<WebElement>();
		
		for(int i=0;i<Linkdlist.size();i++) {
			if(Linkdlist.get(i).getAttribute("href")!=null && (!Linkdlist.get(i).getAttribute("href").contains("JavaScript"))) {
				ActiveLinks.add(Linkdlist.get(i));
		}
		
	}
	
		System.out.println("Activelinks=="+ActiveLinks.size());
		
		for(int j=0;j<ActiveLinks.size();j++) {
	    HttpURLConnection.setFollowRedirects(false);
	    HttpURLConnection httpscode= (HttpURLConnection)new URL(ActiveLinks.get(j).getAttribute("href")).openConnection();
	    httpscode.connect();
	    
	     String response1= httpscode.getResponseMessage();
	     int statuscode= httpscode.getResponseCode();
	    
	    if(httpscode.getResponseCode()>=400) {
	    	System.out.println(httpscode.getResponseCode()+ "--->"+ActiveLinks.get(j).getAttribute("href")+"--->brken link");
	    	brokenlink++;
	    }else {
	    	System.out.println(httpscode.getResponseCode()+ "--->"+ActiveLinks.get(j).getAttribute("href")+"--->valid link");
	    }
}
	System.out.println("No. of broken link"+brokenlink);
	
	}
}