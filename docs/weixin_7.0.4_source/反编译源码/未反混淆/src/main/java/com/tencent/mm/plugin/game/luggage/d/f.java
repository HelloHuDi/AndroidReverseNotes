package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public final class f extends e {
    public f(g gVar, k kVar, Bundle bundle) {
        super(gVar, kVar, bundle);
        AppMethodBeat.i(135996);
        a.c(getWebView());
        l.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135994);
                f.this.bPN.a(new c() {
                    public final String name() {
                        return "onAttachedToWindow";
                    }

                    public final JSONObject wQ() {
                        return null;
                    }
                });
                AppMethodBeat.o(135994);
            }
        });
        l.r(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135995);
                if (f.this.getWebView() != null) {
                    String title = f.this.getWebView().getTitle();
                    if (!bo.isNullOrNil(title)) {
                        f.this.cl(title, 0);
                    }
                }
                AppMethodBeat.o(135995);
            }
        });
        bDK();
        AppMethodBeat.o(135996);
    }

    public final void e(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(135998);
        ab.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(135998);
    }

    public final void g(String str, Bundle bundle) {
        AppMethodBeat.i(135999);
        super.g(str, bundle);
        AppMethodBeat.o(135999);
    }

    public final void bF(String str) {
        AppMethodBeat.i(136000);
        super.bF(str);
        bDK();
        AppMethodBeat.o(136000);
    }

    public final boolean NS(String str) {
        AppMethodBeat.i(136001);
        if (str.equals(cWL())) {
            AppMethodBeat.o(136001);
            return false;
        }
        boolean NS = super.NS(str);
        AppMethodBeat.o(136001);
        return NS;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.webview.ui.tools.game.g NR(String str) {
        AppMethodBeat.i(136003);
        com.tencent.mm.plugin.webview.ui.tools.game.g agh = com.tencent.mm.plugin.webview.ui.tools.game.g.agh(str);
        AppMethodBeat.o(136003);
        return agh;
    }

    public final String xt() {
        AppMethodBeat.i(135997);
        String p = i.p(this.mContext, "preload_game_adapter.js");
        AppMethodBeat.o(135997);
        return p;
    }

    private void bDK() {
        AppMethodBeat.i(136002);
        this.bPN.a(new c() {
            public final String name() {
                return "onJsApiReady";
            }

            public final JSONObject wQ() {
                return null;
            }
        });
        AppMethodBeat.o(136002);
    }
}
