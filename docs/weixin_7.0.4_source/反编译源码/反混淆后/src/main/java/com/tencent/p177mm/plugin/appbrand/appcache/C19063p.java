package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C19074a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.p */
public final class C19063p {
    /* renamed from: a */
    public static boolean m29630a(String str, int i, int i2, String str2, C2057a c2057a) {
        AppMethodBeat.m2504i(59439);
        boolean a = C2055az.m4219a(new C38103al(str, i, i2, str2, c2057a), c2057a);
        AppMethodBeat.m2505o(59439);
        return a;
    }

    /* renamed from: a */
    static void m29629a(C38103al c38103al, C40432m c40432m, C19074a c19074a) {
        AppMethodBeat.m2504i(59440);
        C4990ab.m7413e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, request(%s %d->%d)", c38103al.appId, Integer.valueOf(c38103al.gTP), Integer.valueOf(c38103al.gTQ));
        c19074a.mo34289a(c40432m);
        C38105ax xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
        if (xF == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
            C2055az.m4217a(c38103al.vdC, c38103al.appId, C10067a.ENV_ERR, null);
            AppMethodBeat.m2505o(59440);
            return;
        }
        C2055az.m4226xJ(c38103al.vdC);
        C31281at a = xF.mo60841a(c38103al.appId, c38103al.gTQ, 0, "downloadURL");
        if (a == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", c38103al.appId, Integer.valueOf(c38103al.gTQ));
            AppMethodBeat.m2505o(59440);
            return;
        }
        C2055az.m4224b(c38103al.appId, 0, c38103al.gTQ, a.field_downloadURL, c38103al.gTR);
        AppMethodBeat.m2505o(59440);
    }

    /* renamed from: A */
    static int m29628A(String str, String str2, String str3) {
        int i = 1;
        AppMethodBeat.m2504i(59441);
        try {
            i = WABSPatch.bspatch(str, str2, str3);
            AppMethodBeat.m2505o(59441);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", e, str, str2, str3);
            AppMethodBeat.m2505o(59441);
        }
        return i;
    }
}
