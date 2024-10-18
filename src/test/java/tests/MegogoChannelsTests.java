package tests;

import annotations.Regression;
import api.client.MegogoApi;
import api.models.channel.Data;
import api.models.channel.Program;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;

import static assertions.CustomAssertions.assertThatElementsInListIsSorted;
import static assertions.CustomAssertions.assertThatValueEqualToValue;

@Regression
public class MegogoChannelsTests {
    private static final List<Integer> VIDEO_IDS = List.of(1639111, 1585681, 1639231);
    private Data channelData;
    private List<Program> programs;

    @BeforeEach
    public void setUp() {
        channelData = MegogoApi.getChannelProgramsScheduleByIds(VIDEO_IDS)
                .getData()
                .getFirst();
        programs = channelData.getPrograms();
    }

    @Test
    @DisplayName("Channel programs timestamp is sorted")
    public void testChanelProgramsTimestampSorted() {
        var tvShowScheduleStartTimes = channelData.getPrograms()
                .stream()
                .map(Program::getStartTimestamp)
                .toList();

        assertThatElementsInListIsSorted(tvShowScheduleStartTimes, Comparator.naturalOrder(), "TV show schedule times");
    }

    @Test
    @DisplayName("Current program exist")
    public void testCurrentTvProgramExist() {
        assertThatValueEqualToValue(isCurrentTvProgramExist(programs, Instant.now().getEpochSecond()), true, "Current program is exist");
    }

    @Test
    @DisplayName("No past programs")
    public void testNoTvProgramsInPast() {
        assertThatValueEqualToValue(hasNoPastPrograms(programs, Instant.now().getEpochSecond()), true, "Program schedule has no past programs");
    }

    @Test
    @DisplayName("No programs after 24 hours")
    public void testNoTvProgramsAfter24Hours() {
        assertThatValueEqualToValue(hasNoProgramsAfter24Hours(programs, Instant.now().getEpochSecond()), true, "Program schedule has no programs after 24 hours");
    }

    private boolean isCurrentTvProgramExist(List<Program> programs, long currentTimestamp) {
        return programs.stream().anyMatch(program ->
                currentTimestamp >= program.getStartTimestamp() && currentTimestamp <= program.getEndTimestamp()
        );
    }

    public boolean hasNoPastPrograms(List<Program> programs, long currentTimestamp) {
        return programs.stream().noneMatch(program -> program.getEndTimestamp() < currentTimestamp);
    }

    public boolean hasNoProgramsAfter24Hours(List<Program> programs, long currentTimestamp) {
        long twentyFourHoursAhead = currentTimestamp + 24 * 60 * 60;
        return programs.stream().noneMatch(program -> program.getStartTimestamp() > twentyFourHoursAhead);
    }
}
