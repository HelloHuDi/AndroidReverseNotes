package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;

public final class g extends s {
    private Context context;

    public g(Context context) {
        this.context = context;
    }

    public final boolean a(WebView webView, String str) {
        AppMethodBeat.i(47131);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        ab.d("MicroMsg.ProtoColWebViewClient", "raw url: %s", intent.getStringExtra("rawUrl"));
        d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(47131);
        return true;
    }
}
