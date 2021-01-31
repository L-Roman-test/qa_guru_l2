package Settings;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    public static void config() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/");
    }

    @AfterAll
    public static void closeDriver() {
        closeWebDriver();
    }
}
