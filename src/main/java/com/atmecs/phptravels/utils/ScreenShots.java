package com.atmecs.phptravels.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.atmecs.phptravels.testbase.TestBase;

public class ScreenShots extends TestBase 
{
	LogReports log=new LogReports();
	
	@AfterMethod
	
	public void takeScreenshot(ITestResult result)
	{
	if (ITestResult.FAILURE== result.getStatus()) 
	{
	try
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source =screenshot.getScreenshotAs(OutputType.FILE);   //this will save the screenshot in screenshot folder with failed "methodname.png"
		FileUtils.copyFile(source, new File("C:\\Users\\siva.mutyala\\eclipse-workspace\\PhpTravels\\screenshot"+result.getName() + ".png"));
		log.info("screenshot captured");
	} 
	catch (Exception e) 
	{
	log.info("Exception while taking screenshot " + e.getMessage());
	}
	}
	}


}
