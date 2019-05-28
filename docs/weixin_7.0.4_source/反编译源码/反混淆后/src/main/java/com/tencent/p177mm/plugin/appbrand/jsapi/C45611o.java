package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o */
public abstract class C45611o {
    protected C38492q hwf;
    protected C44709u hwg;
    protected JSONObject hwh;
    private int hwi;
    private C45608m hwj;

    public C45611o(C45608m c45608m, C38492q c38492q, C44709u c44709u, JSONObject jSONObject, int i) {
        if (c45608m == null || c38492q == null || jSONObject == null) {
            throw new IllegalArgumentException("JsApiAsyncRequest");
        }
        this.hwj = c45608m;
        this.hwf = c38492q;
        this.hwg = c44709u;
        this.hwi = i;
        this.hwh = jSONObject;
    }

    /* renamed from: xT */
    public final C38492q mo73400xT() {
        return this.hwf;
    }

    public final JSONObject aCg() {
        return this.hwh;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: w */
    public final void mo73399w(Map<String, ? extends Object> map) {
        this.hwf.mo6107M(this.hwi, this.hwj.mo73394j("ok", map));
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: k */
    public final void mo73398k(String str, Map<String, ? extends Object> map) {
        this.hwf.mo6107M(this.hwi, this.hwj.mo73394j(str, map));
    }
}
