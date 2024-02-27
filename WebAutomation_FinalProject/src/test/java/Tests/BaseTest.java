package Tests;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import outils.MyDriver;

public class BaseTest {

    //protected static MyDriver driver;

    protected static WebDriver driver;
    protected LoginPage LoginPage;

    //we can use this config without creating a class but i tried as well (MyDriver)
    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){WebDriverManager.chromedriver().setup();}


    //with beforemethod, this method will be executed everytime before a test, because
    //we have to log in every time
    @Parameters({"browser","url","username","password"})
    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(String browser,String url,String username,String password){
        driver = new ChromeDriver();
        //driver=new ChromeDriver(browser);
        driver.manage().window().maximize();
        //driver.navigateTo(url);
        //using my driver
        //driver.getDriver().get();
        driver.get(url);
        LoginPage = new LoginPage(driver);
        //load_loginpage();
        LoginPage.write_username(username);
        LoginPage.write_password(password);
        LoginPage.click_LoginButton();
    }

    //public void navigateTo(String url){
    //driver.getDriver().get(url);
    //}

    //public LoginPage load_loginpage(){
    //return new LoginPage(driver.getDriver());
    //}

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.quit();
        //driver.getDriver().close();
    }
}
