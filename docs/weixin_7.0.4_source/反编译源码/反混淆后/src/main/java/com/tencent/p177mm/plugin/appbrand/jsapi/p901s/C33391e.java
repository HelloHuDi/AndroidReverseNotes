package com.tencent.p177mm.plugin.appbrand.jsapi.p901s;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.e */
public final class C33391e {
    /* renamed from: b */
    public static void m54586b(View view, JSONObject jSONObject) {
        int i = 1;
        AppMethodBeat.m2504i(126632);
        if (view == null || jSONObject == null) {
            AppMethodBeat.m2505o(126632);
            return;
        }
        int i2;
        float f;
        int Ee = C42668g.m75551Ee(jSONObject.optString("bgColor"));
        int Ee2 = C42668g.m75551Ee(jSONObject.optString("borderColor"));
        float a = C42668g.m75553a(jSONObject, "borderRadius", 0.0f);
        float a2 = C42668g.m75553a(jSONObject, "borderWidth", 0.0f);
        if (view instanceof C45618f) {
            C45618f c45618f = (C45618f) view;
            c45618f.setBgColor(Ee);
            c45618f.setBorderColor(Ee2);
            c45618f.setBorderRadius(a);
            c45618f.setBorderWidth(a2);
            i2 = 1;
        } else {
            i2 = 0;
        }
        try {
            f = (float) jSONObject.getDouble("opacity");
            if (f >= 0.0f && f <= 1.0f) {
                view.setAlpha(f);
                i2 = 1;
            }
        } catch (JSONException e) {
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("padding");
        if (optJSONArray != null && optJSONArray.length() == 4) {
            view.setPadding(C42668g.m75554a(optJSONArray, 3), C42668g.m75554a(optJSONArray, 0), C42668g.m75554a(optJSONArray, 1), C42668g.m75554a(optJSONArray, 2));
        }
        float optDouble = (float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
        f = (float) jSONObject.optDouble("scaleX", 1.0d);
        float optDouble2 = (float) jSONObject.optDouble("scaleY", 1.0d);
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            view.setRotation(optDouble);
            i2 = 1;
        }
        if (jSONObject.has("scaleX")) {
            view.setScaleX(f);
            i2 = 1;
        }
        if (jSONObject.has("scaleY")) {
            view.setScaleY(optDouble2);
        } else {
            i = i2;
        }
        if (i != 0) {
            view.invalidate();
        }
        AppMethodBeat.m2505o(126632);
    }
}
