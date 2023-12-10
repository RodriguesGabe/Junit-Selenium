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

public class SheinCategorySearchTest {

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
    public void testCategorySearch() {
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

        // Encontrar o filtro de categoria no lado esquerdo e selecionar a categoria específica (por exemplo, "Dresses")
        WebElement categoryFilter = driver.findElement(By.id("left-navigation"));
        Select categoryDropdown = new Select(categoryFilter.findElement(By.tagName("select")));
        categoryDropdown.selectByIndex(1); // Supondo que o índice 1 corresponda a "Dresses"

        // Verificar se a página de resultados de pesquisa é atualizada após selecionar a categoria
        assertTrue(driver.getTitle().contains("Dresses"));

        // Encontrar um produto na lista de resultados e clicar nele para visualizar os detalhes
        WebElement product = driver.findElement(By.cssSelector(".product-list-item"));
        product.click();

        // Verificar se a página de detalhes do produto é exibida
        assertTrue(driver.getTitle().contains("Product Details"));

        // Simular uma ação de "adicionar ao carrinho"
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Verificar se o produto foi adicionado ao carrinho
        assertTrue(driver.getTitle().contains("Shopping Cart"));

        // Realizar uma verificação adicional, por exemplo, se há um ícone de carrinho na barra de navegação
        assertTrue(driver.findElement(By.id("cart-icon")).isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após o teste
        if (driver != null) {
            driver.quit();
        }
    }
}
