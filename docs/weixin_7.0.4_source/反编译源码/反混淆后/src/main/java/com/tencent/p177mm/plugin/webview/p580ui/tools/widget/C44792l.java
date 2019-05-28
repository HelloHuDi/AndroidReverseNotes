package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.l */
public final class C44792l extends C43989k {
    C35726d uJH;
    private C46936m uJI;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.l$1 */
    class C231591 extends C46936m {
        C231591() {
        }

        /* renamed from: c */
        public final boolean mo26784c(int i, Bundle bundle) {
            AppMethodBeat.m2504i(10021);
            boolean c;
            if (C44792l.this.uJH != null) {
                c = C44792l.this.uJH.mo20984c(i, bundle);
                AppMethodBeat.m2505o(10021);
                return c;
            }
            c = super.mo26784c(i, bundle);
            AppMethodBeat.m2505o(10021);
            return c;
        }

        /* renamed from: W */
        public final void mo9706W(Bundle bundle) {
            AppMethodBeat.m2504i(10022);
            if ((C44792l.this.uJH instanceof C36860e) && ((C36860e) C44792l.this.uJH).aba()) {
                AppMethodBeat.m2505o(10022);
                return;
            }
            super.mo9706W(bundle);
            AppMethodBeat.m2505o(10022);
        }
    }

    public C44792l(MMWebView mMWebView, boolean z, C35726d c35726d) {
        this(mMWebView, z, c35726d, null);
    }

    public C44792l(MMWebView mMWebView, boolean z, C35726d c35726d, Bundle bundle) {
        super(mMWebView, z, bundle);
        this.uJH = null;
        this.uJI = null;
        this.uJH = c35726d;
    }

    /* Access modifiers changed, original: protected|final */
    public final C46936m aGt() {
        AppMethodBeat.m2504i(10023);
        if (this.uJI == null) {
            this.uJI = new C231591();
        }
        C46936m c46936m = this.uJI;
        AppMethodBeat.m2505o(10023);
        return c46936m;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo38564a(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(10024);
        super.mo38564a(webView, str, bitmap);
        if (this.uJH instanceof C36860e) {
            ((C36860e) this.uJH).abb();
        }
        AppMethodBeat.m2505o(10024);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final void mo38573e(WebView webView, String str) {
        AppMethodBeat.m2504i(10025);
        super.mo38573e(webView, str);
        if (this.uJH instanceof C36860e) {
            ((C36860e) this.uJH).mo20981a((MMWebView) webView);
        }
        AppMethodBeat.m2505o(10025);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: oZ */
    public final boolean mo44753oZ(String str) {
        AppMethodBeat.m2504i(10026);
        boolean oZ;
        if (this.uJH == null || !(this.uJH instanceof C36860e)) {
            oZ = super.mo44753oZ(str);
            AppMethodBeat.m2505o(10026);
            return oZ;
        }
        oZ = ((C36860e) this.uJH).mo20985oZ(str);
        AppMethodBeat.m2505o(10026);
        return oZ;
    }
}
