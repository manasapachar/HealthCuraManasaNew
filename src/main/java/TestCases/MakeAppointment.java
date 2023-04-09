
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Logout;
import pages.MakeAppointmentPage;
import utility.BaseClass;

public class MakeAppointment extends BaseClass// The extends keyword extends a class
												// (indicates that a class is inherited from another class)
{

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

		Logout l = new Logout(driver);
		
		l.menuToggle();
		
		l.logout();
		
	}
}
