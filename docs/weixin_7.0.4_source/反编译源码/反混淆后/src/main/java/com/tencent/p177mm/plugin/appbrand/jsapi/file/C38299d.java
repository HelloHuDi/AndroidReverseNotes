package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C26974e.C10390a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.d */
abstract class C38299d implements C19377f {
    C45608m hJG = this;

    /* renamed from: a */
    public abstract C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject);

    C38299d() {
    }

    static {
        C10390a.init();
    }

    /* renamed from: c */
    public final C10396a mo61002c(C2241c c2241c, JSONObject jSONObject) {
        String y = mo44689y(jSONObject);
        if (C5046bo.isNullOrNil(y)) {
            return new C10396a("fail invalid path", new Object[0]);
        }
        if (c2241c.isRunning()) {
            return mo21863a(c2241c, y, jSONObject);
        }
        return new C10396a("fail:interrupted", new Object[0]);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: y */
    public String mo44689y(JSONObject jSONObject) {
        String optString = jSONObject.optString("filePath", null);
        if (C5046bo.isNullOrNil(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        if (C5046bo.isNullOrNil(optString)) {
            return jSONObject.optString("path", null);
        }
        return optString;
    }
}
