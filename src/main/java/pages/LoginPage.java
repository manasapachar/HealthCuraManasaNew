package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestCases.LoginTestCases;
import utility.BaseClass;

public class LoginPage {
	
	WebDriver ldriver;

	public LoginPage(WebDriver driver){

		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(id = "btn-make-appointment")
	WebElement makeappointment;// variable 

	@FindBy(id = "txt-username")
	WebElement usernameElement;

	@FindBy(id = "txt-password")
	WebElement passwordElement;

	@FindBy(id = "btn-login")
	WebElement buttonElement;
	
	@FindBy(xpath = "//*[@id=\"login\"]/div/div/div[1]/p[2]")
	WebElement loginErrorMsg;
	
	@FindBy(xpath = "//*[@id=\"top\"]/div/h3")
	WebElement loginPass;
	

	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[2]/a")
	WebElement homeElement;
	
	@FindBy(xpath = "//*[@id=\"summary\"]/div/div/div[1]/h2")
	WebElement appPass;
	
	@FindBy(id = "menu-toggle")
	WebElement toggleMenu;

	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")
	WebElement login;
	
	
	@FindBy(xpath = "//body//footer//p[contains(.,'Atlanta 550 Pharr Road NE Suite 525Atlanta, GA 30305')]")
	WebElement address;
	
	
	public boolean adressPresent()
	{
		return address.isDisplayed();
	}
	
	

	public void makeappointment() {

		makeappointment.click();
		
		
	}

	public void setUserName(String username) {
	
		usernameElement.sendKeys(username);
		
	}

	public void setPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickButton() {
		buttonElement.click();
		
	}

	public void aMenu() {
		toggleMenu.click();
		
	}
	
	public String getErrorMsg() {
		return loginErrorMsg.getText();
	}


 	public void menuToggle() {
 		toggleMenu.click();

 	}

 	public void home() {
 		homeElement.click();

 	}
 	
     public String passAppointment() {
    	 return appPass.getText();
 }

     

     public String passLogin() {
    	 return loginPass.getText();
    	 
     }

		
		public void clickLoginMenu() {
			login.click();

		}
		 
}

