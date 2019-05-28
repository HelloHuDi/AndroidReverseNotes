package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class k extends c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateTextView";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126319);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126319);
        return i;
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126320);
        ab.d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof CoverViewContainer) {
            d dVar = (d) ((CoverViewContainer) view).ah(d.class);
            if (dVar == null) {
                ab.w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", Integer.valueOf(i));
            }
            b.a(dVar, jSONObject.optJSONObject("label"));
            com.tencent.mm.plugin.appbrand.jsapi.s.e.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            boolean c = super.c(eVar, i, view, jSONObject);
            AppMethodBeat.o(126320);
            return c;
        }
        ab.w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(126320);
        return false;
    }
}
