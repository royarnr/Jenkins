package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.selenium.CraftDriver;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class SFDC_Login extends ReusableLibrary {

	public SFDC_Login(ScriptHelper scriptHelper) {
		super(scriptHelper);
		PageFactory.initElements(driver.getWebDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement btnLogin;
	
	public void enterUsername(String name)
	{
		username.sendKeys(name);
	}
	
	public void enterPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

}
