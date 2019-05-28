package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.l;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.d;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class e extends d {
    public e(Context context) {
        super(context);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(135841);
        super.onAttachedToWindow();
        getWebCore().a(new c() {
            public final String name() {
                return "onJsApiReady";
            }

            public final JSONObject wQ() {
                return null;
            }
        });
        AppMethodBeat.o(135841);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(135842);
        super.onDetachedFromWindow();
        AppMethodBeat.o(135842);
    }

    public final void xo() {
        AppMethodBeat.i(135843);
        getWebCore().bPz = new l() {
            public final void bE(String str) {
            }

            public final void bF(String str) {
            }

            public final String xt() {
                AppMethodBeat.i(135840);
                String p = i.p(e.this.getContext(), "preload_game_adapter.js");
                AppMethodBeat.o(135840);
                return p;
            }

            public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
                return null;
            }
        };
        if (getWebCore().bPD != null) {
            getWebCore().bPD.a(new LuggageMMLocalResourceProvider());
            getWebCore().bPD.a(new b(i.p(ah.getContext(), "preload_game_adapter.js")));
        }
        AppMethodBeat.o(135843);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(135844);
        super.b(webView, str, bitmap);
        AppMethodBeat.o(135844);
    }

    public final void b(WebView webView, String str) {
        AppMethodBeat.i(135845);
        super.b(webView, str);
        AppMethodBeat.o(135845);
    }
}
