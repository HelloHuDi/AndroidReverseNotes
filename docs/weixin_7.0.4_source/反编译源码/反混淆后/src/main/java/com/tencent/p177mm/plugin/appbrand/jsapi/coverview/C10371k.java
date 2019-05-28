package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C33391e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38374b;
import com.tencent.p177mm.plugin.appbrand.widget.C42702d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.k */
public final class C10371k extends C45578c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateTextView";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126319);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126319);
        return i;
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126320);
        C4990ab.m7411d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof CoverViewContainer) {
            C42702d c42702d = (C42702d) ((CoverViewContainer) view).mo60996ah(C42702d.class);
            if (c42702d == null) {
                C4990ab.m7421w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", Integer.valueOf(i));
            }
            C38374b.m64945a(c42702d, jSONObject.optJSONObject("label"));
            C33391e.m54586b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            boolean c = super.mo6167c(c33303e, i, view, jSONObject);
            AppMethodBeat.m2505o(126320);
            return c;
        }
        C4990ab.m7421w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(126320);
        return false;
    }
}
