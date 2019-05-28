package com.tencent.p177mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ag */
public enum C42608ag {
    ;

    /* renamed from: oZ */
    public static void m75435oZ(int i) {
        AppMethodBeat.m2504i(131954);
        C42608ag.m75434Ck(C4996ah.getResources().getString(i));
        AppMethodBeat.m2505o(131954);
    }

    /* renamed from: Ck */
    public static void m75434Ck(final String str) {
        AppMethodBeat.m2504i(131955);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(131951);
                Toast.makeText(C4996ah.getContext(), str, 0).show();
                AppMethodBeat.m2505o(131951);
            }
        });
        AppMethodBeat.m2505o(131955);
    }

    public static String getMMString(int i, Object... objArr) {
        AppMethodBeat.m2504i(131956);
        String mMString = C42677e.getMMString(i, objArr);
        AppMethodBeat.m2505o(131956);
        return mMString;
    }
}
