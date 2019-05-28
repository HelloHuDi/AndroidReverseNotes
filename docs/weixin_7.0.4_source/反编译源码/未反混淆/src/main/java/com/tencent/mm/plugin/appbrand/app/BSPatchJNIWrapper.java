package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WABSPatch;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;

public class BSPatchJNIWrapper implements IBSPatchJNIService {
    public int bspatch(String str, String str2, String str3) {
        AppMethodBeat.i(129208);
        int bspatch = WABSPatch.bspatch(str, str2, str3);
        AppMethodBeat.o(129208);
        return bspatch;
    }
}
