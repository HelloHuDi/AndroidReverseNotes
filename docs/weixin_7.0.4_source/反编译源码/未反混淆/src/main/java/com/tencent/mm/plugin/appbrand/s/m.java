package com.tencent.mm.plugin.appbrand.s;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {
    public static void a(i iVar, String str, String str2) {
        AppMethodBeat.i(133581);
        if (bo.isNullOrNil(str2)) {
            str2 = "{}";
        }
        ab.d("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(0));
        iVar.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", new Object[]{str, str2}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(133580);
                ab.i("MicroMsg.JsScriptEvaluatorWC", "hy: value ret: %s", (String) obj);
                AppMethodBeat.o(133580);
            }
        });
        AppMethodBeat.o(133581);
    }
}
