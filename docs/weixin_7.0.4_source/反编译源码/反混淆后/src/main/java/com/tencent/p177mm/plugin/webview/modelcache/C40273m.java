package com.tencent.p177mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.m */
public final class C40273m {
    final String appId;
    final String cHg;
    final String cSx;
    final String cSy;
    final int cSz;
    final String unS;
    final C22895a unT;

    public C40273m(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.m2504i(6855);
        this.appId = str;
        this.cSx = str2;
        this.unS = str3;
        this.cSz = i;
        this.cSy = str4;
        C4990ab.m7417i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", str, str2, str3, Integer.valueOf(i));
        this.unT = C22895a.aeH(str);
        if (this.unT != null) {
            C22895a c22895a = this.unT;
            this.cHg = c22895a.path + "/" + String.format("%d_%d_%d_%d", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i), Integer.valueOf(str3.hashCode()), Integer.valueOf(str4.hashCode())});
            AppMethodBeat.m2505o(6855);
            return;
        }
        this.cHg = null;
        C4990ab.m7412e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
        AppMethodBeat.m2505o(6855);
    }
}
