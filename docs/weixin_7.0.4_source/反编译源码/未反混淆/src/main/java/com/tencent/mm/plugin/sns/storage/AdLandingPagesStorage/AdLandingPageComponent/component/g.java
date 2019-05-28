package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class g extends h {
    public g(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37062);
        if (((aa) cpB()) != null) {
            String str;
            WebView webView = (WebView) getView();
            aa aaVar = (aa) cpB();
            if (TextUtils.isEmpty(aaVar.url) || TextUtils.isEmpty(cpC().qPj)) {
                str = aaVar.url;
            } else {
                String uin = AdLandingPagesProxy.getInstance().getUin();
                String m = ad.m(aaVar.url, "uxinfo=" + cpC().qPj, "uin=".concat(String.valueOf(uin)));
                if (aaVar.cuu == 1) {
                    str = AdLandingPagesProxy.getInstance().getAdVoteInfo(aaVar.url, cpC().qPj, uin);
                    if (!bo.isNullOrNil(str)) {
                        str = m + "&" + str;
                    }
                }
                str = m;
            }
            webView.loadUrl(str);
        }
        AppMethodBeat.o(37062);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37063);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(37063);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.i(37064);
        MMWebView du = a.uJi.du(this.context);
        du.getSettings().dUe();
        du.getSettings().dUi();
        du.getSettings().dUh();
        du.setWebViewClient(c.a.uJh.a(du, false, new d() {
            public final boolean c(int i, Bundle bundle) {
                AppMethodBeat.i(37061);
                switch (i) {
                    case 150:
                        aa aaVar = (aa) g.this.cpB();
                        AdLandingPagesProxy.getInstance().saveAdVoteInfo(aaVar.url, g.this.cpC().qPj, g.this.cpC().uin, bundle.getInt("sns_landing_pages_ad_vote_index"), 0);
                        break;
                }
                AppMethodBeat.o(37061);
                return false;
            }
        }));
        AppMethodBeat.o(37064);
        return du;
    }

    public final void coZ() {
        AppMethodBeat.i(37065);
        super.coZ();
        WebView webView = (WebView) getView();
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.destroy();
        }
        this.contentView = null;
        AppMethodBeat.o(37065);
    }
}
