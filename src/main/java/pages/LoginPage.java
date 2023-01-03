package pages;

import bases.PageBase;
import lombok.Getter;
import models.User;
import org.openqa.selenium.By;

@Getter
public class LoginPage extends PageBase {

    String url = "http://localhost:8000/accounts/login/";


    By loginEmailTextBox = By.id("login-name");
    By loginPasswordTextBox = By.id("login-password");
    By submitButton = By.className("submit");

    public LoginPage() {
    }

    public HomePage login(User user) {
        sendKeys(loginEmailTextBox, user.getUserName());
        sendKeys(loginPasswordTextBox, user.getPassword());
        click(submitButton);

        return new HomePage();
    }
}
