package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.j */
public final class C2278j extends C10296a {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(131112);
        try {
            float f = C5046bo.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = C5046bo.getFloat(jSONObject.optString("longitude"), 0.0f);
            String Eh = C42677e.m75577Eh(jSONObject.optString("name"));
            String Eh2 = C42677e.m75577Eh(jSONObject.optString("address"));
            try {
                i2 = C5046bo.getInt(jSONObject.optString(WMElement.ANIMATE_TYPE_SCALE), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 7);
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i2 > 0) {
                intent.putExtra("kwebmap_scale", i2);
            }
            intent.putExtra("kPoiName", Eh);
            intent.putExtra("Kwebmap_locaion", Eh2);
            Context context = c2241c.getContext();
            if (context == null) {
                c2241c.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(131112);
                return;
            }
            C25985d.m41467b(context, C8741b.LOCATION, ".ui.RedirectUI", intent);
            c2241c.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(131112);
        } catch (Exception e2) {
            c2241c.mo6107M(i, mo73394j("invalid_coordinate", null));
            AppMethodBeat.m2505o(131112);
        }
    }
}
