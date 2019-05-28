package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends c {
    private static final int CTRL_INDEX = 331;
    public static final String NAME = "updateCamera";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126255);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.o(126255);
        return optInt;
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126256);
        ab.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 == null || !(view2 instanceof e)) {
                ab.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", Integer.valueOf(i));
                AppMethodBeat.o(126256);
                return false;
            }
            e eVar2 = (e) view2;
            int optInt = jSONObject.optInt("cameraId");
            String optString = jSONObject.optString("devicePosition", "back");
            String optString2 = jSONObject.optString("flash", "auto");
            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
            eVar2.setAppId(eVar.getAppId());
            eVar2.ai(optString, false);
            eVar2.setFlash(optString2);
            eVar2.setNeedOutput(optBoolean);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            int a = g.a(optJSONObject, "width", 0);
            int a2 = g.a(optJSONObject, "height", 0);
            ab.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a), Integer.valueOf(a2));
            boolean z = false;
            if (!(a == 0 || a2 == 0)) {
                z = eVar2.da(a, a2);
            }
            optString = jSONObject.optString("mode");
            if (!bo.isNullOrNil(optString)) {
                eVar2.setMode(optString);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                ab.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
                eVar2.w(g.qb(optJSONArray.optInt(0)), g.qb(optJSONArray.optInt(1)), g.qb(optJSONArray.optInt(2)), g.qb(optJSONArray.optInt(3)));
            }
            eVar2.setScanFreq(jSONObject.optInt("scanFreq"));
            if (z) {
                eVar2.release();
                eVar2.initView();
            } else {
                eVar2.aDf();
            }
            AppMethodBeat.o(126256);
            return true;
        }
        ab.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(126256);
        return false;
    }
}
