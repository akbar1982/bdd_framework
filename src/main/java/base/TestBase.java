package base;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class TestBase extends DriverManager {

    // here we put all of our re-usable methods


DriverManager driverManager = new DriverManager();

    public WebElement getElement(By element){
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),30);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(driverManager.getDriver().findElement(element)));
        ((JavascriptExecutor)driverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", ele);

        return ele;
    }


    public List<WebElement> getElements(By element){
        List<WebElement> ele = driverManager.getDriver().findElements(element);
        return ele;
    }

    public WebElement getElementWithFluentWait(By element){

        Wait wait = new FluentWait<WebDriver>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NotFoundException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class);
        WebElement ele = (WebElement) wait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply( WebDriver driver) {
                return driver.findElement(element);
            }
        });
        return ele;

    }

    //    this method is used for sending texts
    public void sendText(By element, String text){
        getElement(element).sendKeys(text);
    }

    public void scrollToElementy (By element){
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", getElement(element));

    }

    public String getTextOfElement(By element){
        return getElementWithFluentWait(element).getText();
    }

    public void clickOn(By element){
        getElement(element).click();
    }

    public String getTitleOfThePage(){
        
        String title = driverManager.getDriver().getTitle();
        return title;
    }
//
//    public static String getReportConfigPath(){
//
//        String reportConfigPath = "./configs/extent-config.xml";
//        if(reportConfigPath!= null) return reportConfigPath;
//        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
//    }


//    public  void takeScreenShot(){
//
//        try {
//            TakesScreenshot scrShot =((TakesScreenshot)driverManager.getDriver());
//            File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
//            File destFile=new File("./screenshots/"+ LocalDateTime.now().toString()+".png");
//            FileUtils.copyFile(srcFile, destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }



}
