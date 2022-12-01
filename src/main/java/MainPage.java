import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;
    private final By search = By.id("search");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void setWord(String searchText){
        WebElement wordSpace = driver.findElement(search);
        wordSpace.click();
        wordSpace.sendKeys(searchText);
    }

    public String getWord(){
        WebElement wordSpace = driver.findElement(search);
        return wordSpace.getAttribute("value");
    }

}
