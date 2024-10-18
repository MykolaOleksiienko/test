package api.models.channel;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    @SerializedName("id")
    private long id;

    @SerializedName("external_id")
    private long externalId;

    @SerializedName("title")
    private String title;
}
