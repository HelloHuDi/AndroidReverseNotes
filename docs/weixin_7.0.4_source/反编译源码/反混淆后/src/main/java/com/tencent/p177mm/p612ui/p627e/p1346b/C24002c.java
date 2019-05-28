package com.tencent.p177mm.p612ui.p627e.p1346b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.e.b.c */
public final class C24002c {
    private static C44372b zxp = null;

    /* renamed from: a */
    public static void m36987a(C44372b c44372b) {
        zxp = c44372b;
    }

    /* renamed from: io */
    public static Drawable m36988io(String str, String str2) {
        AppMethodBeat.m2504i(107322);
        if (zxp != null) {
            C44371a dG = zxp.mo35587dG(str, str2);
            if (dG instanceof Drawable) {
                Drawable drawable = (Drawable) dG;
                AppMethodBeat.m2505o(107322);
                return drawable;
            }
            AppMethodBeat.m2505o(107322);
            return null;
        }
        AppMethodBeat.m2505o(107322);
        return null;
    }
}
