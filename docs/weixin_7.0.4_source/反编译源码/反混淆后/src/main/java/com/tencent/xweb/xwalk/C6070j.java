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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36589p;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C41128i;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.C6035t;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C41116b;
import com.tencent.xweb.WebView.C46827a;
import com.tencent.xweb.extension.video.C24528b;
import com.tencent.xweb.extension.video.C44584d;
import com.tencent.xweb.extension.video.C44589e;
import com.tencent.xweb.p1115c.C24524e;
import com.tencent.xweb.p1115c.C41119i;
import com.tencent.xweb.p1115c.C44579j;
import com.tencent.xweb.p1115c.C46832h;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.xwalk.C36614f.C245661;
import com.tencent.xweb.xwalk.C36614f.C24567d;
import com.tencent.xweb.xwalk.C36614f.C24568f;
import com.tencent.xweb.xwalk.C36614f.C36611b;
import com.tencent.xweb.xwalk.C36614f.C36612e;
import com.tencent.xweb.xwalk.C36614f.C36613h;
import com.tencent.xweb.xwalk.C36614f.C36615a;
import com.tencent.xweb.xwalk.C36614f.C36616c;
import com.tencent.xweb.xwalk.C36614f.C6068g;
import com.tencent.xweb.xwalk.p687b.C36608e;
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

/* renamed from: com.tencent.xweb.xwalk.j */
public final class C6070j implements C46832h, C41119i {
    static int ASp = 0;
    WebView APS;
    long APY = 0;
    private C24528b APZ;
    C31537l ARX;
    C24570m ARY;
    XWalkView ARZ;
    C24569k ASi;
    AbsoluteLayout ASj;
    C36617g ASk;
    boolean ASl = false;
    private String ASm = null;
    private C16404b ASn = new C16404b();
    private C6035t ASo = null;
    private boolean ASq = false;
    C36591r icr;
    C36592s iuo = new C36592s();
    C6031l iup = new C6031l();
    int mApkVersion = XWalkEnvironment.getAvailableVersion();
    private int type = 0;

    /* renamed from: com.tencent.xweb.xwalk.j$3 */
    class C60693 extends XWalkProxyWebViewClientExtension {
        C60693() {
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.m2504i(85290);
            if (C6070j.this.ASn != null) {
                Object onMiscCallBack = C6070j.this.ASn.onMiscCallBack(str, bundle);
                AppMethodBeat.m2505o(85290);
                return onMiscCallBack;
            }
            AppMethodBeat.m2505o(85290);
            return null;
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.j$4 */
    class C60744 implements ScrollChangedListener {
        C60744() {
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(85291);
            C6070j.this.ASj.scrollTo(i, i2);
            if (C6070j.this.icr != null) {
                C6070j.this.icr.onScrollChanged(i, i2, i3, i4, C6070j.this.ARZ);
            }
            AppMethodBeat.m2505o(85291);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.j$6 */
    class C60756 extends XWalkLogMessageListener {
        C60756() {
        }

        public final void onLogMessage(int i, String str, int i2, String str2) {
            AppMethodBeat.m2504i(85293);
            Log.m81049i("XWWebView", "[WCWebview] :".concat(String.valueOf(str2)));
            AppMethodBeat.m2505o(85293);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.j$a */
    class C6076a extends XWalkView {
        public C6076a(Context context) {
            super(context);
        }

        public final void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(85294);
            super.onScrollChangedDelegate(i, i2, i3, i4);
            if (C6070j.this.APS != null) {
                C6070j.this.APS.onWebViewScrollChanged(i, i2, i3, i4);
            }
            AppMethodBeat.m2505o(85294);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.j$b */
    public static class C6077b {
        public String ASA;
        public String ASB;
        public int ASw;
        public int ASx;
        public int ASy;
        public int ASz;
        public String wYV;
        public String wYW;
        public String wYX;

        /* renamed from: b */
        public static C6077b m9548b(String str, String str2, int i, int i2, String str3, String str4) {
            String stringBuffer;
            Object obj;
            String str5;
            int i3;
            int i4;
            Object obj2 = 1;
            AppMethodBeat.m2504i(85295);
            C6077b c6077b = new C6077b();
            c6077b.wYV = str;
            c6077b.ASB = str2;
            c6077b.ASw = i;
            c6077b.ASy = i2;
            c6077b.wYW = str3;
            c6077b.wYX = str4;
            if (i > 0) {
                try {
                    stringBuffer = new StringBuffer(str3).reverse().toString();
                    obj = null;
                } catch (Exception e) {
                    Log.m81046e("XWWebView", "SelectInfo getSelectInfo error:" + e.getMessage());
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
                Log.m81046e("XWWebView", "getSelectInfo error prefixIndex:" + i5 + ",suffixIndex:" + i3);
                i3 = 0;
                i4 = 0;
            } else {
                i4 = i5;
            }
            c6077b.ASx = i4;
            c6077b.ASz = i3;
            c6077b.ASA = (str3 + str + str4).substring(str3.length() - i4, i3 + (str3.length() + str.length()));
            AppMethodBeat.m2505o(85295);
            return c6077b;
        }

        public final String toString() {
            AppMethodBeat.m2504i(85296);
            String str;
            try {
                str = "SelectInfo PickedWord:" + this.wYV + ",PrefixText:" + this.wYW + ",SuffixText:" + this.wYX + ",PrefixOffset:" + this.ASw + ",prefixIndex:" + this.ASx + ",SuffixOffset:" + this.ASy + ",SuffixIndex:" + this.ASz + ",ResultPickedWord:" + this.ASB + ",OffsetedPickedWord:" + this.ASA;
                AppMethodBeat.m2505o(85296);
                return str;
            } catch (Exception e) {
                str = "SelectInfo toString error";
                AppMethodBeat.m2505o(85296);
                return str;
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.j$5 */
    class C60785 implements OverScrolledListener {
        C60785() {
        }

        public final void onOverScrolled(boolean z) {
            AppMethodBeat.m2504i(85292);
            if (z) {
                C6070j.this.ASq = true;
                AppMethodBeat.m2505o(85292);
                return;
            }
            C6070j.this.ASq = false;
            AppMethodBeat.m2505o(85292);
        }
    }

    /* renamed from: fE */
    public static synchronized boolean m9545fE(Context context) {
        boolean isXWalkReady;
        synchronized (C6070j.class) {
            AppMethodBeat.m2504i(85297);
            C36608e.m60705jF(context);
            isXWalkReady = C36608e.isXWalkReady();
            AppMethodBeat.m2505o(85297);
        }
        return isXWalkReady;
    }

    private void dVJ() {
        AppMethodBeat.m2504i(85298);
        if (this.ARX != null) {
            AppMethodBeat.m2505o(85298);
            return;
        }
        this.ARX = new C31537l(this.ARZ) {
            String ASr = null;

            public final void onPageLoadStarted(XWalkView xWalkView, String str) {
                AppMethodBeat.m2504i(85248);
                Log.m81049i("XWWebView", "onPageLoadStarted: url = ".concat(String.valueOf(str)));
                C6070j.this.iuo.mo7562b(C6070j.this.APS, str, C6070j.this.ARZ.getFavicon());
                C44579j.dUB().dUx();
                this.ASr = null;
                if (!(C6070j.this.ASm == null || str == null || str.equals(C6070j.this.ASm) || C24532f.avq(str) == C24532f.avq(C6070j.this.ASm))) {
                    if (C24532f.avq(C6070j.this.ASm) == 1 && C24532f.avq(str) == 2) {
                        C6070j.this.type = 1;
                    } else if (C24532f.avq(C6070j.this.ASm) == 2 && C24532f.avq(str) == 1) {
                        C6070j.this.type = 2;
                    }
                }
                C6070j.this.ASm = str;
                C6070j.this.APY = System.currentTimeMillis();
                if (str == null) {
                    str = "";
                }
                C24532f.m38173eV(str, C6070j.this.type);
                if (C6070j.this.APZ != null) {
                    C6070j.this.APZ.mo30114am(true, C6070j.this.APS.getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS);
                }
                AppMethodBeat.m2505o(85248);
            }

            public final void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
                AppMethodBeat.m2504i(85249);
                if (this.ASr == null || !this.ASr.equals(str)) {
                    if (C6070j.this.APZ != null) {
                        C6070j.this.APZ.mo30114am(false, C6070j.this.APS.getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS);
                    }
                    this.ASr = str;
                    Log.m81049i("XWWebView", "onPageFinished: url = " + str + " status = " + loadStatus);
                    C6070j.this.iuo.mo5992b(C6070j.this.APS, str);
                    if (loadStatus != LoadStatus.FAILED) {
                        C44579j.dUB().dUy();
                    }
                    C24532f.m38189q(str, System.currentTimeMillis() - C6070j.this.APY, C6070j.this.type);
                    C6070j.this.APY = System.currentTimeMillis();
                    AppMethodBeat.m2505o(85249);
                    return;
                }
                Log.m81049i("XWWebView", "abandoned onPageFinished: url = " + str + " status = " + loadStatus);
                AppMethodBeat.m2505o(85249);
            }

            public final void onReceivedTitle(XWalkView xWalkView, String str) {
                AppMethodBeat.m2504i(85250);
                Log.m81049i("XWWebView", "onReceivedTitle: ".concat(String.valueOf(str)));
                super.onReceivedTitle(xWalkView, str);
                C6070j.this.iup.mo7557d(null, str);
                if (C6070j.this.APZ != null) {
                    C6070j.this.APZ.mo30114am(true, C6070j.this.APS.getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS);
                }
                AppMethodBeat.m2505o(85250);
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                AppMethodBeat.m2504i(85251);
                Log.m81049i("XWWebView", "onShowCustomView:".concat(String.valueOf(view)));
                C6070j.this.iup.aJY();
                C24532f.dUS();
                C6070j.this.ASj.setVisibility(4);
                if (C6070j.this.APZ != null) {
                    C6070j.this.APZ.onShowCustomView(view, new C36615a(customViewCallback));
                }
                AppMethodBeat.m2505o(85251);
            }

            public final void onHideCustomView() {
                AppMethodBeat.m2504i(85252);
                Log.m81049i("XWWebView", "onHideCustomView");
                C6070j.this.iup.aDI();
                C6070j.this.ASj.setVisibility(0);
                if (C6070j.this.APZ != null) {
                    C6070j.this.APZ.onHideCustomView();
                }
                AppMethodBeat.m2505o(85252);
            }

            public final View getVideoLoadingProgressView() {
                AppMethodBeat.m2504i(85253);
                Log.m81049i("XWWebView", "getVideoLoadingProgressView");
                View inflate = LayoutInflater.from(C6070j.this.APS.getContext()).inflate(2130970993, null);
                AppMethodBeat.m2505o(85253);
                return inflate;
            }

            public final boolean onSelectInfoChanged(XWalkView xWalkView, long j, String str, String str2, String str3) {
                AppMethodBeat.m2504i(85254);
                if (isSearchable()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("PickedWord", str);
                    bundle.putString("PrefixText", str2);
                    bundle.putString("SuffixText", str3);
                    Object onMiscCallBack = C6070j.this.ASn.onMiscCallBack("smartPickWord", bundle);
                    if (onMiscCallBack instanceof Bundle) {
                        Bundle bundle2 = (Bundle) onMiscCallBack;
                        if (!(bundle2 == null || bundle2.getString("PickedWord") == null)) {
                            int i = bundle2.getInt("PrefixOffset");
                            int i2 = bundle2.getInt("SuffixOffset");
                            C6077b b = C6077b.m9548b(str, bundle2.getString("PickedWord"), i, i2, str2, str3);
                            Log.m81045d("XWWebView", "onSelectInfoChanged " + b.toString());
                            xWalkView.adjustSelectPosition(j, bundle2.getString("PickedWord"), -b.ASx, b.ASz);
                        }
                        AppMethodBeat.m2505o(85254);
                        return true;
                    }
                    AppMethodBeat.m2505o(85254);
                    return false;
                }
                AppMethodBeat.m2505o(85254);
                return false;
            }

            public final void onShowSos() {
                AppMethodBeat.m2504i(85255);
                C6070j.this.ASn.onMiscCallBack("onShowSos", new Bundle());
                AppMethodBeat.m2505o(85255);
            }

            public final boolean isSearchable() {
                AppMethodBeat.m2504i(85256);
                Object onMiscCallBack = C6070j.this.ASn.onMiscCallBack("supportSmartPickWord", new Bundle());
                if (onMiscCallBack instanceof Boolean) {
                    boolean booleanValue = ((Boolean) onMiscCallBack).booleanValue();
                    AppMethodBeat.m2505o(85256);
                    return booleanValue;
                }
                AppMethodBeat.m2505o(85256);
                return false;
            }

            public final boolean onSearchWord(XWalkView xWalkView, String str, String str2, String str3) {
                AppMethodBeat.m2504i(85257);
                if (isSearchable()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(SearchIntents.EXTRA_QUERY, str);
                    C6070j.this.ASn.onMiscCallBack("jumpToSos", bundle);
                    C6070j.this.ARZ.getUrl();
                    C6070j.this.ARZ.getRefererUrl();
                    C6070j.this.ARZ.getTitle();
                    AppMethodBeat.m2505o(85257);
                    return true;
                }
                AppMethodBeat.m2505o(85257);
                return false;
            }

            public final boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.m2504i(85258);
                Log.m81049i("XWWebView", "onJsAlert");
                boolean a = C6070j.this.iup.mo13207a(C6070j.this.APS, str, str2, new C36616c(xWalkJavascriptResult));
                AppMethodBeat.m2505o(85258);
                return a;
            }

            public final boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.m2504i(85259);
                Log.m81049i("XWWebView", "onJsConfirm");
                boolean b = C6070j.this.iup.mo13211b(C6070j.this.APS, str, str2, new C36616c(xWalkJavascriptResult));
                AppMethodBeat.m2505o(85259);
                return b;
            }

            public final boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.m2504i(85260);
                Log.m81049i("XWWebView", "onJsPrompt");
                boolean a = C6070j.this.iup.mo13208a(C6070j.this.APS, str, str2, str3, new C24567d(xWalkJavascriptResult));
                AppMethodBeat.m2505o(85260);
                return a;
            }

            public final void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
                AppMethodBeat.m2504i(85261);
                C6070j.this.iup.onGeolocationPermissionsShowPrompt(str, new C36611b(xWalkGeolocationPermissionsCallback));
                AppMethodBeat.m2505o(85261);
            }

            public final void onGeolocationPermissionsHidePrompt() {
            }

            public final boolean onConsoleMessage(XWalkView xWalkView, String str, int i, String str2, ConsoleMessageType consoleMessageType) {
                AppMethodBeat.m2504i(85262);
                if (ConsoleMessageType.ERROR == consoleMessageType && C6070j.this.ASo != null && str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).length == 2) {
                    C6070j.this.ASo;
                    C24532f.dVa();
                }
                C6031l c6031l = C6070j.this.iup;
                MessageLevel messageLevel = MessageLevel.DEBUG;
                switch (C245661.ARS[consoleMessageType.ordinal()]) {
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
                boolean onConsoleMessage = c6031l.onConsoleMessage(new ConsoleMessage(str, str2, i, messageLevel));
                AppMethodBeat.m2505o(85262);
                return onConsoleMessage;
            }

            public final void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
                AppMethodBeat.m2504i(85263);
                Log.m81049i("XWWebView", "openFileChooser with three param");
                C6070j.this.iup.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.m2505o(85263);
            }

            public final boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
                AppMethodBeat.m2504i(85264);
                boolean onCreateWindowRequested = super.onCreateWindowRequested(xWalkView, initiateBy, valueCallback);
                AppMethodBeat.m2505o(85264);
                return onCreateWindowRequested;
            }

            public final void onIconAvailable(XWalkView xWalkView, String str, Message message) {
                AppMethodBeat.m2504i(85265);
                super.onIconAvailable(xWalkView, str, message);
                AppMethodBeat.m2505o(85265);
            }

            public final void onDidChangeThemeColor(XWalkView xWalkView, int i) {
            }

            public final void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
                AppMethodBeat.m2504i(85266);
                super.onReceivedIcon(xWalkView, str, bitmap);
                AppMethodBeat.m2505o(85266);
            }

            public final void onRequestFocus(XWalkView xWalkView) {
                AppMethodBeat.m2504i(85267);
                super.onRequestFocus(xWalkView);
                AppMethodBeat.m2505o(85267);
            }

            public final void onJavascriptCloseWindow(XWalkView xWalkView) {
                AppMethodBeat.m2504i(85268);
                super.onJavascriptCloseWindow(xWalkView);
                AppMethodBeat.m2505o(85268);
            }

            public final boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.m2504i(85269);
                boolean onJavascriptModalDialog = super.onJavascriptModalDialog(xWalkView, javascriptMessageType, str, str2, str3, xWalkJavascriptResult);
                AppMethodBeat.m2505o(85269);
                return onJavascriptModalDialog;
            }

            public final void onFullscreenToggled(XWalkView xWalkView, boolean z) {
                AppMethodBeat.m2504i(85270);
                super.onFullscreenToggled(xWalkView, z);
                AppMethodBeat.m2505o(85270);
            }

            public final void onScaleChanged(XWalkView xWalkView, float f, float f2) {
                AppMethodBeat.m2504i(85271);
                C6070j.this.iuo.mo37025a(C6070j.this.APS, f, f2);
                AppMethodBeat.m2505o(85271);
            }

            public final boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                AppMethodBeat.m2504i(85272);
                boolean shouldOverrideKeyEvent = super.shouldOverrideKeyEvent(xWalkView, keyEvent);
                AppMethodBeat.m2505o(85272);
                return shouldOverrideKeyEvent;
            }

            public final void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                AppMethodBeat.m2504i(85273);
                super.onUnhandledKeyEvent(xWalkView, keyEvent);
                AppMethodBeat.m2505o(85273);
            }

            public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
                AppMethodBeat.m2504i(85274);
                super.onShowCustomView(view, i, customViewCallback);
                AppMethodBeat.m2505o(85274);
            }

            public final boolean shouldDiscardCurrentPage() {
                AppMethodBeat.m2504i(85275);
                boolean shouldDiscardCurrentPage;
                if (C6070j.this.ASn != null) {
                    shouldDiscardCurrentPage = C6070j.this.ASn.shouldDiscardCurrentPage();
                    AppMethodBeat.m2505o(85275);
                    return shouldDiscardCurrentPage;
                }
                shouldDiscardCurrentPage = super.shouldDiscardCurrentPage();
                AppMethodBeat.m2505o(85275);
                return shouldDiscardCurrentPage;
            }

            public final void onClearCurrentPage() {
                AppMethodBeat.m2504i(85276);
                if (C6070j.this.ASn != null) {
                    C6070j.this.ASn.hasDiscardCurrentPage(true);
                }
                AppMethodBeat.m2505o(85276);
            }
        };
        this.ASk.ARX = this.ARX;
        this.ARZ.setUIClient(this.ARX);
        this.ARY = new C24570m(this.ARZ) {
            int ASt = 0;

            public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
                AppMethodBeat.m2504i(85278);
                boolean a = C6070j.this.iuo.mo4762a(C6070j.this.APS, str);
                Log.m81049i("XWWebView", "shouldOverrideUrlLoading ret =  " + a + " url = " + str);
                AppMethodBeat.m2505o(85278);
                return a;
            }

            public final void onLoadStarted(XWalkView xWalkView, String str) {
                AppMethodBeat.m2504i(85279);
                C6070j.this.iuo.mo7563h(C6070j.this.APS, str);
                AppMethodBeat.m2505o(85279);
            }

            public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
                Bundle bundle;
                C31147o a;
                C31147o c;
                AppMethodBeat.m2504i(85280);
                C24530n c36613h = new C36613h(xWalkWebResourceRequest);
                if (c36613h.APN == null) {
                    bundle = null;
                } else {
                    bundle = c36613h.APN.getBundle();
                }
                if (bundle != null) {
                    a = C6070j.this.iuo.mo5991a(C6070j.this.APS, c36613h, bundle);
                } else {
                    a = null;
                }
                if (a == null) {
                    a = C6070j.this.iuo.mo5990a(C6070j.this.APS, c36613h);
                }
                if (a == null) {
                    c = C6070j.this.iuo.mo5993c(C6070j.this.APS, xWalkWebResourceRequest.getUrl().toString());
                } else {
                    c = a;
                }
                if (c != null) {
                    XWalkWebResourceResponse createXWalkWebResourceResponse = createXWalkWebResourceResponse(c.mMimeType, c.mEncoding, c.mInputStream, c.mStatusCode, c.mReasonPhrase, c.mResponseHeaders);
                    AppMethodBeat.m2505o(85280);
                    return createXWalkWebResourceResponse;
                }
                AppMethodBeat.m2505o(85280);
                return null;
            }

            public final void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
                AppMethodBeat.m2504i(85281);
                Log.m81049i("XWWebView", "onReceivedError ".concat(String.valueOf(str2)));
                super.onReceivedLoadError(xWalkView, i, str, str2);
                C6070j.this.ASl = true;
                C6070j.this.iuo.mo7559a(C6070j.this.APS, i, str, str2);
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
                C6070j.this.ARZ.loadDataWithBaseURL("file:///android_asset/", stringBuilder.toString(), "text/html", ProtocolPackage.ServerEncoding, null);
                C44579j.dUB().dUC();
                C24532f.m38171b(str2, i, System.currentTimeMillis() - C6070j.this.APY, C6070j.this.type);
                AppMethodBeat.m2505o(85281);
            }

            public final void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
                AppMethodBeat.m2504i(85282);
                Log.m81049i("XWWebView", "onReceivedSslError " + sslError.getPrimaryError());
                C6070j.this.iuo.mo7560a(C6070j.this.APS, new C6068g(valueCallback), sslError);
                AppMethodBeat.m2505o(85282);
            }

            public final void onProgressChanged(XWalkView xWalkView, int i) {
                AppMethodBeat.m2504i(85283);
                if (Math.abs(i - this.ASt) > 5 || i == 100) {
                    this.ASt = i;
                    Log.m81049i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(i)));
                }
                C6070j.this.iup.mo13205a(C6070j.this.APS, i);
                AppMethodBeat.m2505o(85283);
            }

            public final void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
                AppMethodBeat.m2504i(85284);
                super.onDocumentLoadedInFrame(xWalkView, j);
                AppMethodBeat.m2505o(85284);
            }

            public final void onLoadFinished(XWalkView xWalkView, String str) {
                AppMethodBeat.m2504i(85285);
                super.onLoadFinished(xWalkView, str);
                AppMethodBeat.m2505o(85285);
            }

            public final void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
                AppMethodBeat.m2504i(85286);
                super.onReceivedClientCertRequest(xWalkView, clientCertRequest);
                AppMethodBeat.m2505o(85286);
            }

            public final void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
                AppMethodBeat.m2504i(85287);
                if (xWalkWebResourceResponse.getStatusCode() == 302) {
                    String str = (String) xWalkWebResourceResponse.getResponseHeaders().get(C8741b.LOCATION);
                    if (str == null || str.isEmpty()) {
                        str = (String) xWalkWebResourceResponse.getResponseHeaders().get("Location");
                    }
                    if (str != null && str.trim().startsWith("weixin://")) {
                        C6070j.this.iuo.mo7562b(C6070j.this.APS, str, null);
                        C6070j.this.ARZ.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(85277);
                                C6070j.this.iuo.mo7562b(C6070j.this.APS, str, null);
                                AppMethodBeat.m2505o(85277);
                            }
                        }, 300);
                    }
                } else if (xWalkWebResourceResponse.getStatusCode() >= 400) {
                    C31147o c31147o;
                    Log.m81049i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
                    C36592s c36592s = C6070j.this.iuo;
                    WebView webView = C6070j.this.APS;
                    C24530n c36613h = new C36613h(xWalkWebResourceRequest);
                    if (xWalkWebResourceResponse == null) {
                        c31147o = null;
                    } else {
                        c31147o = new C31147o(xWalkWebResourceResponse.getMimeType(), xWalkWebResourceResponse.getEncoding(), xWalkWebResourceResponse.getStatusCode(), xWalkWebResourceResponse.getReasonPhrase(), xWalkWebResourceResponse.getResponseHeaders(), xWalkWebResourceResponse.getData());
                    }
                    c36592s.mo7561a(webView, c36613h, c31147o);
                    C6070j.this.iuo.mo7559a(C6070j.this.APS, xWalkWebResourceResponse.getStatusCode(), "", xWalkWebResourceRequest.getUrl() != null ? xWalkWebResourceRequest.getUrl().toString() : "");
                }
                super.onReceivedResponseHeaders(xWalkView, xWalkWebResourceRequest, xWalkWebResourceResponse);
                AppMethodBeat.m2505o(85287);
            }

            public final void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
                AppMethodBeat.m2504i(85288);
                if (str == null || !str.startsWith("data:text/html;charset=utf-8")) {
                    C6070j.this.iuo.mo26819a(C6070j.this.APS, str, z);
                    AppMethodBeat.m2505o(85288);
                    return;
                }
                AppMethodBeat.m2505o(85288);
            }

            public final void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
                AppMethodBeat.m2504i(85289);
                super.onReceivedHttpAuthRequest(xWalkView, xWalkHttpAuthHandler, str, str2);
                AppMethodBeat.m2505o(85289);
            }
        };
        this.ASk.ARY = this.ARY;
        this.ARZ.setResourceClient(this.ARY);
        this.ARZ.setProxyWebViewClientExtension(new C60693());
        AppMethodBeat.m2505o(85298);
    }

    public C6070j(WebView webView) {
        AppMethodBeat.m2504i(85299);
        XWalkContextWrapper xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), this.mApkVersion);
        XWalkLibraryLoader.prepareToInit(xWalkContextWrapper);
        try {
            XWalkPreferences.setValue(XWalkPreferences.XWEB_VERSION, String.valueOf(this.mApkVersion));
            XWalkPreferences.setValue(XWalkPreferences.XWEBSDK_VERSION, "190301");
        } catch (Exception e) {
            Log.m81046e("XWWebView", e.getMessage());
        }
        this.ARZ = new C6076a(xWalkContextWrapper);
        this.ARZ.setBackgroundColor(0);
        this.ASj = new AbsoluteLayout(xWalkContextWrapper);
        this.ARZ.getXWalkContentView().addView(this.ASj);
        this.ARZ.setCustomOnScrollChangedListener(new C60744());
        this.ARZ.setCustomOnOverScrolledListener(new C60785());
        this.ASk = new C36617g(this.ARZ);
        this.APS = webView;
        this.ASi = new C24569k(this.ARZ);
        this.ARZ.getSettings().SetLogCallBack(new C60756());
        Activity jC = C6070j.m9546jC(webView.getContext());
        Log.m81049i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + jC);
        this.APZ = C44589e.m81001a(jC, this.APS, this.ARZ, C44584d.dUq());
        if (getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS) {
            this.APZ.mo30115dh(this.ARZ);
        }
        AppMethodBeat.m2505o(85299);
    }

    /* renamed from: jC */
    private static Activity m9546jC(Context context) {
        AppMethodBeat.m2504i(85300);
        while (true) {
            Context context2 = context;
            if (context2 instanceof Activity) {
                Activity activity = (Activity) context2;
                AppMethodBeat.m2505o(85300);
                return activity;
            } else if (context2 instanceof ContextWrapper) {
                context = ((ContextWrapper) context2).getBaseContext();
                if (context == context2) {
                    AppMethodBeat.m2505o(85300);
                    return null;
                }
            } else {
                AppMethodBeat.m2505o(85300);
                return null;
            }
        }
    }

    public final void setWebViewClient(C36592s c36592s) {
        AppMethodBeat.m2504i(85301);
        if (c36592s == null) {
            this.iuo = new C36592s();
            this.iuo.AMp = this.ASk;
            AppMethodBeat.m2505o(85301);
            return;
        }
        dVJ();
        this.iuo = c36592s;
        AppMethodBeat.m2505o(85301);
    }

    public final void setWebChromeClient(C6031l c6031l) {
        AppMethodBeat.m2504i(85302);
        if (c6031l == null) {
            this.iup = new C6031l();
            AppMethodBeat.m2505o(85302);
            return;
        }
        dVJ();
        this.iup = c6031l;
        AppMethodBeat.m2505o(85302);
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.m2504i(85303);
        this.ARZ.setDownloadListener(new C36612e(this.APS.getContext(), downloadListener));
        AppMethodBeat.m2505o(85303);
    }

    public final void setFindListener(FindListener findListener) {
        AppMethodBeat.m2504i(85304);
        this.ARZ.setFindListener(new C24568f(findListener));
        AppMethodBeat.m2505o(85304);
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(85305);
        if (str == null || !str.trim().startsWith("javascript:")) {
            this.ASl = false;
            this.ARZ.loadUrl(str);
            AppMethodBeat.m2505o(85305);
            return;
        }
        this.ARZ.evaluateJavascript(str, null);
        AppMethodBeat.m2505o(85305);
    }

    public final boolean canGoBack() {
        AppMethodBeat.m2504i(85306);
        if (this.ASl || !this.ARZ.getNavigationHistory().canGoBack()) {
            AppMethodBeat.m2505o(85306);
            return false;
        }
        AppMethodBeat.m2505o(85306);
        return true;
    }

    public final void goBack() {
        AppMethodBeat.m2504i(85307);
        if (this.ARZ.getNavigationHistory().canGoBack()) {
            this.ARZ.getNavigationHistory().navigate(Direction.BACKWARD, 1);
            if (!(this.ARZ.getNavigationHistory() == null || this.ARZ.getNavigationHistory().getCurrentItem() == null)) {
                this.iup.mo7557d(this.APS, this.ARZ.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
        AppMethodBeat.m2505o(85307);
    }

    public final boolean hasEnteredFullscreen() {
        AppMethodBeat.m2504i(85308);
        boolean hasEnteredFullscreen = this.ARZ.hasEnteredFullscreen();
        AppMethodBeat.m2505o(85308);
        return hasEnteredFullscreen;
    }

    public final void leaveFullscreen() {
        AppMethodBeat.m2504i(85309);
        this.ARZ.leaveFullscreen();
        AppMethodBeat.m2505o(85309);
    }

    public final void clearView() {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(85310);
        this.ARZ.onDestroy();
        AppMethodBeat.m2505o(85310);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(85311);
        this.ARZ.evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(85311);
    }

    public final C24524e getDefalutOpProvider() {
        return this.ASk;
    }

    public final void reload() {
        AppMethodBeat.m2504i(85312);
        this.ARZ.reload(0);
        AppMethodBeat.m2505o(85312);
    }

    public final void clearSslPreferences() {
        AppMethodBeat.m2504i(85313);
        this.ARZ.clearSslPreferences();
        AppMethodBeat.m2505o(85313);
    }

    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(85314);
        this.ARZ.loadData(str, str2, str3);
        AppMethodBeat.m2505o(85314);
    }

    public final int getContentHeight() {
        AppMethodBeat.m2504i(85315);
        int contentHeight = this.ARZ.getContentHeight();
        AppMethodBeat.m2505o(85315);
        return contentHeight;
    }

    public final float getScale() {
        AppMethodBeat.m2504i(85316);
        float scale = this.ARZ.getScale();
        AppMethodBeat.m2505o(85316);
        return scale;
    }

    public final int getVisibleTitleHeight() {
        return 0;
    }

    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.m2504i(85317);
        int scrollBarStyle = this.ARZ.getScrollBarStyle();
        if (scrollBarStyle == 0 || scrollBarStyle == 33554432) {
            AppMethodBeat.m2505o(85317);
            return true;
        }
        AppMethodBeat.m2505o(85317);
        return false;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(85318);
        this.ARZ.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(85318);
    }

    public final boolean zoomOut() {
        AppMethodBeat.m2504i(85319);
        boolean zoomOut = this.ARZ.zoomOut();
        AppMethodBeat.m2505o(85319);
        return zoomOut;
    }

    public final boolean zoomIn() {
        AppMethodBeat.m2504i(85320);
        boolean zoomIn = this.ARZ.zoomIn();
        AppMethodBeat.m2505o(85320);
        return zoomIn;
    }

    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(85321);
        this.ARZ.loadUrl(str, map);
        AppMethodBeat.m2505o(85321);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(85322);
        this.ARZ.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(85322);
    }

    public final View getView() {
        return this.ARZ;
    }

    public final String getUrl() {
        AppMethodBeat.m2504i(85323);
        String url = this.ARZ.getUrl();
        AppMethodBeat.m2505o(85323);
        return url;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(85324);
        this.ARZ.removeJavascriptInterface(str);
        AppMethodBeat.m2505o(85324);
    }

    public final void stopLoading() {
        AppMethodBeat.m2504i(85325);
        this.ARZ.stopLoading();
        AppMethodBeat.m2505o(85325);
    }

    public final void setWebViewCallbackClient(C36591r c36591r) {
        this.icr = c36591r;
    }

    public final C41116b getHitTestResult() {
        AppMethodBeat.m2504i(85326);
        C41116b c41116b = new C41116b();
        XWalkHitTestResult hitTestResult = this.ARZ.getHitTestResult();
        c41116b.mType = hitTestResult.getType().ordinal();
        c41116b.mExtra = hitTestResult.getExtra();
        AppMethodBeat.m2505o(85326);
        return c41116b;
    }

    public final String getTitle() {
        AppMethodBeat.m2504i(85327);
        String title = this.ARZ.getTitle();
        AppMethodBeat.m2505o(85327);
        return title;
    }

    public final C36589p getSettings() {
        return this.ASi;
    }

    public final View getWebViewUI() {
        return this.ARZ;
    }

    public final ViewGroup getTopView() {
        return this.ASj;
    }

    public final void clearMatches() {
        AppMethodBeat.m2504i(85328);
        this.ARZ.clearMatches();
        AppMethodBeat.m2505o(85328);
    }

    public final void findNext(boolean z) {
        AppMethodBeat.m2504i(85329);
        this.ARZ.findNext(z);
        AppMethodBeat.m2505o(85329);
    }

    public final void findAllAsync(String str) {
        AppMethodBeat.m2504i(85330);
        this.ARZ.findAllAsync(str);
        AppMethodBeat.m2505o(85330);
    }

    public final String getVersionInfo() {
        AppMethodBeat.m2504i(85331);
        String str = "webviewType = WV_KIND_CW,V8 type=" + C41128i.dTV() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 190301";
        AppMethodBeat.m2505o(85331);
        return str;
    }

    public final String getAbstractInfo() {
        AppMethodBeat.m2504i(85332);
        String str = "webviewtype = xwalk, sdkver = 190301\n apkver = " + XWalkEnvironment.getAvailableVersion();
        AppMethodBeat.m2505o(85332);
        return str;
    }

    public final boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.m2504i(85333);
        boolean isSupportExtendPluginForAppbrand = this.ARZ.isSupportExtendPluginForAppbrand();
        AppMethodBeat.m2505o(85333);
        return isSupportExtendPluginForAppbrand;
    }

    public final C36592s getCurWebviewClient() {
        return this.iuo;
    }

    public final C6031l getCurWebChromeClient() {
        return this.iup;
    }

    public final int getWebScrollY() {
        AppMethodBeat.m2504i(85334);
        int computeVerticalScrollOffset = this.ARZ.computeVerticalScrollOffset();
        AppMethodBeat.m2505o(85334);
        return computeVerticalScrollOffset;
    }

    public final int getWebScrollX() {
        AppMethodBeat.m2504i(85335);
        View webViewUI = getWebViewUI();
        int computeHorizontalScrollOffset;
        if (webViewUI instanceof XWalkView) {
            computeHorizontalScrollOffset = ((XWalkView) webViewUI).computeHorizontalScrollOffset();
            AppMethodBeat.m2505o(85335);
            return computeHorizontalScrollOffset;
        }
        computeHorizontalScrollOffset = webViewUI.getScrollX();
        AppMethodBeat.m2505o(85335);
        return computeHorizontalScrollOffset;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(C16404b c16404b) {
        this.ASn = c16404b;
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
        AppMethodBeat.m2504i(85337);
        this.ARZ.onResume();
        AppMethodBeat.m2505o(85337);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(85338);
        this.ARZ.onPause();
        AppMethodBeat.m2505o(85338);
    }

    public final C46827a getFullscreenVideoKind() {
        AppMethodBeat.m2504i(85339);
        C46827a auW = C44572a.auW(WebView.getCurStrModule());
        AppMethodBeat.m2505o(85339);
        return auW;
    }

    public final void setJSExceptionListener(C6035t c6035t) {
        this.ASo = c6035t;
    }

    public final boolean savePage(String str, String str2, int i) {
        AppMethodBeat.m2504i(85340);
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            boolean savePage = ((XWalkView) webViewUI).savePage(str, str2, i);
            AppMethodBeat.m2505o(85340);
            return savePage;
        }
        AppMethodBeat.m2505o(85340);
        return false;
    }

    /* renamed from: eU */
    public final void mo13359eU(String str, int i) {
        AppMethodBeat.m2504i(85341);
        if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
            try {
                Class cls = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
                if (cls == null) {
                    AppMethodBeat.m2505o(85341);
                    return;
                }
                ReflectMethod reflectMethod = new ReflectMethod(cls, "setProfileConfig", Bundle.class);
                Bundle bundle = new Bundle();
                bundle.putString("enabledTraceCategory", str);
                bundle.putInt("traceSampleRatio", i);
                reflectMethod.invoke(bundle);
                AppMethodBeat.m2505o(85341);
                return;
            } catch (Exception e) {
                Log.m81046e("XWWebView", "setProfileConfig reflect failed");
            }
        }
        AppMethodBeat.m2505o(85341);
    }

    public final void clearHistory() {
        AppMethodBeat.m2504i(85342);
        if (this.ARZ.getNavigationHistory() != null) {
            this.ARZ.getNavigationHistory().clear();
        }
        AppMethodBeat.m2505o(85342);
    }

    public final boolean canGoForward() {
        AppMethodBeat.m2504i(85343);
        if (this.ARZ.getNavigationHistory() != null) {
            boolean canGoForward = this.ARZ.getNavigationHistory().canGoForward();
            AppMethodBeat.m2505o(85343);
            return canGoForward;
        }
        AppMethodBeat.m2505o(85343);
        return false;
    }

    public final boolean supportFeature(int i) {
        AppMethodBeat.m2504i(85344);
        boolean hasFeature = XWalkCoreWrapper.getInstance().hasFeature(i);
        AppMethodBeat.m2505o(85344);
        return hasFeature;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(85345);
        this.ARZ.setVerticalScrollBarEnable(z);
        AppMethodBeat.m2505o(85345);
    }

    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(85346);
        this.ARZ.setHorizontalScrollBarEnable(z);
        AppMethodBeat.m2505o(85346);
    }

    public final boolean isOverScrollStart() {
        int computeVerticalScrollOffset;
        AppMethodBeat.m2504i(85336);
        boolean z = this.ASq;
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            computeVerticalScrollOffset = ((XWalkView) webViewUI).computeVerticalScrollOffset();
        } else {
            computeVerticalScrollOffset = webViewUI.getScrollY();
        }
        if (computeVerticalScrollOffset == 0 && z) {
            AppMethodBeat.m2505o(85336);
            return true;
        }
        AppMethodBeat.m2505o(85336);
        return false;
    }
}
