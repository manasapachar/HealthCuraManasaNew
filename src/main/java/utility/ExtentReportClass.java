package utility;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//It is possible to attach screenshots. To add a screen-shot, simply call addScreenCapture. 
//This method returns the HTML with  tag which can be used anywhere in the log details.
 
public class ExtentReportClass extends BaseClass{
	

	ExtentReports extent;
	ExtentTest logger;
	//WebDriver driver;
	
	
	@BeforeTest
	public void startReport(){
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Rajkumar SM");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

        //This method is to capture the screenshot and return the path of the screenshot.
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
		
	@Test
	public void passTest(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName � Name of the test
		//Description � Description of the test
		//Starting test
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void failTest(){
                //My intention is to fail this method
                //If this method fails, then it goes to the @AfterMethod and calls the getScreenshot method and captures a screenshot and place it in the extent reports
	/*	logger = extent.startTest("failTest");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "NoTitle");
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");*/
	}
	
	
	public void skipTest(){
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		System.out.println("inside the get resu methid");
		if(result.getStatus() == ITestResult.FAILURE){
			logger = extent.startTest("failTest");
			System.out.println(ITestResult.FAILURE);
			System.out.println("inside the get resul 1"+result.getName());
			
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			System.out.println("inside the get resul 1");
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			System.out.println("inside the get resul 1");
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
                     
			String updatescreenshotPath="";
						try {
							System.out.println("inside the get resul 1");
							System.out.println(driver);
							System.out.println(result.getName());
							 String 	screenshotPath = ExtentReportClass.getScreenshot(driver, result.getName());
							 System.out.println(screenshotPath+"vgggggggggggggggggggggggggggg");
							 updatescreenshotPath=screenshotPath;
						} catch (Exception e) {
							System.out.println(e);
							e.printStackTrace();
						}
			//To add it in the extent report 
			//logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
						logger.log(LogStatus.FAIL, logger.addScreenCapture(updatescreenshotPath));
						
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
	
	

	
	
	
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                extent.close();
    }
}
