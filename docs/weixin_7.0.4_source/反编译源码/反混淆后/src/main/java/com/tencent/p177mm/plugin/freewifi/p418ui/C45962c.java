package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.c */
public final class C45962c {
    private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    private boolean isRunning;
    private C42207b mzn;
    private C42206a mzo;
    private C7306ak mzp;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.c$b */
    static class C20831b {
        private static C45962c mzs = new C45962c();

        static {
            AppMethodBeat.m2504i(20995);
            AppMethodBeat.m2505o(20995);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.c$a */
    public interface C28105a {
        /* renamed from: Q */
        void mo46025Q(float f, float f2);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.c$2 */
    class C391242 implements Runnable {
        C391242() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20994);
            C45962c.this.isRunning = false;
            if (C45962c.this.mzn != null) {
                C45962c.this.mzn.mo44208c(C45962c.this.mzo);
            }
            if (C45962c.this.mzo == null) {
                C4990ab.m7420w(C45962c.TAG, "already callback");
                AppMethodBeat.m2505o(20994);
                return;
            }
            C45962c.this.mzo = null;
            AppMethodBeat.m2505o(20994);
        }
    }

    /* synthetic */ C45962c(byte b) {
        this();
    }

    private C45962c() {
        this.mzn = null;
        this.mzo = null;
        this.mzp = null;
        this.isRunning = false;
    }

    public static C45962c bzM() {
        AppMethodBeat.m2504i(20996);
        C45962c bzN = C20831b.mzs;
        AppMethodBeat.m2505o(20996);
        return bzN;
    }

    /* renamed from: a */
    public final void mo73827a(final C28105a c28105a) {
        AppMethodBeat.m2504i(20997);
        if (this.isRunning) {
            AppMethodBeat.m2505o(20997);
            return;
        }
        this.isRunning = true;
        this.mzn = C26443d.agz();
        if (this.mzn == null) {
            C4990ab.m7412e(TAG, "doGeoLocation fail, iGetLocation is null");
            AppMethodBeat.m2505o(20997);
            return;
        }
        if (this.mzo == null) {
            this.mzo = new C42206a() {
                /* renamed from: a */
                public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                    AppMethodBeat.m2504i(20993);
                    if (z) {
                        C4990ab.m7419v(C45962c.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
                        if (C45962c.this.mzn != null) {
                            C45962c.this.mzn.mo44208c(C45962c.this.mzo);
                        }
                        if (C45962c.this.mzo == null) {
                            C4990ab.m7420w(C45962c.TAG, "already callback");
                            AppMethodBeat.m2505o(20993);
                            return false;
                        }
                        C45962c.this.mzo = null;
                        c28105a.mo46025Q(f, f2);
                        AppMethodBeat.m2505o(20993);
                        return false;
                    }
                    AppMethodBeat.m2505o(20993);
                    return true;
                }
            };
        }
        if (this.mzp == null) {
            this.mzp = new C7306ak(Looper.myLooper());
        }
        this.mzp.postDelayed(new C391242(), 20000);
        this.mzn.mo44203a(this.mzo);
        AppMethodBeat.m2505o(20997);
    }
}
