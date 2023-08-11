package com.nopcommerce.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nopcommerce.qa.baseclass.BaseClass;

public class ExtentReporter extends BaseClass {
	public static ExtentReports generateExtendReport() {
		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("NopCommerce Test Automation Result");
		sparkReporter.config().setDocumentTitle("NopCommerce Automation Report");
		sparkReporter.config().setTimeStampFormat("dd//MM//yyyy hh:mm:ss");

		extentReport.attachReporter(sparkReporter);

		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Email", prop.getProperty("validUserName"));
		extentReport.setSystemInfo("Password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReport;
	}
}
