import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Add_Product_To_Cart extends  BaseTest{
    String product[];
   ProductDetailPage productDetailPage;

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
        HomePage homePage = new HomePage(driver);
        homePage.clickButton();
        Thread.sleep(500);
    }

    @Test
    @Order(6)
    public void goToProduct() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        product = productPage.selectProduct();
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
        System.out.println(cartPage.checkProduct(product));
    }

    @Test
    @Order(9)
    public void checkPrice(){
        CartPage cartPage = new CartPage(driver);
        System.out.println(cartPage.checkPrice());
    }

    @Test
    @Order(10)
    public void continueBuy(){
        CartPage cartPage = new CartPage(driver);
        cartPage.continueBuy();
    }



}
