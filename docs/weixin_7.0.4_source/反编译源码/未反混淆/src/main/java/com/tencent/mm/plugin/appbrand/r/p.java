package com.tencent.mm.plugin.appbrand.r;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class p {
    private static DisplayMetrics aDu = new DisplayMetrics();

    static {
        AppMethodBeat.i(57068);
        ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getRealMetrics(aDu);
        AppMethodBeat.o(57068);
    }

    public static int qc(int i) {
        return aDu == null ? i : (int) (((float) i) / aDu.density);
    }

    public static int qd(int i) {
        return aDu == null ? i : (int) (aDu.density * ((float) i));
    }
}
