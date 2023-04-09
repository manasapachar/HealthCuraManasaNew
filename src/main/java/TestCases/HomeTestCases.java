package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utility.BaseClass;

@Test
public class HomeTestCases extends BaseClass {

	public void testHomeScreen() throws InterruptedException {

		driver.get(url);

		Home home = new Home(driver);	

		boolean textExists = home.validateText("We Care About Your Health");
		
		Assert.assertTrue(textExists);

	}

}
