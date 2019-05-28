package com.tencent.xweb.p685x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.xweb.C41128i.C36587a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C46828c;
import com.tencent.xweb.p1115c.C24525f;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import com.tencent.xweb.p1115c.C44577b.C36585b;
import com.tencent.xweb.p1115c.C44578g;
import com.tencent.xweb.p1115c.C44581k.C44580a;
import com.tencent.xweb.p1115c.C46832h;
import com.tencent.xweb.p685x5.sdk.C24544d;
import com.tencent.xweb.p685x5.sdk.C24546e;
import com.tencent.xweb.p685x5.sdk.C24548f;
import com.tencent.xweb.p685x5.sdk.C41135i;
import com.tencent.xweb.p685x5.sdk.C44594g;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

/* renamed from: com.tencent.xweb.x5.X5WebFactory */
public class X5WebFactory implements C44580a {
    private static final String TAG = "MicroMsg.X5WebFactory";
    static X5WebFactory sInstance;

    /* renamed from: com.tencent.xweb.x5.X5WebFactory$a */
    class C6039a extends TbsLogClient {
        public C6039a(Context context) {
            super(context);
        }

        public final void writeLog(String str) {
            AppMethodBeat.m2504i(84857);
            super.writeLog(str);
            AppMethodBeat.m2505o(84857);
        }

        public final void writeLogToDisk() {
            AppMethodBeat.m2504i(84858);
            super.writeLogToDisk();
            AppMethodBeat.m2505o(84858);
        }

        public final void showLog(String str) {
            AppMethodBeat.m2504i(84859);
            super.showLog(str);
            AppMethodBeat.m2505o(84859);
        }

        public final void setLogView(TextView textView) {
            AppMethodBeat.m2504i(84860);
            super.setLogView(textView);
            AppMethodBeat.m2505o(84860);
        }

        /* renamed from: i */
        public final void mo13228i(String str, String str2) {
            AppMethodBeat.m2504i(84861);
            super.mo13228i(str, str2);
            Log.m81049i(str, str2);
            AppMethodBeat.m2505o(84861);
        }

        /* renamed from: e */
        public final void mo13227e(String str, String str2) {
            AppMethodBeat.m2504i(84862);
            super.mo13227e(str, str2);
            Log.m81046e(str, str2);
            AppMethodBeat.m2505o(84862);
        }

        /* renamed from: w */
        public final void mo13232w(String str, String str2) {
            AppMethodBeat.m2504i(84863);
            super.mo13232w(str, str2);
            Log.m81051w(str, str2);
            AppMethodBeat.m2505o(84863);
        }

        /* renamed from: d */
        public final void mo13226d(String str, String str2) {
            AppMethodBeat.m2504i(84864);
            super.mo13226d(str, str2);
            Log.m81045d(str, str2);
            AppMethodBeat.m2505o(84864);
        }

        /* renamed from: v */
        public final void mo13231v(String str, String str2) {
            AppMethodBeat.m2504i(84865);
            super.mo13231v(str, str2);
            Log.m81050v(str, str2);
            AppMethodBeat.m2505o(84865);
        }
    }

    /* renamed from: com.tencent.xweb.x5.X5WebFactory$b */
    static class C6040b {
        private static boolean AQJ = false;
        private static boolean lCa = false;

        public static boolean hasInited() {
            return lCa;
        }

        public static boolean isCoreReady() {
            return AQJ;
        }

        /* renamed from: a */
        public static void m9517a(Context context, final C46828c c46828c) {
            AppMethodBeat.m2504i(84868);
            if (lCa) {
                AppMethodBeat.m2505o(84868);
                return;
            }
            Log.m81049i("X5WebFactory.preIniter", "preInit");
            lCa = true;
            QbSdk.preInit(context, new PreInitCallback() {
                private boolean AQK = false;
                private boolean AQL = false;

                public final void onCoreInitFinished() {
                    AppMethodBeat.m2504i(84866);
                    this.AQK = true;
                    if (this.AQK && this.AQL && c46828c != null) {
                        c46828c.onCoreInitFinished();
                        C6040b.AQJ = true;
                    }
                    AppMethodBeat.m2505o(84866);
                }

                public final void onViewInitFinished(boolean z) {
                    AppMethodBeat.m2504i(84867);
                    this.AQL = true;
                    if (this.AQK && this.AQL && c46828c != null) {
                        c46828c.onCoreInitFinished();
                        C6040b.AQJ = true;
                    }
                    AppMethodBeat.m2505o(84867);
                }
            });
            AppMethodBeat.m2505o(84868);
        }
    }

    public static X5WebFactory getInstance() {
        AppMethodBeat.m2504i(84869);
        if (sInstance == null) {
            sInstance = new X5WebFactory();
        }
        X5WebFactory x5WebFactory = sInstance;
        AppMethodBeat.m2505o(84869);
        return x5WebFactory;
    }

    private X5WebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.m2504i(84870);
        Object c24546e;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(84870);
            return null;
        } else if (str.equals("STR_CMD_GET_TBS_QBSDK_IMP")) {
            c24546e = new C24546e();
            AppMethodBeat.m2505o(84870);
            return c24546e;
        } else if (str.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP")) {
            c24546e = new C44594g();
            AppMethodBeat.m2505o(84870);
            return c24546e;
        } else {
            AppMethodBeat.m2505o(84870);
            return null;
        }
    }

    public C46832h createWebView(WebView webView) {
        AppMethodBeat.m2504i(84871);
        C6042k c6042k = new C6042k(webView);
        AppMethodBeat.m2505o(84871);
        return c6042k;
    }

    public void initInterface() {
        AppMethodBeat.m2504i(84872);
        C24544d.m38197a(new C24546e());
        C24548f.m38204a(new C44594g());
        WebView.setX5Interface(new C41135i());
        AppMethodBeat.m2505o(84872);
    }

    public void initEnviroment(Context context) {
        AppMethodBeat.m2504i(84873);
        TbsLog.setTbsLogClient(new C6039a(context));
        AppMethodBeat.m2505o(84873);
    }

    public C24525f getJsCore(C36587a c36587a, Context context) {
        AppMethodBeat.m2504i(84874);
        C24525f c24525f = null;
        switch (c36587a) {
            case RT_TYPE_X5:
                boolean canUseX5JsCore = X5JsCore.canUseX5JsCore(context);
                Log.m81049i(TAG, "canUseX5JsCore : ".concat(String.valueOf(canUseX5JsCore)));
                if (canUseX5JsCore) {
                    if (X5JsCore.canUseX5JsCoreNewAPI(context)) {
                        c24525f = new C25018h(context);
                    } else {
                        c24525f = new C41134f(context);
                    }
                    c24525f.init(0);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(84874);
        return c24525f;
    }

    public boolean initWebviewCore(Context context, C46828c c46828c) {
        AppMethodBeat.m2504i(84875);
        C6040b.m9517a(context, c46828c);
        AppMethodBeat.m2505o(84875);
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
    }

    public boolean hasInited() {
        AppMethodBeat.m2504i(84876);
        boolean hasInited = C6040b.hasInited();
        AppMethodBeat.m2505o(84876);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        return true;
    }

    public boolean isCoreReady() {
        AppMethodBeat.m2504i(84877);
        boolean isCoreReady = C6040b.isCoreReady();
        AppMethodBeat.m2505o(84877);
        return isCoreReady;
    }

    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.m2504i(84878);
        QbSdk.clearAllWebViewCache(context, z);
        AppMethodBeat.m2505o(84878);
    }

    public C36584a getCookieManager() {
        AppMethodBeat.m2504i(84879);
        C46835d c46835d = new C46835d();
        AppMethodBeat.m2505o(84879);
        return c46835d;
    }

    public C36585b getCookieSyncManager() {
        AppMethodBeat.m2504i(84880);
        C44590e c44590e = new C44590e();
        AppMethodBeat.m2505o(84880);
        return c44590e;
    }

    public C44578g createWebviewStorage() {
        AppMethodBeat.m2504i(84881);
        C16407j c16407j = new C16407j();
        AppMethodBeat.m2505o(84881);
        return c16407j;
    }
}
