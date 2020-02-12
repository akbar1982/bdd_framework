package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;

public class ExtentReporter extends DriverManager {

   String fileName = reportLoc + "report.html";

   public  void extentReport(){
       extent = new ExtentReports();
       ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
       htmlReporter.config().setTheme(Theme.STANDARD);
       htmlReporter.config().setDocumentTitle("Hotels.com test report");
       extent.attachReporter(htmlReporter);
   }

   public void extentReportScreenShot(){
       try {
           String filePath = fileName + File.pathSeparator+"/screenshots/"+ LocalTime.now()+"shot.png";
           File scr = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
           Files.copy(scr.toPath(),new File(filePath).toPath());
           scenarioDef.fail("details").addScreenCaptureFromPath(filePath);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }


   public void flushReport(){
       extent.flush();
   }
}
