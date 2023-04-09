
package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.ReadConfigFile;

public class BaseClass {

	// Logger Log;
	
	
	ReadConfigFile readProperties = new ReadConfigFile();
	public 	String url = readProperties.getUrl();
	public String browser = readProperties.getBrowser();
	public String global_username = readProperties.getUsername();
	public String global_password = readProperties.getPassword();
	
	public static Logger log;
	public static WebDriver driver;
	
	
		
	
	


	@BeforeSuite
	public void setup() {
		//ReadConfigFile rcf = new ReadConfigFile();
		//browser = rcf.getBrowser();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//driver.get(rcf.getUrl()); 
		Logger log = Logger.getLogger("HealthCuraManasa");
		PropertyConfigurator.configure("logfile.properties");

	}


	@AfterTest
	public void tear() {
		driver.quit();
	}

}
	
	
	
	/*
	 * if (browser.equals("chrome")) { System.setProperty(
	 * "/Users/anandsortur/eclipse-workspace/HealthCuraManasa/src/main/resources/config.properties",
	 * "chrome"); WebDriverManager.chromedriver().setup();
	 * 
	 * driver= new ChromeDriver();
	 * 
	 * driver.get(rcf.getUrl()); Logger log = Logger.getLogger("HealthCuraManasa");
	 * PropertyConfigurator.configure("logfile.properties"); }
	 * 
	 * if(browser.equals("firefox")) { System.setProperty(
	 * "/Users/anandsortur/eclipse-workspace/HealthCuraManasa/src/main/resources/config.properties",
	 * "firefox"); WebDriverManager.firefoxdriver().setup();
	 * 
	 * driver= new FirefoxDriver();
	 * 
	 * driver.get(rcf.getUrl());
	 * 
	 */


/*@DataProvider
Object readData() // creating | reading the data and will give the data  to another method 
{
	Object[][] data = new Object[4][2];  // creating two dim array
	
	data[0][0]= "manasa";    data[0][1]= "ThisisnotPassword";   
	
	data[1][0]= "john doe";    data[1][1]= "anand"; 
	
	data[2][0]= "john doe";    data[2][1]= "123"; 
	
	data[3][0]= "john";    data[3][1]= "ThisisnotPassword"; 
	
	return data;
}
@Test(dataProvider = "readData")
void verifyUser(String user, String pass)
{
	System.out.println(user);
	System.out.println(pass);
	
	driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
	LoginPage login  = new LoginPage(driver);
	login.setUserName(user);
	login.setPassword(pass);
	login.clickButton(); */
	

/*
 * { //
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "/Users/anandsortur/Downloads/chromedriver_mac64/chromedriver/chromedriver.exe"
 * );
 * 
 * //WebDriverManager.firefoxdriver().setup();
 * 
 * WebDriver driver = new ChromeDriver();
 * 
 * driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
 * 
 * 
 */