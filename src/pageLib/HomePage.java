package pageLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.Base;

public class HomePage extends Base {
	
	@FindBy (xpath = "//a[contains(@data-type,'ogin')]") public WebElement loginBtn ; 
	
	public void navigateToLoginPage() {
		loginBtn.click();
	}
	

	

}
