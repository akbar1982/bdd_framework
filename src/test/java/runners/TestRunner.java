package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"classpath:features"}
        ,glue={"stepdefinition"},

//        strict = true,
//        dryRun = true,
        tags = {"@Run"}
//        plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }



}
