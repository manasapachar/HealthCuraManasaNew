package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Logout;
import utility.BaseClass;

public class LogoutTestCases extends BaseClass {

	@Test
	void testLogout() throws InterruptedException

	{
		driver.get(url);

		LoginPage login = new LoginPage(driver);

		Logout l = new Logout(driver);

		login.makeappointment();

		login.setUserName("John Doe");

		login.setPassword("ThisIsNotAPassword");

		login.clickButton();

		l.menuToggle();

		l.logout();

		//Assert.assertEquals("We Care For Your Health", login.passLogin());
	}

}
