package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    private final String title_mainpage="Products";
    private final String login_button_text="Login";

    //String login_input = driver.findElement(By.cssSelector("input[value='Login']")).getAttribute("value");


    @Test()
    public void logging_out(){


        //on the main page, we click on menu burguer to logout
        MainPage mainPage=new MainPage(driver);
        Assert.assertEquals(mainPage.get_Title(),title_mainpage);
        mainPage.click_menuBurguer();
        mainPage.click_logout();
        //mainPage.click_logout();

        //we verify that we are redirected to the log in page
        LoginPage loginPage= new LoginPage(driver);
        Assert.assertEquals(loginPage.getLogin_input(), login_button_text);


    }
}
