package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class l {
    public static boolean IN() {
        AppMethodBeat.i(93105);
        if (bo.bc(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0) {
            AppMethodBeat.o(93105);
            return true;
        }
        AppMethodBeat.o(93105);
        return false;
    }
}
