package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;

public final class m {
    private final String TAG = "MircoMsg.XWebCodeCacheMeta";
    private String ckz;
    private String script;
    private int size;
    private long uJa;
    private a uJb;

    enum a {
        File,
        Buffer;

        static {
            AppMethodBeat.o(9853);
        }
    }

    public m(String str) {
        this.ckz = str;
        this.uJb = a.File;
    }

    public m(String str, long j, int i) {
        this.script = str;
        this.uJa = j;
        this.size = i;
        this.uJb = a.Buffer;
    }

    public final String toString() {
        AppMethodBeat.i(9854);
        StringBuilder stringBuilder = new StringBuilder("//XWEB_SCRIPT:");
        i iVar = new i();
        try {
            if (this.uJb == a.File) {
                iVar.g("cache_mode", "fullcache");
                iVar.g("js_src_kind", "path");
                iVar.g("js_src", this.ckz);
                stringBuilder.append(iVar.toString());
            } else {
                iVar.g("cache_mode", "nocache");
                iVar.g("js_src_kind", "string");
                iVar.g("js_src", this.script);
                iVar.g("js_param_kind", "buffer");
                iVar.g("js_param", Long.toHexString(this.uJa));
                iVar.K("js_param_length", this.size);
                stringBuilder.append(iVar.toString());
            }
        } catch (g e) {
            d.printErrStackTrace("MircoMsg.XWebCodeCacheMeta", e, "toString", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(9854);
        return stringBuilder2;
    }
}
