package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private WebDriver driver;
    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicacao() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/");
    }
    @Quando("informo o usuário {string}")
    public void informoOUsuario(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }
    @Quando("a senha {string}")
    public void aSenha(String senha) {
        driver.findElement(By.id("senha")).sendKeys(senha);
    }
    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Entao("visualizo a página inicial")
    public void visualizoAPaginaInicial() {
        String texto =  driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Mteste!", texto);
    }
    @Quando("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }
    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }
    @Quando("informo a conta {string}")
    public void informoAConta(String conta) {
        driver.findElement(By.id("nome")).sendKeys(conta);
    }
    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Entao("a conta é inserida com sucesso")
    public void aContaEInseridaComSucesso() {
        String texto =  driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
    @Entao("sou notificar que o nome da conta é obrigatório")
    public void souNotificarQueONomeDaContaEObrigatorio() {
        String texto =  driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Informe o nome da conta", texto);
    }

    @Entao("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJaExisteUmaContaComEsseNome() {
        String texto =  driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
    }

//    // testando allure report
//    @Entao("teste")
//    @Attachment
//    public String teste() {
//        return "Missio";
//    }




    @After
    public void fechandoOBrowser(){
        driver.quit();
    }
}
