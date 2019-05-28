package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 446;
    public static final String NAME = "insertScrollView";

    public final View a(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(126300);
        WxaScrollView wxaScrollView = new WxaScrollView(eVar.getContext());
        AppMethodBeat.o(126300);
        return wxaScrollView;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126301);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126301);
        return i;
    }

    public final void a(final e eVar, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126302);
        ab.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        final WxaScrollView wxaScrollView = (WxaScrollView) view;
        boolean optBoolean = jSONObject.optBoolean("needScrollEvent");
        String optString = jSONObject.optString("data", "");
        com.tencent.mm.plugin.appbrand.jsapi.s.e.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        eVar.aBf().J(i, true).j("data", optString);
        if (optBoolean) {
            wxaScrollView.setOnScrollChangedListener(new m() {
                public final void p(View view, int i, int i2) {
                    AppMethodBeat.i(126298);
                    if (view instanceof WxaScrollView) {
                        b J = eVar.aBf().J(i, false);
                        if (J == null) {
                            AppMethodBeat.o(126298);
                            return;
                        }
                        String string = J.getString("data", null);
                        if (string == null) {
                            AppMethodBeat.o(126298);
                            return;
                        }
                        ViewGroup targetView = ((WxaScrollView) view).getTargetView();
                        HashMap hashMap = new HashMap();
                        hashMap.put("data", string);
                        hashMap.put("scrollLeft", Integer.valueOf(g.qa(i)));
                        hashMap.put("scrollTop", Integer.valueOf(g.qa(i2)));
                        hashMap.put("scrollWidth", Integer.valueOf(g.qa(targetView.getWidth())));
                        hashMap.put("scrollHeight", Integer.valueOf(g.qa(targetView.getHeight())));
                        eVar.b(new l().t(hashMap));
                        AppMethodBeat.o(126298);
                        return;
                    }
                    AppMethodBeat.o(126298);
                }
            });
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            ab.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", Boolean.valueOf(jSONObject.optBoolean("scrollX", true)));
            wxaScrollView.setScrollHorizontal(optBoolean);
        }
        if (jSONObject.has("scrollY")) {
            ab.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", Boolean.valueOf(jSONObject.optBoolean("scrollY", true)));
            wxaScrollView.setScrollVertical(optBoolean);
        }
        if (jSONObject.has("scrollTop")) {
            final int a = g.a(jSONObject, "scrollTop", wxaScrollView.getScrollY());
            ab.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", Integer.valueOf(a));
            wxaScrollView.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126299);
                    wxaScrollView.scrollTo(wxaScrollView.getScrollX(), a);
                    AppMethodBeat.o(126299);
                }
            }, 100);
        }
        AppMethodBeat.o(126302);
    }
}
