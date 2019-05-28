package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class f extends b {
    private static final int CTRL_INDEX = 362;
    public static final String NAME = "removeLivePusher";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96118);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.o(96118);
        return optInt;
    }

    public final boolean b(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(96119);
        super.b(eVar, i, view, jSONObject);
        ab.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 instanceof AppBrandLivePusherView) {
                ((AppBrandLivePusherView) view2).onExit();
                AppMethodBeat.o(96119);
                return true;
            }
            ab.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.o(96119);
            return false;
        }
        ab.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96119);
        return false;
    }
}
