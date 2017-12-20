package businesscomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.cognizant.framework.Status;

import pageObjects.SFDC_Login;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class SFDC extends ReusableLibrary {

	public SFDC(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	public void launchSFDC()
	{
		driver.get(dataTable.getData("General_Data", "Link URL"));
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +dataTable.getData("General_Data", "Link URL"), Status.DONE);
		if (driver.getCurrentUrl().equals(dataTable.getData("General_Data", "Link URL")))
		{
		report.updateTestLog("App Launch", "App laucnhed successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("App Launch", "App did not launch successfully", Status.FAIL);
		}
	}
	
	public void logintoSFDC()
	{
		SFDC_Login login = new SFDC_Login(scriptHelper);
		login.enterUsername(dataTable.getData("General_Data", "UserName"));
		login.enterPassword("Password");
		login.clickLogin();
		
	
		try {
			if (driver.findElement(By.xpath("")).isDisplayed())
			{
				report.updateTestLog("Login to SFDC", "Validate successful login to SFDC", Status.PASS);
			}
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			report.updateTestLog("Login to SFDC", "Validate successful login to SFDC - Element not visible", Status.FAIL);
		}
	}
	
	

}
