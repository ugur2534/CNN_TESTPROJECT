package com.Reports;
import java.io.File;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
        private static ExtentReports extent;
        private static String reportFileName = "Extents-Report"+".html";//1= report name
        private static String fileSeperator = System.getProperty("file.separator");
        private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "target";
        private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
       
        public static ExtentReports getInstance() {
            if (extent == null)
                createInstance();
            return extent;
        }
   
        //Create an extent report instance
        public static ExtentReports createInstance() {
            String fileName = getReportPath(reportFilepath);                          
          
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
			/*
			 * // htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			 * //htmlReporter.config().setChartVisibilityOnOpen(true);
			 * htmlReporter.config().setTheme(Theme.DARK);
			 * htmlReporter.config().setDocumentTitle(reportFileName);
			 * htmlReporter.config().setEncoding("utf-8");
			 * htmlReporter.config().setReportName(reportFileName); htmlReporter.config().
			 * setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			 * //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); extent =
			 * new ExtentReports(); extent.attachReporter(htmlReporter); //Set environment
			 * details extent.setSystemInfo("OS", "Windows");
			 * extent.setSystemInfo("Laptop ", "Sarower Ahmmed");
			 * extent.setSystemInfo("Developer", ""); extent.setSystemInfo("user",
			 * System.getProperty("user.name")); extent.attachReporter(htmlReporter);
			 */
            
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");//2= config file path
            htmlReporter.config().setAutoCreateRelativePathMedia(true);
			
           
            extent = new ExtentReports();
            extent.attachReporter(new ExtentReporter[]{htmlReporter});
            extent.setSystemInfo("Host Name", SystemUtils.getHostName());
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            
            return extent;
        }
        
        //Create the report path
        private static String getReportPath (String path) {
            File testDirectory = new File(path);
            if (!testDirectory.exists()) {
                if (testDirectory.mkdir()) {
                    System.out.println("Directory: " + path + " is created!" );
                    return reportFileLocation;
                } else {
                    System.out.println("Failed to create directory: " + path);
                    return System.getProperty("user.dir");
                }
            } else {
                System.out.println("Directory already exists: " + path);
            }
            return reportFileLocation;
        }
}