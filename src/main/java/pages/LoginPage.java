package pages;

import org.openqa.selenium.By;

public class LoginPage {
    private By signInButton = By.xpath("//button[@type='submit']");

    public By getSignInButton() {
        return signInButton;
    }
}
