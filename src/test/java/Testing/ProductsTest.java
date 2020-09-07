package Testing;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductsTest{
private WebDriver driver;
@BeforeTest
public void setUp() {
    driver = BrowserFactory.getBrowser("Firefox");
    driver.get("https://www.ebay.com/");
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
    @Test
    public void searchProduct(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.changeLanguage();
        SearchResultsPage searchResultsPage=PageFactory.initElements(driver,SearchResultsPage.class);
        searchResultsPage.searchProduct("phone");
        searchResultsPage.setFilter("Condition","New");
        searchResultsPage.setPrice("300000","2000000");
        Assert.assertTrue(searchResultsPage.validateCondition("Brand New"));
        Assert.assertTrue(searchResultsPage.validatePrice(300000,2000000,3));

}

}

