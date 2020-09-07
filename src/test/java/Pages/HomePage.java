package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    @FindBy(id = "gh-eb-Geo-a-default")
    private WebElement languageIcon;
    @FindBy(id = "gh-eb-Geo-a-en")
    private WebElement englishIcon;
    @FindBy(xpath = "//*[@class='hl-image hl-image-js js-only hl-item__bg-image']")
    private WebElement anyProduct;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void changeLanguage() {
        languageIcon.click();
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(englishIcon));
        englishIcon.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    public void selectProduct() {
         WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(anyProduct));
        anyProduct.click();

    }



}