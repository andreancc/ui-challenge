package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='item-title truncate-multiline lines-2 black-link']")
    private WebElement productTitle;

    public WebElement getProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle;
    }
}
