package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10412d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33320g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.d */
public final class C19491d extends C27108a {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "updateXWebMap";

    /* renamed from: h */
    public static boolean m30173h(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(117364);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiUpdateXWebMap", "data is null");
            AppMethodBeat.m2505o(117364);
            return false;
        }
        String appId = c2241c.getAppId();
        C4990ab.m7417i("MicroMsg.JsApiUpdateXWebMap", "data:%s", jSONObject);
        C10406b cj = C33320g.m54494cj(appId, C38303f.m64817g(c2241c, jSONObject));
        if (cj == null) {
            C4990ab.m7412e("MicroMsg.JsApiUpdateXWebMap", "mapView is null, return");
            AppMethodBeat.m2505o(117364);
            return false;
        }
        float f;
        if (jSONObject.has("position")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null && optJSONObject.has("width") && optJSONObject.has("height")) {
                cj.onSizeChanged(C42668g.m75555a(optJSONObject, "width", 0), C42668g.m75555a(optJSONObject, "height", 0));
            }
        }
        if (jSONObject.has(WMElement.ANIMATE_TYPE_SCALE)) {
            cj.mo21910al((float) jSONObject.optDouble(WMElement.ANIMATE_TYPE_SCALE, 16.0d));
        }
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            cj.mo21911am((float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
        }
        if (jSONObject.has("skew")) {
            cj.mo21912an((float) jSONObject.optDouble("skew", 0.0d));
        }
        if (jSONObject.has("centerLatitude") && jSONObject.has("centerLongitude")) {
            float f2 = C5046bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
            f = C5046bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
            if (Math.abs(f2) <= 90.0f && Math.abs(f) <= 180.0f) {
                cj.mo21882I(f2, f);
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
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    float f3 = C5046bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f4 = C5046bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    appId = ((C33139b) c2241c.mo5936B(C33139b.class)).mo22120b(c2241c, jSONObject2.optString("iconPath"));
                    f = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    C10412d c10412d = new C10412d();
                    c10412d.mo21935g((double) f3, (double) f4);
                    c10412d.hNN = appId;
                    c10412d.rotate = f;
                    cj.mo21896a(c10412d, (C19162a) c2241c.mo5936B(C19162a.class));
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(117364);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiUpdateXWebMap", "parse covers error, exception : %s", e);
            AppMethodBeat.m2505o(117364);
            return false;
        }
    }
}
