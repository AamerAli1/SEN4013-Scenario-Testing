import bases.TestBase;
import models.User;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static DataHelper.UserPool.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    /*
     * 1- Set the data or provide the data
     * 2- Actions
     * 3- Assertion
     * */

    @Test
    public void testLogin() {
        User user = validUser();
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        String currentUrl = loginPage.getCurrentUrl();
        assertEquals(currentUrl, loginPage.getUrl());

        homePage = loginPage.login(user);
        homePage.waitForPageLoad(homePage.getCategoriesNavBar());

        currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, homePage.getProductUrl());
    }

    @Test
    public void testFailedLogin() {
        User user = failUser();
        HomePage homePage = new HomePage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user);

        String currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, homePage.getFailedUrl());
    }


}
