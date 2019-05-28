package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

abstract class c<T extends d> extends u {
    private final T hJD;

    public c(T t) {
        this.hJD = t;
    }

    public final String b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject) {
        a c = this.hJD.c(cVar, jSONObject);
        return a(cVar, c.aIm, c.values);
    }
}
