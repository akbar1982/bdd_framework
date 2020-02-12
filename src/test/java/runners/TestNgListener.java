package runners;

import base.ExtentReporter;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static base.DriverManager.features;

public class TestNgListener implements ITestListener, MyInterface {

    ExtentReporter extentReporter = new ExtentReporter();

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentReporter.extentReportScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

        extentReporter.extentReport();
        features = extentReporter.extent.createTest(Feature.class,  Feature.getGherkinName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReporter.flushReport();
    }

    @Override
    public void myTestInt() {

    }
}
