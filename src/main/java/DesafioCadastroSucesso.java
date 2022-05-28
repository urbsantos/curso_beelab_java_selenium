//Preencher Nome, Sobrenome, sexo, comida, escoladirade, esportes, clicar em cadastrar e verificar
//o cadastro com sucesso

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastroSucesso {

    @Test
    public void deveRealizarCadastroComSucesso(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Urbano");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

        WebElement elementCombo = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(elementCombo);
        combo.selectByVisibleText("Mestrado");
        //Simplificando para uma linha
        //new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");

        WebElement elementComboMultiplo = driver.findElement(By.id("elementosForm:esportes"));
        Select comboMultiplo = new Select(elementComboMultiplo);
        comboMultiplo.selectByVisibleText("Corrida");
        //Simplificando para uma linha
        //new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Mestrado");

        driver.findElement(By.id("elementosForm:cadastrar")).click();

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Urbano"));
        Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Santos"));
        Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
        Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
        Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("mestrado"));
        Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Corrida"));

    }

    @Test
    public void deveValidarNomeObrigatorio(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());

        driver.quit();
    }

    @Test
    public void deveValidarSobrenomeObrigatorio(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Urbano");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());

        driver.quit();
    }

    @Test
    public void deveValidarSexoObrigatorio(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Urbano");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());

        driver.quit();
    }

    @Test
    public void deveValidarComidaVegetariana(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Urbano");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

        driver.quit();
    }

    @Test
    public void deveValidarEsportistaIndeciso(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Urbano");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());

        driver.quit();
    }



}
