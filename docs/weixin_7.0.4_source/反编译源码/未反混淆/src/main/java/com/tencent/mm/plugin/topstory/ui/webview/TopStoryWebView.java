package com.tencent.mm.plugin.topstory.ui.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b;
import java.lang.Thread.State;
import java.lang.reflect.Field;

public class TopStoryWebView extends MMWebView {
    private Context context;

    public TopStoryWebView(Context context) {
        super(context);
        AppMethodBeat.i(2160);
        this.context = context;
        init();
        AppMethodBeat.o(2160);
    }

    public TopStoryWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(2161);
        this.context = context;
        init();
        AppMethodBeat.o(2161);
    }

    public TopStoryWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(2162);
        this.context = context;
        init();
        AppMethodBeat.o(2162);
    }

    private void init() {
        AppMethodBeat.i(2163);
        ab.i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
        this.inited = true;
        MMWebView.il(this.context);
        cHn();
        AppMethodBeat.o(2163);
    }

    private void cHn() {
        AppMethodBeat.i(2164);
        if (getIsX5Kernel()) {
            AppMethodBeat.o(2164);
        } else if (d.iW(19)) {
            AppMethodBeat.o(2164);
        } else {
            try {
                ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new c(this, "mSysWebView", null).get());
                ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new c(r0, "mProvider", null).get());
                ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new c(r0, "mWebViewCore", null).get());
                ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new c(r0, "sWebCoreHandler", null).get());
                ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new c(r0, "mLooper", null).get());
                Object obj = new c(obj, "mThread", null).get();
                ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    ab.i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
                AppMethodBeat.o(2164);
            } catch (Exception e) {
                ab.e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", e);
                AppMethodBeat.o(2164);
            }
        }
    }

    public final void a(b bVar, d dVar) {
        AppMethodBeat.i(2165);
        getSettings().dUh();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setPluginsEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().dUj();
        getSettings().setUserAgentString(u.bh(getContext(), getSettings().getUserAgentString()));
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().dUc();
        getSettings().dUb();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().dUj();
        getSettings().dUf();
        getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
        getSettings().dUe();
        getSettings().dUg();
        getSettings().setDatabasePath(e.eSi + "databases/");
        b.dTR().dTS();
        b.dTR().f(this);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(true);
        setConfigCallback((WindowManager) ah.getContext().getSystemService("window"));
        super.setWebChromeClient(bVar);
        super.setWebViewClient(dVar);
        ab.i("MicroMsg.TopStory.TopStoryWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        dKH();
        try {
            if (VERSION.SDK_INT >= 19) {
                if (g.cFm()) {
                    WebView.setWebContentsDebuggingEnabled(true);
                } else {
                    WebView.setWebContentsDebuggingEnabled(false);
                }
            }
        } catch (Exception e) {
        }
        float f = getContext().getSharedPreferences(ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f >= 2.025f) {
            getSettings().setTextZoom(160);
        } else if (f >= 1.875f) {
            getSettings().setTextZoom(150);
        } else if (f >= 1.625f) {
            getSettings().setTextZoom(140);
        } else if (f >= 1.375f) {
            getSettings().setTextZoom(130);
        } else if (f >= 1.25f) {
            getSettings().setTextZoom(120);
        } else if (f >= 1.125f) {
            getSettings().setTextZoom(110);
        } else if (f >= 1.0f) {
            getSettings().setTextZoom(100);
        } else if (f >= 0.875f) {
            getSettings().setTextZoom(90);
        } else {
            getSettings().setTextZoom(80);
        }
        ab.i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", Float.valueOf(f));
        AppMethodBeat.o(2165);
    }

    public final void onDestroy() {
        AppMethodBeat.i(2166);
        this.context = null;
        super.setWebChromeClient(null);
        super.setWebViewClient(null);
        destroy();
        removeJavascriptInterface("topStoryJSApi");
        try {
            destroy();
            AppMethodBeat.o(2166);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebView", e, "onDestroy", new Object[0]);
            AppMethodBeat.o(2166);
        }
    }

    public void setConfigCallback(WindowManager windowManager) {
        AppMethodBeat.i(2167);
        try {
            Field declaredField = com.tencent.xweb.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                AppMethodBeat.o(2167);
                return;
            }
            declaredField = declaredField.getType().getDeclaredField("mWindowManager");
            declaredField.setAccessible(true);
            declaredField.set(obj, windowManager);
            AppMethodBeat.o(2167);
        } catch (Exception e) {
            AppMethodBeat.o(2167);
        }
    }
}
