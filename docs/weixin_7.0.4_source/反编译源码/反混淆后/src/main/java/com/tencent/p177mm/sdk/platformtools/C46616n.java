package com.tencent.p177mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.n */
public final class C46616n {
    /* renamed from: ci */
    public static void m88170ci(View view) {
        AppMethodBeat.m2504i(51990);
        if (view == null) {
            AppMethodBeat.m2505o(51990);
            return;
        }
        C4990ab.m7408b("MicroMsg.ForceGpuUtil", "setLayerType, view: %s", Integer.valueOf(view.hashCode()));
        if (VERSION.SDK_INT >= 11) {
            C46617p c46617p = new C46617p();
            C46617p.m88172ci(view);
        }
        AppMethodBeat.m2505o(51990);
    }

    /* renamed from: w */
    public static void m88171w(View view, int i, int i2) {
        AppMethodBeat.m2504i(51991);
        if (view == null) {
            AppMethodBeat.m2505o(51991);
            return;
        }
        if (VERSION.SDK_INT >= 11) {
            C46617p c46617p = new C46617p();
            C46617p.m88173w(view, i, i2);
        }
        AppMethodBeat.m2505o(51991);
    }
}
