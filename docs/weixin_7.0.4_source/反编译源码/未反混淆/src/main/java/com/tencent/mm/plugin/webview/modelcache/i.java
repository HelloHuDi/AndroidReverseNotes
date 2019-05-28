package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modelcache.e.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;

public final class i extends j<h> {
    static final String[] fnj = new String[]{j.a(h.ccO, "WebViewCacheResConfigMap")};

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(6842);
        boolean b = super.b((h) cVar);
        AppMethodBeat.o(6842);
        return b;
    }

    static {
        AppMethodBeat.i(6843);
        AppMethodBeat.o(6843);
    }

    public static a cYh() {
        AppMethodBeat.i(6841);
        a aVar = new a("WEBVIEW_RESOURCE_CACHE_CONFIG_MAP_TABLE".hashCode(), fnj);
        AppMethodBeat.o(6841);
        return aVar;
    }
}
