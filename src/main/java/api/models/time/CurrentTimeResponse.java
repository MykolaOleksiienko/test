package api.models.time;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CurrentTimeResponse {
    @SerializedName("result")
    private String result;

    @SerializedName("data")
    private Data data;

    @lombok.Data
    public static class Data {
        @SerializedName("utc_offset")
        private int utcOffset;

        @SerializedName("timestamp_gmt")
        private long timestampGmt;

        @SerializedName("timestamp_local")
        private long timestampLocal;

        @SerializedName("timezone")
        private String timezone;

        @SerializedName("timestamp")
        private long timestamp;

        @SerializedName("time_local")
        private String timeLocal;
    }
}
