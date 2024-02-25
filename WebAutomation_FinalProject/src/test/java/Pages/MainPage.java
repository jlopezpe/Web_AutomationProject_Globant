package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(css = "[data-test*='add-to-cart']")
    private List<WebElement> addToCartButtons;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
