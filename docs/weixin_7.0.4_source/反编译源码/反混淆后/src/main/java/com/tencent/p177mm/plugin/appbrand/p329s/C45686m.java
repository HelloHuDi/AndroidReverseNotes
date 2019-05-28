package com.tencent.p177mm.plugin.appbrand.p329s;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.s.m */
public final class C45686m {

    /* renamed from: com.tencent.mm.plugin.appbrand.s.m$1 */
    static class C456851 implements ValueCallback<String> {
        C456851() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(133580);
            C4990ab.m7417i("MicroMsg.JsScriptEvaluatorWC", "hy: value ret: %s", (String) obj);
            AppMethodBeat.m2505o(133580);
        }
    }

    /* renamed from: a */
    public static void m84388a(C6747i c6747i, String str, String str2) {
        AppMethodBeat.m2504i(133581);
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "{}";
        }
        C4990ab.m7411d("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(0));
        c6747i.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", new Object[]{str, str2}), new C456851());
        AppMethodBeat.m2505o(133581);
    }
}
