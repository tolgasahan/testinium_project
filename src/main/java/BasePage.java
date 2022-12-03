import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class BasePage{
    SearchBox searchBox;
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }
    public void typeEnter(By locator){
        find(locator).sendKeys(Keys.ENTER);
    }
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void scroll(By locator){
        WebElement element = find(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollWithElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public WebElement controlElement(By locator,List<WebElement> listElement){
        int i;
        for (i = 0; i<listElement.size();i++){
            try {
                listElement.get(i).findElement(locator);
                break;
            }
            catch (NoSuchElementException e){

            }
        }
        return listElement.get(i);
    }
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public WebElement controlButtonEnabled(By locator,List<WebElement> listElement){
        int i;
        for (i =0; i<listElement.size();i++){
                if(listElement.get(i).findElement(locator).isEnabled() == true){
                    break;
                }
        }
        return listElement.get(i);
    }

    public int convertPriceToInt(String priceText){
        priceText = priceText.replace(",00 TL", "");
        priceText = priceText.replace(".", "");
        return Integer.parseInt(priceText);
    }

    public String readCSV(int row, int column){
        CSVReader csvReader = null;

        try {
            csvReader = new CSVReader(new FileReader("data/users.csv"));
            String[] nextLine;
            int i = 0;
            while ((nextLine = csvReader.readNext()) != null) {
                if(i == row){
                    return nextLine[column];
                }
                i++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
