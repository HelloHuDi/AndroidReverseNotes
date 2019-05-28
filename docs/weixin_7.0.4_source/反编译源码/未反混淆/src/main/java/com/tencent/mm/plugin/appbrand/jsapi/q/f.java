package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126413);
        ab.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        Context context = cVar.getContext();
        if (context == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            AppMethodBeat.o(126413);
        } else if (context instanceof Activity) {
            float f = ((Activity) context).getWindow().getAttributes().screenBrightness;
            if (f < 0.0f) {
                f = cL(context);
            }
            ab.i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", Float.valueOf(f), Float.valueOf(r2.screenBrightness));
            HashMap hashMap = new HashMap();
            hashMap.put("value", Float.valueOf(f));
            cVar.M(i, j("ok", hashMap));
            AppMethodBeat.o(126413);
        } else {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
            AppMethodBeat.o(126413);
        }
    }

    private static float cL(Context context) {
        AppMethodBeat.i(126414);
        float f = 0.0f;
        try {
            f = ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            ab.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e.getMessage());
        } catch (IllegalArgumentException e2) {
            ab.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", e2.getMessage());
        } catch (Exception e3) {
            ab.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e3.getMessage());
        }
        AppMethodBeat.o(126414);
        return f;
    }
}
