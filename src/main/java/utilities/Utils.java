package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class Utils {
	
	public static String getScreenshot(String name) throws IOException {
		
		TakesScreenshot screenshotDriver = (TakesScreenshot) BaseTest.driver;
	    File srcFile=screenshotDriver.getScreenshotAs(OutputType.FILE);
	    String destFilePath = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+name+".png";
		File destFile = new File(destFilePath);
		FileUtils.copyFile(srcFile, destFile);
		
		return destFilePath;
	}
	
	public static String getBase64Img(String name) throws IOException {
		
		String destFilePath = getScreenshot(name);
		byte[] file = FileUtils.readFileToByteArray(new File(destFilePath));
        String base64Img = Base64.encodeBase64String(file);
		
		return base64Img;
	}
}
