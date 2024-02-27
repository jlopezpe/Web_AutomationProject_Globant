package Tests;

import Pages.*;
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

        //purchasing one product
        main_page.Purchase_oneProduct();
        Assert.assertEquals(main_page.get_ProductOn_Chart(),purchased_sign);

        main_page.click_cart();

        Purchase_CartPage cart = new Purchase_CartPage(driver);

        //verify that is one product in the cart, and user is on the cart page
        Assert.assertEquals(cart.get_Title(), title_Cartpage);
        Assert.assertEquals(cart.size_cart(), cart_quantity);
        cart.click_CheckoutButton();

        Checkout_InfoPage checkout_InfoPage = new Checkout_InfoPage(driver);
        Assert.assertEquals(checkout_InfoPage.get_Title(), title_checkoutPage);


        //write shipping information
        checkout_InfoPage.write_firstname(first_name);
        checkout_InfoPage.write_lastname(last_name);
        checkout_InfoPage.write_postalCode(postal_code);
        checkout_InfoPage.click_continueButton();

        Checkout_OverviewPage checkout_overviewPage = new Checkout_OverviewPage(driver);
        Assert.assertEquals(checkout_overviewPage.get_Title(), title_checkoutOverview);
        checkout_overviewPage.ClickButton_finish();

        Checkout_CompletePage purchase_complete= new Checkout_CompletePage(driver);
        Assert.assertEquals(purchase_complete.get_Title(),title_CheckoutComplete);

    }
}
