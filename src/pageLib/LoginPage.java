package pageLib;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.Base;
import genericLib.CommonLib;
import genericLib.ExcelLib;

public class LoginPage extends Base {

	
	@FindBy (xpath = "//a[contains(@href,'signup')]") 			public WebElement signUpLink ; 
	@FindBy (xpath = "//a[contains(@href,'forgot')]") 			public WebElement forgotPassLink;
	@FindBy (xpath = "//a[contains(@href,'policy')]") 			public WebElement privacyPolicyLink ; 
	@FindBy (xpath = "//a[contains(@href,'erms')]" ) 			public WebElement TCLink;
	
	@FindBy (xpath = "//input[contains(@name,'ame')]") 			public WebElement userEditBox ;
	@FindBy (xpath = "//input[contains(@name,'assword')]") 		public WebElement passEditBox; 
	@FindBy (xpath = "//button[@type='submit']") 				public WebElement loginBtn ; 
	
	@FindBy (xpath = "//label[contains(text(),'Not a valid email')]") public WebElement NotAValidEmailLabel ;
	@FindBy (xpath = "//label[contains(text(),'Not a registered')]")  public WebElement NotRegisteredLabel ; 
	
	HashMap<String,String> configData = ExcelLib.getConfigData();
	
	public void validLogin() {
		userEditBox.clear();
		passEditBox.clear();
		userEditBox.sendKeys(configData.get("VALID USERNAME"));
		passEditBox.sendKeys(configData.get("VALID PASSWORD"));
		loginBtn.click();
		
	}
	
	public void invalidLogin() {
		userEditBox.clear();
		passEditBox.clear();
		userEditBox.sendKeys(configData.get("INVALID USERNAME"));
		passEditBox.sendKeys(configData.get("INVALID PASSWORD"));
		loginBtn.click();
		
	}
	
	public void unregisteredLogin() {
		userEditBox.clear();
		passEditBox.clear();
		userEditBox.sendKeys(configData.get("UNREGISTERED USERNAME"));
		passEditBox.sendKeys(configData.get("UNREGISTERED PASSWORD"));
		loginBtn.click();
		
	}
	
	
}
