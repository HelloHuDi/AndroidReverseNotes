package com.tencent.p177mm.plugin.webview.fts.p1664d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.websearch.api.C22759r;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C3569045;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C4033532;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C463040;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C463141;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C463443;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.xweb.WebView;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.fts.d.a */
public final class C46411a implements C22759r {
    private WebView uhI;
    public C44786d uhz;

    public C46411a(WebView webView) {
        this.uhI = webView;
    }

    public final void addView(View view) {
        AppMethodBeat.m2504i(5963);
        ViewGroup topView = this.uhI.getTopView();
        if (topView == null || !(topView instanceof AbsoluteLayout)) {
            C4990ab.m7412e("WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(topView)));
            AppMethodBeat.m2505o(5963);
            return;
        }
        topView.addView(view);
        AppMethodBeat.m2505o(5963);
    }

    public final void removeView(View view) {
        AppMethodBeat.m2504i(5964);
        ViewGroup topView = this.uhI.getTopView();
        if (topView != null && (topView instanceof AbsoluteLayout)) {
            topView.removeView(view);
        }
        AppMethodBeat.m2505o(5964);
    }

    /* renamed from: dw */
    public final void mo38346dw(String str, int i) {
        AppMethodBeat.m2504i(5965);
        C44786d c44786d = this.uhz;
        if (c44786d.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("state", Integer.valueOf(i));
            C5004al.m7441d(new C463443(C23124a.m35500b("onSearchWAWidgetStateChange", hashMap, c44786d.uFv, c44786d.uFw)));
            AppMethodBeat.m2505o(5965);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
        AppMethodBeat.m2505o(5965);
    }

    /* renamed from: g */
    public final void mo38349g(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(5966);
        this.uhz.mo71891a(str, z, "", str2);
        AppMethodBeat.m2505o(5966);
    }

    public final void adG(String str) {
        AppMethodBeat.m2504i(5967);
        C44786d c44786d = this.uhz;
        if (c44786d.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            C5004al.m7441d(new C463141(C23124a.m35500b("onSearchWAWidgetReloadData", hashMap, c44786d.uFv, c44786d.uFw)));
            AppMethodBeat.m2505o(5967);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
        AppMethodBeat.m2505o(5967);
    }

    /* renamed from: gS */
    public final void mo38350gS(String str, String str2) {
        AppMethodBeat.m2504i(5968);
        C44786d c44786d = this.uhz;
        if (c44786d.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("data", str2);
            C5004al.m7441d(new C3569045(C23124a.m35500b("onSearchWAWidgetDataPush", hashMap, c44786d.uFv, c44786d.uFw)));
            AppMethodBeat.m2505o(5968);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
        AppMethodBeat.m2505o(5968);
    }

    /* renamed from: g */
    public final void mo38348g(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(5969);
        C44786d c44786d = this.uhz;
        if (c44786d.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("path", str2);
            hashMap.put("username", str3);
            hashMap.put("debugMode", Integer.valueOf(i));
            C5004al.m7441d(new C463040(C23124a.m35500b("onSearchWAWidgetOpenApp", hashMap, c44786d.uFv, c44786d.uFw)));
            AppMethodBeat.m2505o(5969);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
        AppMethodBeat.m2505o(5969);
    }

    /* renamed from: a */
    public final void mo38342a(String str, boolean z, String str2, String str3) {
        AppMethodBeat.m2504i(5970);
        this.uhz.mo71891a(str, z, str2, str3);
        AppMethodBeat.m2505o(5970);
    }

    /* renamed from: dx */
    public final void mo38347dx(String str, int i) {
        AppMethodBeat.m2504i(5971);
        C44786d c44786d = this.uhz;
        if (c44786d.ready) {
            C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("height", Integer.valueOf(i));
            C5004al.m7441d(new C4033532(C23124a.m35500b("onSearchWAWidgetAttrChanged", hashMap, c44786d.uFv, c44786d.uFw)));
            AppMethodBeat.m2505o(5971);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
        AppMethodBeat.m2505o(5971);
    }

    public final void cUV() {
    }
}
