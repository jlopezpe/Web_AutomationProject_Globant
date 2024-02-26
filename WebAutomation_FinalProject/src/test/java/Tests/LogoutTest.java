package Tests;

import Pages.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    private final String title_mainpage="Products";
    @Test()
    public void logging_out(){

        MainPage mainPage=new MainPage(driver);
        //Assert.assertEquals(mainPage.get_Title(),title_mainpage);
        mainPage.click_menuBurguer();
        mainPage.click_logout();
        //mainPage.click_logout();


    }
}
