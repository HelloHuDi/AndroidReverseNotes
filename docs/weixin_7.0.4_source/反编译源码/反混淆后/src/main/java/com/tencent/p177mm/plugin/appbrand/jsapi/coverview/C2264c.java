package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C27074a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C33391e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38374b;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C16699a;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C31332b;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C38574e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.c */
public final class C2264c extends C45577a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.c$a */
    static class C2265a extends C42467ah {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onImageViewClick";

        private C2265a() {
        }

        /* synthetic */ C2265a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126295);
        Context context = c33303e.getContext();
        C16699a c16699a = null;
        if (C37384e.m62985B(C31332b.class) != null) {
            c16699a = ((C31332b) C37384e.m62985B(C31332b.class)).mo51296cU(context);
        }
        if (c16699a == null) {
            C4990ab.m7412e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
            c16699a = new C38574e(context);
        }
        c16699a.setScaleType(ScaleType.FIT_XY);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, c16699a.getView());
        AppMethodBeat.m2505o(126295);
        return coverViewContainer;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126296);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126296);
        return i;
    }

    /* renamed from: a */
    public final void mo6140a(final C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126297);
        C4990ab.m7411d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        C16699a c16699a = (C16699a) ((CoverViewContainer) view).mo60996ah(C16699a.class);
        if (c16699a == null) {
            C4990ab.m7421w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(126297);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("gesture");
        boolean optBoolean3 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        C33391e.m54586b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        C38374b.m64946a(c33303e, c16699a, jSONObject);
        C27074a.m43024a(c16699a.getView(), jSONObject);
        final C32800b J = c33303e.aBf().mo73439J(i, true);
        J.mo53356j("data", optString2);
        J.mo53356j("sendTo", optString);
        J.mo53356j("transEvt", Boolean.valueOf(optBoolean3));
        J.mo53356j("clickable", Boolean.valueOf(optBoolean));
        c16699a.getView().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(126293);
                if (J.mo53357nX("clickable")) {
                    C2265a c2265a = new C2265a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", J.getString("data", ""));
                    c2265a.mo34958t(hashMap);
                    c2265a.mo61032j(c33303e);
                    if ("webview".equals(J.getString("sendTo", null))) {
                        c33303e.mo6108a(c2265a);
                        AppMethodBeat.m2505o(126293);
                        return;
                    }
                    c33303e.mo6115b(c2265a);
                    AppMethodBeat.m2505o(126293);
                    return;
                }
                AppMethodBeat.m2505o(126293);
            }
        });
        c16699a.getView().setClickable(optBoolean);
        C4990ab.m7417i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2));
        if (!optBoolean && optBoolean2) {
            c16699a.getView().setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.m2504i(126294);
                    C33280a.m54434a(c33303e, motionEvent, J.getString("data", ""), "webview".equals(J.getString("sendTo", null)));
                    AppMethodBeat.m2505o(126294);
                    return true;
                }
            });
        }
        AppMethodBeat.m2505o(126297);
    }
}
