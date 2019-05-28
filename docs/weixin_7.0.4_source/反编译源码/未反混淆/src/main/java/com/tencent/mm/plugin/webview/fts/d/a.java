package com.tencent.mm.plugin.webview.fts.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass32;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass40;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass41;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass43;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass45;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.xweb.WebView;
import java.util.HashMap;

public final class a implements r {
    private WebView uhI;
    public d uhz;

    public a(WebView webView) {
        this.uhI = webView;
    }

    public final void addView(View view) {
        AppMethodBeat.i(5963);
        ViewGroup topView = this.uhI.getTopView();
        if (topView == null || !(topView instanceof AbsoluteLayout)) {
            ab.e("WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(topView)));
            AppMethodBeat.o(5963);
            return;
        }
        topView.addView(view);
        AppMethodBeat.o(5963);
    }

    public final void removeView(View view) {
        AppMethodBeat.i(5964);
        ViewGroup topView = this.uhI.getTopView();
        if (topView != null && (topView instanceof AbsoluteLayout)) {
            topView.removeView(view);
        }
        AppMethodBeat.o(5964);
    }

    public final void dw(String str, int i) {
        AppMethodBeat.i(5965);
        d dVar = this.uhz;
        if (dVar.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("state", Integer.valueOf(i));
            al.d(new AnonymousClass43(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetStateChange", hashMap, dVar.uFv, dVar.uFw)));
            AppMethodBeat.o(5965);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
        AppMethodBeat.o(5965);
    }

    public final void g(String str, boolean z, String str2) {
        AppMethodBeat.i(5966);
        this.uhz.a(str, z, "", str2);
        AppMethodBeat.o(5966);
    }

    public final void adG(String str) {
        AppMethodBeat.i(5967);
        d dVar = this.uhz;
        if (dVar.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            al.d(new AnonymousClass41(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetReloadData", hashMap, dVar.uFv, dVar.uFw)));
            AppMethodBeat.o(5967);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
        AppMethodBeat.o(5967);
    }

    public final void gS(String str, String str2) {
        AppMethodBeat.i(5968);
        d dVar = this.uhz;
        if (dVar.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("data", str2);
            al.d(new AnonymousClass45(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetDataPush", hashMap, dVar.uFv, dVar.uFw)));
            AppMethodBeat.o(5968);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
        AppMethodBeat.o(5968);
    }

    public final void g(String str, String str2, String str3, int i) {
        AppMethodBeat.i(5969);
        d dVar = this.uhz;
        if (dVar.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("path", str2);
            hashMap.put("username", str3);
            hashMap.put("debugMode", Integer.valueOf(i));
            al.d(new AnonymousClass40(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetOpenApp", hashMap, dVar.uFv, dVar.uFw)));
            AppMethodBeat.o(5969);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
        AppMethodBeat.o(5969);
    }

    public final void a(String str, boolean z, String str2, String str3) {
        AppMethodBeat.i(5970);
        this.uhz.a(str, z, str2, str3);
        AppMethodBeat.o(5970);
    }

    public final void dx(String str, int i) {
        AppMethodBeat.i(5971);
        d dVar = this.uhz;
        if (dVar.ready) {
            ab.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
            HashMap hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("height", Integer.valueOf(i));
            al.d(new AnonymousClass32(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onSearchWAWidgetAttrChanged", hashMap, dVar.uFv, dVar.uFw)));
            AppMethodBeat.o(5971);
            return;
        }
        ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
        AppMethodBeat.o(5971);
    }

    public final void cUV() {
    }
}
