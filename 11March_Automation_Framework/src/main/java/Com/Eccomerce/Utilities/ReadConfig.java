package Com.Eccomerce.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src= new File("C:\\Users\\renuka.thengil\\eclipse-workspace\\11March_Automation_Framework\\src\\test\\resources\\Configration\\Config.properties");
		pro= new Properties();
		
		try {
			FileInputStream file= new FileInputStream(src);
			try {
				pro.load(file);
			} catch (IOException e) {
				System.out.println("Exception is"+ e.getMessage());
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception is"+ e.getMessage());
			e.printStackTrace();
		}
		}
	
	public String GetUrl() {
	  String Url=pro.getProperty("BaseURL");
	  return Url;
	}

	public String Username1() {
		  String uname=pro.getProperty("Username");
		  return uname;
		}

	public String Password1() {
		  String pass=pro.getProperty("Password");
		  return pass;
		}
	
	
	public String GetChromepath() {
		  String Chromepath=pro.getProperty("Chromdriver");
		  return Chromepath;
		}
	


}
