package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_InfoPage extends BasePage {


    @FindBy(id ="first-name")
    private WebElement first_name;
    @FindBy(id="last-name")
    private WebElement last_name;

    //I don't know why get elements with xpath doesn't work, but it would be this: xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/input[1]"
    @FindBy(id="postal-code")
    private WebElement postal_code;


    //id="continue"
    //className="submit-button btn btn_primary cart_button btn_action"
    @FindBy(id="continue")
    private WebElement button_continue;
    public Checkout_InfoPage(WebDriver driver) {
        super(driver);
    }
    public void write_firstname(String first_name){
        write_Text(this.first_name,first_name);
    }
    public void write_lastname(String last_name){
        write_Text(this.last_name,last_name);
    }
    public void write_postalCode(String postal_code){
        write_Text(this.postal_code,postal_code);
    }
    public void click_continueButton(){
        click_Element(button_continue);
    }

}
