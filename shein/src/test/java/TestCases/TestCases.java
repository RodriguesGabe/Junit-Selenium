package TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCases {

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
    public void testNavegarPaginaInicial() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Verificar se a página inicial é exibida corretamente
        assertEquals("12.12 Sale 2023 | Moda feminina | Roupas, Acessórios e muitos mais | SHEIN Brasil", driver.getTitle());
    }

    // Adicione métodos de teste adicionais conforme necessário

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após cada teste
        if (driver != null) {
            driver.quit();
        }
    }
}
