package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Map;
import org.json.JSONObject;

public abstract class o {
    protected q hwf;
    protected u hwg;
    protected JSONObject hwh;
    private int hwi;
    private m hwj;

    public o(m mVar, q qVar, u uVar, JSONObject jSONObject, int i) {
        if (mVar == null || qVar == null || jSONObject == null) {
            throw new IllegalArgumentException("JsApiAsyncRequest");
        }
        this.hwj = mVar;
        this.hwf = qVar;
        this.hwg = uVar;
        this.hwi = i;
        this.hwh = jSONObject;
    }

    public final q xT() {
        return this.hwf;
    }

    public final JSONObject aCg() {
        return this.hwh;
    }

    /* Access modifiers changed, original: protected|final */
    public final void w(Map<String, ? extends Object> map) {
        this.hwf.M(this.hwi, this.hwj.j("ok", map));
    }

    /* Access modifiers changed, original: protected|final */
    public final void k(String str, Map<String, ? extends Object> map) {
        this.hwf.M(this.hwi, this.hwj.j(str, map));
    }
}
