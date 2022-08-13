import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Log4j2
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var login = "ya.osipova.sis+1@gmail.com";
        var password = "Test1!test";
        String chromeDriverPath = "lib/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://otus.ru");
        driver.findElement(By.cssSelector("button.header2__auth")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var element = driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'email']"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'password']"));
        element.clear();
        element.sendKeys(password);

        driver.findElement(By.xpath("//form[@action = '/login/']//button[@type = 'submit']")).submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://otus.ru/lk/biography/personal/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        element = driver.findElement(By.id("id_fname"));
//        element.clear();
//        element.sendKeys("Тест");
//
//        element = driver.findElement(By.id("id_fname_latin"));
//        element.clear();
//        element.sendKeys("Тестов");
//
//        element = driver.findElement(By.id("id_lname"));
//        element.clear();
//        element.sendKeys("Test");
//
//        element = driver.findElement(By.id("id_lname_latin"));
//        element.clear();
//        element.sendKeys("Testov");
//
//        element = driver.findElement(By.id("id_blog_name"));
//        element.clear();
//        element.sendKeys("TestBlogov");
//
//        element = driver.findElement(By.xpath("//input[@name='date_of_birth']"));
//        element.clear();
//        element.sendKeys("02.02.2002");

        driver.findElement(By.xpath("//div[@data-slave-selector='.js-lk-cv-dependent-slave-city']")).click();
        driver.findElement(By.xpath("//button[@title='Украина']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(By.xpath("//div[@data-selected-option-class='lk-cv-block__select-option_selected']")).get(1).click();
        driver.findElement(By.xpath("//button[@title='Мариуполь']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
