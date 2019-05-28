package com.tencent.xweb.sys;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C41128i.C36587a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C46828c;
import com.tencent.xweb.p1115c.C24525f;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import com.tencent.xweb.p1115c.C44577b.C36585b;
import com.tencent.xweb.p1115c.C44578g;
import com.tencent.xweb.p1115c.C44581k.C44580a;
import com.tencent.xweb.p1115c.C46832h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory implements C44580a {
    static SysWebFactory sInstance;

    /* renamed from: com.tencent.xweb.sys.SysWebFactory$a */
    static class C16396a {
        private static boolean APR = false;
        private static boolean lCa = false;

        public static boolean hasInitedCallback() {
            return APR;
        }

        public static void dUJ() {
        }
    }

    public static SysWebFactory getInstance() {
        AppMethodBeat.m2504i(84662);
        if (sInstance == null) {
            sInstance = new SysWebFactory();
        }
        SysWebFactory sysWebFactory = sInstance;
        AppMethodBeat.m2505o(84662);
        return sysWebFactory;
    }

    private SysWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.m2504i(84663);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(84663);
        } else if (str.equals("STR_CMD_GET_DEBUG_VIEW") || !str.equals("STR_CMD_GET_UPDATER")) {
            AppMethodBeat.m2505o(84663);
        } else {
            AppMethodBeat.m2505o(84663);
        }
        return null;
    }

    public C46832h createWebView(WebView webView) {
        AppMethodBeat.m2504i(84664);
        C16398e c16398e = new C16398e(webView);
        AppMethodBeat.m2505o(84664);
        return c16398e;
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
    }

    public C24525f getJsCore(C36587a c36587a, Context context) {
        return null;
    }

    public boolean initWebviewCore(Context context, C46828c c46828c) {
        AppMethodBeat.m2504i(84665);
        if (c46828c != null) {
            c46828c.onCoreInitFinished();
        }
        AppMethodBeat.m2505o(84665);
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.m2504i(84666);
        C16396a.dUJ();
        AppMethodBeat.m2505o(84666);
    }

    public boolean hasInited() {
        return true;
    }

    public boolean hasInitedCallback() {
        AppMethodBeat.m2504i(84667);
        boolean hasInitedCallback = C16396a.hasInitedCallback();
        AppMethodBeat.m2505o(84667);
        return hasInitedCallback;
    }

    public boolean isCoreReady() {
        return true;
    }

    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.m2504i(84668);
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
            AppMethodBeat.m2505o(84668);
        } catch (Exception e) {
            Log.m81046e("SysWebFactory", "clearAllWebViewCache failed " + e.getMessage());
            AppMethodBeat.m2505o(84668);
        }
    }

    public C36584a getCookieManager() {
        AppMethodBeat.m2504i(84669);
        C46833a c46833a = new C46833a();
        AppMethodBeat.m2505o(84669);
        return c46833a;
    }

    public C36585b getCookieSyncManager() {
        AppMethodBeat.m2504i(84670);
        C41129b c41129b = new C41129b();
        AppMethodBeat.m2505o(84670);
        return c41129b;
    }

    public C44578g createWebviewStorage() {
        return null;
    }
}
