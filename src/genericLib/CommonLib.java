package genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonLib extends Base {
	
	// Method to take screenshot and will be called by Listener on test failure.
	 public static void takeScreenShot(String screenshotName) {
		 String fileDestination = ".//screenshots/" + screenshotName + ".jpeg" ; 

		 TakesScreenshot capture =  ((TakesScreenshot) driver);
		 File screenshot =  capture.getScreenshotAs(OutputType.FILE);
		 File destination = new File(fileDestination);
		 
		 try {
			FileUtils.copyFile(screenshot,destination);
		} catch (IOException e) {
		
			System.out.println("Exception catched while saving file.");
			e.printStackTrace();
		}


	 }

}