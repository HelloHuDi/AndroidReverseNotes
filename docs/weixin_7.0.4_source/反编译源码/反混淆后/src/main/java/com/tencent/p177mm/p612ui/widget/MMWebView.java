package com.tencent.p177mm.p612ui.widget;

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
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.pluginsdk.C44071s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.lang.reflect.Method;
import java.net.URL;

/* renamed from: com.tencent.mm.ui.widget.MMWebView */
public class MMWebView extends WebView {
    public static final C44570d zNq = C44570d.WV_KIND_X5;
    public static String zNr = null;
    private boolean htt;
    public boolean inited;
    private OnTouchListener jZu;
    private String uFw;
    private C44071s zNp;
    protected boolean zNs;
    private boolean zNt;
    private ViewGroup zNu;
    public C15990d zNv;

    /* renamed from: com.tencent.mm.ui.widget.MMWebView$d */
    public interface C15990d {
        void onWebViewScrollChanged(int i, int i2, int i3, int i4);
    }

    /* renamed from: com.tencent.mm.ui.widget.MMWebView$b */
    class C24087b {
        private C24087b() {
        }

        /* synthetic */ C24087b(MMWebView mMWebView, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.MMWebView$1 */
    class C307961 implements OnTouchListener {
        C307961() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107934);
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
                    AppMethodBeat.m2505o(107934);
                    return onTouch;
                }
            }
            AppMethodBeat.m2505o(107934);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.MMWebView$c */
    class C30797c {
        private C30797c() {
        }

        /* synthetic */ C30797c(MMWebView mMWebView, byte b) {
            this();
        }

        /* renamed from: e */
        public static void m49142e(WebView webView) {
            AppMethodBeat.m2504i(107939);
            webView.setScrollbarFadingEnabled(true);
            webView.setScrollBarStyle(0);
            AppMethodBeat.m2505o(107939);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.MMWebView$a */
    public static class C30798a {
        /* renamed from: im */
        public static MMWebView m49144im(Context context) {
            AppMethodBeat.m2504i(107935);
            try {
                C4990ab.m7416i("MMWebView", "TRACE_ORDER:MMWebView.java");
                WebView.initWebviewCore(context, MMWebView.zNq, "tools", null);
                MMWebView.m49133il(context);
                MMWebView mMWebView = new MMWebView(context, null, 0, C44570d.WV_KIND_SYS);
                mMWebView.inited = true;
                mMWebView.isX5Kernel = mMWebView.getIsX5Kernel();
                AppMethodBeat.m2505o(107935);
                return mMWebView;
            } catch (Exception e) {
                AppMethodBeat.m2505o(107935);
                return null;
            }
        }

        /* renamed from: in */
        public static MMWebView m49145in(Context context) {
            AppMethodBeat.m2504i(107936);
            C4990ab.m7416i("MMWebView", "TRACE_ORDER:MMWebView.java");
            WebView.initWebviewCore(context, MMWebView.zNq, "tools", null);
            MMWebView.m49133il(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.inited = true;
            mMWebView.isX5Kernel = mMWebView.getIsX5Kernel();
            AppMethodBeat.m2505o(107936);
            return mMWebView;
        }

        /* renamed from: n */
        public static MMWebView m49146n(Activity activity, int i) {
            boolean z = true;
            AppMethodBeat.m2504i(107937);
            MMWebView.m49133il(activity);
            MMWebView mMWebView = (MMWebView) activity.findViewById(i);
            mMWebView.inited = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.isX5Kernel = z;
            AppMethodBeat.m2505o(107937);
            return mMWebView;
        }

        /* renamed from: g */
        public static MMWebView m49143g(Context context, View view) {
            boolean z = true;
            AppMethodBeat.m2504i(107938);
            MMWebView.m49133il(context);
            MMWebView mMWebView = (MMWebView) view.findViewById(2131827552);
            mMWebView.inited = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.isX5Kernel = z;
            AppMethodBeat.m2505o(107938);
            return mMWebView;
        }
    }

    public C44071s getPerformanceHelper() {
        return this.zNp;
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, C44570d.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, C44570d.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i, C44570d c44570d) {
        super(context, attributeSet, i, c44570d);
        AppMethodBeat.m2504i(107940);
        this.zNp = new C44071s();
        this.inited = false;
        this.zNs = false;
        this.zNt = false;
        this.zNv = null;
        setBackgroundColor(-1);
        dKG();
        AppMethodBeat.m2505o(107940);
    }

    public void loadUrl(String str) {
        AppMethodBeat.m2504i(107941);
        super.loadUrl(str);
        AppMethodBeat.m2505o(107941);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(11)
    public final void dKG() {
        AppMethodBeat.m2504i(107942);
        try {
            if (VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
            AppMethodBeat.m2505o(107942);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(107942);
        }
    }

    public final void dKH() {
        AppMethodBeat.m2504i(107943);
        if (VERSION.SDK_INT >= 5) {
            C30797c c30797c = new C30797c(this, (byte) 0);
            C30797c.m49142e(this);
            AppMethodBeat.m2505o(107943);
            return;
        }
        C24087b c24087b = new C24087b(this, (byte) 0);
        setScrollBarStyle(0);
        AppMethodBeat.m2505o(107943);
    }

    public final void dKI() {
        AppMethodBeat.m2504i(107944);
        if (VERSION.SDK_INT >= 8) {
            getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        }
        AppMethodBeat.m2505o(107944);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(107945);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(107945);
            return;
        }
        int i;
        if (C1443d.m3068iW(19) || this.isX5Kernel) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            super.evaluateJavascript(str, valueCallback);
            AppMethodBeat.m2505o(107945);
        } else if (this.zNs && MMWebView.m49126a(this, str)) {
            AppMethodBeat.m2505o(107945);
        } else {
            try {
                if (!str.startsWith("javascript:")) {
                    str = "javascript:".concat(String.valueOf(str));
                }
                super.loadUrl(str);
                AppMethodBeat.m2505o(107945);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", e.getMessage());
                AppMethodBeat.m2505o(107945);
            }
        }
    }

    /* renamed from: a */
    public void mo49219a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(107946);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(107946);
    }

    /* renamed from: a */
    public void mo49220a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(107947);
        super.evaluateJavascript(str3, valueCallback);
        AppMethodBeat.m2505o(107947);
    }

    /* renamed from: a */
    private static boolean m49126a(MMWebView mMWebView, String str) {
        AppMethodBeat.m2504i(107948);
        try {
            Object obj = new C1438c(new C1438c(new C1438c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{Message.obtain(null, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, str)});
            AppMethodBeat.m2505o(107948);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMWebView", "reflectJSExec, e = %s", e);
            AppMethodBeat.m2505o(107948);
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
        AppMethodBeat.m2504i(107949);
        super.setOnTouchListener(new C307961());
        AppMethodBeat.m2505o(107949);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.jZu = onTouchListener;
    }

    @TargetApi(9)
    /* renamed from: c */
    public final boolean mo49221c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.m2504i(107950);
        boolean super_overScrollBy = super.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        if (i4 < 0 || (i4 == 0 && i2 < 0)) {
            this.zNt = true;
        }
        AppMethodBeat.m2505o(107950);
        return super_overScrollBy;
    }

    /* renamed from: Q */
    public final boolean mo49216Q(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.m2504i(107951);
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
        AppMethodBeat.m2505o(107951);
        return z;
    }

    @TargetApi(9)
    /* renamed from: e */
    public final void mo49227e(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(107952);
        super.super_onOverScrolled(i, i2, z, z2);
        AppMethodBeat.m2505o(107952);
    }

    /* renamed from: R */
    public final boolean mo49217R(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107953);
        boolean super_dispatchTouchEvent = super.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(107953);
        return super_dispatchTouchEvent;
    }

    /* renamed from: S */
    public final boolean mo49218S(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107954);
        boolean super_onInterceptTouchEvent = super.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(107954);
        return super_onInterceptTouchEvent;
    }

    @TargetApi(9)
    public final void dKK() {
        AppMethodBeat.m2504i(107955);
        super.super_computeScroll();
        AppMethodBeat.m2505o(107955);
    }

    /* renamed from: M */
    public final void mo49215M(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107956);
        super.super_onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(107956);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: il */
    public static void m49133il(Context context) {
        boolean z;
        AppMethodBeat.m2504i(107957);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        C4990ab.m7417i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", sharedPreferences.getString("tbs_webview_disable", AppEventsConstants.EVENT_PARAM_VALUE_NO), sharedPreferences.getString("tbs_webview_min_sdk_version", null), sharedPreferences.getString("tbs_webview_max_sdk_version", null));
        if ("1".equals(sharedPreferences.getString("tbs_webview_disable", AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            int i = C5046bo.getInt(r4, 0);
            int i2 = C5046bo.getInt(r5, 0);
            int i3 = VERSION.SDK_INT;
            if (i3 >= i && (i3 <= i2 || i2 == 0)) {
                C4990ab.m7416i("MicroMsg.MMWebView", "in selection, disable x5");
                z = false;
                C4990ab.m7417i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(z));
                if (!z) {
                    C24544d.forceSysWebView();
                }
                C4990ab.m7417i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(C5059g.dnY()));
                if (!sharedPreferences.getBoolean("tbs_download_oversea", false) && r3) {
                    C24544d.forceSysWebView();
                }
                AppMethodBeat.m2505o(107957);
            }
        }
        z = true;
        C4990ab.m7417i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(z));
        if (z) {
        }
        C4990ab.m7417i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(C5059g.dnY()));
        C24544d.forceSysWebView();
        AppMethodBeat.m2505o(107957);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107958);
        super.onWebViewScrollChanged(i, i2, i3, i4);
        if (this.zNv != null) {
            this.zNv.onWebViewScrollChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(107958);
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
