
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryFormTest {

   String date = TestData.setDate(7);

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys("Майкоп");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(date);
        $("[name='name']").sendKeys("Женя");
        $("[name='phone']").sendKeys("+79200000000");
        $("[class='checkbox__box']").click();
        $(byText("Забронировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));
        $("[data-test-id=notification] .notification__content").shouldHave(text(date));

    }
}
