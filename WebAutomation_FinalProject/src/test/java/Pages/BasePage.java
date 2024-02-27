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
import outils.MyDriver;

import javax.xml.xpath.XPath;
import java.sql.Driver;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final Actions actions;

    protected WebElement product_purchasedSign;

    @FindBy(className ="title")
    private WebElement MainTitle;

    @FindBy(css="#shopping_cart_container .shopping_cart_link")
    private WebElement cart;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burger_button;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_button;


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


    //write in any field of the complete page
    public void write_Text(WebElement element, String text){
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }


    //click every element on the page
    public void click_Element(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    //know if there are some products on the cart
    public void ProductOn_Chart() {
        this.product_purchasedSign = driver.findElement(By.className("shopping_cart_badge"));
    }


    //get the value of the badge (quantity) has the cart
    public String get_ProductOn_Chart(){
        return this.product_purchasedSign.getText();
    }

    public String get_Title(){
        return this.MainTitle.getText();
    }

    public void click_cart() {
        click_Element(this.cart);
    }


    public void click_menuBurguer(){
        click_Element(this.burger_button);
        //WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        //setLogoutButton(logoutButton);
    }
    public void click_logout(){
        click_Element(this.logout_button);
    }
}
