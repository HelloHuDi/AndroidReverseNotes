package com.tencent.mm.plugin.appbrand.r;

import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class o {
    private static DisplayMetrics iQY = ah.getContext().getResources().getDisplayMetrics();

    static {
        AppMethodBeat.i(57067);
        AppMethodBeat.o(57067);
    }

    public static int aNT() {
        if (iQY == null) {
            return 16;
        }
        return (int) (iQY.density * 16.0f);
    }
}
