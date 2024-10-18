package api.models.channel;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Program {
    @SerializedName("external_id")
    private long externalId;

    @SerializedName("title")
    private String title;

    @SerializedName("category")
    private Category category;

    @SerializedName("pictures")
    private Pictures pictures;

    @SerializedName("start_timestamp")
    private long startTimestamp;

    @SerializedName("end_timestamp")
    private long endTimestamp;

    @SerializedName("id")
    private long id;

    @SerializedName("start")
    private String start;

    @SerializedName("end")
    private String end;

    @SerializedName("virtual_object_id")
    private String virtualObjectId;

    @SerializedName("schedule_type")
    private String scheduleType;
}
