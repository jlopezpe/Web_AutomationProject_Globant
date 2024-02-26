package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Purchase_CartPage extends BasePage{
    //".cart_item button[id^=remove]"
    @FindAll({@FindBy(css = ".cart_item button")})
    private List<WebElement> remove_buttons;
    @FindBy(css="button[data-test='checkout']")
    private WebElement checkout_button;
    @FindBy(className="cart_item")
    private List<WebElement> items_cart;

    public Purchase_CartPage(WebDriver driver){
        super(driver);

    }
    public void remove_elements(){
        for (WebElement button_remove:remove_buttons){
            click_Element(button_remove);
        }
        remove_buttons.clear();
    }
    public void click_CheckoutButton(){
        click_Element(checkout_button);
    }
    public Integer size_cart(){
        return items_cart.size();
    }

    public void clickRemove_threeProducts(){

        for(WebElement remove_buttons: remove_buttons){

            click_Element(remove_buttons);
        }
        remove_buttons.clear();
    }

}
