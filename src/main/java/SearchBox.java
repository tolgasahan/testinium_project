import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SearchBox extends BasePage{
    By searchFieldLocator = By.id("search");

    public SearchBox(WebDriver driver){
        super(driver);
    }

    public void setWord(String searchText){
        type(searchFieldLocator,searchText);
    }

    public String getWord(){
        return find(searchFieldLocator).getAttribute("value");
    }

    public void searchWord(){
        typeEnter(searchFieldLocator);
    }


}
