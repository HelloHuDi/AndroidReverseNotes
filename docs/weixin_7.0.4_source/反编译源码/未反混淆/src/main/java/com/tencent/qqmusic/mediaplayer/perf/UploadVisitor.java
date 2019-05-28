package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class UploadVisitor implements Collectable, Visitor {
    private HashMap<String, Long> prefInfos = new HashMap();

    public UploadVisitor() {
        AppMethodBeat.i(128428);
        AppMethodBeat.o(128428);
    }

    public void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo) {
        AppMethodBeat.i(128429);
        for (SpeedCheck speedCheck : list) {
            this.prefInfos.put(speedCheck.getName() + ".ms", Long.valueOf(speedCheck.getTotalTimeMs()));
            this.prefInfos.put(speedCheck.getName() + ".bytes", Long.valueOf(speedCheck.getTotalBufferLength()));
        }
        AppMethodBeat.o(128429);
    }

    public void accept(PlayerInfoCollector playerInfoCollector) {
        AppMethodBeat.i(128430);
        if (!this.prefInfos.entrySet().isEmpty()) {
            for (Entry entry : this.prefInfos.entrySet()) {
                playerInfoCollector.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
        }
        AppMethodBeat.o(128430);
    }

    public void accept(ErrorUploadCollector errorUploadCollector) {
    }
}
