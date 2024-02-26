package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_OverviewPage extends BasePage{

    //(id="finish")

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[9]/button[2]")
    private WebElement button_finish;
    public Checkout_OverviewPage(WebDriver driver) {
        super(driver);
    }
    public void ClickButton_finish(){
        click_Element(button_finish);
    }
}
