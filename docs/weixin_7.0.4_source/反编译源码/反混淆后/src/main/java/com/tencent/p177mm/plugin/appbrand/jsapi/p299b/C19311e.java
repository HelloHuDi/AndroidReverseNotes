package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26932g;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.e */
public class C19311e extends C45578c<C33303e> {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103851);
        int i = jSONObject.getInt("canvasId");
        AppMethodBeat.m2505o(103851);
        return i;
    }

    /* renamed from: b */
    public final boolean mo6138b(C33303e c33303e, int i, View view, JSONObject jSONObject, final C26932g c26932g) {
        AppMethodBeat.m2504i(103852);
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            C4990ab.m7411d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", Integer.valueOf(i));
            if (view2 instanceof C10164a) {
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray optJSONArray = jSONObject.optJSONArray("actions");
                C10164a c10164a = (C10164a) view2;
                if (jSONObject.optBoolean("reserve")) {
                    c10164a.mo21539b(optJSONArray, new C10165a() {
                        /* renamed from: a */
                        public final void mo6094a(DrawCanvasArg drawCanvasArg) {
                            AppMethodBeat.m2504i(103849);
                            c26932g.mo44674AR(C19311e.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(103849);
                        }
                    });
                } else {
                    c10164a.mo21535a(optJSONArray, new C10165a() {
                        /* renamed from: a */
                        public final void mo6094a(DrawCanvasArg drawCanvasArg) {
                            AppMethodBeat.m2504i(103850);
                            c26932g.mo44674AR(C19311e.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(103850);
                        }
                    });
                }
                c10164a.ayc();
                C4990ab.m7419v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                boolean b = super.mo6138b(c33303e, i, view, jSONObject, c26932g);
                AppMethodBeat.m2505o(103852);
                return b;
            }
            C4990ab.m7417i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", Integer.valueOf(i));
            AppMethodBeat.m2505o(103852);
            return false;
        }
        C4990ab.m7417i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", Integer.valueOf(i));
        AppMethodBeat.m2505o(103852);
        return false;
    }

    public final boolean aCE() {
        return true;
    }
}
