package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Logout;
import pages.ProfilePage;
import utility.BaseClass;
public class ProfilePageTest extends BaseClass{
	
	@Test
	void ProfilePageLabelDisplay()
	{
		driver.get(url);
        LoginPage login = new LoginPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		login.makeappointment();
		

		login.setUserName("John Doe");
		

		login.setPassword("ThisIsNotAPassword");
		

		login.clickButton();
		
		
	
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());
		
		
		 
		ProfilePage pp = new ProfilePage(driver);
		
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#profile");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Assert.assertTrue(pp.prfileLabelPresent());
		
		Logout lo = new Logout(driver);
		
		lo.menuToggle();
		
		lo.logout();
	}

}
