package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SheinCadastroTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        // Configurar o WebDriver (ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "Junit-Selenium/shein/chromedriver");

        // Configurar as opções do Chrome (opcional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Executar em modo headless (sem interface gráfica)

        // Inicializar o WebDriver do Chrome
        driver = new ChromeDriver(options);
    }

    @Test
    public void testCadastro() {
        // Navegar para a página de cadastro da SHEIN
        driver.get("https://www.shein.com/register");

        // Encontrar os elementos de entrada para o nome, e-mail e senha
        WebElement nameInput = driver.findElement(By.id("register-fullname"));
        WebElement emailInput = driver.findElement(By.id("register-email"));
        WebElement passwordInput = driver.findElement(By.id("register-password"));

        // Preencher os campos de cadastro
        nameInput.sendKeys("Seu Nome");
        emailInput.sendKeys("seu_email@example.com");
        passwordInput.sendKeys("sua_senha");

        // Submeter o formulário de cadastro
        passwordInput.submit();

        // Aguardar um curto período para que o cadastro seja processado
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar se o cadastro foi bem-sucedido
        assertTrue(driver.getTitle().contains("Minha Conta")); // Substitua "Minha Conta" pelo título esperado após o cadastro

        // Realizar verificações adicionais conforme necessário
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após o teste
        if (driver != null) {
            driver.quit();
        }
    }
}
