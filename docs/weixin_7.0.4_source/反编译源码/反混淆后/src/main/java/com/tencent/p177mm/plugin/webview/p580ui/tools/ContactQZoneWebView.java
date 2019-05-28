package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView */
public class ContactQZoneWebView extends WebViewUI {
    private String phw = "";
    private boolean ura = false;
    private String urb = "";

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView$1 */
    class C45681 extends C36592s {
        C45681() {
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(7348);
            if (str.startsWith("weixin://viewimage/")) {
                ContactQZoneWebView.this.afr(str);
                webView.stopLoading();
            } else if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                AppMethodBeat.m2505o(7348);
                return true;
            } else {
                webView.loadUrl(str);
            }
            AppMethodBeat.m2505o(7348);
            return true;
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(7349);
            if (str.startsWith("weixin://viewimage/")) {
                ContactQZoneWebView.this.afr(str);
                webView.stopLoading();
                AppMethodBeat.m2505o(7349);
            } else if (str.equals(ContactQZoneWebView.this.phw)) {
                C5046bo.m7506M(ContactQZoneWebView.this, str);
                webView.stopLoading();
                AppMethodBeat.m2505o(7349);
            } else {
                super.mo7562b(webView, str, bitmap);
                AppMethodBeat.m2505o(7349);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7350);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.g29));
        this.pzf.setWebViewClient(new C45681());
        this.pzf.loadUrl(this.cOG);
        C4990ab.m7410d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.cOG);
        AppMethodBeat.m2505o(7350);
    }

    public void onResume() {
        AppMethodBeat.m2504i(7351);
        super.onResume();
        this.ura = false;
        AppMethodBeat.m2505o(7351);
    }

    /* Access modifiers changed, original: final */
    public final void afr(String str) {
        AppMethodBeat.m2504i(7352);
        if (this.ura) {
            AppMethodBeat.m2505o(7352);
            return;
        }
        this.ura = true;
        String substring = str.substring(19);
        C4990ab.m7410d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(substring)));
        Intent intent = new Intent();
        intent.putExtra("nowUrl", substring);
        intent.putExtra("tweetid", C5046bo.nullAsNil(getIntent().getStringExtra("tweetid")));
        intent.putExtra("htmlData", this.urb);
        intent.putExtra("type", getIntent().getIntExtra("type", 0));
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 4);
        bundle.putString("stat_url", dae());
        intent.putExtra("_stat_obj", bundle);
        startActivity(intent);
        C40211a.gkE.mo38932q(intent, this);
        AppMethodBeat.m2505o(7352);
    }
}
