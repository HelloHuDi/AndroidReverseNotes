package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    static class a extends ah {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onImageViewClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final View a(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(126295);
        Context context = eVar.getContext();
        com.tencent.mm.plugin.appbrand.widget.c.a aVar = null;
        if (com.tencent.luggage.a.e.B(b.class) != null) {
            aVar = ((b) com.tencent.luggage.a.e.B(b.class)).cU(context);
        }
        if (aVar == null) {
            ab.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
            aVar = new com.tencent.mm.plugin.appbrand.widget.c.e(context);
        }
        aVar.setScaleType(ScaleType.FIT_XY);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, aVar.getView());
        AppMethodBeat.o(126295);
        return coverViewContainer;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126296);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126296);
        return i;
    }

    public final void a(final e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126297);
        ab.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        com.tencent.mm.plugin.appbrand.widget.c.a aVar = (com.tencent.mm.plugin.appbrand.widget.c.a) ((CoverViewContainer) view).ah(com.tencent.mm.plugin.appbrand.widget.c.a.class);
        if (aVar == null) {
            ab.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i));
            AppMethodBeat.o(126297);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("gesture");
        boolean optBoolean3 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        com.tencent.mm.plugin.appbrand.jsapi.s.e.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        com.tencent.mm.plugin.appbrand.jsapi.s.b.a(eVar, aVar, jSONObject);
        com.tencent.mm.plugin.appbrand.jsapi.s.a.a(aVar.getView(), jSONObject);
        final v.b J = eVar.aBf().J(i, true);
        J.j("data", optString2);
        J.j("sendTo", optString);
        J.j("transEvt", Boolean.valueOf(optBoolean3));
        J.j("clickable", Boolean.valueOf(optBoolean));
        aVar.getView().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126293);
                if (J.nX("clickable")) {
                    a aVar = new a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", J.getString("data", ""));
                    aVar.t(hashMap);
                    aVar.j(eVar);
                    if ("webview".equals(J.getString("sendTo", null))) {
                        eVar.a(aVar);
                        AppMethodBeat.o(126293);
                        return;
                    }
                    eVar.b(aVar);
                    AppMethodBeat.o(126293);
                    return;
                }
                AppMethodBeat.o(126293);
            }
        });
        aVar.getView().setClickable(optBoolean);
        ab.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2));
        if (!optBoolean && optBoolean2) {
            aVar.getView().setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(126294);
                    a.a(eVar, motionEvent, J.getString("data", ""), "webview".equals(J.getString("sendTo", null)));
                    AppMethodBeat.o(126294);
                    return true;
                }
            });
        }
        AppMethodBeat.o(126297);
    }
}
