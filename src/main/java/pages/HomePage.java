package pages;

import bases.PageBase;
import lombok.Getter;
import org.openqa.selenium.By;

import static bases.TestBase.driver;
import static bases.TestBase.getWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class HomePage extends PageBase {

    String productUrl = "http://localhost:8000/products/";
    String failedUrl = "http://localhost:8000/login/";
    String waitingPageUrl = "http://localhost:8000/waitingPage/";
    String wishListUrl = "http://localhost:8000/order-summary/";
    By signInUserButton = By.className("sign-in");
    By signUpUserButton = By.className("register");
    By productContainer = By.className("products");
    By categoriesNavBar = By.className("categories");
    By waitingPageHeader = By.id("waiting-page");
    By wishListButton = By.className("wish-list");

    By addToCartButton = By.className("add-to-cart");

    By searchBox = By.id("search-box");


    public HomePage() {
    }

    public LoginPage goToLoginPage() {
        click(signInUserButton);
        getWait().until(visibilityOfElementLocated(By.id("sign-in")));
        return new LoginPage();
    }
    public RegisterPage goToRegisterPage() {
        click(signUpUserButton);
        getWait().until(visibilityOfElementLocated(By.className("sign-up")));
        return new RegisterPage();
    }

    public void checkIfSearchFails(){
        sendKeys(searchBox, "%");
        sendEnter(searchBox);
        String currentURL = getCurrentUrl();
        assertTrue(currentURL.contains(productUrl));
    }
    public void checkSearch(String keyword){
        sendKeys(searchBox, keyword);
        sendEnter(searchBox);

        String currentURL = getCurrentUrl();
        assertTrue(currentURL.contains("Blue"));
    }

    public void addToCart(){
        click(addToCartButton);
    }

    public void switchToWishListPage(){
        click(wishListButton);
        String currentUrl = getCurrentUrl();
        assertEquals(currentUrl,wishListUrl);
    }


}
