import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Test_Search extends BaseTest{


    @Test
    public void setSearch(){
        mainPage.setWord("ceket");
        Assertions.assertEquals("ceket",mainPage.getWord(),"Arama sözcüğü doğru değil!");

    }




}
