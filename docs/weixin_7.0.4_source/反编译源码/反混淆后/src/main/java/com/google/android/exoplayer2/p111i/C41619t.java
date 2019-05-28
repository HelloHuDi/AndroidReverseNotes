package com.google.android.exoplayer2.p111i;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.t */
public final class C41619t {
    public static void beginSection(String str) {
        AppMethodBeat.m2504i(95946);
        if (C17675v.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
        AppMethodBeat.m2505o(95946);
    }

    public static void endSection() {
        AppMethodBeat.m2504i(95947);
        if (C17675v.SDK_INT >= 18) {
            Trace.endSection();
        }
        AppMethodBeat.m2505o(95947);
    }
}
