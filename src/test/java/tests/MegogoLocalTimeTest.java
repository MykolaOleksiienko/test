package tests;

import annotations.Regression;
import api.client.MegogoApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static assertions.CustomAssertions.assertThatValueEqualToValue;

@Regression
public class MegogoLocalTimeTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy hh:mm:ss a XXX", Locale.ENGLISH);

    @Test
    @DisplayName("Time test")
    public void testTime() {
        var data = MegogoApi.getCurrentTimeFromServer().getData();
        Assertions.assertAll(
                () -> assertThatValueEqualToValue(data.getTimestampLocal(), Instant.now().plusSeconds(data.getUtcOffset()).getEpochSecond(),"Local server timestamp"),
                () -> assertThatValueEqualToValue(data.getTimestamp(), Instant.now().getEpochSecond(),"Local timestamp"),
                () -> assertThatValueEqualToValue(data.getTimezone(), ZoneId.systemDefault().getId(), "Local Timezone"),
                () -> assertThatValueEqualToValue(data.getTimestampGmt(), Instant.now().getEpochSecond(), "GMT timestamp"),
                () -> assertThatValueEqualToValue(data.getTimeLocal(), ZonedDateTime.now().format(formatter), "Time local")
        );
    }
}
