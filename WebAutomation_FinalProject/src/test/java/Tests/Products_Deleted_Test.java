package Tests;

import Pages.MainPage;
import Pages.Purchase_CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Products_Deleted_Test extends BaseTest {

    private final String title_mainpage="Products";
    private final String productsOnchart_quantity="3";

    private final String productsOnchartDeleted_quantity="0";

    private final String cartpage_title="Your Cart";


    private final int size_cart=0;


    @Test
    public void Removed_products(){

        MainPage mainpage= new MainPage(driver);
        Assert.assertEquals(mainpage.get_Title(),title_mainpage);
        mainpage.Purchase_threeProducts();
        Assert.assertEquals(mainpage.get_ProductOn_Chart(),productsOnchart_quantity);

        mainpage.click_cart();

        Purchase_CartPage cartpage = new Purchase_CartPage(driver);
        Assert.assertEquals(cartpage.get_Title(),cartpage_title);
        cartpage.clickRemove_threeProducts();
        Assert.assertEquals(cartpage.size_cart(),size_cart);



    }

}
