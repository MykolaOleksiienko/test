package api.models.channel;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChannelResponse {
    @SerializedName("result")
    private String result;

    @SerializedName("data")
    private List<Data> data;
}
