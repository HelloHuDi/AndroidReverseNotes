package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        AppMethodBeat.i(131112);
        try {
            float f = bo.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = bo.getFloat(jSONObject.optString("longitude"), 0.0f);
            String Eh = e.Eh(jSONObject.optString("name"));
            String Eh2 = e.Eh(jSONObject.optString("address"));
            try {
                i2 = bo.getInt(jSONObject.optString(WMElement.ANIMATE_TYPE_SCALE), 0);
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
            Context context = cVar.getContext();
            if (context == null) {
                cVar.M(i, j("fail", null));
                AppMethodBeat.o(131112);
                return;
            }
            d.b(context, b.LOCATION, ".ui.RedirectUI", intent);
            cVar.M(i, j("ok", null));
            AppMethodBeat.o(131112);
        } catch (Exception e2) {
            cVar.M(i, j("invalid_coordinate", null));
            AppMethodBeat.o(131112);
        }
    }
}
