package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;

public final class e {
    public static StringBuilder a(TimePoint timePoint) {
        AppMethodBeat.i(57041);
        StringBuilder stringBuilder = new StringBuilder();
        if (timePoint == null) {
            ab.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
            AppMethodBeat.o(57041);
            return stringBuilder;
        }
        stringBuilder.append(0).append(". ").append(timePoint.name).append(" : ");
        stringBuilder.append(timePoint.heM);
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.heL.get());
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.heM.get() - timePoint.heM.get());
        int i = 0;
        TimePoint timePoint2 = timePoint;
        while (timePoint2.heN.get() != null) {
            TimePoint timePoint3 = (TimePoint) timePoint2.heN.get();
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append(i + 1).append(". ").append(timePoint3.name).append(" : ");
            stringBuilder.append(((double) (timePoint3.heM.get() - timePoint2.heM.get())) / 1000000.0d);
            i++;
            timePoint2 = timePoint3;
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("total cost : ").append(((double) (timePoint2.heM.get() - timePoint.heM.get())) / 1000000.0d);
        AppMethodBeat.o(57041);
        return stringBuilder;
    }
}
