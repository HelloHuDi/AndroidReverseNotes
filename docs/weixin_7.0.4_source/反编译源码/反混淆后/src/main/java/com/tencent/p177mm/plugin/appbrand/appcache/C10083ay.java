package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C37091y;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageInvalidRecordFixer;", "", "()V", "TAG", "", "removeInvalidReleaseRecords", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ay */
public final class C10083ay {
    public static final C10083ay gVo = new C10083ay();

    static {
        AppMethodBeat.m2504i(134468);
        AppMethodBeat.m2505o(134468);
    }

    private C10083ay() {
    }

    public static final void awp() {
        AppMethodBeat.m2504i(134467);
        C1953a auK = C42340f.auK();
        if (auK != null) {
            try {
                Boolean.valueOf(auK.mo10108hY("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0"));
                AppMethodBeat.m2505o(134467);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", e, " removeInvalidReleaseRecords", new Object[0]);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(134467);
                return;
            }
        }
        AppMethodBeat.m2505o(134467);
    }
}
