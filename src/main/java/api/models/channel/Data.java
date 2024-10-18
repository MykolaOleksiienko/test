package api.models.channel;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    @SerializedName("id")
    private long id;

    @SerializedName("external_id")
    private long externalId;

    @SerializedName("title")
    private String title;

    @SerializedName("pictures")
    private Pictures pictures;

    @SerializedName("video_id")
    private long videoId;

    @SerializedName("programs")
    private List<Program> programs;
}
