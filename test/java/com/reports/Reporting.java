package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.baseclass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * @see To Create Reporting class
 * @author kaviy
 *
 */
public class Reporting extends BaseClass {
/**
 * @see To create JVM report
 * @param jsonFile
 * @throws IOException 
 * @throws FileNotFoundException 
 */
	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
        
		File file = new File(getProjectPath()+getPropertyFileValue("jvmpath"));
		Configuration configuration =new Configuration(file,"OMRBranchAutomation");
		
		configuration.addClassifications("Browser", "chrome");
		configuration.addClassifications("Version", "108");
		configuration.addClassifications("OS", "WIN11");
		configuration.addClassifications("SPRINT", "34");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
		
	}

}
