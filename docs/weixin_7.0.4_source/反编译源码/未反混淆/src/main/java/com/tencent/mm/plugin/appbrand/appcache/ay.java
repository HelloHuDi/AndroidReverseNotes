package com.tencent.mm.plugin.appbrand.appcache;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageInvalidRecordFixer;", "", "()V", "TAG", "", "removeInvalidReleaseRecords", "", "plugin-appbrand-integration_release"})
public final class ay {
    public static final ay gVo = new ay();

    static {
        AppMethodBeat.i(134468);
        AppMethodBeat.o(134468);
    }

    private ay() {
    }

    public static final void awp() {
        AppMethodBeat.i(134467);
        a auK = f.auK();
        if (auK != null) {
            try {
                Boolean.valueOf(auK.hY("AppBrandWxaPkgManifestRecord", "delete from AppBrandWxaPkgManifestRecord where debugType=0 and version=0"));
                AppMethodBeat.o(134467);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MiroMsg.WxaPkgStorageInvalidRecordFixer", e, " removeInvalidReleaseRecords", new Object[0]);
                y yVar = y.AUy;
                AppMethodBeat.o(134467);
                return;
            }
        }
        AppMethodBeat.o(134467);
    }
}
