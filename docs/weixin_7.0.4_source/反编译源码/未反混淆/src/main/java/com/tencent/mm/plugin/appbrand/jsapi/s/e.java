package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static void b(View view, JSONObject jSONObject) {
        int i = 1;
        AppMethodBeat.i(126632);
        if (view == null || jSONObject == null) {
            AppMethodBeat.o(126632);
            return;
        }
        int i2;
        float f;
        int Ee = g.Ee(jSONObject.optString("bgColor"));
        int Ee2 = g.Ee(jSONObject.optString("borderColor"));
        float a = g.a(jSONObject, "borderRadius", 0.0f);
        float a2 = g.a(jSONObject, "borderWidth", 0.0f);
        if (view instanceof f) {
            f fVar = (f) view;
            fVar.setBgColor(Ee);
            fVar.setBorderColor(Ee2);
            fVar.setBorderRadius(a);
            fVar.setBorderWidth(a2);
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
            view.setPadding(g.a(optJSONArray, 3), g.a(optJSONArray, 0), g.a(optJSONArray, 1), g.a(optJSONArray, 2));
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
        AppMethodBeat.o(126632);
    }
}
