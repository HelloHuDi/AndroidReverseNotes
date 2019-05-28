package com.tencent.mm.plugin.appbrand.dynamic.html;

import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;

public class CustomURLSpan extends URLSpan {
    private String mUrl;

    public CustomURLSpan(String str) {
        super(str);
        this.mUrl = str;
    }

    public void onClick(View view) {
        AppMethodBeat.i(10813);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mUrl);
        d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        ab.d("MicroMsg.CustomURLSpan", "on custom url(%s) span clicked.", this.mUrl);
        AppMethodBeat.o(10813);
    }
}
