package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.graphics.Color;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10427r;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10427r.C10403b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10427r.C10428a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.e */
public final class C19394e extends C42517a {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93842);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapMarkers", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93842);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiAddMapMarkers", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93842);
            return;
        }
        int by;
        C4990ab.m7417i("MicroMsg.JsApiAddMapMarkers", "clear:%b", Boolean.valueOf(jSONObject.optBoolean("clear", true)));
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
                        C4990ab.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e2, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        JSONObject jSONObject3;
                        C10427r c10427r = new C10427r();
                        String optString = jSONObject2.optString("id");
                        float f2 = C5046bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        double d = (double) f2;
                        double d2 = (double) C5046bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        c10427r.latitude = d;
                        c10427r.longitude = d2;
                        String optString2 = jSONObject2.optString("iconPath");
                        float a = C42668g.m75553a(jSONObject2, "width", 0.0f);
                        float a2 = C42668g.m75553a(jSONObject2, "height", 0.0f);
                        if (!C5046bo.isNullOrNil(optString2)) {
                            if (c2241c.mo5936B(C33139b.class) != null) {
                                c10427r.hNN = ((C33139b) c2241c.mo5936B(C33139b.class)).mo22120b(c2241c, optString2);
                                c10427r.hOb = a;
                                c10427r.hOc = a2;
                            }
                        }
                        c10427r.rotate = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                        c10427r.alpha = (float) jSONObject2.optDouble("alpha", 1.0d);
                        c10427r.data = jSONObject2.optString("data");
                        c10427r.hOd = jSONObject2.optString("ariaLabel");
                        if (jSONObject2.has("anchor")) {
                            try {
                                jSONObject3 = new JSONObject(jSONObject2.optString("anchor"));
                            } catch (JSONException e3) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                c10427r.mo21941K((float) jSONObject3.optDouble(VideoMaterialUtil.CRAZYFACE_X, 0.5d), (float) jSONObject3.optDouble(VideoMaterialUtil.CRAZYFACE_Y, 1.0d));
                            } else {
                                c10427r.mo21941K(0.5f, 1.0f);
                            }
                        }
                        c10427r.zIndex = jSONObject2.optInt("zIndex", 0);
                        String optString3 = jSONObject2.optString("label");
                        if (!C5046bo.isNullOrNil(optString3)) {
                            try {
                                jSONObject3 = new JSONObject(optString3);
                            } catch (JSONException e4) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                optString2 = jSONObject3.optString(C8741b.CONTENT);
                                by = C42668g.m75559by(jSONObject3.optString("color", "#000000"), Color.parseColor("#000000"));
                                int optInt = jSONObject3.optInt("fontSize", 12);
                                int a3 = C42668g.m75555a(jSONObject3, "anchorX", C42668g.m75555a(jSONObject3, VideoMaterialUtil.CRAZYFACE_X, 0));
                                int a4 = C42668g.m75555a(jSONObject3, "anchorY", C42668g.m75555a(jSONObject3, VideoMaterialUtil.CRAZYFACE_Y, 0));
                                int optInt2 = jSONObject3.optInt("borderRadius", 0);
                                int f3 = C42668g.m75563f(jSONObject3, "borderWidth");
                                int Ee = C42668g.m75551Ee(jSONObject3.optString("borderColor"));
                                c10427r.hOf = new C10403b(optString2, by, optInt, a3, a4, C42668g.m75559by(jSONObject3.optString("bgColor", ""), Color.parseColor("#000000")), optInt2, f3, Ee, jSONObject3.optString("textAlign", ""), C42668g.m75555a(jSONObject3, "padding", 0));
                            }
                        }
                        optString3 = jSONObject2.optString("callout");
                        if (!C5046bo.isNullOrNil(optString3)) {
                            try {
                                jSONObject3 = new JSONObject(optString3);
                            } catch (JSONException e5) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                c10427r.hOe = new C10428a(jSONObject3.optString(C8741b.CONTENT), C42668g.m75559by(jSONObject3.optString("color", "#000000"), Color.parseColor("#000000")), jSONObject3.optInt("fontSize", 12), jSONObject3.optInt("borderRadius", 0), C42668g.m75559by(jSONObject3.optString("bgColor", "#000000"), Color.parseColor("#000000")), C42668g.m75563f(jSONObject3, "borderWidth"), C42668g.m75551Ee(jSONObject3.optString("borderColor")), C42668g.m75555a(jSONObject3, "padding", 0), C42668g.m75559by(jSONObject3.optString("shadowColor", "#000000"), Color.parseColor("#000000")), jSONObject3.optInt("shadowOpacity"), jSONObject3.optInt("shadowOffsetX"), jSONObject3.optInt("shadowOffsetY"), jSONObject3.optInt(ServerProtocol.DIALOG_PARAM_DISPLAY, 0), jSONObject3.optString("textAlign", ""));
                            }
                        }
                        String optString4 = jSONObject2.optString("buildingId");
                        optString2 = jSONObject2.optString("floorName");
                        c10427r.buildingId = optString4;
                        c10427r.floorName = optString2;
                        C10406b c10406b = f;
                        String str = optString;
                        C10427r c10427r2 = c10427r;
                        c10406b.mo21893a(str, c10427r2, (C19162a) c2241c.mo5936B(C19162a.class));
                    }
                    i2 = i3 + 1;
                }
            } else {
                C4990ab.m7412e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
                c2241c.mo6107M(i, mo73394j("fail:internal error", null));
                AppMethodBeat.m2505o(93842);
                return;
            }
        }
        C2241c c2241c2 = c2241c;
        by = i;
        mo67989a(c2241c2, by, mo73394j("ok", null), true, f.aDU());
        AppMethodBeat.m2505o(93842);
    }
}
