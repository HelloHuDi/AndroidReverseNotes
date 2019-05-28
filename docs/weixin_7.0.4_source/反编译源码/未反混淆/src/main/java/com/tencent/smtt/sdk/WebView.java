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
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.w;
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
    private static final Lock c = new ReentrantLock();
    private static OutputStream d = null;
    private static Context j = null;
    public static boolean mSysWebviewCreated = false;
    public static boolean mWebViewCreated = false;
    private static BroadcastReceiver n = null;
    private static w o = null;
    private static Method p = null;
    private static String s = null;
    private static Paint y = null;
    private static boolean z = true;
    private Object A;
    private OnLongClickListener B;
    int a;
    private final String b;
    private boolean e;
    private IX5WebViewBase f;
    private b g;
    private WebSettings h;
    private Context i;
    private boolean k;
    private am l;
    private boolean m;
    public WebViewCallbackClient mWebViewCallbackClient;
    private WebViewClient q;
    private WebChromeClient r;
    private final int t;
    private final int u;
    private final int v;
    private final String w;
    private final String x;

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(bm bmVar) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(64840);
            if (intent != null) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int apnType = Apn.getApnType(context);
                        long currentTimeMillis = System.currentTimeMillis();
                        synchronized (QbSdk.h) {
                            if (QbSdk.e) {
                                QbSdk.g += currentTimeMillis - QbSdk.f;
                            }
                            QbSdk.f = currentTimeMillis;
                        }
                        TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.g + " apnType=" + apnType);
                        QbSdk.e = apnType == 3;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(64840);
                    return;
                }
            }
            AppMethodBeat.o(64840);
        }
    }

    public class WebViewTransport {
        private WebView b;

        public synchronized WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    class b extends android.webkit.WebView {
        public b(WebView webView, Context context) {
            this(context, null);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(64843);
            if (!(QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context))) {
                CookieSyncManager.createInstance(WebView.this.i).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
                    WebView.mSysWebviewCreated = true;
                    AppMethodBeat.o(64843);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(64843);
        }

        public void a() {
            AppMethodBeat.i(64849);
            super.computeScroll();
            AppMethodBeat.o(64849);
        }

        public void a(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(64847);
            super.onScrollChanged(i, i2, i3, i4);
            AppMethodBeat.o(64847);
        }

        @TargetApi(9)
        public void a(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.i(64856);
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
            AppMethodBeat.o(64856);
        }

        @TargetApi(9)
        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.i(64854);
            if (VERSION.SDK_INT >= 9) {
                boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.o(64854);
                return overScrollBy;
            }
            AppMethodBeat.o(64854);
            return false;
        }

        public boolean a(MotionEvent motionEvent) {
            AppMethodBeat.i(64851);
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(64851);
            return onTouchEvent;
        }

        public boolean b(MotionEvent motionEvent) {
            AppMethodBeat.i(64858);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(64858);
            return dispatchTouchEvent;
        }

        public boolean c(MotionEvent motionEvent) {
            AppMethodBeat.i(64860);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(64860);
            return onInterceptTouchEvent;
        }

        public void computeScroll() {
            AppMethodBeat.i(64848);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.computeScroll(this);
                AppMethodBeat.o(64848);
                return;
            }
            super.computeScroll();
            AppMethodBeat.o(64848);
        }

        /* Access modifiers changed, original: protected */
        public void dispatchDraw(Canvas canvas) {
            AppMethodBeat.i(64852);
            try {
                super.dispatchDraw(canvas);
                if (!(WebView.z || WebView.y == null)) {
                    canvas.save();
                    canvas.drawPaint(WebView.y);
                    canvas.restore();
                }
                AppMethodBeat.o(64852);
            } catch (Throwable th) {
                AppMethodBeat.o(64852);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(64857);
            boolean dispatchTouchEvent;
            if (WebView.this.mWebViewCallbackClient != null) {
                dispatchTouchEvent = WebView.this.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this);
                AppMethodBeat.o(64857);
                return dispatchTouchEvent;
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(64857);
            return dispatchTouchEvent;
        }

        public WebSettings getSettings() {
            AppMethodBeat.i(64845);
            try {
                WebSettings settings = super.getSettings();
                AppMethodBeat.o(64845);
                return settings;
            } catch (Exception e) {
                AppMethodBeat.o(64845);
                return null;
            }
        }

        public void invalidate() {
            AppMethodBeat.i(64844);
            super.invalidate();
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.invalidate();
            }
            AppMethodBeat.o(64844);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(64859);
            boolean onInterceptTouchEvent;
            if (WebView.this.mWebViewCallbackClient != null) {
                onInterceptTouchEvent = WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
                AppMethodBeat.o(64859);
                return onInterceptTouchEvent;
            }
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(64859);
            return onInterceptTouchEvent;
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.i(64855);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
                AppMethodBeat.o(64855);
                return;
            }
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
            AppMethodBeat.o(64855);
        }

        /* Access modifiers changed, original: protected */
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(64846);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                AppMethodBeat.o(64846);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            WebView.b(WebView.this, i, i2, i3, i4);
            AppMethodBeat.o(64846);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(64850);
            if (!hasFocus()) {
                requestFocus();
            }
            boolean onTouchEvent;
            if (WebView.this.mWebViewCallbackClient != null) {
                onTouchEvent = WebView.this.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
                AppMethodBeat.o(64850);
                return onTouchEvent;
            }
            try {
                onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(64850);
                return onTouchEvent;
            } catch (Exception e) {
                AppMethodBeat.o(64850);
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.i(64853);
            boolean overScrollBy;
            if (WebView.this.mWebViewCallbackClient != null) {
                overScrollBy = WebView.this.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
                AppMethodBeat.o(64853);
                return overScrollBy;
            } else if (VERSION.SDK_INT >= 9) {
                overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.o(64853);
                return overScrollBy;
            } else {
                AppMethodBeat.o(64853);
                return false;
            }
        }

        public void setOverScrollMode(int i) {
            AppMethodBeat.i(64861);
            try {
                super.setOverScrollMode(i);
                AppMethodBeat.o(64861);
            } catch (Exception e) {
                AppMethodBeat.o(64861);
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
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult a;
        private android.webkit.WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.a = null;
            this.b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.a = null;
            this.b = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.a = hitTestResult;
            this.b = null;
        }

        public String getExtra() {
            AppMethodBeat.i(64842);
            String str = "";
            if (this.a != null) {
                str = this.a.getExtra();
            } else if (this.b != null) {
                str = this.b.getExtra();
            }
            AppMethodBeat.o(64842);
            return str;
        }

        public int getType() {
            AppMethodBeat.i(64841);
            int i = 0;
            if (this.a != null) {
                i = this.a.getType();
            } else if (this.b != null) {
                i = this.b.getType();
            }
            AppMethodBeat.o(64841);
            return i;
        }
    }

    static {
        AppMethodBeat.i(65023);
        AppMethodBeat.o(65023);
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
        AppMethodBeat.i(64862);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.a = 0;
        this.k = false;
        this.l = null;
        this.m = false;
        this.q = null;
        this.r = null;
        this.t = 1;
        this.u = 2;
        this.v = 3;
        this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.A = null;
        this.B = null;
        mWebViewCreated = true;
        this.l = new am();
        this.l.a("init_all", (byte) 1);
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.i = context;
            this.f = null;
            this.e = false;
            QbSdk.a(context, "failed to createTBSWebview!");
            this.g = new b(context, attributeSet);
            CookieManager.getInstance().a(context, true, false);
            CookieSyncManager.createInstance(this.i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
                mSysWebviewCreated = true;
            } catch (Exception e) {
            }
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable());
            AppMethodBeat.o(64862);
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.setWriteLogJIT(true);
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        this.l.a("tbslog_init", (byte) 1);
        TbsLog.initIfNeed(context);
        this.l.a("tbslog_init", (byte) 2);
        if (context == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid context argument");
            AppMethodBeat.o(64862);
            throw illegalArgumentException;
        }
        if (o == null) {
            o = w.a(context);
        }
        if (o.a) {
            TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.a(context, "debug.conf force syswebview!");
        }
        a(context, this.l);
        this.i = context;
        if (context != null) {
            j = context.getApplicationContext();
        }
        if (!this.e || QbSdk.a) {
            this.f = null;
            if (TbsShareManager.isThirdPartyApp(this.i)) {
                this.g = new b(context, attributeSet);
            } else {
                this.g = new b(this, context);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #2");
            CookieManager.getInstance().a(context, true, false);
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new LayoutParams(-1, -1));
            setDownloadListener(null);
            b(context);
            TbsLog.writeLogToDisk();
            an.a(context);
        } else {
            this.l.a("init_x5_webview", (byte) 1);
            this.f = bv.a().a(true).a(context);
            this.l.a("init_x5_webview", (byte) 2);
            if (this.f == null || this.f.getView() == null) {
                TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f = null;
                this.e = false;
                QbSdk.a(context, "failed to createTBSWebview!");
                a(context, this.l);
                if (TbsShareManager.isThirdPartyApp(this.i)) {
                    this.g = new b(context, attributeSet);
                } else {
                    this.g = new b(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().a(context, true, false);
                CookieManager.getInstance().a();
                this.g.setFocusableInTouchMode(true);
                addView(this.g, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                }
                b(context);
                TbsLog.writeLogToDisk();
                an.a(context);
                AppMethodBeat.o(64862);
                return;
            }
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.f.getView().setFocusableInTouchMode(true);
            a(attributeSet);
            addView(this.f.getView(), new LayoutParams(-1, -1));
            this.f.setDownloadListener(new b(this, null, this.e));
            this.f.getX5WebViewExtension().setWebViewClientExtension(new bm(this, bv.a().a(true).k()));
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
        }
        if ((TbsConfig.APP_QQ.equals(this.i.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.i.getApplicationInfo().packageName)) && o.a(true).h() && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        if (this.f != null) {
            TbsLog.writeLogToDisk();
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == an.a().i(context) || i2 != an.a().j(context)) {
                    TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + an.a().i(context) + " getTbsCoreInstalledVerInNolock is " + an.a().j(context));
                } else {
                    an.a().o(context);
                }
            }
        }
        if (this.l != null) {
            this.l.a("load_url_gap", (byte) 1);
            this.l.a("init_all", (byte) 2);
        }
        QbSdk.continueLoadSo(context);
        AppMethodBeat.o(64862);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    private void a(Context context, am amVar) {
        AppMethodBeat.i(64873);
        if (QbSdk.i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        if (amVar != null) {
            amVar.a("x5_core_engine_init_sync", (byte) 1);
        }
        bv a = bv.a();
        a.a(context, amVar);
        this.e = a.b();
        AppMethodBeat.o(64873);
    }

    private void a(AttributeSet attributeSet) {
        AppMethodBeat.i(64992);
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.o(64992);
                return;
            }
        }
        AppMethodBeat.o(64992);
    }

    static /* synthetic */ void a(WebView webView, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(65021);
        webView.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(65021);
    }

    private boolean a(View view) {
        AppMethodBeat.i(65003);
        if (this.i == null || getTbsCoreVersion(this.i) <= 36200) {
            Object a = r.a(this.A, "onLongClick", new Class[]{View.class}, view);
            if (a != null) {
                boolean booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(65003);
                return booleanValue;
            }
            AppMethodBeat.o(65003);
            return false;
        }
        AppMethodBeat.o(65003);
        return false;
    }

    private void b(Context context) {
        AppMethodBeat.i(64863);
        if (n != null) {
            AppMethodBeat.o(64863);
            return;
        }
        n = new a();
        new bn(this, context).start();
        AppMethodBeat.o(64863);
    }

    static /* synthetic */ void b(WebView webView, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(65022);
        webView.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(65022);
    }

    private boolean c(Context context) {
        AppMethodBeat.i(64871);
        try {
            if (context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0) {
                AppMethodBeat.o(64871);
                return true;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(64871);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0125 A:{SYNTHETIC, Splitter:B:43:0x0125} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int d(Context context) {
        FileLock a;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Exception e;
        Throwable th;
        int i = -1;
        AppMethodBeat.i(65000);
        FileOutputStream b = k.b(context, true, "tbslock.txt");
        if (b != null) {
            a = k.a(context, b);
            if (a == null) {
                AppMethodBeat.o(65000);
            } else if (c.tryLock()) {
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
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                }
                                c.unlock();
                                k.a(a, b);
                                AppMethodBeat.o(65000);
                            } else {
                                i = Integer.parseInt(property);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e22) {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                }
                                c.unlock();
                                k.a(a, b);
                                AppMethodBeat.o(65000);
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } else {
                        c.unlock();
                        k.a(a, b);
                        AppMethodBeat.o(65000);
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
                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                        }
                    }
                    c.unlock();
                    k.a(a, b);
                    AppMethodBeat.o(65000);
                    throw th;
                }
            } else {
                k.a(a, b);
                AppMethodBeat.o(65000);
            }
        } else {
            AppMethodBeat.o(65000);
        }
        return i;
        c.unlock();
        k.a(a, b);
        AppMethodBeat.o(65000);
        return i;
        try {
            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2222) {
                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                }
            }
            c.unlock();
            k.a(a, b);
            AppMethodBeat.o(65000);
            return i;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            c.unlock();
            k.a(a, b);
            AppMethodBeat.o(65000);
            throw th;
        }
    }

    static void d() {
        AppMethodBeat.i(65008);
        new bu().start();
        AppMethodBeat.o(65008);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        AppMethodBeat.i(64892);
        if (!bv.a().b()) {
            r.a("android.webkit.WebView", "disablePlatformNotifications");
        }
        AppMethodBeat.o(64892);
    }

    private void e(Context context) {
        AppMethodBeat.i(65002);
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
                AppMethodBeat.o(65002);
                return;
            }
            AppMethodBeat.o(65002);
        } catch (Exception e) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
            AppMethodBeat.o(65002);
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        AppMethodBeat.i(64891);
        if (!bv.a().b()) {
            r.a("android.webkit.WebView", "enablePlatformNotifications");
        }
        AppMethodBeat.o(64891);
    }

    public static String findAddress(String str) {
        AppMethodBeat.i(64951);
        if (bv.a().b()) {
            AppMethodBeat.o(64951);
            return null;
        }
        String findAddress = android.webkit.WebView.findAddress(str);
        AppMethodBeat.o(64951);
        return findAddress;
    }

    public static String getCrashExtraMessage(Context context) {
        AppMethodBeat.i(65006);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(65006);
            return str;
        }
        str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:43644;";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o.a(true).e());
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && QbSdk.n != null && QbSdk.n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            str = "weapp_id:" + QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";weapp_name:" + QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append(str);
        }
        if (stringBuilder.length() > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            str = stringBuilder.substring(stringBuilder.length() - 8192);
            AppMethodBeat.o(65006);
            return str;
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(65006);
        return str;
    }

    public static PackageInfo getCurrentWebViewPackage() {
        AppMethodBeat.i(64931);
        if (bv.a().b()) {
            AppMethodBeat.o(64931);
            return null;
        } else if (VERSION.SDK_INT < 26) {
            AppMethodBeat.o(64931);
            return null;
        } else {
            try {
                PackageInfo packageInfo = (PackageInfo) r.a("android.webkit.WebView", "getCurrentWebViewPackage");
                AppMethodBeat.o(64931);
                return packageInfo;
            } catch (Exception e) {
                AppMethodBeat.o(64931);
                return null;
            }
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object obj;
        synchronized (WebView.class) {
            AppMethodBeat.i(64964);
            if (bv.a().b()) {
                obj = null;
                AppMethodBeat.o(64964);
            } else {
                obj = r.a("android.webkit.WebView", "getPluginList");
                AppMethodBeat.o(64964);
            }
        }
        return obj;
    }

    public static int getTbsCoreVersion(Context context) {
        AppMethodBeat.i(64989);
        int tbsVersion = QbSdk.getTbsVersion(context);
        AppMethodBeat.o(64989);
        return tbsVersion;
    }

    public static boolean getTbsNeedReboot() {
        AppMethodBeat.i(65007);
        d();
        boolean f = o.a(true).f();
        AppMethodBeat.o(65007);
        return f;
    }

    public static int getTbsSDKVersion(Context context) {
        return 43644;
    }

    private long i() {
        long j;
        AppMethodBeat.i(64890);
        synchronized (QbSdk.h) {
            try {
                if (QbSdk.e) {
                    QbSdk.g += System.currentTimeMillis() - QbSdk.f;
                    TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
                }
                j = QbSdk.g / 1000;
                QbSdk.g = 0;
                QbSdk.f = System.currentTimeMillis();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(64890);
            }
        }
        return j;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            AppMethodBeat.i(64995);
            if (z == z) {
                AppMethodBeat.o(64995);
            } else {
                z = z;
                if (y == null) {
                    Paint paint = new Paint();
                    y = paint;
                    paint.setColor(NIGHT_MODE_COLOR);
                }
                if (z) {
                    if (y.getAlpha() != 255) {
                        y.setAlpha(255);
                    }
                } else if (y.getAlpha() != NIGHT_MODE_ALPHA) {
                    y.setAlpha(NIGHT_MODE_ALPHA);
                    AppMethodBeat.o(64995);
                }
                AppMethodBeat.o(64995);
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        AppMethodBeat.i(64908);
        bv a = bv.a();
        if (a == null || !a.b()) {
            if (VERSION.SDK_INT >= 19) {
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                    p = declaredMethod;
                    if (declaredMethod != null) {
                        p.setAccessible(true);
                        p.invoke(null, new Object[]{Boolean.valueOf(z)});
                    }
                    AppMethodBeat.o(64908);
                    return;
                } catch (Exception e) {
                    TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
                }
            }
            AppMethodBeat.o(64908);
            return;
        }
        a.c().a(z);
        AppMethodBeat.o(64908);
    }

    /* Access modifiers changed, original: protected */
    public void a() {
        AppMethodBeat.i(64979);
        if (!(this.k || this.a == 0)) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e) {
                Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int d = d(this.i);
                if (d == -1) {
                    d = this.a;
                }
                this.a = d;
                e(this.i);
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, i());
            this.a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
        AppMethodBeat.o(64979);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Context context) {
        String str;
        AppMethodBeat.i(65001);
        int d = d(context);
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
            d = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            if (d != null) {
                d.flush();
                AppMethodBeat.o(65001);
                return;
            }
            AppMethodBeat.o(65001);
        } catch (Throwable th) {
            AppMethodBeat.o(65001);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(android.webkit.WebView webView) {
    }

    /* Access modifiers changed, original: 0000 */
    public void a(IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(64961);
        if (this.e) {
            this.f.addJavascriptInterface(obj, str);
            AppMethodBeat.o(64961);
            return;
        }
        this.g.addJavascriptInterface(obj, str);
        AppMethodBeat.o(64961);
    }

    public void addView(View view) {
        AppMethodBeat.i(65004);
        if (this.e) {
            View view2 = this.f.getView();
            try {
                Method a = r.a(view2, "addView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                AppMethodBeat.o(65004);
                return;
            } catch (Throwable th) {
                AppMethodBeat.o(65004);
                return;
            }
        }
        this.g.addView(view);
        AppMethodBeat.o(65004);
    }

    /* Access modifiers changed, original: 0000 */
    public android.webkit.WebView b() {
        return !this.e ? this.g : null;
    }

    /* Access modifiers changed, original: 0000 */
    public IX5WebViewBase c() {
        return this.f;
    }

    public boolean canGoBack() {
        AppMethodBeat.i(64910);
        boolean canGoBack;
        if (this.e) {
            canGoBack = this.f.canGoBack();
            AppMethodBeat.o(64910);
            return canGoBack;
        }
        canGoBack = this.g.canGoBack();
        AppMethodBeat.o(64910);
        return canGoBack;
    }

    public boolean canGoBackOrForward(int i) {
        AppMethodBeat.i(64914);
        boolean canGoBackOrForward;
        if (this.e) {
            canGoBackOrForward = this.f.canGoBackOrForward(i);
            AppMethodBeat.o(64914);
            return canGoBackOrForward;
        }
        canGoBackOrForward = this.g.canGoBackOrForward(i);
        AppMethodBeat.o(64914);
        return canGoBackOrForward;
    }

    public boolean canGoForward() {
        AppMethodBeat.i(64912);
        boolean canGoForward;
        if (this.e) {
            canGoForward = this.f.canGoForward();
            AppMethodBeat.o(64912);
            return canGoForward;
        }
        canGoForward = this.g.canGoForward();
        AppMethodBeat.o(64912);
        return canGoForward;
    }

    @Deprecated
    public boolean canZoomIn() {
        AppMethodBeat.i(64969);
        boolean canZoomIn;
        if (this.e) {
            canZoomIn = this.f.canZoomIn();
            AppMethodBeat.o(64969);
            return canZoomIn;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = r.a(this.g, "canZoomIn");
            if (a == null) {
                AppMethodBeat.o(64969);
                return false;
            }
            canZoomIn = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64969);
            return canZoomIn;
        } else {
            AppMethodBeat.o(64969);
            return false;
        }
    }

    @Deprecated
    public boolean canZoomOut() {
        AppMethodBeat.i(64971);
        boolean canZoomOut;
        if (this.e) {
            canZoomOut = this.f.canZoomOut();
            AppMethodBeat.o(64971);
            return canZoomOut;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = r.a(this.g, "canZoomOut");
            if (a == null) {
                AppMethodBeat.o(64971);
                return false;
            }
            canZoomOut = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64971);
            return canZoomOut;
        } else {
            AppMethodBeat.o(64971);
            return false;
        }
    }

    @Deprecated
    public Picture capturePicture() {
        AppMethodBeat.i(64919);
        Picture capturePicture;
        if (this.e) {
            capturePicture = this.f.capturePicture();
            AppMethodBeat.o(64919);
            return capturePicture;
        }
        Object a = r.a(this.g, "capturePicture");
        if (a == null) {
            AppMethodBeat.o(64919);
            return null;
        }
        capturePicture = (Picture) a;
        AppMethodBeat.o(64919);
        return capturePicture;
    }

    public void clearCache(boolean z) {
        AppMethodBeat.i(64943);
        if (this.e) {
            this.f.clearCache(z);
            AppMethodBeat.o(64943);
            return;
        }
        this.g.clearCache(z);
        AppMethodBeat.o(64943);
    }

    public void clearFormData() {
        AppMethodBeat.i(64944);
        if (this.e) {
            this.f.clearFormData();
            AppMethodBeat.o(64944);
            return;
        }
        this.g.clearFormData();
        AppMethodBeat.o(64944);
    }

    public void clearHistory() {
        AppMethodBeat.i(64945);
        if (this.e) {
            this.f.clearHistory();
            AppMethodBeat.o(64945);
            return;
        }
        this.g.clearHistory();
        AppMethodBeat.o(64945);
    }

    @TargetApi(3)
    public void clearMatches() {
        AppMethodBeat.i(64953);
        if (this.e) {
            this.f.clearMatches();
            AppMethodBeat.o(64953);
            return;
        }
        this.g.clearMatches();
        AppMethodBeat.o(64953);
    }

    public void clearSslPreferences() {
        AppMethodBeat.i(64946);
        if (this.e) {
            this.f.clearSslPreferences();
            AppMethodBeat.o(64946);
            return;
        }
        this.g.clearSslPreferences();
        AppMethodBeat.o(64946);
    }

    @Deprecated
    public void clearView() {
        AppMethodBeat.i(64918);
        if (this.e) {
            this.f.clearView();
            AppMethodBeat.o(64918);
            return;
        }
        r.a(this.g, "clearView");
        AppMethodBeat.o(64918);
    }

    public int computeHorizontalScrollExtent() {
        AppMethodBeat.i(64869);
        try {
            Method a;
            int intValue;
            if (this.e) {
                a = r.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f.getView(), null)).intValue();
                AppMethodBeat.o(64869);
                return intValue;
            }
            a = r.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.g, null)).intValue();
            AppMethodBeat.o(64869);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(64869);
            return -1;
        }
    }

    public int computeHorizontalScrollOffset() {
        AppMethodBeat.i(64865);
        try {
            Method a;
            int intValue;
            if (this.e) {
                a = r.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f.getView(), null)).intValue();
                AppMethodBeat.o(64865);
                return intValue;
            }
            a = r.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.g, null)).intValue();
            AppMethodBeat.o(64865);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(64865);
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        AppMethodBeat.i(64868);
        try {
            int intValue;
            if (this.e) {
                intValue = ((Integer) r.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
                AppMethodBeat.o(64868);
                return intValue;
            }
            Method a = r.a(this.g, "computeHorizontalScrollRange", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.g, null)).intValue();
            AppMethodBeat.o(64868);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(64868);
            return -1;
        }
    }

    public void computeScroll() {
        AppMethodBeat.i(64976);
        if (this.e) {
            this.f.computeScroll();
            AppMethodBeat.o(64976);
            return;
        }
        this.g.computeScroll();
        AppMethodBeat.o(64976);
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(64867);
        try {
            Method a;
            int intValue;
            if (this.e) {
                a = r.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f.getView(), null)).intValue();
                AppMethodBeat.o(64867);
                return intValue;
            }
            a = r.a(this.g, "computeVerticalScrollExtent", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.g, null)).intValue();
            AppMethodBeat.o(64867);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(64867);
            return -1;
        }
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.i(64866);
        try {
            Method a;
            int intValue;
            if (this.e) {
                a = r.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
                a.setAccessible(true);
                intValue = ((Integer) a.invoke(this.f.getView(), null)).intValue();
                AppMethodBeat.o(64866);
                return intValue;
            }
            a = r.a(this.g, "computeVerticalScrollOffset", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.g, null)).intValue();
            AppMethodBeat.o(64866);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(64866);
            return -1;
        }
    }

    public int computeVerticalScrollRange() {
        AppMethodBeat.i(64870);
        try {
            int intValue;
            if (this.e) {
                intValue = ((Integer) r.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
                AppMethodBeat.o(64870);
                return intValue;
            }
            Method a = r.a(this.g, "computeVerticalScrollRange", new Class[0]);
            a.setAccessible(true);
            intValue = ((Integer) a.invoke(this.g, null)).intValue();
            AppMethodBeat.o(64870);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(64870);
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        AppMethodBeat.i(64947);
        WebBackForwardList a;
        if (this.e) {
            a = WebBackForwardList.a(this.f.copyBackForwardList());
            AppMethodBeat.o(64947);
            return a;
        }
        a = WebBackForwardList.a(this.g.copyBackForwardList());
        AppMethodBeat.o(64947);
        return a;
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        AppMethodBeat.i(64864);
        if (this.e) {
            try {
                obj = this.f.createPrintDocumentAdapter(str);
                AppMethodBeat.o(64864);
                return obj;
            } catch (Throwable th) {
                AppMethodBeat.o(64864);
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(64864);
            return obj;
        } else {
            obj = r.a(this.g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
            AppMethodBeat.o(64864);
            return obj;
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        AppMethodBeat.i(64957);
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
        AppMethodBeat.o(64957);
    }

    public void destroy() {
        AppMethodBeat.i(64889);
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new bo(this, "WebviewDestroy").start();
                if (this.e) {
                    this.f.destroy();
                    AppMethodBeat.o(64889);
                    return;
                }
                this.g.destroy();
                AppMethodBeat.o(64889);
                return;
            }
            tbsWebviewDestroy(true);
            AppMethodBeat.o(64889);
        } catch (Throwable th) {
            tbsWebviewDestroy(true);
            AppMethodBeat.o(64889);
        }
    }

    public void documentHasImages(Message message) {
        AppMethodBeat.i(64954);
        if (this.e) {
            this.f.documentHasImages(message);
            AppMethodBeat.o(64954);
            return;
        }
        this.g.documentHasImages(message);
        AppMethodBeat.o(64954);
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        AppMethodBeat.i(64974);
        if (this.e) {
            this.f.dumpViewHierarchyWithProperties(bufferedWriter, i);
            AppMethodBeat.o(64974);
            return;
        }
        r.a(this.g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
        AppMethodBeat.o(64974);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(64988);
        Method a;
        if (this.e) {
            try {
                a = r.a(this.f.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a.setAccessible(true);
                a.invoke(this.f.getView(), new Object[]{str, valueCallback});
                AppMethodBeat.o(64988);
                return;
            } catch (Exception e) {
                loadUrl(str);
                AppMethodBeat.o(64988);
                return;
            }
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                a = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                a.setAccessible(true);
                a.invoke(this.g, new Object[]{str, valueCallback});
                AppMethodBeat.o(64988);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(64988);
    }

    @Deprecated
    public int findAll(String str) {
        AppMethodBeat.i(64950);
        int findAll;
        if (this.e) {
            findAll = this.f.findAll(str);
            AppMethodBeat.o(64950);
            return findAll;
        }
        Object a = r.a(this.g, "findAll", new Class[]{String.class}, str);
        if (a == null) {
            AppMethodBeat.o(64950);
            return 0;
        }
        findAll = ((Integer) a).intValue();
        AppMethodBeat.o(64950);
        return findAll;
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        AppMethodBeat.i(64952);
        if (this.e) {
            this.f.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            r.a(this.g, "findAllAsync", new Class[]{String.class}, str);
            AppMethodBeat.o(64952);
            return;
        }
        AppMethodBeat.o(64952);
    }

    public View findHierarchyView(String str, int i) {
        AppMethodBeat.i(64975);
        View findHierarchyView;
        if (this.e) {
            findHierarchyView = this.f.findHierarchyView(str, i);
            AppMethodBeat.o(64975);
            return findHierarchyView;
        }
        findHierarchyView = (View) r.a(this.g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        AppMethodBeat.o(64975);
        return findHierarchyView;
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        AppMethodBeat.i(64949);
        if (this.e) {
            this.f.findNext(z);
            AppMethodBeat.o(64949);
            return;
        }
        this.g.findNext(z);
        AppMethodBeat.o(64949);
    }

    public void flingScroll(int i, int i2) {
        AppMethodBeat.i(64967);
        if (this.e) {
            this.f.flingScroll(i, i2);
            AppMethodBeat.o(64967);
            return;
        }
        this.g.flingScroll(i, i2);
        AppMethodBeat.o(64967);
    }

    @Deprecated
    public void freeMemory() {
        AppMethodBeat.i(64942);
        if (this.e) {
            this.f.freeMemory();
            AppMethodBeat.o(64942);
            return;
        }
        r.a(this.g, "freeMemory");
        AppMethodBeat.o(64942);
    }

    public SslCertificate getCertificate() {
        AppMethodBeat.i(64883);
        SslCertificate certificate;
        if (this.e) {
            certificate = this.f.getCertificate();
            AppMethodBeat.o(64883);
            return certificate;
        }
        certificate = this.g.getCertificate();
        AppMethodBeat.o(64883);
        return certificate;
    }

    public int getContentHeight() {
        AppMethodBeat.i(64936);
        int contentHeight;
        if (this.e) {
            contentHeight = this.f.getContentHeight();
            AppMethodBeat.o(64936);
            return contentHeight;
        }
        contentHeight = this.g.getContentHeight();
        AppMethodBeat.o(64936);
        return contentHeight;
    }

    public int getContentWidth() {
        AppMethodBeat.i(64937);
        int contentWidth;
        if (this.e) {
            contentWidth = this.f.getContentWidth();
            AppMethodBeat.o(64937);
            return contentWidth;
        }
        Object a = r.a(this.g, "getContentWidth");
        if (a == null) {
            AppMethodBeat.o(64937);
            return 0;
        }
        contentWidth = ((Integer) a).intValue();
        AppMethodBeat.o(64937);
        return contentWidth;
    }

    public Bitmap getFavicon() {
        AppMethodBeat.i(64930);
        Bitmap favicon;
        if (this.e) {
            favicon = this.f.getFavicon();
            AppMethodBeat.o(64930);
            return favicon;
        }
        favicon = this.g.getFavicon();
        AppMethodBeat.o(64930);
        return favicon;
    }

    public HitTestResult getHitTestResult() {
        AppMethodBeat.i(64923);
        HitTestResult hitTestResult;
        if (this.e) {
            hitTestResult = new HitTestResult(this.f.getHitTestResult());
            AppMethodBeat.o(64923);
            return hitTestResult;
        }
        hitTestResult = new HitTestResult(this.g.getHitTestResult());
        AppMethodBeat.o(64923);
        return hitTestResult;
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(64887);
        String[] httpAuthUsernamePassword;
        if (this.e) {
            httpAuthUsernamePassword = this.f.getHttpAuthUsernamePassword(str, str2);
            AppMethodBeat.o(64887);
            return httpAuthUsernamePassword;
        }
        httpAuthUsernamePassword = this.g.getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(64887);
        return httpAuthUsernamePassword;
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        AppMethodBeat.i(64928);
        String originalUrl;
        if (this.e) {
            originalUrl = this.f.getOriginalUrl();
            AppMethodBeat.o(64928);
            return originalUrl;
        }
        originalUrl = this.g.getOriginalUrl();
        AppMethodBeat.o(64928);
        return originalUrl;
    }

    public int getProgress() {
        AppMethodBeat.i(64935);
        int progress;
        if (this.e) {
            progress = this.f.getProgress();
            AppMethodBeat.o(64935);
            return progress;
        }
        progress = this.g.getProgress();
        AppMethodBeat.o(64935);
        return progress;
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        AppMethodBeat.i(64934);
        try {
            if (this.e) {
                AppMethodBeat.o(64934);
                return false;
            } else if (VERSION.SDK_INT < 26) {
                AppMethodBeat.o(64934);
                return false;
            } else {
                Object a = r.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
                if (a == null) {
                    AppMethodBeat.o(64934);
                    return false;
                }
                boolean booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(64934);
                return booleanValue;
            }
        } catch (Exception e) {
            AppMethodBeat.o(64934);
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        AppMethodBeat.i(64933);
        try {
            if (this.e) {
                AppMethodBeat.o(64933);
                return 0;
            } else if (VERSION.SDK_INT < 26) {
                AppMethodBeat.o(64933);
                return 0;
            } else {
                Object a = r.a(this.g, "getRendererRequestedPriority");
                if (a == null) {
                    AppMethodBeat.o(64933);
                    return 0;
                }
                int intValue = ((Integer) a).intValue();
                AppMethodBeat.o(64933);
                return intValue;
            }
        } catch (Exception e) {
            AppMethodBeat.o(64933);
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        AppMethodBeat.i(64920);
        float scale;
        if (this.e) {
            scale = this.f.getScale();
            AppMethodBeat.o(64920);
            return scale;
        }
        Object a = r.a(this.g, "getScale");
        if (a == null) {
            AppMethodBeat.o(64920);
            return 0.0f;
        }
        scale = ((Float) a).floatValue();
        AppMethodBeat.o(64920);
        return scale;
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        AppMethodBeat.i(65016);
        if (getView() == null) {
            AppMethodBeat.o(65016);
            return 0;
        }
        int scrollBarDefaultDelayBeforeFade = getView().getScrollBarDefaultDelayBeforeFade();
        AppMethodBeat.o(65016);
        return scrollBarDefaultDelayBeforeFade;
    }

    public int getScrollBarFadeDuration() {
        AppMethodBeat.i(65017);
        if (getView() == null) {
            AppMethodBeat.o(65017);
            return 0;
        }
        int scrollBarFadeDuration = getView().getScrollBarFadeDuration();
        AppMethodBeat.o(65017);
        return scrollBarFadeDuration;
    }

    public int getScrollBarSize() {
        AppMethodBeat.i(65018);
        if (getView() == null) {
            AppMethodBeat.o(65018);
            return 0;
        }
        int scrollBarSize = getView().getScrollBarSize();
        AppMethodBeat.o(65018);
        return scrollBarSize;
    }

    public int getScrollBarStyle() {
        AppMethodBeat.i(65019);
        if (getView() == null) {
            AppMethodBeat.o(65019);
            return 0;
        }
        int scrollBarStyle = getView().getScrollBarStyle();
        AppMethodBeat.o(65019);
        return scrollBarStyle;
    }

    public WebSettings getSettings() {
        AppMethodBeat.i(64963);
        WebSettings webSettings;
        if (this.h != null) {
            webSettings = this.h;
            AppMethodBeat.o(64963);
            return webSettings;
        } else if (this.e) {
            webSettings = new WebSettings(this.f.getSettings());
            this.h = webSettings;
            AppMethodBeat.o(64963);
            return webSettings;
        } else {
            webSettings = new WebSettings(this.g.getSettings());
            this.h = webSettings;
            AppMethodBeat.o(64963);
            return webSettings;
        }
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        AppMethodBeat.i(64983);
        if (this.e) {
            IX5WebSettingsExtension settingsExtension = this.f.getX5WebViewExtension().getSettingsExtension();
            AppMethodBeat.o(64983);
            return settingsExtension;
        }
        AppMethodBeat.o(64983);
        return null;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        AppMethodBeat.i(64929);
        String title;
        if (this.e) {
            title = this.f.getTitle();
            AppMethodBeat.o(64929);
            return title;
        }
        title = this.g.getTitle();
        AppMethodBeat.o(64929);
        return title;
    }

    public String getUrl() {
        AppMethodBeat.i(64927);
        String url;
        if (this.e) {
            url = this.f.getUrl();
            AppMethodBeat.o(64927);
            return url;
        }
        url = this.g.getUrl();
        AppMethodBeat.o(64927);
        return url;
    }

    public View getView() {
        AppMethodBeat.i(64978);
        if (this.e) {
            View view = this.f.getView();
            AppMethodBeat.o(64978);
            return view;
        }
        b bVar = this.g;
        AppMethodBeat.o(64978);
        return bVar;
    }

    public int getVisibleTitleHeight() {
        AppMethodBeat.i(64882);
        int visibleTitleHeight;
        if (this.e) {
            visibleTitleHeight = this.f.getVisibleTitleHeight();
            AppMethodBeat.o(64882);
            return visibleTitleHeight;
        }
        Object a = r.a(this.g, "getVisibleTitleHeight");
        if (a == null) {
            AppMethodBeat.o(64882);
            return 0;
        }
        visibleTitleHeight = ((Integer) a).intValue();
        AppMethodBeat.o(64882);
        return visibleTitleHeight;
    }

    public WebChromeClient getWebChromeClient() {
        return this.r;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        AppMethodBeat.i(64986);
        if (this.e) {
            IX5WebChromeClientExtension webChromeClientExtension = this.f.getX5WebViewExtension().getWebChromeClientExtension();
            AppMethodBeat.o(64986);
            return webChromeClientExtension;
        }
        AppMethodBeat.o(64986);
        return null;
    }

    public int getWebScrollX() {
        AppMethodBeat.i(64880);
        int scrollX;
        if (this.e) {
            scrollX = this.f.getView().getScrollX();
            AppMethodBeat.o(64880);
            return scrollX;
        }
        scrollX = this.g.getScrollX();
        AppMethodBeat.o(64880);
        return scrollX;
    }

    public int getWebScrollY() {
        AppMethodBeat.i(64881);
        int scrollY;
        if (this.e) {
            scrollY = this.f.getView().getScrollY();
            AppMethodBeat.o(64881);
            return scrollY;
        }
        scrollY = this.g.getScrollY();
        AppMethodBeat.o(64881);
        return scrollY;
    }

    public WebViewClient getWebViewClient() {
        return this.q;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        AppMethodBeat.i(64987);
        if (this.e) {
            IX5WebViewClientExtension webViewClientExtension = this.f.getX5WebViewExtension().getWebViewClientExtension();
            AppMethodBeat.o(64987);
            return webViewClientExtension;
        }
        AppMethodBeat.o(64987);
        return null;
    }

    public com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult getX5HitTestResult() {
        AppMethodBeat.i(64924);
        if (this.e) {
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult = this.f.getHitTestResult();
            AppMethodBeat.o(64924);
            return hitTestResult;
        }
        AppMethodBeat.o(64924);
        return null;
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        AppMethodBeat.i(64982);
        if (this.e) {
            IX5WebViewExtension x5WebViewExtension = this.f.getX5WebViewExtension();
            AppMethodBeat.o(64982);
            return x5WebViewExtension;
        }
        AppMethodBeat.o(64982);
        return null;
    }

    @Deprecated
    public View getZoomControls() {
        AppMethodBeat.i(64968);
        View zoomControls;
        if (this.e) {
            zoomControls = this.f.getZoomControls();
            AppMethodBeat.o(64968);
            return zoomControls;
        }
        zoomControls = (View) r.a(this.g, "getZoomControls");
        AppMethodBeat.o(64968);
        return zoomControls;
    }

    public void goBack() {
        AppMethodBeat.i(64911);
        if (this.e) {
            this.f.goBack();
            AppMethodBeat.o(64911);
            return;
        }
        this.g.goBack();
        AppMethodBeat.o(64911);
    }

    public void goBackOrForward(int i) {
        AppMethodBeat.i(64915);
        if (this.e) {
            this.f.goBackOrForward(i);
            AppMethodBeat.o(64915);
            return;
        }
        this.g.goBackOrForward(i);
        AppMethodBeat.o(64915);
    }

    public void goForward() {
        AppMethodBeat.i(64913);
        if (this.e) {
            this.f.goForward();
            AppMethodBeat.o(64913);
            return;
        }
        this.g.goForward();
        AppMethodBeat.o(64913);
    }

    public void invokeZoomPicker() {
        AppMethodBeat.i(64922);
        if (this.e) {
            this.f.invokeZoomPicker();
            AppMethodBeat.o(64922);
            return;
        }
        this.g.invokeZoomPicker();
        AppMethodBeat.o(64922);
    }

    public boolean isDayMode() {
        return z;
    }

    public boolean isPrivateBrowsingEnabled() {
        AppMethodBeat.i(64970);
        boolean isPrivateBrowsingEnable;
        if (this.e) {
            isPrivateBrowsingEnable = this.f.isPrivateBrowsingEnable();
            AppMethodBeat.o(64970);
            return isPrivateBrowsingEnable;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = r.a(this.g, "isPrivateBrowsingEnabled");
            if (a == null) {
                AppMethodBeat.o(64970);
                return false;
            }
            isPrivateBrowsingEnable = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64970);
            return isPrivateBrowsingEnable;
        } else {
            AppMethodBeat.o(64970);
            return false;
        }
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(64903);
        if (this.e) {
            this.f.loadData(str, str2, str3);
            AppMethodBeat.o(64903);
            return;
        }
        this.g.loadData(str, str2, str3);
        AppMethodBeat.o(64903);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(64904);
        if (this.e) {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
            AppMethodBeat.o(64904);
            return;
        }
        this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(64904);
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(64900);
        if (!(!this.e || this.l == null || this.m)) {
            this.l.a("load_url_gap", (byte) 2);
        }
        if (str == null || showDebugView(str)) {
            AppMethodBeat.o(64900);
        } else if (this.e) {
            this.f.loadUrl(str);
            AppMethodBeat.o(64900);
        } else {
            this.g.loadUrl(str);
            AppMethodBeat.o(64900);
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(64899);
        if (!(!this.e || this.l == null || this.m)) {
            this.l.a("load_url_gap", (byte) 2);
        }
        if (str == null || showDebugView(str)) {
            AppMethodBeat.o(64899);
            return;
        }
        if (this.e) {
            this.f.loadUrl(str, map);
        } else if (VERSION.SDK_INT >= 8) {
            this.g.loadUrl(str, map);
            AppMethodBeat.o(64899);
            return;
        }
        AppMethodBeat.o(64899);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(64980);
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new bt(this, "onDetachedFromWindow").start();
                AppMethodBeat.o(64980);
                return;
            }
            a();
            AppMethodBeat.o(64980);
        } catch (Throwable th) {
            a();
            AppMethodBeat.o(64980);
        }
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(64998);
        boolean a;
        if (this.B == null) {
            a = a(view);
            AppMethodBeat.o(64998);
            return a;
        } else if (this.B.onLongClick(view)) {
            AppMethodBeat.o(64998);
            return true;
        } else {
            a = a(view);
            AppMethodBeat.o(64998);
            return a;
        }
    }

    public void onPause() {
        AppMethodBeat.i(64940);
        if (this.e) {
            this.f.onPause();
            AppMethodBeat.o(64940);
            return;
        }
        r.a(this.g, "onPause");
        AppMethodBeat.o(64940);
    }

    public void onResume() {
        AppMethodBeat.i(64941);
        if (this.e) {
            this.f.onResume();
            AppMethodBeat.o(64941);
            return;
        }
        r.a(this.g, "onResume");
        AppMethodBeat.o(64941);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(11)
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(64872);
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && c(this.i) && isHardwareAccelerated() && i > 0 && i2 > 0) {
            getLayerType();
        }
        AppMethodBeat.o(64872);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(64981);
        if (this.i == null) {
            super.onVisibilityChanged(view, i);
            AppMethodBeat.o(64981);
            return;
        }
        if (s == null) {
            s = this.i.getApplicationInfo().packageName;
        }
        if (s == null || !(s.equals("com.tencent.mm") || s.equals(TbsConfig.APP_QQ))) {
            if (!(i == 0 || this.k || this.a == 0)) {
                this.k = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.e) {
                    Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                    int d = d(this.i);
                    if (d == -1) {
                        d = this.a;
                    }
                    this.a = d;
                    e(this.i);
                }
                com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, i());
                this.a = 0;
                this.k = false;
            }
            super.onVisibilityChanged(view, i);
            AppMethodBeat.o(64981);
            return;
        }
        super.onVisibilityChanged(view, i);
        AppMethodBeat.o(64981);
    }

    public boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(64877);
        boolean overlayHorizontalScrollbar;
        if (this.e) {
            overlayHorizontalScrollbar = this.f.overlayHorizontalScrollbar();
            AppMethodBeat.o(64877);
            return overlayHorizontalScrollbar;
        }
        overlayHorizontalScrollbar = this.g.overlayHorizontalScrollbar();
        AppMethodBeat.o(64877);
        return overlayHorizontalScrollbar;
    }

    public boolean overlayVerticalScrollbar() {
        AppMethodBeat.i(64878);
        boolean overlayVerticalScrollbar;
        if (this.e) {
            overlayVerticalScrollbar = this.f.overlayVerticalScrollbar();
            AppMethodBeat.o(64878);
            return overlayVerticalScrollbar;
        }
        overlayVerticalScrollbar = this.g.overlayVerticalScrollbar();
        AppMethodBeat.o(64878);
        return overlayVerticalScrollbar;
    }

    public boolean pageDown(boolean z) {
        AppMethodBeat.i(64917);
        boolean pageDown;
        if (this.e) {
            pageDown = this.f.pageDown(z, -1);
            AppMethodBeat.o(64917);
            return pageDown;
        }
        pageDown = this.g.pageDown(z);
        AppMethodBeat.o(64917);
        return pageDown;
    }

    public boolean pageUp(boolean z) {
        AppMethodBeat.i(64916);
        boolean pageUp;
        if (this.e) {
            pageUp = this.f.pageUp(z, -1);
            AppMethodBeat.o(64916);
            return pageUp;
        }
        pageUp = this.g.pageUp(z);
        AppMethodBeat.o(64916);
        return pageUp;
    }

    public void pauseTimers() {
        AppMethodBeat.i(64938);
        if (this.e) {
            this.f.pauseTimers();
            AppMethodBeat.o(64938);
            return;
        }
        this.g.pauseTimers();
        AppMethodBeat.o(64938);
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        AppMethodBeat.i(64902);
        if (this.e) {
            this.f.postUrl(str, bArr);
            AppMethodBeat.o(64902);
            return;
        }
        this.g.postUrl(str, bArr);
        AppMethodBeat.o(64902);
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        AppMethodBeat.i(64965);
        if (this.e) {
            this.f.refreshPlugins(z);
            AppMethodBeat.o(64965);
            return;
        }
        r.a(this.g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(64965);
    }

    public void reload() {
        AppMethodBeat.i(64909);
        if (this.e) {
            this.f.reload();
            AppMethodBeat.o(64909);
            return;
        }
        this.g.reload();
        AppMethodBeat.o(64909);
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(64962);
        if (!this.e) {
            if (VERSION.SDK_INT >= 11) {
                r.a(this.g, "removeJavascriptInterface", new Class[]{String.class}, str);
                AppMethodBeat.o(64962);
                return;
            }
            this.f.removeJavascriptInterface(str);
        }
        AppMethodBeat.o(64962);
    }

    public void removeView(View view) {
        AppMethodBeat.i(65005);
        if (this.e) {
            View view2 = this.f.getView();
            try {
                Method a = r.a(view2, "removeView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                AppMethodBeat.o(65005);
                return;
            } catch (Throwable th) {
                AppMethodBeat.o(65005);
                return;
            }
        }
        this.g.removeView(view);
        AppMethodBeat.o(65005);
    }

    public void reportInitPerformance(long j, int i, long j2, long j3) {
        AppMethodBeat.i(64898);
        TbsLog.i("sdkreport", "reportInitPerformance initType is " + j + " isX5Core is " + this.e + " isPerformanceDataRecorded" + this.m);
        if (!(!this.e || this.l == null || this.m)) {
            this.l.a("init_type", j);
            this.l.a("time_oncreate", j2);
            this.l.a("webview_type", (long) i);
            this.l.a("time_webaccelerator", j3);
            if (this.l.a(this.f.hashCode(), getUrl())) {
                this.m = true;
            }
        }
        AppMethodBeat.o(64898);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        AppMethodBeat.i(64879);
        boolean requestChildRectangleOnScreen;
        if (this.e) {
            View view2 = this.f.getView();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (view != this) {
                    view2 = view;
                }
                requestChildRectangleOnScreen = viewGroup.requestChildRectangleOnScreen(view2, rect, z);
                AppMethodBeat.o(64879);
                return requestChildRectangleOnScreen;
            }
            AppMethodBeat.o(64879);
            return false;
        }
        b bVar = this.g;
        if (view == this) {
            view = this.g;
        }
        requestChildRectangleOnScreen = bVar.requestChildRectangleOnScreen(view, rect, z);
        AppMethodBeat.o(64879);
        return requestChildRectangleOnScreen;
    }

    public void requestFocusNodeHref(Message message) {
        AppMethodBeat.i(64925);
        if (this.e) {
            this.f.requestFocusNodeHref(message);
            AppMethodBeat.o(64925);
            return;
        }
        this.g.requestFocusNodeHref(message);
        AppMethodBeat.o(64925);
    }

    public void requestImageRef(Message message) {
        AppMethodBeat.i(64926);
        if (this.e) {
            this.f.requestImageRef(message);
            AppMethodBeat.o(64926);
            return;
        }
        this.g.requestImageRef(message);
        AppMethodBeat.o(64926);
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        AppMethodBeat.i(64896);
        boolean restorePicture;
        if (this.e) {
            restorePicture = this.f.restorePicture(bundle, file);
            AppMethodBeat.o(64896);
            return restorePicture;
        }
        Object a = r.a(this.g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        if (a == null) {
            AppMethodBeat.o(64896);
            return false;
        }
        restorePicture = ((Boolean) a).booleanValue();
        AppMethodBeat.o(64896);
        return restorePicture;
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        AppMethodBeat.i(64897);
        WebBackForwardList a;
        if (this.e) {
            a = WebBackForwardList.a(this.f.restoreState(bundle));
            AppMethodBeat.o(64897);
            return a;
        }
        a = WebBackForwardList.a(this.g.restoreState(bundle));
        AppMethodBeat.o(64897);
        return a;
    }

    public void resumeTimers() {
        AppMethodBeat.i(64939);
        if (this.e) {
            this.f.resumeTimers();
            AppMethodBeat.o(64939);
            return;
        }
        this.g.resumeTimers();
        AppMethodBeat.o(64939);
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        AppMethodBeat.i(64885);
        if (this.e) {
            this.f.savePassword(str, str2, str3);
            AppMethodBeat.o(64885);
            return;
        }
        r.a(this.g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        AppMethodBeat.o(64885);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        AppMethodBeat.i(64895);
        boolean savePicture;
        if (this.e) {
            savePicture = this.f.savePicture(bundle, file);
            AppMethodBeat.o(64895);
            return savePicture;
        }
        Object a = r.a(this.g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        if (a == null) {
            AppMethodBeat.o(64895);
            return false;
        }
        savePicture = ((Boolean) a).booleanValue();
        AppMethodBeat.o(64895);
        return savePicture;
    }

    public WebBackForwardList saveState(Bundle bundle) {
        AppMethodBeat.i(64894);
        WebBackForwardList a;
        if (this.e) {
            a = WebBackForwardList.a(this.f.saveState(bundle));
            AppMethodBeat.o(64894);
            return a;
        }
        a = WebBackForwardList.a(this.g.saveState(bundle));
        AppMethodBeat.o(64894);
        return a;
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        AppMethodBeat.i(64905);
        if (this.e) {
            this.f.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            r.a(this.g, "saveWebArchive", new Class[]{String.class}, str);
            AppMethodBeat.o(64905);
            return;
        }
        AppMethodBeat.o(64905);
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(64906);
        if (this.e) {
            this.f.saveWebArchive(str, z, valueCallback);
        } else if (VERSION.SDK_INT >= 11) {
            r.a(this.g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
            AppMethodBeat.o(64906);
            return;
        }
        AppMethodBeat.o(64906);
    }

    public void setARModeEnable(boolean z) {
        AppMethodBeat.i(64997);
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z);
            }
            AppMethodBeat.o(64997);
        } catch (Throwable th) {
            AppMethodBeat.o(64997);
        }
    }

    public void setBackgroundColor(int i) {
        AppMethodBeat.i(64977);
        if (this.e) {
            this.f.setBackgroundColor(i);
        } else {
            this.g.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
        AppMethodBeat.o(64977);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        AppMethodBeat.i(64884);
        if (this.e) {
            this.f.setCertificate(sslCertificate);
            AppMethodBeat.o(64884);
            return;
        }
        this.g.setCertificate(sslCertificate);
        AppMethodBeat.o(64884);
    }

    public void setDayOrNight(boolean z) {
        AppMethodBeat.i(64996);
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
            AppMethodBeat.o(64996);
        } catch (Throwable th) {
            AppMethodBeat.o(64996);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(64958);
        if (this.e) {
            this.f.setDownloadListener(new b(this, downloadListener, this.e));
            AppMethodBeat.o(64958);
            return;
        }
        this.g.setDownloadListener(new bq(this, downloadListener));
        AppMethodBeat.o(64958);
    }

    @TargetApi(16)
    public void setFindListener(FindListener findListener) {
        AppMethodBeat.i(64948);
        if (this.e) {
            this.f.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.g.setFindListener(new bp(this, findListener));
            AppMethodBeat.o(64948);
            return;
        }
        AppMethodBeat.o(64948);
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        AppMethodBeat.i(64875);
        if (this.e) {
            this.f.setHorizontalScrollbarOverlay(z);
            AppMethodBeat.o(64875);
            return;
        }
        this.g.setHorizontalScrollbarOverlay(z);
        AppMethodBeat.o(64875);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(64886);
        if (this.e) {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
            AppMethodBeat.o(64886);
            return;
        }
        this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(64886);
    }

    public void setInitialScale(int i) {
        AppMethodBeat.i(64921);
        if (this.e) {
            this.f.setInitialScale(i);
            AppMethodBeat.o(64921);
            return;
        }
        this.g.setInitialScale(i);
        AppMethodBeat.o(64921);
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        AppMethodBeat.i(64966);
        if (this.e) {
            this.f.setMapTrackballToArrowKeys(z);
            AppMethodBeat.o(64966);
            return;
        }
        r.a(this.g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(64966);
    }

    public void setNetworkAvailable(boolean z) {
        AppMethodBeat.i(64893);
        if (this.e) {
            this.f.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.g.setNetworkAvailable(z);
            AppMethodBeat.o(64893);
            return;
        }
        AppMethodBeat.o(64893);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(64999);
        if (this.e) {
            View view = this.f.getView();
            try {
                if (this.A == null) {
                    Method a = r.a(view, "getListenerInfo", new Class[0]);
                    a.setAccessible(true);
                    Object invoke = a.invoke(view, null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.A = declaredField.get(invoke);
                }
                this.B = onLongClickListener;
                getView().setOnLongClickListener(this);
                AppMethodBeat.o(64999);
                return;
            } catch (Throwable th) {
                AppMethodBeat.o(64999);
                return;
            }
        }
        this.g.setOnLongClickListener(onLongClickListener);
        AppMethodBeat.o(64999);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(64991);
        getView().setOnTouchListener(onTouchListener);
        AppMethodBeat.o(64991);
    }

    public void setPictureListener(PictureListener pictureListener) {
        AppMethodBeat.i(64960);
        if (this.e) {
            if (pictureListener == null) {
                this.f.setPictureListener(null);
                AppMethodBeat.o(64960);
                return;
            }
            this.f.setPictureListener(new bs(this, pictureListener));
            AppMethodBeat.o(64960);
        } else if (pictureListener == null) {
            this.g.setPictureListener(null);
            AppMethodBeat.o(64960);
        } else {
            this.g.setPictureListener(new br(this, pictureListener));
            AppMethodBeat.o(64960);
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        AppMethodBeat.i(64932);
        try {
            if (this.e) {
                AppMethodBeat.o(64932);
            } else if (VERSION.SDK_INT < 26) {
                AppMethodBeat.o(64932);
            } else {
                r.a(this.g, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
                AppMethodBeat.o(64932);
            }
        } catch (Exception e) {
            AppMethodBeat.o(64932);
        }
    }

    public void setScrollBarStyle(int i) {
        AppMethodBeat.i(64874);
        if (this.e) {
            this.f.getView().setScrollBarStyle(i);
            AppMethodBeat.o(64874);
            return;
        }
        this.g.setScrollBarStyle(i);
        AppMethodBeat.o(64874);
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        AppMethodBeat.i(64876);
        if (this.e) {
            this.f.setVerticalScrollbarOverlay(z);
            AppMethodBeat.o(64876);
            return;
        }
        this.g.setVerticalScrollbarOverlay(z);
        AppMethodBeat.o(64876);
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        AppMethodBeat.i(64990);
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            AppMethodBeat.o(64990);
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        AppMethodBeat.o(64990);
        return true;
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(65020);
        super.setVisibility(i);
        if (getView() == null) {
            AppMethodBeat.o(65020);
            return;
        }
        getView().setVisibility(i);
        AppMethodBeat.o(65020);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        AppMethodBeat.i(64959);
        if (this.e) {
            IX5WebChromeClient qVar;
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webChromeClient != null) {
                qVar = new q(bv.a().a(true).i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(qVar);
        } else {
            b bVar = this.g;
            if (webChromeClient != null) {
                webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
            }
            bVar.setWebChromeClient(webChromeClient2);
        }
        this.r = webChromeClient;
        AppMethodBeat.o(64959);
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        AppMethodBeat.i(64985);
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
            AppMethodBeat.o(64985);
            return;
        }
        AppMethodBeat.o(64985);
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        AppMethodBeat.i(64956);
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
        AppMethodBeat.o(64956);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        AppMethodBeat.i(64955);
        if (this.e) {
            IX5WebViewClient vVar;
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webViewClient != null) {
                vVar = new v(bv.a().a(true).j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(vVar);
        } else {
            b bVar = this.g;
            if (webViewClient != null) {
                webViewClient2 = new ad(this, webViewClient);
            }
            bVar.setWebViewClient(webViewClient2);
        }
        this.q = webViewClient;
        AppMethodBeat.o(64955);
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        AppMethodBeat.i(64984);
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
            AppMethodBeat.o(64984);
            return;
        }
        AppMethodBeat.o(64984);
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        AppMethodBeat.i(64901);
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            d.a(this.i).a(toLowerCase, this, this.i, al.a().getLooper());
            AppMethodBeat.o(64901);
            return true;
        } else if (!toLowerCase.startsWith("http://debugx5.qq.com")) {
            AppMethodBeat.o(64901);
            return false;
        } else if (this.e) {
            AppMethodBeat.o(64901);
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
            AppMethodBeat.o(64901);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        AppMethodBeat.i(64907);
        if (this.e) {
            this.f.stopLoading();
            AppMethodBeat.o(64907);
            return;
        }
        this.g.stopLoading();
        AppMethodBeat.o(64907);
    }

    public void super_computeScroll() {
        AppMethodBeat.i(65015);
        if (this.e) {
            try {
                r.a(this.f.getView(), "super_computeScroll");
                AppMethodBeat.o(65015);
                return;
            } catch (Throwable th) {
                AppMethodBeat.o(65015);
                return;
            }
        }
        this.g.a();
        AppMethodBeat.o(65015);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(65012);
        boolean booleanValue;
        if (this.e) {
            try {
                Object a = r.a(this.f.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
                if (a == null) {
                    AppMethodBeat.o(65012);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(65012);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.o(65012);
                return false;
            }
        }
        booleanValue = this.g.b(motionEvent);
        AppMethodBeat.o(65012);
        return booleanValue;
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(65013);
        boolean booleanValue;
        if (this.e) {
            try {
                Object a = r.a(this.f.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
                if (a == null) {
                    AppMethodBeat.o(65013);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(65013);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.o(65013);
                return false;
            }
        }
        booleanValue = this.g.c(motionEvent);
        AppMethodBeat.o(65013);
        return booleanValue;
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(65011);
        if (this.e) {
            try {
                r.a(this.f.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                AppMethodBeat.o(65011);
                return;
            } catch (Throwable th) {
                AppMethodBeat.o(65011);
                return;
            }
        }
        this.g.a(i, i2, z, z2);
        AppMethodBeat.o(65011);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(65009);
        if (this.e) {
            try {
                r.a(this.f.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                AppMethodBeat.o(65009);
                return;
            } catch (Throwable th) {
                AppMethodBeat.o(65009);
                return;
            }
        }
        this.g.a(i, i2, i3, i4);
        AppMethodBeat.o(65009);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(65014);
        boolean booleanValue;
        if (this.e) {
            try {
                Object a = r.a(this.f.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
                if (a == null) {
                    AppMethodBeat.o(65014);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(65014);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.o(65014);
                return false;
            }
        }
        booleanValue = this.g.a(motionEvent);
        AppMethodBeat.o(65014);
        return booleanValue;
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.i(65010);
        boolean booleanValue;
        if (this.e) {
            try {
                Object a = r.a(this.f.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
                if (a == null) {
                    AppMethodBeat.o(65010);
                    return false;
                }
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(65010);
                return booleanValue;
            } catch (Throwable th) {
                AppMethodBeat.o(65010);
                return false;
            }
        }
        booleanValue = this.g.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.o(65010);
        return booleanValue;
    }

    public void switchNightMode(boolean z) {
        AppMethodBeat.i(64993);
        if (z == z) {
            AppMethodBeat.o(64993);
            return;
        }
        z = z;
        if (z) {
            TbsLog.e("QB_SDK", "deleteNightMode");
            loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
            AppMethodBeat.o(64993);
            return;
        }
        TbsLog.e("QB_SDK", "nightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        AppMethodBeat.o(64993);
    }

    public void switchToNightMode() {
        AppMethodBeat.i(64994);
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!z) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
        AppMethodBeat.o(64994);
    }

    public void tbsWebviewDestroy(boolean z) {
        AppMethodBeat.i(64888);
        if (!(this.k || this.a == 0)) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e) {
                Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int d = d(this.i);
                if (d == -1) {
                    d = this.a;
                }
                this.a = d;
                e(this.i);
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, i());
            this.a = 0;
            this.k = false;
        }
        if (!this.e) {
            Object invoke;
            Field declaredField;
            try {
                Class cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
                method.setAccessible(true);
                invoke = method.invoke(null, new Object[]{this.g});
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
                this.g.destroy();
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
                    AppMethodBeat.o(64888);
                }
            }
        } else if (z) {
            this.f.destroy();
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
        AppMethodBeat.o(64888);
    }

    public boolean zoomIn() {
        AppMethodBeat.i(64972);
        boolean zoomIn;
        if (this.e) {
            zoomIn = this.f.zoomIn();
            AppMethodBeat.o(64972);
            return zoomIn;
        }
        zoomIn = this.g.zoomIn();
        AppMethodBeat.o(64972);
        return zoomIn;
    }

    public boolean zoomOut() {
        AppMethodBeat.i(64973);
        boolean zoomOut;
        if (this.e) {
            zoomOut = this.f.zoomOut();
            AppMethodBeat.o(64973);
            return zoomOut;
        }
        zoomOut = this.g.zoomOut();
        AppMethodBeat.o(64973);
        return zoomOut;
    }
}
