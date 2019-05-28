package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class i extends c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateImageView";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126314);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126314);
        return i;
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126315);
        ab.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof CoverViewContainer) {
            a aVar = (a) ((CoverViewContainer) view).ah(a.class);
            if (aVar == null) {
                ab.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", Integer.valueOf(i));
                AppMethodBeat.o(126315);
                return false;
            }
            com.tencent.mm.plugin.appbrand.jsapi.s.e.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            b.a(eVar, aVar, jSONObject);
            boolean c = super.c(eVar, i, view, jSONObject);
            AppMethodBeat.o(126315);
            return c;
        }
        ab.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(126315);
        return false;
    }
}
