package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.a.q;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.k.u;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.w;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.s;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 L2\u00020\u0001:\u0002LMB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0014J\n\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020\nH\u0014J\b\u00101\u001a\u00020\nH\u0014J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0002J\u0010\u00105\u001a\u0002032\u0006\u0010'\u001a\u00020(H\u0002J\b\u00106\u001a\u00020\nH\u0014J\b\u00107\u001a\u00020\nH\u0014J\b\u00108\u001a\u00020\nH\u0014J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u0004H\u0014J\u0012\u0010;\u001a\u0002032\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u000203H\u0014J,\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0014J\u0010\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020=H\u0014J\u0010\u0010D\u001a\u0002032\u0006\u0010C\u001a\u00020=H\u0014J\b\u0010E\u001a\u000203H\u0014J\b\u0010F\u001a\u00020\nH\u0014J\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\nH\u0014J,\u0010K\u001a\u0002032\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00060\u001bR\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "httpHeader", "", "isA8KeyDone", "", "isDestroied", "isRefreshWebViewByGetA8Key", "isTmplWebView", "openType", "", "getOpenType", "()I", "openType$delegate", "Lkotlin/Lazy;", "pfullUrl", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "getSession", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "session$delegate", "tempWebViewClient", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "getTempWebViewClient", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "setTempWebViewClient", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;)V", "tmplController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "tmplParams$delegate", "tmplWebView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "tmplWebViewId", "createJsApiHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiHandler;", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewClient", "Lcom/tencent/xweb/WebViewClient;", "enableMinimize", "enableWvSHA1", "finish", "", "forceUseOriWebViewUI", "initTmplWebView", "isFastLoadPage", "isWebViewPreloaded", "needInvokePageFinished", "notifyPageInfo", "pageInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processCommonGetA8KeyFullUrl", "reqUrl", "fullUrl", "processGetA8Key", "data", "processGetA8KeyFail", "refreshWebView", "showBackBtnRes", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$StartGetA8KeyResult;", "url", "force", "updatePageAuth", "Companion", "TmplController", "plugin-brandservice_release"})
public class TmplWebViewToolUI extends WebViewUI {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(TmplWebViewToolUI.class), "openType", "getOpenType()I")), v.a(new t(v.aN(TmplWebViewToolUI.class), "session", "getSession()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;")), v.a(new t(v.aN(TmplWebViewToolUI.class), "tmplParams", "getTmplParams()Lcom/tencent/mm/plugin/webview/preload/TmplParams;"))};
    public static final a jUT = new a();
    private int jUG;
    private b jUH;
    private a jUI;
    private final a.f jUJ = i.g(new d(this));
    private final a.f jUK = i.g(new e(this));
    private final a.f jUL = i.g(new g(this));
    private boolean jUM;
    private boolean jUN;
    private String jUO;
    private Map<String, String> jUP;
    private boolean jUQ;
    private h jUR = new f(this);
    private boolean jUS = true;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$tempWebViewClient$1", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "canIntercept", "", "url", "", "doUpdateVisitedHistory", "", "view", "Lcom/tencent/xweb/WebView;", "isReload", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldInterceptRequest", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "plugin-brandservice_release"})
    public static final class f extends h {
        final /* synthetic */ TmplWebViewToolUI jVe;

        f(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super();
        }

        public final void a(WebView webView, String str, boolean z) {
            AppMethodBeat.i(15075);
            ab.i(TmplWebViewToolUI.b(this.jVe), "doUpdateVisitedHistory url:" + str + ", isReady:" + TmplWebViewToolUI.a(this.jVe).isReady());
            if (j.j(str, TmplWebViewToolUI.a(this.jVe).jVi)) {
                AppMethodBeat.o(15075);
                return;
            }
            if (this.jVe.jUQ) {
                this.jVe.jUQ = false;
                if (webView == null) {
                    j.dWJ();
                }
                webView.clearHistory();
            }
            super.a(webView, str, z);
            AppMethodBeat.o(15075);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(15076);
            ab.i(TmplWebViewToolUI.b(this.jVe), "onPageStarted url:" + str + ", isReady:" + TmplWebViewToolUI.a(this.jVe).isReady());
            if (j.j(str, TmplWebViewToolUI.a(this.jVe).jVi)) {
                s webViewClient = TmplWebViewToolUI.a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    webViewClient.b(webView, str, bitmap);
                    AppMethodBeat.o(15076);
                    return;
                }
                AppMethodBeat.o(15076);
                return;
            }
            if (this.jVe.uvY != null) {
                this.jVe.uvY.dcq();
                this.jVe.jUI = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a();
            }
            super.b(webView, str, bitmap);
            AppMethodBeat.o(15076);
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(15077);
            ab.i(TmplWebViewToolUI.b(this.jVe), "onPageFinished url:" + str + " isReady:" + TmplWebViewToolUI.a(this.jVe).isReady() + " state:" + TmplWebViewToolUI.a(this.jVe).getState());
            if (j.j(str, TmplWebViewToolUI.a(this.jVe).jVi)) {
                s webViewClient = TmplWebViewToolUI.a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    webViewClient.b(webView, str);
                    AppMethodBeat.o(15077);
                    return;
                }
                AppMethodBeat.o(15077);
                return;
            }
            super.b(webView, str);
            AppMethodBeat.o(15077);
        }

        private final boolean Gc(String str) {
            AppMethodBeat.i(15078);
            if (j.j(str, TmplWebViewToolUI.a(this.jVe).jVi) || u.jb(str, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix())) {
                AppMethodBeat.o(15078);
                return true;
            }
            AppMethodBeat.o(15078);
            return false;
        }

        public final o c(WebView webView, String str) {
            o c;
            AppMethodBeat.i(15079);
            j.p(webView, "view");
            j.p(str, "url");
            if (!this.jVe.jUM) {
                ab.v(TmplWebViewToolUI.b(this.jVe), "shouldInterceptRequest url:" + str + ", isReady:" + TmplWebViewToolUI.a(this.jVe).isReady());
                if (Gc(str)) {
                    s webViewClient = TmplWebViewToolUI.a(this.jVe).getWebViewClient();
                    if (webViewClient != null) {
                        c = webViewClient.c(webView, str);
                        AppMethodBeat.o(15079);
                        return c;
                    }
                    AppMethodBeat.o(15079);
                    return null;
                }
            }
            c = super.c(webView, str);
            AppMethodBeat.o(15079);
            return c;
        }

        public final o a(WebView webView, n nVar) {
            AppMethodBeat.i(15080);
            j.p(webView, "view");
            j.p(nVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            String uri = nVar.getUrl().toString();
            j.o(uri, "request.url.toString()");
            ab.v(TmplWebViewToolUI.b(this.jVe), "shouldInterceptRequest url:" + uri + ", isReady:" + TmplWebViewToolUI.a(this.jVe).isReady());
            o a;
            if (Gc(uri)) {
                s webViewClient = TmplWebViewToolUI.a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    a = webViewClient.a(webView, nVar);
                    AppMethodBeat.o(15080);
                    return a;
                }
                AppMethodBeat.o(15080);
                return null;
            }
            a = super.a(webView, nVar);
            AppMethodBeat.o(15080);
            return a;
        }

        public final o a(WebView webView, n nVar, Bundle bundle) {
            AppMethodBeat.i(15081);
            j.p(webView, "view");
            j.p(nVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            j.p(bundle, "bundle");
            String uri = nVar.getUrl().toString();
            j.o(uri, "request.url.toString()");
            ab.v(TmplWebViewToolUI.b(this.jVe), "shouldInterceptRequest url:" + uri + ", isReady:" + TmplWebViewToolUI.a(this.jVe).isReady());
            o a;
            if (Gc(uri)) {
                s webViewClient = TmplWebViewToolUI.a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    a = webViewClient.a(webView, nVar);
                    AppMethodBeat.o(15081);
                    return a;
                }
                AppMethodBeat.o(15081);
                return null;
            }
            a = super.a(webView, nVar, bundle);
            AppMethodBeat.o(15081);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<PreloadSession> {
        final /* synthetic */ TmplWebViewToolUI jVe;

        e(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15074);
            Parcelable parcelableExtra = this.jVe.getIntent().getParcelableExtra(m.ygq);
            if (parcelableExtra == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession");
                AppMethodBeat.o(15074);
                throw vVar;
            }
            PreloadSession preloadSession = (PreloadSession) parcelableExtra;
            AppMethodBeat.o(15074);
            return preloadSession;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "invoke"})
    static final class g extends a.f.b.k implements a.f.a.a<TmplParams> {
        final /* synthetic */ TmplWebViewToolUI jVe;

        g(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15082);
            TmplParams aYh = aYh();
            AppMethodBeat.o(15082);
            return aYh;
        }

        private TmplParams aYh() {
            AppMethodBeat.i(138517);
            TmplParams tmplParams;
            try {
                Parcelable parcelableExtra = this.jVe.getIntent().getParcelableExtra(m.yge);
                if (parcelableExtra == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.TmplParams");
                    AppMethodBeat.o(138517);
                    throw vVar;
                }
                tmplParams = (TmplParams) parcelableExtra;
                AppMethodBeat.o(138517);
                return tmplParams;
            } catch (Exception e) {
                String b = TmplWebViewToolUI.b(this.jVe);
                StringBuilder stringBuilder = new StringBuilder("tmplParam is null, ");
                Intent intent = this.jVe.getIntent();
                j.o(intent, "intent");
                ab.e(b, stringBuilder.append(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Q(intent)).toString());
                com.tencent.mm.plugin.webview.preload.a.IU(150);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(2);
                Intent intent2 = this.jVe.getIntent();
                j.o(intent2, "intent");
                objArr[1] = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Q(intent2);
                hVar.e(17260, objArr);
                this.jVe.finish();
                tmplParams = new TmplParams();
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u001bH\u0002J,\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180)H\u0016J\b\u0010*\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u000bH\u0016J\u001a\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010\u00182\u0006\u0010:\u001a\u00020\u000bH\u0016J\b\u0010;\u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020\u001bH\u0002J,\u0010>\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180)H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "webViewUI", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;)V", "TIMEOUT_TIME", "", "checkInjectDataRunnable", "Ljava/lang/Runnable;", "checkNotifyPageRunnable", "isNextWebViewPreloaded", "", "isUseDataCache", "isUsePreloadWebView", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "receivePageData", "", "showProgressBarRunnable", "startGetPageData", "startLoadPage", "getWebViewUI", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "adjustFullUrl", "", "fullUrl", "afterCreate", "", "beforeCreate", "checkNotifyPage", "createJsApiHandler", "createWebView", "createWebViewClient", "finishAllCheck", "fixProgressBar", "notifyPageInfo", "pageInfo", "preloadWebview", "processCommonGetA8KeyFullUrl", "reqUrl", "httpHeader", "", "processData", "processGetA8Key", "data", "Landroid/os/Bundle;", "processGetA8KeyFail", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processLongClick", "processReport", "removeShowProcess", "showBackBtnRes", "startGetA8Key", "url", "force", "supplyPageFinishInvoke", "tryPreloadNextWebView", "updateKV", "updatePageAuth", "plugin-brandservice_release"})
    final class b implements a {
        private long jUU;
        private boolean jUV;
        boolean jUW;
        final int jUX = 5000;
        final com.tencent.mm.plugin.brandservice.ui.timeline.preload.f jUY = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.f();
        final Runnable jUZ = new c(this);
        long jUd;
        long jUe;
        private final Runnable jVa = new d(this);
        final Runnable jVb = new i(this);
        private boolean jVc;
        final TmplWebViewToolUI jVd;
        final /* synthetic */ TmplWebViewToolUI jVe;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ b jVf;

            b(b bVar) {
                this.jVf = bVar;
            }

            public final void run() {
                AppMethodBeat.i(15048);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.o(15048);
                    return;
                }
                b.b(this.jVf);
                AppMethodBeat.o(15048);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ b jVf;

            c(b bVar) {
                this.jVf = bVar;
            }

            public final void run() {
                AppMethodBeat.i(15049);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.o(15049);
                    return;
                }
                boolean z = TmplWebViewToolUI.a(this.jVf.jVe).jUk;
                ab.i(TmplWebViewToolUI.b(this.jVf.jVe), "isInjectDataSuccess:".concat(String.valueOf(z)));
                if (!z) {
                    this.jVf.jUY.jSt = true;
                    TmplWebViewToolUI.f(this.jVf.jVe);
                }
                this.jVf.aYg();
                b.a(this.jVf);
                AppMethodBeat.o(15049);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class e implements Runnable {
            final /* synthetic */ b jVf;

            e(b bVar) {
                this.jVf = bVar;
            }

            public final void run() {
                AppMethodBeat.i(15051);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.o(15051);
                    return;
                }
                b.b(this.jVf);
                AppMethodBeat.o(15051);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ b jVf;

            d(b bVar) {
                this.jVf = bVar;
            }

            public final void run() {
                AppMethodBeat.i(15050);
                if (!TmplWebViewToolUI.a(this.jVf.jVe).jUl) {
                    com.tencent.mm.plugin.webview.preload.a.kT(92);
                    ab.e(TmplWebViewToolUI.b(this.jVf.jVe), "check notifyPage timeout");
                }
                AppMethodBeat.o(15050);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController$supplyPageFinishInvoke$1", "Ljava/lang/Runnable;", "run", "", "plugin-brandservice_release"})
        public static final class j implements Runnable {
            final /* synthetic */ b jVf;

            j(b bVar) {
                this.jVf = bVar;
            }

            /* JADX WARNING: Missing block: B:12:0x0039, code skipped:
            if (r0 == null) goto L_0x0060;
     */
            /* JADX WARNING: Missing block: B:13:0x003b, code skipped:
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.a(r4.jVf.jVe).getCurWebviewClient().b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.a(r4.jVf.jVe), com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.a(r4.jVf.jVe).getUrl());
     */
            /* JADX WARNING: Missing block: B:15:0x006c, code skipped:
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.a(r4.jVf.jVe).getDelayInitJsAPI() == false) goto L_0x0075;
     */
            /* JADX WARNING: Missing block: B:16:0x006e, code skipped:
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.j(r4.jVf.jVe);
     */
            /* JADX WARNING: Missing block: B:17:0x0075, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(15058);
     */
            /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(15058);
                Object obj = null;
                synchronized (this) {
                    try {
                        if (this.jVf.jVe.jUM) {
                        } else {
                            ab.i(TmplWebViewToolUI.b(this.jVf.jVe), "[supplyPageFinishInvoke]");
                            if (TmplWebViewToolUI.a(this.jVf.jVe) != null) {
                                this.jVf.jVe.uwp = false;
                                obj = 1;
                            }
                            y yVar = y.AUy;
                        }
                    } finally {
                        AppMethodBeat.o(15058);
                    }
                }
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.b<Integer, y> {
            final /* synthetic */ b jVf;

            a(b bVar) {
                this.jVf = bVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(15047);
                int intValue = ((Number) obj).intValue();
                ab.i(TmplWebViewToolUI.b(this.jVf.jVe), "onStateChange state:".concat(String.valueOf(intValue)));
                switch (intValue) {
                    case 2:
                        ab.w(TmplWebViewToolUI.b(this.jVf.jVe), "onReady success");
                        break;
                    case 4:
                        al.af(this.jVf.jUZ);
                        b.a(this.jVf);
                        break;
                    case 5:
                        al.d(new j(this.jVf));
                        break;
                    case 6:
                        ab.e(TmplWebViewToolUI.b(this.jVf.jVe), "onReady fail, forceUseOriWebViewUI");
                        this.jVf.jUY.jSt = true;
                        TmplWebViewToolUI.f(this.jVf.jVe);
                        break;
                }
                y yVar = y.AUy;
                AppMethodBeat.o(15047);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "context", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
        static final class g extends a.f.b.k implements q<WeakReference<Object>, com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.h, ef, y> {
            public static final g jVh = new g();

            static {
                AppMethodBeat.i(15055);
                AppMethodBeat.o(15055);
            }

            g() {
                super(3);
            }

            public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(15054);
                WeakReference weakReference = (WeakReference) obj;
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.h hVar = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.h) obj2;
                ef efVar = (ef) obj3;
                a.f.b.j.p(weakReference, "context");
                a.f.b.j.p(hVar, "result");
                a.f.b.j.p(efVar, "appMsgContext");
                Object obj4 = weakReference.get();
                if (obj4 == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.TmplController");
                    AppMethodBeat.o(15054);
                    throw vVar;
                }
                b bVar = (b) obj4;
                ab.v(TmplWebViewToolUI.b(bVar.jVe), "processGetAppContext");
                int i = TmplWebViewToolUI.c(bVar.jVd).upQ;
                bVar.jUW = hVar.jSU;
                com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(bVar.jVe).upQ, hVar.jSU ? 121 : 122);
                bVar.jUY.jRr = hVar.start;
                bVar.jUY.jRs = hVar.aZV;
                bVar.jUY.jRc = efVar.vFU;
                String a;
                if (hVar.jSU) {
                    bVar.jUe = System.currentTimeMillis();
                    bVar.jUY.jRq = bVar.jUe;
                    String d = TmplWebViewToolUI.d(bVar.jVe);
                    a.f.b.j.o(d, "getRawUrl()");
                    a = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(d, TmplWebViewToolUI.e(bVar.jVe));
                    al.n(bVar.jUZ, (long) bVar.jUX);
                    PreloadLogic.FO(a);
                    TmplWebViewToolUI.a(bVar.jVe).b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a(efVar), a, bVar.jUd, bVar.jUe);
                } else {
                    if (hVar.cxT) {
                        a = efVar.vFV;
                        b a2 = TmplWebViewToolUI.a(bVar.jVd);
                        com.tencent.mm.plugin.webview.preload.a.gu(i, 123);
                        if (a != null) {
                            boolean z;
                            if (u.ar(a)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                com.tencent.mm.plugin.webview.preload.a.gu(i, 120);
                                a2.loadUrl(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(a, TmplWebViewToolUI.e(bVar.jVe)));
                            }
                        }
                        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(efVar)) {
                            boolean z2;
                            com.tencent.mm.plugin.webview.preload.a.gu(i, 124);
                            bVar.jUe = System.currentTimeMillis();
                            bVar.jUY.jRq = bVar.jUe;
                            al.n(bVar.jUZ, (long) bVar.jUX);
                            a = TmplWebViewToolUI.d(bVar.jVe);
                            a.f.b.j.o(a, "url");
                            PreloadLogic.FO(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(a, TmplWebViewToolUI.e(bVar.jVe)));
                            com.tencent.mm.plugin.brandservice.ui.timeline.preload.f fVar = bVar.jUY;
                            if (a2.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a(efVar), com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(a, TmplWebViewToolUI.e(bVar.jVe)), bVar.jUd, bVar.jUe)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            fVar.jRU = z2;
                            bVar.jUY.jRW = hVar.jRW;
                        }
                    }
                    com.tencent.mm.plugin.webview.preload.a.gu(i, 125);
                    bVar.jUY.jSt = true;
                    TmplWebViewToolUI.f(bVar.jVe);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(15054);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "invoke"})
        static final class f extends a.f.b.k implements a.f.a.b<WeakReference<b>, y> {
            public static final f jVg = new f();

            static {
                AppMethodBeat.i(15053);
                AppMethodBeat.o(15053);
            }

            f() {
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(15052);
                WeakReference weakReference = (WeakReference) obj;
                a.f.b.j.p(weakReference, "it");
                b bVar = (b) weakReference.get();
                if (bVar != null) {
                    ab.v(TmplWebViewToolUI.b(bVar.jVe), "removeShowProcess");
                    al.af(bVar.jVb);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(15052);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class i implements Runnable {
            final /* synthetic */ b jVf;

            i(b bVar) {
                this.jVf = bVar;
            }

            public final void run() {
                AppMethodBeat.i(15057);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.o(15057);
                    return;
                }
                this.jVf.jVe.uuX.start();
                AppMethodBeat.o(15057);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        static final class h implements OnLongClickListener {
            final /* synthetic */ b jVf;

            h(b bVar) {
                this.jVf = bVar;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(15056);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.jVf.jUY.toString());
                com.tencent.mm.ui.base.h.J(this.jVf.jVe, stringBuilder.toString(), "");
                AppMethodBeat.o(15056);
                return true;
            }
        }

        public b(TmplWebViewToolUI tmplWebViewToolUI, TmplWebViewToolUI tmplWebViewToolUI2) {
            a.f.b.j.p(tmplWebViewToolUI2, "webViewUI");
            this.jVe = tmplWebViewToolUI;
            AppMethodBeat.i(15069);
            this.jVd = tmplWebViewToolUI2;
            AppMethodBeat.o(15069);
        }

        /* Access modifiers changed, original: final */
        public final void aYg() {
            AppMethodBeat.i(15060);
            this.jUY.jRD = TmplWebViewToolUI.g(this.jVe).ais("onCreate");
            this.jUY.jRE = TmplWebViewToolUI.g(this.jVe).ais("onUIInitStart");
            this.jUY.jRF = TmplWebViewToolUI.g(this.jVe).ais("onUIInitEnd");
            this.jUY.jRG = TmplWebViewToolUI.g(this.jVe).ais("onTryBindServiceStart");
            this.jUY.jRG = TmplWebViewToolUI.g(this.jVe).ais("onTryBindServiceEnd");
            this.jUY.jRH = TmplWebViewToolUI.g(this.jVe).ais("onPostBindedStart");
            this.jUY.jRI = TmplWebViewToolUI.g(this.jVe).ais("onPostBindedEnd");
            b a = TmplWebViewToolUI.a(this.jVe);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.f fVar = this.jUY;
            a.f.b.j.p(fVar, "kv");
            ab.v(a.getTAG(), "terry trace updateKV");
            fVar.jRx = a.getPerformanceHelper().ais("onInjectStart");
            fVar.jRy = a.getPerformanceHelper().ais("onInjectEnd");
            fVar.jRA = a.getPerformanceHelper().ais("onTmplLoadStart");
            fVar.jRB = a.getPerformanceHelper().ais("onTmplLoadEnd");
            fVar.jRv = a.getPerformanceHelper().ais("onCreateStart");
            fVar.jRw = a.getPerformanceHelper().ais("onCreateEnd");
            fVar.jRV = a.jUk;
            fVar.jRz = a.getPerformanceHelper().ais("onWebInjectEnd");
            String randomStr = a.getRandomStr();
            a.f.b.j.o(randomStr, "randomStr");
            a.f.b.j.p(randomStr, "<set-?>");
            fVar.key = randomStr;
            AppMethodBeat.o(15060);
        }

        public final void aXH() {
            int i;
            AppMethodBeat.i(15061);
            ab.i(TmplWebViewToolUI.b(this.jVe), "afterCreate isWebViewCreated:" + this.jUV + " state:" + TmplWebViewToolUI.a(this.jVe).getState());
            TmplWebViewToolUI.a(this.jVe).c((a.f.a.b) new a(this));
            if (this.jUV) {
                al.n(new b(this), 1000);
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.f fVar = this.jUY;
            TmplParams c = TmplWebViewToolUI.c(this.jVe);
            a.f.b.j.p(c, "<set-?>");
            fVar.jRb = c;
            fVar = this.jUY;
            String d = TmplWebViewToolUI.d(this.jVe);
            a.f.b.j.o(d, "getRawUrl()");
            a.f.b.j.p(d, "<set-?>");
            fVar.url = d;
            this.jUY.jRT = this.jUV;
            this.jUY.jRS = this.jUW;
            this.jUY.jSr = TmplWebViewToolUI.a(this.jVe).getWebCoreType().name();
            if (this.jUV) {
                i = 106;
            } else {
                i = 105;
            }
            com.tencent.mm.plugin.webview.preload.a.IU(i);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.FQ("use preloaded webview:true");
            AppMethodBeat.o(15061);
        }

        public final void FX(String str) {
            AppMethodBeat.i(15062);
            if (str != null && a.f.b.j.j(str, TmplWebViewToolUI.d(this.jVe))) {
                com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, 116);
                this.jUY.jRt = System.currentTimeMillis();
            }
            AppMethodBeat.o(15062);
        }

        public final void F(Bundle bundle) {
            AppMethodBeat.i(15063);
            a.f.b.j.p(bundle, "data");
            String string = bundle.getString("geta8key_result_full_url");
            if (string == null) {
                a.f.b.j.dWJ();
            }
            if (u.jb(string, "http://")) {
                this.jVe.icz.a(Gb(string), new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes")), new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1")));
            }
            AppMethodBeat.o(15063);
        }

        public final boolean a(String str, String str2, Map<String, String> map) {
            AppMethodBeat.i(15064);
            a.f.b.j.p(str, "reqUrl");
            a.f.b.j.p(str2, "fullUrl");
            a.f.b.j.p(map, "httpHeader");
            com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, com.tencent.view.d.MIC_ALPHA_ADJUST_REAL);
            this.jUY.jRu = System.currentTimeMillis();
            this.jUY.jSd = true;
            aYg();
            this.jUY.IF();
            b(str, str2, map);
            TmplWebViewToolUI.a(this.jVe).a(true, Gb(str2), TmplWebViewToolUI.e(this.jVe));
            this.jVe.uwI.afE(Gb(str2));
            AppMethodBeat.o(15064);
            return true;
        }

        public final void b(String str, String str2, Map<String, String> map) {
            AppMethodBeat.i(15065);
            a.f.b.j.p(str, "reqUrl");
            a.f.b.j.p(str2, "fullUrl");
            a.f.b.j.p(map, "httpHeader");
            ab.i(TmplWebViewToolUI.b(this.jVe), "[updatePageAuth]reqUrl:" + str + " fullUrl:" + str2 + " httpHeader:" + map);
            TmplWebViewToolUI.a(this.jVe).evaluateJavascript("history.replaceState({},\"\",\"" + Gb(str2) + "\");", null);
            p settings = TmplWebViewToolUI.a(this.jVe).getSettings();
            a.f.b.j.o(settings, "tmplWebView.settings");
            String userAgentString = settings.getUserAgentString();
            a.f.b.j.o(userAgentString, "tmplWebView.settings.userAgentString");
            map.put("User-agent", userAgentString);
            this.jVe.uhz.agm(new JSONObject(map).toString());
            this.jVe.uhz.agl(Uri.parse(str2).getQueryParameter("pass_ticket"));
            AppMethodBeat.o(15065);
        }

        private static String Gb(String str) {
            AppMethodBeat.i(15066);
            String c = new a.k.k("http://").c(str, "https://");
            AppMethodBeat.o(15066);
            return c;
        }

        public final void G(Bundle bundle) {
            AppMethodBeat.i(15067);
            a.f.b.j.p(bundle, "data");
            com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, 118);
            this.jUY.jRu = System.currentTimeMillis();
            b.a(TmplWebViewToolUI.a(this.jVe), "");
            if (this.jVe.uwh != null) {
                View n = this.jVe.uwh;
                a.f.b.j.o(n, "this@TmplWebViewToolUI.refreshMask");
                n.setVisibility(8);
            }
            AppMethodBeat.o(15067);
        }

        public final boolean aXI() {
            return true;
        }

        public final boolean aXJ() {
            return true;
        }

        public final boolean aXK() {
            return true;
        }

        public final void FY(String str) {
            AppMethodBeat.i(15068);
            a.f.b.j.p(str, "pageInfo");
            ab.i(TmplWebViewToolUI.b(this.jVe), "[notifyPageInfo]pageInfo:".concat(String.valueOf(str)));
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("performance"));
                long j = jSONObject2.getLong("compileTime");
                long j2 = jSONObject2.getLong("receivePageDataTimestamp");
                long j3 = jSONObject2.getLong("firstScreenTimestamp");
                long j4 = jSONObject2.getLong("firstScreenTime");
                this.jUY.jRn = j;
                this.jUY.jRo = j2;
                this.jUY.jRk = j3;
                this.jUY.jRm = j4;
                String optString = jSONObject.optString("injectPageDataResult", "fail");
                aYg();
                if (a.f.b.j.j(optString, "ok")) {
                    TmplWebViewToolUI.a(this.jVe).setNotifyPageSuccess(true);
                    this.jUY.jSe = true;
                    al.af(this.jUZ);
                    al.af(this.jVa);
                    this.jUY.IF();
                    com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, 131);
                    com.tencent.mm.plugin.webview.preload.a.IU(108);
                } else {
                    this.jUY.jSt = true;
                    TmplWebViewToolUI.f(this.jVe);
                }
            } catch (JSONException e) {
                ab.printErrStackTrace(TmplWebViewToolUI.b(this.jVe), e, "", new Object[0]);
                this.jUY.jSt = true;
                TmplWebViewToolUI.f(this.jVe);
            }
            this.jUY.jRC = System.currentTimeMillis();
            al.n(new e(this), 300);
            AppMethodBeat.o(15068);
        }

        public final boolean aXL() {
            return true;
        }

        public final void aXG() {
            b bVar;
            boolean z = false;
            AppMethodBeat.i(15059);
            this.jVe.getIntent().putExtra("show_native_web_view", true);
            al.n(this.jVb, 500);
            b bVar2 = (b) c.a((Context) this.jVe, TmplWebViewToolUI.c(this.jVe));
            if (bVar2 == null) {
                MMWebView b = c.b((Context) this.jVe, TmplWebViewToolUI.c(this.jVe));
                if (b == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebView");
                    AppMethodBeat.o(15059);
                    throw vVar;
                }
                bVar2 = (b) b;
                this.jUV = false;
                com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, 111);
                bVar = bVar2;
            } else {
                boolean z2;
                if (bVar2.getState() >= 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.jUV = z2;
                com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, 110);
                bVar = bVar2;
            }
            if (com.tencent.mm.plugin.webview.ui.tools.jsapi.f.c((WebView) bVar)) {
                com.tencent.mm.plugin.webview.preload.a.IU(112);
            }
            TmplWebViewToolUI tmplWebViewToolUI = this.jVe;
            if (bVar == null) {
                a.f.b.j.dWJ();
            }
            TmplWebViewToolUI.a(tmplWebViewToolUI, bVar);
            b a = TmplWebViewToolUI.a(this.jVe);
            a.f.a.b bVar3 = f.jVg;
            a.f.b.j.p(this, "context");
            a.f.b.j.p(bVar3, "callback");
            if (a.jUm) {
                bVar3.am(new WeakReference(this));
            } else {
                a.jUn = new d(bVar3, this);
            }
            ab.v(TmplWebViewToolUI.b(this.jVe), "processData");
            this.jUU = System.currentTimeMillis();
            this.jUd = this.jVe.getIntent().getLongExtra(m.ygg, 0);
            com.tencent.mm.kernel.b.g Rn = com.tencent.mm.kernel.g.RM().Rn();
            a.f.b.j.o(Rn, "MMKernel.process().current()");
            com.tencent.mm.kernel.b.g.a SF = ((com.tencent.mm.kernel.b.h) Rn).SF();
            String stringExtra = this.jVe.getIntent().getStringExtra(m.ygi);
            if (stringExtra == null) {
                String b2 = TmplWebViewToolUI.b(this.jVe);
                StringBuilder stringBuilder = new StringBuilder("dataKey is null, ");
                Intent intent = this.jVe.getIntent();
                a.f.b.j.o(intent, "intent");
                ab.e(b2, stringBuilder.append(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Q(intent)).toString());
                com.tencent.mm.plugin.webview.preload.a.IU(151);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(1);
                Intent intent2 = this.jVe.getIntent();
                a.f.b.j.o(intent2, "intent");
                objArr[1] = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Q(intent2);
                hVar.e(17260, objArr);
                this.jVe.finish();
            } else {
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.f fVar = this.jUY;
                if (SF.eMy < this.jUd) {
                    z = true;
                }
                fVar.jSb = z;
                com.tencent.mm.plugin.webview.preload.a.IU(this.jUY.jSb ? 104 : 103);
                switch (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.a(this.jVe.getIntent().getIntExtra(m.ygn, -1), this.jUd, Process.myPid(), SF.eMq)) {
                    case 1:
                        this.jUY.jSc = 1;
                        this.jUd = SF.eMq;
                        break;
                    case 2:
                        this.jUY.jSc = 2;
                        this.jUd = -1;
                        break;
                }
                this.jUY.jRX = TmplWebViewToolUI.e(this.jVe).jTb;
                this.jUY.jRY = TmplWebViewToolUI.e(this.jVe).jTc;
                this.jUY.jRZ = com.tencent.mm.plugin.webview.ui.tools.jsapi.f.c((WebView) TmplWebViewToolUI.a(this.jVe));
                this.jUY.jSa = TmplWebViewToolUI.e(this.jVe).jSa;
                this.jUY.jRJ = SF.eMq;
                this.jUY.jRK = SF.eMr;
                this.jUY.jRL = SF.eMs;
                this.jUY.jRM = SF.eMt;
                this.jUY.jRN = SF.eMu;
                this.jUY.jRO = SF.eMv;
                this.jUY.jRP = SF.eMw;
                this.jUY.jRQ = SF.eMx;
                this.jUY.jRR = SF.eMy;
                this.jUY.jRj = this.jUd;
                this.jUY.jRp = this.jUU;
                this.jUY.jSu = TmplWebViewToolUI.e(this.jVe).jSu;
                PreloadLogic.jSS.a((Object) this, stringExtra, TmplWebViewToolUI.e(this.jVe), (q) g.jVh);
            }
            if (com.tencent.mm.sdk.platformtools.f.DEBUG || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || 1 >= ab.getLogLevel()) {
                this.jVe.uxc = new h(this);
            }
            AppMethodBeat.o(15059);
        }

        public static final /* synthetic */ void a(b bVar) {
            AppMethodBeat.i(15070);
            if (TmplWebViewToolUI.a(bVar.jVe).jUk && !TmplWebViewToolUI.a(bVar.jVe).jUl) {
                ab.i(TmplWebViewToolUI.b(bVar.jVe), "check notifyPage");
                al.n(bVar.jVa, 3000);
            }
            AppMethodBeat.o(15070);
        }

        /* JADX WARNING: Missing block: B:10:0x0016, code skipped:
            r0 = r5.jVe.getIntent().getBooleanExtra(com.tencent.mm.ui.e.m.ygf, true);
            com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.b(r5.jVe), "[preloadNextWebView] ".concat(java.lang.String.valueOf(r0)));
     */
        /* JADX WARNING: Missing block: B:11:0x0036, code skipped:
            if (r0 == false) goto L_0x003b;
     */
        /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.aVR();
     */
        /* JADX WARNING: Missing block: B:13:0x003b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(15071);
     */
        /* JADX WARNING: Missing block: B:17:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void b(b bVar) {
            AppMethodBeat.i(15071);
            synchronized (bVar) {
                try {
                    if (bVar.jVc) {
                    } else {
                        bVar.jVc = true;
                        y yVar = y.AUy;
                    }
                } finally {
                    AppMethodBeat.o(15071);
                }
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ TmplWebViewToolUI jVe;

        d(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15073);
            Integer valueOf = Integer.valueOf(this.jVe.getIntent().getIntExtra(m.ygp, -1));
            AppMethodBeat.o(15073);
            return valueOf;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$Companion;", "", "()V", "SHOW_PROGRESS_TIME", "", "rawTAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ TmplWebViewToolUI jVe;

        c(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
        }

        public final void run() {
            AppMethodBeat.i(15072);
            if (this.jVe.jUM) {
                AppMethodBeat.o(15072);
                return;
            }
            ab.i(TmplWebViewToolUI.b(this.jVe), "forceUseOriWebViewUI() isA8KeyDone:" + this.jVe.jUN);
            if (!(TmplWebViewToolUI.q(this.jVe) instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a)) {
                com.tencent.mm.plugin.webview.preload.a.gu(TmplWebViewToolUI.c(this.jVe).upQ, 137);
                this.jVe.jUI = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a();
                if (this.jVe.jUN) {
                    ab.i(TmplWebViewToolUI.b(this.jVe), "forceUseOriWebViewUI()");
                    if (this.jVe.uvY != null) {
                        this.jVe.uvY.dcq();
                        this.jVe.jUI = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a();
                    }
                    String s = this.jVe.jUO;
                    if (s != null) {
                        s = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.G(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.dh(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.dh(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.dh(s, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
                    } else {
                        s = null;
                    }
                    if (this.jVe.jUP != null) {
                        TmplWebViewToolUI.a(this.jVe).loadUrl(s, this.jVe.jUP);
                        AppMethodBeat.o(15072);
                        return;
                    }
                    TmplWebViewToolUI.a(this.jVe).loadUrl(s);
                }
            }
            AppMethodBeat.o(15072);
        }
    }

    static {
        AppMethodBeat.i(15083);
        AppMethodBeat.o(15083);
    }

    private final TmplParams aWY() {
        AppMethodBeat.i(15086);
        TmplParams tmplParams = (TmplParams) this.jUL.getValue();
        AppMethodBeat.o(15086);
        return tmplParams;
    }

    private final int aXV() {
        AppMethodBeat.i(15085);
        int intValue = ((Number) this.jUJ.getValue()).intValue();
        AppMethodBeat.o(15085);
        return intValue;
    }

    private final PreloadSession aXW() {
        AppMethodBeat.i(138518);
        PreloadSession preloadSession = (PreloadSession) this.jUK.getValue();
        AppMethodBeat.o(138518);
        return preloadSession;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TmplWebViewToolUI() {
        AppMethodBeat.i(15101);
        AppMethodBeat.o(15101);
    }

    public static final /* synthetic */ b a(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15102);
        b bVar = tmplWebViewToolUI.jUH;
        if (bVar == null) {
            j.avw("tmplWebView");
        }
        AppMethodBeat.o(15102);
        return bVar;
    }

    public static final /* synthetic */ String b(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15103);
        String tag = tmplWebViewToolUI.getTAG();
        AppMethodBeat.o(15103);
        return tag;
    }

    public static final /* synthetic */ TmplParams c(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15104);
        TmplParams aWY = tmplWebViewToolUI.aWY();
        AppMethodBeat.o(15104);
        return aWY;
    }

    public static final /* synthetic */ String d(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15106);
        String cWL = tmplWebViewToolUI.cWL();
        AppMethodBeat.o(15106);
        return cWL;
    }

    public static final /* synthetic */ PreloadSession e(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15107);
        PreloadSession aXW = tmplWebViewToolUI.aXW();
        AppMethodBeat.o(15107);
        return aXW;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.webview.e.d g(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15109);
        com.tencent.mm.plugin.webview.e.d cZW = tmplWebViewToolUI.cZW();
        AppMethodBeat.o(15109);
        return cZW;
    }

    public static final /* synthetic */ void j(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15110);
        tmplWebViewToolUI.daf();
        AppMethodBeat.o(15110);
    }

    public static final /* synthetic */ a q(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15111);
        a aVar = tmplWebViewToolUI.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        AppMethodBeat.o(15111);
        return aVar;
    }

    private final String getTAG() {
        AppMethodBeat.i(15084);
        String str = "MicroMsg.TmplWebViewToolUI:" + this.jUG;
        AppMethodBeat.o(15084);
        return str;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(15087);
        if (aWY().jSV == -1 || bo.isNullOrNil(aWY().upO)) {
            ab.i(getTAG(), "initTmpl() tmplParams is null");
            this.jUI = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a();
            com.tencent.mm.plugin.webview.preload.a.kT(109);
            com.tencent.mm.plugin.webview.preload.a.IU(101);
        } else {
            ab.i(getTAG(), "initTmpl() TmplController");
            this.jUI = new b(this, this);
        }
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.aXG();
        super.onCreate(bundle);
        aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.aXH();
        AppMethodBeat.o(15087);
    }

    public void finish() {
        AppMethodBeat.i(15088);
        super.finish();
        if (aXV() != -1 && aXV() == 1) {
            daG();
        }
        AppMethodBeat.o(15088);
    }

    public final MMWebView aXX() {
        AppMethodBeat.i(15089);
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        MMWebView mMWebView;
        if (aVar.aXI()) {
            b bVar = this.jUH;
            if (bVar == null) {
                j.avw("tmplWebView");
            }
            mMWebView = bVar;
            AppMethodBeat.o(15089);
            return mMWebView;
        }
        mMWebView = super.aXX();
        AppMethodBeat.o(15089);
        return mMWebView;
    }

    public void onDestroy() {
        AppMethodBeat.i(15090);
        this.jUM = true;
        super.onDestroy();
        AppMethodBeat.o(15090);
    }

    public final w as(String str, boolean z) {
        w wVar;
        AppMethodBeat.i(15091);
        j.p(str, "url");
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.FX(str);
        aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        if ((aVar instanceof b) && j.j(str, cWL())) {
            Bundle FZ = d.FZ(str);
            if (!(FZ == null || at.isConnected(ah.getContext()))) {
                this.uwI.utI = true;
                H(FZ);
                b bVar = this.jUH;
                if (bVar == null) {
                    j.avw("tmplWebView");
                }
                b.a(bVar, "");
                wVar = w.NO_NEED;
                AppMethodBeat.o(15091);
                return wVar;
            }
        }
        wVar = super.as(str, z);
        j.o(wVar, "super.startGetA8Key(url, force)");
        AppMethodBeat.o(15091);
        return wVar;
    }

    public final boolean H(Bundle bundle) {
        AppMethodBeat.i(15092);
        j.p(bundle, "data");
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.F(bundle);
        String string = bundle.getString("geta8key_result_req_url");
        a aVar2 = this.jUI;
        if (aVar2 == null) {
            j.avw("tmplController");
        }
        if ((aVar2 instanceof b) && string != null && j.j(string, cWL())) {
            d.m(string, bundle);
        }
        boolean H = super.H(bundle);
        AppMethodBeat.o(15092);
        return H;
    }

    public final void c(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(15093);
        j.p(str, "reqUrl");
        j.p(str2, "fullUrl");
        j.p(map, "httpHeader");
        ab.v(getTAG(), "processCommonGetA8KeyFullUrl:".concat(String.valueOf(str)));
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        if (aVar.a(str, str2, map)) {
            this.jUN = true;
            this.jUO = str2;
            this.jUP = map;
            AppMethodBeat.o(15093);
            return;
        }
        super.c(str, str2, map);
        AppMethodBeat.o(15093);
    }

    public final void b(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(15094);
        j.p(str, "reqUrl");
        j.p(str2, "fullUrl");
        j.p(map, "httpHeader");
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.b(str, str2, map);
        com.tencent.mm.plugin.webview.preload.a.IU(109);
        AppMethodBeat.o(15094);
    }

    public final void G(Bundle bundle) {
        AppMethodBeat.i(15095);
        j.p(bundle, "data");
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.G(bundle);
        AppMethodBeat.o(15095);
    }

    public final com.tencent.mm.plugin.webview.ui.tools.jsapi.d aXY() {
        AppMethodBeat.i(15096);
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d jsApiHandler;
        if (aVar.aXJ()) {
            b bVar = this.jUH;
            if (bVar == null) {
                j.avw("tmplWebView");
            }
            bVar.getJsApiHandler().e(this.icy);
            bVar = this.jUH;
            if (bVar == null) {
                j.avw("tmplWebView");
            }
            bVar.getJsApiHandler().JJ(hashCode());
            bVar = this.jUH;
            if (bVar == null) {
                j.avw("tmplWebView");
            }
            bVar.getJsApiHandler().a(this.icz);
            com.tencent.mm.plugin.webview.ui.tools.k kVar = this.icz;
            b bVar2 = this.jUH;
            if (bVar2 == null) {
                j.avw("tmplWebView");
            }
            kVar.a(bVar2.jVi, JsapiPermissionWrapper.vxI, GeneralControlWrapper.vxF);
            bVar = this.jUH;
            if (bVar == null) {
                j.avw("tmplWebView");
            }
            jsApiHandler = bVar.getJsApiHandler();
            j.o(jsApiHandler, "tmplWebView.jsApiHandler");
            AppMethodBeat.o(15096);
            return jsApiHandler;
        }
        jsApiHandler = super.aXY();
        j.o(jsApiHandler, "super.createJsApiHandler()");
        AppMethodBeat.o(15096);
        return jsApiHandler;
    }

    public final s aXZ() {
        AppMethodBeat.i(15097);
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        s sVar;
        if (aVar.aXK()) {
            sVar = this.jUR;
            AppMethodBeat.o(15097);
            return sVar;
        }
        sVar = super.aXZ();
        j.o(sVar, "super.createWebViewClient()");
        AppMethodBeat.o(15097);
        return sVar;
    }

    public final boolean aXL() {
        AppMethodBeat.i(15098);
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        if (aVar.aXL()) {
            AppMethodBeat.o(15098);
            return false;
        }
        boolean aXL = super.aXL();
        AppMethodBeat.o(15098);
        return aXL;
    }

    public final boolean aYa() {
        return false;
    }

    public final boolean aYb() {
        return false;
    }

    public final boolean aYc() {
        return true;
    }

    public final boolean aYd() {
        return true;
    }

    public final void FY(String str) {
        AppMethodBeat.i(15099);
        j.p(str, "pageInfo");
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        aVar.FY(str);
        AppMethodBeat.o(15099);
    }

    public final void aYe() {
        AppMethodBeat.i(15100);
        a aVar = this.jUI;
        if (aVar == null) {
            j.avw("tmplController");
        }
        if (aVar instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a) {
            super.aYe();
            AppMethodBeat.o(15100);
            return;
        }
        this.jUS = false;
        this.jUI = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.a();
        String cWL = cWL();
        j.o(cWL, "getRawUrl()");
        as(cWL, true);
        this.jUQ = true;
        AppMethodBeat.o(15100);
    }

    public final boolean aYf() {
        return this.jUS;
    }

    public static final /* synthetic */ void f(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(15108);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.jSD;
        if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXk()) {
            tmplWebViewToolUI.jUS = false;
            com.tencent.mm.plugin.webview.preload.a.IU(102);
            al.d(new c(tmplWebViewToolUI));
        }
        AppMethodBeat.o(15108);
    }
}
