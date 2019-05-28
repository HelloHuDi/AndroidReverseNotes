package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.i */
public final class C10557i extends C41231b {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126566);
        int optInt = jSONObject.optInt("videoPlayerId", 0);
        AppMethodBeat.m2505o(126566);
        return optInt;
    }

    /* renamed from: b */
    public final boolean mo22053b(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126567);
        C4990ab.m7417i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).mo60996ah(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                C4990ab.m7420w("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView not AppBrandVideoView");
                AppMethodBeat.m2505o(126567);
                return false;
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(126565);
                    appBrandVideoView.clean();
                    AppMethodBeat.m2505o(126565);
                }
            });
            super.mo22053b(c33303e, i, view, jSONObject);
            AppMethodBeat.m2505o(126567);
            return true;
        }
        C4990ab.m7421w("MicroMsg.JsApiRemoveVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(126567);
        return false;
    }
}
