package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.HistoryAppointmentTestCases;

public class HistoryWithApp {
	
	WebDriver ldriver;
	
	public HistoryWithApp (WebDriver driver) {
		
		ldriver = driver;
		PageFactory.initElements(driver, this);

		
	}

	@FindBy(id ="menu-toggle")
	WebElement menuToggleElement;
	
		
	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")
	WebElement historyElement;
	
	@FindBy(xpath = "//*[@id=\"history\"]/div/div[2]/div")
	WebElement withAppointmentElement;
	
	@FindBy(xpath = "//*[@id=\"top\"]/div/h3")
	WebElement loginPass;
	
	@FindBy(xpath = "//*[@id=\"summary\"]/div/div/div[1]/h2")
	WebElement appPass;
	
	@FindBy(xpath = "//*[@id=\"history\"]/div/div[1]/div/h2")
	WebElement historyHeader;
	
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
		withAppointmentElement.click();
	}
	


    public String passLogin() {
   	 return loginPass.getText();
   	 
    }
    
    public String passAppointment() {
   	 return appPass.getText();}
    
     public String getHistoryHeader() {
       	 return historyHeader.getText();
        
    
    
}}
