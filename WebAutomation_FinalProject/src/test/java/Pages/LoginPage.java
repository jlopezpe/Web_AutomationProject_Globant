package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import outils.MyDriver;

public class LoginPage extends BasePage{


    //i tried @FindBy(css = "[name='user-name']") but i had some errors using this compose method
    @FindBy(id="user-name")
    private WebElement username;
    @FindBy(id="password")
    private WebElement password;

    //same with this one @FindBy(className="submit-button btn_action")
    // i coudnt know why it didn't work
    @FindBy(id="login-button")
    private WebElement login_button;
    String login_input = driver.findElement(By.cssSelector("input[value='Login']")).getAttribute("value");

    public String getLogin_input() {
        return login_input;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void write_username(String username){
        write_Text(this.username,username);
    }
    public void write_password(String password){
        write_Text(this.password,password);
    }
    public void click_LoginButton(){
        click_Element(this.login_button);
    }

    //public String search_LoginButtonName(){
       // return this.login_button.getText();
    //}

}
