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

public class SheinAddToCartTest {

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
    public void testAddToCart() {
        // Navegar para a página inicial da SHEIN
        driver.get("https://www.shein.com/");

        // Encontrar o elemento de pesquisa
        WebElement searchBox = driver.findElement(By.id("search-bar-input"));

        // Digitar o nome de um produto (por exemplo, "blouse") na caixa de pesquisa
        searchBox.sendKeys("blouse");

        // Submeter a pesquisa pressionando Enter
        searchBox.sendKeys(Keys.ENTER);

        // Encontrar um produto na lista de resultados e clicar nele para visualizar os detalhes
        WebElement product = driver.findElement(By.cssSelector(".product-list-item"));
        product.click();

        // Verificar se a página de detalhes do produto é exibida
        assertTrue(driver.getTitle().contains("Product Details"));

        // Encontrar o botão "Adicionar ao Carrinho" e clicar nele
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Aguardar um curto período para que o item seja adicionado ao carrinho
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Navegar para a página de carrinho
        driver.get("https://www.shein.com/cart");

        // Verificar se o produto adicionado está presente no carrinho
        WebElement cartProduct = driver.findElement(By.cssSelector(".cart-item-title"));
        assertTrue(cartProduct.getText().contains("Blouse")); // Substitua "Blouse" pelo nome real do produto

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
