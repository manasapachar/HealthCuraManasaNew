package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.HomeTestCases;

public class Home {

	WebDriver ldriver;
	
	public Home(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"top\"]/div/h1")
	WebElement curahealthservice;

	@FindBy(xpath = "//*[@id=\"top\"]/div/h3")
	WebElement wecareaboutyourhealth;
	
	@FindBy(xpath = "//body//footer//p[contains(.,'Atlanta 550 Pharr Road NE Suite 525Atlanta, GA 30305')]")
	WebElement address;
	
	
	public boolean adressPresent()
	{
		return address.isDisplayed();
	}
	
	public boolean validateHeader(String text1) {
		if (text1.equals(curahealthservice.getText())) {
			return true;
		} else
			return false;
	}

	public boolean validateText(String text) {
		if (text.equals(wecareaboutyourhealth.getText())) {
			return true;
		} else
			return false;

	}

	public boolean validateTextWithoutIfElse(String text) {
		return text.equals(wecareaboutyourhealth.getText());
	}

}
