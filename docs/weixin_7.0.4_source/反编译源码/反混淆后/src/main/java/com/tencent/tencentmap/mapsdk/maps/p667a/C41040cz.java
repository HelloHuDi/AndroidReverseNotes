package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cz */
final class C41040cz implements Runnable {
    /* renamed from: a */
    private /* synthetic */ C16216cs f16461a;
    /* renamed from: b */
    private /* synthetic */ long f16462b;
    /* renamed from: c */
    private /* synthetic */ C36495cy f16463c;

    C41040cz(C36495cy c36495cy, C16216cs c16216cs, long j) {
        this.f16463c = c36495cy;
        this.f16461a = c16216cs;
        this.f16462b = j;
    }

    public final void run() {
        boolean z = false;
        AppMethodBeat.m2504i(98687);
        try {
            C5862cv a = this.f16461a.mo12409a();
            this.f16461a.f15290k = SystemClock.elapsedRealtime() - this.f16462b;
            this.f16461a.mo12411a(false);
            if (a.f1540a == 0 && a.f1542c == 200) {
                z = true;
            }
            C36495cy.m60375a(this.f16463c, z);
            AppMethodBeat.m2505o(98687);
        } catch (Throwable th) {
            C36495cy.m60375a(this.f16463c, false);
            AppMethodBeat.m2505o(98687);
            throw th;
        }
    }
}
