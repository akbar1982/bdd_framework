package stepdefinition;
import base.DriverManager;
import io.cucumber.java.*;


public class TestHooker extends DriverManager {



    @Before
    public void start(Scenario scenario){
        init();
        scenarioDef = features.createNode(scenario.getName());
    }
    @After
    public void stop(){
        tearDown();
    }





}
