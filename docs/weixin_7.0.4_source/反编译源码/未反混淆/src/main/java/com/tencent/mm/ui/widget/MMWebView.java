package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.xweb.WebView;
import java.lang.reflect.Method;
import java.net.URL;

public class MMWebView extends WebView {
    public static final com.tencent.xweb.WebView.d zNq = com.tencent.xweb.WebView.d.WV_KIND_X5;
    public static String zNr = null;
    private boolean htt;
    public boolean inited;
    private OnTouchListener jZu;
    private String uFw;
    private s zNp;
    protected boolean zNs;
    private boolean zNt;
    private ViewGroup zNu;
    public d zNv;

    public interface d {
        void onWebViewScrollChanged(int i, int i2, int i3, int i4);
    }

    class b {
        private b() {
        }

        /* synthetic */ b(MMWebView mMWebView, byte b) {
            this();
        }
    }

    class c {
        private c() {
        }

        /* synthetic */ c(MMWebView mMWebView, byte b) {
            this();
        }

        public static void e(WebView webView) {
            AppMethodBeat.i(107939);
            webView.setScrollbarFadingEnabled(true);
            webView.setScrollBarStyle(0);
            AppMethodBeat.o(107939);
        }
    }

    public static class a {
        public static MMWebView im(Context context) {
            AppMethodBeat.i(107935);
            try {
                ab.i("MMWebView", "TRACE_ORDER:MMWebView.java");
                WebView.initWebviewCore(context, MMWebView.zNq, "tools", null);
                MMWebView.il(context);
                MMWebView mMWebView = new MMWebView(context, null, 0, com.tencent.xweb.WebView.d.WV_KIND_SYS);
                mMWebView.inited = true;
                mMWebView.isX5Kernel = mMWebView.getIsX5Kernel();
                AppMethodBeat.o(107935);
                return mMWebView;
            } catch (Exception e) {
                AppMethodBeat.o(107935);
                return null;
            }
        }

        public static MMWebView in(Context context) {
            AppMethodBeat.i(107936);
            ab.i("MMWebView", "TRACE_ORDER:MMWebView.java");
            WebView.initWebviewCore(context, MMWebView.zNq, "tools", null);
            MMWebView.il(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.inited = true;
            mMWebView.isX5Kernel = mMWebView.getIsX5Kernel();
            AppMethodBeat.o(107936);
            return mMWebView;
        }

        public static MMWebView n(Activity activity, int i) {
            boolean z = true;
            AppMethodBeat.i(107937);
            MMWebView.il(activity);
            MMWebView mMWebView = (MMWebView) activity.findViewById(i);
            mMWebView.inited = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.isX5Kernel = z;
            AppMethodBeat.o(107937);
            return mMWebView;
        }

        public static MMWebView g(Context context, View view) {
            boolean z = true;
            AppMethodBeat.i(107938);
            MMWebView.il(context);
            MMWebView mMWebView = (MMWebView) view.findViewById(R.id.edf);
            mMWebView.inited = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.isX5Kernel = z;
            AppMethodBeat.o(107938);
            return mMWebView;
        }
    }

    public s getPerformanceHelper() {
        return this.zNp;
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, com.tencent.xweb.WebView.d.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, com.tencent.xweb.WebView.d.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i, com.tencent.xweb.WebView.d dVar) {
        super(context, attributeSet, i, dVar);
        AppMethodBeat.i(107940);
        this.zNp = new s();
        this.inited = false;
        this.zNs = false;
        this.zNt = false;
        this.zNv = null;
        setBackgroundColor(-1);
        dKG();
        AppMethodBeat.o(107940);
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(107941);
        super.loadUrl(str);
        AppMethodBeat.o(107941);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(11)
    public final void dKG() {
        AppMethodBeat.i(107942);
        try {
            if (VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
            AppMethodBeat.o(107942);
        } catch (Exception e) {
            ab.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", e.getMessage());
            AppMethodBeat.o(107942);
        }
    }

    public final void dKH() {
        AppMethodBeat.i(107943);
        if (VERSION.SDK_INT >= 5) {
            c cVar = new c(this, (byte) 0);
            c.e(this);
            AppMethodBeat.o(107943);
            return;
        }
        b bVar = new b(this, (byte) 0);
        setScrollBarStyle(0);
        AppMethodBeat.o(107943);
    }

    public final void dKI() {
        AppMethodBeat.i(107944);
        if (VERSION.SDK_INT >= 8) {
            getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        }
        AppMethodBeat.o(107944);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(107945);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(107945);
            return;
        }
        int i;
        if (com.tencent.mm.compatible.util.d.iW(19) || this.isX5Kernel) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            super.evaluateJavascript(str, valueCallback);
            AppMethodBeat.o(107945);
        } else if (this.zNs && a(this, str)) {
            AppMethodBeat.o(107945);
        } else {
            try {
                if (!str.startsWith("javascript:")) {
                    str = "javascript:".concat(String.valueOf(str));
                }
                super.loadUrl(str);
                AppMethodBeat.o(107945);
            } catch (Exception e) {
                ab.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", e.getMessage());
                AppMethodBeat.o(107945);
            }
        }
    }

    public void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(107946);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(107946);
    }

    public void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(107947);
        super.evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(107947);
    }

    private static boolean a(MMWebView mMWebView, String str) {
        AppMethodBeat.i(107948);
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{Message.obtain(null, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, str)});
            AppMethodBeat.o(107948);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", e);
            AppMethodBeat.o(107948);
            return false;
        }
    }

    public void setCompetitorView(ViewGroup viewGroup) {
        this.zNu = viewGroup;
    }

    public boolean getIsX5Kernel() {
        return this.isX5Kernel;
    }

    public final void dKJ() {
        AppMethodBeat.i(107949);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(107934);
                if (MMWebView.this.getIsX5Kernel()) {
                    int action = motionEvent.getAction();
                    if (MMWebView.this.zNu != null) {
                        switch (action & 255) {
                            case 0:
                            case 2:
                                MMWebView.this.zNu.requestDisallowInterceptTouchEvent(true);
                                break;
                            case 1:
                            case 3:
                                MMWebView.this.zNu.requestDisallowInterceptTouchEvent(false);
                                break;
                            default:
                                MMWebView.this.zNu.requestDisallowInterceptTouchEvent(true);
                                break;
                        }
                    }
                    if (MMWebView.this.jZu != null) {
                        boolean onTouch = MMWebView.this.jZu.onTouch(view, motionEvent);
                        AppMethodBeat.o(107934);
                        return onTouch;
                    }
                }
                AppMethodBeat.o(107934);
                return false;
            }
        });
        AppMethodBeat.o(107949);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.jZu = onTouchListener;
    }

    @TargetApi(9)
    public final boolean c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.i(107950);
        boolean super_overScrollBy = super.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        if (i4 < 0 || (i4 == 0 && i2 < 0)) {
            this.zNt = true;
        }
        AppMethodBeat.o(107950);
        return super_overScrollBy;
    }

    public final boolean Q(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(107951);
        int action = motionEvent.getAction();
        boolean super_onTouchEvent = super.super_onTouchEvent(motionEvent);
        switch (action & 255) {
            case 0:
                this.zNt = false;
                break;
            case 2:
                if (this.zNu != null) {
                    if (!this.zNt) {
                        this.zNu.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    this.zNu.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        if (!super_onTouchEvent) {
            z = super_onTouchEvent;
        } else if (this.zNt) {
            z = false;
        }
        AppMethodBeat.o(107951);
        return z;
    }

    @TargetApi(9)
    public final void e(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(107952);
        super.super_onOverScrolled(i, i2, z, z2);
        AppMethodBeat.o(107952);
    }

    public final boolean R(MotionEvent motionEvent) {
        AppMethodBeat.i(107953);
        boolean super_dispatchTouchEvent = super.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(107953);
        return super_dispatchTouchEvent;
    }

    public final boolean S(MotionEvent motionEvent) {
        AppMethodBeat.i(107954);
        boolean super_onInterceptTouchEvent = super.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(107954);
        return super_onInterceptTouchEvent;
    }

    @TargetApi(9)
    public final void dKK() {
        AppMethodBeat.i(107955);
        super.super_computeScroll();
        AppMethodBeat.o(107955);
    }

    public final void M(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107956);
        super.super_onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(107956);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void il(Context context) {
        boolean z;
        AppMethodBeat.i(107957);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        ab.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", sharedPreferences.getString("tbs_webview_disable", AppEventsConstants.EVENT_PARAM_VALUE_NO), sharedPreferences.getString("tbs_webview_min_sdk_version", null), sharedPreferences.getString("tbs_webview_max_sdk_version", null));
        if ("1".equals(sharedPreferences.getString("tbs_webview_disable", AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            int i = bo.getInt(r4, 0);
            int i2 = bo.getInt(r5, 0);
            int i3 = VERSION.SDK_INT;
            if (i3 >= i && (i3 <= i2 || i2 == 0)) {
                ab.i("MicroMsg.MMWebView", "in selection, disable x5");
                z = false;
                ab.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(z));
                if (!z) {
                    com.tencent.xweb.x5.sdk.d.forceSysWebView();
                }
                ab.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(g.dnY()));
                if (!sharedPreferences.getBoolean("tbs_download_oversea", false) && r3) {
                    com.tencent.xweb.x5.sdk.d.forceSysWebView();
                }
                AppMethodBeat.o(107957);
            }
        }
        z = true;
        ab.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(z));
        if (z) {
        }
        ab.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(g.dnY()));
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
        AppMethodBeat.o(107957);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107958);
        super.onWebViewScrollChanged(i, i2, i3, i4);
        if (this.zNv != null) {
            this.zNv.onWebViewScrollChanged(i, i2, i3, i4);
        }
        AppMethodBeat.o(107958);
    }

    public String getRandomStr() {
        return this.uFw;
    }

    public void setRandomStr(String str) {
        this.uFw = str;
    }

    public void setPreload(boolean z) {
        this.htt = z;
    }
}
