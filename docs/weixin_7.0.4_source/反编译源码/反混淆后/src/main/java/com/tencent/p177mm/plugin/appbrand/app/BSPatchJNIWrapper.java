package com.tencent.p177mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.WABSPatch;
import com.tencent.p177mm.plugin.appbrand.service.IBSPatchJNIService;

/* renamed from: com.tencent.mm.plugin.appbrand.app.BSPatchJNIWrapper */
public class BSPatchJNIWrapper implements IBSPatchJNIService {
    public int bspatch(String str, String str2, String str3) {
        AppMethodBeat.m2504i(129208);
        int bspatch = WABSPatch.bspatch(str, str2, str3);
        AppMethodBeat.m2505o(129208);
        return bspatch;
    }
}
