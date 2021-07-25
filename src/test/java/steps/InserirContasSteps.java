package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/");
    }
    @Quando("informo o usuário {string}")
    public void informo_o_usuário(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }
    @Quando("a senha {string}")
    public void a_senha(String senha) {
      driver.findElement(By.id("senha")).sendKeys(senha);
    }
    @Quando("seleciono entrar")
    public void seleciono_entrar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Então("visualizo a página inicial")
    public void visualizo_a_página_inicial() {
       String texto =  driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Rafael!", texto);

    }
    @Quando("seleciono Contas")
    public void seleciono_contas() {
        driver.findElement(By.linkText("Contas")).click();
    }
    @Quando("seleciono Adicionar")
    public void seleciono_adicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }
    @Quando("informo a conta {string}")
    public void informo_a_conta(String conta) {
        driver.findElement(By.id("nome")).sendKeys(conta);
    }
    @Quando("seleciono Salvar")
    public void seleciono_salvar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Então("a conta é inserida com sucesso")
    public void a_conta_é_inserida_com_sucesso() {
        String texto =  driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
}
