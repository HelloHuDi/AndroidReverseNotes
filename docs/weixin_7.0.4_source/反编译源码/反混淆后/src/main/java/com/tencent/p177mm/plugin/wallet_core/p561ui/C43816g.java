package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.g */
public final class C43816g extends C36592s {
    private Context context;

    public C43816g(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public final boolean mo4762a(WebView webView, String str) {
        AppMethodBeat.m2504i(47131);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        C4990ab.m7411d("MicroMsg.ProtoColWebViewClient", "raw url: %s", intent.getStringExtra("rawUrl"));
        C25985d.m41467b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(47131);
        return true;
    }
}
