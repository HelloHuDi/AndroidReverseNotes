package com.tencent.p177mm.plugin.appbrand.task.p1139a;

import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.TimeUnit;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "hitLimit", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "hitLimitByCounter", "hitLimitByMemoryPressure", "onTrimMemory", "", "level", "", "test_disablePreload", "disabled", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.task.a.a */
public final class C27308a {
    private static final C27307a iFw = new C27307a();
    public static final C27308a iFx = new C27308a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "update", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.task.a.a$a */
    static final class C27307a extends SparseLongArray {
        public C27307a() {
            super(C38519g.values().length);
            AppMethodBeat.m2504i(134965);
            AppMethodBeat.m2505o(134965);
        }

        /* renamed from: i */
        public final long mo45004i(C38519g c38519g) {
            AppMethodBeat.m2504i(134963);
            C25052j.m39376p(c38519g, "type");
            if (C38519g.NIL == c38519g) {
                AppMethodBeat.m2505o(134963);
                return 0;
            }
            long j = super.get(c38519g.ordinal(), 0);
            AppMethodBeat.m2505o(134963);
            return j;
        }

        /* renamed from: j */
        public final void mo45005j(C38519g c38519g) {
            AppMethodBeat.m2504i(134964);
            C25052j.m39376p(c38519g, "type");
            super.put(c38519g.ordinal(), C5046bo.m7588yz());
            AppMethodBeat.m2505o(134964);
        }
    }

    static {
        AppMethodBeat.m2504i(134970);
        AppMethodBeat.m2505o(134970);
    }

    private C27308a() {
    }

    /* renamed from: eC */
    public static final void m43360eC(boolean z) {
        AppMethodBeat.m2504i(134966);
        C5018as.amF("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", z).commit();
        AppMethodBeat.m2505o(134966);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public static final boolean m43361g(C38519g c38519g) {
        AppMethodBeat.m2504i(134967);
        C25052j.m39376p(c38519g, "type");
        if (C5018as.amF("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false)) {
            AppMethodBeat.m2505o(134967);
            return true;
        }
        if (!C27308a.m43362h(c38519g)) {
            boolean z;
            long anU = C5046bo.anU();
            long j = C5018as.amF("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", anU);
            if (j - anU >= TimeUnit.DAYS.toMillis(1)) {
                C4990ab.m7420w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
                C5018as.amF("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", anU).apply();
            } else if (j > anU) {
                z = true;
                if (!z) {
                    iFw.mo45005j(c38519g);
                    AppMethodBeat.m2505o(134967);
                    return false;
                }
            }
            z = false;
            if (z) {
            }
        }
        AppMethodBeat.m2505o(134967);
        return true;
    }

    /* renamed from: h */
    private static boolean m43362h(C38519g c38519g) {
        AppMethodBeat.m2504i(134968);
        if (C38519g.NIL == c38519g) {
            AppMethodBeat.m2505o(134968);
            return false;
        }
        long a;
        try {
            a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_appbrand_process_preload_frequence_limit, 30);
        } catch (NullPointerException e) {
            a = 30;
        }
        if (C5046bo.m7525az(iFw.mo45004i(c38519g)) <= TimeUnit.SECONDS.toMillis(a)) {
            AppMethodBeat.m2505o(134968);
            return true;
        }
        AppMethodBeat.m2505o(134968);
        return false;
    }

    public static final void onTrimMemory(int i) {
        AppMethodBeat.m2504i(134969);
        C4990ab.m7416i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + i + ", process=" + C4996ah.getProcessName());
        C7060h.pYm.mo15421z(915, 21);
        C5018as.amF("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", TimeUnit.MINUTES.toMillis(((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_appbrand_process_preload_memory_stress_time_limit, 10)) + C5046bo.anU()).apply();
        AppMethodBeat.m2505o(134969);
    }
}
