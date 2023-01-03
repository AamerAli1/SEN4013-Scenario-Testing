import bases.TestBase;
import models.User;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import static DataHelper.UserPool.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class RegisterTest extends TestBase{

    @Test
    public void testRegister() {
        User user = newUser();
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();

        String currentUrl = registerPage.getCurrentUrl();
        assertEquals(currentUrl, registerPage.getUrl());

        homePage = registerPage.register(user);
        homePage.waitForPageLoad(homePage.getWaitingPageHeader());

        currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, homePage.getWaitingPageUrl());
    }
}
