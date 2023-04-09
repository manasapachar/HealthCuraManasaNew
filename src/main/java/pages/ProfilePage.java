package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	
	WebDriver ldriver;
	
	public ProfilePage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h2[normalize-space()='Profile']")
	WebElement profileLabel;
	
	
	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profile;
	
	
	
	
	@FindBy(xpath = "//body//footer//p[contains(.,'Atlanta 550 Pharr Road NE Suite 525Atlanta, GA 30305')]")
	WebElement address;
	
	
	public boolean adressPresent()
	{
		return address.isDisplayed();
	}
	
	public void clickProfile()
	{
		profile.click();
	}
	
	
	
	
	public boolean prfileLabelPresent()
	{
		return profileLabel.isDisplayed();
	}
	
	

}
