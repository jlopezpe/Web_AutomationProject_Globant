package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.sql.Driver;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final Actions actions;

    protected WebElement product_purchasedSign;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
    private WebElement MainTitle;

    @FindBy(css="#shopping_cart_container .shopping_cart_link")
    private WebElement cart;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void waitToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void write_Text(WebElement element, String text){
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void click_Element(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void ProductOn_Chart() {
        this.product_purchasedSign = driver.findElement(By.className("shopping_cart_badge"));
    }

    public String get_ProductOn_Chart(){
        return this.product_purchasedSign.getText();
    }

    public String get_Title(){
        return this.MainTitle.getText();
    }

    public void click_cart() {
        click_Element(cart);
    }


}
