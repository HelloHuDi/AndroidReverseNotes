package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.j;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends a<e> {
    private static final ConcurrentHashMap<String, Boolean> uox = new ConcurrentHashMap();

    public c(e eVar) {
        super(eVar);
    }

    public final boolean awb() {
        return true;
    }

    public final boolean awc() {
        return false;
    }

    public final boolean awd() {
        return true;
    }

    public final boolean awf() {
        return false;
    }

    public final String awa() {
        return "WebViewCache";
    }

    public final boolean gh(long j) {
        AppMethodBeat.i(6905);
        if (!super.gh(j)) {
            AppMethodBeat.o(6905);
            return false;
        } else if (j < 5242880) {
            AppMethodBeat.o(6905);
            return true;
        } else {
            AppMethodBeat.o(6905);
            return false;
        }
    }

    static {
        AppMethodBeat.i(6908);
        AppMethodBeat.o(6908);
    }

    public final m a(j jVar) {
        AppMethodBeat.i(6906);
        if (uox.putIfAbsent(((e) awh()).getFilePath(), Boolean.TRUE) != null) {
            ab.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", ((e) awh()).vdC);
            AppMethodBeat.o(6906);
            return null;
        }
        m a = super.a(jVar);
        uox.remove(((e) awh()).getFilePath());
        AppMethodBeat.o(6906);
        return a;
    }

    public static void clearCache() {
        AppMethodBeat.i(6907);
        uox.clear();
        AppMethodBeat.o(6907);
    }
}
