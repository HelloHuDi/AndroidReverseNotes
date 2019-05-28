package com.tencent.xweb.xwalk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i;
import com.tencent.xweb.l;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.b.e;
import com.tencent.xweb.xwalk.f.c;
import com.tencent.xweb.xwalk.f.d;
import com.tencent.xweb.xwalk.f.g;
import java.util.Map;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkLogMessageListener;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkProxyWebViewClientExtension;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkView.OverScrolledListener;
import org.xwalk.core.XWalkView.ScrollChangedListener;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class j implements h, i {
    static int ASp = 0;
    WebView APS;
    long APY = 0;
    private com.tencent.xweb.extension.video.b APZ;
    l ARX;
    m ARY;
    XWalkView ARZ;
    k ASi;
    AbsoluteLayout ASj;
    g ASk;
    boolean ASl = false;
    private String ASm = null;
    private com.tencent.xweb.x5.a.a.a.a.b ASn = new com.tencent.xweb.x5.a.a.a.a.b();
    private t ASo = null;
    private boolean ASq = false;
    r icr;
    s iuo = new s();
    l iup = new l();
    int mApkVersion = XWalkEnvironment.getAvailableVersion();
    private int type = 0;

    class a extends XWalkView {
        public a(Context context) {
            super(context);
        }

        public final void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(85294);
            super.onScrollChangedDelegate(i, i2, i3, i4);
            if (j.this.APS != null) {
                j.this.APS.onWebViewScrollChanged(i, i2, i3, i4);
            }
            AppMethodBeat.o(85294);
        }
    }

    public static class b {
        public String ASA;
        public String ASB;
        public int ASw;
        public int ASx;
        public int ASy;
        public int ASz;
        public String wYV;
        public String wYW;
        public String wYX;

        public static b b(String str, String str2, int i, int i2, String str3, String str4) {
            String stringBuffer;
            Object obj;
            String str5;
            int i3;
            int i4;
            Object obj2 = 1;
            AppMethodBeat.i(85295);
            b bVar = new b();
            bVar.wYV = str;
            bVar.ASB = str2;
            bVar.ASw = i;
            bVar.ASy = i2;
            bVar.wYW = str3;
            bVar.wYX = str4;
            if (i > 0) {
                try {
                    stringBuffer = new StringBuffer(str3).reverse().toString();
                    obj = null;
                } catch (Exception e) {
                    Log.e("XWWebView", "SelectInfo getSelectInfo error:" + e.getMessage());
                }
            } else {
                i *= -1;
                stringBuffer = str + str4;
                int obj3 = 1;
            }
            if (i2 > 0) {
                str5 = str4;
                obj2 = null;
            } else {
                i2 *= -1;
                str5 = new StringBuffer(str).reverse().toString() + new StringBuffer(str3).reverse().toString();
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 <= stringBuffer.length()) {
                if (i <= stringBuffer.substring(0, i5).getBytes().length) {
                    break;
                }
                i6 = i5;
                i5++;
            }
            i5 = i6;
            int i7 = 0;
            for (i6 = 0; i6 <= str5.length(); i6++) {
                if (i2 <= str5.substring(0, i6).getBytes().length) {
                    i3 = i6;
                    break;
                }
                i7 = i6;
            }
            i3 = i7;
            if (obj3 != null) {
                i5 *= -1;
            }
            if (obj2 != null) {
                i3 *= -1;
            }
            if ((str.length() + i5) + i3 <= 0) {
                Log.e("XWWebView", "getSelectInfo error prefixIndex:" + i5 + ",suffixIndex:" + i3);
                i3 = 0;
                i4 = 0;
            } else {
                i4 = i5;
            }
            bVar.ASx = i4;
            bVar.ASz = i3;
            bVar.ASA = (str3 + str + str4).substring(str3.length() - i4, i3 + (str3.length() + str.length()));
            AppMethodBeat.o(85295);
            return bVar;
        }

        public final String toString() {
            AppMethodBeat.i(85296);
            String str;
            try {
                str = "SelectInfo PickedWord:" + this.wYV + ",PrefixText:" + this.wYW + ",SuffixText:" + this.wYX + ",PrefixOffset:" + this.ASw + ",prefixIndex:" + this.ASx + ",SuffixOffset:" + this.ASy + ",SuffixIndex:" + this.ASz + ",ResultPickedWord:" + this.ASB + ",OffsetedPickedWord:" + this.ASA;
                AppMethodBeat.o(85296);
                return str;
            } catch (Exception e) {
                str = "SelectInfo toString error";
                AppMethodBeat.o(85296);
                return str;
            }
        }
    }

    public static synchronized boolean fE(Context context) {
        boolean isXWalkReady;
        synchronized (j.class) {
            AppMethodBeat.i(85297);
            e.jF(context);
            isXWalkReady = e.isXWalkReady();
            AppMethodBeat.o(85297);
        }
        return isXWalkReady;
    }

    private void dVJ() {
        AppMethodBeat.i(85298);
        if (this.ARX != null) {
            AppMethodBeat.o(85298);
            return;
        }
        this.ARX = new l(this.ARZ) {
            String ASr = null;

            public final void onPageLoadStarted(XWalkView xWalkView, String str) {
                AppMethodBeat.i(85248);
                Log.i("XWWebView", "onPageLoadStarted: url = ".concat(String.valueOf(str)));
                j.this.iuo.b(j.this.APS, str, j.this.ARZ.getFavicon());
                com.tencent.xweb.c.j.dUB().dUx();
                this.ASr = null;
                if (!(j.this.ASm == null || str == null || str.equals(j.this.ASm) || f.avq(str) == f.avq(j.this.ASm))) {
                    if (f.avq(j.this.ASm) == 1 && f.avq(str) == 2) {
                        j.this.type = 1;
                    } else if (f.avq(j.this.ASm) == 2 && f.avq(str) == 1) {
                        j.this.type = 2;
                    }
                }
                j.this.ASm = str;
                j.this.APY = System.currentTimeMillis();
                if (str == null) {
                    str = "";
                }
                f.eV(str, j.this.type);
                if (j.this.APZ != null) {
                    j.this.APZ.am(true, j.this.APS.getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS);
                }
                AppMethodBeat.o(85248);
            }

            public final void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
                AppMethodBeat.i(85249);
                if (this.ASr == null || !this.ASr.equals(str)) {
                    if (j.this.APZ != null) {
                        j.this.APZ.am(false, j.this.APS.getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS);
                    }
                    this.ASr = str;
                    Log.i("XWWebView", "onPageFinished: url = " + str + " status = " + loadStatus);
                    j.this.iuo.b(j.this.APS, str);
                    if (loadStatus != LoadStatus.FAILED) {
                        com.tencent.xweb.c.j.dUB().dUy();
                    }
                    f.q(str, System.currentTimeMillis() - j.this.APY, j.this.type);
                    j.this.APY = System.currentTimeMillis();
                    AppMethodBeat.o(85249);
                    return;
                }
                Log.i("XWWebView", "abandoned onPageFinished: url = " + str + " status = " + loadStatus);
                AppMethodBeat.o(85249);
            }

            public final void onReceivedTitle(XWalkView xWalkView, String str) {
                AppMethodBeat.i(85250);
                Log.i("XWWebView", "onReceivedTitle: ".concat(String.valueOf(str)));
                super.onReceivedTitle(xWalkView, str);
                j.this.iup.d(null, str);
                if (j.this.APZ != null) {
                    j.this.APZ.am(true, j.this.APS.getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS);
                }
                AppMethodBeat.o(85250);
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                AppMethodBeat.i(85251);
                Log.i("XWWebView", "onShowCustomView:".concat(String.valueOf(view)));
                j.this.iup.aJY();
                f.dUS();
                j.this.ASj.setVisibility(4);
                if (j.this.APZ != null) {
                    j.this.APZ.onShowCustomView(view, new com.tencent.xweb.xwalk.f.a(customViewCallback));
                }
                AppMethodBeat.o(85251);
            }

            public final void onHideCustomView() {
                AppMethodBeat.i(85252);
                Log.i("XWWebView", "onHideCustomView");
                j.this.iup.aDI();
                j.this.ASj.setVisibility(0);
                if (j.this.APZ != null) {
                    j.this.APZ.onHideCustomView();
                }
                AppMethodBeat.o(85252);
            }

            public final View getVideoLoadingProgressView() {
                AppMethodBeat.i(85253);
                Log.i("XWWebView", "getVideoLoadingProgressView");
                View inflate = LayoutInflater.from(j.this.APS.getContext()).inflate(R.layout.b1g, null);
                AppMethodBeat.o(85253);
                return inflate;
            }

            public final boolean onSelectInfoChanged(XWalkView xWalkView, long j, String str, String str2, String str3) {
                AppMethodBeat.i(85254);
                if (isSearchable()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("PickedWord", str);
                    bundle.putString("PrefixText", str2);
                    bundle.putString("SuffixText", str3);
                    Object onMiscCallBack = j.this.ASn.onMiscCallBack("smartPickWord", bundle);
                    if (onMiscCallBack instanceof Bundle) {
                        Bundle bundle2 = (Bundle) onMiscCallBack;
                        if (!(bundle2 == null || bundle2.getString("PickedWord") == null)) {
                            int i = bundle2.getInt("PrefixOffset");
                            int i2 = bundle2.getInt("SuffixOffset");
                            b b = b.b(str, bundle2.getString("PickedWord"), i, i2, str2, str3);
                            Log.d("XWWebView", "onSelectInfoChanged " + b.toString());
                            xWalkView.adjustSelectPosition(j, bundle2.getString("PickedWord"), -b.ASx, b.ASz);
                        }
                        AppMethodBeat.o(85254);
                        return true;
                    }
                    AppMethodBeat.o(85254);
                    return false;
                }
                AppMethodBeat.o(85254);
                return false;
            }

            public final void onShowSos() {
                AppMethodBeat.i(85255);
                j.this.ASn.onMiscCallBack("onShowSos", new Bundle());
                AppMethodBeat.o(85255);
            }

            public final boolean isSearchable() {
                AppMethodBeat.i(85256);
                Object onMiscCallBack = j.this.ASn.onMiscCallBack("supportSmartPickWord", new Bundle());
                if (onMiscCallBack instanceof Boolean) {
                    boolean booleanValue = ((Boolean) onMiscCallBack).booleanValue();
                    AppMethodBeat.o(85256);
                    return booleanValue;
                }
                AppMethodBeat.o(85256);
                return false;
            }

            public final boolean onSearchWord(XWalkView xWalkView, String str, String str2, String str3) {
                AppMethodBeat.i(85257);
                if (isSearchable()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(SearchIntents.EXTRA_QUERY, str);
                    j.this.ASn.onMiscCallBack("jumpToSos", bundle);
                    j.this.ARZ.getUrl();
                    j.this.ARZ.getRefererUrl();
                    j.this.ARZ.getTitle();
                    AppMethodBeat.o(85257);
                    return true;
                }
                AppMethodBeat.o(85257);
                return false;
            }

            public final boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(85258);
                Log.i("XWWebView", "onJsAlert");
                boolean a = j.this.iup.a(j.this.APS, str, str2, new c(xWalkJavascriptResult));
                AppMethodBeat.o(85258);
                return a;
            }

            public final boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(85259);
                Log.i("XWWebView", "onJsConfirm");
                boolean b = j.this.iup.b(j.this.APS, str, str2, new c(xWalkJavascriptResult));
                AppMethodBeat.o(85259);
                return b;
            }

            public final boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(85260);
                Log.i("XWWebView", "onJsPrompt");
                boolean a = j.this.iup.a(j.this.APS, str, str2, str3, new d(xWalkJavascriptResult));
                AppMethodBeat.o(85260);
                return a;
            }

            public final void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
                AppMethodBeat.i(85261);
                j.this.iup.onGeolocationPermissionsShowPrompt(str, new com.tencent.xweb.xwalk.f.b(xWalkGeolocationPermissionsCallback));
                AppMethodBeat.o(85261);
            }

            public final void onGeolocationPermissionsHidePrompt() {
            }

            public final boolean onConsoleMessage(XWalkView xWalkView, String str, int i, String str2, ConsoleMessageType consoleMessageType) {
                AppMethodBeat.i(85262);
                if (ConsoleMessageType.ERROR == consoleMessageType && j.this.ASo != null && str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).length == 2) {
                    j.this.ASo;
                    f.dVa();
                }
                l lVar = j.this.iup;
                MessageLevel messageLevel = MessageLevel.DEBUG;
                switch (com.tencent.xweb.xwalk.f.AnonymousClass1.ARS[consoleMessageType.ordinal()]) {
                    case 1:
                        messageLevel = MessageLevel.DEBUG;
                        break;
                    case 2:
                        messageLevel = MessageLevel.ERROR;
                        break;
                    case 3:
                        messageLevel = MessageLevel.LOG;
                        break;
                    case 4:
                        messageLevel = MessageLevel.TIP;
                        break;
                    case 5:
                        messageLevel = MessageLevel.WARNING;
                        break;
                }
                boolean onConsoleMessage = lVar.onConsoleMessage(new ConsoleMessage(str, str2, i, messageLevel));
                AppMethodBeat.o(85262);
                return onConsoleMessage;
            }

            public final void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
                AppMethodBeat.i(85263);
                Log.i("XWWebView", "openFileChooser with three param");
                j.this.iup.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.o(85263);
            }

            public final boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
                AppMethodBeat.i(85264);
                boolean onCreateWindowRequested = super.onCreateWindowRequested(xWalkView, initiateBy, valueCallback);
                AppMethodBeat.o(85264);
                return onCreateWindowRequested;
            }

            public final void onIconAvailable(XWalkView xWalkView, String str, Message message) {
                AppMethodBeat.i(85265);
                super.onIconAvailable(xWalkView, str, message);
                AppMethodBeat.o(85265);
            }

            public final void onDidChangeThemeColor(XWalkView xWalkView, int i) {
            }

            public final void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
                AppMethodBeat.i(85266);
                super.onReceivedIcon(xWalkView, str, bitmap);
                AppMethodBeat.o(85266);
            }

            public final void onRequestFocus(XWalkView xWalkView) {
                AppMethodBeat.i(85267);
                super.onRequestFocus(xWalkView);
                AppMethodBeat.o(85267);
            }

            public final void onJavascriptCloseWindow(XWalkView xWalkView) {
                AppMethodBeat.i(85268);
                super.onJavascriptCloseWindow(xWalkView);
                AppMethodBeat.o(85268);
            }

            public final boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(85269);
                boolean onJavascriptModalDialog = super.onJavascriptModalDialog(xWalkView, javascriptMessageType, str, str2, str3, xWalkJavascriptResult);
                AppMethodBeat.o(85269);
                return onJavascriptModalDialog;
            }

            public final void onFullscreenToggled(XWalkView xWalkView, boolean z) {
                AppMethodBeat.i(85270);
                super.onFullscreenToggled(xWalkView, z);
                AppMethodBeat.o(85270);
            }

            public final void onScaleChanged(XWalkView xWalkView, float f, float f2) {
                AppMethodBeat.i(85271);
                j.this.iuo.a(j.this.APS, f, f2);
                AppMethodBeat.o(85271);
            }

            public final boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                AppMethodBeat.i(85272);
                boolean shouldOverrideKeyEvent = super.shouldOverrideKeyEvent(xWalkView, keyEvent);
                AppMethodBeat.o(85272);
                return shouldOverrideKeyEvent;
            }

            public final void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                AppMethodBeat.i(85273);
                super.onUnhandledKeyEvent(xWalkView, keyEvent);
                AppMethodBeat.o(85273);
            }

            public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
                AppMethodBeat.i(85274);
                super.onShowCustomView(view, i, customViewCallback);
                AppMethodBeat.o(85274);
            }

            public final boolean shouldDiscardCurrentPage() {
                AppMethodBeat.i(85275);
                boolean shouldDiscardCurrentPage;
                if (j.this.ASn != null) {
                    shouldDiscardCurrentPage = j.this.ASn.shouldDiscardCurrentPage();
                    AppMethodBeat.o(85275);
                    return shouldDiscardCurrentPage;
                }
                shouldDiscardCurrentPage = super.shouldDiscardCurrentPage();
                AppMethodBeat.o(85275);
                return shouldDiscardCurrentPage;
            }

            public final void onClearCurrentPage() {
                AppMethodBeat.i(85276);
                if (j.this.ASn != null) {
                    j.this.ASn.hasDiscardCurrentPage(true);
                }
                AppMethodBeat.o(85276);
            }
        };
        this.ASk.ARX = this.ARX;
        this.ARZ.setUIClient(this.ARX);
        this.ARY = new m(this.ARZ) {
            int ASt = 0;

            public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
                AppMethodBeat.i(85278);
                boolean a = j.this.iuo.a(j.this.APS, str);
                Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + a + " url = " + str);
                AppMethodBeat.o(85278);
                return a;
            }

            public final void onLoadStarted(XWalkView xWalkView, String str) {
                AppMethodBeat.i(85279);
                j.this.iuo.h(j.this.APS, str);
                AppMethodBeat.o(85279);
            }

            public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
                Bundle bundle;
                o a;
                o c;
                AppMethodBeat.i(85280);
                n hVar = new f.h(xWalkWebResourceRequest);
                if (hVar.APN == null) {
                    bundle = null;
                } else {
                    bundle = hVar.APN.getBundle();
                }
                if (bundle != null) {
                    a = j.this.iuo.a(j.this.APS, hVar, bundle);
                } else {
                    a = null;
                }
                if (a == null) {
                    a = j.this.iuo.a(j.this.APS, hVar);
                }
                if (a == null) {
                    c = j.this.iuo.c(j.this.APS, xWalkWebResourceRequest.getUrl().toString());
                } else {
                    c = a;
                }
                if (c != null) {
                    XWalkWebResourceResponse createXWalkWebResourceResponse = createXWalkWebResourceResponse(c.mMimeType, c.mEncoding, c.mInputStream, c.mStatusCode, c.mReasonPhrase, c.mResponseHeaders);
                    AppMethodBeat.o(85280);
                    return createXWalkWebResourceResponse;
                }
                AppMethodBeat.o(85280);
                return null;
            }

            public final void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
                AppMethodBeat.i(85281);
                Log.i("XWWebView", "onReceivedError ".concat(String.valueOf(str2)));
                super.onReceivedLoadError(xWalkView, i, str, str2);
                j.this.ASl = true;
                j.this.iuo.a(j.this.APS, i, str, str2);
                StringBuilder stringBuilder = new StringBuilder(2000);
                stringBuilder.append("<html>\n");
                stringBuilder.append("<head>\n");
                stringBuilder.append("<script type=\"text/javascript\">\n");
                stringBuilder.append("function jumurl(){\n");
                stringBuilder.append("　　window.location.href = '");
                stringBuilder.append(str2);
                stringBuilder.append("';\n");
                stringBuilder.append("}\n");
                stringBuilder.append("</script>\n");
                stringBuilder.append("<title>无法打开页面</title>\n");
                stringBuilder.append("<script >\n");
                stringBuilder.append("var html = document.documentElement,");
                stringBuilder.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
                stringBuilder.append("function setHtmlFontSize() {");
                stringBuilder.append("var cliWidth = html.clientWidth;");
                stringBuilder.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
                stringBuilder.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
                stringBuilder.append("</script>\n");
                stringBuilder.append("<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\n");
                stringBuilder.append("<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\n");
                stringBuilder.append("<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\n");
                stringBuilder.append("</head>\n");
                stringBuilder.append("<body bgcolor=\"#F2F2F2\" onclick=\"jumurl()\"'\">\n");
                stringBuilder.append("<br></br>");
                stringBuilder.append("<p></p>");
                stringBuilder.append("<div class=\"exp\" ><img src=\"html/img/webview_404_refresh_icon.svg\" text-align:center /><div>");
                stringBuilder.append("<br></br>");
                stringBuilder.append("<font size=\"44px\" class=\"fcolorfortitle\">无法打开页面</font>");
                stringBuilder.append("<br></br>");
                stringBuilder.append("<font size=\"44px\" class=\"fcolorforsubtitle\">轻触屏幕重新加载</font>");
                stringBuilder.append("</body>\n");
                stringBuilder.append("</html>");
                j.this.ARZ.loadDataWithBaseURL("file:///android_asset/", stringBuilder.toString(), "text/html", ProtocolPackage.ServerEncoding, null);
                com.tencent.xweb.c.j.dUB().dUC();
                f.b(str2, i, System.currentTimeMillis() - j.this.APY, j.this.type);
                AppMethodBeat.o(85281);
            }

            public final void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
                AppMethodBeat.i(85282);
                Log.i("XWWebView", "onReceivedSslError " + sslError.getPrimaryError());
                j.this.iuo.a(j.this.APS, new g(valueCallback), sslError);
                AppMethodBeat.o(85282);
            }

            public final void onProgressChanged(XWalkView xWalkView, int i) {
                AppMethodBeat.i(85283);
                if (Math.abs(i - this.ASt) > 5 || i == 100) {
                    this.ASt = i;
                    Log.i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(i)));
                }
                j.this.iup.a(j.this.APS, i);
                AppMethodBeat.o(85283);
            }

            public final void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
                AppMethodBeat.i(85284);
                super.onDocumentLoadedInFrame(xWalkView, j);
                AppMethodBeat.o(85284);
            }

            public final void onLoadFinished(XWalkView xWalkView, String str) {
                AppMethodBeat.i(85285);
                super.onLoadFinished(xWalkView, str);
                AppMethodBeat.o(85285);
            }

            public final void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
                AppMethodBeat.i(85286);
                super.onReceivedClientCertRequest(xWalkView, clientCertRequest);
                AppMethodBeat.o(85286);
            }

            public final void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
                AppMethodBeat.i(85287);
                if (xWalkWebResourceResponse.getStatusCode() == 302) {
                    String str = (String) xWalkWebResourceResponse.getResponseHeaders().get(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
                    if (str == null || str.isEmpty()) {
                        str = (String) xWalkWebResourceResponse.getResponseHeaders().get("Location");
                    }
                    if (str != null && str.trim().startsWith("weixin://")) {
                        j.this.iuo.b(j.this.APS, str, null);
                        j.this.ARZ.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(85277);
                                j.this.iuo.b(j.this.APS, str, null);
                                AppMethodBeat.o(85277);
                            }
                        }, 300);
                    }
                } else if (xWalkWebResourceResponse.getStatusCode() >= 400) {
                    o oVar;
                    Log.i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
                    s sVar = j.this.iuo;
                    WebView webView = j.this.APS;
                    n hVar = new f.h(xWalkWebResourceRequest);
                    if (xWalkWebResourceResponse == null) {
                        oVar = null;
                    } else {
                        oVar = new o(xWalkWebResourceResponse.getMimeType(), xWalkWebResourceResponse.getEncoding(), xWalkWebResourceResponse.getStatusCode(), xWalkWebResourceResponse.getReasonPhrase(), xWalkWebResourceResponse.getResponseHeaders(), xWalkWebResourceResponse.getData());
                    }
                    sVar.a(webView, hVar, oVar);
                    j.this.iuo.a(j.this.APS, xWalkWebResourceResponse.getStatusCode(), "", xWalkWebResourceRequest.getUrl() != null ? xWalkWebResourceRequest.getUrl().toString() : "");
                }
                super.onReceivedResponseHeaders(xWalkView, xWalkWebResourceRequest, xWalkWebResourceResponse);
                AppMethodBeat.o(85287);
            }

            public final void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
                AppMethodBeat.i(85288);
                if (str == null || !str.startsWith("data:text/html;charset=utf-8")) {
                    j.this.iuo.a(j.this.APS, str, z);
                    AppMethodBeat.o(85288);
                    return;
                }
                AppMethodBeat.o(85288);
            }

            public final void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
                AppMethodBeat.i(85289);
                super.onReceivedHttpAuthRequest(xWalkView, xWalkHttpAuthHandler, str, str2);
                AppMethodBeat.o(85289);
            }
        };
        this.ASk.ARY = this.ARY;
        this.ARZ.setResourceClient(this.ARY);
        this.ARZ.setProxyWebViewClientExtension(new XWalkProxyWebViewClientExtension() {
            public final Object onMiscCallBack(String str, Bundle bundle) {
                AppMethodBeat.i(85290);
                if (j.this.ASn != null) {
                    Object onMiscCallBack = j.this.ASn.onMiscCallBack(str, bundle);
                    AppMethodBeat.o(85290);
                    return onMiscCallBack;
                }
                AppMethodBeat.o(85290);
                return null;
            }
        });
        AppMethodBeat.o(85298);
    }

    public j(WebView webView) {
        AppMethodBeat.i(85299);
        XWalkContextWrapper xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), this.mApkVersion);
        XWalkLibraryLoader.prepareToInit(xWalkContextWrapper);
        try {
            XWalkPreferences.setValue(XWalkPreferences.XWEB_VERSION, String.valueOf(this.mApkVersion));
            XWalkPreferences.setValue(XWalkPreferences.XWEBSDK_VERSION, "190301");
        } catch (Exception e) {
            Log.e("XWWebView", e.getMessage());
        }
        this.ARZ = new a(xWalkContextWrapper);
        this.ARZ.setBackgroundColor(0);
        this.ASj = new AbsoluteLayout(xWalkContextWrapper);
        this.ARZ.getXWalkContentView().addView(this.ASj);
        this.ARZ.setCustomOnScrollChangedListener(new ScrollChangedListener() {
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                AppMethodBeat.i(85291);
                j.this.ASj.scrollTo(i, i2);
                if (j.this.icr != null) {
                    j.this.icr.onScrollChanged(i, i2, i3, i4, j.this.ARZ);
                }
                AppMethodBeat.o(85291);
            }
        });
        this.ARZ.setCustomOnOverScrolledListener(new OverScrolledListener() {
            public final void onOverScrolled(boolean z) {
                AppMethodBeat.i(85292);
                if (z) {
                    j.this.ASq = true;
                    AppMethodBeat.o(85292);
                    return;
                }
                j.this.ASq = false;
                AppMethodBeat.o(85292);
            }
        });
        this.ASk = new g(this.ARZ);
        this.APS = webView;
        this.ASi = new k(this.ARZ);
        this.ARZ.getSettings().SetLogCallBack(new XWalkLogMessageListener() {
            public final void onLogMessage(int i, String str, int i2, String str2) {
                AppMethodBeat.i(85293);
                Log.i("XWWebView", "[WCWebview] :".concat(String.valueOf(str2)));
                AppMethodBeat.o(85293);
            }
        });
        Activity jC = jC(webView.getContext());
        Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + jC);
        this.APZ = com.tencent.xweb.extension.video.e.a(jC, this.APS, this.ARZ, com.tencent.xweb.extension.video.d.dUq());
        if (getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS) {
            this.APZ.dh(this.ARZ);
        }
        AppMethodBeat.o(85299);
    }

    private static Activity jC(Context context) {
        AppMethodBeat.i(85300);
        while (true) {
            Context context2 = context;
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                AppMethodBeat.o(85300);
                return activity;
            } else if (context2 instanceof ContextWrapper) {
                context = ((ContextWrapper) context2).getBaseContext();
                if (context == context2) {
                    AppMethodBeat.o(85300);
                    return null;
                }
            } else {
                AppMethodBeat.o(85300);
                return null;
            }
        }
    }

    public final void setWebViewClient(s sVar) {
        AppMethodBeat.i(85301);
        if (sVar == null) {
            this.iuo = new s();
            this.iuo.AMp = this.ASk;
            AppMethodBeat.o(85301);
            return;
        }
        dVJ();
        this.iuo = sVar;
        AppMethodBeat.o(85301);
    }

    public final void setWebChromeClient(l lVar) {
        AppMethodBeat.i(85302);
        if (lVar == null) {
            this.iup = new l();
            AppMethodBeat.o(85302);
            return;
        }
        dVJ();
        this.iup = lVar;
        AppMethodBeat.o(85302);
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(85303);
        this.ARZ.setDownloadListener(new f.e(this.APS.getContext(), downloadListener));
        AppMethodBeat.o(85303);
    }

    public final void setFindListener(FindListener findListener) {
        AppMethodBeat.i(85304);
        this.ARZ.setFindListener(new f.f(findListener));
        AppMethodBeat.o(85304);
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(85305);
        if (str == null || !str.trim().startsWith("javascript:")) {
            this.ASl = false;
            this.ARZ.loadUrl(str);
            AppMethodBeat.o(85305);
            return;
        }
        this.ARZ.evaluateJavascript(str, null);
        AppMethodBeat.o(85305);
    }

    public final boolean canGoBack() {
        AppMethodBeat.i(85306);
        if (this.ASl || !this.ARZ.getNavigationHistory().canGoBack()) {
            AppMethodBeat.o(85306);
            return false;
        }
        AppMethodBeat.o(85306);
        return true;
    }

    public final void goBack() {
        AppMethodBeat.i(85307);
        if (this.ARZ.getNavigationHistory().canGoBack()) {
            this.ARZ.getNavigationHistory().navigate(Direction.BACKWARD, 1);
            if (!(this.ARZ.getNavigationHistory() == null || this.ARZ.getNavigationHistory().getCurrentItem() == null)) {
                this.iup.d(this.APS, this.ARZ.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
        AppMethodBeat.o(85307);
    }

    public final boolean hasEnteredFullscreen() {
        AppMethodBeat.i(85308);
        boolean hasEnteredFullscreen = this.ARZ.hasEnteredFullscreen();
        AppMethodBeat.o(85308);
        return hasEnteredFullscreen;
    }

    public final void leaveFullscreen() {
        AppMethodBeat.i(85309);
        this.ARZ.leaveFullscreen();
        AppMethodBeat.o(85309);
    }

    public final void clearView() {
    }

    public final void destroy() {
        AppMethodBeat.i(85310);
        this.ARZ.onDestroy();
        AppMethodBeat.o(85310);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(85311);
        this.ARZ.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(85311);
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.ASk;
    }

    public final void reload() {
        AppMethodBeat.i(85312);
        this.ARZ.reload(0);
        AppMethodBeat.o(85312);
    }

    public final void clearSslPreferences() {
        AppMethodBeat.i(85313);
        this.ARZ.clearSslPreferences();
        AppMethodBeat.o(85313);
    }

    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(85314);
        this.ARZ.loadData(str, str2, str3);
        AppMethodBeat.o(85314);
    }

    public final int getContentHeight() {
        AppMethodBeat.i(85315);
        int contentHeight = this.ARZ.getContentHeight();
        AppMethodBeat.o(85315);
        return contentHeight;
    }

    public final float getScale() {
        AppMethodBeat.i(85316);
        float scale = this.ARZ.getScale();
        AppMethodBeat.o(85316);
        return scale;
    }

    public final int getVisibleTitleHeight() {
        return 0;
    }

    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(85317);
        int scrollBarStyle = this.ARZ.getScrollBarStyle();
        if (scrollBarStyle == 0 || scrollBarStyle == 33554432) {
            AppMethodBeat.o(85317);
            return true;
        }
        AppMethodBeat.o(85317);
        return false;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(85318);
        this.ARZ.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(85318);
    }

    public final boolean zoomOut() {
        AppMethodBeat.i(85319);
        boolean zoomOut = this.ARZ.zoomOut();
        AppMethodBeat.o(85319);
        return zoomOut;
    }

    public final boolean zoomIn() {
        AppMethodBeat.i(85320);
        boolean zoomIn = this.ARZ.zoomIn();
        AppMethodBeat.o(85320);
        return zoomIn;
    }

    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(85321);
        this.ARZ.loadUrl(str, map);
        AppMethodBeat.o(85321);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(85322);
        this.ARZ.addJavascriptInterface(obj, str);
        AppMethodBeat.o(85322);
    }

    public final View getView() {
        return this.ARZ;
    }

    public final String getUrl() {
        AppMethodBeat.i(85323);
        String url = this.ARZ.getUrl();
        AppMethodBeat.o(85323);
        return url;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(85324);
        this.ARZ.removeJavascriptInterface(str);
        AppMethodBeat.o(85324);
    }

    public final void stopLoading() {
        AppMethodBeat.i(85325);
        this.ARZ.stopLoading();
        AppMethodBeat.o(85325);
    }

    public final void setWebViewCallbackClient(r rVar) {
        this.icr = rVar;
    }

    public final com.tencent.xweb.WebView.b getHitTestResult() {
        AppMethodBeat.i(85326);
        com.tencent.xweb.WebView.b bVar = new com.tencent.xweb.WebView.b();
        XWalkHitTestResult hitTestResult = this.ARZ.getHitTestResult();
        bVar.mType = hitTestResult.getType().ordinal();
        bVar.mExtra = hitTestResult.getExtra();
        AppMethodBeat.o(85326);
        return bVar;
    }

    public final String getTitle() {
        AppMethodBeat.i(85327);
        String title = this.ARZ.getTitle();
        AppMethodBeat.o(85327);
        return title;
    }

    public final p getSettings() {
        return this.ASi;
    }

    public final View getWebViewUI() {
        return this.ARZ;
    }

    public final ViewGroup getTopView() {
        return this.ASj;
    }

    public final void clearMatches() {
        AppMethodBeat.i(85328);
        this.ARZ.clearMatches();
        AppMethodBeat.o(85328);
    }

    public final void findNext(boolean z) {
        AppMethodBeat.i(85329);
        this.ARZ.findNext(z);
        AppMethodBeat.o(85329);
    }

    public final void findAllAsync(String str) {
        AppMethodBeat.i(85330);
        this.ARZ.findAllAsync(str);
        AppMethodBeat.o(85330);
    }

    public final String getVersionInfo() {
        AppMethodBeat.i(85331);
        String str = "webviewType = WV_KIND_CW,V8 type=" + com.tencent.xweb.i.dTV() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 190301";
        AppMethodBeat.o(85331);
        return str;
    }

    public final String getAbstractInfo() {
        AppMethodBeat.i(85332);
        String str = "webviewtype = xwalk, sdkver = 190301\n apkver = " + XWalkEnvironment.getAvailableVersion();
        AppMethodBeat.o(85332);
        return str;
    }

    public final boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.i(85333);
        boolean isSupportExtendPluginForAppbrand = this.ARZ.isSupportExtendPluginForAppbrand();
        AppMethodBeat.o(85333);
        return isSupportExtendPluginForAppbrand;
    }

    public final s getCurWebviewClient() {
        return this.iuo;
    }

    public final l getCurWebChromeClient() {
        return this.iup;
    }

    public final int getWebScrollY() {
        AppMethodBeat.i(85334);
        int computeVerticalScrollOffset = this.ARZ.computeVerticalScrollOffset();
        AppMethodBeat.o(85334);
        return computeVerticalScrollOffset;
    }

    public final int getWebScrollX() {
        AppMethodBeat.i(85335);
        View webViewUI = getWebViewUI();
        int computeHorizontalScrollOffset;
        if (webViewUI instanceof XWalkView) {
            computeHorizontalScrollOffset = ((XWalkView) webViewUI).computeHorizontalScrollOffset();
            AppMethodBeat.o(85335);
            return computeHorizontalScrollOffset;
        }
        computeHorizontalScrollOffset = webViewUI.getScrollX();
        AppMethodBeat.o(85335);
        return computeHorizontalScrollOffset;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
        this.ASn = bVar;
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_computeScroll() {
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public final void onResume() {
        AppMethodBeat.i(85337);
        this.ARZ.onResume();
        AppMethodBeat.o(85337);
    }

    public final void onPause() {
        AppMethodBeat.i(85338);
        this.ARZ.onPause();
        AppMethodBeat.o(85338);
    }

    public final com.tencent.xweb.WebView.a getFullscreenVideoKind() {
        AppMethodBeat.i(85339);
        com.tencent.xweb.WebView.a auW = com.tencent.xweb.a.auW(WebView.getCurStrModule());
        AppMethodBeat.o(85339);
        return auW;
    }

    public final void setJSExceptionListener(t tVar) {
        this.ASo = tVar;
    }

    public final boolean savePage(String str, String str2, int i) {
        AppMethodBeat.i(85340);
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            boolean savePage = ((XWalkView) webViewUI).savePage(str, str2, i);
            AppMethodBeat.o(85340);
            return savePage;
        }
        AppMethodBeat.o(85340);
        return false;
    }

    public final void eU(String str, int i) {
        AppMethodBeat.i(85341);
        if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
            try {
                Class cls = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
                if (cls == null) {
                    AppMethodBeat.o(85341);
                    return;
                }
                ReflectMethod reflectMethod = new ReflectMethod(cls, "setProfileConfig", Bundle.class);
                Bundle bundle = new Bundle();
                bundle.putString("enabledTraceCategory", str);
                bundle.putInt("traceSampleRatio", i);
                reflectMethod.invoke(bundle);
                AppMethodBeat.o(85341);
                return;
            } catch (Exception e) {
                Log.e("XWWebView", "setProfileConfig reflect failed");
            }
        }
        AppMethodBeat.o(85341);
    }

    public final void clearHistory() {
        AppMethodBeat.i(85342);
        if (this.ARZ.getNavigationHistory() != null) {
            this.ARZ.getNavigationHistory().clear();
        }
        AppMethodBeat.o(85342);
    }

    public final boolean canGoForward() {
        AppMethodBeat.i(85343);
        if (this.ARZ.getNavigationHistory() != null) {
            boolean canGoForward = this.ARZ.getNavigationHistory().canGoForward();
            AppMethodBeat.o(85343);
            return canGoForward;
        }
        AppMethodBeat.o(85343);
        return false;
    }

    public final boolean supportFeature(int i) {
        AppMethodBeat.i(85344);
        boolean hasFeature = XWalkCoreWrapper.getInstance().hasFeature(i);
        AppMethodBeat.o(85344);
        return hasFeature;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(85345);
        this.ARZ.setVerticalScrollBarEnable(z);
        AppMethodBeat.o(85345);
    }

    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(85346);
        this.ARZ.setHorizontalScrollBarEnable(z);
        AppMethodBeat.o(85346);
    }

    public final boolean isOverScrollStart() {
        int computeVerticalScrollOffset;
        AppMethodBeat.i(85336);
        boolean z = this.ASq;
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            computeVerticalScrollOffset = ((XWalkView) webViewUI).computeVerticalScrollOffset();
        } else {
            computeVerticalScrollOffset = webViewUI.getScrollY();
        }
        if (computeVerticalScrollOffset == 0 && z) {
            AppMethodBeat.o(85336);
            return true;
        }
        AppMethodBeat.o(85336);
        return false;
    }
}
