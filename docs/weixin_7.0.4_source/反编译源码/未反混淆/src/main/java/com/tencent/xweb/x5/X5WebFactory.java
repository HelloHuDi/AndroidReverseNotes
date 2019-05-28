package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.h;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.e;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.g;
import com.tencent.xweb.x5.sdk.i;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class X5WebFactory implements com.tencent.xweb.c.k.a {
    private static final String TAG = "MicroMsg.X5WebFactory";
    static X5WebFactory sInstance;

    class a extends TbsLogClient {
        public a(Context context) {
            super(context);
        }

        public final void writeLog(String str) {
            AppMethodBeat.i(84857);
            super.writeLog(str);
            AppMethodBeat.o(84857);
        }

        public final void writeLogToDisk() {
            AppMethodBeat.i(84858);
            super.writeLogToDisk();
            AppMethodBeat.o(84858);
        }

        public final void showLog(String str) {
            AppMethodBeat.i(84859);
            super.showLog(str);
            AppMethodBeat.o(84859);
        }

        public final void setLogView(TextView textView) {
            AppMethodBeat.i(84860);
            super.setLogView(textView);
            AppMethodBeat.o(84860);
        }

        public final void i(String str, String str2) {
            AppMethodBeat.i(84861);
            super.i(str, str2);
            Log.i(str, str2);
            AppMethodBeat.o(84861);
        }

        public final void e(String str, String str2) {
            AppMethodBeat.i(84862);
            super.e(str, str2);
            Log.e(str, str2);
            AppMethodBeat.o(84862);
        }

        public final void w(String str, String str2) {
            AppMethodBeat.i(84863);
            super.w(str, str2);
            Log.w(str, str2);
            AppMethodBeat.o(84863);
        }

        public final void d(String str, String str2) {
            AppMethodBeat.i(84864);
            super.d(str, str2);
            Log.d(str, str2);
            AppMethodBeat.o(84864);
        }

        public final void v(String str, String str2) {
            AppMethodBeat.i(84865);
            super.v(str, str2);
            Log.v(str, str2);
            AppMethodBeat.o(84865);
        }
    }

    static class b {
        private static boolean AQJ = false;
        private static boolean lCa = false;

        public static boolean hasInited() {
            return lCa;
        }

        public static boolean isCoreReady() {
            return AQJ;
        }

        public static void a(Context context, final c cVar) {
            AppMethodBeat.i(84868);
            if (lCa) {
                AppMethodBeat.o(84868);
                return;
            }
            Log.i("X5WebFactory.preIniter", "preInit");
            lCa = true;
            QbSdk.preInit(context, new PreInitCallback() {
                private boolean AQK = false;
                private boolean AQL = false;

                public final void onCoreInitFinished() {
                    AppMethodBeat.i(84866);
                    this.AQK = true;
                    if (this.AQK && this.AQL && cVar != null) {
                        cVar.onCoreInitFinished();
                        b.AQJ = true;
                    }
                    AppMethodBeat.o(84866);
                }

                public final void onViewInitFinished(boolean z) {
                    AppMethodBeat.i(84867);
                    this.AQL = true;
                    if (this.AQK && this.AQL && cVar != null) {
                        cVar.onCoreInitFinished();
                        b.AQJ = true;
                    }
                    AppMethodBeat.o(84867);
                }
            });
            AppMethodBeat.o(84868);
        }
    }

    public static X5WebFactory getInstance() {
        AppMethodBeat.i(84869);
        if (sInstance == null) {
            sInstance = new X5WebFactory();
        }
        X5WebFactory x5WebFactory = sInstance;
        AppMethodBeat.o(84869);
        return x5WebFactory;
    }

    private X5WebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.i(84870);
        Object eVar;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(84870);
            return null;
        } else if (str.equals("STR_CMD_GET_TBS_QBSDK_IMP")) {
            eVar = new e();
            AppMethodBeat.o(84870);
            return eVar;
        } else if (str.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP")) {
            eVar = new g();
            AppMethodBeat.o(84870);
            return eVar;
        } else {
            AppMethodBeat.o(84870);
            return null;
        }
    }

    public h createWebView(WebView webView) {
        AppMethodBeat.i(84871);
        k kVar = new k(webView);
        AppMethodBeat.o(84871);
        return kVar;
    }

    public void initInterface() {
        AppMethodBeat.i(84872);
        d.a(new e());
        f.a(new g());
        WebView.setX5Interface(new i());
        AppMethodBeat.o(84872);
    }

    public void initEnviroment(Context context) {
        AppMethodBeat.i(84873);
        TbsLog.setTbsLogClient(new a(context));
        AppMethodBeat.o(84873);
    }

    public com.tencent.xweb.c.f getJsCore(com.tencent.xweb.i.a aVar, Context context) {
        AppMethodBeat.i(84874);
        com.tencent.xweb.c.f fVar = null;
        switch (aVar) {
            case RT_TYPE_X5:
                boolean canUseX5JsCore = X5JsCore.canUseX5JsCore(context);
                Log.i(TAG, "canUseX5JsCore : ".concat(String.valueOf(canUseX5JsCore)));
                if (canUseX5JsCore) {
                    if (X5JsCore.canUseX5JsCoreNewAPI(context)) {
                        fVar = new h(context);
                    } else {
                        fVar = new f(context);
                    }
                    fVar.init(0);
                    break;
                }
                break;
        }
        AppMethodBeat.o(84874);
        return fVar;
    }

    public boolean initWebviewCore(Context context, c cVar) {
        AppMethodBeat.i(84875);
        b.a(context, cVar);
        AppMethodBeat.o(84875);
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
    }

    public boolean hasInited() {
        AppMethodBeat.i(84876);
        boolean hasInited = b.hasInited();
        AppMethodBeat.o(84876);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        return true;
    }

    public boolean isCoreReady() {
        AppMethodBeat.i(84877);
        boolean isCoreReady = b.isCoreReady();
        AppMethodBeat.o(84877);
        return isCoreReady;
    }

    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(84878);
        QbSdk.clearAllWebViewCache(context, z);
        AppMethodBeat.o(84878);
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        AppMethodBeat.i(84879);
        d dVar = new d();
        AppMethodBeat.o(84879);
        return dVar;
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        AppMethodBeat.i(84880);
        e eVar = new e();
        AppMethodBeat.o(84880);
        return eVar;
    }

    public com.tencent.xweb.c.g createWebviewStorage() {
        AppMethodBeat.i(84881);
        j jVar = new j();
        AppMethodBeat.o(84881);
        return jVar;
    }
}
