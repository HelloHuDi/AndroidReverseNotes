package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C33391e;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.j */
public final class C26963j extends C45578c {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126317);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126317);
        return i;
    }

    /* renamed from: c */
    public final boolean mo6167c(final C33303e c33303e, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126318);
        C4990ab.m7411d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof WxaScrollView) {
            WxaScrollView wxaScrollView = (WxaScrollView) view;
            C33391e.m54586b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            try {
                if (jSONObject.getBoolean("needScrollEvent")) {
                    wxaScrollView.setOnScrollChangedListener(new C42491m() {
                        /* renamed from: p */
                        public final void mo44686p(View view, int i, int i2) {
                            AppMethodBeat.m2504i(126316);
                            if (view instanceof WxaScrollView) {
                                C32800b J = c33303e.aBf().mo73439J(i, false);
                                if (J == null) {
                                    AppMethodBeat.m2505o(126316);
                                    return;
                                }
                                String string = J.getString("data", null);
                                if (string == null) {
                                    AppMethodBeat.m2505o(126316);
                                    return;
                                }
                                ViewGroup targetView = ((WxaScrollView) view).getTargetView();
                                HashMap hashMap = new HashMap();
                                hashMap.put("data", string);
                                hashMap.put("scrollLeft", Integer.valueOf(C42668g.m75570qa(i)));
                                hashMap.put("scrollTop", Integer.valueOf(C42668g.m75570qa(i2)));
                                hashMap.put("scrollWidth", Integer.valueOf(C42668g.m75570qa(targetView.getWidth())));
                                hashMap.put("scrollHeight", Integer.valueOf(C42668g.m75570qa(targetView.getHeight())));
                                c33303e.mo6115b(new C45591l().mo34958t(hashMap));
                                AppMethodBeat.m2505o(126316);
                                return;
                            }
                            AppMethodBeat.m2505o(126316);
                        }
                    });
                } else {
                    wxaScrollView.setOnScrollChangedListener(null);
                }
            } catch (JSONException e) {
            }
            jSONObject.optInt("scrollLeft", 0);
            if (jSONObject.has("scrollX")) {
                C4990ab.m7417i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", Boolean.valueOf(jSONObject.optBoolean("scrollX", true)));
                wxaScrollView.setScrollHorizontal(r2);
            }
            if (jSONObject.has("scrollY")) {
                C4990ab.m7417i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", Boolean.valueOf(jSONObject.optBoolean("scrollY", true)));
                wxaScrollView.setScrollVertical(r2);
            }
            if (jSONObject.has("scrollTop")) {
                C4990ab.m7417i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", Integer.valueOf(C42668g.m75555a(jSONObject, "scrollTop", wxaScrollView.getScrollY())));
                wxaScrollView.scrollTo(wxaScrollView.getScrollX(), r2);
            }
            boolean c = super.mo6167c(c33303e, i, view, jSONObject);
            AppMethodBeat.m2505o(126318);
            return c;
        }
        C4990ab.m7421w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", Integer.valueOf(i));
        AppMethodBeat.m2505o(126318);
        return false;
    }
}
