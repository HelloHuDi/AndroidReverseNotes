package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93842);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiAddMapMarkers", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93842);
            return;
        }
        ab.i("MicroMsg.JsApiAddMapMarkers", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93842);
            return;
        }
        int by;
        ab.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", Boolean.valueOf(jSONObject.optBoolean("clear", true)));
        if (jSONObject.optBoolean("clear", true)) {
            f.aDZ();
        }
        if (jSONObject.has("markers")) {
            JSONArray jSONArray;
            try {
                jSONArray = new JSONArray(jSONObject.optString("markers"));
            } catch (JSONException e) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2;
                    try {
                        jSONObject2 = (JSONObject) jSONArray.get(i3);
                    } catch (JSONException e2) {
                        ab.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e2, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        JSONObject jSONObject3;
                        r rVar = new r();
                        String optString = jSONObject2.optString("id");
                        float f2 = bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        double d = (double) f2;
                        double d2 = (double) bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        rVar.latitude = d;
                        rVar.longitude = d2;
                        String optString2 = jSONObject2.optString("iconPath");
                        float a = g.a(jSONObject2, "width", 0.0f);
                        float a2 = g.a(jSONObject2, "height", 0.0f);
                        if (!bo.isNullOrNil(optString2)) {
                            if (cVar.B(com.tencent.mm.plugin.appbrand.d.b.class) != null) {
                                rVar.hNN = ((com.tencent.mm.plugin.appbrand.d.b) cVar.B(com.tencent.mm.plugin.appbrand.d.b.class)).b(cVar, optString2);
                                rVar.hOb = a;
                                rVar.hOc = a2;
                            }
                        }
                        rVar.rotate = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                        rVar.alpha = (float) jSONObject2.optDouble("alpha", 1.0d);
                        rVar.data = jSONObject2.optString("data");
                        rVar.hOd = jSONObject2.optString("ariaLabel");
                        if (jSONObject2.has("anchor")) {
                            try {
                                jSONObject3 = new JSONObject(jSONObject2.optString("anchor"));
                            } catch (JSONException e3) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                rVar.K((float) jSONObject3.optDouble(VideoMaterialUtil.CRAZYFACE_X, 0.5d), (float) jSONObject3.optDouble(VideoMaterialUtil.CRAZYFACE_Y, 1.0d));
                            } else {
                                rVar.K(0.5f, 1.0f);
                            }
                        }
                        rVar.zIndex = jSONObject2.optInt("zIndex", 0);
                        String optString3 = jSONObject2.optString("label");
                        if (!bo.isNullOrNil(optString3)) {
                            try {
                                jSONObject3 = new JSONObject(optString3);
                            } catch (JSONException e4) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                optString2 = jSONObject3.optString(FirebaseAnalytics.b.CONTENT);
                                by = g.by(jSONObject3.optString("color", "#000000"), Color.parseColor("#000000"));
                                int optInt = jSONObject3.optInt("fontSize", 12);
                                int a3 = g.a(jSONObject3, "anchorX", g.a(jSONObject3, VideoMaterialUtil.CRAZYFACE_X, 0));
                                int a4 = g.a(jSONObject3, "anchorY", g.a(jSONObject3, VideoMaterialUtil.CRAZYFACE_Y, 0));
                                int optInt2 = jSONObject3.optInt("borderRadius", 0);
                                int f3 = g.f(jSONObject3, "borderWidth");
                                int Ee = g.Ee(jSONObject3.optString("borderColor"));
                                rVar.hOf = new r.b(optString2, by, optInt, a3, a4, g.by(jSONObject3.optString("bgColor", ""), Color.parseColor("#000000")), optInt2, f3, Ee, jSONObject3.optString("textAlign", ""), g.a(jSONObject3, "padding", 0));
                            }
                        }
                        optString3 = jSONObject2.optString("callout");
                        if (!bo.isNullOrNil(optString3)) {
                            try {
                                jSONObject3 = new JSONObject(optString3);
                            } catch (JSONException e5) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                rVar.hOe = new a(jSONObject3.optString(FirebaseAnalytics.b.CONTENT), g.by(jSONObject3.optString("color", "#000000"), Color.parseColor("#000000")), jSONObject3.optInt("fontSize", 12), jSONObject3.optInt("borderRadius", 0), g.by(jSONObject3.optString("bgColor", "#000000"), Color.parseColor("#000000")), g.f(jSONObject3, "borderWidth"), g.Ee(jSONObject3.optString("borderColor")), g.a(jSONObject3, "padding", 0), g.by(jSONObject3.optString("shadowColor", "#000000"), Color.parseColor("#000000")), jSONObject3.optInt("shadowOpacity"), jSONObject3.optInt("shadowOffsetX"), jSONObject3.optInt("shadowOffsetY"), jSONObject3.optInt(ServerProtocol.DIALOG_PARAM_DISPLAY, 0), jSONObject3.optString("textAlign", ""));
                            }
                        }
                        String optString4 = jSONObject2.optString("buildingId");
                        optString2 = jSONObject2.optString("floorName");
                        rVar.buildingId = optString4;
                        rVar.floorName = optString2;
                        b bVar = f;
                        String str = optString;
                        r rVar2 = rVar;
                        bVar.a(str, rVar2, (com.tencent.mm.plugin.appbrand.d.a) cVar.B(com.tencent.mm.plugin.appbrand.d.a.class));
                    }
                    i2 = i3 + 1;
                }
            } else {
                ab.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
                cVar.M(i, j("fail:internal error", null));
                AppMethodBeat.o(93842);
                return;
            }
        }
        c cVar2 = cVar;
        by = i;
        a(cVar2, by, j("ok", null), true, f.aDU());
        AppMethodBeat.o(93842);
    }
}
