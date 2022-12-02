import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    By productSizeLocator = new By.ByCssSelector("span.cartItem__attrValue");
    By oldPriceLocator = new By.ByCssSelector("span.cartItem__price.-old.-labelPrice");
    By actualPriceLocator = new By.ByCssSelector("span.cartItem__price.-sale");
    By continueButtonLocator = new By.ByCssSelector("button.continueButton.n-button.large.block.text-center.-primary");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public boolean checkProduct(String[] product){
        String cartPageProduct[] = {
                find(actualPriceLocator).getText(),
                find(oldPriceLocator).getText(),
                find(productSizeLocator).getText()
        };
        for(int i=0;i<3;i++){
            if(cartPageProduct[i].equals(product[i])){
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean checkPrice(){
        int oldPrice = convertPriceToInt(find(oldPriceLocator).getText());
        int actualPrice = convertPriceToInt(find(actualPriceLocator).getText());
        if(oldPrice > actualPrice){
            return true;
        }
        else {
            return false;
        }
    }

    public void continueBuy(){
        click(continueButtonLocator);
    }


}
