package com.tencent.p177mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.collector.e */
public final class C2109e {
    /* renamed from: a */
    public static StringBuilder m4326a(TimePoint timePoint) {
        AppMethodBeat.m2504i(57041);
        StringBuilder stringBuilder = new StringBuilder();
        if (timePoint == null) {
            C4990ab.m7416i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
            AppMethodBeat.m2505o(57041);
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
        AppMethodBeat.m2505o(57041);
        return stringBuilder;
    }
}
