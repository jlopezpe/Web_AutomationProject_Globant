package outils;
import org.testng.annotations.DataProvider;
public class Data_getter {

    //this data will be provided before the tests begin to do a login for the first step
    @DataProvider(name = "login_successful")
    public static Object[][] successful_Login() {
        return new Object[][] {
                {
                        "standard_user", "secret_sauce"
                }
        };
    }

    //making a bad unsuccessful login

    @DataProvider(name = "login_unsuccessful")
    public static Object[][] unsuccessful_Login() {
        return new Object[][] {
                {
                        "incorrect_user", "incorrect_password"
                }
        };
    }

    //This data is used for the purchase product test
    //filling the info required
    @DataProvider(name = "checkout_info")
    public static Object[][] Personal_info_Purchasing() {
        return new Object[][] {
                {
                        "Jonathan", "Lopez", "050051"
                }
        };
    }
}