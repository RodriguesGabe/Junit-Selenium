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

public class SheinProductDetailsTest {

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
    public void testProductDetails() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Encontrar o elemento de pesquisa
        WebElement searchBox = driver.findElement(By.id("search-bar-input"));

        // Digitar o nome de um produto (por exemplo, "dress") na caixa de pesquisa
        searchBox.sendKeys("dress");

        // Submeter a pesquisa pressionando Enter
        searchBox.submit();

        // Encontrar um produto na lista de resultados e clicar nele para visualizar os detalhes
        WebElement product = driver.findElement(By.cssSelector(".product-list-item"));
        product.click();

        // Verificar se a página de detalhes do produto é exibida
        assertTrue(driver.getTitle().contains("Product Details"));

        // Capturar informações detalhadas do produto
        WebElement productName = driver.findElement(By.cssSelector(".product-title"));
        WebElement productPrice = driver.findElement(By.cssSelector(".product-price"));
        WebElement productDescription = driver.findElement(By.cssSelector(".product-description"));
        WebElement productReviews = driver.findElement(By.cssSelector(".product-reviews"));

        // Verificar se as informações são exibidas corretamente
        assertTrue(productName.isDisplayed());
        assertTrue(productPrice.isDisplayed());
        assertTrue(productDescription.isDisplayed());
        assertTrue(productReviews.isDisplayed());

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
