
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryFormTest {

    LocalDate date = LocalDate.now();
    LocalDate threeDate = date.plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys("Майкоп");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(formatter.format(threeDate));
        $("[name='name']").sendKeys("Женя");
        $("[name='phone']").sendKeys("+79200000000");
        $("[class='checkbox__box']").click();
        $(byText("Забронировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));
    }
}
