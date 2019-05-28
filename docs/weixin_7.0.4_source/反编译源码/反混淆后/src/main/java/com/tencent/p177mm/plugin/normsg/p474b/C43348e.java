package com.tencent.p177mm.plugin.normsg.p474b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.normsg.Normsg.C21379b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.normsg.b.e */
public final class C43348e {
    public static boolean oVb;

    static {
        AppMethodBeat.m2504i(10438);
        oVb = false;
        long nanoTime = System.nanoTime();
        try {
            oVb = C21379b.bVK();
            C4990ab.m7417i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", Boolean.valueOf(oVb), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.m2505o(10438);
        } catch (Throwable th) {
            C4990ab.m7417i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", Boolean.valueOf(oVb), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.m2505o(10438);
        }
    }
}
