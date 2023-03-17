package com.testrunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runner.RunWith;

import com.baseclass.BaseClass;
import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)

@CucumberOptions(tags = (" "), snippets = SnippetType.CAMELCASE, dryRun = false, monochrome = true, plugin = {"pretty",
		"json:C:\\Users\\kaviy\\eclipse-workspace\\OMRBranchAutomation\\target\\index.json"}, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")

public class TestRunnerClass extends BaseClass {

	public static void afterclass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonPath"));
	}
}
