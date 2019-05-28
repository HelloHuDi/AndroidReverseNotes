package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.f */
public final class C19423f extends C41231b {
    private static final int CTRL_INDEX = 362;
    public static final String NAME = "removeLivePusher";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96118);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.m2505o(96118);
        return optInt;
    }

    /* renamed from: b */
    public final boolean mo22053b(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96119);
        super.mo22053b(c33303e, i, view, jSONObject);
        C4990ab.m7417i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 instanceof AppBrandLivePusherView) {
                ((AppBrandLivePusherView) view2).onExit();
                AppMethodBeat.m2505o(96119);
                return true;
            }
            C4990ab.m7412e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.m2505o(96119);
            return false;
        }
        C4990ab.m7421w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96119);
        return false;
    }
}
