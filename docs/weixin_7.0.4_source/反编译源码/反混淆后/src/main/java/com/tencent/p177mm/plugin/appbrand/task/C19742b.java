package com.tencent.p177mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandForcePreloadConfig;", "", "()V", "FORCE_PRELOAD_TAG", "", "TAG", "sShouldForcePreload", "", "disableForcePreload", "", "enableForcePreload", "shouldForcePreload", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.task.b */
public final class C19742b {
    private static boolean iEf = true;
    public static final C19742b iEg = new C19742b();

    static {
        AppMethodBeat.m2504i(134962);
        long yz = C5046bo.m7588yz();
        if (C5018as.amF("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0) == 1) {
            C4990ab.m7417i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] == 1, accepted (mmkv cost [%d]ms)", Integer.valueOf(C5018as.amF("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0)), Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(134962);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] storage config = [%d] != 1, buildConfig = [%b] reject (mmkv cost [%d]ms)", Integer.valueOf(C5018as.amF("appbrand_process_force_preload").decodeInt("appbrand_process_force_preload", 0)), Boolean.FALSE, Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(134962);
    }

    private C19742b() {
    }

    public static final boolean aLG() {
        AppMethodBeat.m2504i(134959);
        C4990ab.m7417i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] forcePreload = [%b]", Boolean.valueOf(iEf));
        boolean z = iEf;
        AppMethodBeat.m2505o(134959);
        return z;
    }

    public static final void aLH() {
        AppMethodBeat.m2504i(134960);
        C4990ab.m7416i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] enableForcePreload");
        iEf = true;
        C5018as amF = C5018as.amF("appbrand_process_force_preload");
        amF.encode("appbrand_process_force_preload", 1);
        amF.apply();
        AppMethodBeat.m2505o(134960);
    }

    public static final void aLI() {
        AppMethodBeat.m2504i(134961);
        C4990ab.m7416i("MicroMsg.AppBrandForcePreloadConfig", "[ForcePreload] disableForcePreload");
        iEf = false;
        C5018as amF = C5018as.amF("appbrand_process_force_preload");
        amF.encode("appbrand_process_force_preload", -1);
        amF.apply();
        AppMethodBeat.m2505o(134961);
    }
}
