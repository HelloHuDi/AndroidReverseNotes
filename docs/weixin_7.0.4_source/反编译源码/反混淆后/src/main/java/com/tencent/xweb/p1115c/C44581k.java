package com.tencent.xweb.p1115c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.WebView.C46828c;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import com.tencent.xweb.p1115c.C44577b.C36585b;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C6038e;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.c.k */
public final class C44581k {
    static C44580a APA;
    static C44580a APB;
    static C44580a APC;

    /* renamed from: com.tencent.xweb.c.k$a */
    public interface C44580a {
        void clearAllWebViewCache(Context context, boolean z);

        C46832h createWebView(WebView webView);

        C44578g createWebviewStorage();

        Object excute(String str, Object[] objArr);

        C36584a getCookieManager();

        C36585b getCookieSyncManager();

        boolean hasInited();

        void initCallback(WebViewExtensionListener webViewExtensionListener);

        void initEnviroment(Context context);

        void initInterface();

        boolean initWebviewCore(Context context, C46828c c46828c);
    }

    /* renamed from: f */
    public static C44580a m80968f(C44570d c44570d) {
        AppMethodBeat.m2504i(3993);
        Object iJ;
        C44580a c44580a;
        if (c44570d == C44570d.WV_KIND_CW) {
            if (APA == null) {
                iJ = C6038e.m9509iJ("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
                if (iJ == null || !(iJ instanceof C44580a)) {
                    Log.m81046e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
                    AppMethodBeat.m2505o(3993);
                    return null;
                }
                APA = (C44580a) iJ;
            }
            c44580a = APA;
            AppMethodBeat.m2505o(3993);
            return c44580a;
        } else if (c44570d == C44570d.WV_KIND_X5) {
            if (APB == null) {
                iJ = C6038e.m9509iJ("com.tencent.xweb.x5.X5WebFactory", "getInstance");
                if (iJ == null || !(iJ instanceof C44580a)) {
                    Log.m81046e("WebViewWrapperFactory", "find X5WebFactory failed");
                    AppMethodBeat.m2505o(3993);
                    return null;
                }
                APB = (C44580a) iJ;
            }
            c44580a = APB;
            AppMethodBeat.m2505o(3993);
            return c44580a;
        } else if (c44570d == C44570d.WV_KIND_SYS) {
            if (APC == null) {
                iJ = C6038e.m9509iJ("com.tencent.xweb.sys.SysWebFactory", "getInstance");
                if (iJ == null || !(iJ instanceof C44580a)) {
                    Log.m81046e("WebViewWrapperFactory", "find SysWebFactory failed");
                    AppMethodBeat.m2505o(3993);
                    return null;
                }
                APC = (C44580a) iJ;
            }
            c44580a = APC;
            AppMethodBeat.m2505o(3993);
            return c44580a;
        } else {
            AppMethodBeat.m2505o(3993);
            return null;
        }
    }

    /* renamed from: a */
    public static C46832h m80967a(C44570d c44570d, WebView webView) {
        C46832h c46832h = null;
        AppMethodBeat.m2504i(3994);
        Log.m81049i("WebViewWrapperFactory", "try to create webview  = ".concat(String.valueOf(c44570d)));
        C24523c b = C24523c.m38149b("CREATE_WEBVIEW", c44570d);
        b.dUx();
        try {
            if (C44581k.m80968f(c44570d) == null) {
                Log.m81046e("WebViewWrapperFactory", "the kind of " + c44570d + " this provider does not exist!");
                AppMethodBeat.m2505o(3994);
                return c46832h;
            }
            c46832h = C44581k.m80968f(c44570d).createWebView(webView);
            if (c46832h != null) {
                b.dUy();
            } else {
                XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = ".concat(String.valueOf(c44570d)));
            }
            AppMethodBeat.m2505o(3994);
            return c46832h;
        } catch (Exception e) {
            XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + c44570d + ", error msg:" + e.getMessage());
            C24532f.m38179k(c44570d);
        }
    }
}
