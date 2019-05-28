package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.m */
public final class C40342m {
    private final String TAG = "MircoMsg.XWebCodeCacheMeta";
    private String ckz;
    private String script;
    private int size;
    private long uJa;
    private C23137a uJb;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.m$a */
    enum C23137a {
        File,
        Buffer;

        static {
            AppMethodBeat.m2505o(9853);
        }
    }

    public C40342m(String str) {
        this.ckz = str;
        this.uJb = C23137a.File;
    }

    public C40342m(String str, long j, int i) {
        this.script = str;
        this.uJa = j;
        this.size = i;
        this.uJb = C23137a.Buffer;
    }

    public final String toString() {
        AppMethodBeat.m2504i(9854);
        StringBuilder stringBuilder = new StringBuilder("//XWEB_SCRIPT:");
        C41726i c41726i = new C41726i();
        try {
            if (this.uJb == C23137a.File) {
                c41726i.mo67475g("cache_mode", "fullcache");
                c41726i.mo67475g("js_src_kind", "path");
                c41726i.mo67475g("js_src", this.ckz);
                stringBuilder.append(c41726i.toString());
            } else {
                c41726i.mo67475g("cache_mode", "nocache");
                c41726i.mo67475g("js_src_kind", "string");
                c41726i.mo67475g("js_src", this.script);
                c41726i.mo67475g("js_param_kind", "buffer");
                c41726i.mo67475g("js_param", Long.toHexString(this.uJa));
                c41726i.mo67474K("js_param_length", this.size);
                stringBuilder.append(c41726i.toString());
            }
        } catch (C41724g e) {
            C45124d.printErrStackTrace("MircoMsg.XWebCodeCacheMeta", e, "toString", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(9854);
        return stringBuilder2;
    }
}
