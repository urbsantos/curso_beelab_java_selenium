import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escreve(String id, String texto){
        driver.findElement(By.id(id)).sendKeys(texto);
    }

    public String obterValorCampo(String id){
        return driver.findElement(By.id(id)).getAttribute("value");
    }

    public void clicarRadio(String id){
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    public void clicarCheckbox(String id){
        driver.findElement(By.id(id)).click();
    }

    public boolean isCheckboxMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valorSelecionado){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valorSelecionado);
    }

    public String obterValorCombo(String id){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBotao(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clicarLink(String link){
        driver.findElement(By.linkText(link)).click();
    }

    public String obterTexto(By by){
        return driver.findElement(by).getText();
    }

    public String obterTexto(String id){
        return obterTexto(By.id(id));
    }

}
