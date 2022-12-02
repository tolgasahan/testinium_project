import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends  BasePage{

    By cookiesLocator = By.id("onetrust-accept-btn-handler");
    By showAllButtonLocator = new By.ByCssSelector("button.button.-secondary.-sm.relative");
    By goToCartButtonLocator = new By.ByCssSelector("a.button.-primary.header__basket--checkout.header__basketModal.-checkout");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies(){
        click(cookiesLocator);
    }

    public void scrollTo(){
        scroll(showAllButtonLocator);
    }

    public void clickButton(){
        click(showAllButtonLocator);
    }

    public void goToCart(){click(goToCartButtonLocator);}
}
