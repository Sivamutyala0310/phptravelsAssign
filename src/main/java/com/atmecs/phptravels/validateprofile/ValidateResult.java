package com.atmecs.phptravels.validateprofile;

import org.testng.Assert;

import com.atmecs.phptravels.utils.LogReports;

public class ValidateResult {
	
	static LogReports report = new LogReports();

	public static boolean validateData(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual,expected);
			
			report.info("Assertion Passed : " + message + ": " + "Actual data : " + actual + "   " + "Expected :" + expected);
			return true;
		} 
		catch (AssertionError assertionError) {
			report.info("Assertion failed : " + message + ": " + "Actual data : " + actual + "   " + "Expected :" + expected);
			return false;
		}
	}
}
