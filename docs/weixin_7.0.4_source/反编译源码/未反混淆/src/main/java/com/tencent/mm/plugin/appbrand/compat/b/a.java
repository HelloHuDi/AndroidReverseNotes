package com.tencent.mm.plugin.appbrand.compat.b;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import com.tencent.xweb.WebView;

public final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.compat.b.a$1 */
    public static class AnonymousClass1 implements com.tencent.mm.vending.c.a<String, Void> {
        final /* synthetic */ WebView heQ;

        public AnonymousClass1(WebView webView) {
            this.heQ = webView;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(93750);
            final b dMo = f.dMo();
            this.heQ.evaluateJavascript("(function() {if (window.privateOpenWeappFunctinalPage || false) {return window.data} else {return undefined } })()", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(93749);
                    String str = (String) obj;
                    dMo.B(str);
                    AppMethodBeat.o(93749);
                }
            });
            AppMethodBeat.o(93750);
            return null;
        }
    }
}
