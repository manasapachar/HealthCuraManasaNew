package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.HistoryTestCases;

public class History {
	
	WebDriver ldriver;
	
	public History (WebDriver driver) {
		
		ldriver = driver;
		PageFactory.initElements(driver, this);

		
	}

	@FindBy(id ="menu-toggle")
	WebElement menuToggleElement;
	
		
	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")
	WebElement historyElement;
	
	@FindBy(xpath = "//*[@id=\"history\"]/div/div[1]/div/p")
	WebElement noAppointmentElement;
	
	@FindBy(xpath = "//*[@id=\"top\"]/div/h3")
	WebElement loginPass;
	
	@FindBy(xpath = "//*[@id=\"history\"]/div/div[1]/div/p")
	WebElement noHistory;
	
	@FindBy(xpath = "//body//footer//p[contains(.,'Atlanta 550 Pharr Road NE Suite 525Atlanta, GA 30305')]")
	WebElement address;
	
	
	public boolean adressPresent()
	{
		return address.isDisplayed();
	}
	
	
	public void menuToggle()
	{
		menuToggleElement.click();
		
	}
	
	
	public void history()
	{
		historyElement.click();
	}
	
	public void appointmentlist()
	{
		noAppointmentElement.click();
	}
	
	 public String passLogin() {
    	 return loginPass.getText();
    	 
     }
	
	 public String passNoHistory() {
    	 return noHistory.getText();
    	 
     }
}
