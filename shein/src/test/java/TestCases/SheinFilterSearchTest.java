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
import org.openqa.selenium.support.ui.Select;

public class SheinFilterSearchTest {

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
    public void testFilterSearch() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Encontrar o elemento de pesquisa
        WebElement searchBox = driver.findElement(By.id("search-bar-input"));

        // Digitar o nome de uma categoria (por exemplo, "dress") na caixa de pesquisa
        searchBox.sendKeys("dress");

        // Submeter a pesquisa pressionando Enter
        searchBox.sendKeys(Keys.ENTER);

        // Verificar se a página de resultados de pesquisa é exibida
        assertTrue(driver.getTitle().contains("Dress"));

        // Encontrar o filtro de tamanho e selecionar um tamanho específico
        WebElement sizeFilter = driver.findElement(By.id("size-filter"));
        Select sizeDropdown = new Select(sizeFilter.findElement(By.tagName("select")));
        sizeDropdown.selectByIndex(1); // Supondo que o índice 1 corresponda ao tamanho "S"

        // Verificar se a página de resultados de pesquisa é atualizada após selecionar o tamanho
        assertTrue(driver.getTitle().contains("Size: S"));

        // Encontrar o filtro de cor e selecionar uma cor específica
        WebElement colorFilter = driver.findElement(By.id("color-filter"));
        colorFilter.findElement(By.cssSelector("[data-color='red']")).click(); // Supondo que haja uma opção de cor vermelha

        // Verificar se a página de resultados de pesquisa é atualizada após selecionar a cor
        assertTrue(driver.getTitle().contains("Color: Red"));

        // Encontrar o filtro de faixa de preço e definir um intervalo específico
        WebElement priceFilter = driver.findElement(By.id("price-filter"));
        WebElement minPriceInput = priceFilter.findElement(By.name("min-price"));
        WebElement maxPriceInput = priceFilter.findElement(By.name("max-price"));

        // Simular a entrada de valores de preço mínimo e máximo
        minPriceInput.clear();
        minPriceInput.sendKeys("20");

        maxPriceInput.clear();
        maxPriceInput.sendKeys("50");

        // Submeter o formulário de filtro de preço
        priceFilter.submit();

        // Verificar se a página de resultados de pesquisa é atualizada após aplicar o filtro de preço
        assertTrue(driver.getTitle().contains("$20 - $50"));

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
