package Tests;

import Pages.Checkout_InfoPage;
import Pages.MainPage;
import Pages.Purchase_CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import outils.Data_getter;

public class Purchase_Product_Test extends BaseTest{

    private final String title_Mainpage = "Products";
    private final String title_Cartpage = "Your Cart";
    private final String title_checkoutPage = "Checkout: Your Information";
    private final String title_checkoutOverview = "Checkout: Overview";
    private final String title_CheckoutComplete = "Checkout: Complete!";
    private final String purchased_sign = "1";
    private final int cart_quantity= 1;
    @Test(dataProvider = "checkout_info",dataProviderClass = Data_getter.class)
    public void purchaseTest(String first_name,String last_name, String postal_code) {

        MainPage main_page = new MainPage(driver);
        Assert.assertEquals(main_page.get_Title(), title_Mainpage);

        main_page.Purchase_oneProduct();
        Assert.assertEquals(main_page.get_ProductOn_Chart(),purchased_sign);

        main_page.click_cart();

        Purchase_CartPage cart = new Purchase_CartPage(driver);
        Assert.assertEquals(cart.get_Title(), title_Cartpage);
        Assert.assertEquals(cart.size_cart(), cart_quantity);
        cart.click_CheckoutButton();

        Checkout_InfoPage checkout_InfoPage = new Checkout_InfoPage(driver);
        Assert.assertEquals(checkout_InfoPage.get_Title(), title_checkoutPage);


        checkout_InfoPage.write_firstname(first_name);
        checkout_InfoPage.write_lastname(last_name);
        checkout_InfoPage.write_postalCode(postal_code);
        checkout_InfoPage.click_continueButton();
    }
}
