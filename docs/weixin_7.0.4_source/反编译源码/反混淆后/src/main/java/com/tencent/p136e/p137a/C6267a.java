package com.tencent.p136e.p137a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b.C0925a;

/* renamed from: com.tencent.e.a.a */
final class C6267a implements C0925a {
    C6267a() {
    }

    public final void println(int i, String str, String str2) {
        AppMethodBeat.m2504i(63703);
        Log.println(i, str, str2);
        AppMethodBeat.m2505o(63703);
    }

    public final boolean isLoggable(String str, int i) {
        AppMethodBeat.m2504i(63704);
        boolean isLoggable = Log.isLoggable(str, i);
        AppMethodBeat.m2505o(63704);
        return isLoggable;
    }
}
