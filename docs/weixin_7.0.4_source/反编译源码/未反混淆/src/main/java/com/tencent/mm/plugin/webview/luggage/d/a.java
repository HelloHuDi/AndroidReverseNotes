package com.tencent.mm.plugin.webview.luggage.d;

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
import com.tencent.luggage.d.k;
import com.tencent.luggage.g.d;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.l;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import java.lang.Thread.State;
import java.util.Map;

public class a extends MMWebView implements com.tencent.luggage.webview.a {
    private k bPN;
    private r icr;
    public String nHU;
    private Handler oUA;
    protected LuggageGetA8Key uii;
    private f ulw;
    private c ulx;
    private e uly;

    static /* synthetic */ void a(a aVar, String str, ValueCallback valueCallback) {
        AppMethodBeat.i(6559);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(6559);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(6534);
        this.ulw = new f() {
            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(6518);
                d.i(getClass().getSimpleName(), "onPageStarted");
                super.b(webView, str, bitmap);
                AppMethodBeat.o(6518);
            }
        };
        this.ulx = new c() {
        };
        this.uly = new e() {
            public final Object onMiscCallBack(String str, Bundle bundle) {
                AppMethodBeat.i(6519);
                Object onMiscCallBack = super.onMiscCallBack(str, bundle);
                AppMethodBeat.o(6519);
                return onMiscCallBack;
            }

            public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(6520);
                if (a.this.icr.A(motionEvent) || super.onTouchEvent(motionEvent, view)) {
                    AppMethodBeat.o(6520);
                    return true;
                }
                AppMethodBeat.o(6520);
                return false;
            }

            public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(6521);
                if (a.this.icr.C(motionEvent) || super.onInterceptTouchEvent(motionEvent, view)) {
                    AppMethodBeat.o(6521);
                    return true;
                }
                AppMethodBeat.o(6521);
                return false;
            }

            public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(6522);
                if (a.this.icr.B(motionEvent) || super.dispatchTouchEvent(motionEvent, view)) {
                    AppMethodBeat.o(6522);
                    return true;
                }
                AppMethodBeat.o(6522);
                return false;
            }

            public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
                AppMethodBeat.i(6523);
                if (a.this.icr.b(i, i2, i3, i4, i5, i6, i7, i8, z) || super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view)) {
                    AppMethodBeat.o(6523);
                    return true;
                }
                AppMethodBeat.o(6523);
                return false;
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                AppMethodBeat.i(6524);
                a.this.icr.onScrollChanged(i, i2, i3, i4, view);
                super.onScrollChanged(i, i2, i3, i4, view);
                AppMethodBeat.o(6524);
            }

            public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
                AppMethodBeat.i(6525);
                a.this.icr.d(i, i2, z, z2);
                super.onOverScrolled(i, i2, z, z2, view);
                AppMethodBeat.o(6525);
            }

            public final void computeScroll(View view) {
                AppMethodBeat.i(6526);
                a.this.icr.aGs();
                super.computeScroll(view);
                AppMethodBeat.o(6526);
            }
        };
        this.icr = new r() {
            public final boolean A(MotionEvent motionEvent) {
                AppMethodBeat.i(6527);
                boolean Q = a.this.Q(motionEvent);
                AppMethodBeat.o(6527);
                return Q;
            }

            public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
                AppMethodBeat.i(6528);
                boolean c = a.this.c(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.o(6528);
                return c;
            }

            public final void aGs() {
                AppMethodBeat.i(6529);
                a.this.dKK();
                AppMethodBeat.o(6529);
            }

            @TargetApi(9)
            public final void d(int i, int i2, boolean z, boolean z2) {
                AppMethodBeat.i(6530);
                a.this.e(i, i2, z, z2);
                AppMethodBeat.o(6530);
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                AppMethodBeat.i(6531);
                a.this.M(i, i2, i3, i4);
                AppMethodBeat.o(6531);
            }

            public final boolean B(MotionEvent motionEvent) {
                AppMethodBeat.i(6532);
                boolean R = a.this.R(motionEvent);
                AppMethodBeat.o(6532);
                return R;
            }

            public final boolean C(MotionEvent motionEvent) {
                AppMethodBeat.i(6533);
                boolean S = a.this.S(motionEvent);
                AppMethodBeat.o(6533);
                return S;
            }
        };
        this.uii = new LuggageGetA8Key();
        this.oUA = new Handler(Looper.getMainLooper());
        this.inited = true;
        this.isX5Kernel = getX5WebViewExtension() != null;
        com.tencent.mm.pluginsdk.model.v.a.fH(getContext());
        if (!(getIsX5Kernel() || com.tencent.mm.compatible.util.d.iW(19))) {
            try {
                ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get());
                ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get());
                ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get());
                ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get());
                ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get());
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    ab.i("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, exception = %s", e);
            }
        }
        MMWebView.il(getContext());
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
        getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eSi + "databases/");
        b.dTR().dTS();
        b.dTR().f(this);
        getSettings().setUserAgentString(com.tencent.mm.plugin.webview.luggage.c.b.bh(getContext(), getSettings().getUserAgentString()) + " Luggage");
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
        AppMethodBeat.o(6534);
    }

    public void setContext(Context context) {
        AppMethodBeat.i(6535);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        AppMethodBeat.o(6535);
    }

    public void setSource(String str) {
        this.nHU = str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(6536);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.o(6536);
            return;
        }
        this.oUA.post(runnable);
        AppMethodBeat.o(6536);
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(6537);
        super.addJavascriptInterface(obj, str);
        AppMethodBeat.o(6537);
    }

    public final void by(final String str) {
        AppMethodBeat.i(6538);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6507);
                a.a(a.this, str);
                AppMethodBeat.o(6507);
            }
        });
        AppMethodBeat.o(6538);
    }

    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(6539);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6508);
                a.a(a.this, str, valueCallback);
                AppMethodBeat.o(6508);
            }
        });
        AppMethodBeat.o(6539);
    }

    public void setWebCore(k kVar) {
        AppMethodBeat.i(6540);
        this.bPN = kVar;
        xo();
        AppMethodBeat.o(6540);
    }

    public k getWebCore() {
        return this.bPN;
    }

    /* Access modifiers changed, original: protected */
    public void xo() {
        AppMethodBeat.i(6541);
        if (getWebCore().bPD != null) {
            getWebCore().bPD.a(new LuggageMMLocalResourceProvider());
            getWebCore().bPD.a(new com.tencent.mm.plugin.webview.luggage.b(i.p(ah.getContext(), "luggage_mm_adapter.js")));
        }
        AppMethodBeat.o(6541);
    }

    public void a(final com.tencent.luggage.webview.a.a aVar) {
        AppMethodBeat.i(6542);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6509);
                a.a(a.this, aVar);
                AppMethodBeat.o(6509);
            }
        });
        AppMethodBeat.o(6542);
    }

    public View getView() {
        return this;
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(6543);
        super.loadUrl(str);
        AppMethodBeat.o(6543);
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(6544);
        super.loadUrl(str, map);
        AppMethodBeat.o(6544);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(6545);
        super.loadData(str, str2, str3);
        AppMethodBeat.o(6545);
    }

    public void stopLoading() {
        AppMethodBeat.i(6546);
        super.stopLoading();
        AppMethodBeat.o(6546);
    }

    public String getUrl() {
        AppMethodBeat.i(6547);
        String url = super.getUrl();
        AppMethodBeat.o(6547);
        return url;
    }

    public String getTitle() {
        AppMethodBeat.i(6548);
        String title = super.getTitle();
        AppMethodBeat.o(6548);
        return title;
    }

    public void goBack() {
        AppMethodBeat.i(6549);
        super.goBack();
        AppMethodBeat.o(6549);
    }

    public boolean canGoBack() {
        AppMethodBeat.i(6550);
        boolean canGoBack = super.canGoBack();
        AppMethodBeat.o(6550);
        return canGoBack;
    }

    public void destroy() {
        AppMethodBeat.i(6551);
        super.destroy();
        AppMethodBeat.o(6551);
    }

    public void setWebViewClient(s sVar) {
        AppMethodBeat.i(6552);
        this.ulw.a(sVar);
        AppMethodBeat.o(6552);
    }

    /* Access modifiers changed, original: protected */
    public void setWebViewClientProxy(f fVar) {
        AppMethodBeat.i(6553);
        if (fVar != null) {
            this.ulw.a(fVar);
            this.ulw = fVar;
        }
        AppMethodBeat.o(6553);
    }

    public void setWebChromeClient(l lVar) {
        AppMethodBeat.i(6554);
        this.ulx.a(lVar);
        AppMethodBeat.o(6554);
    }

    /* Access modifiers changed, original: protected */
    public void setWebChromeClientProxy(c cVar) {
        AppMethodBeat.i(6555);
        if (cVar != null) {
            this.ulx.a(cVar);
            this.ulx = cVar;
        }
        AppMethodBeat.o(6555);
    }

    public void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
        AppMethodBeat.i(6556);
        this.uly.a(bVar);
        AppMethodBeat.o(6556);
    }

    /* Access modifiers changed, original: protected */
    public void setWebViewClientExtensionProxy(e eVar) {
        AppMethodBeat.i(6557);
        if (eVar != null) {
            this.uly.a(eVar);
            this.uly = eVar;
        }
        AppMethodBeat.o(6557);
    }
}
