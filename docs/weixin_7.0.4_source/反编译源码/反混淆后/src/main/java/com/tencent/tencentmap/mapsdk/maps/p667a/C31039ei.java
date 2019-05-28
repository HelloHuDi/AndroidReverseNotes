package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5868ec.C5869a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ei */
final class C31039ei implements Runnable {
    /* renamed from: a */
    private /* synthetic */ C5868ec f14111a;

    C31039ei(C5868ec c5868ec) {
        this.f14111a = c5868ec;
    }

    public final void run() {
        AppMethodBeat.m2504i(98788);
        try {
            C31029ce.m49850e();
            C5869a a = C5868ec.m9037a(this.f14111a, C31029ce.m49847b());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - a.f1588a > ((long) C5868ec.m9036a(this.f14111a, a.f1589b)) || elapsedRealtime < a.f1588a) {
                C5868ec.f1578a = 2;
                this.f14111a.f1582e.removeCallbacks(this.f14111a.f1586i);
                this.f14111a.f1582e.post(this.f14111a.f1586i);
            }
            AppMethodBeat.m2505o(98788);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(98788);
            throw th;
        }
    }
}
