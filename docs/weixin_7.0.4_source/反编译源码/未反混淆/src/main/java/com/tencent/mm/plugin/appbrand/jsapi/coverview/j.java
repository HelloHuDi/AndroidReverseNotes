package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends c {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126317);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.o(126317);
        return i;
    }

    public final boolean c(final e eVar, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126318);
        ab.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof WxaScrollView) {
            WxaScrollView wxaScrollView = (WxaScrollView) view;
            com.tencent.mm.plugin.appbrand.jsapi.s.e.b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            try {
                if (jSONObject.getBoolean("needScrollEvent")) {
                    wxaScrollView.setOnScrollChangedListener(new m() {
                        public final void p(View view, int i, int i2) {
                            AppMethodBeat.i(126316);
                            if (view instanceof WxaScrollView) {
                                b J = eVar.aBf().J(i, false);
                                if (J == null) {
                                    AppMethodBeat.o(126316);
                                    return;
                                }
                                String string = J.getString("data", null);
                                if (string == null) {
                                    AppMethodBeat.o(126316);
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
                                AppMethodBeat.o(126316);
                                return;
                            }
                            AppMethodBeat.o(126316);
                        }
                    });
                } else {
                    wxaScrollView.setOnScrollChangedListener(null);
                }
            } catch (JSONException e) {
            }
            jSONObject.optInt("scrollLeft", 0);
            if (jSONObject.has("scrollX")) {
                ab.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", Boolean.valueOf(jSONObject.optBoolean("scrollX", true)));
                wxaScrollView.setScrollHorizontal(r2);
            }
            if (jSONObject.has("scrollY")) {
                ab.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", Boolean.valueOf(jSONObject.optBoolean("scrollY", true)));
                wxaScrollView.setScrollVertical(r2);
            }
            if (jSONObject.has("scrollTop")) {
                ab.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", Integer.valueOf(g.a(jSONObject, "scrollTop", wxaScrollView.getScrollY())));
                wxaScrollView.scrollTo(wxaScrollView.getScrollX(), r2);
            }
            boolean c = super.c(eVar, i, view, jSONObject);
            AppMethodBeat.o(126318);
            return c;
        }
        ab.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", Integer.valueOf(i));
        AppMethodBeat.o(126318);
        return false;
    }
}
