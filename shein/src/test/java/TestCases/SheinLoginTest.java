package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SheinLoginTest {

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
    public void testLogin() {
        // Navegar para a página de login da SHEIN
        driver.get("https://www.shein.com/login");

        // Encontrar os elementos de entrada para o nome de usuário e senha
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Preencher o nome de usuário e senha
        usernameInput.sendKeys("seu_nome_de_usuario");
        passwordInput.sendKeys("sua_senha");

        // Submeter o formulário de login
        passwordInput.submit();

        // Aguardar um curto período para que o login seja processado
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar se o login foi bem-sucedido
        assertTrue(driver.getTitle().contains("Minha Conta")); // Substitua "Minha Conta" pelo título esperado após o login

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
