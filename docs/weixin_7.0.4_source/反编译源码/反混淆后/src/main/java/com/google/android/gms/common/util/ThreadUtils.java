package com.google.android.gms.common.util;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadUtils {
    private ThreadUtils() {
    }

    public static boolean isMainThread() {
        AppMethodBeat.m2504i(90275);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            AppMethodBeat.m2505o(90275);
            return true;
        }
        AppMethodBeat.m2505o(90275);
        return false;
    }
}
