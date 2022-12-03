import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Add_Product_To_Cart extends  BaseTest{
    String product[];
    int selectRow = 1;

    @Test
    @Order(1)
    public void acceptCookies() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        Thread.sleep(500);
    }

    @Test
    @Order(2)
    public void searchProduct() throws InterruptedException {
        SearchBox searchBox = new SearchBox(driver);
        searchBox.setWord("ceket");
        Assertions.assertEquals("ceket", searchBox.getWord(),"Arama sözcüğü doğru değil!");
        Thread.sleep(500);

    }

    @Test
    @Order(3)
    public void searchAfterWord() throws InterruptedException {
        SearchBox searchBox = new SearchBox(driver);
        searchBox.searchWord();
        Thread.sleep(500);
    }

    @Test
    @Order(4)
    public void scrollToBottom() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.scrollTo();
        Thread.sleep(500);
    }

    @Test
    @Order(5)
    public void showMore() throws InterruptedException {
        String old_url = driver.getCurrentUrl();
        HomePage homePage = new HomePage(driver);
        homePage.clickButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("page=2"));
        boolean isPageChanged = old_url.equals(driver.getCurrentUrl());
        Assertions.assertFalse(isPageChanged,"Page not changed!");
        Thread.sleep(500);
    }

    @Test
    @Order(6)
    public void goToProduct() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        product = productPage.selectProduct();
        Assertions.assertTrue(productPage.isOnProductPage(),"Products not yet ready!");
        Thread.sleep(500);
    }

    @Test
    @Order(7)
    public void goToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.goToCart();
        Thread.sleep(500);
    }

    @Test
    @Order(8)
    public void checkProducts(){
        CartPage cartPage = new CartPage(driver);
        boolean isTrue = cartPage.checkProduct(product);
        Assertions.assertTrue(isTrue, "Product informations different");
    }

    @Test
    @Order(9)
    public void checkPrice(){
        CartPage cartPage = new CartPage(driver);
        boolean isTrue = cartPage.checkPrice();
        Assertions.assertTrue(isTrue, "Old price would be bigger actual price");
    }

    @Test
    @Order(10)
    public void continueBuy(){
        CartPage cartPage = new CartPage(driver);
        cartPage.continueBuy();
    }



    @Test
    @Order(11)
    public void fillMail(){
        LoginPage loginPage = new LoginPage(driver);
        String eMail = loginPage.setEmailField(selectRow);
        Assertions.assertEquals(eMail, loginPage.checkEmailField(),"eMail Wrong!");
    }

    @Test
    @Order(12)
    public void fillPassword(){
        LoginPage loginPage = new LoginPage(driver);
        String password = loginPage.setPasswordField(selectRow);
        Assertions.assertEquals(password, loginPage.checkPasswordField(),"Password Wrong!");
        Assertions.assertTrue(loginPage.isButtonOnPage(),"Button not yet here!");
    }

    @Test
    @Order(13)
    public void clickLogo() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogo();
        Thread.sleep(500);
    }

    @Test
    @Order(14)
    public void clickCartButton() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCartButton();
        Thread.sleep(500);
    }

    @Test
    @Order(15)
    public void deleteFromCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.deleteFromCart();
        Thread.sleep(500);
    }

    @Test
    @Order(16)
    public void sureDelete() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.sureDelete();
        Assertions.assertTrue(homePage.isProductCountZero(),"Product count did not increase!");
        Thread.sleep(500);
    }


}
