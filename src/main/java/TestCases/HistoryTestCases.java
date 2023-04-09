package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.History;
import pages.LoginPage;
import pages.Logout;
import utility.BaseClass;

public class HistoryTestCases extends BaseClass {

	@Test

	void verifyUser() throws InterruptedException

	{
		driver.get(url);

		LoginPage login = new LoginPage(driver);

		login.makeappointment();
		
		login.setUserName("John Doe");

		login.setPassword("ThisIsNotAPassword");

		login.clickButton();
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());
		
		System.out.println("Testing commit to github");

	}

	@Test

	void verifynoHistory() throws InterruptedException

	{
		driver.get(url);

		History noHistory = new History(driver);

		noHistory.menuToggle();

		noHistory.history();

		noHistory.appointmentlist();
		
		Assert.assertEquals("No appointment.", noHistory.passNoHistory());
		
		Logout l = new Logout(driver);
		l.menuToggle();
		Thread.sleep(2000);
		
		l.logout();

	}
}