package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C33391e;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.d */
public final class C33281d extends C45577a {
    private static final int CTRL_INDEX = 446;
    public static final String NAME = "insertScrollView";

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126300);
        WxaScrollView wxaScrollView = new WxaScrollView(c33303e.getContext());
        AppMethodBeat.m2505o(126300);
        return wxaScrollView;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126301);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126301);
        return i;
    }

    /* renamed from: a */
    public final void mo6140a(final C33303e c33303e, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126302);
        C4990ab.m7411d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        final WxaScrollView wxaScrollView = (WxaScrollView) view;
        boolean optBoolean = jSONObject.optBoolean("needScrollEvent");
        String optString = jSONObject.optString("data", "");
        C33391e.m54586b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        c33303e.aBf().mo73439J(i, true).mo53356j("data", optString);
        if (optBoolean) {
            wxaScrollView.setOnScrollChangedListener(new C42491m() {
                /* renamed from: p */
                public final void mo44686p(View view, int i, int i2) {
                    AppMethodBeat.m2504i(126298);
                    if (view instanceof WxaScrollView) {
                        C32800b J = c33303e.aBf().mo73439J(i, false);
                        if (J == null) {
                            AppMethodBeat.m2505o(126298);
                            return;
                        }
                        String string = J.getString("data", null);
                        if (string == null) {
                            AppMethodBeat.m2505o(126298);
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
                        AppMethodBeat.m2505o(126298);
                        return;
                    }
                    AppMethodBeat.m2505o(126298);
                }
            });
        }
        jSONObject.optInt("scrollLeft", 0);
        if (jSONObject.has("scrollX")) {
            C4990ab.m7417i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", Boolean.valueOf(jSONObject.optBoolean("scrollX", true)));
            wxaScrollView.setScrollHorizontal(optBoolean);
        }
        if (jSONObject.has("scrollY")) {
            C4990ab.m7417i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", Boolean.valueOf(jSONObject.optBoolean("scrollY", true)));
            wxaScrollView.setScrollVertical(optBoolean);
        }
        if (jSONObject.has("scrollTop")) {
            final int a = C42668g.m75555a(jSONObject, "scrollTop", wxaScrollView.getScrollY());
            C4990ab.m7417i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", Integer.valueOf(a));
            wxaScrollView.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(126299);
                    wxaScrollView.scrollTo(wxaScrollView.getScrollX(), a);
                    AppMethodBeat.m2505o(126299);
                }
            }, 100);
        }
        AppMethodBeat.m2505o(126302);
    }
}
