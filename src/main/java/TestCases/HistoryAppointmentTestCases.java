package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.History;
import pages.HistoryWithApp;
import pages.LoginPage;
import pages.Logout;
import pages.MakeAppointmentPage;
import utility.BaseClass;

public class HistoryAppointmentTestCases extends BaseClass {

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

	}

	@Test(dependsOnMethods = "verifyUser")
	void verifyAppointment() throws InterruptedException

	{

		driver.get(url);

		MakeAppointmentPage appointment = new MakeAppointmentPage(driver);

		appointment.setFacilty(" Tokyo CURA Healthcare Center ");

		appointment.selectReadmission();

		appointment.selectMedicalAid();

		appointment.selectCalender();

		appointment.setDate();

		appointment.setComment("COVID");

		appointment.bookAppointement();		
		
		Assert.assertEquals("Appointment Confirmation", appointment.passAppointment());

	}

	@Test(dependsOnMethods = "verifyAppointment")

	void verifyAppointment1()

	{
		driver.get(url);

		HistoryWithApp withHistory = new HistoryWithApp(driver);

		withHistory.menuToggle();

		withHistory.history();

		withHistory.appointmentlist();

		Assert.assertEquals("History", withHistory.getHistoryHeader());
		
		Logout l = new Logout(driver);
		
		l.menuToggle();
		
		l.logout();

	}

}
