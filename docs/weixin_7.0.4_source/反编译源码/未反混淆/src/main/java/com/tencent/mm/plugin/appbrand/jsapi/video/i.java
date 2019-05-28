package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class i extends b {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126566);
        int optInt = jSONObject.optInt("videoPlayerId", 0);
        AppMethodBeat.o(126566);
        return optInt;
    }

    public final boolean b(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126567);
        ab.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).ah(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                ab.w("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView not AppBrandVideoView");
                AppMethodBeat.o(126567);
                return false;
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126565);
                    appBrandVideoView.clean();
                    AppMethodBeat.o(126565);
                }
            });
            super.b(eVar, i, view, jSONObject);
            AppMethodBeat.o(126567);
            return true;
        }
        ab.w("MicroMsg.JsApiRemoveVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(126567);
        return false;
    }
}
