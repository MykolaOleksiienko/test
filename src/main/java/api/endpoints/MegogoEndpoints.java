package api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MegogoEndpoints {
    BASE_URL("https://epg.megogo.net/"),
    CURRENT_TIME(BASE_URL.getValue().concat("time")),
    CHANNEL(BASE_URL.getValue().concat("channel"));

    private final String value;
}
