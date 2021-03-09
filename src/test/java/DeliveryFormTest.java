
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryFormTest {

    LocalDate date = LocalDate.now();
    LocalDate threeDays = date.plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys("Майкоп");
        $("[placeholder='Город']").sendKeys(Keys.COMMAND + "a");
        $("[placeholder='Город']").sendKeys(Keys.DELETE);
        $("[placeholder='Город']").sendKeys("Казань");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(formatter.format(threeDays));
        $("[name='name']").sendKeys("Женя");
        $("[name='phone']").sendKeys("+79200000000");
        $("[class='checkbox__box']").click();
        $(byText("Забронировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));
    }
}
