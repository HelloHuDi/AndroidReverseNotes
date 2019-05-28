package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1480b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b */
public final class C38802b {
    public static int bgo() {
        AppMethodBeat.m2504i(135467);
        if (C4990ab.dos() != null) {
            int logLevel = C4990ab.dos().getLogLevel();
            AppMethodBeat.m2505o(135467);
            return logLevel;
        }
        AppMethodBeat.m2505o(135467);
        return 0;
    }
}
