package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

/* renamed from: com.google.android.exoplayer2.j */
public final class C8691j {
    private static final HashSet<String> aNY = new HashSet();
    private static String aNZ = "goog.exo.core";

    static {
        AppMethodBeat.m2504i(94839);
        AppMethodBeat.m2505o(94839);
    }

    /* renamed from: qa */
    public static synchronized String m15429qa() {
        String str;
        synchronized (C8691j.class) {
            str = aNZ;
        }
        return str;
    }

    /* renamed from: ar */
    public static synchronized void m15428ar(String str) {
        synchronized (C8691j.class) {
            AppMethodBeat.m2504i(94838);
            if (aNY.add(str)) {
                aNZ += ", " + str;
            }
            AppMethodBeat.m2505o(94838);
        }
    }
}
