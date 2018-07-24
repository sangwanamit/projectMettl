package testLib;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.Base;
import genericLib.ExcelLib;
import genericLib.WebDriverCommons;
import pageLib.HomePage;

public class HomePageTests extends Base{
	

	@Test(priority = 0 )
	public void LoginButtonEnabledTest() {
		HomePage pf = PageFactory.initElements(driver,HomePage.class);

		System.out.println(pf.loginBtn.isEnabled());
		AssertJUnit.assertTrue(pf.loginBtn.isEnabled());	
	}
	
	@Test(priority = 1)
	public void LoginButtonDisplayedTest() {
		HomePage pf = PageFactory.initElements(driver,HomePage.class);

		AssertJUnit.assertTrue(pf.loginBtn.isDisplayed());	
	}
	
	@Test (priority =2 , description = "Verifies the landing page based on correct URL, Header and Title")
	public void LoginButtonFunctionalityTest() {
		HomePage pf = PageFactory.initElements(driver,HomePage.class);

		pf.loginBtn.click();
		
		WebDriverCommons.waitTillURLContains("login");
	
		String loginUrl = driver.getCurrentUrl();
		String Header = driver.findElement(By.xpath("//div[contains(@id,'login')]/h2")).getText();
		String title = driver.getTitle();
		
		Boolean verifyURL = loginUrl.contains("login?");
		Boolean verifyHeader = Header.contains("Login");
		Boolean verifyTitle = title.contains("Login");
		
		AssertJUnit.assertTrue(verifyURL && verifyHeader && verifyTitle);
		
	}
	
	@Test (priority =3 , dependsOnMethods = { "LoginButtonFunctionalityTest" })
	public void NavigateBackToHomePageTest() {
		HomePage pf = PageFactory.initElements(driver,HomePage.class);

		driver.navigate().back();
		String actURL = driver.getCurrentUrl();
		String expURL = ExcelLib.getConfigData().get("URL");
		AssertJUnit.assertTrue(actURL.equals(expURL));

	}
	


	

}
