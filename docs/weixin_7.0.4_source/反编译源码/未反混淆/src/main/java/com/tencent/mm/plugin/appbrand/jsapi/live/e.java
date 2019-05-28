package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e extends b {
    private static final int CTRL_INDEX = 366;
    public static final String NAME = "removeLivePlayer";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96116);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.o(96116);
        return optInt;
    }

    public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(96117);
        super.b(eVar, i, view, jSONObject);
        ab.i("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 instanceof AppBrandLivePlayerView) {
                ((AppBrandLivePlayerView) view2).onExit();
                AppMethodBeat.o(96117);
                return true;
            }
            ab.e("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.o(96117);
            return false;
        }
        ab.w("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96117);
        return false;
    }
}
