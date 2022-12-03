import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ProductPage extends BasePage{
    By discountedProductLocator =new By.ByCssSelector("div.products__item.col-6.col-md-4");
    By actualPrice = new By.ByCssSelector("span.product__price.-actual");
    By oldPrice = new By.ByCssSelector("span.product__price.-label.-old.-size");
    By priceLocator = new By.ByCssSelector("div.product__discountPercent");
    By addProductButtonLocator = new By.ByCssSelector("input.radio-box__input.icheck-input");
    By productSizes = new By.ByCssSelector("div.product__size.-productCart.radio-box");


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public String[] selectProduct(){
        WebElement element1 = getDiscountedProducts(priceLocator);
        WebElement element2 = addToCartProduct(addProductButtonLocator,element1.findElements(productSizes));
        scrollWithElement(element1.findElement(priceLocator));
        element2.click();

        return new String[]{
            element1.findElement(actualPrice).getText(),
            element1.findElement(oldPrice).getText(),
            element2.getText()
        };
    }

    private WebElement getDiscountedProducts(By locator){
        return controlElement(locator,findAll(discountedProductLocator));
    }

    private WebElement addToCartProduct(By locator,List<WebElement> listElements){
        return controlButtonEnabled(locator,listElements);
    }

    public boolean isOnProductPage() {
        return isDisplayed(discountedProductLocator);
    }

}
