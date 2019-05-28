package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.az.a;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class p {
    public static boolean a(String str, int i, int i2, String str2, a aVar) {
        AppMethodBeat.i(59439);
        boolean a = az.a(new al(str, i, i2, str2, aVar), aVar);
        AppMethodBeat.o(59439);
        return a;
    }

    static void a(al alVar, m mVar, z.a aVar) {
        AppMethodBeat.i(59440);
        ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", alVar.appId, Integer.valueOf(alVar.gTP), Integer.valueOf(alVar.gTQ));
        aVar.a(mVar);
        ax xF = ((d) g.K(d.class)).xF();
        if (xF == null) {
            ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
            az.a(alVar.vdC, alVar.appId, b.a.a.ENV_ERR, null);
            AppMethodBeat.o(59440);
            return;
        }
        az.xJ(alVar.vdC);
        at a = xF.a(alVar.appId, alVar.gTQ, 0, "downloadURL");
        if (a == null) {
            ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", alVar.appId, Integer.valueOf(alVar.gTQ));
            AppMethodBeat.o(59440);
            return;
        }
        az.b(alVar.appId, 0, alVar.gTQ, a.field_downloadURL, alVar.gTR);
        AppMethodBeat.o(59440);
    }

    static int A(String str, String str2, String str3) {
        int i = 1;
        AppMethodBeat.i(59441);
        try {
            i = WABSPatch.bspatch(str, str2, str3);
            AppMethodBeat.o(59441);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", e, str, str2, str3);
            AppMethodBeat.o(59441);
        }
        return i;
    }
}
