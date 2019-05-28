package com.tencent.mm.plugin.appbrand.jsapi;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class bo {
    public static void a(i iVar, String str, String str2, int i) {
        AppMethodBeat.i(91041);
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(str2)) {
            str2 = "{}";
        }
        String str3 = "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = QB();
        iVar.evaluateJavascript(String.format(str3, objArr), new ValueCallback<String>() {
            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
            }
        });
        AppMethodBeat.o(91041);
    }

    public static String QB() {
        AppMethodBeat.i(91042);
        String jSONObject;
        try {
            jSONObject = new JSONObject().put("nativeTime", System.currentTimeMillis()).toString();
            AppMethodBeat.o(91042);
            return jSONObject;
        } catch (Exception e) {
            ab.e("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", e);
            jSONObject = "{}";
            AppMethodBeat.o(91042);
            return jSONObject;
        }
    }
}
