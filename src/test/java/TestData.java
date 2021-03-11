import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestData {

    public static String setDate(long plusDay) {
        String date = LocalDate
                .now()
                .plusDays(plusDay)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return date;
    }


}
