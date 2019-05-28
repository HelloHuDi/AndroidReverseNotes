package com.tencent.p177mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C17819l;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C3228d;
import com.tencent.p177mm.plugin.webview.luggage.C14462b;
import com.tencent.p177mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.e */
public class C28214e extends C3228d {

    /* renamed from: com.tencent.mm.plugin.game.luggage.e$1 */
    class C32401 extends C17817c {
        C32401() {
        }

        public final String name() {
            return "onJsApiReady";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.e$2 */
    class C32412 extends C17819l {
        C32412() {
        }

        /* renamed from: bE */
        public final void mo3960bE(String str) {
        }

        /* renamed from: bF */
        public final void mo3961bF(String str) {
        }

        /* renamed from: xt */
        public final String mo3962xt() {
            AppMethodBeat.m2504i(135840);
            String p = C32192i.m52511p(C28214e.this.getContext(), "preload_game_adapter.js");
            AppMethodBeat.m2505o(135840);
            return p;
        }

        /* renamed from: a */
        public final WebResourceResponse mo3959a(WebResourceRequest webResourceRequest, Bundle bundle) {
            return null;
        }
    }

    public C28214e(Context context) {
        super(context);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(135841);
        super.onAttachedToWindow();
        getWebCore().mo52826a(new C32401());
        AppMethodBeat.m2505o(135841);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(135842);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(135842);
    }

    /* renamed from: xo */
    public final void mo7556xo() {
        AppMethodBeat.m2504i(135843);
        getWebCore().bPz = new C32412();
        if (getWebCore().bPD != null) {
            getWebCore().bPD.mo33005a(new LuggageMMLocalResourceProvider());
            getWebCore().bPD.mo33005a(new C14462b(C32192i.m52511p(C4996ah.getContext(), "preload_game_adapter.js")));
        }
        AppMethodBeat.m2505o(135843);
    }

    /* renamed from: b */
    public final void mo7545b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(135844);
        super.mo7545b(webView, str, bitmap);
        AppMethodBeat.m2505o(135844);
    }

    /* renamed from: b */
    public final void mo7544b(WebView webView, String str) {
        AppMethodBeat.m2504i(135845);
        super.mo7544b(webView, str);
        AppMethodBeat.m2505o(135845);
    }
}
