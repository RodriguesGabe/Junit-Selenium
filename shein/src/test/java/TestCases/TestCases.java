package TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCases {

     @BeforeEach
    public void setup() {
      // Abrir o navegador
      WebDriver driver = new ChromeDriver();

      // Navegar para a página de teste
      driver.get("https://www.shein.com/");
    }
     
     @Test
     public void testNavegarPaginaInicial() {
       // Abrir o navegador
       WebDriver driver = new ChromeDriver();

       // Navegar para a página inicial da SHEIN
       driver.get("https://www.shein.com/");

       // Verificar se a página inicial é exibida
       assertEquals("12.12 Sale 2023 | Moda feminina | Roupas, Acessórios e muitos mais | SHEIN Brasil", driver.getTitle());
     }
     
}    