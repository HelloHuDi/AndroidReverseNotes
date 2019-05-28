package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class Reporters {
    static /* synthetic */ void access$000(List list, StringBuilder stringBuilder, long j) {
        AppMethodBeat.i(128435);
        generateDetailedPerformance(list, stringBuilder, j);
        AppMethodBeat.o(128435);
    }

    public static Visitor detail(final AudioInformation audioInformation, final Map<String, String> map) {
        AppMethodBeat.i(128433);
        AnonymousClass1 anonymousClass1 = new Visitor() {
            public final void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo) {
                int i = 1;
                AppMethodBeat.i(128432);
                long round = Math.round(((double) overallInfo.totalPcmToBePlayed) / ((double) overallInfo.timeCostInMs));
                long playSample = audioInformation.getPlaySample() * ((long) audioInformation.getChannels());
                if (audioInformation.getBitDept() != 1) {
                    i = 2;
                }
                double d = ((double) (((long) i) * playSample)) / 1000.0d;
                double d2 = ((double) round) / d;
                StringBuilder stringBuilder = new StringBuilder("\n============== Info start ==============\n");
                stringBuilder.append("媒体文件信息:\n");
                stringBuilder.append("\t播放时间: ").append(new Date().toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t音频类型: ").append(audioInformation.getAudioType().toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t文件采样率: ").append(audioInformation.getSampleRate()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t播放采样率: ").append(audioInformation.getPlaySample()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t位深: ").append(audioInformation.getBitDept()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t声道数: ").append(audioInformation.getChannels()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t时长: ").append(audioInformation.getDuration()).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\n整体性能\n");
                stringBuilder.append("\t总耗时 (ms): ").append(overallInfo.timeCostInMs).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t播放PCM数据量 (byte): ").append(overallInfo.totalPcmToBePlayed).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\t总速度 (byte/ms): ").append(round).append(" (").append(Math.round(d2)).append(" 倍于最低要求速度)\n");
                stringBuilder.append("\t最低要求速度 (byte/ms): ").append(d).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("\n额外信息:");
                for (Entry entry : map.entrySet()) {
                    stringBuilder.append("\n\t").append((String) entry.getKey()).append(": ").append((String) entry.getValue());
                }
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                Reporters.access$000(list, stringBuilder, overallInfo.timeCostInMs);
                stringBuilder.append("============== Info end ==============");
                Logger.i("PERFORMANCE", stringBuilder.toString());
                AppMethodBeat.o(128432);
            }
        };
        AppMethodBeat.o(128433);
        return anonymousClass1;
    }

    private static void generateDetailedPerformance(List<SpeedCheck> list, StringBuilder stringBuilder, long j) {
        AppMethodBeat.i(128434);
        stringBuilder.append("\n详细性能数据:\n");
        stringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", new Object[]{"名称", "平均速度(byte/ms)", "耗时(ms)", "数据量(byte)", "占总耗时比"}));
        for (SpeedCheck speedCheck : list) {
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15.0f%15d%15d%13.2f", new Object[]{speedCheck.getName(), Double.valueOf(speedCheck.getAvg()), Long.valueOf(speedCheck.getTotalTimeMs()), Long.valueOf(speedCheck.getTotalBufferLength()), Double.valueOf(((double) speedCheck.getTotalTimeMs()) / ((double) j))}));
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        AppMethodBeat.o(128434);
    }
}
