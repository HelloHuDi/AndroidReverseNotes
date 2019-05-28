package com.tencent.p177mm.plugin.webview.fts.p752c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.c.c */
public final class C43875c {
    /* renamed from: cL */
    private static float m78693cL(Context context) {
        AppMethodBeat.m2504i(5945);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            C4990ab.m7413e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", e.getMessage());
        }
        AppMethodBeat.m2505o(5945);
        return f;
    }

    /* renamed from: cN */
    public static float m78694cN(Context context) {
        AppMethodBeat.m2504i(5946);
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float cL;
        if (attributes.screenBrightness < 0.0f) {
            cL = C43875c.m78693cL(context);
            AppMethodBeat.m2505o(5946);
            return cL;
        }
        cL = attributes.screenBrightness;
        AppMethodBeat.m2505o(5946);
        return cL;
    }

    /* renamed from: fQ */
    public static String m78695fQ(long j) {
        String str;
        AppMethodBeat.m2504i(5947);
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(j));
        AppMethodBeat.m2505o(5947);
        return str;
    }

    /* renamed from: a */
    public static float[] m78691a(JSONObject jSONObject, Context context) {
        AppMethodBeat.m2504i(5948);
        float[] fArr = new float[5];
        if (jSONObject.has(VideoMaterialUtil.CRAZYFACE_X)) {
            fArr[0] = (float) C1338a.fromDPToPix(context, jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_X));
        } else {
            fArr[0] = Float.MAX_VALUE;
        }
        if (jSONObject.has(VideoMaterialUtil.CRAZYFACE_Y)) {
            fArr[1] = (float) C1338a.fromDPToPix(context, jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_Y));
        } else {
            fArr[1] = Float.MAX_VALUE;
        }
        if (jSONObject.has("width")) {
            fArr[2] = (float) C1338a.fromDPToPix(context, jSONObject.optInt("width"));
        } else {
            fArr[2] = Float.MAX_VALUE;
        }
        if (jSONObject.has("height")) {
            fArr[3] = (float) C1338a.fromDPToPix(context, jSONObject.optInt("height"));
        } else {
            fArr[3] = Float.MAX_VALUE;
        }
        fArr[4] = 0.0f;
        AppMethodBeat.m2505o(5948);
        return fArr;
    }

    /* renamed from: t */
    public static int m78696t(JSONObject jSONObject) {
        AppMethodBeat.m2504i(5949);
        if (!jSONObject.has("visible")) {
            AppMethodBeat.m2505o(5949);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (jSONObject.optBoolean("visible")) {
            AppMethodBeat.m2505o(5949);
            return 0;
        } else {
            AppMethodBeat.m2505o(5949);
            return 1;
        }
    }

    /* renamed from: aL */
    public static String m78692aL(JSONObject jSONObject) {
        String string;
        AppMethodBeat.m2504i(5950);
        JSONArray optJSONArray = jSONObject.optJSONArray("playUrl");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                string = optJSONArray.getString(0);
                AppMethodBeat.m2505o(5950);
                return string;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", e.getMessage());
            }
        }
        string = "";
        AppMethodBeat.m2505o(5950);
        return string;
    }
}
