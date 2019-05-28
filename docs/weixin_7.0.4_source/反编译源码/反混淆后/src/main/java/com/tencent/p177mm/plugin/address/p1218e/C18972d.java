package com.tencent.p177mm.plugin.address.p1218e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.address.e.d */
public final class C18972d {
    /* renamed from: wG */
    public static void m29544wG(String str) {
        AppMethodBeat.m2504i(17013);
        if (VERSION.SDK_INT >= 11) {
            C42317b c42317b = new C42317b();
            C42317b.m74837wG(str);
            AppMethodBeat.m2505o(17013);
            return;
        }
        C18971c c18971c = new C18971c();
        C18971c.m29543wG(str);
        AppMethodBeat.m2505o(17013);
    }
}
