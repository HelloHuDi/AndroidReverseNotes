package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class j {
    private static final HashSet<String> aNY = new HashSet();
    private static String aNZ = "goog.exo.core";

    static {
        AppMethodBeat.i(94839);
        AppMethodBeat.o(94839);
    }

    public static synchronized String qa() {
        String str;
        synchronized (j.class) {
            str = aNZ;
        }
        return str;
    }

    public static synchronized void ar(String str) {
        synchronized (j.class) {
            AppMethodBeat.i(94838);
            if (aNY.add(str)) {
                aNZ += ", " + str;
            }
            AppMethodBeat.o(94838);
        }
    }
}
