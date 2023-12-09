import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NavigationTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Configuração do WebDriver usando a versão embutida no Codespaces
        driver = new ChromeDriver();
    }

    @Test
    void navigateToSheinAndPerformAssertions() {
        // Abre a página da SHEIN
        driver.get("https://www.shein.com/");

        // Verifica se o título da página é o esperado
        assertEquals("SHEIN - Fashion Women's Online Shopping", driver.getTitle(), "O título da página não é o esperado.");

        // Encontra um elemento na página (por exemplo, campo de pesquisa)
        WebElement searchInput = driver.findElement(By.id("searchInput"));

        // Insere texto no campo de pesquisa
        searchInput.sendKeys("dress");

        // Verifica se o texto inserido está correto
        assertEquals("dress", searchInput.getAttribute("value"), "O texto no campo de pesquisa não é o esperado.");

        // Encontra e clica em um botão (por exemplo, botão de pesquisa)
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();

        // Verifica se a página de resultados de pesquisa é exibida (exemplo de uso do assertTrue)
        assertTrue(driver.getCurrentUrl().contains("/search"), "A página de resultados de pesquisa não foi exibida.");

        // Exemplo de uso do assertFalse
        assertFalse(driver.getPageSource().contains("Error"), "A página contém um erro.");

        // Adicione mais verificações ou ações conforme necessário

        // Feche o navegador
        driver.quit();
    }
}
