package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    private static WebDriver driver;
    public ExtentReports extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLoc = "./Reports/";



    public  static WebDriver init(){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver.get("https://hotels.com");
            return driver;

    }

    public  static WebDriver getDriver(){
           return driver;
    }

    public static void tearDown(){
        if(driver!=null){
            driver.close();
//            driver.quit();
        }

    }
}
