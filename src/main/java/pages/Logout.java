package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class Logout{
	
	
		WebDriver ldriver;
	
	

		public  Logout (WebDriver driver) {
			ldriver = driver;
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(xpath = "//*[@id=\"btn-make-appointment\"]")
		WebElement makeappointment;
		 

		@FindBy(xpath = "//*[@id=\"txt-username\"]")
		WebElement usernameElement;

		@FindBy(xpath = "//*[@id=\"txt-password\"]")
		WebElement passwordElement;

		@FindBy(xpath = "//*[@id=\"btn-login\"]")
		WebElement buttonElement;
		
		@FindBy(xpath ="//*[@id=\"menu-toggle\"]")
		WebElement menuToggleElement;
		
		@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a")
		WebElement logoutElement;
		
		
		@FindBy(xpath = "//*[@id=\"top\"]/div/h3")
		WebElement logoutPass;


		public void makeappointment() {
			makeappointment.click();
		}
		 

		public void setUserName(String username) {
			
			//System.out.println("Username === " + username);
			
			usernameElement.sendKeys(username);
		}

		public void setPassword(String password) {
			passwordElement.sendKeys(password);
		}

		public void clickButton() {
			buttonElement.click();
		}
		
		public void menuToggle()
		{
			menuToggleElement.click();
			
		}
		public void logout()
		{
			logoutElement.click();
			
		}

		

		public void click() {
			// TODO Auto-generated method stub
			
		}
		
		 public String passLogout() {
	    	 return logoutPass.getText();

}}
