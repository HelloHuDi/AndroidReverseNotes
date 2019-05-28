package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.n */
public final class C38284n extends C45578c {
    private static final int CTRL_INDEX = 331;
    public static final String NAME = "updateCamera";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126255);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.m2505o(126255);
        return optInt;
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126256);
        C4990ab.m7417i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 == null || !(view2 instanceof C33272e)) {
                C4990ab.m7421w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", Integer.valueOf(i));
                AppMethodBeat.m2505o(126256);
                return false;
            }
            C33272e c33272e = (C33272e) view2;
            int optInt = jSONObject.optInt("cameraId");
            String optString = jSONObject.optString("devicePosition", "back");
            String optString2 = jSONObject.optString("flash", "auto");
            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
            c33272e.setAppId(c33303e.getAppId());
            c33272e.mo30612ai(optString, false);
            c33272e.setFlash(optString2);
            c33272e.setNeedOutput(optBoolean);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            int a = C42668g.m75555a(optJSONObject, "width", 0);
            int a2 = C42668g.m75555a(optJSONObject, "height", 0);
            C4990ab.m7411d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a), Integer.valueOf(a2));
            boolean z = false;
            if (!(a == 0 || a2 == 0)) {
                z = c33272e.mo30613da(a, a2);
            }
            optString = jSONObject.optString("mode");
            if (!C5046bo.isNullOrNil(optString)) {
                c33272e.setMode(optString);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                C4990ab.m7417i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
                c33272e.mo30630w(C42668g.m75571qb(optJSONArray.optInt(0)), C42668g.m75571qb(optJSONArray.optInt(1)), C42668g.m75571qb(optJSONArray.optInt(2)), C42668g.m75571qb(optJSONArray.optInt(3)));
            }
            c33272e.setScanFreq(jSONObject.optInt("scanFreq"));
            if (z) {
                c33272e.release();
                c33272e.initView();
            } else {
                c33272e.aDf();
            }
            AppMethodBeat.m2505o(126256);
            return true;
        }
        C4990ab.m7421w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(126256);
        return false;
    }
}
