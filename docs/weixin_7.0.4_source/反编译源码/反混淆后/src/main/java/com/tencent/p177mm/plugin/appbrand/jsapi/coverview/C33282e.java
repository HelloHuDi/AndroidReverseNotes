package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C27074a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C33391e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38374b;
import com.tencent.p177mm.plugin.appbrand.widget.C42702d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.e */
public final class C33282e extends C45577a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.e$a */
    static class C33283a extends C42467ah {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onTextViewClick";

        private C33283a() {
        }

        /* synthetic */ C33283a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126305);
        Context context = c33303e.getContext();
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, new C42702d(context));
        AppMethodBeat.m2505o(126305);
        return coverViewContainer;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126306);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126306);
        return i;
    }

    /* renamed from: a */
    public final void mo6140a(final C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126307);
        C4990ab.m7411d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        C42702d c42702d = (C42702d) ((CoverViewContainer) view).mo60996ah(C42702d.class);
        if (c42702d == null) {
            C4990ab.m7421w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(126307);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        boolean optBoolean3 = jSONObject.optBoolean("gesture");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString("data", "");
        C38374b.m64945a(c42702d, jSONObject.optJSONObject("label"));
        C27074a.m43024a(c42702d, jSONObject);
        C33391e.m54586b(view, jSONObject.optJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
        final C32800b J = c33303e.aBf().mo73439J(i, true);
        J.mo53356j("data", optString2);
        J.mo53356j("sendTo", optString);
        J.mo53356j("transEvt", Boolean.valueOf(optBoolean2));
        J.mo53356j("clickable", Boolean.valueOf(optBoolean));
        c42702d.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(126303);
                if (J.mo53357nX("clickable")) {
                    C33283a c33283a = new C33283a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", J.getString("data", ""));
                    c33283a.mo34958t(hashMap);
                    if ("webview".equals(J.getString("sendTo", null))) {
                        c33303e.mo6108a(c33283a);
                        AppMethodBeat.m2505o(126303);
                        return;
                    }
                    c33303e.mo6115b(c33283a);
                    AppMethodBeat.m2505o(126303);
                    return;
                }
                AppMethodBeat.m2505o(126303);
            }
        });
        c42702d.setClickable(optBoolean);
        C4990ab.m7417i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean3));
        if (!optBoolean && optBoolean3) {
            c42702d.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.m2504i(126304);
                    C33280a.m54434a(c33303e, motionEvent, J.getString("data", ""), "webview".equals(J.getString("sendTo", null)));
                    AppMethodBeat.m2505o(126304);
                    return true;
                }
            });
        }
        AppMethodBeat.m2505o(126307);
    }
}
