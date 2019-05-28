package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends c<com.tencent.mm.plugin.appbrand.jsapi.e> {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(103851);
        int i = jSONObject.getInt("canvasId");
        AppMethodBeat.o(103851);
        return i;
    }

    public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e eVar, int i, View view, JSONObject jSONObject, final g gVar) {
        AppMethodBeat.i(103852);
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            ab.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", Integer.valueOf(i));
            if (view2 instanceof a) {
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray optJSONArray = jSONObject.optJSONArray("actions");
                a aVar = (a) view2;
                if (jSONObject.optBoolean("reserve")) {
                    aVar.b(optJSONArray, new a.a() {
                        public final void a(DrawCanvasArg drawCanvasArg) {
                            AppMethodBeat.i(103849);
                            gVar.AR(e.this.j("ok", null));
                            AppMethodBeat.o(103849);
                        }
                    });
                } else {
                    aVar.a(optJSONArray, new a.a() {
                        public final void a(DrawCanvasArg drawCanvasArg) {
                            AppMethodBeat.i(103850);
                            gVar.AR(e.this.j("ok", null));
                            AppMethodBeat.o(103850);
                        }
                    });
                }
                aVar.ayc();
                ab.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                boolean b = super.b(eVar, i, view, jSONObject, gVar);
                AppMethodBeat.o(103852);
                return b;
            }
            ab.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", Integer.valueOf(i));
            AppMethodBeat.o(103852);
            return false;
        }
        ab.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", Integer.valueOf(i));
        AppMethodBeat.o(103852);
        return false;
    }

    public final boolean aCE() {
        return true;
    }
}
