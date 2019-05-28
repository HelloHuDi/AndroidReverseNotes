package com.google.android.gms.common.util;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadUtils {
    private ThreadUtils() {
    }

    public static boolean isMainThread() {
        AppMethodBeat.i(90275);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            AppMethodBeat.o(90275);
            return true;
        }
        AppMethodBeat.o(90275);
        return false;
    }
}
