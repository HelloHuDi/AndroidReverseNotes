package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33319e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33320g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.q */
public final class C33324q extends C41231b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(93867);
        int B = C38303f.m64811B(jSONObject);
        AppMethodBeat.m2505o(93867);
        return B;
    }

    /* renamed from: b */
    public final boolean mo22053b(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(93868);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiRemoveMap", "data is null");
            AppMethodBeat.m2505o(93868);
            return false;
        }
        C33319e.m54490oq(6);
        if (C33320g.m54495ck(c33303e.getAppId(), C38303f.m64817g(c33303e, jSONObject))) {
            C33319e.m54490oq(7);
        } else {
            C33319e.m54490oq(8);
        }
        AppMethodBeat.m2505o(93868);
        return true;
    }
}
