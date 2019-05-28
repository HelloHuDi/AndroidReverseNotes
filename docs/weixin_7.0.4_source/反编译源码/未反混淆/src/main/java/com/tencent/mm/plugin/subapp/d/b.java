package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static void b(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(25326);
        ab.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, result: %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        h.pYm.e(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i2 + i3), Integer.valueOf(i4), str);
        AppMethodBeat.o(25326);
    }
}
