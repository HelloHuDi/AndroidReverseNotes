package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import com.tencent.xweb.xwalk.a.f;
import com.tencent.xweb.xwalk.b.c;
import com.tencent.xweb.xwalk.b.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkViewDatabase;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory implements com.tencent.xweb.c.k.a {
    private static final String TAG = "XWalkWebFactory";
    static XWalkWebFactory sInstance;
    private boolean mIsDebugMode = false;
    private boolean mIsDebugModeReplase = false;

    static class a {
        private static boolean APR = false;
        private static boolean AQJ = false;
        private static boolean lCa = false;

        public static boolean hasInited() {
            return lCa;
        }

        public static boolean hasInitedCallback() {
            return APR;
        }

        public static boolean isCoreReady() {
            return AQJ;
        }

        public static boolean jE(Context context) {
            AppMethodBeat.i(85397);
            boolean z;
            if (lCa) {
                z = lCa;
                AppMethodBeat.o(85397);
                return z;
            }
            Log.i("XWebViewHelper", "preInit");
            if (j.fE(context)) {
                Log.i("XWebViewHelper", "preInit finished");
                lCa = true;
                AQJ = true;
            } else {
                Log.i("XWebViewHelper", "preInit xwalk is not available");
            }
            z = lCa;
            AppMethodBeat.o(85397);
            return z;
        }

        public static void initCallback(WebViewExtensionListener webViewExtensionListener) {
            AppMethodBeat.i(85398);
            if (APR) {
                AppMethodBeat.o(85398);
                return;
            }
            Log.i("XWebViewHelper", "initCallback");
            WebViewExtension.SetExtension(webViewExtensionListener);
            APR = true;
            AppMethodBeat.o(85398);
        }
    }

    public static XWalkWebFactory getInstance() {
        AppMethodBeat.i(85399);
        if (sInstance == null) {
            sInstance = new XWalkWebFactory();
        }
        XWalkWebFactory xWalkWebFactory = sInstance;
        AppMethodBeat.o(85399);
        return xWalkWebFactory;
    }

    private XWalkWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.i(85400);
        Object di;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(85400);
            return null;
        } else if (str.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG")) {
            if (objArr == null || objArr.length <= 0) {
                AppMethodBeat.o(85400);
                return null;
            }
            di = a.di(objArr[0]);
            AppMethodBeat.o(85400);
            return di;
        } else if (str.equals("STR_CMD_GET_DEBUG_VIEW")) {
            c cVar = new c((WebView) objArr[0]);
            AppMethodBeat.o(85400);
            return cVar;
        } else if (str.equals("STR_CMD_GET_UPDATER")) {
            di = new com.tencent.xweb.xwalk.n.a();
            AppMethodBeat.o(85400);
            return di;
        } else if (str.equals("STR_CMD_GET_PLUGIN_UPDATER")) {
            di = new f();
            AppMethodBeat.o(85400);
            return di;
        } else if (str.equals("STR_CMD_CLEAR_SCHEDULER")) {
            c.a(null);
            AppMethodBeat.o(85400);
            return null;
        } else {
            if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE")) {
                this.mIsDebugMode = true;
                this.mIsDebugModeReplase = true;
            } else if (str.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE")) {
                this.mIsDebugMode = true;
                this.mIsDebugModeReplase = false;
            } else if (str.equals("STR_CMD_SET_RECHECK_COMMAND")) {
                try {
                    com.tencent.xweb.xwalk.b.a.a avv = com.tencent.xweb.xwalk.b.a.avv(XWalkEnvironment.getUpdateConfigFullPath());
                    if (avv == null) {
                        XWalkEnvironment.addXWalkInitializeLog("recheck cmds ConfigParser failed ");
                        AppMethodBeat.o(85400);
                        return null;
                    }
                    com.tencent.xweb.a.a(avv.ATe, avv.ATc, true);
                    com.tencent.xweb.util.f.nI(68);
                } catch (Exception e) {
                    XWalkEnvironment.addXWalkInitializeLog("recheck cmds failed , " + e.getMessage());
                }
            } else if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW")) {
                tryLoadLocalAssetRuntime((Context) objArr[0], true);
                c.jB((Context) objArr[0]);
            } else if (str.equals("BASE_CONTEXT_CHANGED")) {
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED, objArr);
            } else if (str.equals("STR_CMD_FEATURE_SUPPORT")) {
                di = Boolean.valueOf(XWalkCoreWrapper.hasFeatureStatic(((Integer) objArr[0]).intValue()));
                AppMethodBeat.o(85400);
                return di;
            }
            AppMethodBeat.o(85400);
            return null;
        }
    }

    public h createWebView(WebView webView) {
        AppMethodBeat.i(85401);
        try {
            if (j.fE(webView.getContext())) {
                WebViewExtension.updateExtension(false);
                j jVar = new j(webView);
                AppMethodBeat.o(85401);
                return jVar;
            }
        } catch (Exception e) {
            String str = "init xwalk crashed:" + e.getMessage() + ",stacktrace:" + android.util.Log.getStackTraceString(e);
            Log.e(TAG, str);
            XWalkInitializer.addXWalkInitializeLog(str);
        }
        AppMethodBeat.o(85401);
        return null;
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
        AppMethodBeat.i(85402);
        if (this.mIsDebugMode) {
            tryLoadLocalAssetRuntime(context, this.mIsDebugModeReplase);
        }
        AppMethodBeat.o(85402);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A:{SYNTHETIC, Splitter:B:28:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A:{SYNTHETIC, Splitter:B:31:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008d A:{SYNTHETIC, Splitter:B:54:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0092 A:{SYNTHETIC, Splitter:B:57:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008d A:{SYNTHETIC, Splitter:B:54:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0092 A:{SYNTHETIC, Splitter:B:57:0x0092} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean tryLoadLocalAssetRuntime(Context context, boolean z) {
        InputStream open;
        FileOutputStream fileOutputStream;
        Throwable th;
        boolean z2 = false;
        synchronized (XWalkWebFactory.class) {
            AppMethodBeat.i(85403);
            XWalkEnvironment.init(context);
            if (z && XWalkEnvironment.getAvailableVersion() == 100000) {
                XWalkEnvironment.delApiVersion(100000);
            }
            if (XWalkEnvironment.getAvailableVersion() == -1 || z) {
                try {
                    open = context.getAssets().open(XWalkEnvironment.LOCAL_TEST_ZIP_NAME);
                } catch (IOException e) {
                    fileOutputStream = null;
                    open = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    open = null;
                    if (open != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(85403);
                    throw th;
                }
                try {
                    File file = new File(XWalkEnvironment.getDownloadZipDir(100000));
                    if (file.exists()) {
                        file.delete();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1048576];
                        while (true) {
                            int read = open.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        XWalkUpdater.updateLocalXWalkRuntime();
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception e2) {
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                        }
                        z2 = true;
                        AppMethodBeat.o(85403);
                    } catch (IOException e4) {
                        if (open != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(85403);
                        return z2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (open != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(85403);
                        throw th;
                    }
                } catch (IOException e5) {
                    fileOutputStream = null;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    AppMethodBeat.o(85403);
                    return z2;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e8) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e9) {
                        }
                    }
                    AppMethodBeat.o(85403);
                    throw th;
                }
            }
            AppMethodBeat.o(85403);
        }
        return z2;
    }

    public com.tencent.xweb.c.f getJsCore(com.tencent.xweb.i.a aVar, Context context) {
        com.tencent.xweb.c.f fVar = null;
        AppMethodBeat.i(85404);
        initWebviewCore(context, null);
        switch (aVar) {
            case RT_TYPE_J2V8:
            case RT_TYPE_NATIVE_SCRIPT:
                if (e.isXWalkReady()) {
                    if (aVar != com.tencent.xweb.i.a.RT_TYPE_J2V8) {
                        if (aVar == com.tencent.xweb.i.a.RT_TYPE_NATIVE_SCRIPT) {
                            fVar = new h();
                            fVar.init(1);
                            break;
                        }
                    }
                    fVar = new h();
                    fVar.init(0);
                    break;
                }
                break;
        }
        AppMethodBeat.o(85404);
        return fVar;
    }

    public boolean initWebviewCore(Context context, WebView.c cVar) {
        AppMethodBeat.i(85405);
        boolean jE = a.jE(context);
        if (cVar != null) {
            if (jE) {
                cVar.onCoreInitFinished();
            } else {
                cVar.BH();
            }
        }
        AppMethodBeat.o(85405);
        return jE;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.i(85406);
        a.initCallback(webViewExtensionListener);
        AppMethodBeat.o(85406);
    }

    public boolean hasInited() {
        AppMethodBeat.i(85407);
        boolean hasInited = a.hasInited();
        AppMethodBeat.o(85407);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        AppMethodBeat.i(85408);
        boolean hasInitedCallback = a.hasInitedCallback();
        AppMethodBeat.o(85408);
        return hasInitedCallback;
    }

    public boolean isCoreReady() {
        AppMethodBeat.i(85409);
        boolean isCoreReady = a.isCoreReady();
        AppMethodBeat.o(85409);
        return isCoreReady;
    }

    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(85410);
        if (WebView.getCurWebType() != d.WV_KIND_CW) {
            AppMethodBeat.o(85410);
            return;
        }
        try {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                AppMethodBeat.o(85410);
                return;
            }
            XWalkView xWalkView = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
            xWalkView.removeJavascriptInterface("searchBoxJavaBridge_");
            xWalkView.removeJavascriptInterface("accessibility");
            xWalkView.removeJavascriptInterface("accessibilityTraversal");
            xWalkView.clearCache(true);
            XWalkViewDatabase.clearFormData();
            if (z) {
                com.tencent.xweb.c.b.a cookieManager = getCookieManager();
                if (cookieManager != null) {
                    cookieManager.removeAllCookie();
                }
            }
            AppMethodBeat.o(85410);
        } catch (Throwable th) {
            Log.e(TAG, "clearAllWebViewCache exception 1 -- " + th.getMessage());
            AppMethodBeat.o(85410);
        }
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        AppMethodBeat.i(85411);
        d dVar = new d();
        AppMethodBeat.o(85411);
        return dVar;
    }

    public b getCookieSyncManager() {
        AppMethodBeat.i(85412);
        e eVar = new e();
        AppMethodBeat.o(85412);
        return eVar;
    }

    public g createWebviewStorage() {
        AppMethodBeat.i(85413);
        i iVar = new i();
        AppMethodBeat.o(85413);
        return iVar;
    }
}
