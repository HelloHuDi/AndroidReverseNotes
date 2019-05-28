package com.tencent.p177mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n.C30044a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35791j;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.c */
public final class C4555c extends C30044a<C36857e> {
    private static final ConcurrentHashMap<String, Boolean> uox = new ConcurrentHashMap();

    public C4555c(C36857e c36857e) {
        super(c36857e);
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

    /* renamed from: gh */
    public final boolean mo9636gh(long j) {
        AppMethodBeat.m2504i(6905);
        if (!super.mo9636gh(j)) {
            AppMethodBeat.m2505o(6905);
            return false;
        } else if (j < 5242880) {
            AppMethodBeat.m2505o(6905);
            return true;
        } else {
            AppMethodBeat.m2505o(6905);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(6908);
        AppMethodBeat.m2505o(6908);
    }

    /* renamed from: a */
    public final C40432m mo9630a(C35791j c35791j) {
        AppMethodBeat.m2504i(6906);
        if (uox.putIfAbsent(((C36857e) awh()).getFilePath(), Boolean.TRUE) != null) {
            C4990ab.m7417i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", ((C36857e) awh()).vdC);
            AppMethodBeat.m2505o(6906);
            return null;
        }
        C40432m a = super.mo9630a(c35791j);
        uox.remove(((C36857e) awh()).getFilePath());
        AppMethodBeat.m2505o(6906);
        return a;
    }

    public static void clearCache() {
        AppMethodBeat.m2504i(6907);
        uox.clear();
        AppMethodBeat.m2505o(6907);
    }
}
