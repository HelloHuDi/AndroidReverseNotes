package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class m {
    final String appId;
    final String cHg;
    final String cSx;
    final String cSy;
    final int cSz;
    final String unS;
    final a unT;

    public m(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(6855);
        this.appId = str;
        this.cSx = str2;
        this.unS = str3;
        this.cSz = i;
        this.cSy = str4;
        ab.i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", str, str2, str3, Integer.valueOf(i));
        this.unT = a.aeH(str);
        if (this.unT != null) {
            a aVar = this.unT;
            this.cHg = aVar.path + "/" + String.format("%d_%d_%d_%d", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i), Integer.valueOf(str3.hashCode()), Integer.valueOf(str4.hashCode())});
            AppMethodBeat.o(6855);
            return;
        }
        this.cHg = null;
        ab.e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
        AppMethodBeat.o(6855);
    }
}
