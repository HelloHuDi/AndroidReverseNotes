package com.tencent.p177mm.p612ui.p627e.p628c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.e.c.b */
public final class C5509b {
    private static C5508a zxq = null;

    /* renamed from: a */
    public static void m8293a(C5508a c5508a) {
        zxq = c5508a;
    }

    /* renamed from: h */
    public static CharSequence m8296h(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(112571);
        if (zxq != null) {
            charSequence = zxq.mo11123h(charSequence, i);
            AppMethodBeat.m2505o(112571);
            return charSequence;
        }
        AppMethodBeat.m2505o(112571);
        return charSequence;
    }

    /* renamed from: c */
    public static CharSequence m8295c(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(112572);
        if (zxq != null) {
            charSequence = zxq.mo11122c(context, charSequence, f);
            AppMethodBeat.m2505o(112572);
            return charSequence;
        }
        AppMethodBeat.m2505o(112572);
        return charSequence;
    }

    /* renamed from: bV */
    public static int m8294bV(String str, int i) {
        AppMethodBeat.m2504i(112573);
        if (zxq != null) {
            i = zxq.mo11121bV(str, i);
            AppMethodBeat.m2505o(112573);
            return i;
        }
        AppMethodBeat.m2505o(112573);
        return i;
    }
}
