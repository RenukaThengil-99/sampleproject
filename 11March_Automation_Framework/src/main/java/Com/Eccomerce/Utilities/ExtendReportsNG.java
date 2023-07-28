package Com.Eccomerce.Utilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsNG {
	
	static ExtentReports extents;

	public static ExtentReports getReportObject() {
		
		String Timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.ss").format(new Date());
		
		String Name= "ExtentReport---"+Timestamp;
		
		Path resourceDirectory=Paths.get("src","test","resources");
		
		String Absolutepath=resourceDirectory.toFile().getAbsolutePath();
		String Path=Absolutepath +"/Reports/"+Name+" "+".html";
		ExtentHtmlReporter reporter= new ExtentHtmlReporter(Path);
		reporter.config().setReportName("11March Framework Extent Report");
		reporter.config().setDocumentTitle("11March Framework Execution report");
		
		extents= new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("QA Automation Engineer", "Renuka Thengil");
		extents.setSystemInfo("suite name","Regression/ Smoke");
		
		return extents;
	}
}
