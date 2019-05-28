package com.tencent.mm.plugin.appbrand.task.a;

import a.f.b.j;
import a.l;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "hitLimit", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "hitLimitByCounter", "hitLimitByMemoryPressure", "onTrimMemory", "", "level", "", "test_disablePreload", "disabled", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
public final class a {
    private static final a iFw = new a();
    public static final a iFx = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "update", "", "plugin-appbrand-integration_release"})
    static final class a extends SparseLongArray {
        public a() {
            super(g.values().length);
            AppMethodBeat.i(134965);
            AppMethodBeat.o(134965);
        }

        public final long i(g gVar) {
            AppMethodBeat.i(134963);
            j.p(gVar, "type");
            if (g.NIL == gVar) {
                AppMethodBeat.o(134963);
                return 0;
            }
            long j = super.get(gVar.ordinal(), 0);
            AppMethodBeat.o(134963);
            return j;
        }

        public final void j(g gVar) {
            AppMethodBeat.i(134964);
            j.p(gVar, "type");
            super.put(gVar.ordinal(), bo.yz());
            AppMethodBeat.o(134964);
        }
    }

    static {
        AppMethodBeat.i(134970);
        AppMethodBeat.o(134970);
    }

    private a() {
    }

    public static final void eC(boolean z) {
        AppMethodBeat.i(134966);
        as.amF("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", z).commit();
        AppMethodBeat.o(134966);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean g(g gVar) {
        AppMethodBeat.i(134967);
        j.p(gVar, "type");
        if (as.amF("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false)) {
            AppMethodBeat.o(134967);
            return true;
        }
        if (!h(gVar)) {
            boolean z;
            long anU = bo.anU();
            long j = as.amF("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", anU);
            if (j - anU >= TimeUnit.DAYS.toMillis(1)) {
                ab.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
                as.amF("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", anU).apply();
            } else if (j > anU) {
                z = true;
                if (!z) {
                    iFw.j(gVar);
                    AppMethodBeat.o(134967);
                    return false;
                }
            }
            z = false;
            if (z) {
            }
        }
        AppMethodBeat.o(134967);
        return true;
    }

    private static boolean h(g gVar) {
        AppMethodBeat.i(134968);
        if (g.NIL == gVar) {
            AppMethodBeat.o(134968);
            return false;
        }
        long a;
        try {
            a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_process_preload_frequence_limit, 30);
        } catch (NullPointerException e) {
            a = 30;
        }
        if (bo.az(iFw.i(gVar)) <= TimeUnit.SECONDS.toMillis(a)) {
            AppMethodBeat.o(134968);
            return true;
        }
        AppMethodBeat.o(134968);
        return false;
    }

    public static final void onTrimMemory(int i) {
        AppMethodBeat.i(134969);
        ab.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + i + ", process=" + ah.getProcessName());
        h.pYm.z(915, 21);
        as.amF("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", TimeUnit.MINUTES.toMillis(((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_process_preload_memory_stress_time_limit, 10)) + bo.anU()).apply();
        AppMethodBeat.o(134969);
    }
}
