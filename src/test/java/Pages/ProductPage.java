package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    @FindBy(id = "isCartBtn_btn")
    private WebElement cartAddButton;
    @FindBy(xpath = "//*[@class='it-ttl']")
    private WebElement anyProduct;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void addtoCart() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(cartAddButton));
        cartAddButton.click();
    }
    public String getname() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(anyProduct));
        return anyProduct.getText();
    }

}
