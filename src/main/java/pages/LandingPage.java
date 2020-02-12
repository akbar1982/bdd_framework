package pages;

import org.openqa.selenium.By;

public class LandingPage {

    private By signInMenuOption = By.xpath("//*[@id='header-sign-in']");
    By popUpCancelBtn = By.xpath("//*[@class=\"cta widget-overlay-close\"]");

    public By getPopUpCancelBtn() {
        return popUpCancelBtn;
    }

    public By getSignInMenuOption() {
        return signInMenuOption;
    }
}
