import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class LoginPage extends BasePage{

    By emailFieldLocator = By.id("n-input-email");
    By passwordFieldLocator = By.id("n-input-password");
    By loginButtonLocator = new By.ByCssSelector("button.n-button.large.block.text-center.-primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String setEmailField(int row){
        type(emailFieldLocator,readCSV(row,0));
        return readCSV(row,0);
    }
    public String checkEmailField(){
        return find(emailFieldLocator).getAttribute("value");
    }

    public String setPasswordField(int row){
        type(passwordFieldLocator,readCSV(row,1));
        return readCSV(row,1);
    }


    public String checkPasswordField(){
        return find(passwordFieldLocator).getAttribute("value");
    }


    public boolean isButtonOnPage(){
        return isDisplayed(loginButtonLocator);
    }



}
