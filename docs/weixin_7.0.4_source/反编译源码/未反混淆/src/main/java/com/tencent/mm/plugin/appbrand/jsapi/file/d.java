package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

abstract class d implements f {
    m hJG = this;

    public abstract a a(c cVar, String str, JSONObject jSONObject);

    d() {
    }

    static {
        e.a.init();
    }

    public final a c(c cVar, JSONObject jSONObject) {
        String y = y(jSONObject);
        if (bo.isNullOrNil(y)) {
            return new a("fail invalid path", new Object[0]);
        }
        if (cVar.isRunning()) {
            return a(cVar, y, jSONObject);
        }
        return new a("fail:interrupted", new Object[0]);
    }

    /* Access modifiers changed, original: protected */
    public String y(JSONObject jSONObject) {
        String optString = jSONObject.optString("filePath", null);
        if (bo.isNullOrNil(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        if (bo.isNullOrNil(optString)) {
            return jSONObject.optString("path", null);
        }
        return optString;
    }
}
