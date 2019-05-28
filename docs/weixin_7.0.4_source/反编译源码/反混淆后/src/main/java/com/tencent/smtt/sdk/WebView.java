package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.p1104a.C40969b;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C30951r;
import com.tencent.smtt.utils.C36447w;
import com.tencent.smtt.utils.C44458d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.xwalk.core.XWalkEnvironment;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    /* renamed from: c */
    private static final Lock f13866c = new ReentrantLock();
    /* renamed from: d */
    private static OutputStream f13867d = null;
    /* renamed from: j */
    private static Context f13868j = null;
    public static boolean mSysWebviewCreated = false;
    public static boolean mWebViewCreated = false;
    /* renamed from: n */
    private static BroadcastReceiver f13869n = null;
    /* renamed from: o */
    private static C36447w f13870o = null;
    /* renamed from: p */
    private static Method f13871p = null;
    /* renamed from: s */
    private static String f13872s = null;
    /* renamed from: y */
    private static Paint f13873y = null;
    /* renamed from: z */
    private static boolean f13874z = true;
    /* renamed from: A */
    private Object f13875A;
    /* renamed from: B */
    private OnLongClickListener f13876B;
    /* renamed from: a */
    int f13877a;
    /* renamed from: b */
    private final String f13878b;
    /* renamed from: e */
    private boolean f13879e;
    /* renamed from: f */
    private IX5WebViewBase f13880f;
    /* renamed from: g */
    private C30942b f13881g;
    /* renamed from: h */
    private WebSettings f13882h;
    /* renamed from: i */
    private Context f13883i;
    /* renamed from: k */
    private boolean f13884k;
    /* renamed from: l */
    private C30943am f13885l;
    /* renamed from: m */
    private boolean f13886m;
    public WebViewCallbackClient mWebViewCallbackClient;
    /* renamed from: q */
    private WebViewClient f13887q;
    /* renamed from: r */
    private WebChromeClient f13888r;
    /* renamed from: t */
    private final int f13889t;
    /* renamed from: u */
    private final int f13890u;
    /* renamed from: v */
    private final int f13891v;
    /* renamed from: w */
    private final String f13892w;
    /* renamed from: x */
    private final String f13893x;

    /* renamed from: com.tencent.smtt.sdk.WebView$a */
    static class C16143a extends BroadcastReceiver {
        private C16143a() {
        }

        /* synthetic */ C16143a(C40977bm c40977bm) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(64840);
            if (intent != null) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int apnType = Apn.getApnType(context);
                        long currentTimeMillis = System.currentTimeMillis();
                        synchronized (QbSdk.f16246h) {
                            if (QbSdk.f16243e) {
                                QbSdk.f16245g += currentTimeMillis - QbSdk.f16244f;
                            }
                            QbSdk.f16244f = currentTimeMillis;
                        }
                        TbsLog.m80430d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.f16245g + " apnType=" + apnType);
                        QbSdk.f16243e = apnType == 3;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(64840);
                    return;
                }
            }
            AppMethodBeat.m2505o(64840);
        }
    }

    public class WebViewTransport {
        /* renamed from: b */
        private WebView f4502b;

        public synchronized WebView getWebView() {
            return this.f4502b;
        }

        public synchronized void setWebView(WebView webView) {
            this.f4502b = webView;
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    /* renamed from: com.tencent.smtt.sdk.WebView$b */
    class C30942b extends android.webkit.WebView {
        public C30942b(WebView webView, Context context) {
            this(context, null);
        }

        public C30942b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.m2504i(64843);
            if (!(QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context))) {
                CookieSyncManager.createInstance(WebView.this.f13883i).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C36439p());
                    WebView.mSysWebviewCreated = true;
                    AppMethodBeat.m2505o(64843);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(64843);
        }

        /* renamed from: a */
        public void mo50019a() {
            AppMethodBeat.m2504i(64849);
            super.computeScroll();
            AppMethodBeat.m2505o(64849);
        }

        /* renamed from: a */
        public void mo50020a(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(64847);
            super.onScrollChanged(i, i2, i3, i4);
            AppMethodBeat.m2505o(64847);
        }

        @TargetApi(9)
        /* renamed from: a */
        public void mo50021a(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(64856);
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
            AppMethodBeat.m2505o(64856);
        }

        @TargetApi(9)
        /* renamed from: a */
        public boolean mo50022a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.m2504i(64854);
            if (VERSION.SDK_INT >= 9) {
                boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.m2505o(64854);
                return overScrollBy;
            }
            AppMethodBeat.m2505o(64854);
            return false;
        }

        /* renamed from: a */
        public boolean mo50023a(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(64851);
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(64851);
            return onTouchEvent;
        }

        /* renamed from: b */
        public boolean mo50024b(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(64858);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(64858);
            return dispatchTouchEvent;
        }

        /* renamed from: c */
        public boolean mo50025c(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(64860);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(64860);
            return onInterceptTouchEvent;
        }

        public void computeScroll() {
            AppMethodBeat.m2504i(64848);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.computeScroll(this);
                AppMethodBeat.m2505o(64848);
                return;
            }
            super.computeScroll();
            AppMethodBeat.m2505o(64848);
        }

        /* Access modifiers changed, original: protected */
        public void dispatchDraw(Canvas canvas) {
            AppMethodBeat.m2504i(64852);
            try {
                super.dispatchDraw(canvas);
                if (!(WebView.f13874z || WebView.f13873y == null)) {
                    canvas.save();
                    canvas.drawPaint(WebView.f13873y);
                    canvas.restore();
                }
                AppMethodBeat.m2505o(64852);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(64852);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(64857);
            boolean dispatchTouchEvent;
            if (WebView.this.mWebViewCallbackClient != null) {
                dispatchTouchEvent = WebView.this.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this);
                AppMethodBeat.m2505o(64857);
                return dispatchTouchEvent;
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(64857);
            return dispatchTouchEvent;
        }

        public WebSettings getSettings() {
            AppMethodBeat.m2504i(64845);
            try {
                WebSettings settings = super.getSettings();
                AppMethodBeat.m2505o(64845);
                return settings;
            } catch (Exception e) {
                AppMethodBeat.m2505o(64845);
                return null;
            }
        }

        public void invalidate() {
            AppMethodBeat.m2504i(64844);
            super.invalidate();
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.invalidate();
            }
            AppMethodBeat.m2505o(64844);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(64859);
            boolean onInterceptTouchEvent;
            if (WebView.this.mWebViewCallbackClient != null) {
                onInterceptTouchEvent = WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
                AppMethodBeat.m2505o(64859);
                return onInterceptTouchEvent;
            }
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(64859);
            return onInterceptTouchEvent;
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(64855);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
                AppMethodBeat.m2505o(64855);
                return;
            }
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
            AppMethodBeat.m2505o(64855);
        }

        /* Access modifiers changed, original: protected */
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(64846);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                AppMethodBeat.m2505o(64846);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            WebView.m49488b(WebView.this, i, i2, i3, i4);
            AppMethodBeat.m2505o(64846);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(64850);
            if (!hasFocus()) {
                requestFocus();
            }
            boolean onTouchEvent;
            if (WebView.this.mWebViewCallbackClient != null) {
                onTouchEvent = WebView.this.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
                AppMethodBeat.m2505o(64850);
                return onTouchEvent;
            }
            try {
                onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(64850);
                return onTouchEvent;
            } catch (Exception e) {
                AppMethodBeat.m2505o(64850);
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.m2504i(64853);
            boolean overScrollBy;
            if (WebView.this.mWebViewCallbackClient != null) {
                overScrollBy = WebView.this.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
                AppMethodBeat.m2505o(64853);
                return overScrollBy;
            } else if (VERSION.SDK_INT >= 9) {
                overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.m2505o(64853);
                return overScrollBy;
            } else {
                AppMethodBeat.m2505o(64853);
                return false;
            }
        }

        public void setOverScrollMode(int i) {
            AppMethodBeat.m2504i(64861);
            try {
                super.setOverScrollMode(i);
                AppMethodBeat.m2505o(64861);
            } catch (Exception e) {
                AppMethodBeat.m2505o(64861);
            }
        }
    }

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        /* renamed from: a */
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult f13895a;
        /* renamed from: b */
        private android.webkit.WebView.HitTestResult f13896b;

        public HitTestResult() {
            this.f13896b = null;
            this.f13895a = null;
            this.f13896b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.f13896b = null;
            this.f13895a = null;
            this.f13896b = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.f13896b = null;
            this.f13895a = hitTestResult;
            this.f13896b = null;
        }

        public String getExtra() {
            AppMethodBeat.m2504i(64842);
            String str = "";
            if (this.f13895a != null) {
                str = this.f13895a.getExtra();
            } else if (this.f13896b != null) {
                str = this.f13896b.getExtra();
            }
            AppMethodBeat.m2505o(64842);
            return str;
        }

        public int getType() {
            AppMethodBeat.m2504i(64841);
            int i = 0;
            if (this.f13895a != null) {
                i = this.f13895a.getType();
            } else if (this.f13896b != null) {
                i = this.f13896b.getType();
            }
            AppMethodBeat.m2505o(64841);
            return i;
        }
    }

    static {
        AppMethodBeat.m2504i(65023);
        AppMethodBeat.m2505o(65023);
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(64862);
        this.f13878b = "WebView";
        this.f13879e = false;
        this.f13882h = null;
        this.f13883i = null;
        this.f13877a = 0;
        this.f13884k = false;
        this.f13885l = null;
        this.f13886m = false;
        this.f13887q = null;
        this.f13888r = null;
        this.f13889t = 1;
        this.f13890u = 2;
        this.f13891v = 3;
        this.f13892w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f13893x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f13875A = null;
        this.f13876B = null;
        mWebViewCreated = true;
        this.f13885l = new C30943am();
        this.f13885l.mo50045a("init_all", (byte) 1);
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.f13883i = context;
            this.f13880f = null;
            this.f13879e = false;
            QbSdk.m71035a(context, "failed to createTBSWebview!");
            this.f13881g = new C30942b(context, attributeSet);
            CookieManager.getInstance().mo70588a(context, true, false);
            CookieSyncManager.createInstance(this.f13883i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C36439p());
                mSysWebviewCreated = true;
            } catch (Exception e) {
            }
            CookieManager.getInstance().mo70587a();
            this.f13881g.setFocusableInTouchMode(true);
            addView(this.f13881g, new LayoutParams(-1, -1));
            TbsLog.m80434i("WebView", "SystemWebView Created Success! #3");
            TbsLog.m80433e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().mo64872a(context, 402, new Throwable());
            AppMethodBeat.m2505o(64862);
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.setWriteLogJIT(true);
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        this.f13885l.mo50045a("tbslog_init", (byte) 1);
        TbsLog.initIfNeed(context);
        this.f13885l.mo50045a("tbslog_init", (byte) 2);
        if (context == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid context argument");
            AppMethodBeat.m2505o(64862);
            throw illegalArgumentException;
        }
        if (f13870o == null) {
            f13870o = C36447w.m60204a(context);
        }
        if (f13870o.f15197a) {
            TbsLog.m80433e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.m71035a(context, "debug.conf force syswebview!");
        }
        m49483a(context, this.f13885l);
        this.f13883i = context;
        if (context != null) {
            f13868j = context.getApplicationContext();
        }
        if (!this.f13879e || QbSdk.f16239a) {
            this.f13880f = null;
            if (TbsShareManager.isThirdPartyApp(this.f13883i)) {
                this.f13881g = new C30942b(context, attributeSet);
            } else {
                this.f13881g = new C30942b(this, context);
            }
            TbsLog.m80434i("WebView", "SystemWebView Created Success! #2");
            CookieManager.getInstance().mo70588a(context, true, false);
            CookieManager.getInstance().mo70587a();
            this.f13881g.setFocusableInTouchMode(true);
            addView(this.f13881g, new LayoutParams(-1, -1));
            setDownloadListener(null);
            m49487b(context);
            TbsLog.writeLogToDisk();
            C5813an.m8802a(context);
        } else {
            this.f13885l.mo50045a("init_x5_webview", (byte) 1);
            this.f13880f = C40978bv.m71073a().mo64918a(true).mo57558a(context);
            this.f13885l.mo50045a("init_x5_webview", (byte) 2);
            if (this.f13880f == null || this.f13880f.getView() == null) {
                TbsLog.m80433e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f13880f = null;
                this.f13879e = false;
                QbSdk.m71035a(context, "failed to createTBSWebview!");
                m49483a(context, this.f13885l);
                if (TbsShareManager.isThirdPartyApp(this.f13883i)) {
                    this.f13881g = new C30942b(context, attributeSet);
                } else {
                    this.f13881g = new C30942b(this, context);
                }
                TbsLog.m80434i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().mo70588a(context, true, false);
                CookieManager.getInstance().mo70587a();
                this.f13881g.setFocusableInTouchMode(true);
                addView(this.f13881g, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                }
                m49487b(context);
                TbsLog.writeLogToDisk();
                C5813an.m8802a(context);
                AppMethodBeat.m2505o(64862);
                return;
            }
            TbsLog.m80434i("WebView", "X5 WebView Created Success!!");
            this.f13880f.getView().setFocusableInTouchMode(true);
            m49484a(attributeSet);
            addView(this.f13880f.getView(), new LayoutParams(-1, -1));
            this.f13880f.setDownloadListener(new C44453b(this, null, this.f13879e));
            this.f13880f.getX5WebViewExtension().setWebViewClientExtension(new C40977bm(this, C40978bv.m71073a().mo64918a(true).mo57603k()));
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
        }
        if ((TbsConfig.APP_QQ.equals(this.f13883i.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.f13883i.getApplicationInfo().packageName)) && C5818o.m8863a(true).mo12204h() && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        if (this.f13880f != null) {
            TbsLog.writeLogToDisk();
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == C5813an.m8800a().mo12174i(context) || i2 != C5813an.m8800a().mo12175j(context)) {
                    TbsLog.m80434i("WebView", "webview construction #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + C5813an.m8800a().mo12174i(context) + " getTbsCoreInstalledVerInNolock is " + C5813an.m8800a().mo12175j(context));
                } else {
                    C5813an.m8800a().mo12180o(context);
                }
            }
        }
        if (this.f13885l != null) {
            this.f13885l.mo50045a("load_url_gap", (byte) 1);
            this.f13885l.mo50045a("init_all", (byte) 2);
        }
        QbSdk.continueLoadSo(context);
        AppMethodBeat.m2505o(64862);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    /* renamed from: a */
    private void m49483a(Context context, C30943am c30943am) {
        AppMethodBeat.m2504i(64873);
        if (QbSdk.f16247i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        if (c30943am != null) {
            c30943am.mo50045a("x5_core_engine_init_sync", (byte) 1);
        }
        C40978bv a = C40978bv.m71073a();
        a.mo64920a(context, c30943am);
        this.f13879e = a.mo64921b();
        AppMethodBeat.m2505o(64873);
    }

    /* renamed from: a */
    private void m49484a(AttributeSet attributeSet) {
        AppMethodBeat.m2504i(64992);
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f13880f.getView().setVerticalScrollBarEnabled(false);
                            this.f13880f.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f13880f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f13880f.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(64992);
                return;
            }
        }
        AppMethodBeat.m2505o(64992);
    }

    /* renamed from: a */
    static /* synthetic */ void m49485a(WebView webView, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(65021);
        webView.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(65021);
    }

    /* renamed from: a */
    private boolean m49486a(View view) {
        AppMethodBeat.m2504i(65003);
        if (this.f13883i == null || getTbsCoreVersion(this.f13883i) <= 36200) {
            Object a = C30951r.m49578a(this.f13875A, "onLongClick", new Class[]{View.class}, view);
            if (a != null) {
                boolean booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(65003);
                return booleanValue;
            }
            AppMethodBeat.m2505o(65003);
            return false;
        }
        AppMethodBeat.m2505o(65003);
        return false;
    }

    /* renamed from: b */
    private void m49487b(Context context) {
        AppMethodBeat.m2504i(64863);
        if (f13869n != null) {
            AppMethodBeat.m2505o(64863);
            return;
        }
        f13869n = new C16143a();
        new C46739bn(this, context).start();
        AppMethodBeat.m2505o(64863);
    }

    /* renamed from: b */
    static /* synthetic */ void m49488b(WebView webView, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(65022);
        webView.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(65022);
    }

    /* renamed from: c */
    private boolean m49489c(Context context) {
        AppMethodBeat.m2504i(64871);
        try {
            if (context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0) {
                AppMethodBeat.m2505o(64871);
                return true;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(64871);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0125 A:{SYNTHETIC, Splitter:B:43:0x0125} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private int m49490d(Context context) {
        FileLock a;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Exception e;
        Throwable th;
        int i = -1;
        AppMethodBeat.m2504i(65000);
        FileOutputStream b = C30950k.m49563b(context, true, "tbslock.txt");
        if (b != null) {
            a = C30950k.m49548a(context, b);
            if (a == null) {
                AppMethodBeat.m2505o(65000);
            } else if (f13866c.tryLock()) {
                fileInputStream = null;
                try {
                    File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                    if (file.exists()) {
                        Properties properties = new Properties();
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream2);
                            fileInputStream2.close();
                            String property = properties.getProperty("PV");
                            if (property == null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    TbsLog.m80432e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                }
                                f13866c.unlock();
                                C30950k.m49552a(a, b);
                                AppMethodBeat.m2505o(65000);
                            } else {
                                i = Integer.parseInt(property);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e22) {
                                    TbsLog.m80432e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                }
                                f13866c.unlock();
                                C30950k.m49552a(a, b);
                                AppMethodBeat.m2505o(65000);
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } else {
                        f13866c.unlock();
                        C30950k.m49552a(a, b);
                        AppMethodBeat.m2505o(65000);
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e222) {
                            TbsLog.m80432e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                        }
                    }
                    f13866c.unlock();
                    C30950k.m49552a(a, b);
                    AppMethodBeat.m2505o(65000);
                    throw th;
                }
            } else {
                C30950k.m49552a(a, b);
                AppMethodBeat.m2505o(65000);
            }
        } else {
            AppMethodBeat.m2505o(65000);
        }
        return i;
        f13866c.unlock();
        C30950k.m49552a(a, b);
        AppMethodBeat.m2505o(65000);
        return i;
        try {
            TbsLog.m80432e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2222) {
                    TbsLog.m80432e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                }
            }
            f13866c.unlock();
            C30950k.m49552a(a, b);
            AppMethodBeat.m2505o(65000);
            return i;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            f13866c.unlock();
            C30950k.m49552a(a, b);
            AppMethodBeat.m2505o(65000);
            throw th;
        }
    }

    /* renamed from: d */
    static void m49491d() {
        AppMethodBeat.m2504i(65008);
        new C46740bu().start();
        AppMethodBeat.m2505o(65008);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        AppMethodBeat.m2504i(64892);
        if (!C40978bv.m71073a().mo64921b()) {
            C30951r.m49579a("android.webkit.WebView", "disablePlatformNotifications");
        }
        AppMethodBeat.m2505o(64892);
    }

    /* renamed from: e */
    private void m49493e(Context context) {
        AppMethodBeat.m2504i(65002);
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
                AppMethodBeat.m2505o(65002);
                return;
            }
            AppMethodBeat.m2505o(65002);
        } catch (Exception e) {
            TbsLog.m80434i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
            AppMethodBeat.m2505o(65002);
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        AppMethodBeat.m2504i(64891);
        if (!C40978bv.m71073a().mo64921b()) {
            C30951r.m49579a("android.webkit.WebView", "enablePlatformNotifications");
        }
        AppMethodBeat.m2505o(64891);
    }

    public static String findAddress(String str) {
        AppMethodBeat.m2504i(64951);
        if (C40978bv.m71073a().mo64921b()) {
            AppMethodBeat.m2505o(64951);
            return null;
        }
        String findAddress = android.webkit.WebView.findAddress(str);
        AppMethodBeat.m2505o(64951);
        return findAddress;
    }

    public static String getCrashExtraMessage(Context context) {
        AppMethodBeat.m2504i(65006);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(65006);
            return str;
        }
        str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:43644;";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C5818o.m8863a(true).mo12201e());
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && QbSdk.f16252n != null && QbSdk.f16252n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f16252n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            str = "weapp_id:" + QbSdk.f16252n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";weapp_name:" + QbSdk.f16252n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append(str);
        }
        if (stringBuilder.length() > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            str = stringBuilder.substring(stringBuilder.length() - 8192);
            AppMethodBeat.m2505o(65006);
            return str;
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(65006);
        return str;
    }

    public static PackageInfo getCurrentWebViewPackage() {
        AppMethodBeat.m2504i(64931);
        if (C40978bv.m71073a().mo64921b()) {
            AppMethodBeat.m2505o(64931);
            return null;
        } else if (VERSION.SDK_INT < 26) {
            AppMethodBeat.m2505o(64931);
            return null;
        } else {
            try {
                PackageInfo packageInfo = (PackageInfo) C30951r.m49579a("android.webkit.WebView", "getCurrentWebViewPackage");
                AppMethodBeat.m2505o(64931);
                return packageInfo;
            } catch (Exception e) {
                AppMethodBeat.m2505o(64931);
                return null;
            }
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object obj;
        synchronized (WebView.class) {
            AppMethodBeat.m2504i(64964);
            if (C40978bv.m71073a().mo64921b()) {
                obj = null;
                AppMethodBeat.m2505o(64964);
            } else {
                obj = C30951r.m49579a("android.webkit.WebView", "getPluginList");
                AppMethodBeat.m2505o(64964);
            }
        }
        return obj;
    }

    public static int getTbsCoreVersion(Context context) {
        AppMethodBeat.m2504i(64989);
        int tbsVersion = QbSdk.getTbsVersion(context);
        AppMethodBeat.m2505o(64989);
        return tbsVersion;
    }

    public static boolean getTbsNeedReboot() {
        AppMethodBeat.m2504i(65007);
        m49491d();
        boolean f = C5818o.m8863a(true).mo12202f();
        AppMethodBeat.m2505o(65007);
        return f;
    }

    public static int getTbsSDKVersion(Context context) {
        return 43644;
    }

    /* renamed from: i */
    private long m49497i() {
        long j;
        AppMethodBeat.m2504i(64890);
        synchronized (QbSdk.f16246h) {
            try {
                if (QbSdk.f16243e) {
                    QbSdk.f16245g += System.currentTimeMillis() - QbSdk.f16244f;
                    TbsLog.m80430d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f16245g);
                }
                j = QbSdk.f16245g / 1000;
                QbSdk.f16245g = 0;
                QbSdk.f16244f = System.currentTimeMillis();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(64890);
            }
        }
        return j;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            AppMethodBeat.m2504i(64995);
            if (z == f13874z) {
                AppMethodBeat.m2505o(64995);
            } else {
                f13874z = z;
                if (f13873y == null) {
                    Paint paint = new Paint();
                    f13873y = paint;
                    paint.setColor(NIGHT_MODE_COLOR);
                }
                if (z) {
                    if (f13873y.getAlpha() != 255) {
                        f13873y.setAlpha(255);
                    }
                } else if (f13873y.getAlpha() != NIGHT_MODE_ALPHA) {
                    f13873y.setAlpha(NIGHT_MODE_ALPHA);
                    AppMethodBeat.m2505o(64995);
                }
                AppMethodBeat.m2505o(64995);
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        AppMethodBeat.m2504i(64908);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            if (VERSION.SDK_INT >= 19) {
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                    f13871p = declaredMethod;
                    if (declaredMethod != null) {
                        f13871p.setAccessible(true);
                        f13871p.invoke(null, new Object[]{Boolean.valueOf(z)});
                    }
                    AppMethodBeat.m2505o(64908);
                    return;
                } catch (Exception e) {
                    TbsLog.m80432e("QbSdk", "Exception:" + e.getStackTrace());
                }
            }
            AppMethodBeat.m2505o(64908);
            return;
        }
        a.mo64922c().mo57567a(z);
        AppMethodBeat.m2505o(64908);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo49869a() {
        AppMethodBeat.m2504i(64979);
        if (!(this.f13884k || this.f13877a == 0)) {
            this.f13884k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.f13879e) {
                Bundle sdkQBStatisticsInfo = this.f13880f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if (TbsConfig.APP_QZONE.equals(this.f13883i.getApplicationInfo().packageName)) {
                int d = m49490d(this.f13883i);
                if (d == -1) {
                    d = this.f13877a;
                }
                this.f13877a = d;
                m49493e(this.f13883i);
            }
            C40969b.m71058a(this.f13883i, str, str2, str3, this.f13877a, this.f13879e, m49497i());
            this.f13877a = 0;
            this.f13884k = false;
        }
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(64979);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo49870a(Context context) {
        String str;
        AppMethodBeat.m2504i(65001);
        int d = m49490d(context);
        if (d != -1) {
            str = "PV=" + String.valueOf(d + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!(file.isFile() && file.exists())) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            f13867d = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            if (f13867d != null) {
                f13867d.flush();
                AppMethodBeat.m2505o(65001);
                return;
            }
            AppMethodBeat.m2505o(65001);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(65001);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo49871a(android.webkit.WebView webView) {
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo49872a(IX5WebViewBase iX5WebViewBase) {
        this.f13880f = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(64961);
        if (this.f13879e) {
            this.f13880f.addJavascriptInterface(obj, str);
            AppMethodBeat.m2505o(64961);
            return;
        }
        this.f13881g.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(64961);
    }

    public void addView(View view) {
        AppMethodBeat.m2504i(65004);
        if (this.f13879e) {
            View view2 = this.f13880f.getView();
            try {
                Method a = C30951r.m49580a(view2, "addView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                AppMethodBeat.m2505o(65004);
                return;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65004);
                return;
            }
        }
        this.f13881g.addView(view);
        AppMethodBeat.m2505o(65004);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public android.webkit.WebView mo49875b() {
        return !this.f13879e ? this.f13881g : null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public IX5WebViewBase mo49876c() {
        return this.f13880f;
    }

    public boolean canGoBack() {
        AppMethodBeat.m2504i(64910);
        boolean canGoBack;
        if (this.f13879e) {
            canGoBack = this.f13880f.canGoBack();
            AppMethodBeat.m2505o(64910);
            return canGoBack;
        }
        canGoBack = this.f13881g.canGoBack();
        AppMethodBeat.m2505o(64910);
        return canGoBack;
    }

    public boolean canGoBackOrForward(int i) {
        AppMethodBeat.m2504i(64914);
        boolean canGoBackOrForward;
        if (this.f13879e) {
            canGoBackOrForward = this.f13880f.canGoBackOrForward(i);
            AppMethodBeat.m2505o(64914);
            return canGoBackOrForward;
        }
        canGoBackOrForward = this.f13881g.canGoBackOrForward(i);
        AppMethodBeat.m2505o(64914);
        return canGoBackOrForward;
    }

    public boolean canGoForward() {
        AppMethodBeat.m2504i(64912);
        boolean canGoForward;
        if (this.f13879e) {
            canGoForward = this.f13880f.canGoForward();
            AppMethodBeat.m2505o(64912);
            return canGoForward;
        }
        canGoForward = this.f13881g.canGoForward();
        AppMethodBeat.m2505o(64912);
        return canGoForward;
    }

    @Deprecated
    public boolean canZoomIn() {
        AppMethodBeat.m2504i(64969);
        boolean canZoomIn;
        if (this.f13879e) {
            canZoomIn = this.f13880f.canZoomIn();
            AppMethodBeat.m2505o(64969);
            return canZoomIn;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = C30951r.m49577a(this.f13881g, "canZoomIn");
            if (a == null) {
                AppMethodBeat.m2505o(64969);
                return false;
            }
            canZoomIn = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64969);
            return canZoomIn;
        } else {
            AppMethodBeat.m2505o(64969);
            return false;
        }
    }

    @Deprecated
    public boolean canZoomOut() {
        AppMethodBeat.m2504i(64971);
        boolean canZoomOut;
        if (this.f13879e) {
            canZoomOut = this.f13880f.canZoomOut();
            AppMethodBeat.m2505o(64971);
            return canZoomOut;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = C30951r.m49577a(this.f13881g, "canZoomOut");
            if (a == null) {
                AppMethodBeat.m2505o(64971);
                return false;
            }
            canZoomOut = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64971);
            return canZoomOut;
        } else {
            AppMethodBeat.m2505o(64971);
            return false;
        }
    }

    @Deprecated
    public Picture capturePicture() {
        AppMethodBeat.m2504i(64919);
        Picture capturePicture;
        if (this.f13879e) {
            capturePicture = this.f13880f.capturePicture();
            AppMethodBeat.m2505o(64919);
            return capturePicture;
        }
        Object a = C30951r.m49577a(this.f13881g, "capturePicture");
        if (a == null) {
            AppMethodBeat.m2505o(64919);
            return null;
        }
        capturePicture = (Picture) a;
        AppMethodBeat.m2505o(64919);
        return capturePicture;
    }

    public void clearCache(boolean z) {
        AppMethodBeat.m2504i(64943);
        if (this.f13879e) {
            this.f13880f.clearCache(z);
            AppMethodBeat.m2505o(64943);
            return;
        }
        this.f13881g.clearCache(z);
        AppMethodBeat.m2505o(64943);
    }

    public void clearFormData() {
        AppMethodBeat.m2504i(64944);
        if (this.f13879e) {
            this.f13880f.clearFormData();
            AppMethodBeat.m2505o(64944);
            return;
        }
        this.f13881g.clearFormData();
        AppMethodBeat.m2505o(64944);
    }

    public void clearHistory() {
        AppMethodBeat.m2504i(64945);
        if (this.f13879e) {
            this.f13880f.clearHistory();
            AppMethodBeat.m2505o(64945);
            return;
        }
        this.f13881g.clearHistory();
        AppMethodBeat.m2505o(64945);
    }

    @TargetApi(3)
    public void clearMatches() {
        AppMethodBeat.m2504i(64953);
        if (this.f13879e) {
            this.f13880f.clearMatches();
            AppMethodBeat.m2505o(64953);
            return;
        }
        this.f13881g.clearMatches();
        AppMethodBeat.m2505o(64953);
    }

    public void clearSslPreferences() {
        AppMethodBeat.m2504i(64946);
        if (this.f13879e) {
            this.f13880f.clearSslPreferences();
            AppMethodBeat.m2505o(64946);
            return;
        }
        this.f13881g.clearSslPreferences();
        AppMethodBeat.m2505o(64946);
    }

    @Deprecated
    public void clearView() {
        AppMethodBeat.m2504i(64918);
        if (this.f13879e) {
            this.f13880f.clearView();
            AppMethodBeat.m2505o(64918);
            return;
        }
        C30951r.m49577a(this.f13881g, "clearView");
        AppMethodBeat.m2505o(64918);
    }

    public int computeHorizontalScrollExtent() {
        AppMethodBeat.m2504i(64869);
        try {
            Method a;
            int intValue;
            if (this.f13879e) {
                a = C30951r.m49580a(this.f13880f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f13880f.getView(), null)).intValue();
                AppMethodBeat.m2505o(64869);
                return intValue;
            }
            a = C30951r.m49580a(this.f13881g, "computeHorizontalScrollExtent", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.f13881g, null)).intValue();
            AppMethodBeat.m2505o(64869);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64869);
            return -1;
        }
    }

    public int computeHorizontalScrollOffset() {
        AppMethodBeat.m2504i(64865);
        try {
            Method a;
            int intValue;
            if (this.f13879e) {
                a = C30951r.m49580a(this.f13880f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f13880f.getView(), null)).intValue();
                AppMethodBeat.m2505o(64865);
                return intValue;
            }
            a = C30951r.m49580a(this.f13881g, "computeHorizontalScrollOffset", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.f13881g, null)).intValue();
            AppMethodBeat.m2505o(64865);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64865);
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        AppMethodBeat.m2504i(64868);
        try {
            int intValue;
            if (this.f13879e) {
                intValue = ((Integer) C30951r.m49578a(this.f13880f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
                AppMethodBeat.m2505o(64868);
                return intValue;
            }
            Method a = C30951r.m49580a(this.f13881g, "computeHorizontalScrollRange", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.f13881g, null)).intValue();
            AppMethodBeat.m2505o(64868);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64868);
            return -1;
        }
    }

    public void computeScroll() {
        AppMethodBeat.m2504i(64976);
        if (this.f13879e) {
            this.f13880f.computeScroll();
            AppMethodBeat.m2505o(64976);
            return;
        }
        this.f13881g.computeScroll();
        AppMethodBeat.m2505o(64976);
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.m2504i(64867);
        try {
            Method a;
            int intValue;
            if (this.f13879e) {
                a = C30951r.m49580a(this.f13880f.getView(), "computeVerticalScrollExtent", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f13880f.getView(), null)).intValue();
                AppMethodBeat.m2505o(64867);
                return intValue;
            }
            a = C30951r.m49580a(this.f13881g, "computeVerticalScrollExtent", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.f13881g, null)).intValue();
            AppMethodBeat.m2505o(64867);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64867);
            return -1;
        }
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.m2504i(64866);
        try {
            Method a;
            int intValue;
            if (this.f13879e) {
                a = C30951r.m49580a(this.f13880f.getView(), "computeVerticalScrollOffset", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f13880f.getView(), null)).intValue();
                AppMethodBeat.m2505o(64866);
                return intValue;
            }
            a = C30951r.m49580a(this.f13881g, "computeVerticalScrollOffset", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.f13881g, null)).intValue();
            AppMethodBeat.m2505o(64866);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64866);
            return -1;
        }
    }

    public int computeVerticalScrollRange() {
        AppMethodBeat.m2504i(64870);
        try {
            int intValue;
            if (this.f13879e) {
                intValue = ((Integer) C30951r.m49578a(this.f13880f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
                AppMethodBeat.m2505o(64870);
                return intValue;
            }
            Method a = C30951r.m49580a(this.f13881g, "computeVerticalScrollRange", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.f13881g, null)).intValue();
            AppMethodBeat.m2505o(64870);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64870);
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        AppMethodBeat.m2504i(64947);
        WebBackForwardList a;
        if (this.f13879e) {
            a = WebBackForwardList.m88576a(this.f13880f.copyBackForwardList());
            AppMethodBeat.m2505o(64947);
            return a;
        }
        a = WebBackForwardList.m88575a(this.f13881g.copyBackForwardList());
        AppMethodBeat.m2505o(64947);
        return a;
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        AppMethodBeat.m2504i(64864);
        if (this.f13879e) {
            try {
                obj = this.f13880f.createPrintDocumentAdapter(str);
                AppMethodBeat.m2505o(64864);
                return obj;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(64864);
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(64864);
            return obj;
        } else {
            obj = C30951r.m49578a(this.f13881g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
            AppMethodBeat.m2505o(64864);
            return obj;
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        AppMethodBeat.m2504i(64957);
        if (this.f13879e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
        AppMethodBeat.m2505o(64957);
    }

    public void destroy() {
        AppMethodBeat.m2504i(64889);
        try {
            if ("com.xunmeng.pinduoduo".equals(this.f13883i.getApplicationInfo().packageName)) {
                new C5814bo(this, "WebviewDestroy").start();
                if (this.f13879e) {
                    this.f13880f.destroy();
                    AppMethodBeat.m2505o(64889);
                    return;
                }
                this.f13881g.destroy();
                AppMethodBeat.m2505o(64889);
                return;
            }
            tbsWebviewDestroy(true);
            AppMethodBeat.m2505o(64889);
        } catch (Throwable th) {
            tbsWebviewDestroy(true);
            AppMethodBeat.m2505o(64889);
        }
    }

    public void documentHasImages(Message message) {
        AppMethodBeat.m2504i(64954);
        if (this.f13879e) {
            this.f13880f.documentHasImages(message);
            AppMethodBeat.m2505o(64954);
            return;
        }
        this.f13881g.documentHasImages(message);
        AppMethodBeat.m2505o(64954);
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        AppMethodBeat.m2504i(64974);
        if (this.f13879e) {
            this.f13880f.dumpViewHierarchyWithProperties(bufferedWriter, i);
            AppMethodBeat.m2505o(64974);
            return;
        }
        C30951r.m49578a(this.f13881g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
        AppMethodBeat.m2505o(64974);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(64988);
        Method a;
        if (this.f13879e) {
            try {
                a = C30951r.m49580a(this.f13880f.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a.setAccessible(true);
                a.invoke(this.f13880f.getView(), new Object[]{str, valueCallback});
                AppMethodBeat.m2505o(64988);
                return;
            } catch (Exception e) {
                loadUrl(str);
                AppMethodBeat.m2505o(64988);
                return;
            }
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                a = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                a.setAccessible(true);
                a.invoke(this.f13881g, new Object[]{str, valueCallback});
                AppMethodBeat.m2505o(64988);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(64988);
    }

    @Deprecated
    public int findAll(String str) {
        AppMethodBeat.m2504i(64950);
        int findAll;
        if (this.f13879e) {
            findAll = this.f13880f.findAll(str);
            AppMethodBeat.m2505o(64950);
            return findAll;
        }
        Object a = C30951r.m49578a(this.f13881g, "findAll", new Class[]{String.class}, str);
        if (a == null) {
            AppMethodBeat.m2505o(64950);
            return 0;
        }
        findAll = ((Integer) a).intValue();
        AppMethodBeat.m2505o(64950);
        return findAll;
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        AppMethodBeat.m2504i(64952);
        if (this.f13879e) {
            this.f13880f.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            C30951r.m49578a(this.f13881g, "findAllAsync", new Class[]{String.class}, str);
            AppMethodBeat.m2505o(64952);
            return;
        }
        AppMethodBeat.m2505o(64952);
    }

    public View findHierarchyView(String str, int i) {
        AppMethodBeat.m2504i(64975);
        View findHierarchyView;
        if (this.f13879e) {
            findHierarchyView = this.f13880f.findHierarchyView(str, i);
            AppMethodBeat.m2505o(64975);
            return findHierarchyView;
        }
        findHierarchyView = (View) C30951r.m49578a(this.f13881g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        AppMethodBeat.m2505o(64975);
        return findHierarchyView;
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        AppMethodBeat.m2504i(64949);
        if (this.f13879e) {
            this.f13880f.findNext(z);
            AppMethodBeat.m2505o(64949);
            return;
        }
        this.f13881g.findNext(z);
        AppMethodBeat.m2505o(64949);
    }

    public void flingScroll(int i, int i2) {
        AppMethodBeat.m2504i(64967);
        if (this.f13879e) {
            this.f13880f.flingScroll(i, i2);
            AppMethodBeat.m2505o(64967);
            return;
        }
        this.f13881g.flingScroll(i, i2);
        AppMethodBeat.m2505o(64967);
    }

    @Deprecated
    public void freeMemory() {
        AppMethodBeat.m2504i(64942);
        if (this.f13879e) {
            this.f13880f.freeMemory();
            AppMethodBeat.m2505o(64942);
            return;
        }
        C30951r.m49577a(this.f13881g, "freeMemory");
        AppMethodBeat.m2505o(64942);
    }

    public SslCertificate getCertificate() {
        AppMethodBeat.m2504i(64883);
        SslCertificate certificate;
        if (this.f13879e) {
            certificate = this.f13880f.getCertificate();
            AppMethodBeat.m2505o(64883);
            return certificate;
        }
        certificate = this.f13881g.getCertificate();
        AppMethodBeat.m2505o(64883);
        return certificate;
    }

    public int getContentHeight() {
        AppMethodBeat.m2504i(64936);
        int contentHeight;
        if (this.f13879e) {
            contentHeight = this.f13880f.getContentHeight();
            AppMethodBeat.m2505o(64936);
            return contentHeight;
        }
        contentHeight = this.f13881g.getContentHeight();
        AppMethodBeat.m2505o(64936);
        return contentHeight;
    }

    public int getContentWidth() {
        AppMethodBeat.m2504i(64937);
        int contentWidth;
        if (this.f13879e) {
            contentWidth = this.f13880f.getContentWidth();
            AppMethodBeat.m2505o(64937);
            return contentWidth;
        }
        Object a = C30951r.m49577a(this.f13881g, "getContentWidth");
        if (a == null) {
            AppMethodBeat.m2505o(64937);
            return 0;
        }
        contentWidth = ((Integer) a).intValue();
        AppMethodBeat.m2505o(64937);
        return contentWidth;
    }

    public Bitmap getFavicon() {
        AppMethodBeat.m2504i(64930);
        Bitmap favicon;
        if (this.f13879e) {
            favicon = this.f13880f.getFavicon();
            AppMethodBeat.m2505o(64930);
            return favicon;
        }
        favicon = this.f13881g.getFavicon();
        AppMethodBeat.m2505o(64930);
        return favicon;
    }

    public HitTestResult getHitTestResult() {
        AppMethodBeat.m2504i(64923);
        HitTestResult hitTestResult;
        if (this.f13879e) {
            hitTestResult = new HitTestResult(this.f13880f.getHitTestResult());
            AppMethodBeat.m2505o(64923);
            return hitTestResult;
        }
        hitTestResult = new HitTestResult(this.f13881g.getHitTestResult());
        AppMethodBeat.m2505o(64923);
        return hitTestResult;
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.m2504i(64887);
        String[] httpAuthUsernamePassword;
        if (this.f13879e) {
            httpAuthUsernamePassword = this.f13880f.getHttpAuthUsernamePassword(str, str2);
            AppMethodBeat.m2505o(64887);
            return httpAuthUsernamePassword;
        }
        httpAuthUsernamePassword = this.f13881g.getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.m2505o(64887);
        return httpAuthUsernamePassword;
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        AppMethodBeat.m2504i(64928);
        String originalUrl;
        if (this.f13879e) {
            originalUrl = this.f13880f.getOriginalUrl();
            AppMethodBeat.m2505o(64928);
            return originalUrl;
        }
        originalUrl = this.f13881g.getOriginalUrl();
        AppMethodBeat.m2505o(64928);
        return originalUrl;
    }

    public int getProgress() {
        AppMethodBeat.m2504i(64935);
        int progress;
        if (this.f13879e) {
            progress = this.f13880f.getProgress();
            AppMethodBeat.m2505o(64935);
            return progress;
        }
        progress = this.f13881g.getProgress();
        AppMethodBeat.m2505o(64935);
        return progress;
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        AppMethodBeat.m2504i(64934);
        try {
            if (this.f13879e) {
                AppMethodBeat.m2505o(64934);
                return false;
            } else if (VERSION.SDK_INT < 26) {
                AppMethodBeat.m2505o(64934);
                return false;
            } else {
                Object a = C30951r.m49577a(this.f13881g, "getRendererPriorityWaivedWhenNotVisible");
                if (a == null) {
                    AppMethodBeat.m2505o(64934);
                    return false;
                }
                boolean booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(64934);
                return booleanValue;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(64934);
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        AppMethodBeat.m2504i(64933);
        try {
            if (this.f13879e) {
                AppMethodBeat.m2505o(64933);
                return 0;
            } else if (VERSION.SDK_INT < 26) {
                AppMethodBeat.m2505o(64933);
                return 0;
            } else {
                Object a = C30951r.m49577a(this.f13881g, "getRendererRequestedPriority");
                if (a == null) {
                    AppMethodBeat.m2505o(64933);
                    return 0;
                }
                int intValue = ((Integer) a).intValue();
                AppMethodBeat.m2505o(64933);
                return intValue;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(64933);
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        AppMethodBeat.m2504i(64920);
        float scale;
        if (this.f13879e) {
            scale = this.f13880f.getScale();
            AppMethodBeat.m2505o(64920);
            return scale;
        }
        Object a = C30951r.m49577a(this.f13881g, "getScale");
        if (a == null) {
            AppMethodBeat.m2505o(64920);
            return 0.0f;
        }
        scale = ((Float) a).floatValue();
        AppMethodBeat.m2505o(64920);
        return scale;
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        AppMethodBeat.m2504i(65016);
        if (getView() == null) {
            AppMethodBeat.m2505o(65016);
            return 0;
        }
        int scrollBarDefaultDelayBeforeFade = getView().getScrollBarDefaultDelayBeforeFade();
        AppMethodBeat.m2505o(65016);
        return scrollBarDefaultDelayBeforeFade;
    }

    public int getScrollBarFadeDuration() {
        AppMethodBeat.m2504i(65017);
        if (getView() == null) {
            AppMethodBeat.m2505o(65017);
            return 0;
        }
        int scrollBarFadeDuration = getView().getScrollBarFadeDuration();
        AppMethodBeat.m2505o(65017);
        return scrollBarFadeDuration;
    }

    public int getScrollBarSize() {
        AppMethodBeat.m2504i(65018);
        if (getView() == null) {
            AppMethodBeat.m2505o(65018);
            return 0;
        }
        int scrollBarSize = getView().getScrollBarSize();
        AppMethodBeat.m2505o(65018);
        return scrollBarSize;
    }

    public int getScrollBarStyle() {
        AppMethodBeat.m2504i(65019);
        if (getView() == null) {
            AppMethodBeat.m2505o(65019);
            return 0;
        }
        int scrollBarStyle = getView().getScrollBarStyle();
        AppMethodBeat.m2505o(65019);
        return scrollBarStyle;
    }

    public WebSettings getSettings() {
        AppMethodBeat.m2504i(64963);
        WebSettings webSettings;
        if (this.f13882h != null) {
            webSettings = this.f13882h;
            AppMethodBeat.m2505o(64963);
            return webSettings;
        } else if (this.f13879e) {
            webSettings = new WebSettings(this.f13880f.getSettings());
            this.f13882h = webSettings;
            AppMethodBeat.m2505o(64963);
            return webSettings;
        } else {
            webSettings = new WebSettings(this.f13881g.getSettings());
            this.f13882h = webSettings;
            AppMethodBeat.m2505o(64963);
            return webSettings;
        }
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        AppMethodBeat.m2504i(64983);
        if (this.f13879e) {
            IX5WebSettingsExtension settingsExtension = this.f13880f.getX5WebViewExtension().getSettingsExtension();
            AppMethodBeat.m2505o(64983);
            return settingsExtension;
        }
        AppMethodBeat.m2505o(64983);
        return null;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        AppMethodBeat.m2504i(64929);
        String title;
        if (this.f13879e) {
            title = this.f13880f.getTitle();
            AppMethodBeat.m2505o(64929);
            return title;
        }
        title = this.f13881g.getTitle();
        AppMethodBeat.m2505o(64929);
        return title;
    }

    public String getUrl() {
        AppMethodBeat.m2504i(64927);
        String url;
        if (this.f13879e) {
            url = this.f13880f.getUrl();
            AppMethodBeat.m2505o(64927);
            return url;
        }
        url = this.f13881g.getUrl();
        AppMethodBeat.m2505o(64927);
        return url;
    }

    public View getView() {
        AppMethodBeat.m2504i(64978);
        if (this.f13879e) {
            View view = this.f13880f.getView();
            AppMethodBeat.m2505o(64978);
            return view;
        }
        C30942b c30942b = this.f13881g;
        AppMethodBeat.m2505o(64978);
        return c30942b;
    }

    public int getVisibleTitleHeight() {
        AppMethodBeat.m2504i(64882);
        int visibleTitleHeight;
        if (this.f13879e) {
            visibleTitleHeight = this.f13880f.getVisibleTitleHeight();
            AppMethodBeat.m2505o(64882);
            return visibleTitleHeight;
        }
        Object a = C30951r.m49577a(this.f13881g, "getVisibleTitleHeight");
        if (a == null) {
            AppMethodBeat.m2505o(64882);
            return 0;
        }
        visibleTitleHeight = ((Integer) a).intValue();
        AppMethodBeat.m2505o(64882);
        return visibleTitleHeight;
    }

    public WebChromeClient getWebChromeClient() {
        return this.f13888r;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        AppMethodBeat.m2504i(64986);
        if (this.f13879e) {
            IX5WebChromeClientExtension webChromeClientExtension = this.f13880f.getX5WebViewExtension().getWebChromeClientExtension();
            AppMethodBeat.m2505o(64986);
            return webChromeClientExtension;
        }
        AppMethodBeat.m2505o(64986);
        return null;
    }

    public int getWebScrollX() {
        AppMethodBeat.m2504i(64880);
        int scrollX;
        if (this.f13879e) {
            scrollX = this.f13880f.getView().getScrollX();
            AppMethodBeat.m2505o(64880);
            return scrollX;
        }
        scrollX = this.f13881g.getScrollX();
        AppMethodBeat.m2505o(64880);
        return scrollX;
    }

    public int getWebScrollY() {
        AppMethodBeat.m2504i(64881);
        int scrollY;
        if (this.f13879e) {
            scrollY = this.f13880f.getView().getScrollY();
            AppMethodBeat.m2505o(64881);
            return scrollY;
        }
        scrollY = this.f13881g.getScrollY();
        AppMethodBeat.m2505o(64881);
        return scrollY;
    }

    public WebViewClient getWebViewClient() {
        return this.f13887q;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        AppMethodBeat.m2504i(64987);
        if (this.f13879e) {
            IX5WebViewClientExtension webViewClientExtension = this.f13880f.getX5WebViewExtension().getWebViewClientExtension();
            AppMethodBeat.m2505o(64987);
            return webViewClientExtension;
        }
        AppMethodBeat.m2505o(64987);
        return null;
    }

    public com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult getX5HitTestResult() {
        AppMethodBeat.m2504i(64924);
        if (this.f13879e) {
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult = this.f13880f.getHitTestResult();
            AppMethodBeat.m2505o(64924);
            return hitTestResult;
        }
        AppMethodBeat.m2505o(64924);
        return null;
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        AppMethodBeat.m2504i(64982);
        if (this.f13879e) {
            IX5WebViewExtension x5WebViewExtension = this.f13880f.getX5WebViewExtension();
            AppMethodBeat.m2505o(64982);
            return x5WebViewExtension;
        }
        AppMethodBeat.m2505o(64982);
        return null;
    }

    @Deprecated
    public View getZoomControls() {
        AppMethodBeat.m2504i(64968);
        View zoomControls;
        if (this.f13879e) {
            zoomControls = this.f13880f.getZoomControls();
            AppMethodBeat.m2505o(64968);
            return zoomControls;
        }
        zoomControls = (View) C30951r.m49577a(this.f13881g, "getZoomControls");
        AppMethodBeat.m2505o(64968);
        return zoomControls;
    }

    public void goBack() {
        AppMethodBeat.m2504i(64911);
        if (this.f13879e) {
            this.f13880f.goBack();
            AppMethodBeat.m2505o(64911);
            return;
        }
        this.f13881g.goBack();
        AppMethodBeat.m2505o(64911);
    }

    public void goBackOrForward(int i) {
        AppMethodBeat.m2504i(64915);
        if (this.f13879e) {
            this.f13880f.goBackOrForward(i);
            AppMethodBeat.m2505o(64915);
            return;
        }
        this.f13881g.goBackOrForward(i);
        AppMethodBeat.m2505o(64915);
    }

    public void goForward() {
        AppMethodBeat.m2504i(64913);
        if (this.f13879e) {
            this.f13880f.goForward();
            AppMethodBeat.m2505o(64913);
            return;
        }
        this.f13881g.goForward();
        AppMethodBeat.m2505o(64913);
    }

    public void invokeZoomPicker() {
        AppMethodBeat.m2504i(64922);
        if (this.f13879e) {
            this.f13880f.invokeZoomPicker();
            AppMethodBeat.m2505o(64922);
            return;
        }
        this.f13881g.invokeZoomPicker();
        AppMethodBeat.m2505o(64922);
    }

    public boolean isDayMode() {
        return f13874z;
    }

    public boolean isPrivateBrowsingEnabled() {
        AppMethodBeat.m2504i(64970);
        boolean isPrivateBrowsingEnable;
        if (this.f13879e) {
            isPrivateBrowsingEnable = this.f13880f.isPrivateBrowsingEnable();
            AppMethodBeat.m2505o(64970);
            return isPrivateBrowsingEnable;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = C30951r.m49577a(this.f13881g, "isPrivateBrowsingEnabled");
            if (a == null) {
                AppMethodBeat.m2505o(64970);
                return false;
            }
            isPrivateBrowsingEnable = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64970);
            return isPrivateBrowsingEnable;
        } else {
            AppMethodBeat.m2505o(64970);
            return false;
        }
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(64903);
        if (this.f13879e) {
            this.f13880f.loadData(str, str2, str3);
            AppMethodBeat.m2505o(64903);
            return;
        }
        this.f13881g.loadData(str, str2, str3);
        AppMethodBeat.m2505o(64903);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(64904);
        if (this.f13879e) {
            this.f13880f.loadDataWithBaseURL(str, str2, str3, str4, str5);
            AppMethodBeat.m2505o(64904);
            return;
        }
        this.f13881g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(64904);
    }

    public void loadUrl(String str) {
        AppMethodBeat.m2504i(64900);
        if (!(!this.f13879e || this.f13885l == null || this.f13886m)) {
            this.f13885l.mo50045a("load_url_gap", (byte) 2);
        }
        if (str == null || showDebugView(str)) {
            AppMethodBeat.m2505o(64900);
        } else if (this.f13879e) {
            this.f13880f.loadUrl(str);
            AppMethodBeat.m2505o(64900);
        } else {
            this.f13881g.loadUrl(str);
            AppMethodBeat.m2505o(64900);
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(64899);
        if (!(!this.f13879e || this.f13885l == null || this.f13886m)) {
            this.f13885l.mo50045a("load_url_gap", (byte) 2);
        }
        if (str == null || showDebugView(str)) {
            AppMethodBeat.m2505o(64899);
            return;
        }
        if (this.f13879e) {
            this.f13880f.loadUrl(str, map);
        } else if (VERSION.SDK_INT >= 8) {
            this.f13881g.loadUrl(str, map);
            AppMethodBeat.m2505o(64899);
            return;
        }
        AppMethodBeat.m2505o(64899);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(64980);
        try {
            if ("com.xunmeng.pinduoduo".equals(this.f13883i.getApplicationInfo().packageName)) {
                new C36437bt(this, "onDetachedFromWindow").start();
                AppMethodBeat.m2505o(64980);
                return;
            }
            mo49869a();
            AppMethodBeat.m2505o(64980);
        } catch (Throwable th) {
            mo49869a();
            AppMethodBeat.m2505o(64980);
        }
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.m2504i(64998);
        boolean a;
        if (this.f13876B == null) {
            a = m49486a(view);
            AppMethodBeat.m2505o(64998);
            return a;
        } else if (this.f13876B.onLongClick(view)) {
            AppMethodBeat.m2505o(64998);
            return true;
        } else {
            a = m49486a(view);
            AppMethodBeat.m2505o(64998);
            return a;
        }
    }

    public void onPause() {
        AppMethodBeat.m2504i(64940);
        if (this.f13879e) {
            this.f13880f.onPause();
            AppMethodBeat.m2505o(64940);
            return;
        }
        C30951r.m49577a(this.f13881g, "onPause");
        AppMethodBeat.m2505o(64940);
    }

    public void onResume() {
        AppMethodBeat.m2504i(64941);
        if (this.f13879e) {
            this.f13880f.onResume();
            AppMethodBeat.m2505o(64941);
            return;
        }
        C30951r.m49577a(this.f13881g, "onResume");
        AppMethodBeat.m2505o(64941);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(11)
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(64872);
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && m49489c(this.f13883i) && isHardwareAccelerated() && i > 0 && i2 > 0) {
            getLayerType();
        }
        AppMethodBeat.m2505o(64872);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(64981);
        if (this.f13883i == null) {
            super.onVisibilityChanged(view, i);
            AppMethodBeat.m2505o(64981);
            return;
        }
        if (f13872s == null) {
            f13872s = this.f13883i.getApplicationInfo().packageName;
        }
        if (f13872s == null || !(f13872s.equals("com.tencent.mm") || f13872s.equals(TbsConfig.APP_QQ))) {
            if (!(i == 0 || this.f13884k || this.f13877a == 0)) {
                this.f13884k = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.f13879e) {
                    Bundle sdkQBStatisticsInfo = this.f13880f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if (TbsConfig.APP_QZONE.equals(this.f13883i.getApplicationInfo().packageName)) {
                    int d = m49490d(this.f13883i);
                    if (d == -1) {
                        d = this.f13877a;
                    }
                    this.f13877a = d;
                    m49493e(this.f13883i);
                }
                C40969b.m71058a(this.f13883i, str, str2, str3, this.f13877a, this.f13879e, m49497i());
                this.f13877a = 0;
                this.f13884k = false;
            }
            super.onVisibilityChanged(view, i);
            AppMethodBeat.m2505o(64981);
            return;
        }
        super.onVisibilityChanged(view, i);
        AppMethodBeat.m2505o(64981);
    }

    public boolean overlayHorizontalScrollbar() {
        AppMethodBeat.m2504i(64877);
        boolean overlayHorizontalScrollbar;
        if (this.f13879e) {
            overlayHorizontalScrollbar = this.f13880f.overlayHorizontalScrollbar();
            AppMethodBeat.m2505o(64877);
            return overlayHorizontalScrollbar;
        }
        overlayHorizontalScrollbar = this.f13881g.overlayHorizontalScrollbar();
        AppMethodBeat.m2505o(64877);
        return overlayHorizontalScrollbar;
    }

    public boolean overlayVerticalScrollbar() {
        AppMethodBeat.m2504i(64878);
        boolean overlayVerticalScrollbar;
        if (this.f13879e) {
            overlayVerticalScrollbar = this.f13880f.overlayVerticalScrollbar();
            AppMethodBeat.m2505o(64878);
            return overlayVerticalScrollbar;
        }
        overlayVerticalScrollbar = this.f13881g.overlayVerticalScrollbar();
        AppMethodBeat.m2505o(64878);
        return overlayVerticalScrollbar;
    }

    public boolean pageDown(boolean z) {
        AppMethodBeat.m2504i(64917);
        boolean pageDown;
        if (this.f13879e) {
            pageDown = this.f13880f.pageDown(z, -1);
            AppMethodBeat.m2505o(64917);
            return pageDown;
        }
        pageDown = this.f13881g.pageDown(z);
        AppMethodBeat.m2505o(64917);
        return pageDown;
    }

    public boolean pageUp(boolean z) {
        AppMethodBeat.m2504i(64916);
        boolean pageUp;
        if (this.f13879e) {
            pageUp = this.f13880f.pageUp(z, -1);
            AppMethodBeat.m2505o(64916);
            return pageUp;
        }
        pageUp = this.f13881g.pageUp(z);
        AppMethodBeat.m2505o(64916);
        return pageUp;
    }

    public void pauseTimers() {
        AppMethodBeat.m2504i(64938);
        if (this.f13879e) {
            this.f13880f.pauseTimers();
            AppMethodBeat.m2505o(64938);
            return;
        }
        this.f13881g.pauseTimers();
        AppMethodBeat.m2505o(64938);
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        AppMethodBeat.m2504i(64902);
        if (this.f13879e) {
            this.f13880f.postUrl(str, bArr);
            AppMethodBeat.m2505o(64902);
            return;
        }
        this.f13881g.postUrl(str, bArr);
        AppMethodBeat.m2505o(64902);
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        AppMethodBeat.m2504i(64965);
        if (this.f13879e) {
            this.f13880f.refreshPlugins(z);
            AppMethodBeat.m2505o(64965);
            return;
        }
        C30951r.m49578a(this.f13881g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.m2505o(64965);
    }

    public void reload() {
        AppMethodBeat.m2504i(64909);
        if (this.f13879e) {
            this.f13880f.reload();
            AppMethodBeat.m2505o(64909);
            return;
        }
        this.f13881g.reload();
        AppMethodBeat.m2505o(64909);
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(64962);
        if (!this.f13879e) {
            if (VERSION.SDK_INT >= 11) {
                C30951r.m49578a(this.f13881g, "removeJavascriptInterface", new Class[]{String.class}, str);
                AppMethodBeat.m2505o(64962);
                return;
            }
            this.f13880f.removeJavascriptInterface(str);
        }
        AppMethodBeat.m2505o(64962);
    }

    public void removeView(View view) {
        AppMethodBeat.m2504i(65005);
        if (this.f13879e) {
            View view2 = this.f13880f.getView();
            try {
                Method a = C30951r.m49580a(view2, "removeView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                AppMethodBeat.m2505o(65005);
                return;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65005);
                return;
            }
        }
        this.f13881g.removeView(view);
        AppMethodBeat.m2505o(65005);
    }

    public void reportInitPerformance(long j, int i, long j2, long j3) {
        AppMethodBeat.m2504i(64898);
        TbsLog.m80434i("sdkreport", "reportInitPerformance initType is " + j + " isX5Core is " + this.f13879e + " isPerformanceDataRecorded" + this.f13886m);
        if (!(!this.f13879e || this.f13885l == null || this.f13886m)) {
            this.f13885l.mo50046a("init_type", j);
            this.f13885l.mo50046a("time_oncreate", j2);
            this.f13885l.mo50046a("webview_type", (long) i);
            this.f13885l.mo50046a("time_webaccelerator", j3);
            if (this.f13885l.mo50047a(this.f13880f.hashCode(), getUrl())) {
                this.f13886m = true;
            }
        }
        AppMethodBeat.m2505o(64898);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        AppMethodBeat.m2504i(64879);
        boolean requestChildRectangleOnScreen;
        if (this.f13879e) {
            View view2 = this.f13880f.getView();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (view != this) {
                    view2 = view;
                }
                requestChildRectangleOnScreen = viewGroup.requestChildRectangleOnScreen(view2, rect, z);
                AppMethodBeat.m2505o(64879);
                return requestChildRectangleOnScreen;
            }
            AppMethodBeat.m2505o(64879);
            return false;
        }
        C30942b c30942b = this.f13881g;
        if (view == this) {
            view = this.f13881g;
        }
        requestChildRectangleOnScreen = c30942b.requestChildRectangleOnScreen(view, rect, z);
        AppMethodBeat.m2505o(64879);
        return requestChildRectangleOnScreen;
    }

    public void requestFocusNodeHref(Message message) {
        AppMethodBeat.m2504i(64925);
        if (this.f13879e) {
            this.f13880f.requestFocusNodeHref(message);
            AppMethodBeat.m2505o(64925);
            return;
        }
        this.f13881g.requestFocusNodeHref(message);
        AppMethodBeat.m2505o(64925);
    }

    public void requestImageRef(Message message) {
        AppMethodBeat.m2504i(64926);
        if (this.f13879e) {
            this.f13880f.requestImageRef(message);
            AppMethodBeat.m2505o(64926);
            return;
        }
        this.f13881g.requestImageRef(message);
        AppMethodBeat.m2505o(64926);
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        AppMethodBeat.m2504i(64896);
        boolean restorePicture;
        if (this.f13879e) {
            restorePicture = this.f13880f.restorePicture(bundle, file);
            AppMethodBeat.m2505o(64896);
            return restorePicture;
        }
        Object a = C30951r.m49578a(this.f13881g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        if (a == null) {
            AppMethodBeat.m2505o(64896);
            return false;
        }
        restorePicture = ((Boolean) a).booleanValue();
        AppMethodBeat.m2505o(64896);
        return restorePicture;
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        AppMethodBeat.m2504i(64897);
        WebBackForwardList a;
        if (this.f13879e) {
            a = WebBackForwardList.m88576a(this.f13880f.restoreState(bundle));
            AppMethodBeat.m2505o(64897);
            return a;
        }
        a = WebBackForwardList.m88575a(this.f13881g.restoreState(bundle));
        AppMethodBeat.m2505o(64897);
        return a;
    }

    public void resumeTimers() {
        AppMethodBeat.m2504i(64939);
        if (this.f13879e) {
            this.f13880f.resumeTimers();
            AppMethodBeat.m2505o(64939);
            return;
        }
        this.f13881g.resumeTimers();
        AppMethodBeat.m2505o(64939);
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        AppMethodBeat.m2504i(64885);
        if (this.f13879e) {
            this.f13880f.savePassword(str, str2, str3);
            AppMethodBeat.m2505o(64885);
            return;
        }
        C30951r.m49578a(this.f13881g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        AppMethodBeat.m2505o(64885);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        AppMethodBeat.m2504i(64895);
        boolean savePicture;
        if (this.f13879e) {
            savePicture = this.f13880f.savePicture(bundle, file);
            AppMethodBeat.m2505o(64895);
            return savePicture;
        }
        Object a = C30951r.m49578a(this.f13881g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        if (a == null) {
            AppMethodBeat.m2505o(64895);
            return false;
        }
        savePicture = ((Boolean) a).booleanValue();
        AppMethodBeat.m2505o(64895);
        return savePicture;
    }

    public WebBackForwardList saveState(Bundle bundle) {
        AppMethodBeat.m2504i(64894);
        WebBackForwardList a;
        if (this.f13879e) {
            a = WebBackForwardList.m88576a(this.f13880f.saveState(bundle));
            AppMethodBeat.m2505o(64894);
            return a;
        }
        a = WebBackForwardList.m88575a(this.f13881g.saveState(bundle));
        AppMethodBeat.m2505o(64894);
        return a;
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        AppMethodBeat.m2504i(64905);
        if (this.f13879e) {
            this.f13880f.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            C30951r.m49578a(this.f13881g, "saveWebArchive", new Class[]{String.class}, str);
            AppMethodBeat.m2505o(64905);
            return;
        }
        AppMethodBeat.m2505o(64905);
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(64906);
        if (this.f13879e) {
            this.f13880f.saveWebArchive(str, z, valueCallback);
        } else if (VERSION.SDK_INT >= 11) {
            C30951r.m49578a(this.f13881g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
            AppMethodBeat.m2505o(64906);
            return;
        }
        AppMethodBeat.m2505o(64906);
    }

    public void setARModeEnable(boolean z) {
        AppMethodBeat.m2504i(64997);
        try {
            if (this.f13879e) {
                getSettingsExtension().setARModeEnable(z);
            }
            AppMethodBeat.m2505o(64997);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64997);
        }
    }

    public void setBackgroundColor(int i) {
        AppMethodBeat.m2504i(64977);
        if (this.f13879e) {
            this.f13880f.setBackgroundColor(i);
        } else {
            this.f13881g.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
        AppMethodBeat.m2505o(64977);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        AppMethodBeat.m2504i(64884);
        if (this.f13879e) {
            this.f13880f.setCertificate(sslCertificate);
            AppMethodBeat.m2505o(64884);
            return;
        }
        this.f13881g.setCertificate(sslCertificate);
        AppMethodBeat.m2505o(64884);
    }

    public void setDayOrNight(boolean z) {
        AppMethodBeat.m2504i(64996);
        try {
            if (this.f13879e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
            AppMethodBeat.m2505o(64996);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64996);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.m2504i(64958);
        if (this.f13879e) {
            this.f13880f.setDownloadListener(new C44453b(this, downloadListener, this.f13879e));
            AppMethodBeat.m2505o(64958);
            return;
        }
        this.f13881g.setDownloadListener(new C16150bq(this, downloadListener));
        AppMethodBeat.m2505o(64958);
    }

    @TargetApi(16)
    public void setFindListener(FindListener findListener) {
        AppMethodBeat.m2504i(64948);
        if (this.f13879e) {
            this.f13880f.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.f13881g.setFindListener(new C5815bp(this, findListener));
            AppMethodBeat.m2505o(64948);
            return;
        }
        AppMethodBeat.m2505o(64948);
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        AppMethodBeat.m2504i(64875);
        if (this.f13879e) {
            this.f13880f.setHorizontalScrollbarOverlay(z);
            AppMethodBeat.m2505o(64875);
            return;
        }
        this.f13881g.setHorizontalScrollbarOverlay(z);
        AppMethodBeat.m2505o(64875);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(64886);
        if (this.f13879e) {
            this.f13880f.setHttpAuthUsernamePassword(str, str2, str3, str4);
            AppMethodBeat.m2505o(64886);
            return;
        }
        this.f13881g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.m2505o(64886);
    }

    public void setInitialScale(int i) {
        AppMethodBeat.m2504i(64921);
        if (this.f13879e) {
            this.f13880f.setInitialScale(i);
            AppMethodBeat.m2505o(64921);
            return;
        }
        this.f13881g.setInitialScale(i);
        AppMethodBeat.m2505o(64921);
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        AppMethodBeat.m2504i(64966);
        if (this.f13879e) {
            this.f13880f.setMapTrackballToArrowKeys(z);
            AppMethodBeat.m2505o(64966);
            return;
        }
        C30951r.m49578a(this.f13881g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.m2505o(64966);
    }

    public void setNetworkAvailable(boolean z) {
        AppMethodBeat.m2504i(64893);
        if (this.f13879e) {
            this.f13880f.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.f13881g.setNetworkAvailable(z);
            AppMethodBeat.m2505o(64893);
            return;
        }
        AppMethodBeat.m2505o(64893);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.m2504i(64999);
        if (this.f13879e) {
            View view = this.f13880f.getView();
            try {
                if (this.f13875A == null) {
                    Method a = C30951r.m49580a(view, "getListenerInfo", new Class[0]);
                    a.setAccessible(true);
                    Object invoke = a.invoke(view, null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.f13875A = declaredField.get(invoke);
                }
                this.f13876B = onLongClickListener;
                getView().setOnLongClickListener(this);
                AppMethodBeat.m2505o(64999);
                return;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(64999);
                return;
            }
        }
        this.f13881g.setOnLongClickListener(onLongClickListener);
        AppMethodBeat.m2505o(64999);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(64991);
        getView().setOnTouchListener(onTouchListener);
        AppMethodBeat.m2505o(64991);
    }

    public void setPictureListener(PictureListener pictureListener) {
        AppMethodBeat.m2504i(64960);
        if (this.f13879e) {
            if (pictureListener == null) {
                this.f13880f.setPictureListener(null);
                AppMethodBeat.m2505o(64960);
                return;
            }
            this.f13880f.setPictureListener(new C36436bs(this, pictureListener));
            AppMethodBeat.m2505o(64960);
        } else if (pictureListener == null) {
            this.f13881g.setPictureListener(null);
            AppMethodBeat.m2505o(64960);
        } else {
            this.f13881g.setPictureListener(new C5816br(this, pictureListener));
            AppMethodBeat.m2505o(64960);
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        AppMethodBeat.m2504i(64932);
        try {
            if (this.f13879e) {
                AppMethodBeat.m2505o(64932);
            } else if (VERSION.SDK_INT < 26) {
                AppMethodBeat.m2505o(64932);
            } else {
                C30951r.m49578a(this.f13881g, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
                AppMethodBeat.m2505o(64932);
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(64932);
        }
    }

    public void setScrollBarStyle(int i) {
        AppMethodBeat.m2504i(64874);
        if (this.f13879e) {
            this.f13880f.getView().setScrollBarStyle(i);
            AppMethodBeat.m2505o(64874);
            return;
        }
        this.f13881g.setScrollBarStyle(i);
        AppMethodBeat.m2505o(64874);
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        AppMethodBeat.m2504i(64876);
        if (this.f13879e) {
            this.f13880f.setVerticalScrollbarOverlay(z);
            AppMethodBeat.m2505o(64876);
            return;
        }
        this.f13881g.setVerticalScrollbarOverlay(z);
        AppMethodBeat.m2505o(64876);
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        AppMethodBeat.m2504i(64990);
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f13880f == null) {
            AppMethodBeat.m2505o(64990);
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f13880f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        AppMethodBeat.m2505o(64990);
        return true;
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(65020);
        super.setVisibility(i);
        if (getView() == null) {
            AppMethodBeat.m2505o(65020);
            return;
        }
        getView().setVisibility(i);
        AppMethodBeat.m2505o(65020);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        AppMethodBeat.m2504i(64959);
        if (this.f13879e) {
            IX5WebChromeClient c40981q;
            IX5WebViewBase iX5WebViewBase = this.f13880f;
            if (webChromeClient != null) {
                c40981q = new C40981q(C40978bv.m71073a().mo64918a(true).mo57598i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(c40981q);
        } else {
            C30942b c30942b = this.f13881g;
            if (webChromeClient != null) {
                webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
            }
            c30942b.setWebChromeClient(webChromeClient2);
        }
        this.f13888r = webChromeClient;
        AppMethodBeat.m2505o(64959);
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        AppMethodBeat.m2504i(64985);
        if (this.f13879e) {
            this.f13880f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
            AppMethodBeat.m2505o(64985);
            return;
        }
        AppMethodBeat.m2505o(64985);
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        AppMethodBeat.m2504i(64956);
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.f13879e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
        AppMethodBeat.m2505o(64956);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        AppMethodBeat.m2504i(64955);
        if (this.f13879e) {
            IX5WebViewClient c5819v;
            IX5WebViewBase iX5WebViewBase = this.f13880f;
            if (webViewClient != null) {
                c5819v = new C5819v(C40978bv.m71073a().mo64918a(true).mo57601j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(c5819v);
        } else {
            C30942b c30942b = this.f13881g;
            if (webViewClient != null) {
                webViewClient2 = new C36426ad(this, webViewClient);
            }
            c30942b.setWebViewClient(webViewClient2);
        }
        this.f13887q = webViewClient;
        AppMethodBeat.m2505o(64955);
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        AppMethodBeat.m2504i(64984);
        if (this.f13879e) {
            this.f13880f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
            AppMethodBeat.m2505o(64984);
            return;
        }
        AppMethodBeat.m2505o(64984);
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        AppMethodBeat.m2504i(64901);
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            C44458d.m80441a(this.f13883i).mo70634a(toLowerCase, this, this.f13883i, C24267al.m37429a().getLooper());
            AppMethodBeat.m2505o(64901);
            return true;
        } else if (!toLowerCase.startsWith("http://debugx5.qq.com")) {
            AppMethodBeat.m2505o(64901);
            return false;
        } else if (this.f13879e) {
            AppMethodBeat.m2505o(64901);
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html><html><body>");
            stringBuilder.append("<head>");
            stringBuilder.append("<title>无法打开debugx5</title>");
            stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            stringBuilder.append("</head>");
            stringBuilder.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
            stringBuilder.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
            stringBuilder.append("</body></html>");
            loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", ProtocolPackage.ServerEncoding, null);
            AppMethodBeat.m2505o(64901);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        AppMethodBeat.m2504i(64907);
        if (this.f13879e) {
            this.f13880f.stopLoading();
            AppMethodBeat.m2505o(64907);
            return;
        }
        this.f13881g.stopLoading();
        AppMethodBeat.m2505o(64907);
    }

    public void super_computeScroll() {
        AppMethodBeat.m2504i(65015);
        if (this.f13879e) {
            try {
                C30951r.m49577a(this.f13880f.getView(), "super_computeScroll");
                AppMethodBeat.m2505o(65015);
                return;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65015);
                return;
            }
        }
        this.f13881g.mo50019a();
        AppMethodBeat.m2505o(65015);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(65012);
        boolean booleanValue;
        if (this.f13879e) {
            try {
                Object a = C30951r.m49578a(this.f13880f.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
                if (a == null) {
                    AppMethodBeat.m2505o(65012);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(65012);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65012);
                return false;
            }
        }
        booleanValue = this.f13881g.mo50024b(motionEvent);
        AppMethodBeat.m2505o(65012);
        return booleanValue;
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(65013);
        boolean booleanValue;
        if (this.f13879e) {
            try {
                Object a = C30951r.m49578a(this.f13880f.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
                if (a == null) {
                    AppMethodBeat.m2505o(65013);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(65013);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65013);
                return false;
            }
        }
        booleanValue = this.f13881g.mo50025c(motionEvent);
        AppMethodBeat.m2505o(65013);
        return booleanValue;
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(65011);
        if (this.f13879e) {
            try {
                C30951r.m49578a(this.f13880f.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                AppMethodBeat.m2505o(65011);
                return;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65011);
                return;
            }
        }
        this.f13881g.mo50021a(i, i2, z, z2);
        AppMethodBeat.m2505o(65011);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(65009);
        if (this.f13879e) {
            try {
                C30951r.m49578a(this.f13880f.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                AppMethodBeat.m2505o(65009);
                return;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65009);
                return;
            }
        }
        this.f13881g.mo50020a(i, i2, i3, i4);
        AppMethodBeat.m2505o(65009);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(65014);
        boolean booleanValue;
        if (this.f13879e) {
            try {
                Object a = C30951r.m49578a(this.f13880f.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
                if (a == null) {
                    AppMethodBeat.m2505o(65014);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(65014);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65014);
                return false;
            }
        }
        booleanValue = this.f13881g.mo50023a(motionEvent);
        AppMethodBeat.m2505o(65014);
        return booleanValue;
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.m2504i(65010);
        boolean booleanValue;
        if (this.f13879e) {
            try {
                Object a = C30951r.m49578a(this.f13880f.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
                if (a == null) {
                    AppMethodBeat.m2505o(65010);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(65010);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(65010);
                return false;
            }
        }
        booleanValue = this.f13881g.mo50022a(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.m2505o(65010);
        return booleanValue;
    }

    public void switchNightMode(boolean z) {
        AppMethodBeat.m2504i(64993);
        if (z == f13874z) {
            AppMethodBeat.m2505o(64993);
            return;
        }
        f13874z = z;
        if (z) {
            TbsLog.m80432e("QB_SDK", "deleteNightMode");
            loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
            AppMethodBeat.m2505o(64993);
            return;
        }
        TbsLog.m80432e("QB_SDK", "nightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        AppMethodBeat.m2505o(64993);
    }

    public void switchToNightMode() {
        AppMethodBeat.m2504i(64994);
        TbsLog.m80432e("QB_SDK", "switchToNightMode 01");
        if (!f13874z) {
            TbsLog.m80432e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
        AppMethodBeat.m2505o(64994);
    }

    public void tbsWebviewDestroy(boolean z) {
        AppMethodBeat.m2504i(64888);
        if (!(this.f13884k || this.f13877a == 0)) {
            this.f13884k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.f13879e) {
                Bundle sdkQBStatisticsInfo = this.f13880f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if (TbsConfig.APP_QZONE.equals(this.f13883i.getApplicationInfo().packageName)) {
                int d = m49490d(this.f13883i);
                if (d == -1) {
                    d = this.f13877a;
                }
                this.f13877a = d;
                m49493e(this.f13883i);
            }
            C40969b.m71058a(this.f13883i, str, str2, str3, this.f13877a, this.f13879e, m49497i());
            this.f13877a = 0;
            this.f13884k = false;
        }
        if (!this.f13879e) {
            Object invoke;
            Field declaredField;
            try {
                Class cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
                method.setAccessible(true);
                invoke = method.invoke(null, new Object[]{this.f13881g});
                if (invoke != null) {
                    Field declaredField2 = cls.getDeclaredField("mListBoxDialog");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class cls2 = Class.forName("android.app.Dialog");
                        declaredField = cls2.getDeclaredField("CANCEL");
                        declaredField.setAccessible(true);
                        int intValue = ((Integer) declaredField.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception e) {
            }
            if (z) {
                this.f13881g.destroy();
            }
            try {
                declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    declaredField = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField.setAccessible(true);
                    invoke = declaredField.get(null);
                    if (invoke != null) {
                        List list = (List) invoke;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception e2) {
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(64888);
                }
            }
        } else if (z) {
            this.f13880f.destroy();
        }
        TbsLog.m80434i("WebView", "X5 GUID = " + QbSdk.m71042b());
        AppMethodBeat.m2505o(64888);
    }

    public boolean zoomIn() {
        AppMethodBeat.m2504i(64972);
        boolean zoomIn;
        if (this.f13879e) {
            zoomIn = this.f13880f.zoomIn();
            AppMethodBeat.m2505o(64972);
            return zoomIn;
        }
        zoomIn = this.f13881g.zoomIn();
        AppMethodBeat.m2505o(64972);
        return zoomIn;
    }

    public boolean zoomOut() {
        AppMethodBeat.m2504i(64973);
        boolean zoomOut;
        if (this.f13879e) {
            zoomOut = this.f13880f.zoomOut();
            AppMethodBeat.m2505o(64973);
            return zoomOut;
        }
        zoomOut = this.f13881g.zoomOut();
        AppMethodBeat.m2505o(64973);
        return zoomOut;
    }
}
