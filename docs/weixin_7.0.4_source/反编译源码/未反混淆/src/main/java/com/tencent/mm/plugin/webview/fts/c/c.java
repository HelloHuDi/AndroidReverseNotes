package com.tencent.mm.plugin.webview.fts.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static float cL(Context context) {
        AppMethodBeat.i(5945);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            ab.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", e.getMessage());
        }
        AppMethodBeat.o(5945);
        return f;
    }

    public static float cN(Context context) {
        AppMethodBeat.i(5946);
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float cL;
        if (attributes.screenBrightness < 0.0f) {
            cL = cL(context);
            AppMethodBeat.o(5946);
            return cL;
        }
        cL = attributes.screenBrightness;
        AppMethodBeat.o(5946);
        return cL;
    }

    public static String fQ(long j) {
        String str;
        AppMethodBeat.i(5947);
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(j));
        AppMethodBeat.o(5947);
        return str;
    }

    public static float[] a(JSONObject jSONObject, Context context) {
        AppMethodBeat.i(5948);
        float[] fArr = new float[5];
        if (jSONObject.has(VideoMaterialUtil.CRAZYFACE_X)) {
            fArr[0] = (float) a.fromDPToPix(context, jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_X));
        } else {
            fArr[0] = Float.MAX_VALUE;
        }
        if (jSONObject.has(VideoMaterialUtil.CRAZYFACE_Y)) {
            fArr[1] = (float) a.fromDPToPix(context, jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_Y));
        } else {
            fArr[1] = Float.MAX_VALUE;
        }
        if (jSONObject.has("width")) {
            fArr[2] = (float) a.fromDPToPix(context, jSONObject.optInt("width"));
        } else {
            fArr[2] = Float.MAX_VALUE;
        }
        if (jSONObject.has("height")) {
            fArr[3] = (float) a.fromDPToPix(context, jSONObject.optInt("height"));
        } else {
            fArr[3] = Float.MAX_VALUE;
        }
        fArr[4] = 0.0f;
        AppMethodBeat.o(5948);
        return fArr;
    }

    public static int t(JSONObject jSONObject) {
        AppMethodBeat.i(5949);
        if (!jSONObject.has("visible")) {
            AppMethodBeat.o(5949);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (jSONObject.optBoolean("visible")) {
            AppMethodBeat.o(5949);
            return 0;
        } else {
            AppMethodBeat.o(5949);
            return 1;
        }
    }

    public static String aL(JSONObject jSONObject) {
        String string;
        AppMethodBeat.i(5950);
        JSONArray optJSONArray = jSONObject.optJSONArray("playUrl");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                string = optJSONArray.getString(0);
                AppMethodBeat.o(5950);
                return string;
            } catch (JSONException e) {
                ab.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", e.getMessage());
            }
        }
        string = "";
        AppMethodBeat.o(5950);
        return string;
    }
}
