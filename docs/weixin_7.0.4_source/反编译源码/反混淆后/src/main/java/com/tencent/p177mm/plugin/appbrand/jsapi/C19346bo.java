package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bo */
public final class C19346bo {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bo$1 */
    static class C193471 implements ValueCallback<String> {
        C193471() {
        }

        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
        }
    }

    /* renamed from: a */
    public static void m30025a(C6747i c6747i, String str, String str2, int i) {
        AppMethodBeat.m2504i(91041);
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "{}";
        }
        String str3 = "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = C19346bo.m30024QB();
        c6747i.evaluateJavascript(String.format(str3, objArr), new C193471());
        AppMethodBeat.m2505o(91041);
    }

    /* renamed from: QB */
    public static String m30024QB() {
        AppMethodBeat.m2504i(91042);
        String jSONObject;
        try {
            jSONObject = new JSONObject().put("nativeTime", System.currentTimeMillis()).toString();
            AppMethodBeat.m2505o(91042);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", e);
            jSONObject = "{}";
            AppMethodBeat.m2505o(91042);
            return jSONObject;
        }
    }
}
