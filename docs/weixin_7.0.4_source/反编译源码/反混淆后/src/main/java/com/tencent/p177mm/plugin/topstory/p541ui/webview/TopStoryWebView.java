package com.tencent.p177mm.plugin.topstory.p541ui.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.C44576b;
import java.lang.Thread.State;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView */
public class TopStoryWebView extends MMWebView {
    private Context context;

    public TopStoryWebView(Context context) {
        super(context);
        AppMethodBeat.m2504i(2160);
        this.context = context;
        init();
        AppMethodBeat.m2505o(2160);
    }

    public TopStoryWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(2161);
        this.context = context;
        init();
        AppMethodBeat.m2505o(2161);
    }

    public TopStoryWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(2162);
        this.context = context;
        init();
        AppMethodBeat.m2505o(2162);
    }

    private void init() {
        AppMethodBeat.m2504i(2163);
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
        this.inited = true;
        MMWebView.m49133il(this.context);
        cHn();
        AppMethodBeat.m2505o(2163);
    }

    private void cHn() {
        AppMethodBeat.m2504i(2164);
        if (getIsX5Kernel()) {
            AppMethodBeat.m2505o(2164);
        } else if (C1443d.m3068iW(19)) {
            AppMethodBeat.m2505o(2164);
        } else {
            try {
                C4990ab.m7411d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new C1438c(this, "mSysWebView", null).get());
                C4990ab.m7411d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new C1438c(r0, "mProvider", null).get());
                C4990ab.m7411d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new C1438c(r0, "mWebViewCore", null).get());
                C4990ab.m7411d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new C1438c(r0, "sWebCoreHandler", null).get());
                C4990ab.m7411d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new C1438c(r0, "mLooper", null).get());
                Object obj = new C1438c(obj, "mThread", null).get();
                C4990ab.m7411d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
                AppMethodBeat.m2505o(2164);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", e);
                AppMethodBeat.m2505o(2164);
            }
        }
    }

    /* renamed from: a */
    public final void mo51379a(C13994b c13994b, C14002d c14002d) {
        AppMethodBeat.m2504i(2165);
        getSettings().dUh();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setPluginsEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().dUj();
        getSettings().setUserAgentString(C30152u.m47747bh(getContext(), getSettings().getUserAgentString()));
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
        getSettings().setDatabasePath(C6457e.eSi + "databases/");
        C44576b.dTR().dTS();
        C44576b.dTR().mo71378f(this);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(true);
        setConfigCallback((WindowManager) C4996ah.getContext().getSystemService("window"));
        super.setWebChromeClient(c13994b);
        super.setWebViewClient(c14002d);
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        dKH();
        try {
            if (VERSION.SDK_INT >= 19) {
                if (C39964g.cFm()) {
                    WebView.setWebContentsDebuggingEnabled(true);
                } else {
                    WebView.setWebContentsDebuggingEnabled(false);
                }
            }
        } catch (Exception e) {
        }
        float f = getContext().getSharedPreferences(C4996ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
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
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", Float.valueOf(f));
        AppMethodBeat.m2505o(2165);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(2166);
        this.context = null;
        super.setWebChromeClient(null);
        super.setWebViewClient(null);
        destroy();
        removeJavascriptInterface("topStoryJSApi");
        try {
            destroy();
            AppMethodBeat.m2505o(2166);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebView", e, "onDestroy", new Object[0]);
            AppMethodBeat.m2505o(2166);
        }
    }

    public void setConfigCallback(WindowManager windowManager) {
        AppMethodBeat.m2504i(2167);
        try {
            Field declaredField = com.tencent.xweb.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                AppMethodBeat.m2505o(2167);
                return;
            }
            declaredField = declaredField.getType().getDeclaredField("mWindowManager");
            declaredField.setAccessible(true);
            declaredField.set(obj, windowManager);
            AppMethodBeat.m2505o(2167);
        } catch (Exception e) {
            AppMethodBeat.m2505o(2167);
        }
    }
}
