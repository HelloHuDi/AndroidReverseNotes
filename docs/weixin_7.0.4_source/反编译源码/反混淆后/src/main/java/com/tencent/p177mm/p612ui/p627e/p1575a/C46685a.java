package com.tencent.p177mm.p612ui.p627e.p1575a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.e.a.a */
public final class C46685a {
    private static C40860b zxo = null;

    /* renamed from: a */
    public static void m88421a(C40860b c40860b) {
        zxo = c40860b;
    }

    /* renamed from: b */
    public static void m88422b(ImageView imageView, String str) {
        AppMethodBeat.m2504i(107321);
        if (zxo != null) {
            zxo.mo51299b(imageView, str);
        }
        AppMethodBeat.m2505o(107321);
    }
}
