package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.e */
public final class C27021e extends C41231b {
    private static final int CTRL_INDEX = 366;
    public static final String NAME = "removeLivePlayer";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96116);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.m2505o(96116);
        return optInt;
    }

    /* renamed from: b */
    public final boolean mo22053b(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96117);
        super.mo22053b(c33303e, i, view, jSONObject);
        C4990ab.m7417i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 instanceof AppBrandLivePlayerView) {
                ((AppBrandLivePlayerView) view2).onExit();
                AppMethodBeat.m2505o(96117);
                return true;
            }
            C4990ab.m7412e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.m2505o(96117);
            return false;
        }
        C4990ab.m7421w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96117);
        return false;
    }
}
