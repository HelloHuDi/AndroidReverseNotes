package com.tencent.p177mm.plugin.game.luggage.p432d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.webview.C37407a.C32193a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.plugin.downloader.model.DownloadChecker;
import com.tencent.p177mm.plugin.game.luggage.C12128a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C29785c;
import com.tencent.p177mm.plugin.webview.luggage.C46418f;
import com.tencent.p177mm.plugin.webview.luggage.p1070d.C31472a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C43886b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43963g;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.plugin.wepkg.event.C46472b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.WebView;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.luggage.d.d */
public class C3228d extends C31472a {
    private static final Object lock = new Object();
    String mTH;
    private String mTitle;
    private C30003c mUE = new C30003c();
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
    private Runnable mUR = new C32311();

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$a */
    public class C3229a extends C29785c {
        /* renamed from: d */
        public final void mo7557d(WebView webView, String str) {
            AppMethodBeat.m2504i(135934);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", str);
            if (!C43886b.m78711Ed(str)) {
                C3228d.this.mTitle = str;
            }
            super.mo7557d(webView, str);
            AppMethodBeat.m2505o(135934);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(135935);
            if (C3228d.this.mUE != null) {
                C3228d.this.mUE.mo48234a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(135935);
            return onConsoleMessage;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$b */
    public class C3230b extends C46418f {
        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(135936);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            C3228d.this.mUE.mo48240j(webView, str);
            super.mo7562b(webView, str, bitmap);
            C3228d.this.mo7545b(webView, str, bitmap);
            AppMethodBeat.m2505o(135936);
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(135937);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            C3228d.this.mUE.mo48241k(webView, str);
            super.mo5992b(webView, str);
            C3228d.this.mo7544b(webView, str);
            AppMethodBeat.m2505o(135937);
        }

        /* renamed from: h */
        public final void mo7563h(WebView webView, String str) {
            AppMethodBeat.m2504i(135938);
            super.mo7563h(webView, str);
            C45124d.m82926d("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", str);
            AppMethodBeat.m2505o(135938);
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(135939);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", str);
            if (DownloadChecker.m31425a(str, C3228d.this.nHU, webView)) {
                C4990ab.m7416i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
                AppMethodBeat.m2505o(135939);
                return true;
            }
            boolean a = super.mo4762a(webView, str);
            AppMethodBeat.m2505o(135939);
            return a;
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(135940);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", str);
            C31147o c31147o;
            if (str.equals("https://game.weixin.qq.com/favicon.ico")) {
                c31147o = new C31147o("img/png", null, null);
                AppMethodBeat.m2505o(135940);
                return c31147o;
            }
            c31147o = C3228d.this.mUE.ahA(str);
            if (c31147o != null) {
                C45124d.m82929i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.m2505o(135940);
                return c31147o;
            }
            c31147o = super.mo5993c(webView, str);
            AppMethodBeat.m2505o(135940);
            return c31147o;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(135941);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", c24530n.getUrl().toString());
            C31147o c31147o;
            if (c24530n.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico")) {
                c31147o = new C31147o("img/png", null, null);
                AppMethodBeat.m2505o(135941);
                return c31147o;
            }
            c31147o = C3228d.this.mUE.ahA(c24530n.getUrl().toString());
            if (c31147o != null) {
                C45124d.m82929i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.m2505o(135941);
                return c31147o;
            }
            c31147o = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(135941);
            return c31147o;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(135942);
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", c24530n.getUrl().toString());
            C31147o c31147o;
            if (c24530n.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico")) {
                c31147o = new C31147o("img/png", null, null);
                AppMethodBeat.m2505o(135942);
                return c31147o;
            }
            c31147o = C3228d.this.mUE.ahA(c24530n.getUrl().toString());
            if (c31147o != null) {
                C45124d.m82929i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.m2505o(135942);
                return c31147o;
            }
            c31147o = super.mo5991a(webView, c24530n, bundle);
            AppMethodBeat.m2505o(135942);
            return c31147o;
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(135943);
            super.mo7559a(webView, i, str, str2);
            C45124d.m82928e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", str, str2);
            C7060h.pYm.mo15419k(949, 1, 1);
            AppMethodBeat.m2505o(135943);
        }

        /* renamed from: a */
        public final void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
            AppMethodBeat.m2504i(135944);
            super.mo7560a(webView, c36588j, sslError);
            C45124d.m82927e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(sslError)));
            C7060h.pYm.mo15419k(949, 2, 1);
            AppMethodBeat.m2505o(135944);
        }

        /* renamed from: a */
        public final void mo7561a(WebView webView, C24530n c24530n, C31147o c31147o) {
            AppMethodBeat.m2504i(135945);
            super.mo7561a(webView, c24530n, c31147o);
            C45124d.m82928e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", Integer.valueOf(c31147o.mStatusCode));
            C7060h.pYm.mo15419k(949, 3, 1);
            AppMethodBeat.m2505o(135945);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$1 */
    class C32311 implements Runnable {
        C32311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135925);
            synchronized (C3228d.lock) {
                try {
                    if (C3228d.this.getSettings().getBlockNetworkImage()) {
                        C45124d.m82929i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
                        C3228d.this.getSettings().setBlockNetworkImage(false);
                        C7060h.pYm.mo15419k(949, 0, 1);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(135925);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$2 */
    class C32322 extends C46472b {

        /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$2$2 */
        class C32332 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$2$2$1 */
            class C32341 implements Runnable {
                C32341() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(135927);
                    if (C3228d.this.mUP) {
                        C3228d.m5540d(C3228d.this);
                    }
                    AppMethodBeat.m2505o(135927);
                }
            }

            C32332() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135928);
                C45124d.m82929i("MicroMsg.GameWebCoreImpl", "onForceUpdate");
                C3228d.this.mUP = true;
                C3228d.this.postDelayed(new C32341(), 1000);
                AppMethodBeat.m2505o(135928);
            }
        }

        /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$2$1 */
        class C32351 implements Runnable {
            C32351() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135926);
                C3228d.this.loadUrl(C3228d.this.mTH, C3228d.this.mUG);
                AppMethodBeat.m2505o(135926);
            }
        }

        C32322() {
        }

        public final void bDB() {
            AppMethodBeat.m2504i(135930);
            if (!C5046bo.isNullOrNil(C3228d.this.mTH)) {
                C3228d.this.post(new C32351());
            }
            AppMethodBeat.m2505o(135930);
        }

        public final void bDC() {
            AppMethodBeat.m2504i(135931);
            C3228d.this.post(new C32332());
            AppMethodBeat.m2505o(135931);
        }

        /* renamed from: hL */
        public final void mo7567hL(final boolean z) {
            AppMethodBeat.m2504i(135932);
            C3228d.this.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(135929);
                    if (C3228d.this.mUP) {
                        C3228d.this.mUP = false;
                        C3228d.m5541e(C3228d.this);
                        if (z) {
                            C45124d.m82929i("MicroMsg.GameWebCoreImpl", "onPkgReady");
                            C3228d.this.stopLoading();
                            C3228d.this.mUF = false;
                            C3228d.this.loadUrl(C3228d.this.mUH);
                        }
                    }
                    AppMethodBeat.m2505o(135929);
                }
            });
            AppMethodBeat.m2505o(135932);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.d$3 */
    class C32373 implements Runnable {
        C32373() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135933);
            C3228d.this.init();
            AppMethodBeat.m2505o(135933);
        }
    }

    static {
        AppMethodBeat.m2504i(135962);
        AppMethodBeat.m2505o(135962);
    }

    public C3228d(Context context) {
        super(context);
        AppMethodBeat.m2504i(135946);
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(135946);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(135947);
        super.onAttachedToWindow();
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", Integer.valueOf(hashCode()));
        this.mUL = true;
        bDA();
        AppMethodBeat.m2505o(135947);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(135948);
        super.onDetachedFromWindow();
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", Integer.valueOf(hashCode()));
        removeCallbacks(this.mUR);
        AppMethodBeat.m2505o(135948);
    }

    /* renamed from: a */
    public final void mo7543a(C32193a c32193a) {
        AppMethodBeat.m2504i(135949);
        super.mo7543a(c32193a);
        runOnUiThread(new C32373());
        AppMethodBeat.m2505o(135949);
    }

    /* renamed from: xo */
    public void mo7556xo() {
        AppMethodBeat.m2504i(135950);
        super.mo7556xo();
        getWebCore().bPD.mo33005a(new C12128a(this));
        AppMethodBeat.m2505o(135950);
    }

    /* Access modifiers changed, original: protected|final */
    public final void init() {
        AppMethodBeat.m2504i(135951);
        getSettings().setBlockNetworkImage(true);
        setWebViewClientProxy(new C3230b());
        setWebChromeClientProxy(new C3229a());
        AppMethodBeat.m2505o(135951);
    }

    private void bDA() {
        AppMethodBeat.m2504i(135952);
        if (this.mUK && this.mUL) {
            postDelayed(this.mUR, 3000);
        }
        AppMethodBeat.m2505o(135952);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo7545b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(135953);
        this.mUK = true;
        bDA();
        if (this.mUN.eCf == 0) {
            this.mUN.eCf = System.currentTimeMillis();
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", str, Long.valueOf(this.mUN.eCf));
        }
        if (C43963g.agh(str).uDM == 0) {
            C43963g.agh(str).uDM = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(135953);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo7544b(WebView webView, String str) {
        AppMethodBeat.m2504i(135954);
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", Boolean.valueOf(this.mUJ));
        if (this.mUN.eCg == 0) {
            this.mUN.eCg = System.currentTimeMillis();
            C45124d.m82930i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", str, Long.valueOf(this.mUN.eCg));
        }
        if (C43963g.agh(str).uDN == 0) {
            C43963g.agh(str).uDN = System.currentTimeMillis();
        }
        synchronized (lock) {
            try {
                getSettings().setBlockNetworkImage(this.mUJ);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(135954);
                }
            }
        }
        this.mUI = true;
        if (this.mUN.eCd == 0) {
            this.mUN.eCd = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(135954);
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.m2504i(135955);
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", Boolean.valueOf(z));
        this.mUJ = z;
        if (this.mUI) {
            synchronized (lock) {
                try {
                    getSettings().setBlockNetworkImage(z);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(135955);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(135955);
    }

    public void destroy() {
        AppMethodBeat.m2504i(135956);
        this.mUE.mo48243ot(this.mUM);
        super.destroy();
        AppMethodBeat.m2505o(135956);
    }

    public void loadUrl(String str) {
        AppMethodBeat.m2504i(135957);
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
        this.mUH = str;
        if (this.mUN == null) {
            this.mUN = GameWebPerformanceInfo.m63878kU(str);
            this.mUN.eCe = System.currentTimeMillis();
        }
        C45124d.m82926d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", Boolean.valueOf(this.mUF));
        if (!this.mUF) {
            this.mUE.mo48237bO(str, true);
            this.mUF = true;
        }
        super.loadUrl(str);
        AppMethodBeat.m2505o(135957);
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(135958);
        C45124d.m82930i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", Long.valueOf(System.currentTimeMillis()));
        this.mUH = str;
        if (this.mUN == null) {
            this.mUN = GameWebPerformanceInfo.m63878kU(str);
            this.mUN.eCe = System.currentTimeMillis();
        }
        C45124d.m82926d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", Boolean.valueOf(this.mUF));
        if (!this.mUF) {
            this.mUE.mo48237bO(str, true);
            this.mUF = true;
        }
        super.loadUrl(str, map);
        AppMethodBeat.m2505o(135958);
    }

    /* renamed from: NQ */
    public final boolean mo7542NQ(String str) {
        AppMethodBeat.m2504i(135959);
        C45124d.m82926d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", Boolean.valueOf(this.mUF));
        if (!this.mUF) {
            this.mUE.mo48237bO(str, true);
            this.mUF = true;
        }
        boolean ahB = this.mUE.ahB(str);
        AppMethodBeat.m2505o(135959);
        return ahB;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setShouldCleanPkgWhenDestroy(boolean z) {
        this.mUM = z;
    }

    public C30003c getWePkgPlugin() {
        return this.mUE;
    }

    /* renamed from: d */
    static /* synthetic */ void m5540d(C3228d c3228d) {
        AppMethodBeat.m2504i(135960);
        synchronized (c3228d.mUQ) {
            try {
                ViewGroup viewGroup = (ViewGroup) c3228d.getParent();
                if (viewGroup != null && c3228d.mUP) {
                    c3228d.mUO = new FrameLayout(viewGroup.getContext());
                    c3228d.mUO.setBackgroundColor(0);
                    c3228d.mUO.setClickable(true);
                    viewGroup.addView(c3228d.mUO, new LayoutParams(-1, -1));
                    c3228d.mUO.addView(LayoutInflater.from(viewGroup.getContext()).inflate(2130969941, viewGroup, false), new LayoutParams(-2, -2, 17));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135960);
            }
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m5541e(C3228d c3228d) {
        AppMethodBeat.m2504i(135961);
        synchronized (c3228d.mUQ) {
            try {
                ViewGroup viewGroup = (ViewGroup) c3228d.getParent();
                if (!(viewGroup == null || c3228d.mUO == null)) {
                    viewGroup.removeView(c3228d.mUO);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135961);
            }
        }
    }
}
