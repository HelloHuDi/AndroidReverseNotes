package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33319e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33320g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a */
public abstract class C42517a extends C10296a {
    /* renamed from: a */
    public void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        C33319e.m54488Bj(getName());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo67989a(C2241c c2241c, int i, String str, boolean z, boolean z2) {
        c2241c.mo6107M(i, str);
        C33319e.m54489d(getName(), z, z2);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final C10406b mo67990f(C2241c c2241c, JSONObject jSONObject) {
        if (c2241c instanceof C33303e) {
            return C33320g.m54494cj(c2241c.getAppId(), C38303f.m64817g(c2241c, jSONObject));
        }
        if (c2241c.mo5936B(C10333f.class) == null) {
            C45124d.m82928e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", getName());
            return null;
        }
        C33303e c = ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
        if (c != null) {
            return C33320g.m54494cj(c.getAppId(), C38303f.m64817g(c, jSONObject));
        }
        C45124d.m82928e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", getName());
        return null;
    }
}
