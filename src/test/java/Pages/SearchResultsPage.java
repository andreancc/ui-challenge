package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultsPage {

    private WebDriver driver;
    @FindBy(id = "gh-ac")
    private WebElement searchBar;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;
    @FindBy(xpath = "//*[contains(@href,'adidas')]")
    private WebElement firstProductTitle;
    @FindBy(xpath = "//*[@class='SECONDARY_INFO'][contains(text(),'Brand New')]")
    private List<WebElement> conditionInfo;
    @FindBy(xpath = "//*[@class='s-item__price']")
    private List<WebElement> itemPrice;
    @FindBy(xpath = "//*[@class='x-textrange__input x-textrange__input--from']")
    private WebElement lowPrice;
    @FindBy(xpath = "//*[@class='x-textrange__input x-textrange__input--to']")
    private WebElement topPrice;
    private final String xpathproductfilters = "//h3[contains(text(),'%s')]/../..//span[contains(text(),'%s')]";

    public SearchResultsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void searchProduct(String product) {
        searchBar.sendKeys(product);
        searchButton.click();
    }

    public void setFilter(String option, String value) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(String.format(xpathproductfilters, option, value))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void setPrice(String value1, String value2) {
        lowPrice.sendKeys(value1);
        topPrice.sendKeys(value2);
        topPrice.sendKeys(Keys.ENTER);
    }
    public boolean validateCondition(String value){
        for(int i=0;i<conditionInfo.size();i++){
            if(!conditionInfo.get(i).getText().equals(value)){
                return false;
            }
        }return true;
    }
    public boolean validatePrice(double minValue, double maxValue,int elementNumber){
      boolean rsp=true;

        for(int i=0;i<elementNumber;i++){
            String price=itemPrice.get(i).getText().replace("COP $", "").replace(",", "");
                 if (price.contains("to")){
                String price1=price.split(" to ")[0];
                String price2=price.split(" to ")[1];
                if(priceVerification(price1,minValue,maxValue)||priceVerification(price2,minValue,maxValue)){
                    return false;
                }
            }
            else{
            rsp=priceVerification(price,minValue,maxValue);
            }}
        return rsp;
    }
    public boolean priceVerification(String price,double min,double max){
        boolean response=true;
        if(Double.parseDouble(price)<min||Double.parseDouble(price)>max){
            response= false;
        }
        return response;
    }

}
