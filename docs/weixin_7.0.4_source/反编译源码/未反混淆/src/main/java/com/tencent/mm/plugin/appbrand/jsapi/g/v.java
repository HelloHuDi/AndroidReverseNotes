package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v extends c {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(93880);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.o(93880);
            return optInt;
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", e);
            AppMethodBeat.o(93880);
            return -1;
        }
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(93881);
        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(3);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiUpdateMap", "data is null");
            AppMethodBeat.o(93881);
            return false;
        }
        String b;
        ab.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", eVar.getAppId(), Integer.valueOf(i), jSONObject);
        b cj = g.cj(b, f.g(eVar, jSONObject));
        if (cj == null) {
            ab.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
            AppMethodBeat.o(93881);
            return false;
        }
        float f;
        if (jSONObject.has(WMElement.ANIMATE_TYPE_SCALE)) {
            cj.al((float) jSONObject.optDouble(WMElement.ANIMATE_TYPE_SCALE, 16.0d));
        }
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            cj.am((float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
        }
        if (jSONObject.has("skew")) {
            cj.an((float) jSONObject.optDouble("skew", 0.0d));
        }
        if (jSONObject.has("centerLatitude")) {
            if (jSONObject.has("centerLongitude")) {
                float f2 = bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                f = bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                if (Math.abs(f2) <= 90.0f && Math.abs(f) <= 180.0f) {
                    cj.I(f2, f);
                }
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
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    float f3 = bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f4 = bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    b = ((com.tencent.mm.plugin.appbrand.d.b) eVar.B(com.tencent.mm.plugin.appbrand.d.b.class)).b(eVar, jSONObject2.optString("iconPath"));
                    f = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    d dVar = new d();
                    dVar.g((double) f3, (double) f4);
                    dVar.hNN = b;
                    dVar.rotate = f;
                    cj.a(dVar, (a) eVar.B(a.class));
                    i2 = i3 + 1;
                }
            }
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(4);
            AppMethodBeat.o(93881);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", e);
            AppMethodBeat.o(93881);
            return false;
        }
    }
}
