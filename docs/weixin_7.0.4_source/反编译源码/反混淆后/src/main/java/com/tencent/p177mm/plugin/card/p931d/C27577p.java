package com.tencent.p177mm.plugin.card.p931d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.card.d.p */
public final class C27577p {
    /* renamed from: wG */
    public static void m43810wG(String str) {
        AppMethodBeat.m2504i(88942);
        if (VERSION.SDK_INT >= 11) {
            C42845n c42845n = new C42845n();
            C42845n.m76053wG(str);
            AppMethodBeat.m2505o(88942);
            return;
        }
        C11279o c11279o = new C11279o();
        C11279o.m18994wG(str);
        AppMethodBeat.m2505o(88942);
    }
}
