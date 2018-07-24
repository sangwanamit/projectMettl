package genericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommons extends Base{

	public static void waitTillAlertPresent() {
		WebDriverWait wait =  new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitTillElementToBeClickable(WebElement locator) {
		WebDriverWait wait =  new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitTillURLContains(String fraction) {
		WebDriverWait wait =  new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.urlContains(fraction));
	}
	
	public static void waitTillElementToBeDisplayed(WebElement element) {
		WebDriverWait wait =  new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	
}
