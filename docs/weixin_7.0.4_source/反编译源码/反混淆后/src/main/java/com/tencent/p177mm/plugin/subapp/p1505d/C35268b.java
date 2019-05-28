package com.tencent.p177mm.plugin.subapp.p1505d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.subapp.d.b */
public final class C35268b {
    /* renamed from: b */
    public static void m57941b(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(25326);
        C4990ab.m7417i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, result: %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        C7060h.pYm.mo8381e(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i2 + i3), Integer.valueOf(i4), str);
        AppMethodBeat.m2505o(25326);
    }
}
