package stepdefinition;

import base.DriverManager;
import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginPage;

public class LandingPageTests extends DriverManager {



    TestBase base = new TestBase();
    LandingPage landingPage = new LandingPage();
    LoginPage loginPage = new LoginPage();

    @Given("User in landing page of hotels.com")
    public void user_in_landing_page_of_hotels_com() {
       scenarioDef.createNode("User in landing page of hotels.com","");
       base.clickOn(landingPage.getPopUpCancelBtn());
       Assert.assertEquals( base.getTitleOfThePage(),"Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
    }

    @Then("User clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        scenarioDef.createNode("User clicks on sign in button","");
        base.clickOn(landingPage.getSignInMenuOption());
    }

    @Then("User validates sign in page title")
    public void user_validates_sign_in_page_title() {
        scenarioDef.createNode("User validates sign in page title","");
        Assert.assertEquals( base.getTitleOfThePage(),"Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
    }

    @Then("User validates {string} of the sign in button")
    public void user_validates_of_the_sign_in_button(String string) {
        scenarioDef.createNode("User validates {string} of the sign in button","");
        Assert.assertEquals( base.getTextOfElement(loginPage.getSignInButton()),string);
    }



}
