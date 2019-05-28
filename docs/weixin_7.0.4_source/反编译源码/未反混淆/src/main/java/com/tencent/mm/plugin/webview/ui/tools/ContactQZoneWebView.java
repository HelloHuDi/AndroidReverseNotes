package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;

public class ContactQZoneWebView extends WebViewUI {
    private String phw = "";
    private boolean ura = false;
    private String urb = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7350);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.g29));
        this.pzf.setWebViewClient(new s() {
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(7348);
                if (str.startsWith("weixin://viewimage/")) {
                    ContactQZoneWebView.this.afr(str);
                    webView.stopLoading();
                } else if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                    AppMethodBeat.o(7348);
                    return true;
                } else {
                    webView.loadUrl(str);
                }
                AppMethodBeat.o(7348);
                return true;
            }

            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(7349);
                if (str.startsWith("weixin://viewimage/")) {
                    ContactQZoneWebView.this.afr(str);
                    webView.stopLoading();
                    AppMethodBeat.o(7349);
                } else if (str.equals(ContactQZoneWebView.this.phw)) {
                    bo.M(ContactQZoneWebView.this, str);
                    webView.stopLoading();
                    AppMethodBeat.o(7349);
                } else {
                    super.b(webView, str, bitmap);
                    AppMethodBeat.o(7349);
                }
            }
        });
        this.pzf.loadUrl(this.cOG);
        ab.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.cOG);
        AppMethodBeat.o(7350);
    }

    public void onResume() {
        AppMethodBeat.i(7351);
        super.onResume();
        this.ura = false;
        AppMethodBeat.o(7351);
    }

    /* Access modifiers changed, original: final */
    public final void afr(String str) {
        AppMethodBeat.i(7352);
        if (this.ura) {
            AppMethodBeat.o(7352);
            return;
        }
        this.ura = true;
        String substring = str.substring(19);
        ab.d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(substring)));
        Intent intent = new Intent();
        intent.putExtra("nowUrl", substring);
        intent.putExtra("tweetid", bo.nullAsNil(getIntent().getStringExtra("tweetid")));
        intent.putExtra("htmlData", this.urb);
        intent.putExtra("type", getIntent().getIntExtra("type", 0));
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 4);
        bundle.putString("stat_url", dae());
        intent.putExtra("_stat_obj", bundle);
        startActivity(intent);
        a.gkE.q(intent, this);
        AppMethodBeat.o(7352);
    }
}
