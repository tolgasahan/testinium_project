import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HomePage extends  BasePage{

    By cookiesLocator = By.id("onetrust-accept-btn-handler");
    By showAllButtonLocator = new By.ByCssSelector("button.button.-secondary.-sm.relative");
    By goToCartButtonLocator = new By.ByCssSelector("a.button.-primary.header__basket--checkout.header__basketModal.-checkout");
    By logoLocator = new By.ByCssSelector("a.headerCheckout__logo");
    By cartButtonLocator = new By.ByCssSelector("button.header__basketTrigger.js-basket-trigger.-desktop");
    By deleteFromCartLocator = new By.ByCssSelector("div.header__basketProductBtn.header__basketModal.-remove");
    By deleteAskLocator = new By.ByCssSelector("button.btn.-black.o-removeCartModal__button");
    By cartCountLocator = new By.ByCssSelector("span.header__basket--count");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies(){
        if (isDisplayed(cookiesLocator)){
            click(cookiesLocator);
        }
    }

    public void scrollTo(){
        scroll(showAllButtonLocator);
    }

    public void clickButton(){
        click(showAllButtonLocator);
    }

    public void goToCart(){click(goToCartButtonLocator);}

    public void clickLogo(){
        click(logoLocator);
    }

    public void clickCartButton(){
        click(cartButtonLocator);
    }

    public void deleteFromCart(){
        click(deleteFromCartLocator);
    }

    public void sureDelete(){
        click(deleteAskLocator);
    }

    private int getCartCount(){

            String count = find(cartCountLocator).getText();
            return Integer.parseInt(count);


    }

    public boolean isProductCountZero() {
        return getCartCount() != 0 ;
    }
}
