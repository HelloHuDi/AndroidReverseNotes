package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C33391e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38374b;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C16699a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.i */
public final class C19356i extends C45578c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateImageView";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126314);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126314);
        return i;
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126315);
        C4990ab.m7411d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof CoverViewContainer) {
            C16699a c16699a = (C16699a) ((CoverViewContainer) view).mo60996ah(C16699a.class);
            if (c16699a == null) {
                C4990ab.m7421w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", Integer.valueOf(i));
                AppMethodBeat.m2505o(126315);
                return false;
            }
            C33391e.m54586b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            C38374b.m64946a(c33303e, c16699a, jSONObject);
            boolean c = super.mo6167c(c33303e, i, view, jSONObject);
            AppMethodBeat.m2505o(126315);
            return c;
        }
        C4990ab.m7421w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(126315);
        return false;
    }
}
