package api.models.channel;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pictures {
    @SerializedName("original")
    private String original;

    @SerializedName("105x85")
    private String size105x85;

    @SerializedName("180x180")
    private String size180x180;

    @SerializedName("980x560")
    private String size980x560;

    @SerializedName("88x65")
    private String size88x65;

    @SerializedName("88x88")
    private String size88x88;

    @SerializedName("105x105")
    private String size105x105;

    @SerializedName("40x40")
    private String size40x40;

    @SerializedName("150x150")
    private String size150x150;

    @SerializedName("1600x520")
    private String size1600x520;
}
