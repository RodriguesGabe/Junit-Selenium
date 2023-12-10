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

public class SheinShareRedesSociaisTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        // Configurar o WebDriver (ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "Junit-Selenium/shein/chromedrive");

        // Configurar as opções do Chrome (opcional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Executar em modo headless (sem interface gráfica)

        // Inicializar o WebDriver do Chrome
        driver = new ChromeDriver(options);
    }

    @Test
    public void testCompartilhamentoRedesSociais() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Encontrar um produto específico na página inicial
        WebElement productToShare = driver.findElement(By.cssSelector(".featured-product"));

        // Encontrar o botão de compartilhamento para redes sociais (por exemplo, Facebook)
        WebElement shareOnFacebookButton = productToShare.findElement(By.cssSelector(".facebook-share-button"));
        shareOnFacebookButton.click();

        // Verificar se a janela de compartilhamento do Facebook é aberta
        assertTrue(driver.getTitle().contains("Facebook"));

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
