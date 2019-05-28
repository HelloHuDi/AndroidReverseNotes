package com.tencent.mm.plugin.appbrand.jsapi.u.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "updateXWebMap";

    public static boolean h(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(117364);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiUpdateXWebMap", "data is null");
            AppMethodBeat.o(117364);
            return false;
        }
        String appId = cVar.getAppId();
        ab.i("MicroMsg.JsApiUpdateXWebMap", "data:%s", jSONObject);
        b cj = g.cj(appId, f.g(cVar, jSONObject));
        if (cj == null) {
            ab.e("MicroMsg.JsApiUpdateXWebMap", "mapView is null, return");
            AppMethodBeat.o(117364);
            return false;
        }
        float f;
        if (jSONObject.has("position")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null && optJSONObject.has("width") && optJSONObject.has("height")) {
                cj.onSizeChanged(com.tencent.mm.plugin.appbrand.r.g.a(optJSONObject, "width", 0), com.tencent.mm.plugin.appbrand.r.g.a(optJSONObject, "height", 0));
            }
        }
        if (jSONObject.has(WMElement.ANIMATE_TYPE_SCALE)) {
            cj.al((float) jSONObject.optDouble(WMElement.ANIMATE_TYPE_SCALE, 16.0d));
        }
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            cj.am((float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
        }
        if (jSONObject.has("skew")) {
            cj.an((float) jSONObject.optDouble("skew", 0.0d));
        }
        if (jSONObject.has("centerLatitude") && jSONObject.has("centerLongitude")) {
            float f2 = bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
            f = bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
            if (Math.abs(f2) <= 90.0f && Math.abs(f) <= 180.0f) {
                cj.I(f2, f);
            }
        }
        if (jSONObject.has("enableZoom")) {
            cj.ed(jSONObject.optBoolean("enableZoom", true));
        }
        if (jSONObject.has("enableScroll")) {
            cj.ee(jSONObject.optBoolean("enableScroll", true));
        }
        if (jSONObject.has("enableRotate")) {
            cj.ef(jSONObject.optBoolean("enableRotate", true));
        }
        if (jSONObject.has("showCompass")) {
            cj.eg(jSONObject.optBoolean("showCompass", false));
        }
        if (jSONObject.has("enable3D")) {
            cj.eh(jSONObject.optBoolean("enable3D", false));
        }
        if (jSONObject.has("enableOverlooking")) {
            cj.ei(jSONObject.optBoolean("enableOverlooking", false));
        }
        if (jSONObject.has("enableSatellite")) {
            cj.ej(jSONObject.optBoolean("enableSatellite", false));
        }
        if (jSONObject.has("enableTraffic")) {
            cj.ek(jSONObject.optBoolean("enableTraffic", false));
        }
        if (jSONObject.has("enableIndoor")) {
            cj.el(jSONObject.optBoolean("enableIndoor", false));
        }
        if (jSONObject.has("enableIndoorLevelPick")) {
            cj.em(jSONObject.optBoolean("enableIndoorLevelPick", false));
        }
        if (jSONObject.has("showLocation")) {
            cj.en(jSONObject.optBoolean("showLocation", false));
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
                    float f3 = bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f4 = bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    appId = ((com.tencent.mm.plugin.appbrand.d.b) cVar.B(com.tencent.mm.plugin.appbrand.d.b.class)).b(cVar, jSONObject2.optString("iconPath"));
                    f = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d dVar = new com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d();
                    dVar.g((double) f3, (double) f4);
                    dVar.hNN = appId;
                    dVar.rotate = f;
                    cj.a(dVar, (a) cVar.B(a.class));
                    i = i2 + 1;
                }
            }
            AppMethodBeat.o(117364);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiUpdateXWebMap", "parse covers error, exception : %s", e);
            AppMethodBeat.o(117364);
            return false;
        }
    }
}
