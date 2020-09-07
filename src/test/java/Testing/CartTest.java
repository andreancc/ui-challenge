package Testing;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CartTest {
    private WebDriver driver;
    @BeforeTest
    public void setUp() {
        driver = BrowserFactory.getBrowser("Chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
    @Test
    public void buyProduct() throws IOException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProductPage productPage=PageFactory.initElements(driver,ProductPage.class);
        homePage.changeLanguage();
        homePage.selectProduct();
        String selectedProduct= productPage.getname();
        productPage.addtoCart();
        CartPage cartPage=PageFactory.initElements(driver,CartPage.class);
        Assert.assertEquals(cartPage.getProductTitle().getText(),selectedProduct);
        screenShot();
    }
    public void screenShot() throws IOException {
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenShotName=new File("/Users/acastillo/Desktop"+driver.getTitle()+".png");
        FileUtils.copyFile(scrFile,screenShotName);
        Reporter.log("<br><img src='"+screenShotName+"'height='400' width='400'/><br>");

    }
}
