package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class m extends b {
    private static final int CTRL_INDEX = 330;
    public static final String NAME = "removeCamera";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126253);
        int optInt = jSONObject.optInt("cameraId", 0);
        AppMethodBeat.o(126253);
        return optInt;
    }

    public final boolean b(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126254);
        super.b(eVar, i, view, jSONObject);
        ab.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 == null || !(view2 instanceof e)) {
                ab.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", Integer.valueOf(i));
                AppMethodBeat.o(126254);
                return false;
            }
            e eVar2 = (e) view2;
            eVar.b((d) eVar2);
            eVar.b((f.b) eVar2);
            eVar.b((c) eVar2);
            eVar2.release();
            AppMethodBeat.o(126254);
            return true;
        }
        ab.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(126254);
        return false;
    }
}
