package com.tencent.xweb.p685x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.p1115c.C24524e;

/* renamed from: com.tencent.xweb.x5.i */
public final class C36598i implements C24524e {
    C41133c AQF = new C41133c();
    C31150b AQG = new C31150b();
    WebView AQH;

    public C36598i(WebView webView) {
        AppMethodBeat.m2504i(84853);
        this.AQH = webView;
        AppMethodBeat.m2505o(84853);
    }

    /* renamed from: w */
    public final void mo13225w(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(84854);
        this.AQF.mo65693b(this.AQH, str, bitmap);
        AppMethodBeat.m2505o(84854);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
        AppMethodBeat.m2504i(84855);
        this.AQG.dVA();
        AppMethodBeat.m2505o(84855);
    }

    /* renamed from: a */
    public final boolean mo13220a(String str, String str2, C46945h c46945h) {
        return false;
    }

    /* renamed from: b */
    public final boolean mo13222b(String str, String str2, C46945h c46945h) {
        return false;
    }

    /* renamed from: a */
    public final boolean mo13221a(String str, String str2, String str3, C41127g c41127g) {
        return false;
    }
}
