package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    static class a extends ah {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onTextViewClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final View a(com.tencent.mm.plugin.appbrand.jsapi.e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(126305);
        Context context = eVar.getContext();
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, new d(context));
        AppMethodBeat.o(126305);
        return coverViewContainer;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126306);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126306);
        return i;
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126307);
        ab.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        d dVar = (d) ((CoverViewContainer) view).ah(d.class);
        if (dVar == null) {
            ab.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i));
            AppMethodBeat.o(126307);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        boolean optBoolean3 = jSONObject.optBoolean("gesture");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        b.a(dVar, jSONObject.optJSONObject("label"));
        com.tencent.mm.plugin.appbrand.jsapi.s.a.a(dVar, jSONObject);
        com.tencent.mm.plugin.appbrand.jsapi.s.e.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        final v.b J = eVar.aBf().J(i, true);
        J.j("data", optString2);
        J.j("sendTo", optString);
        J.j("transEvt", Boolean.valueOf(optBoolean2));
        J.j("clickable", Boolean.valueOf(optBoolean));
        dVar.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126303);
                if (J.nX("clickable")) {
                    a aVar = new a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", J.getString("data", ""));
                    aVar.t(hashMap);
                    if ("webview".equals(J.getString("sendTo", null))) {
                        eVar.a(aVar);
                        AppMethodBeat.o(126303);
                        return;
                    }
                    eVar.b(aVar);
                    AppMethodBeat.o(126303);
                    return;
                }
                AppMethodBeat.o(126303);
            }
        });
        dVar.setClickable(optBoolean);
        ab.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean3));
        if (!optBoolean && optBoolean3) {
            dVar.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(126304);
                    a.a(eVar, motionEvent, J.getString("data", ""), "webview".equals(J.getString("sendTo", null)));
                    AppMethodBeat.o(126304);
                    return true;
                }
            });
        }
        AppMethodBeat.o(126307);
    }
}
