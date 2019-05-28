package com.tencent.mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.d;

public final class a implements c {
    private d mTG;

    public a(d dVar) {
        this.mTG = dVar;
    }

    public final String yk() {
        return "weixin://game.js";
    }

    public final WebResourceResponse bG(String str) {
        AppMethodBeat.i(135806);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(135806);
            return null;
        }
        boolean z = false;
        if (this.mTG.getWePkgPlugin() != null) {
            z = this.mTG.getWePkgPlugin().uVv;
        }
        WebResourceResponse nX = com.tencent.mm.plugin.webview.ui.tools.game.d.nX(z);
        AppMethodBeat.o(135806);
        return nX;
    }
}
