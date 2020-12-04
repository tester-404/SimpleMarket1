import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class YandexTZ {
    String SITE_URL = "https://market.yandex.ru/";
    WebDriver driver;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void finish() {
         driver.quit();
    }

    @Test
    public void firstTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_URL);
        driver.findElement(By.xpath("//span[.='Электроника']")).click();
        System.out.println(" ----- > Electronika is OK!");

        try {
            driver.findElement(By.linkText("Телевизоры")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Телевизоры")));
        }
        System.out.println(" ----- > ТV-sets is OK!");
        driver.findElement(By.id("glpriceto")).sendKeys("50000");
        System.out.println(" ----- > 50 000 is OK!");

        driver.findElement(By.xpath("//span[.='32\"-39\"']")).click();
        System.out.println(" ----- > 32\"-39\" is OK!");

        System.out.println(" ----- > ADD TO COMPARE . . .");

        try {
            driver.findElement(By.className("_1CXljk9rtd")).click();
          //  driver.findElement(By.className("_1CXljk9rtd")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.className("_1CXljk9rtd")));
        }

        try {
            driver.findElement(By.xpath("//article[2]/div[2]/div[1]/div")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//article[2]/div[2]/div[1]/div")));
             }

        try {
                driver.findElement(By.xpath("//article[3]/div[2]/div[1]/div")).click();
            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//article[3]/div[2]/div[1]/div")));
            }

        try {
            driver.findElement(By.xpath("//article[4]/div[2]/div[1]/div")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//article[4]/div[2]/div[1]/div")));
        }

        try {
            driver.findElement(By.xpath("//article[5]/div[2]/div[1]/div")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//article[5]/div[2]/div[1]/div")));
        }

        try {
            driver.findElement(By.linkText("Сравнить")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Сравнить")));
        }

    }

}
