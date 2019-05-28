package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33159d;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C10204a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C45542b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26863d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19311e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b */
public final class C45543b extends C10200a {
    public C45543b(int i) {
        super(C19311e.NAME, i);
    }

    /* renamed from: a */
    public final void mo21611a(C36405a c36405a, JSONObject jSONObject, Bundle bundle, C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10828);
        C2107c.m4312bD(C26863d.m42788o(jSONObject), "before_jsapi_invoke");
        C32800b Qy = c36405a.mo11733Qy();
        String string = Qy.getString("__page_view_id", null);
        String string2 = Qy.getString("__process_name", C4996ah.getProcessName());
        int i = Qy.getInt("__draw_strategy", 0);
        if (C33159d.azy().mo53689zR(string) == null) {
            C4990ab.m7421w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", string);
            c16115a.mo11732au(mo57327a(false, "got 'null' when get view by the given viewId", null));
            AppMethodBeat.m2505o(10828);
            return;
        }
        C45542b c45542b = new C45542b();
        c45542b.mo73354a(string2, string, jSONObject, this, c16115a, C10204a.m17844bb(string, i), bundle != null ? bundle.getString("rawJsapiData") : System.currentTimeMillis());
        C10204a.m17844bb(string, i).mo21614a(c45542b);
        AppMethodBeat.m2505o(10828);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, C16115a<JSONObject> c16115a) {
    }
}
