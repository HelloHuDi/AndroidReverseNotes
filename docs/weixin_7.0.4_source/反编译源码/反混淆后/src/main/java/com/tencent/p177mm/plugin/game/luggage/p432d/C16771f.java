package com.tencent.p177mm.plugin.game.luggage.p432d;

import android.os.Bundle;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p146d.C41709g;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.plugin.webview.model.C40252a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43963g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.d.f */
public final class C16771f extends C12140e {

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.f$1 */
    class C121431 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.game.luggage.d.f$1$1 */
        class C121441 extends C17817c {
            C121441() {
            }

            public final String name() {
                return "onAttachedToWindow";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                return null;
            }
        }

        C121431() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135994);
            C16771f.this.bPN.mo52826a(new C121441());
            AppMethodBeat.m2505o(135994);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.f$3 */
    class C121453 extends C17817c {
        C121453() {
        }

        public final String name() {
            return "onJsApiReady";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.f$2 */
    class C167722 implements Runnable {
        C167722() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135995);
            if (C16771f.this.getWebView() != null) {
                String title = C16771f.this.getWebView().getTitle();
                if (!C5046bo.isNullOrNil(title)) {
                    C16771f.this.mo41795cl(title, 0);
                }
            }
            AppMethodBeat.m2505o(135995);
        }
    }

    public C16771f(C41709g c41709g, C32186k c32186k, Bundle bundle) {
        super(c41709g, c32186k, bundle);
        AppMethodBeat.m2504i(135996);
        C40252a.m69033c(getWebView());
        C18514l.post(new C121431());
        C18514l.m28820r(new C167722());
        bDK();
        AppMethodBeat.m2505o(135996);
    }

    /* renamed from: e */
    public final void mo23978e(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(135998);
        C4990ab.m7417i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(135998);
    }

    /* renamed from: g */
    public final void mo20038g(String str, Bundle bundle) {
        AppMethodBeat.m2504i(135999);
        super.mo20038g(str, bundle);
        AppMethodBeat.m2505o(135999);
    }

    /* renamed from: bF */
    public final void mo23977bF(String str) {
        AppMethodBeat.m2504i(136000);
        super.mo23977bF(str);
        bDK();
        AppMethodBeat.m2505o(136000);
    }

    /* renamed from: NS */
    public final boolean mo23966NS(String str) {
        AppMethodBeat.m2504i(136001);
        if (str.equals(cWL())) {
            AppMethodBeat.m2505o(136001);
            return false;
        }
        boolean NS = super.mo23966NS(str);
        AppMethodBeat.m2505o(136001);
        return NS;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: NR */
    public final C43963g mo23965NR(String str) {
        AppMethodBeat.m2504i(136003);
        C43963g agh = C43963g.agh(str);
        AppMethodBeat.m2505o(136003);
        return agh;
    }

    /* renamed from: xt */
    public final String mo30766xt() {
        AppMethodBeat.m2504i(135997);
        String p = C32192i.m52511p(this.mContext, "preload_game_adapter.js");
        AppMethodBeat.m2505o(135997);
        return p;
    }

    private void bDK() {
        AppMethodBeat.m2504i(136002);
        this.bPN.mo52826a(new C121453());
        AppMethodBeat.m2505o(136002);
    }
}
