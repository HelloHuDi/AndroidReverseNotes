package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10412d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33319e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33320g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.v */
public final class C2292v extends C45578c {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(93880);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.m2505o(93880);
            return optInt;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", e);
            AppMethodBeat.m2505o(93880);
            return -1;
        }
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(93881);
        C33319e.m54490oq(3);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiUpdateMap", "data is null");
            AppMethodBeat.m2505o(93881);
            return false;
        }
        String b;
        C4990ab.m7417i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", c33303e.getAppId(), Integer.valueOf(i), jSONObject);
        C10406b cj = C33320g.m54494cj(b, C38303f.m64817g(c33303e, jSONObject));
        if (cj == null) {
            C4990ab.m7412e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
            AppMethodBeat.m2505o(93881);
            return false;
        }
        float f;
        if (jSONObject.has(WMElement.ANIMATE_TYPE_SCALE)) {
            cj.mo21910al((float) jSONObject.optDouble(WMElement.ANIMATE_TYPE_SCALE, 16.0d));
        }
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            cj.mo21911am((float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
        }
        if (jSONObject.has("skew")) {
            cj.mo21912an((float) jSONObject.optDouble("skew", 0.0d));
        }
        if (jSONObject.has("centerLatitude")) {
            if (jSONObject.has("centerLongitude")) {
                float f2 = C5046bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                f = C5046bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                if (Math.abs(f2) <= 90.0f && Math.abs(f) <= 180.0f) {
                    cj.mo21882I(f2, f);
                }
            }
        }
        if (jSONObject.has("enableZoom")) {
            cj.mo21914ed(jSONObject.optBoolean("enableZoom", true));
        }
        if (jSONObject.has("enableScroll")) {
            cj.mo21915ee(jSONObject.optBoolean("enableScroll", true));
        }
        if (jSONObject.has("enableRotate")) {
            cj.mo21916ef(jSONObject.optBoolean("enableRotate", true));
        }
        if (jSONObject.has("showCompass")) {
            cj.mo21917eg(jSONObject.optBoolean("showCompass", false));
        }
        if (jSONObject.has("enable3D")) {
            cj.mo21918eh(jSONObject.optBoolean("enable3D", false));
        }
        if (jSONObject.has("enableOverlooking")) {
            cj.mo21919ei(jSONObject.optBoolean("enableOverlooking", false));
        }
        if (jSONObject.has("enableSatellite")) {
            cj.mo21920ej(jSONObject.optBoolean("enableSatellite", false));
        }
        if (jSONObject.has("enableTraffic")) {
            cj.mo21921ek(jSONObject.optBoolean("enableTraffic", false));
        }
        if (jSONObject.has("enableIndoor")) {
            cj.mo21922el(jSONObject.optBoolean("enableIndoor", false));
        }
        if (jSONObject.has("enableIndoorLevelPick")) {
            cj.mo21923em(jSONObject.optBoolean("enableIndoorLevelPick", false));
        }
        if (jSONObject.has("showLocation")) {
            cj.mo21924en(jSONObject.optBoolean("showLocation", false));
        }
        try {
            if (jSONObject.has("covers")) {
                cj.aEa();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("covers"));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    float f3 = C5046bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f4 = C5046bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    b = ((C33139b) c33303e.mo5936B(C33139b.class)).mo22120b(c33303e, jSONObject2.optString("iconPath"));
                    f = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    C10412d c10412d = new C10412d();
                    c10412d.mo21935g((double) f3, (double) f4);
                    c10412d.hNN = b;
                    c10412d.rotate = f;
                    cj.mo21896a(c10412d, (C19162a) c33303e.mo5936B(C19162a.class));
                    i2 = i3 + 1;
                }
            }
            C33319e.m54490oq(4);
            AppMethodBeat.m2505o(93881);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", e);
            AppMethodBeat.m2505o(93881);
            return false;
        }
    }
}
