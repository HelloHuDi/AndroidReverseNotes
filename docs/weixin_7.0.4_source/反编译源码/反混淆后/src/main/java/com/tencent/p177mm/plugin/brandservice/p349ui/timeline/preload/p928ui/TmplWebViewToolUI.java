package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui;

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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C1681g.C1680a;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C20086l;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2702b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2710d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2712f;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g.C33740a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C38710j;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.C20072h;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C27554a.C27555a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C44724b.C20091d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p1068e.C44781d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C14579h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C16953w;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.C40515ef;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36589p;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C25274k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 L2\u00020\u0001:\u0002LMB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0014J\n\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020\nH\u0014J\b\u00101\u001a\u00020\nH\u0014J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0002J\u0010\u00105\u001a\u0002032\u0006\u0010'\u001a\u00020(H\u0002J\b\u00106\u001a\u00020\nH\u0014J\b\u00107\u001a\u00020\nH\u0014J\b\u00108\u001a\u00020\nH\u0014J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u0004H\u0014J\u0012\u0010;\u001a\u0002032\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u000203H\u0014J,\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0014J\u0010\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020=H\u0014J\u0010\u0010D\u001a\u0002032\u0006\u0010C\u001a\u00020=H\u0014J\b\u0010E\u001a\u000203H\u0014J\b\u0010F\u001a\u00020\nH\u0014J\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\nH\u0014J,\u0010K\u001a\u0002032\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00060\u001bR\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "httpHeader", "", "isA8KeyDone", "", "isDestroied", "isRefreshWebViewByGetA8Key", "isTmplWebView", "openType", "", "getOpenType", "()I", "openType$delegate", "Lkotlin/Lazy;", "pfullUrl", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "getSession", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "session$delegate", "tempWebViewClient", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "getTempWebViewClient", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "setTempWebViewClient", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;)V", "tmplController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "tmplParams$delegate", "tmplWebView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "tmplWebViewId", "createJsApiHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiHandler;", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewClient", "Lcom/tencent/xweb/WebViewClient;", "enableMinimize", "enableWvSHA1", "finish", "", "forceUseOriWebViewUI", "initTmplWebView", "isFastLoadPage", "isWebViewPreloaded", "needInvokePageFinished", "notifyPageInfo", "pageInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processCommonGetA8KeyFullUrl", "reqUrl", "fullUrl", "processGetA8Key", "data", "processGetA8KeyFail", "refreshWebView", "showBackBtnRes", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$StartGetA8KeyResult;", "url", "force", "updatePageAuth", "Companion", "TmplController", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI */
public class TmplWebViewToolUI extends WebViewUI {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(TmplWebViewToolUI.class), "openType", "getOpenType()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(TmplWebViewToolUI.class), "session", "getSession()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(TmplWebViewToolUI.class), "tmplParams", "getTmplParams()Lcom/tencent/mm/plugin/webview/preload/TmplParams;"))};
    public static final C27552a jUT = new C27552a();
    private int jUG;
    private C44724b jUH;
    private C27554a jUI;
    private final C44856f jUJ = C17344i.m26854g(new C27551d(this));
    private final C44856f jUK = C17344i.m26854g(new C27543e(this));
    private final C44856f jUL = C17344i.m26854g(new C27544g(this));
    private boolean jUM;
    private boolean jUN;
    private String jUO;
    private Map<String, String> jUP;
    private boolean jUQ;
    private C14579h jUR = new C20088f(this);
    private boolean jUS = true;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$tempWebViewClient$1", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "canIntercept", "", "url", "", "doUpdateVisitedHistory", "", "view", "Lcom/tencent/xweb/WebView;", "isReload", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldInterceptRequest", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$f */
    public static final class C20088f extends C14579h {
        final /* synthetic */ TmplWebViewToolUI jVe;

        C20088f(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super();
        }

        /* renamed from: a */
        public final void mo26819a(WebView webView, String str, boolean z) {
            AppMethodBeat.m2504i(15075);
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "doUpdateVisitedHistory url:" + str + ", isReady:" + TmplWebViewToolUI.m43712a(this.jVe).isReady());
            if (C25052j.m39373j(str, TmplWebViewToolUI.m43712a(this.jVe).jVi)) {
                AppMethodBeat.m2505o(15075);
                return;
            }
            if (this.jVe.jUQ) {
                this.jVe.jUQ = false;
                if (webView == null) {
                    C25052j.dWJ();
                }
                webView.clearHistory();
            }
            super.mo26819a(webView, str, z);
            AppMethodBeat.m2505o(15075);
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(15076);
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "onPageStarted url:" + str + ", isReady:" + TmplWebViewToolUI.m43712a(this.jVe).isReady());
            if (C25052j.m39373j(str, TmplWebViewToolUI.m43712a(this.jVe).jVi)) {
                C36592s webViewClient = TmplWebViewToolUI.m43712a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    webViewClient.mo7562b(webView, str, bitmap);
                    AppMethodBeat.m2505o(15076);
                    return;
                }
                AppMethodBeat.m2505o(15076);
                return;
            }
            if (this.jVe.uvY != null) {
                this.jVe.uvY.dcq();
                this.jVe.jUI = new C27555a();
            }
            super.mo7562b(webView, str, bitmap);
            AppMethodBeat.m2505o(15076);
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(15077);
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "onPageFinished url:" + str + " isReady:" + TmplWebViewToolUI.m43712a(this.jVe).isReady() + " state:" + TmplWebViewToolUI.m43712a(this.jVe).getState());
            if (C25052j.m39373j(str, TmplWebViewToolUI.m43712a(this.jVe).jVi)) {
                C36592s webViewClient = TmplWebViewToolUI.m43712a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    webViewClient.mo5992b(webView, str);
                    AppMethodBeat.m2505o(15077);
                    return;
                }
                AppMethodBeat.m2505o(15077);
                return;
            }
            super.mo5992b(webView, str);
            AppMethodBeat.m2505o(15077);
        }

        /* renamed from: Gc */
        private final boolean m31087Gc(String str) {
            AppMethodBeat.m2504i(15078);
            if (C25052j.m39373j(str, TmplWebViewToolUI.m43712a(this.jVe).jVi) || C6163u.m9839jb(str, C20082b.getPrefix())) {
                AppMethodBeat.m2505o(15078);
                return true;
            }
            AppMethodBeat.m2505o(15078);
            return false;
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            C31147o c;
            AppMethodBeat.m2504i(15079);
            C25052j.m39376p(webView, "view");
            C25052j.m39376p(str, "url");
            if (!this.jVe.jUM) {
                C4990ab.m7418v(TmplWebViewToolUI.m43716b(this.jVe), "shouldInterceptRequest url:" + str + ", isReady:" + TmplWebViewToolUI.m43712a(this.jVe).isReady());
                if (m31087Gc(str)) {
                    C36592s webViewClient = TmplWebViewToolUI.m43712a(this.jVe).getWebViewClient();
                    if (webViewClient != null) {
                        c = webViewClient.mo5993c(webView, str);
                        AppMethodBeat.m2505o(15079);
                        return c;
                    }
                    AppMethodBeat.m2505o(15079);
                    return null;
                }
            }
            c = super.mo5993c(webView, str);
            AppMethodBeat.m2505o(15079);
            return c;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(15080);
            C25052j.m39376p(webView, "view");
            C25052j.m39376p(c24530n, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            String uri = c24530n.getUrl().toString();
            C25052j.m39375o(uri, "request.url.toString()");
            C4990ab.m7418v(TmplWebViewToolUI.m43716b(this.jVe), "shouldInterceptRequest url:" + uri + ", isReady:" + TmplWebViewToolUI.m43712a(this.jVe).isReady());
            C31147o a;
            if (m31087Gc(uri)) {
                C36592s webViewClient = TmplWebViewToolUI.m43712a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    a = webViewClient.mo5990a(webView, c24530n);
                    AppMethodBeat.m2505o(15080);
                    return a;
                }
                AppMethodBeat.m2505o(15080);
                return null;
            }
            a = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(15080);
            return a;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(15081);
            C25052j.m39376p(webView, "view");
            C25052j.m39376p(c24530n, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            C25052j.m39376p(bundle, "bundle");
            String uri = c24530n.getUrl().toString();
            C25052j.m39375o(uri, "request.url.toString()");
            C4990ab.m7418v(TmplWebViewToolUI.m43716b(this.jVe), "shouldInterceptRequest url:" + uri + ", isReady:" + TmplWebViewToolUI.m43712a(this.jVe).isReady());
            C31147o a;
            if (m31087Gc(uri)) {
                C36592s webViewClient = TmplWebViewToolUI.m43712a(this.jVe).getWebViewClient();
                if (webViewClient != null) {
                    a = webViewClient.mo5990a(webView, c24530n);
                    AppMethodBeat.m2505o(15081);
                    return a;
                }
                AppMethodBeat.m2505o(15081);
                return null;
            }
            a = super.mo5991a(webView, c24530n, bundle);
            AppMethodBeat.m2505o(15081);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$e */
    static final class C27543e extends C25053k implements C31214a<PreloadSession> {
        final /* synthetic */ TmplWebViewToolUI jVe;

        C27543e(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15074);
            Parcelable parcelableExtra = this.jVe.getIntent().getParcelableExtra(C5506m.ygq);
            if (parcelableExtra == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession");
                AppMethodBeat.m2505o(15074);
                throw c44941v;
            }
            PreloadSession preloadSession = (PreloadSession) parcelableExtra;
            AppMethodBeat.m2505o(15074);
            return preloadSession;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$g */
    static final class C27544g extends C25053k implements C31214a<TmplParams> {
        final /* synthetic */ TmplWebViewToolUI jVe;

        C27544g(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15082);
            TmplParams aYh = aYh();
            AppMethodBeat.m2505o(15082);
            return aYh;
        }

        private TmplParams aYh() {
            AppMethodBeat.m2504i(138517);
            TmplParams tmplParams;
            try {
                Parcelable parcelableExtra = this.jVe.getIntent().getParcelableExtra(C5506m.yge);
                if (parcelableExtra == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.TmplParams");
                    AppMethodBeat.m2505o(138517);
                    throw c44941v;
                }
                tmplParams = (TmplParams) parcelableExtra;
                AppMethodBeat.m2505o(138517);
                return tmplParams;
            } catch (Exception e) {
                String b = TmplWebViewToolUI.m43716b(this.jVe);
                StringBuilder stringBuilder = new StringBuilder("tmplParam is null, ");
                Intent intent = this.jVe.getIntent();
                C25052j.m39375o(intent, "intent");
                C4990ab.m7412e(b, stringBuilder.append(C2710d.m4954Q(intent)).toString());
                C43924a.m78788IU(150);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(2);
                Intent intent2 = this.jVe.getIntent();
                C25052j.m39375o(intent2, "intent");
                objArr[1] = C2710d.m4954Q(intent2);
                c7060h.mo8381e(17260, objArr);
                this.jVe.finish();
                tmplParams = new TmplParams();
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u001bH\u0002J,\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180)H\u0016J\b\u0010*\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u000bH\u0016J\u001a\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010\u00182\u0006\u0010:\u001a\u00020\u000bH\u0016J\b\u0010;\u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020\u001bH\u0002J,\u0010>\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180)H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "webViewUI", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;)V", "TIMEOUT_TIME", "", "checkInjectDataRunnable", "Ljava/lang/Runnable;", "checkNotifyPageRunnable", "isNextWebViewPreloaded", "", "isUseDataCache", "isUsePreloadWebView", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "receivePageData", "", "showProgressBarRunnable", "startGetPageData", "startLoadPage", "getWebViewUI", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "adjustFullUrl", "", "fullUrl", "afterCreate", "", "beforeCreate", "checkNotifyPage", "createJsApiHandler", "createWebView", "createWebViewClient", "finishAllCheck", "fixProgressBar", "notifyPageInfo", "pageInfo", "preloadWebview", "processCommonGetA8KeyFullUrl", "reqUrl", "httpHeader", "", "processData", "processGetA8Key", "data", "Landroid/os/Bundle;", "processGetA8KeyFail", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processLongClick", "processReport", "removeShowProcess", "showBackBtnRes", "startGetA8Key", "url", "force", "supplyPageFinishInvoke", "tryPreloadNextWebView", "updateKV", "updatePageAuth", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b */
    final class C27545b implements C27554a {
        private long jUU;
        private boolean jUV;
        boolean jUW;
        final int jUX = 5000;
        final C2712f jUY = new C2712f();
        final Runnable jUZ = new C11255c(this);
        long jUd;
        long jUe;
        private final Runnable jVa = new C27541d(this);
        final Runnable jVb = new C27549i(this);
        private boolean jVc;
        final TmplWebViewToolUI jVd;
        final /* synthetic */ TmplWebViewToolUI jVe;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$b */
        static final class C11254b implements Runnable {
            final /* synthetic */ C27545b jVf;

            C11254b(C27545b c27545b) {
                this.jVf = c27545b;
            }

            public final void run() {
                AppMethodBeat.m2504i(15048);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.m2505o(15048);
                    return;
                }
                C27545b.m43745b(this.jVf);
                AppMethodBeat.m2505o(15048);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$c */
        static final class C11255c implements Runnable {
            final /* synthetic */ C27545b jVf;

            C11255c(C27545b c27545b) {
                this.jVf = c27545b;
            }

            public final void run() {
                AppMethodBeat.m2504i(15049);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.m2505o(15049);
                    return;
                }
                boolean z = TmplWebViewToolUI.m43712a(this.jVf.jVe).jUk;
                C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVf.jVe), "isInjectDataSuccess:".concat(String.valueOf(z)));
                if (!z) {
                    this.jVf.jUY.jSt = true;
                    TmplWebViewToolUI.m43720f(this.jVf.jVe);
                }
                this.jVf.aYg();
                C27545b.m43744a(this.jVf);
                AppMethodBeat.m2505o(15049);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$e */
        static final class C11256e implements Runnable {
            final /* synthetic */ C27545b jVf;

            C11256e(C27545b c27545b) {
                this.jVf = c27545b;
            }

            public final void run() {
                AppMethodBeat.m2504i(15051);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.m2505o(15051);
                    return;
                }
                C27545b.m43745b(this.jVf);
                AppMethodBeat.m2505o(15051);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$d */
        static final class C27541d implements Runnable {
            final /* synthetic */ C27545b jVf;

            C27541d(C27545b c27545b) {
                this.jVf = c27545b;
            }

            public final void run() {
                AppMethodBeat.m2504i(15050);
                if (!TmplWebViewToolUI.m43712a(this.jVf.jVe).jUl) {
                    C43924a.m78793kT(92);
                    C4990ab.m7412e(TmplWebViewToolUI.m43716b(this.jVf.jVe), "check notifyPage timeout");
                }
                AppMethodBeat.m2505o(15050);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController$supplyPageFinishInvoke$1", "Ljava/lang/Runnable;", "run", "", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$j */
        public static final class C27542j implements Runnable {
            final /* synthetic */ C27545b jVf;

            C27542j(C27545b c27545b) {
                this.jVf = c27545b;
            }

            /* JADX WARNING: Missing block: B:12:0x0039, code skipped:
            if (r0 == null) goto L_0x0060;
     */
            /* JADX WARNING: Missing block: B:13:0x003b, code skipped:
            com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.TmplWebViewToolUI.m43712a(r4.jVf.jVe).getCurWebviewClient().mo5992b(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.TmplWebViewToolUI.m43712a(r4.jVf.jVe), com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.TmplWebViewToolUI.m43712a(r4.jVf.jVe).getUrl());
     */
            /* JADX WARNING: Missing block: B:15:0x006c, code skipped:
            if (com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.TmplWebViewToolUI.m43712a(r4.jVf.jVe).getDelayInitJsAPI() == false) goto L_0x0075;
     */
            /* JADX WARNING: Missing block: B:16:0x006e, code skipped:
            com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.TmplWebViewToolUI.m43724j(r4.jVf.jVe);
     */
            /* JADX WARNING: Missing block: B:17:0x0075, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(15058);
     */
            /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(15058);
                Object obj = null;
                synchronized (this) {
                    try {
                        if (this.jVf.jVe.jUM) {
                        } else {
                            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVf.jVe), "[supplyPageFinishInvoke]");
                            if (TmplWebViewToolUI.m43712a(this.jVf.jVe) != null) {
                                this.jVf.jVe.uwp = false;
                                obj = 1;
                            }
                            C37091y c37091y = C37091y.AUy;
                        }
                    } finally {
                        AppMethodBeat.m2505o(15058);
                    }
                }
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$a */
        static final class C27546a extends C25053k implements C17126b<Integer, C37091y> {
            final /* synthetic */ C27545b jVf;

            C27546a(C27545b c27545b) {
                this.jVf = c27545b;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(15047);
                int intValue = ((Number) obj).intValue();
                C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVf.jVe), "onStateChange state:".concat(String.valueOf(intValue)));
                switch (intValue) {
                    case 2:
                        C4990ab.m7420w(TmplWebViewToolUI.m43716b(this.jVf.jVe), "onReady success");
                        break;
                    case 4:
                        C5004al.m7439af(this.jVf.jUZ);
                        C27545b.m43744a(this.jVf);
                        break;
                    case 5:
                        C5004al.m7441d(new C27542j(this.jVf));
                        break;
                    case 6:
                        C4990ab.m7412e(TmplWebViewToolUI.m43716b(this.jVf.jVe), "onReady fail, forceUseOriWebViewUI");
                        this.jVf.jUY.jSt = true;
                        TmplWebViewToolUI.m43720f(this.jVf.jVe);
                        break;
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(15047);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "context", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$g */
        static final class C27547g extends C25053k implements C36933q<WeakReference<Object>, C20072h, C40515ef, C37091y> {
            public static final C27547g jVh = new C27547g();

            static {
                AppMethodBeat.m2504i(15055);
                AppMethodBeat.m2505o(15055);
            }

            C27547g() {
                super(3);
            }

            /* renamed from: g */
            public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.m2504i(15054);
                WeakReference weakReference = (WeakReference) obj;
                C20072h c20072h = (C20072h) obj2;
                C40515ef c40515ef = (C40515ef) obj3;
                C25052j.m39376p(weakReference, "context");
                C25052j.m39376p(c20072h, "result");
                C25052j.m39376p(c40515ef, "appMsgContext");
                Object obj4 = weakReference.get();
                if (obj4 == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.TmplController");
                    AppMethodBeat.m2505o(15054);
                    throw c44941v;
                }
                C27545b c27545b = (C27545b) obj4;
                C4990ab.m7418v(TmplWebViewToolUI.m43716b(c27545b.jVe), "processGetAppContext");
                int i = TmplWebViewToolUI.m43717c(c27545b.jVd).upQ;
                c27545b.jUW = c20072h.jSU;
                C43924a.m78791gu(TmplWebViewToolUI.m43717c(c27545b.jVe).upQ, c20072h.jSU ? 121 : 122);
                c27545b.jUY.jRr = c20072h.start;
                c27545b.jUY.jRs = c20072h.aZV;
                c27545b.jUY.jRc = c40515ef.vFU;
                String a;
                if (c20072h.jSU) {
                    c27545b.jUe = System.currentTimeMillis();
                    c27545b.jUY.jRq = c27545b.jUe;
                    String d = TmplWebViewToolUI.m43718d(c27545b.jVe);
                    C25052j.m39375o(d, "getRawUrl()");
                    a = C27540m.m43709a(d, TmplWebViewToolUI.m43719e(c27545b.jVe));
                    C5004al.m7442n(c27545b.jUZ, (long) c27545b.jUX);
                    PreloadLogic.m31008FO(a);
                    TmplWebViewToolUI.m43712a(c27545b.jVe).mo71794b(C2702b.m4928a(c40515ef), a, c27545b.jUd, c27545b.jUe);
                } else {
                    if (c20072h.cxT) {
                        a = c40515ef.vFV;
                        C44724b a2 = TmplWebViewToolUI.m43712a(c27545b.jVd);
                        C43924a.m78791gu(i, 123);
                        if (a != null) {
                            boolean z;
                            if (C6163u.m9837ar(a)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                C43924a.m78791gu(i, 120);
                                a2.loadUrl(C27540m.m43709a(a, TmplWebViewToolUI.m43719e(c27545b.jVe)));
                            }
                        }
                        if (C2702b.m4929b(c40515ef)) {
                            boolean z2;
                            C43924a.m78791gu(i, 124);
                            c27545b.jUe = System.currentTimeMillis();
                            c27545b.jUY.jRq = c27545b.jUe;
                            C5004al.m7442n(c27545b.jUZ, (long) c27545b.jUX);
                            a = TmplWebViewToolUI.m43718d(c27545b.jVe);
                            C25052j.m39375o(a, "url");
                            PreloadLogic.m31008FO(C27540m.m43709a(a, TmplWebViewToolUI.m43719e(c27545b.jVe)));
                            C2712f c2712f = c27545b.jUY;
                            if (a2.mo71794b(C2702b.m4928a(c40515ef), C27540m.m43709a(a, TmplWebViewToolUI.m43719e(c27545b.jVe)), c27545b.jUd, c27545b.jUe)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            c2712f.jRU = z2;
                            c27545b.jUY.jRW = c20072h.jRW;
                        }
                    }
                    C43924a.m78791gu(i, 125);
                    c27545b.jUY.jSt = true;
                    TmplWebViewToolUI.m43720f(c27545b.jVe);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(15054);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$f */
        static final class C27548f extends C25053k implements C17126b<WeakReference<C27545b>, C37091y> {
            public static final C27548f jVg = new C27548f();

            static {
                AppMethodBeat.m2504i(15053);
                AppMethodBeat.m2505o(15053);
            }

            C27548f() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(15052);
                WeakReference weakReference = (WeakReference) obj;
                C25052j.m39376p(weakReference, "it");
                C27545b c27545b = (C27545b) weakReference.get();
                if (c27545b != null) {
                    C4990ab.m7418v(TmplWebViewToolUI.m43716b(c27545b.jVe), "removeShowProcess");
                    C5004al.m7439af(c27545b.jVb);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(15052);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$i */
        static final class C27549i implements Runnable {
            final /* synthetic */ C27545b jVf;

            C27549i(C27545b c27545b) {
                this.jVf = c27545b;
            }

            public final void run() {
                AppMethodBeat.m2504i(15057);
                if (this.jVf.jVe.jUM) {
                    AppMethodBeat.m2505o(15057);
                    return;
                }
                this.jVf.jVe.uuX.start();
                AppMethodBeat.m2505o(15057);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$b$h */
        static final class C27550h implements OnLongClickListener {
            final /* synthetic */ C27545b jVf;

            C27550h(C27545b c27545b) {
                this.jVf = c27545b;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(15056);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.jVf.jUY.toString());
                C30379h.m48417J(this.jVf.jVe, stringBuilder.toString(), "");
                AppMethodBeat.m2505o(15056);
                return true;
            }
        }

        public C27545b(TmplWebViewToolUI tmplWebViewToolUI, TmplWebViewToolUI tmplWebViewToolUI2) {
            C25052j.m39376p(tmplWebViewToolUI2, "webViewUI");
            this.jVe = tmplWebViewToolUI;
            AppMethodBeat.m2504i(15069);
            this.jVd = tmplWebViewToolUI2;
            AppMethodBeat.m2505o(15069);
        }

        /* Access modifiers changed, original: final */
        public final void aYg() {
            AppMethodBeat.m2504i(15060);
            this.jUY.jRD = TmplWebViewToolUI.m43721g(this.jVe).ais("onCreate");
            this.jUY.jRE = TmplWebViewToolUI.m43721g(this.jVe).ais("onUIInitStart");
            this.jUY.jRF = TmplWebViewToolUI.m43721g(this.jVe).ais("onUIInitEnd");
            this.jUY.jRG = TmplWebViewToolUI.m43721g(this.jVe).ais("onTryBindServiceStart");
            this.jUY.jRG = TmplWebViewToolUI.m43721g(this.jVe).ais("onTryBindServiceEnd");
            this.jUY.jRH = TmplWebViewToolUI.m43721g(this.jVe).ais("onPostBindedStart");
            this.jUY.jRI = TmplWebViewToolUI.m43721g(this.jVe).ais("onPostBindedEnd");
            C44724b a = TmplWebViewToolUI.m43712a(this.jVe);
            C2712f c2712f = this.jUY;
            C25052j.m39376p(c2712f, "kv");
            C4990ab.m7418v(a.getTAG(), "terry trace updateKV");
            c2712f.jRx = a.getPerformanceHelper().ais("onInjectStart");
            c2712f.jRy = a.getPerformanceHelper().ais("onInjectEnd");
            c2712f.jRA = a.getPerformanceHelper().ais("onTmplLoadStart");
            c2712f.jRB = a.getPerformanceHelper().ais("onTmplLoadEnd");
            c2712f.jRv = a.getPerformanceHelper().ais("onCreateStart");
            c2712f.jRw = a.getPerformanceHelper().ais("onCreateEnd");
            c2712f.jRV = a.jUk;
            c2712f.jRz = a.getPerformanceHelper().ais("onWebInjectEnd");
            String randomStr = a.getRandomStr();
            C25052j.m39375o(randomStr, "randomStr");
            C25052j.m39376p(randomStr, "<set-?>");
            c2712f.key = randomStr;
            AppMethodBeat.m2505o(15060);
        }

        public final void aXH() {
            int i;
            AppMethodBeat.m2504i(15061);
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "afterCreate isWebViewCreated:" + this.jUV + " state:" + TmplWebViewToolUI.m43712a(this.jVe).getState());
            TmplWebViewToolUI.m43712a(this.jVe).mo71795c((C17126b) new C27546a(this));
            if (this.jUV) {
                C5004al.m7442n(new C11254b(this), 1000);
            }
            C2712f c2712f = this.jUY;
            TmplParams c = TmplWebViewToolUI.m43717c(this.jVe);
            C25052j.m39376p(c, "<set-?>");
            c2712f.jRb = c;
            c2712f = this.jUY;
            String d = TmplWebViewToolUI.m43718d(this.jVe);
            C25052j.m39375o(d, "getRawUrl()");
            C25052j.m39376p(d, "<set-?>");
            c2712f.url = d;
            this.jUY.jRT = this.jUV;
            this.jUY.jRS = this.jUW;
            this.jUY.jSr = TmplWebViewToolUI.m43712a(this.jVe).getWebCoreType().name();
            if (this.jUV) {
                i = 106;
            } else {
                i = 105;
            }
            C43924a.m78788IU(i);
            C38710j.m65657FQ("use preloaded webview:true");
            AppMethodBeat.m2505o(15061);
        }

        /* renamed from: FX */
        public final void mo45348FX(String str) {
            AppMethodBeat.m2504i(15062);
            if (str != null && C25052j.m39373j(str, TmplWebViewToolUI.m43718d(this.jVe))) {
                C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, 116);
                this.jUY.jRt = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(15062);
        }

        /* renamed from: F */
        public final void mo45347F(Bundle bundle) {
            AppMethodBeat.m2504i(15063);
            C25052j.m39376p(bundle, "data");
            String string = bundle.getString("geta8key_result_full_url");
            if (string == null) {
                C25052j.dWJ();
            }
            if (C6163u.m9839jb(string, "http://")) {
                this.jVe.icz.mo63705a(C27545b.m43743Gb(string), new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes")), new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1")));
            }
            AppMethodBeat.m2505o(15063);
        }

        /* renamed from: a */
        public final boolean mo45351a(String str, String str2, Map<String, String> map) {
            AppMethodBeat.m2504i(15064);
            C25052j.m39376p(str, "reqUrl");
            C25052j.m39376p(str2, "fullUrl");
            C25052j.m39376p(map, "httpHeader");
            C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, C31128d.MIC_ALPHA_ADJUST_REAL);
            this.jUY.jRu = System.currentTimeMillis();
            this.jUY.jSd = true;
            aYg();
            this.jUY.mo6791IF();
            mo45359b(str, str2, map);
            TmplWebViewToolUI.m43712a(this.jVe).mo71793a(true, C27545b.m43743Gb(str2), TmplWebViewToolUI.m43719e(this.jVe));
            this.jVe.uwI.afE(C27545b.m43743Gb(str2));
            AppMethodBeat.m2505o(15064);
            return true;
        }

        /* renamed from: b */
        public final void mo45359b(String str, String str2, Map<String, String> map) {
            AppMethodBeat.m2504i(15065);
            C25052j.m39376p(str, "reqUrl");
            C25052j.m39376p(str2, "fullUrl");
            C25052j.m39376p(map, "httpHeader");
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "[updatePageAuth]reqUrl:" + str + " fullUrl:" + str2 + " httpHeader:" + map);
            TmplWebViewToolUI.m43712a(this.jVe).evaluateJavascript("history.replaceState({},\"\",\"" + C27545b.m43743Gb(str2) + "\");", null);
            C36589p settings = TmplWebViewToolUI.m43712a(this.jVe).getSettings();
            C25052j.m39375o(settings, "tmplWebView.settings");
            String userAgentString = settings.getUserAgentString();
            C25052j.m39375o(userAgentString, "tmplWebView.settings.userAgentString");
            map.put("User-agent", userAgentString);
            this.jVe.uhz.agm(new JSONObject(map).toString());
            this.jVe.uhz.agl(Uri.parse(str2).getQueryParameter("pass_ticket"));
            AppMethodBeat.m2505o(15065);
        }

        /* renamed from: Gb */
        private static String m43743Gb(String str) {
            AppMethodBeat.m2504i(15066);
            String c = new C25274k("http://").mo42120c(str, "https://");
            AppMethodBeat.m2505o(15066);
            return c;
        }

        /* renamed from: G */
        public final void mo45350G(Bundle bundle) {
            AppMethodBeat.m2504i(15067);
            C25052j.m39376p(bundle, "data");
            C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, 118);
            this.jUY.jRu = System.currentTimeMillis();
            C44724b.m81441a(TmplWebViewToolUI.m43712a(this.jVe), "");
            if (this.jVe.uwh != null) {
                View n = this.jVe.uwh;
                C25052j.m39375o(n, "this@TmplWebViewToolUI.refreshMask");
                n.setVisibility(8);
            }
            AppMethodBeat.m2505o(15067);
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

        /* renamed from: FY */
        public final void mo45349FY(String str) {
            AppMethodBeat.m2504i(15068);
            C25052j.m39376p(str, "pageInfo");
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "[notifyPageInfo]pageInfo:".concat(String.valueOf(str)));
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
                if (C25052j.m39373j(optString, "ok")) {
                    TmplWebViewToolUI.m43712a(this.jVe).setNotifyPageSuccess(true);
                    this.jUY.jSe = true;
                    C5004al.m7439af(this.jUZ);
                    C5004al.m7439af(this.jVa);
                    this.jUY.mo6791IF();
                    C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, 131);
                    C43924a.m78788IU(108);
                } else {
                    this.jUY.jSt = true;
                    TmplWebViewToolUI.m43720f(this.jVe);
                }
            } catch (JSONException e) {
                C4990ab.printErrStackTrace(TmplWebViewToolUI.m43716b(this.jVe), e, "", new Object[0]);
                this.jUY.jSt = true;
                TmplWebViewToolUI.m43720f(this.jVe);
            }
            this.jUY.jRC = System.currentTimeMillis();
            C5004al.m7442n(new C11256e(this), 300);
            AppMethodBeat.m2505o(15068);
        }

        public final boolean aXL() {
            return true;
        }

        public final void aXG() {
            C44724b c44724b;
            boolean z = false;
            AppMethodBeat.m2504i(15059);
            this.jVe.getIntent().putExtra("show_native_web_view", true);
            C5004al.m7442n(this.jVb, 500);
            C44724b c44724b2 = (C44724b) C45765c.m84590a((Context) this.jVe, TmplWebViewToolUI.m43717c(this.jVe));
            if (c44724b2 == null) {
                MMWebView b = C45765c.m84595b((Context) this.jVe, TmplWebViewToolUI.m43717c(this.jVe));
                if (b == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebView");
                    AppMethodBeat.m2505o(15059);
                    throw c44941v;
                }
                c44724b2 = (C44724b) b;
                this.jUV = false;
                C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, 111);
                c44724b = c44724b2;
            } else {
                boolean z2;
                if (c44724b2.getState() >= 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.jUV = z2;
                C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, 110);
                c44724b = c44724b2;
            }
            if (C43986f.m78916c((WebView) c44724b)) {
                C43924a.m78788IU(112);
            }
            TmplWebViewToolUI tmplWebViewToolUI = this.jVe;
            if (c44724b == null) {
                C25052j.dWJ();
            }
            TmplWebViewToolUI.m43715a(tmplWebViewToolUI, c44724b);
            C44724b a = TmplWebViewToolUI.m43712a(this.jVe);
            C17126b c17126b = C27548f.jVg;
            C25052j.m39376p(this, "context");
            C25052j.m39376p(c17126b, "callback");
            if (a.jUm) {
                c17126b.mo50am(new WeakReference(this));
            } else {
                a.jUn = new C20091d(c17126b, this);
            }
            C4990ab.m7418v(TmplWebViewToolUI.m43716b(this.jVe), "processData");
            this.jUU = System.currentTimeMillis();
            this.jUd = this.jVe.getIntent().getLongExtra(C5506m.ygg, 0);
            C1681g Rn = C1720g.m3533RM().mo5224Rn();
            C25052j.m39375o(Rn, "MMKernel.process().current()");
            C1680a SF = ((C6624h) Rn).mo5180SF();
            String stringExtra = this.jVe.getIntent().getStringExtra(C5506m.ygi);
            if (stringExtra == null) {
                String b2 = TmplWebViewToolUI.m43716b(this.jVe);
                StringBuilder stringBuilder = new StringBuilder("dataKey is null, ");
                Intent intent = this.jVe.getIntent();
                C25052j.m39375o(intent, "intent");
                C4990ab.m7412e(b2, stringBuilder.append(C2710d.m4954Q(intent)).toString());
                C43924a.m78788IU(151);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(1);
                Intent intent2 = this.jVe.getIntent();
                C25052j.m39375o(intent2, "intent");
                objArr[1] = C2710d.m4954Q(intent2);
                c7060h.mo8381e(17260, objArr);
                this.jVe.finish();
            } else {
                C2712f c2712f = this.jUY;
                if (SF.eMy < this.jUd) {
                    z = true;
                }
                c2712f.jSb = z;
                C43924a.m78788IU(this.jUY.jSb ? 104 : 103);
                switch (C20086l.m31076a(this.jVe.getIntent().getIntExtra(C5506m.ygn, -1), this.jUd, Process.myPid(), SF.eMq)) {
                    case 1:
                        this.jUY.jSc = 1;
                        this.jUd = SF.eMq;
                        break;
                    case 2:
                        this.jUY.jSc = 2;
                        this.jUd = -1;
                        break;
                }
                this.jUY.jRX = TmplWebViewToolUI.m43719e(this.jVe).jTb;
                this.jUY.jRY = TmplWebViewToolUI.m43719e(this.jVe).jTc;
                this.jUY.jRZ = C43986f.m78916c((WebView) TmplWebViewToolUI.m43712a(this.jVe));
                this.jUY.jSa = TmplWebViewToolUI.m43719e(this.jVe).jSa;
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
                this.jUY.jSu = TmplWebViewToolUI.m43719e(this.jVe).jSu;
                PreloadLogic.jSS.mo35311a((Object) this, stringExtra, TmplWebViewToolUI.m43719e(this.jVe), (C36933q) C27547g.jVh);
            }
            if (C5058f.DEBUG || C5058f.IS_FLAVOR_RED || 1 >= C4990ab.getLogLevel()) {
                this.jVe.uxc = new C27550h(this);
            }
            AppMethodBeat.m2505o(15059);
        }

        /* renamed from: a */
        public static final /* synthetic */ void m43744a(C27545b c27545b) {
            AppMethodBeat.m2504i(15070);
            if (TmplWebViewToolUI.m43712a(c27545b.jVe).jUk && !TmplWebViewToolUI.m43712a(c27545b.jVe).jUl) {
                C4990ab.m7416i(TmplWebViewToolUI.m43716b(c27545b.jVe), "check notifyPage");
                C5004al.m7442n(c27545b.jVa, 3000);
            }
            AppMethodBeat.m2505o(15070);
        }

        /* JADX WARNING: Missing block: B:10:0x0016, code skipped:
            r0 = r5.jVe.getIntent().getBooleanExtra(com.tencent.p177mm.p612ui.C5510e.C5506m.ygf, true);
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.TmplWebViewToolUI.m43716b(r5.jVe), "[preloadNextWebView] ".concat(java.lang.String.valueOf(r0)));
     */
        /* JADX WARNING: Missing block: B:11:0x0036, code skipped:
            if (r0 == false) goto L_0x003b;
     */
        /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C45765c.aVR();
     */
        /* JADX WARNING: Missing block: B:13:0x003b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(15071);
     */
        /* JADX WARNING: Missing block: B:17:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public static final /* synthetic */ void m43745b(C27545b c27545b) {
            AppMethodBeat.m2504i(15071);
            synchronized (c27545b) {
                try {
                    if (c27545b.jVc) {
                    } else {
                        c27545b.jVc = true;
                        C37091y c37091y = C37091y.AUy;
                    }
                } finally {
                    AppMethodBeat.m2505o(15071);
                }
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$d */
    static final class C27551d extends C25053k implements C31214a<Integer> {
        final /* synthetic */ TmplWebViewToolUI jVe;

        C27551d(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15073);
            Integer valueOf = Integer.valueOf(this.jVe.getIntent().getIntExtra(C5506m.ygp, -1));
            AppMethodBeat.m2505o(15073);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$Companion;", "", "()V", "SHOW_PROGRESS_TIME", "", "rawTAG", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$a */
    public static final class C27552a {
        private C27552a() {
        }

        public /* synthetic */ C27552a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI$c */
    static final class C27553c implements Runnable {
        final /* synthetic */ TmplWebViewToolUI jVe;

        C27553c(TmplWebViewToolUI tmplWebViewToolUI) {
            this.jVe = tmplWebViewToolUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(15072);
            if (this.jVe.jUM) {
                AppMethodBeat.m2505o(15072);
                return;
            }
            C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "forceUseOriWebViewUI() isA8KeyDone:" + this.jVe.jUN);
            if (!(TmplWebViewToolUI.m43731q(this.jVe) instanceof C27555a)) {
                C43924a.m78791gu(TmplWebViewToolUI.m43717c(this.jVe).upQ, 137);
                this.jVe.jUI = new C27555a();
                if (this.jVe.jUN) {
                    C4990ab.m7416i(TmplWebViewToolUI.m43716b(this.jVe), "forceUseOriWebViewUI()");
                    if (this.jVe.uvY != null) {
                        this.jVe.uvY.dcq();
                        this.jVe.jUI = new C27555a();
                    }
                    String s = this.jVe.jUO;
                    if (s != null) {
                        s = C27540m.m43708G(C27540m.m43711dh(C27540m.m43711dh(C27540m.m43711dh(s, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
                    } else {
                        s = null;
                    }
                    if (this.jVe.jUP != null) {
                        TmplWebViewToolUI.m43712a(this.jVe).loadUrl(s, this.jVe.jUP);
                        AppMethodBeat.m2505o(15072);
                        return;
                    }
                    TmplWebViewToolUI.m43712a(this.jVe).loadUrl(s);
                }
            }
            AppMethodBeat.m2505o(15072);
        }
    }

    static {
        AppMethodBeat.m2504i(15083);
        AppMethodBeat.m2505o(15083);
    }

    private final TmplParams aWY() {
        AppMethodBeat.m2504i(15086);
        TmplParams tmplParams = (TmplParams) this.jUL.getValue();
        AppMethodBeat.m2505o(15086);
        return tmplParams;
    }

    private final int aXV() {
        AppMethodBeat.m2504i(15085);
        int intValue = ((Number) this.jUJ.getValue()).intValue();
        AppMethodBeat.m2505o(15085);
        return intValue;
    }

    private final PreloadSession aXW() {
        AppMethodBeat.m2504i(138518);
        PreloadSession preloadSession = (PreloadSession) this.jUK.getValue();
        AppMethodBeat.m2505o(138518);
        return preloadSession;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TmplWebViewToolUI() {
        AppMethodBeat.m2504i(15101);
        AppMethodBeat.m2505o(15101);
    }

    /* renamed from: a */
    public static final /* synthetic */ C44724b m43712a(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15102);
        C44724b c44724b = tmplWebViewToolUI.jUH;
        if (c44724b == null) {
            C25052j.avw("tmplWebView");
        }
        AppMethodBeat.m2505o(15102);
        return c44724b;
    }

    /* renamed from: b */
    public static final /* synthetic */ String m43716b(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15103);
        String tag = tmplWebViewToolUI.getTAG();
        AppMethodBeat.m2505o(15103);
        return tag;
    }

    /* renamed from: c */
    public static final /* synthetic */ TmplParams m43717c(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15104);
        TmplParams aWY = tmplWebViewToolUI.aWY();
        AppMethodBeat.m2505o(15104);
        return aWY;
    }

    /* renamed from: d */
    public static final /* synthetic */ String m43718d(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15106);
        String cWL = tmplWebViewToolUI.cWL();
        AppMethodBeat.m2505o(15106);
        return cWL;
    }

    /* renamed from: e */
    public static final /* synthetic */ PreloadSession m43719e(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15107);
        PreloadSession aXW = tmplWebViewToolUI.aXW();
        AppMethodBeat.m2505o(15107);
        return aXW;
    }

    /* renamed from: g */
    public static final /* synthetic */ C44781d m43721g(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15109);
        C44781d cZW = tmplWebViewToolUI.cZW();
        AppMethodBeat.m2505o(15109);
        return cZW;
    }

    /* renamed from: j */
    public static final /* synthetic */ void m43724j(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15110);
        tmplWebViewToolUI.daf();
        AppMethodBeat.m2505o(15110);
    }

    /* renamed from: q */
    public static final /* synthetic */ C27554a m43731q(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15111);
        C27554a c27554a = tmplWebViewToolUI.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        AppMethodBeat.m2505o(15111);
        return c27554a;
    }

    private final String getTAG() {
        AppMethodBeat.m2504i(15084);
        String str = "MicroMsg.TmplWebViewToolUI:" + this.jUG;
        AppMethodBeat.m2505o(15084);
        return str;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(15087);
        if (aWY().jSV == -1 || C5046bo.isNullOrNil(aWY().upO)) {
            C4990ab.m7416i(getTAG(), "initTmpl() tmplParams is null");
            this.jUI = new C27555a();
            C43924a.m78793kT(109);
            C43924a.m78788IU(101);
        } else {
            C4990ab.m7416i(getTAG(), "initTmpl() TmplController");
            this.jUI = new C27545b(this, this);
        }
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.aXG();
        super.onCreate(bundle);
        c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.aXH();
        AppMethodBeat.m2505o(15087);
    }

    public void finish() {
        AppMethodBeat.m2504i(15088);
        super.finish();
        if (aXV() != -1 && aXV() == 1) {
            daG();
        }
        AppMethodBeat.m2505o(15088);
    }

    public final MMWebView aXX() {
        AppMethodBeat.m2504i(15089);
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        MMWebView mMWebView;
        if (c27554a.aXI()) {
            C44724b c44724b = this.jUH;
            if (c44724b == null) {
                C25052j.avw("tmplWebView");
            }
            mMWebView = c44724b;
            AppMethodBeat.m2505o(15089);
            return mMWebView;
        }
        mMWebView = super.aXX();
        AppMethodBeat.m2505o(15089);
        return mMWebView;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(15090);
        this.jUM = true;
        super.onDestroy();
        AppMethodBeat.m2505o(15090);
    }

    /* renamed from: as */
    public final C16953w mo30966as(String str, boolean z) {
        C16953w c16953w;
        AppMethodBeat.m2504i(15091);
        C25052j.m39376p(str, "url");
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.mo45348FX(str);
        c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        if ((c27554a instanceof C27545b) && C25052j.m39373j(str, cWL())) {
            Bundle FZ = C38712d.m65659FZ(str);
            if (!(FZ == null || C5023at.isConnected(C4996ah.getContext()))) {
                this.uwI.utI = true;
                mo30942H(FZ);
                C44724b c44724b = this.jUH;
                if (c44724b == null) {
                    C25052j.avw("tmplWebView");
                }
                C44724b.m81441a(c44724b, "");
                c16953w = C16953w.NO_NEED;
                AppMethodBeat.m2505o(15091);
                return c16953w;
            }
        }
        c16953w = super.mo30966as(str, z);
        C25052j.m39375o(c16953w, "super.startGetA8Key(url, force)");
        AppMethodBeat.m2505o(15091);
        return c16953w;
    }

    /* renamed from: H */
    public final boolean mo30942H(Bundle bundle) {
        AppMethodBeat.m2504i(15092);
        C25052j.m39376p(bundle, "data");
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.mo45347F(bundle);
        String string = bundle.getString("geta8key_result_req_url");
        C27554a c27554a2 = this.jUI;
        if (c27554a2 == null) {
            C25052j.avw("tmplController");
        }
        if ((c27554a2 instanceof C27545b) && string != null && C25052j.m39373j(string, cWL())) {
            C38712d.m65661m(string, bundle);
        }
        boolean H = super.mo30942H(bundle);
        AppMethodBeat.m2505o(15092);
        return H;
    }

    /* renamed from: c */
    public final void mo30972c(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(15093);
        C25052j.m39376p(str, "reqUrl");
        C25052j.m39376p(str2, "fullUrl");
        C25052j.m39376p(map, "httpHeader");
        C4990ab.m7418v(getTAG(), "processCommonGetA8KeyFullUrl:".concat(String.valueOf(str)));
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        if (c27554a.mo45351a(str, str2, map)) {
            this.jUN = true;
            this.jUO = str2;
            this.jUP = map;
            AppMethodBeat.m2505o(15093);
            return;
        }
        super.mo30972c(str, str2, map);
        AppMethodBeat.m2505o(15093);
    }

    /* renamed from: b */
    public final void mo30969b(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(15094);
        C25052j.m39376p(str, "reqUrl");
        C25052j.m39376p(str2, "fullUrl");
        C25052j.m39376p(map, "httpHeader");
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.mo45359b(str, str2, map);
        C43924a.m78788IU(109);
        AppMethodBeat.m2505o(15094);
    }

    /* renamed from: G */
    public final void mo30941G(Bundle bundle) {
        AppMethodBeat.m2504i(15095);
        C25052j.m39376p(bundle, "data");
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.mo45350G(bundle);
        AppMethodBeat.m2505o(15095);
    }

    public final C44786d aXY() {
        AppMethodBeat.m2504i(15096);
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        C44786d jsApiHandler;
        if (c27554a.aXJ()) {
            C44724b c44724b = this.jUH;
            if (c44724b == null) {
                C25052j.avw("tmplWebView");
            }
            c44724b.getJsApiHandler().mo71928e(this.icy);
            c44724b = this.jUH;
            if (c44724b == null) {
                C25052j.avw("tmplWebView");
            }
            c44724b.getJsApiHandler().mo71876JJ(hashCode());
            c44724b = this.jUH;
            if (c44724b == null) {
                C25052j.avw("tmplWebView");
            }
            c44724b.getJsApiHandler().mo71884a(this.icz);
            C40344k c40344k = this.icz;
            C44724b c44724b2 = this.jUH;
            if (c44724b2 == null) {
                C25052j.avw("tmplWebView");
            }
            c40344k.mo63705a(c44724b2.jVi, JsapiPermissionWrapper.vxI, GeneralControlWrapper.vxF);
            c44724b = this.jUH;
            if (c44724b == null) {
                C25052j.avw("tmplWebView");
            }
            jsApiHandler = c44724b.getJsApiHandler();
            C25052j.m39375o(jsApiHandler, "tmplWebView.jsApiHandler");
            AppMethodBeat.m2505o(15096);
            return jsApiHandler;
        }
        jsApiHandler = super.aXY();
        C25052j.m39375o(jsApiHandler, "super.createJsApiHandler()");
        AppMethodBeat.m2505o(15096);
        return jsApiHandler;
    }

    public final C36592s aXZ() {
        AppMethodBeat.m2504i(15097);
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        C36592s c36592s;
        if (c27554a.aXK()) {
            c36592s = this.jUR;
            AppMethodBeat.m2505o(15097);
            return c36592s;
        }
        c36592s = super.aXZ();
        C25052j.m39375o(c36592s, "super.createWebViewClient()");
        AppMethodBeat.m2505o(15097);
        return c36592s;
    }

    public final boolean aXL() {
        AppMethodBeat.m2504i(15098);
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        if (c27554a.aXL()) {
            AppMethodBeat.m2505o(15098);
            return false;
        }
        boolean aXL = super.aXL();
        AppMethodBeat.m2505o(15098);
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

    /* renamed from: FY */
    public final void mo30940FY(String str) {
        AppMethodBeat.m2504i(15099);
        C25052j.m39376p(str, "pageInfo");
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        c27554a.mo45349FY(str);
        AppMethodBeat.m2505o(15099);
    }

    public final void aYe() {
        AppMethodBeat.m2504i(15100);
        C27554a c27554a = this.jUI;
        if (c27554a == null) {
            C25052j.avw("tmplController");
        }
        if (c27554a instanceof C27555a) {
            super.aYe();
            AppMethodBeat.m2505o(15100);
            return;
        }
        this.jUS = false;
        this.jUI = new C27555a();
        String cWL = cWL();
        C25052j.m39375o(cWL, "getRawUrl()");
        mo30966as(cWL, true);
        this.jUQ = true;
        AppMethodBeat.m2505o(15100);
    }

    public final boolean aYf() {
        return this.jUS;
    }

    /* renamed from: f */
    public static final /* synthetic */ void m43720f(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.m2504i(15108);
        C33740a c33740a = C33739g.jSD;
        if (!C33740a.aXk()) {
            tmplWebViewToolUI.jUS = false;
            C43924a.m78788IU(102);
            C5004al.m7441d(new C27553c(tmplWebViewToolUI));
        }
        AppMethodBeat.m2505o(15108);
    }
}
