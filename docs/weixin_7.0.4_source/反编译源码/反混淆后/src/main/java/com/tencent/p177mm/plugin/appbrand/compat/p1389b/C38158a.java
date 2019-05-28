package com.tencent.p177mm.plugin.appbrand.compat.p1389b;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.appbrand.compat.b.a */
public final class C38158a {

    /* renamed from: com.tencent.mm.plugin.appbrand.compat.b.a$1 */
    public static class C268251 implements C5681a<String, Void> {
        final /* synthetic */ WebView heQ;

        public C268251(WebView webView) {
            this.heQ = webView;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(93750);
            final C5688b dMo = C5698f.dMo();
            this.heQ.evaluateJavascript("(function() {if (window.privateOpenWeappFunctinalPage || false) {return window.data} else {return undefined } })()", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(93749);
                    String str = (String) obj;
                    dMo.mo11581B(str);
                    AppMethodBeat.m2505o(93749);
                }
            });
            AppMethodBeat.m2505o(93750);
            return null;
        }
    }
}
