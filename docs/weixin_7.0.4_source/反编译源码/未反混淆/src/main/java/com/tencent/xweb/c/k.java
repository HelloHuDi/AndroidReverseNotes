package com.tencent.xweb.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.f;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class k {
    static a APA;
    static a APB;
    static a APC;

    public interface a {
        void clearAllWebViewCache(Context context, boolean z);

        h createWebView(WebView webView);

        g createWebviewStorage();

        Object excute(String str, Object[] objArr);

        com.tencent.xweb.c.b.a getCookieManager();

        b getCookieSyncManager();

        boolean hasInited();

        void initCallback(WebViewExtensionListener webViewExtensionListener);

        void initEnviroment(Context context);

        void initInterface();

        boolean initWebviewCore(Context context, c cVar);
    }

    public static a f(d dVar) {
        AppMethodBeat.i(3993);
        Object iJ;
        a aVar;
        if (dVar == d.WV_KIND_CW) {
            if (APA == null) {
                iJ = e.iJ("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
                if (iJ == null || !(iJ instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
                    AppMethodBeat.o(3993);
                    return null;
                }
                APA = (a) iJ;
            }
            aVar = APA;
            AppMethodBeat.o(3993);
            return aVar;
        } else if (dVar == d.WV_KIND_X5) {
            if (APB == null) {
                iJ = e.iJ("com.tencent.xweb.x5.X5WebFactory", "getInstance");
                if (iJ == null || !(iJ instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
                    AppMethodBeat.o(3993);
                    return null;
                }
                APB = (a) iJ;
            }
            aVar = APB;
            AppMethodBeat.o(3993);
            return aVar;
        } else if (dVar == d.WV_KIND_SYS) {
            if (APC == null) {
                iJ = e.iJ("com.tencent.xweb.sys.SysWebFactory", "getInstance");
                if (iJ == null || !(iJ instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
                    AppMethodBeat.o(3993);
                    return null;
                }
                APC = (a) iJ;
            }
            aVar = APC;
            AppMethodBeat.o(3993);
            return aVar;
        } else {
            AppMethodBeat.o(3993);
            return null;
        }
    }

    public static h a(d dVar, WebView webView) {
        h hVar = null;
        AppMethodBeat.i(3994);
        Log.i("WebViewWrapperFactory", "try to create webview  = ".concat(String.valueOf(dVar)));
        c b = c.b("CREATE_WEBVIEW", dVar);
        b.dUx();
        try {
            if (f(dVar) == null) {
                Log.e("WebViewWrapperFactory", "the kind of " + dVar + " this provider does not exist!");
                AppMethodBeat.o(3994);
                return hVar;
            }
            hVar = f(dVar).createWebView(webView);
            if (hVar != null) {
                b.dUy();
            } else {
                XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = ".concat(String.valueOf(dVar)));
            }
            AppMethodBeat.o(3994);
            return hVar;
        } catch (Exception e) {
            XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + dVar + ", error msg:" + e.getMessage());
            f.k(dVar);
        }
    }
}
