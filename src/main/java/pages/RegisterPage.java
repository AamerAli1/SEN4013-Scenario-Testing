package pages;

import bases.PageBase;
import models.User;
import org.openqa.selenium.By;
import lombok.Getter;

@Getter
public class RegisterPage extends PageBase{

    String url = "http://localhost:8000/users/register/";

    By userName = By.id("login-name");
    By email = By.id("email");
    By password = By.id("exampleInputPassword1");
    By confirmPassword = By.id("exampleInputPassword2");

    By submitButton = By.id("submitButton");

    public RegisterPage(){
    }

    public HomePage register(User user) {
        sendKeys(userName, user.getUserName());
        sendKeys(email, user.getEmail());
        sendKeys(password, user.getPassword());
        sendKeys(confirmPassword, user.getPassword());
        click(submitButton);

        return new HomePage();
    }


}
