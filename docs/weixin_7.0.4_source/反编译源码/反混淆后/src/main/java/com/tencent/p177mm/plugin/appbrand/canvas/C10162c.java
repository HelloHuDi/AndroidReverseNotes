package com.tencent.p177mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C10155d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C16585ak;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C16591b;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C16592c;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C16593j;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C16594z;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19134aa;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19135ab;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19136ac;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19137ai;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19148l;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19149r;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C19150u;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C2091a;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C26802ad;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C26803aj;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C26816i;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C26817k;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C26818s;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C26819t;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C38141ag;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C38147f;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C38148h;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C38149o;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C38150v;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C38151x;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C42389ae;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C42390af;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C42395g;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C42396m;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C42397p;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C42398q;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C45526ah;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C45528e;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C45529n;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C45530w;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C45531y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.c */
public final class C10162c {
    public Map<String, C10155d> hcD = new HashMap();

    public C10162c() {
        AppMethodBeat.m2504i(103162);
        m17780a(new C42389ae());
        m17780a(new C42398q());
        m17780a(new C42390af());
        m17780a(new C38150v());
        m17780a(new C26817k());
        m17780a(new C2091a());
        m17780a(new C38148h());
        m17780a(new C45528e());
        m17780a(new C19148l());
        m17780a(new C26816i());
        m17780a(new C38147f());
        m17780a(new C26802ad());
        m17780a(new C16593j());
        m17780a(new C42395g());
        m17780a(new C16592c());
        m17780a(new C16591b());
        m17780a(new C38141ag());
        m17780a(new C45526ah());
        m17780a(new C38151x());
        m17780a(new C19134aa());
        m17780a(new C19135ab());
        m17780a(new C19136ac());
        m17780a(new C26818s());
        m17780a(new C45531y());
        m17780a(new C26819t());
        m17780a(new C19150u());
        m17780a(new C19149r());
        m17780a(new C16594z());
        m17780a(new C19137ai());
        m17780a(new C45530w());
        m17780a(new C42397p());
        m17780a(new C45529n());
        m17780a(new C16585ak());
        m17780a(new C38149o());
        m17780a(new C42396m());
        m17780a(new C26803aj());
        AppMethodBeat.m2505o(103162);
    }

    /* renamed from: a */
    public final boolean mo21531a(C2102d c2102d, Canvas canvas, JSONObject jSONObject) {
        AppMethodBeat.m2504i(103163);
        String optString = jSONObject.optString(C8741b.METHOD);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        C10155d c10155d = (C10155d) this.hcD.get(optString);
        if (c10155d == null) {
            AppMethodBeat.m2505o(103163);
            return false;
        }
        boolean a = c10155d.mo5873a(c2102d, canvas, optJSONArray);
        AppMethodBeat.m2505o(103163);
        return a;
    }

    /* renamed from: a */
    private void m17780a(C10155d c10155d) {
        AppMethodBeat.m2504i(103164);
        this.hcD.put(c10155d.getMethod(), c10155d);
        AppMethodBeat.m2505o(103164);
    }
}
