package api.client;

import api.endpoints.MegogoEndpoints;
import api.models.channel.ChannelResponse;
import api.models.time.CurrentTimeResponse;
import io.qameta.allure.Step;

import java.util.List;

import static api.endpoints.MegogoEndpoints.CHANNEL;
import static api.endpoints.MegogoEndpoints.CURRENT_TIME;
import static api.helpers.RestAssuredHelper.initGetRequest;
import static api.helpers.RestAssuredHelper.initGetRequestWithQueryParams;

public class MegogoApi {
    private static final String VIDEO_IDS_QUERY_PARAM = "video_ids";

    @Step("Get current time from server")
    public static CurrentTimeResponse getCurrentTimeFromServer() {
        return initGetRequest(CURRENT_TIME, CurrentTimeResponse.class);
    }

    @Step("Get channel programs schedule by ids {0}")
    public static ChannelResponse getChannelProgramsScheduleByIds(List<Integer> ids) {
        return initGetRequestWithQueryParams(CHANNEL, ChannelResponse.class, VIDEO_IDS_QUERY_PARAM, ids.toArray());
    }
}
