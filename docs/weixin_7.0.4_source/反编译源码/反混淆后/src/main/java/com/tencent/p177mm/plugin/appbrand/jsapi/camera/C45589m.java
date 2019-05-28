package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.m */
public final class C45589m extends C41231b {
    private static final int CTRL_INDEX = 330;
    public static final String NAME = "removeCamera";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126253);
        int optInt = jSONObject.optInt("cameraId", 0);
        AppMethodBeat.m2505o(126253);
        return optInt;
    }

    /* renamed from: b */
    public final boolean mo22053b(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126254);
        super.mo22053b(c33303e, i, view, jSONObject);
        C4990ab.m7417i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 == null || !(view2 instanceof C33272e)) {
                C4990ab.m7421w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", Integer.valueOf(i));
                AppMethodBeat.m2505o(126254);
                return false;
            }
            C33272e c33272e = (C33272e) view2;
            c33303e.mo53834b((C10381d) c33272e);
            c33303e.mo53832b((C10379b) c33272e);
            c33303e.mo53833b((C10380c) c33272e);
            c33272e.release();
            AppMethodBeat.m2505o(126254);
            return true;
        }
        C4990ab.m7421w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(126254);
        return false;
    }
}
