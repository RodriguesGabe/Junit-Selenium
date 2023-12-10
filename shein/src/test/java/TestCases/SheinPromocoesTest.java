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

public class SheinPromocoesTest {

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
    public void testPromocoes() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Encontrar um elemento que representa promoções (por exemplo, uma seção de ofertas especiais)
        WebElement promotionsSection = driver.findElement(By.cssSelector(".promotions"));

        // Verificar se a seção de promoções está presente na página
        assertTrue(promotionsSection.isDisplayed());

        // Realizar verificações adicionais, como a presença de produtos em promoção
        // Você pode usar métodos adicionais do Selenium para encontrar elementos e verificar suas propriedades

        // Exemplo: Verificar se há pelo menos um produto em promoção
        WebElement productOnPromotion = driver.findElement(By.cssSelector(".product-on-promotion"));
        assertTrue(productOnPromotion.isDisplayed());

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
