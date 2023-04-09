package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.MakeAppointment;

public class MakeAppointmentPage {
	
	
	  	WebDriver ldriver;
		
		public MakeAppointmentPage(WebDriver driver) {
			ldriver = driver;
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(id = "combo_facility")
		WebElement faciltyElement;
		 
	
		@FindBy(xpath = "//label[@for='chk_hospotal_readmission']")
		WebElement hospitalReaddmissionElement;

		@FindBy(id = "radio_program_medicaid")
		WebElement medicalAidElement;
		
		@FindBy(xpath = "//div[@class='input-group-addon']")
		WebElement dateElement;
	
		@FindBy(xpath = "//td[normalize-space()='15']")
		WebElement calender;
		
		@FindBy(id = "txt_comment")
		WebElement commentElement1;
		

		@FindBy(id = "btn-book-appointment")
		WebElement bookApointmentElement;
		
		
		@FindBy(xpath = "//*[@id=\"top\"]/div/h3")
		WebElement loginPass;
		
		@FindBy(xpath = "//*[@id=\"summary\"]/div/div/div[1]/h2")
		WebElement appPass;
		
		
		
		@FindBy(xpath = "//body//footer//p[contains(.,'Atlanta 550 Pharr Road NE Suite 525Atlanta, GA 30305')]")
		WebElement address;
		
		
		public boolean adressPresent()
		{
			return address.isDisplayed();
		}
		
	
		public void setFacilty(String facility)
		{
			faciltyElement.sendKeys(facility);
		}
	


		public void selectReadmission()
		{
			hospitalReaddmissionElement.click();
		}
		
		
		public void selectMedicalAid()
		{
			medicalAidElement.click();
		}
		
		public void selectCalender()
		{
			dateElement.click();
		}
		

		public void setDate()
		{
			calender.click();
		}
		
		

		public void setComment(String comment)
		{
			commentElement1.sendKeys(comment);
		}
		
		
		public void bookAppointement()
		{
			bookApointmentElement.click();
			
		}
		
		 public String passLogin() {
	    	 return loginPass.getText();}
	
	     public String passAppointment() {
		    	 return appPass.getText();
}}