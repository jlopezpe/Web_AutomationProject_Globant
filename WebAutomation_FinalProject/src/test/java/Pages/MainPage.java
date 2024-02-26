package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {

    //tried this but doesnt work (button[data-test*='add-to-cart']) ;
    @FindBy(css="button[data-test*='add-to-cart']")
    private List<WebElement> buttons_addcart;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void Purchase_oneProduct() {

        //creation of a random num for purchase a random product
        Random random_num = new Random();
        int num = random_num.nextInt(buttons_addcart.size());
        click_Element(buttons_addcart.get(num));
        ProductOn_Chart();
    }

    public void Purchase_threeProducts(){

        Collections.shuffle(buttons_addcart);

        click_Element(this.buttons_addcart.get(0));
        click_Element(this.buttons_addcart.get(1));
        click_Element(this.buttons_addcart.get(2));
        ProductOn_Chart();
    }
}
