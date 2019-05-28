package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.c */
abstract class C33312c<T extends C38299d> extends C19497u {
    private final T hJD;

    public C33312c(T t) {
        this.hJD = t;
    }

    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        C10396a c = this.hJD.mo61002c(c2241c, jSONObject);
        return mo73393a(c2241c, c.aIm, c.values);
    }
}
