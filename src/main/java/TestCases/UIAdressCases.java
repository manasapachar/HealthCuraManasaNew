package TestCases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseClass;
import pages.Home;
import pages.MakeAppointmentPage;
import pages.History;
import pages.LoginPage;
import pages.ProfilePage;
import pages.Logout;
public class UIAdressCases extends BaseClass {
	
	@Test
	void verifyAdressAtHome()
	{
		driver.get(url);
        LoginPage login = new LoginPage(driver);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		login.makeappointment();
		

		login.setUserName("John Doe");
		

		login.setPassword("ThisIsNotAPassword");
		

		login.clickButton();
		
		
	
		
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());

		Home home = new Home(driver);	
		boolean result = home.adressPresent();
		Assert.assertTrue(result);
		
		Logout lo = new Logout(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lo.menuToggle();
		lo.logout();
	}

	

	@Test
	void verifyAdressAtHistory()
	{
		driver.get(url);
        LoginPage login = new LoginPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		login.makeappointment();
		

		login.setUserName("John Doe");
		

		login.setPassword("ThisIsNotAPassword");
		

		login.clickButton();
		
		
		
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());
		History history = new History(driver);	
		boolean result = history.adressPresent();
		Assert.assertTrue(result);
		
		Logout lo = new Logout(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lo.menuToggle();
		lo.logout();

	}
	

	@Test
	void verifyAdressAtLogin()
	{
		driver.get(url);
        LoginPage login = new LoginPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		login.makeappointment();
		

		login.setUserName("John Doe");
		

		login.setPassword("ThisIsNotAPassword");
		

		login.clickButton();
		
		
	
		
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());
		LoginPage lp = new LoginPage(driver);	
		boolean result = lp.adressPresent();
		Assert.assertTrue(result);
		
		
		Logout lo = new Logout(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lo.menuToggle();
		lo.logout();
	}
	
	

	@Test
	void verifyAdressAtProfile()
	{
		
		
		driver.get(url);
        LoginPage login = new LoginPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		login.makeappointment();
		

		login.setUserName("John Doe");
		

		login.setPassword("ThisIsNotAPassword");
		

		login.clickButton();
		
		
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());
		ProfilePage mp = new ProfilePage(driver);	
		boolean result = mp.adressPresent();
		Assert.assertTrue(result);
		
		Logout lo = new Logout(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lo.menuToggle();
		lo.logout();
	}
	
	

	@Test
	void verifyAdressAtAppointment()
	{
		driver.get(url);
        LoginPage login = new LoginPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		login.makeappointment();
		

		login.setUserName("John Doe");
		

		login.setPassword("ThisIsNotAPassword");
		

		login.clickButton();
		
		
	
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());

		MakeAppointmentPage home = new MakeAppointmentPage(driver);	
		boolean result = home.adressPresent();
		Assert.assertTrue(result);
		
		Logout lo = new Logout(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lo.menuToggle();
		lo.logout();
	}
}
