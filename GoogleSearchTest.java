package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Configurar la ubicación del driver de chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bryan.pereyra\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Inicializar el navegador
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch() throws InterruptedException {
        // Navegar al sitio
        driver.get("https://www.google.com.mx/?hl=es");

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Steps
        //driver.findElement(By.name("q")).sendKeys("Apple");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Apple");
        searchBar.submit();

        // Esperar a que carguen los resultados
        Thread.sleep(2000);

        // Validar que se muestran resultados
        List<WebElement> results = driver.findElements(By.cssSelector("div.g"));
        Assert.assertTrue(results.size() > 0, "No se encontraron resultados");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
