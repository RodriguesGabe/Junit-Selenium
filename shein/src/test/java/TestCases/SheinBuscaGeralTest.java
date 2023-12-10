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

public class SheinBuscaGeralTest {

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
    public void testBuscaGeral() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Encontrar o elemento de pesquisa
        WebElement searchBox = driver.findElement(By.id("search-bar-input"));

        // Digitar um termo de pesquisa geral (por exemplo, "moda") na caixa de pesquisa
        searchBox.sendKeys("moda");

        // Submeter a pesquisa pressionando Enter
        searchBox.sendKeys(Keys.ENTER);

        // Verificar se a página de resultados de pesquisa é exibida corretamente
        assertTrue(driver.getTitle().contains("Moda"));

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
