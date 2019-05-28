package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.f */
public final class C45615f extends C10296a {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126413);
        C4990ab.m7410d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        Context context = c2241c.getContext();
        if (context == null) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            AppMethodBeat.m2505o(126413);
        } else if (context instanceof Activity) {
            float f = ((Activity) context).getWindow().getAttributes().screenBrightness;
            if (f < 0.0f) {
                f = C45615f.m84197cL(context);
            }
            C4990ab.m7417i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", Float.valueOf(f), Float.valueOf(r2.screenBrightness));
            HashMap hashMap = new HashMap();
            hashMap.put("value", Float.valueOf(f));
            c2241c.mo6107M(i, mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(126413);
        } else {
            c2241c.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
            AppMethodBeat.m2505o(126413);
        }
    }

    /* renamed from: cL */
    private static float m84197cL(Context context) {
        AppMethodBeat.m2504i(126414);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            C4990ab.m7413e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e.getMessage());
        } catch (IllegalArgumentException e2) {
            C4990ab.m7413e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", e2.getMessage());
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e3.getMessage());
        }
        AppMethodBeat.m2505o(126414);
        return f;
    }
}
