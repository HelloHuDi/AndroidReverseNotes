package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ee */
final class C36499ee implements Runnable {
    /* renamed from: a */
    private /* synthetic */ C17082ed f15327a;

    C36499ee(C17082ed c17082ed) {
        this.f15327a = c17082ed;
    }

    public final void run() {
        AppMethodBeat.m2504i(98783);
        String string = C46772bt.m88735a().getSharedPreferences(C17082ed.m26421a(this.f15327a), 0).getString("halley_cloud_param_content", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.f15327a.f3584a.mo50353a(string);
                AppMethodBeat.m2505o(98783);
                return;
            } catch (Throwable th) {
                C17082ed.m26422a(this.f15327a, "");
            }
        }
        AppMethodBeat.m2505o(98783);
    }
}
