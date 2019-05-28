package com.tencent.p177mm.plugin.webview.luggage.p1070d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.webview.C37407a;
import com.tencent.luggage.webview.C37407a.C32193a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.luggage.C14462b;
import com.tencent.p177mm.plugin.webview.luggage.C16926e;
import com.tencent.p177mm.plugin.webview.luggage.C29785c;
import com.tencent.p177mm.plugin.webview.luggage.C46418f;
import com.tencent.p177mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C43886b;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import java.lang.Thread.State;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.luggage.d.a */
public class C31472a extends MMWebView implements C37407a {
    private C32186k bPN;
    private C36591r icr;
    public String nHU;
    private Handler oUA;
    protected LuggageGetA8Key uii;
    private C46418f ulw;
    private C29785c ulx;
    private C16926e uly;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d.a$8 */
    class C228228 implements C36591r {
        C228228() {
        }

        /* renamed from: A */
        public final boolean mo31055A(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(6527);
            boolean Q = C31472a.this.mo49216Q(motionEvent);
            AppMethodBeat.m2505o(6527);
            return Q;
        }

        /* renamed from: b */
        public final boolean mo31059b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.m2504i(6528);
            boolean c = C31472a.this.mo49221c(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.m2505o(6528);
            return c;
        }

        public final void aGs() {
            AppMethodBeat.m2504i(6529);
            C31472a.this.dKK();
            AppMethodBeat.m2505o(6529);
        }

        @TargetApi(9)
        /* renamed from: d */
        public final void mo31060d(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(6530);
            C31472a.this.mo49227e(i, i2, z, z2);
            AppMethodBeat.m2505o(6530);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(6531);
            C31472a.this.mo49215M(i, i2, i3, i4);
            AppMethodBeat.m2505o(6531);
        }

        /* renamed from: B */
        public final boolean mo31056B(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(6532);
            boolean R = C31472a.this.mo49217R(motionEvent);
            AppMethodBeat.m2505o(6532);
            return R;
        }

        /* renamed from: C */
        public final boolean mo31057C(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(6533);
            boolean S = C31472a.this.mo49218S(motionEvent);
            AppMethodBeat.m2505o(6533);
            return S;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d.a$5 */
    class C314735 extends C46418f {
        C314735() {
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(6518);
            C45124d.m82929i(getClass().getSimpleName(), "onPageStarted");
            super.mo7562b(webView, str, bitmap);
            AppMethodBeat.m2505o(6518);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d.a$6 */
    class C314746 extends C29785c {
        C314746() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.d.a$7 */
    class C314757 extends C16926e {
        C314757() {
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.m2504i(6519);
            Object onMiscCallBack = super.onMiscCallBack(str, bundle);
            AppMethodBeat.m2505o(6519);
            return onMiscCallBack;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(6520);
            if (C31472a.this.icr.mo31055A(motionEvent) || super.onTouchEvent(motionEvent, view)) {
                AppMethodBeat.m2505o(6520);
                return true;
            }
            AppMethodBeat.m2505o(6520);
            return false;
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(6521);
            if (C31472a.this.icr.mo31057C(motionEvent) || super.onInterceptTouchEvent(motionEvent, view)) {
                AppMethodBeat.m2505o(6521);
                return true;
            }
            AppMethodBeat.m2505o(6521);
            return false;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(6522);
            if (C31472a.this.icr.mo31056B(motionEvent) || super.dispatchTouchEvent(motionEvent, view)) {
                AppMethodBeat.m2505o(6522);
                return true;
            }
            AppMethodBeat.m2505o(6522);
            return false;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            AppMethodBeat.m2504i(6523);
            if (C31472a.this.icr.mo31059b(i, i2, i3, i4, i5, i6, i7, i8, z) || super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view)) {
                AppMethodBeat.m2505o(6523);
                return true;
            }
            AppMethodBeat.m2505o(6523);
            return false;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(6524);
            C31472a.this.icr.onScrollChanged(i, i2, i3, i4, view);
            super.onScrollChanged(i, i2, i3, i4, view);
            AppMethodBeat.m2505o(6524);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            AppMethodBeat.m2504i(6525);
            C31472a.this.icr.mo31060d(i, i2, z, z2);
            super.onOverScrolled(i, i2, z, z2, view);
            AppMethodBeat.m2505o(6525);
        }

        public final void computeScroll(View view) {
            AppMethodBeat.m2504i(6526);
            C31472a.this.icr.aGs();
            super.computeScroll(view);
            AppMethodBeat.m2505o(6526);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m50920a(C31472a c31472a, String str, ValueCallback valueCallback) {
        AppMethodBeat.m2504i(6559);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(6559);
    }

    public C31472a(Context context) {
        super(context);
        AppMethodBeat.m2504i(6534);
        this.ulw = new C314735();
        this.ulx = new C314746();
        this.uly = new C314757();
        this.icr = new C228228();
        this.uii = new LuggageGetA8Key();
        this.oUA = new Handler(Looper.getMainLooper());
        this.inited = true;
        this.isX5Kernel = getX5WebViewExtension() != null;
        C30086a.m47650fH(getContext());
        if (!(getIsX5Kernel() || C1443d.m3068iW(19))) {
            try {
                C4990ab.m7411d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new C1438c(this, "mSysWebView", null).get());
                C4990ab.m7411d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new C1438c(r0, "mProvider", null).get());
                C4990ab.m7411d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new C1438c(r0, "mWebViewCore", null).get());
                C4990ab.m7411d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new C1438c(r0, "sWebCoreHandler", null).get());
                C4990ab.m7411d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new C1438c(r0, "mLooper", null).get());
                Object obj = new C1438c(obj, "mThread", null).get();
                C4990ab.m7411d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    C4990ab.m7417i("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, exception = %s", e);
            }
        }
        MMWebView.m49133il(getContext());
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().dUh();
        getSettings().dUc();
        getSettings().dUb();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().dUj();
        getSettings().dUf();
        getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        getSettings().dUe();
        getSettings().dUg();
        getSettings().setDatabasePath(C6457e.eSi + "databases/");
        C44576b.dTR().dTS();
        C44576b.dTR().mo71378f(this);
        getSettings().setUserAgentString(C43886b.m78712bh(getContext(), getSettings().getUserAgentString()) + " Luggage");
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setLayoutParams(new LayoutParams(-1, -1));
        super.setWebViewClient(this.ulw);
        super.setWebChromeClient(this.ulx);
        if (getIsX5Kernel()) {
            super.setWebViewCallbackClient(this.icr);
            super.setWebViewClientExtension(this.uly);
        }
        dKJ();
        AppMethodBeat.m2505o(6534);
    }

    public void setContext(Context context) {
        AppMethodBeat.m2504i(6535);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        AppMethodBeat.m2505o(6535);
    }

    public void setSource(String str) {
        this.nHU = str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(6536);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.m2505o(6536);
            return;
        }
        this.oUA.post(runnable);
        AppMethodBeat.m2505o(6536);
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(6537);
        super.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(6537);
    }

    /* renamed from: by */
    public final void mo43469by(final String str) {
        AppMethodBeat.m2504i(6538);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6507);
                C31472a.m50919a(C31472a.this, str);
                AppMethodBeat.m2505o(6507);
            }
        });
        AppMethodBeat.m2505o(6538);
    }

    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(6539);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6508);
                C31472a.m50920a(C31472a.this, str, valueCallback);
                AppMethodBeat.m2505o(6508);
            }
        });
        AppMethodBeat.m2505o(6539);
    }

    public void setWebCore(C32186k c32186k) {
        AppMethodBeat.m2504i(6540);
        this.bPN = c32186k;
        mo7556xo();
        AppMethodBeat.m2505o(6540);
    }

    public C32186k getWebCore() {
        return this.bPN;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xo */
    public void mo7556xo() {
        AppMethodBeat.m2504i(6541);
        if (getWebCore().bPD != null) {
            getWebCore().bPD.mo33005a(new LuggageMMLocalResourceProvider());
            getWebCore().bPD.mo33005a(new C14462b(C32192i.m52511p(C4996ah.getContext(), "luggage_mm_adapter.js")));
        }
        AppMethodBeat.m2505o(6541);
    }

    /* renamed from: a */
    public void mo7543a(final C32193a c32193a) {
        AppMethodBeat.m2504i(6542);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6509);
                C31472a.m50918a(C31472a.this, c32193a);
                AppMethodBeat.m2505o(6509);
            }
        });
        AppMethodBeat.m2505o(6542);
    }

    public View getView() {
        return this;
    }

    public void loadUrl(String str) {
        AppMethodBeat.m2504i(6543);
        super.loadUrl(str);
        AppMethodBeat.m2505o(6543);
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(6544);
        super.loadUrl(str, map);
        AppMethodBeat.m2505o(6544);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(6545);
        super.loadData(str, str2, str3);
        AppMethodBeat.m2505o(6545);
    }

    public void stopLoading() {
        AppMethodBeat.m2504i(6546);
        super.stopLoading();
        AppMethodBeat.m2505o(6546);
    }

    public String getUrl() {
        AppMethodBeat.m2504i(6547);
        String url = super.getUrl();
        AppMethodBeat.m2505o(6547);
        return url;
    }

    public String getTitle() {
        AppMethodBeat.m2504i(6548);
        String title = super.getTitle();
        AppMethodBeat.m2505o(6548);
        return title;
    }

    public void goBack() {
        AppMethodBeat.m2504i(6549);
        super.goBack();
        AppMethodBeat.m2505o(6549);
    }

    public boolean canGoBack() {
        AppMethodBeat.m2504i(6550);
        boolean canGoBack = super.canGoBack();
        AppMethodBeat.m2505o(6550);
        return canGoBack;
    }

    public void destroy() {
        AppMethodBeat.m2504i(6551);
        super.destroy();
        AppMethodBeat.m2505o(6551);
    }

    public void setWebViewClient(C36592s c36592s) {
        AppMethodBeat.m2504i(6552);
        this.ulw.mo74632a(c36592s);
        AppMethodBeat.m2505o(6552);
    }

    /* Access modifiers changed, original: protected */
    public void setWebViewClientProxy(C46418f c46418f) {
        AppMethodBeat.m2504i(6553);
        if (c46418f != null) {
            this.ulw.mo74632a(c46418f);
            this.ulw = c46418f;
        }
        AppMethodBeat.m2505o(6553);
    }

    public void setWebChromeClient(C6031l c6031l) {
        AppMethodBeat.m2504i(6554);
        this.ulx.mo48031a(c6031l);
        AppMethodBeat.m2505o(6554);
    }

    /* Access modifiers changed, original: protected */
    public void setWebChromeClientProxy(C29785c c29785c) {
        AppMethodBeat.m2504i(6555);
        if (c29785c != null) {
            this.ulx.mo48031a(c29785c);
            this.ulx = c29785c;
        }
        AppMethodBeat.m2505o(6555);
    }

    public void setWebViewClientExtension(C16404b c16404b) {
        AppMethodBeat.m2504i(6556);
        this.uly.mo30938a(c16404b);
        AppMethodBeat.m2505o(6556);
    }

    /* Access modifiers changed, original: protected */
    public void setWebViewClientExtensionProxy(C16926e c16926e) {
        AppMethodBeat.m2504i(6557);
        if (c16926e != null) {
            this.uly.mo30938a(c16926e);
            this.uly = c16926e;
        }
        AppMethodBeat.m2505o(6557);
    }
}
