package com.tencent.p177mm.plugin.appbrand.dynamic.html;

import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan */
public class CustomURLSpan extends URLSpan {
    private String mUrl;

    public CustomURLSpan(String str) {
        super(str);
        this.mUrl = str;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(10813);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mUrl);
        C25985d.m41467b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        C4990ab.m7411d("MicroMsg.CustomURLSpan", "on custom url(%s) span clicked.", this.mUrl);
        AppMethodBeat.m2505o(10813);
    }
}
