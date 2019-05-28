package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.do */
final class C36498do implements Runnable {
    /* renamed from: a */
    private /* synthetic */ C24365dn f15326a;

    C36498do(C24365dn c24365dn) {
        this.f15326a = c24365dn;
    }

    public final void run() {
        AppMethodBeat.m2504i(98730);
        String b = C24370er.m37716b("settings_in_client", "", true);
        if (!TextUtils.isEmpty(b)) {
            try {
                this.f15326a.f4664a.mo50353a(b);
                C24365dn.m37694b(this.f15326a);
                AppMethodBeat.m2505o(98730);
                return;
            } catch (Throwable th) {
                C24370er.m37713a("settings_in_client", "", true);
            }
        }
        AppMethodBeat.m2505o(98730);
    }
}
