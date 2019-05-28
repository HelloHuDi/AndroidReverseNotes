package com.tencent.xweb.sys;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory implements com.tencent.xweb.c.k.a {
    static SysWebFactory sInstance;

    static class a {
        private static boolean APR = false;
        private static boolean lCa = false;

        public static boolean hasInitedCallback() {
            return APR;
        }

        public static void dUJ() {
        }
    }

    public static SysWebFactory getInstance() {
        AppMethodBeat.i(84662);
        if (sInstance == null) {
            sInstance = new SysWebFactory();
        }
        SysWebFactory sysWebFactory = sInstance;
        AppMethodBeat.o(84662);
        return sysWebFactory;
    }

    private SysWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.i(84663);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(84663);
        } else if (str.equals("STR_CMD_GET_DEBUG_VIEW") || !str.equals("STR_CMD_GET_UPDATER")) {
            AppMethodBeat.o(84663);
        } else {
            AppMethodBeat.o(84663);
        }
        return null;
    }

    public h createWebView(WebView webView) {
        AppMethodBeat.i(84664);
        e eVar = new e(webView);
        AppMethodBeat.o(84664);
        return eVar;
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
    }

    public f getJsCore(com.tencent.xweb.i.a aVar, Context context) {
        return null;
    }

    public boolean initWebviewCore(Context context, c cVar) {
        AppMethodBeat.i(84665);
        if (cVar != null) {
            cVar.onCoreInitFinished();
        }
        AppMethodBeat.o(84665);
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.i(84666);
        a.dUJ();
        AppMethodBeat.o(84666);
    }

    public boolean hasInited() {
        return true;
    }

    public boolean hasInitedCallback() {
        AppMethodBeat.i(84667);
        boolean hasInitedCallback = a.hasInitedCallback();
        AppMethodBeat.o(84667);
        return hasInitedCallback;
    }

    public boolean isCoreReady() {
        return true;
    }

    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(84668);
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
            AppMethodBeat.o(84668);
        } catch (Exception e) {
            Log.e("SysWebFactory", "clearAllWebViewCache failed " + e.getMessage());
            AppMethodBeat.o(84668);
        }
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        AppMethodBeat.i(84669);
        a aVar = new a();
        AppMethodBeat.o(84669);
        return aVar;
    }

    public b getCookieSyncManager() {
        AppMethodBeat.i(84670);
        b bVar = new b();
        AppMethodBeat.o(84670);
        return bVar;
    }

    public g createWebviewStorage() {
        return null;
    }
}
