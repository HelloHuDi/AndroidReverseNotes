package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.c */
public final class C26759c {
    private static float hba = 0.0f;
    private static float hbb = 0.0f;
    private static volatile long hbc = 0;
    private boolean hbd = false;
    private C26760a hbe;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.c$a */
    public interface C26760a {
        /* renamed from: G */
        void mo21466G(float f, float f2);
    }

    /* renamed from: a */
    public final void mo44535a(C26760a c26760a) {
        this.hbe = c26760a;
    }

    public final boolean axS() {
        return this.hbe != null;
    }

    public static boolean axT() {
        AppMethodBeat.m2504i(129740);
        if (hbb == -85.0f || hba == -1000.0f) {
            AppMethodBeat.m2505o(129740);
            return false;
        }
        boolean z;
        if (C5046bo.anU() - hbc < 300000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(129740);
            return true;
        }
        AppMethodBeat.m2505o(129740);
        return false;
    }

    public static float getLongitude() {
        return hba;
    }

    public static float getLatitude() {
        return hbb;
    }

    public final void axU() {
        AppMethodBeat.m2504i(129741);
        if (this.hbd) {
            AppMethodBeat.m2505o(129741);
            return;
        }
        C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
        this.hbd = true;
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        C7564ap c7564ap = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(129738);
                if (pBool2.value) {
                    AppMethodBeat.m2505o(129738);
                } else {
                    pBool.value = true;
                    C26759c.this.hbd = false;
                    C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
                    if (C26759c.this.hbe != null) {
                        C26759c.this.hbe.mo21466G(C26759c.hba, C26759c.hbb);
                    }
                    AppMethodBeat.m2505o(129738);
                }
                return false;
            }
        }, false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        c7564ap.mo16770ae(toMillis, toMillis);
        C26443d.agz().mo44207b((C42206a) C42677e.m75580bB(new C42206a() {
            private int gZI = 0;

            /* renamed from: a */
            public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.m2504i(129739);
                C42677e.m75579at(this);
                C26443d.agz().mo44208c(this);
                int i2 = this.gZI + 1;
                this.gZI = i2;
                if (i2 > 1 || pBool.value) {
                    AppMethodBeat.m2505o(129739);
                    return false;
                }
                pBool2.value = true;
                C26759c.this.hbd = false;
                if (z) {
                    C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
                    C26759c.hbb = f2;
                    C26759c.hba = f;
                    C26759c.hbc = C5046bo.anU();
                    if (C26759c.this.hbe != null) {
                        C26759c.this.hbe.mo21466G(f, f2);
                    }
                    AppMethodBeat.m2505o(129739);
                    return true;
                }
                C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
                if (C26759c.this.hbe != null) {
                    C26759c.this.hbe.mo21466G(f, f2);
                }
                AppMethodBeat.m2505o(129739);
                return false;
            }
        }), false);
        AppMethodBeat.m2505o(129741);
    }
}
