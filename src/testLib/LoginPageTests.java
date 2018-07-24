package testLib;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLib.Base;
import genericLib.CommonLib;
import genericLib.ExcelLib;
import genericLib.WebDriverCommons;
import pageLib.LoginPage;

public class LoginPageTests extends Base {

	@Test(priority  = 0)
	public void navigateToLoginTest() {
		HomePageTests pf = PageFactory.initElements(driver,HomePageTests.class);
		pf.LoginButtonFunctionalityTest();

	}
	
	@Test(priority = 1)
	public void loginWithEmptyCredentialsTest() {
		String urlBefore = driver.getCurrentUrl();
		
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		
		pf.loginBtn.click();
		String urlAfter = driver.getCurrentUrl();

		boolean ErrorMsg = pf.NotAValidEmailLabel.isDisplayed();
		boolean url =  urlAfter.equals(urlBefore);
		Assert.assertTrue(url && ErrorMsg);
		
	}

	@Test(priority = 2)
	public void loginWithInvalidCredentialsTest() {
		String urlBefore = driver.getCurrentUrl();
		
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
 		pf.invalidLogin();
		String urlAfter = driver.getCurrentUrl();

		boolean ErrorMsg = pf.NotAValidEmailLabel.isDisplayed();
		boolean url =  urlAfter.equals(urlBefore);
		Assert.assertTrue(url && ErrorMsg);
		
	}

	@Test(priority = 3)
	public void loginWithUnregisteredCredentialsTest() {
		String urlBefore = driver.getCurrentUrl();
		
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		pf.unregisteredLogin();
		
		WebDriverCommons.waitTillElementToBeDisplayed(pf.NotRegisteredLabel);

		boolean ErrorMsg = pf.NotRegisteredLabel.isDisplayed();


		Assert.assertTrue(ErrorMsg);
		
	}
	
	@Test(priority = 20)
	public void loginWithValidCredentialsTest() {
		String urlBefore = driver.getCurrentUrl();
		driver.navigate().refresh();

		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		pf.validLogin();
		WebDriverCommons.waitTillURLContains("dashboard");

		String urlAfter = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean verifyUrl =  urlAfter.contains("dashboard");
		boolean verifyTitle = title.contains("Control Panel");
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(verifyUrl && verifyTitle);
		
	}
	
	@Test (priority = 4)
	public void verifyForgotPasswordLinkTest() {
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		pf.forgotPassLink.click();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean verifyUrl = url.contains("forgot-password");
		boolean verifyTitle =  title.contains("Forgot password");
		
		Assert.assertTrue(verifyTitle && verifyUrl);
		
		driver.navigate().back();
	}
	
	
	@Test (priority = 5)
	public void verifySignUpLinkTest() {
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		pf.signUpLink.click();
		WebDriverCommons.waitTillURLContains("sign");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean verifyUrl = url.contains("signup");
		boolean verifyTitle =  title.contains("Signup");
		
		Assert.assertTrue(verifyTitle && verifyUrl);
		
		driver.navigate().back();
	
	}
		
	
	@Test (priority = 6)
	public void verifyPrivacyPolicyLinkTest() {
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		pf.privacyPolicyLink.click();
		WebDriverCommons.waitTillURLContains("policy");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean verifyUrl = url.contains("privacy-policy");
		boolean verifyTitle =  title.contains("Privacy Policy");


		Assert.assertTrue(verifyTitle && verifyUrl);
		
		driver.navigate().back();
	
	}
	@Test (priority = 7)
	public void verifyTermsAndConditionsLinkTest() {
		LoginPage pf = PageFactory.initElements(driver,LoginPage.class);
		WebDriverCommons.waitTillElementToBeDisplayed(pf.TCLink);
		pf.TCLink.click();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean verifyUrl = url.contains("terms-of-services");
		boolean verifyTitle =  title.contains("Services");
		
		Assert.assertTrue(verifyTitle && verifyUrl);
		
		driver.navigate().back();
	
	}
		
	
}
