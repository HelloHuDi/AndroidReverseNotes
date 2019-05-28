package com.tencent.mm.plugin.game.luggage.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.util.Map;

public class d extends com.tencent.mm.plugin.webview.luggage.d.a {
    private static final Object lock = new Object();
    String mTH;
    private String mTitle;
    private c mUE = new c();
    private boolean mUF = false;
    Map<String, String> mUG;
    private String mUH;
    private boolean mUI = false;
    private boolean mUJ = false;
    private boolean mUK = false;
    private boolean mUL = false;
    private boolean mUM = false;
    private GameWebPerformanceInfo mUN;
    private ViewGroup mUO;
    private boolean mUP = false;
    private Object mUQ = new Object();
    private Runnable mUR = new Runnable() {
        public final void run() {
            AppMethodBeat.i(135925);
            synchronized (d.lock) {
                try {
                    if (d.this.getSettings().getBlockNetworkImage()) {
                        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
                        d.this.getSettings().setBlockNetworkImage(false);
                        h.pYm.k(949, 0, 1);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(135925);
                }
            }
        }
    };

    public class a extends com.tencent.mm.plugin.webview.luggage.c {
        public final void d(WebView webView, String str) {
            AppMethodBeat.i(135934);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", str);
            if (!com.tencent.mm.plugin.webview.luggage.c.b.Ed(str)) {
                d.this.mTitle = str;
            }
            super.d(webView, str);
            AppMethodBeat.o(135934);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(135935);
            if (d.this.mUE != null) {
                d.this.mUE.a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(135935);
            return onConsoleMessage;
        }
    }

    public class b extends f {
        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(135936);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            d.this.mUE.j(webView, str);
            super.b(webView, str, bitmap);
            d.this.b(webView, str, bitmap);
            AppMethodBeat.o(135936);
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(135937);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            d.this.mUE.k(webView, str);
            super.b(webView, str);
            d.this.b(webView, str);
            AppMethodBeat.o(135937);
        }

        public final void h(WebView webView, String str) {
            AppMethodBeat.i(135938);
            super.h(webView, str);
            com.tencent.luggage.g.d.d("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", str);
            AppMethodBeat.o(135938);
        }

        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(135939);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", str);
            if (DownloadChecker.a(str, d.this.nHU, webView)) {
                ab.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
                AppMethodBeat.o(135939);
                return true;
            }
            boolean a = super.a(webView, str);
            AppMethodBeat.o(135939);
            return a;
        }

        public final o c(WebView webView, String str) {
            AppMethodBeat.i(135940);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", str);
            o oVar;
            if (str.equals("https://game.weixin.qq.com/favicon.ico")) {
                oVar = new o("img/png", null, null);
                AppMethodBeat.o(135940);
                return oVar;
            }
            oVar = d.this.mUE.ahA(str);
            if (oVar != null) {
                com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.o(135940);
                return oVar;
            }
            oVar = super.c(webView, str);
            AppMethodBeat.o(135940);
            return oVar;
        }

        public final o a(WebView webView, n nVar) {
            AppMethodBeat.i(135941);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", nVar.getUrl().toString());
            o oVar;
            if (nVar.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico")) {
                oVar = new o("img/png", null, null);
                AppMethodBeat.o(135941);
                return oVar;
            }
            oVar = d.this.mUE.ahA(nVar.getUrl().toString());
            if (oVar != null) {
                com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.o(135941);
                return oVar;
            }
            oVar = super.a(webView, nVar);
            AppMethodBeat.o(135941);
            return oVar;
        }

        public final o a(WebView webView, n nVar, Bundle bundle) {
            AppMethodBeat.i(135942);
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", nVar.getUrl().toString());
            o oVar;
            if (nVar.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico")) {
                oVar = new o("img/png", null, null);
                AppMethodBeat.o(135942);
                return oVar;
            }
            oVar = d.this.mUE.ahA(nVar.getUrl().toString());
            if (oVar != null) {
                com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.o(135942);
                return oVar;
            }
            oVar = super.a(webView, nVar, bundle);
            AppMethodBeat.o(135942);
            return oVar;
        }

        public final void a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(135943);
            super.a(webView, i, str, str2);
            com.tencent.luggage.g.d.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", str, str2);
            h.pYm.k(949, 1, 1);
            AppMethodBeat.o(135943);
        }

        public final void a(WebView webView, j jVar, SslError sslError) {
            AppMethodBeat.i(135944);
            super.a(webView, jVar, sslError);
            com.tencent.luggage.g.d.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(sslError)));
            h.pYm.k(949, 2, 1);
            AppMethodBeat.o(135944);
        }

        public final void a(WebView webView, n nVar, o oVar) {
            AppMethodBeat.i(135945);
            super.a(webView, nVar, oVar);
            com.tencent.luggage.g.d.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", Integer.valueOf(oVar.mStatusCode));
            h.pYm.k(949, 3, 1);
            AppMethodBeat.o(135945);
        }
    }

    static {
        AppMethodBeat.i(135962);
        AppMethodBeat.o(135962);
    }

    public d(Context context) {
        super(context);
        AppMethodBeat.i(135946);
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(135946);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(135947);
        super.onAttachedToWindow();
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", Integer.valueOf(hashCode()));
        this.mUL = true;
        bDA();
        AppMethodBeat.o(135947);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(135948);
        super.onDetachedFromWindow();
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", Integer.valueOf(hashCode()));
        removeCallbacks(this.mUR);
        AppMethodBeat.o(135948);
    }

    public final void a(com.tencent.luggage.webview.a.a aVar) {
        AppMethodBeat.i(135949);
        super.a(aVar);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135933);
                d.this.init();
                AppMethodBeat.o(135933);
            }
        });
        AppMethodBeat.o(135949);
    }

    public void xo() {
        AppMethodBeat.i(135950);
        super.xo();
        getWebCore().bPD.a(new com.tencent.mm.plugin.game.luggage.a(this));
        AppMethodBeat.o(135950);
    }

    /* Access modifiers changed, original: protected|final */
    public final void init() {
        AppMethodBeat.i(135951);
        getSettings().setBlockNetworkImage(true);
        setWebViewClientProxy(new b());
        setWebChromeClientProxy(new a());
        AppMethodBeat.o(135951);
    }

    private void bDA() {
        AppMethodBeat.i(135952);
        if (this.mUK && this.mUL) {
            postDelayed(this.mUR, 3000);
        }
        AppMethodBeat.o(135952);
    }

    /* Access modifiers changed, original: protected */
    public void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(135953);
        this.mUK = true;
        bDA();
        if (this.mUN.eCf == 0) {
            this.mUN.eCf = System.currentTimeMillis();
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", str, Long.valueOf(this.mUN.eCf));
        }
        if (g.agh(str).uDM == 0) {
            g.agh(str).uDM = System.currentTimeMillis();
        }
        AppMethodBeat.o(135953);
    }

    /* Access modifiers changed, original: protected */
    public void b(WebView webView, String str) {
        AppMethodBeat.i(135954);
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", Boolean.valueOf(this.mUJ));
        if (this.mUN.eCg == 0) {
            this.mUN.eCg = System.currentTimeMillis();
            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", str, Long.valueOf(this.mUN.eCg));
        }
        if (g.agh(str).uDN == 0) {
            g.agh(str).uDN = System.currentTimeMillis();
        }
        synchronized (lock) {
            try {
                getSettings().setBlockNetworkImage(this.mUJ);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(135954);
                }
            }
        }
        this.mUI = true;
        if (this.mUN.eCd == 0) {
            this.mUN.eCd = System.currentTimeMillis();
        }
        AppMethodBeat.o(135954);
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(135955);
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", Boolean.valueOf(z));
        this.mUJ = z;
        if (this.mUI) {
            synchronized (lock) {
                try {
                    getSettings().setBlockNetworkImage(z);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(135955);
                }
            }
            return;
        }
        AppMethodBeat.o(135955);
    }

    public void destroy() {
        AppMethodBeat.i(135956);
        this.mUE.ot(this.mUM);
        super.destroy();
        AppMethodBeat.o(135956);
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(135957);
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
        this.mUH = str;
        if (this.mUN == null) {
            this.mUN = GameWebPerformanceInfo.kU(str);
            this.mUN.eCe = System.currentTimeMillis();
        }
        com.tencent.luggage.g.d.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", Boolean.valueOf(this.mUF));
        if (!this.mUF) {
            this.mUE.bO(str, true);
            this.mUF = true;
        }
        super.loadUrl(str);
        AppMethodBeat.o(135957);
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(135958);
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", Long.valueOf(System.currentTimeMillis()));
        this.mUH = str;
        if (this.mUN == null) {
            this.mUN = GameWebPerformanceInfo.kU(str);
            this.mUN.eCe = System.currentTimeMillis();
        }
        com.tencent.luggage.g.d.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", Boolean.valueOf(this.mUF));
        if (!this.mUF) {
            this.mUE.bO(str, true);
            this.mUF = true;
        }
        super.loadUrl(str, map);
        AppMethodBeat.o(135958);
    }

    public final boolean NQ(String str) {
        AppMethodBeat.i(135959);
        com.tencent.luggage.g.d.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", Boolean.valueOf(this.mUF));
        if (!this.mUF) {
            this.mUE.bO(str, true);
            this.mUF = true;
        }
        boolean ahB = this.mUE.ahB(str);
        AppMethodBeat.o(135959);
        return ahB;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setShouldCleanPkgWhenDestroy(boolean z) {
        this.mUM = z;
    }

    public c getWePkgPlugin() {
        return this.mUE;
    }

    static /* synthetic */ void d(d dVar) {
        AppMethodBeat.i(135960);
        synchronized (dVar.mUQ) {
            try {
                ViewGroup viewGroup = (ViewGroup) dVar.getParent();
                if (viewGroup != null && dVar.mUP) {
                    dVar.mUO = new FrameLayout(viewGroup.getContext());
                    dVar.mUO.setBackgroundColor(0);
                    dVar.mUO.setClickable(true);
                    viewGroup.addView(dVar.mUO, new LayoutParams(-1, -1));
                    dVar.mUO.addView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_3, viewGroup, false), new LayoutParams(-2, -2, 17));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135960);
            }
        }
    }

    static /* synthetic */ void e(d dVar) {
        AppMethodBeat.i(135961);
        synchronized (dVar.mUQ) {
            try {
                ViewGroup viewGroup = (ViewGroup) dVar.getParent();
                if (!(viewGroup == null || dVar.mUO == null)) {
                    viewGroup.removeView(dVar.mUO);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135961);
            }
        }
    }
}
