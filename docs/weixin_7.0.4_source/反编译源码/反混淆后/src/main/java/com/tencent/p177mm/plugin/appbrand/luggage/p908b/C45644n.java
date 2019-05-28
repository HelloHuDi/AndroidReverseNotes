package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.content.Context;
import com.tencent.luggage.p815f.p816a.C8868b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.C38388b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.n */
public final class C45644n extends C8868b {
    public static Integer ikm;

    private static int getMapType() {
        AppMethodBeat.m2504i(132110);
        int intValue;
        if (ikm != null) {
            intValue = ikm.intValue();
            AppMethodBeat.m2505o(132110);
            return intValue;
        }
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100487");
        if (ll == null || !ll.isValid()) {
            C4990ab.m7416i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
            AppMethodBeat.m2505o(132110);
            return 1;
        }
        ikm = Integer.valueOf(C5046bo.getInt((String) ll.dru().get("MapType"), 1));
        C4990ab.m7417i("MicroMsg.WxaMapViewFactory", "sMapType:%d", ikm);
        intValue = ikm.intValue();
        AppMethodBeat.m2505o(132110);
        return intValue;
    }

    /* renamed from: a */
    public final C10406b mo20061a(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(132111);
        if (jSONObject != null) {
            try {
                jSONObject.put("mapType", C45644n.getMapType());
            } catch (JSONException e) {
                C4990ab.m7409c("MicroMsg.WxaMapViewFactory", "", e);
            }
        }
        C10406b a = super.mo20061a(c2241c, jSONObject);
        AppMethodBeat.m2505o(132111);
        return a;
    }

    /* renamed from: a */
    public final C10406b mo20060a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.m2504i(132112);
        C10406b c38388b;
        if (context == null) {
            AppMethodBeat.m2505o(132112);
            return null;
        } else if (C38303f.m64812a((Map) map, "mapType", C45644n.getMapType()) == 2) {
            c38388b = new C38388b(context, str, map);
            AppMethodBeat.m2505o(132112);
            return c38388b;
        } else {
            c38388b = super.mo20060a(context, str, map);
            AppMethodBeat.m2505o(132112);
            return c38388b;
        }
    }
}
