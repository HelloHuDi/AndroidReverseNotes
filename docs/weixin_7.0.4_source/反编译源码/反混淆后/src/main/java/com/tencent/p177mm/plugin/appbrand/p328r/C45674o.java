package com.tencent.p177mm.plugin.appbrand.p328r;

import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.r.o */
public final class C45674o {
    private static DisplayMetrics iQY = C4996ah.getContext().getResources().getDisplayMetrics();

    static {
        AppMethodBeat.m2504i(57067);
        AppMethodBeat.m2505o(57067);
    }

    public static int aNT() {
        if (iQY == null) {
            return 16;
        }
        return (int) (iQY.density * 16.0f);
    }
}
