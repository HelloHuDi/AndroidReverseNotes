package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C31414aa;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29959f.C23152a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C35726d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40347c.C40348a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g */
public final class C46229g extends C13437h {

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g$1 */
    class C368091 implements C35726d {
        C368091() {
        }

        /* renamed from: c */
        public final boolean mo20984c(int i, Bundle bundle) {
            AppMethodBeat.m2504i(37061);
            switch (i) {
                case 150:
                    C31414aa c31414aa = (C31414aa) C46229g.this.cpB();
                    AdLandingPagesProxy.getInstance().saveAdVoteInfo(c31414aa.url, C46229g.this.cpC().qPj, C46229g.this.cpC().uin, bundle.getInt("sns_landing_pages_ad_vote_index"), 0);
                    break;
            }
            AppMethodBeat.m2505o(37061);
            return false;
        }
    }

    public C46229g(Context context, C29086r c29086r, ViewGroup viewGroup) {
        super(context, c29086r, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37062);
        if (((C31414aa) cpB()) != null) {
            String str;
            WebView webView = (WebView) getView();
            C31414aa c31414aa = (C31414aa) cpB();
            if (TextUtils.isEmpty(c31414aa.url) || TextUtils.isEmpty(cpC().qPj)) {
                str = c31414aa.url;
            } else {
                String uin = AdLandingPagesProxy.getInstance().getUin();
                String m = C29064ad.m46209m(c31414aa.url, "uxinfo=" + cpC().qPj, "uin=".concat(String.valueOf(uin)));
                if (c31414aa.cuu == 1) {
                    str = AdLandingPagesProxy.getInstance().getAdVoteInfo(c31414aa.url, cpC().qPj, uin);
                    if (!C5046bo.isNullOrNil(str)) {
                        str = m + "&" + str;
                    }
                }
                str = m;
            }
            webView.loadUrl(str);
        }
        AppMethodBeat.m2505o(37062);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37063);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(37063);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.m2504i(37064);
        MMWebView du = C23152a.uJi.mo30691du(this.context);
        du.getSettings().dUe();
        du.getSettings().dUi();
        du.getSettings().dUh();
        du.setWebViewClient(C40348a.uJh.mo30693a(du, false, new C368091()));
        AppMethodBeat.m2505o(37064);
        return du;
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37065);
        super.coZ();
        WebView webView = (WebView) getView();
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.destroy();
        }
        this.contentView = null;
        AppMethodBeat.m2505o(37065);
    }
}
