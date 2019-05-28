package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43989k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C46936m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.protocal.C15045c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.xweb.WebView.C44570d;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31595a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "setDensity", "Lkotlin/Function1;", "", "", "resize", "", "getA8KeyScene", "sendScrollEvent", "scrollViewHeight", "subViewOffsetTop", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a */
public final class C42831a {
    public static final C42831a jVq = new C42831a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$2", "", "adWidth", "", "getAdWidth", "()I", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a$b */
    public static final class C42829b {
        final /* synthetic */ MMWebViewWithJsApi jVt;
        final /* synthetic */ C31595a jVu;

        C42829b(MMWebViewWithJsApi mMWebViewWithJsApi, C31595a c31595a) {
            this.jVt = mMWebViewWithJsApi;
            this.jVu = c31595a;
        }

        @JavascriptInterface
        @org.xwalk.core.JavascriptInterface
        public final int getAdWidth() {
            AppMethodBeat.m2504i(15112);
            int measuredWidth = (int) (((float) this.jVt.getMeasuredWidth()) / this.jVu.AVC);
            AppMethodBeat.m2505o(15112);
            return measuredWidth;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a$c */
    public static final class C42830c extends C46936m {
        final /* synthetic */ MMWebViewWithJsApi jVt;
        final /* synthetic */ C31595a jVu;
        final /* synthetic */ String jVv;
        final /* synthetic */ C17126b jVw;

        C42830c(MMWebViewWithJsApi mMWebViewWithJsApi, String str, C17126b c17126b, C31595a c31595a) {
            this.jVt = mMWebViewWithJsApi;
            this.jVv = str;
            this.jVw = c17126b;
            this.jVu = c31595a;
        }

        /* renamed from: c */
        public final boolean mo26784c(int i, Bundle bundle) {
            AppMethodBeat.m2504i(15113);
            C25052j.m39376p(bundle, "data");
            C4990ab.m7416i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(i)));
            boolean c = super.mo26784c(i, bundle);
            AppMethodBeat.m2505o(15113);
            return c;
        }

        /* renamed from: g */
        public final Bundle mo6226g(int i, Bundle bundle) {
            AppMethodBeat.m2504i(15114);
            C4990ab.m7416i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(i)));
            switch (i) {
                case 101:
                    if (bundle == null) {
                        C25052j.dWJ();
                    }
                    bundle.setClassLoader(WebViewUI.class.getClassLoader());
                    Context context = this.jVt.getContext();
                    String string = bundle.getString("open_ui_with_webview_ui_plugin_name");
                    String string2 = bundle.getString("open_ui_with_webview_ui_plugin_entry");
                    Intent intent = new Intent();
                    Bundle bundle2 = bundle.getBundle("open_ui_with_webview_ui_extras");
                    if (bundle2 == null) {
                        C25052j.dWJ();
                    }
                    C25985d.m41467b(context, string, string2, intent.putExtras(bundle2).putExtra("KPublisherId", this.jVv));
                    break;
            }
            AppMethodBeat.m2505o(15114);
            return null;
        }

        /* renamed from: dj */
        public final Bundle mo26790dj(String str, String str2) {
            Bundle akC;
            AppMethodBeat.m2504i(15115);
            if (str != null) {
                switch (str.hashCode()) {
                    case -1083168262:
                        if (str.equals("configMpAdAttrs")) {
                            C4990ab.m7416i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(str2)));
                            int i = new C41726i(str2).getInt("viewHeight");
                            Object concat = C5058f.DEBUG ? ",param:".concat(String.valueOf(str2)) : "";
                            if (i > 0) {
                                this.jVw.mo50am(Integer.valueOf((int) ((((float) i) * this.jVu.AVC) + 0.5f)));
                                akC = C15045c.akC("configMpAdAttrs:ok".concat(String.valueOf(concat)));
                                C25052j.m39375o(akC, "ConstantsJSAPIFunc.creat…gMpAdAttrs:ok$debugInfo\")");
                                AppMethodBeat.m2505o(15115);
                                return akC;
                            }
                            akC = C15045c.akC("configMpAdAttrs:err height".concat(String.valueOf(concat)));
                            C25052j.m39375o(akC, "ConstantsJSAPIFunc.creat…rs:err height$debugInfo\")");
                            AppMethodBeat.m2505o(15115);
                            return akC;
                        }
                        break;
                }
            }
            akC = super.mo26790dj(str, str2);
            C25052j.m39375o(akC, "super.handleMsg(func, param)");
            AppMethodBeat.m2505o(15115);
            return akC;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a$a */
    public static final class C42832a extends C43989k {
        final /* synthetic */ C42830c jVr;
        final /* synthetic */ int jVs;
        final /* synthetic */ MMWebViewWithJsApi jVt;

        C42832a(C42830c c42830c, int i, MMWebViewWithJsApi mMWebViewWithJsApi, MMWebView mMWebView) {
            this.jVr = c42830c;
            this.jVs = i;
            this.jVt = mMWebViewWithJsApi;
            super(mMWebView);
        }

        public final C46936m aGt() {
            return this.jVr;
        }

        public final int aGu() {
            return this.jVs;
        }
    }

    static {
        AppMethodBeat.m2504i(15118);
        AppMethodBeat.m2505o(15118);
    }

    private C42831a() {
    }

    /* renamed from: a */
    public static void m75979a(MMWebViewWithJsApi mMWebViewWithJsApi, int i, int i2) {
        AppMethodBeat.m2504i(15116);
        C25052j.m39376p(mMWebViewWithJsApi, "webView");
        try {
            if (mMWebViewWithJsApi.getJsapi() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("scrollViewHeight", Integer.valueOf(i));
                hashMap.put("subViewOffsetTop", Integer.valueOf(i2));
                Map map = hashMap;
                C44786d jsapi = mMWebViewWithJsApi.getJsapi();
                C25052j.m39375o(jsapi, "webView.jsapi");
                mMWebViewWithJsApi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("onScrollViewDidScroll", map, true, jsapi.dci()) + ')', null);
                AppMethodBeat.m2505o(15116);
                return;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AdWebViewManager", "onScrollViewDidScroll fail, ex = %s", e.getMessage());
        }
        AppMethodBeat.m2505o(15116);
    }

    /* renamed from: a */
    public static MMWebViewWithJsApi m75978a(MMWebViewWithJsApi mMWebViewWithJsApi, String str, C17126b<? super Float, C37091y> c17126b, C17126b<? super Integer, C37091y> c17126b2, int i) {
        AppMethodBeat.m2504i(15117);
        C25052j.m39376p(mMWebViewWithJsApi, "webView");
        C25052j.m39376p(str, "publishId");
        C25052j.m39376p(c17126b, "setDensity");
        C25052j.m39376p(c17126b2, "resize");
        C31595a c31595a = new C31595a();
        c31595a.AVC = C32432a.dmO();
        if (mMWebViewWithJsApi.getWebCoreType() == C44570d.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
            Resources resources = mMWebViewWithJsApi.getResources();
            C25052j.m39375o(resources, "webView.resources");
            c31595a.AVC = resources.getDisplayMetrics().density;
        }
        c17126b.mo50am(Float.valueOf(c31595a.AVC));
        mMWebViewWithJsApi.setBackgroundColor(0);
        mMWebViewWithJsApi.setWebViewClient(new C42832a(new C42830c(mMWebViewWithJsApi, str, c17126b2, c31595a), i, mMWebViewWithJsApi, mMWebViewWithJsApi));
        mMWebViewWithJsApi.addJavascriptInterface(new C42829b(mMWebViewWithJsApi, c31595a), "__mp_ad_webview");
        C4990ab.m7416i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(15117);
        return mMWebViewWithJsApi;
    }
}
