package com.tencent.p177mm.plugin.appbrand.p328r;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.r.p */
public final class C10706p {
    private static DisplayMetrics aDu = new DisplayMetrics();

    static {
        AppMethodBeat.m2504i(57068);
        ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getRealMetrics(aDu);
        AppMethodBeat.m2505o(57068);
    }

    /* renamed from: qc */
    public static int m18378qc(int i) {
        return aDu == null ? i : (int) (((float) i) / aDu.density);
    }

    /* renamed from: qd */
    public static int m18379qd(int i) {
        return aDu == null ? i : (int) (aDu.density * ((float) i));
    }
}
