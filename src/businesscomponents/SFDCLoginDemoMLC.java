package businesscomponents;

import org.openqa.selenium.By;

import com.cognizant.framework.Status;

import pageObjects.SFDC_Login;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class SFDCLoginDemoMLC extends ReusableLibrary{

	public SFDCLoginDemoMLC(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	public void launchSFDCDemo()
	{
		driver.get(dataTable.getData("General_Data", "URL"));
		
		SFDC_Login login = new SFDC_Login(scriptHelper);
		login.enterUsername(dataTable.getData("General_Data", "Username"));
		login.enterPassword(dataTable.getData("General_Data", "Password"));
		login.clickLogin();
		
		report.updateTestLog("Login to SFDC", "Login", Status.DONE);
		
		try {
			if(driver.findElement(By.xpath("")).isDisplayed())
			{
				report.updateTestLog("Validation", "Validation", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validation", "Validation", Status.FAIL);
			}
		} catch (Exception e) {
			// TODO: handle exception
			report.updateTestLog("Validation", "Element not visible/enabled", Status.FAIL);
			
		}
		
		
	}
	

}
