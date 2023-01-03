import bases.TestBase;
import models.User;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static DataHelper.UserPool.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends TestBase {

    @Test
    public void searchTest(){
        User user = validUser();
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        String currentUrl = loginPage.getCurrentUrl();
        assertEquals(currentUrl, loginPage.getUrl());

        homePage = loginPage.login(user);
        homePage.waitForPageLoad(homePage.getCategoriesNavBar());

        currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, homePage.getProductUrl());

        homePage.checkIfSearchFails();
        homePage.checkSearch("Blue");



    }
}
