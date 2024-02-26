package Tests;

import Pages.MainPage;
import Pages.Purchase_CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import outils.Data_getter;

public class Purchase_Product_Test extends BaseTest{

    private String title_Mainpage = "Products";
    private String title_Cartpage = "Your Cart";
    private String title_purchasing_step1 = "Checkout: Your Information";
    private String title_purchasing_step2 = "Checkout: Overview";
    private String title_purchasing_step3 = "Checkout: Complete!";
    private String purchased_sign = "1";
    private int cart_quantity= 1;
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

        
    }
}
