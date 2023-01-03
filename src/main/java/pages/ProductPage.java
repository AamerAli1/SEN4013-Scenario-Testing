package pages;

import bases.PageBase;
import lombok.Getter;
import models.User;
import org.openqa.selenium.By;

public class ProductPage extends PageBase {

    String url = "http://localhost:8000/products/";

    By SearchBox = By.id("search-box");

    public ProductPage(){
    }


}
