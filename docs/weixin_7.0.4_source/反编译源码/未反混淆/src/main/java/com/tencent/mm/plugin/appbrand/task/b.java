package com.tencent.mm.plugin.appbrand.task;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
public final class b {
    private static boolean iEf = true;
    public static final b iEg = new b();

    static {
        AppMethodBeat.i(134962);
        long yz = bo.yz();
        if (as.amF("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0) == 1) {
            ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", Integer.valueOf(as.amF("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0)), Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(134962);
            return;
        }
        ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", Integer.valueOf(as.amF("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0)), Boolean.FALSE, Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(134962);
    }

    private b() {
    }

    public static final boolean aLG() {
        AppMethodBeat.i(134959);
        ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", Boolean.valueOf(iEf));
        boolean z = iEf;
        AppMethodBeat.o(134959);
        return z;
    }

    public static final void aLH() {
        AppMethodBeat.i(134960);
        ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
        iEf = true;
        as amF = as.amF("appbrand_process_force_preload");
        amF.encode("appbrand_process_force_preload", 1);
        amF.apply();
        AppMethodBeat.o(134960);
    }

    public static final void aLI() {
        AppMethodBeat.i(134961);
        ab.i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
        iEf = false;
        as amF = as.amF("appbrand_process_force_preload");
        amF.encode("appbrand_process_force_preload", -1);
        amF.apply();
        AppMethodBeat.o(134961);
    }
}
