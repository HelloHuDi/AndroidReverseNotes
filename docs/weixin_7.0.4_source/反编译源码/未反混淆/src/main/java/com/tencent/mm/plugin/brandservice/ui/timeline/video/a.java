package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "setDensity", "Lkotlin/Function1;", "", "", "resize", "", "getA8KeyScene", "sendScrollEvent", "scrollViewHeight", "subViewOffsetTop", "plugin-brandservice_release"})
public final class a {
    public static final a jVq = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$2", "", "adWidth", "", "getAdWidth", "()I", "plugin-brandservice_release"})
    public static final class b {
        final /* synthetic */ MMWebViewWithJsApi jVt;
        final /* synthetic */ a.f.b.u.a jVu;

        b(MMWebViewWithJsApi mMWebViewWithJsApi, a.f.b.u.a aVar) {
            this.jVt = mMWebViewWithJsApi;
            this.jVu = aVar;
        }

        @JavascriptInterface
        @org.xwalk.core.JavascriptInterface
        public final int getAdWidth() {
            AppMethodBeat.i(15112);
            int measuredWidth = (int) (((float) this.jVt.getMeasuredWidth()) / this.jVu.AVC);
            AppMethodBeat.o(15112);
            return measuredWidth;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
    public static final class c extends m {
        final /* synthetic */ MMWebViewWithJsApi jVt;
        final /* synthetic */ a.f.b.u.a jVu;
        final /* synthetic */ String jVv;
        final /* synthetic */ a.f.a.b jVw;

        c(MMWebViewWithJsApi mMWebViewWithJsApi, String str, a.f.a.b bVar, a.f.b.u.a aVar) {
            this.jVt = mMWebViewWithJsApi;
            this.jVv = str;
            this.jVw = bVar;
            this.jVu = aVar;
        }

        public final boolean c(int i, Bundle bundle) {
            AppMethodBeat.i(15113);
            j.p(bundle, "data");
            ab.i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(i)));
            boolean c = super.c(i, bundle);
            AppMethodBeat.o(15113);
            return c;
        }

        public final Bundle g(int i, Bundle bundle) {
            AppMethodBeat.i(15114);
            ab.i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(i)));
            switch (i) {
                case 101:
                    if (bundle == null) {
                        j.dWJ();
                    }
                    bundle.setClassLoader(WebViewUI.class.getClassLoader());
                    Context context = this.jVt.getContext();
                    String string = bundle.getString("open_ui_with_webview_ui_plugin_name");
                    String string2 = bundle.getString("open_ui_with_webview_ui_plugin_entry");
                    Intent intent = new Intent();
                    Bundle bundle2 = bundle.getBundle("open_ui_with_webview_ui_extras");
                    if (bundle2 == null) {
                        j.dWJ();
                    }
                    d.b(context, string, string2, intent.putExtras(bundle2).putExtra("KPublisherId", this.jVv));
                    break;
            }
            AppMethodBeat.o(15114);
            return null;
        }

        public final Bundle dj(String str, String str2) {
            Bundle akC;
            AppMethodBeat.i(15115);
            if (str != null) {
                switch (str.hashCode()) {
                    case -1083168262:
                        if (str.equals("configMpAdAttrs")) {
                            ab.i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(str2)));
                            int i = new i(str2).getInt("viewHeight");
                            Object concat = f.DEBUG ? ",param:".concat(String.valueOf(str2)) : "";
                            if (i > 0) {
                                this.jVw.am(Integer.valueOf((int) ((((float) i) * this.jVu.AVC) + 0.5f)));
                                akC = com.tencent.mm.protocal.c.akC("configMpAdAttrs:ok".concat(String.valueOf(concat)));
                                j.o(akC, "ConstantsJSAPIFunc.creat…gMpAdAttrs:ok$debugInfo\")");
                                AppMethodBeat.o(15115);
                                return akC;
                            }
                            akC = com.tencent.mm.protocal.c.akC("configMpAdAttrs:err height".concat(String.valueOf(concat)));
                            j.o(akC, "ConstantsJSAPIFunc.creat…rs:err height$debugInfo\")");
                            AppMethodBeat.o(15115);
                            return akC;
                        }
                        break;
                }
            }
            akC = super.dj(str, str2);
            j.o(akC, "super.handleMsg(func, param)");
            AppMethodBeat.o(15115);
            return akC;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "plugin-brandservice_release"})
    public static final class a extends k {
        final /* synthetic */ c jVr;
        final /* synthetic */ int jVs;
        final /* synthetic */ MMWebViewWithJsApi jVt;

        a(c cVar, int i, MMWebViewWithJsApi mMWebViewWithJsApi, MMWebView mMWebView) {
            this.jVr = cVar;
            this.jVs = i;
            this.jVt = mMWebViewWithJsApi;
            super(mMWebView);
        }

        public final m aGt() {
            return this.jVr;
        }

        public final int aGu() {
            return this.jVs;
        }
    }

    static {
        AppMethodBeat.i(15118);
        AppMethodBeat.o(15118);
    }

    private a() {
    }

    public static void a(MMWebViewWithJsApi mMWebViewWithJsApi, int i, int i2) {
        AppMethodBeat.i(15116);
        j.p(mMWebViewWithJsApi, "webView");
        try {
            if (mMWebViewWithJsApi.getJsapi() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("scrollViewHeight", Integer.valueOf(i));
                hashMap.put("subViewOffsetTop", Integer.valueOf(i2));
                Map map = hashMap;
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d jsapi = mMWebViewWithJsApi.getJsapi();
                j.o(jsapi, "webView.jsapi");
                mMWebViewWithJsApi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onScrollViewDidScroll", map, true, jsapi.dci()) + ')', null);
                AppMethodBeat.o(15116);
                return;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AdWebViewManager", "onScrollViewDidScroll fail, ex = %s", e.getMessage());
        }
        AppMethodBeat.o(15116);
    }

    public static MMWebViewWithJsApi a(MMWebViewWithJsApi mMWebViewWithJsApi, String str, a.f.a.b<? super Float, y> bVar, a.f.a.b<? super Integer, y> bVar2, int i) {
        AppMethodBeat.i(15117);
        j.p(mMWebViewWithJsApi, "webView");
        j.p(str, "publishId");
        j.p(bVar, "setDensity");
        j.p(bVar2, "resize");
        a.f.b.u.a aVar = new a.f.b.u.a();
        aVar.AVC = com.tencent.mm.ca.a.dmO();
        if (mMWebViewWithJsApi.getWebCoreType() == WebView.d.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
            Resources resources = mMWebViewWithJsApi.getResources();
            j.o(resources, "webView.resources");
            aVar.AVC = resources.getDisplayMetrics().density;
        }
        bVar.am(Float.valueOf(aVar.AVC));
        mMWebViewWithJsApi.setBackgroundColor(0);
        mMWebViewWithJsApi.setWebViewClient(new a(new c(mMWebViewWithJsApi, str, bVar2, aVar), i, mMWebViewWithJsApi, mMWebViewWithJsApi));
        mMWebViewWithJsApi.addJavascriptInterface(new b(mMWebViewWithJsApi, aVar), "__mp_ad_webview");
        ab.i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(str)));
        AppMethodBeat.o(15117);
        return mMWebViewWithJsApi;
    }
}
