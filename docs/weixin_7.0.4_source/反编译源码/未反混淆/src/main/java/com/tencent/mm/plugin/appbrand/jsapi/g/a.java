package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.luggage.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public void a(c cVar, JSONObject jSONObject, int i) {
        e.Bj(getName());
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, String str, boolean z, boolean z2) {
        cVar.M(i, str);
        e.d(getName(), z, z2);
    }

    /* Access modifiers changed, original: protected|final */
    public final b f(c cVar, JSONObject jSONObject) {
        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.e) {
            return g.cj(cVar.getAppId(), f.g(cVar, jSONObject));
        }
        if (cVar.B(com.tencent.mm.plugin.appbrand.jsapi.base.f.class) == null) {
            d.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", getName());
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.e c = ((com.tencent.mm.plugin.appbrand.jsapi.base.f) cVar.B(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).c(cVar);
        if (c != null) {
            return g.cj(c.getAppId(), f.g(c, jSONObject));
        }
        d.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", getName());
        return null;
    }
}
