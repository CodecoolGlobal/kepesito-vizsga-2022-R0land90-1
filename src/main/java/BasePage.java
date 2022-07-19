import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    static WebDriver driver;

    public By popUpClose = By.id("at-cv-lightbox-close");

    public BasePage(WebDriver drv) {
        driver = drv;
    }


}
