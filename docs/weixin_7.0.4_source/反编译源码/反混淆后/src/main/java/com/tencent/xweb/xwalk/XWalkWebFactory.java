package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C41128i.C36587a;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.WebView.C46828c;
import com.tencent.xweb.p1115c.C24525f;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import com.tencent.xweb.p1115c.C44577b.C36585b;
import com.tencent.xweb.p1115c.C44578g;
import com.tencent.xweb.p1115c.C44581k.C44580a;
import com.tencent.xweb.p1115c.C46832h;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.xwalk.C46946n.C24571a;
import com.tencent.xweb.xwalk.p686a.C36603f;
import com.tencent.xweb.xwalk.p687b.C24553a;
import com.tencent.xweb.xwalk.p687b.C24553a.C24555a;
import com.tencent.xweb.xwalk.p687b.C36608e;
import com.tencent.xweb.xwalk.p687b.C41136c;
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

public class XWalkWebFactory implements C44580a {
    private static final String TAG = "XWalkWebFactory";
    static XWalkWebFactory sInstance;
    private boolean mIsDebugMode = false;
    private boolean mIsDebugModeReplase = false;

    /* renamed from: com.tencent.xweb.xwalk.XWalkWebFactory$a */
    static class C31152a {
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

        /* renamed from: jE */
        public static boolean m50239jE(Context context) {
            AppMethodBeat.m2504i(85397);
            boolean z;
            if (lCa) {
                z = lCa;
                AppMethodBeat.m2505o(85397);
                return z;
            }
            Log.m81049i("XWebViewHelper", "preInit");
            if (C6070j.m9545fE(context)) {
                Log.m81049i("XWebViewHelper", "preInit finished");
                lCa = true;
                AQJ = true;
            } else {
                Log.m81049i("XWebViewHelper", "preInit xwalk is not available");
            }
            z = lCa;
            AppMethodBeat.m2505o(85397);
            return z;
        }

        public static void initCallback(WebViewExtensionListener webViewExtensionListener) {
            AppMethodBeat.m2504i(85398);
            if (APR) {
                AppMethodBeat.m2505o(85398);
                return;
            }
            Log.m81049i("XWebViewHelper", "initCallback");
            WebViewExtension.SetExtension(webViewExtensionListener);
            APR = true;
            AppMethodBeat.m2505o(85398);
        }
    }

    public static XWalkWebFactory getInstance() {
        AppMethodBeat.m2504i(85399);
        if (sInstance == null) {
            sInstance = new XWalkWebFactory();
        }
        XWalkWebFactory xWalkWebFactory = sInstance;
        AppMethodBeat.m2505o(85399);
        return xWalkWebFactory;
    }

    private XWalkWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.m2504i(85400);
        Object di;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(85400);
            return null;
        } else if (str.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG")) {
            if (objArr == null || objArr.length <= 0) {
                AppMethodBeat.m2505o(85400);
                return null;
            }
            di = C16408a.m25219di(objArr[0]);
            AppMethodBeat.m2505o(85400);
            return di;
        } else if (str.equals("STR_CMD_GET_DEBUG_VIEW")) {
            C31513c c31513c = new C31513c((WebView) objArr[0]);
            AppMethodBeat.m2505o(85400);
            return c31513c;
        } else if (str.equals("STR_CMD_GET_UPDATER")) {
            di = new C24571a();
            AppMethodBeat.m2505o(85400);
            return di;
        } else if (str.equals("STR_CMD_GET_PLUGIN_UPDATER")) {
            di = new C36603f();
            AppMethodBeat.m2505o(85400);
            return di;
        } else if (str.equals("STR_CMD_CLEAR_SCHEDULER")) {
            C41136c.m71568a(null);
            AppMethodBeat.m2505o(85400);
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
                    C24555a avv = C24553a.avv(XWalkEnvironment.getUpdateConfigFullPath());
                    if (avv == null) {
                        XWalkEnvironment.addXWalkInitializeLog("recheck cmds ConfigParser failed ");
                        AppMethodBeat.m2505o(85400);
                        return null;
                    }
                    C44572a.m80957a(avv.ATe, avv.ATc, true);
                    C24532f.m38181nI(68);
                } catch (Exception e) {
                    XWalkEnvironment.addXWalkInitializeLog("recheck cmds failed , " + e.getMessage());
                }
            } else if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW")) {
                tryLoadLocalAssetRuntime((Context) objArr[0], true);
                C31513c.m51006jB((Context) objArr[0]);
            } else if (str.equals("BASE_CONTEXT_CHANGED")) {
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED, objArr);
            } else if (str.equals("STR_CMD_FEATURE_SUPPORT")) {
                di = Boolean.valueOf(XWalkCoreWrapper.hasFeatureStatic(((Integer) objArr[0]).intValue()));
                AppMethodBeat.m2505o(85400);
                return di;
            }
            AppMethodBeat.m2505o(85400);
            return null;
        }
    }

    public C46832h createWebView(WebView webView) {
        AppMethodBeat.m2504i(85401);
        try {
            if (C6070j.m9545fE(webView.getContext())) {
                WebViewExtension.updateExtension(false);
                C6070j c6070j = new C6070j(webView);
                AppMethodBeat.m2505o(85401);
                return c6070j;
            }
        } catch (Exception e) {
            String str = "init xwalk crashed:" + e.getMessage() + ",stacktrace:" + android.util.Log.getStackTraceString(e);
            Log.m81046e(TAG, str);
            XWalkInitializer.addXWalkInitializeLog(str);
        }
        AppMethodBeat.m2505o(85401);
        return null;
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
        AppMethodBeat.m2504i(85402);
        if (this.mIsDebugMode) {
            tryLoadLocalAssetRuntime(context, this.mIsDebugModeReplase);
        }
        AppMethodBeat.m2505o(85402);
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
            AppMethodBeat.m2504i(85403);
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
                    AppMethodBeat.m2505o(85403);
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
                        AppMethodBeat.m2505o(85403);
                    } catch (IOException e4) {
                        if (open != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(85403);
                        return z2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (open != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(85403);
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
                    AppMethodBeat.m2505o(85403);
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
                    AppMethodBeat.m2505o(85403);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(85403);
        }
        return z2;
    }

    public C24525f getJsCore(C36587a c36587a, Context context) {
        C24525f c24525f = null;
        AppMethodBeat.m2504i(85404);
        initWebviewCore(context, null);
        switch (c36587a) {
            case RT_TYPE_J2V8:
            case RT_TYPE_NATIVE_SCRIPT:
                if (C36608e.isXWalkReady()) {
                    if (c36587a != C36587a.RT_TYPE_J2V8) {
                        if (c36587a == C36587a.RT_TYPE_NATIVE_SCRIPT) {
                            c24525f = new C41138h();
                            c24525f.init(1);
                            break;
                        }
                    }
                    c24525f = new C41138h();
                    c24525f.init(0);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(85404);
        return c24525f;
    }

    public boolean initWebviewCore(Context context, C46828c c46828c) {
        AppMethodBeat.m2504i(85405);
        boolean jE = C31152a.m50239jE(context);
        if (c46828c != null) {
            if (jE) {
                c46828c.onCoreInitFinished();
            } else {
                c46828c.mo4528BH();
            }
        }
        AppMethodBeat.m2505o(85405);
        return jE;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.m2504i(85406);
        C31152a.initCallback(webViewExtensionListener);
        AppMethodBeat.m2505o(85406);
    }

    public boolean hasInited() {
        AppMethodBeat.m2504i(85407);
        boolean hasInited = C31152a.hasInited();
        AppMethodBeat.m2505o(85407);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        AppMethodBeat.m2504i(85408);
        boolean hasInitedCallback = C31152a.hasInitedCallback();
        AppMethodBeat.m2505o(85408);
        return hasInitedCallback;
    }

    public boolean isCoreReady() {
        AppMethodBeat.m2504i(85409);
        boolean isCoreReady = C31152a.isCoreReady();
        AppMethodBeat.m2505o(85409);
        return isCoreReady;
    }

    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.m2504i(85410);
        if (WebView.getCurWebType() != C44570d.WV_KIND_CW) {
            AppMethodBeat.m2505o(85410);
            return;
        }
        try {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                AppMethodBeat.m2505o(85410);
                return;
            }
            XWalkView xWalkView = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
            xWalkView.removeJavascriptInterface("searchBoxJavaBridge_");
            xWalkView.removeJavascriptInterface("accessibility");
            xWalkView.removeJavascriptInterface("accessibilityTraversal");
            xWalkView.clearCache(true);
            XWalkViewDatabase.clearFormData();
            if (z) {
                C36584a cookieManager = getCookieManager();
                if (cookieManager != null) {
                    cookieManager.removeAllCookie();
                }
            }
            AppMethodBeat.m2505o(85410);
        } catch (Throwable th) {
            Log.m81046e(TAG, "clearAllWebViewCache exception 1 -- " + th.getMessage());
            AppMethodBeat.m2505o(85410);
        }
    }

    public C36584a getCookieManager() {
        AppMethodBeat.m2504i(85411);
        C24565d c24565d = new C24565d();
        AppMethodBeat.m2505o(85411);
        return c24565d;
    }

    public C36585b getCookieSyncManager() {
        AppMethodBeat.m2504i(85412);
        C6067e c6067e = new C6067e();
        AppMethodBeat.m2505o(85412);
        return c6067e;
    }

    public C44578g createWebviewStorage() {
        AppMethodBeat.m2504i(85413);
        C36618i c36618i = new C36618i();
        AppMethodBeat.m2505o(85413);
        return c36618i;
    }
}
