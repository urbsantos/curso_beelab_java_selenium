import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestGoogle {

    private WebDriver driver;
    @Before
    public void inicializa(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @After
    public void finaliza(){
        driver.quit();
    }
    @Test
    public void test() {
        Assert.assertEquals("Google", driver.getTitle());
    }
}
