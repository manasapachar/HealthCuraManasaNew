
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Logout;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import utility.BaseClass;

public class LoginTestCases extends BaseClass {

	// WebDriver driver;

	/*
	 * public LoginTestCases(WebDriver driver) { // TODO Auto-generated constructor
	 * stub }
	 */

	@Test

	void validUser() throws InterruptedException

	{
		
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		
		Logout l = new Logout(driver);
		
		Thread.sleep(1000);

		login.makeappointment();
		Thread.sleep(1000);

		login.setUserName("John Doe");
		Thread.sleep(1000);

		login.setPassword("ThisIsNotAPassword");
		Thread.sleep(1000);

		login.clickButton();
		Thread.sleep(1000);
		
		l.menuToggle();
		Thread.sleep(1000);
		
		l.logout();
		Thread.sleep(1000);
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());
 
	}
	
	@Test

	void invalidUser() throws InterruptedException

	{
		driver.get(url);

		LoginPage login = new LoginPage(driver);

		login.makeappointment();
		Thread.sleep(1000);

		login.setUserName("abc");
		Thread.sleep(1000);

		login.setPassword("abc");

		Thread.sleep(1000);
		login.clickButton();
		Thread.sleep(1000);
		Assert.assertEquals("Login failed! Please ensure the username and password are valid.", login.getErrorMsg());
      
	}

	@Test

	void noUser() throws InterruptedException

	{
		driver.get("https://katalon-demo-cura.herokuapp.com");


		LoginPage login = new LoginPage(driver);

		login.makeappointment();
		Thread.sleep(1000);

		login.setUserName("");
		Thread.sleep(1000);

		login.setPassword("");
		Thread.sleep(1000);

		login.clickButton();
		Thread.sleep(1000);
		
		Assert.assertEquals("Login failed! Please ensure the username and password are valid.", login.getErrorMsg());
 

	}
	
	@Test

	void alterUser() throws InterruptedException

	{
		driver.get("https://katalon-demo-cura.herokuapp.com");

		LoginPage login = new LoginPage(driver);
		
		Logout l = new Logout(driver);

		login.aMenu();
		Thread.sleep(1000);
				
		login.clickLoginMenu();
		Thread.sleep(1000);
		
		login.setUserName("John Doe");
		Thread.sleep(1000);

		login.setPassword("ThisIsNotAPassword");
		Thread.sleep(1000);

		login.clickButton();
		Thread.sleep(1000);
		Thread.sleep(1000);
		
		l.menuToggle();
		Thread.sleep(1000);
		
		l.logout();
		Thread.sleep(1000);
		
		Assert.assertEquals("We Care About Your Health", login.passLogin());

	}
	
}
