package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi.C14670a;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewTestUI */
public class WebViewTestUI extends MMActivity {
    private C36592s iuo = new C79001();
    MMWebViewWithJsApi uuU;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewTestUI$1 */
    class C79001 extends C36592s {
        C79001() {
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(7804);
            super.mo5992b(webView, str);
            AppMethodBeat.m2505o(7804);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WebViewTestUI() {
        AppMethodBeat.m2504i(7805);
        AppMethodBeat.m2505o(7805);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7806);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.uuU = C14670a.m22876fw(this);
        this.uuU.setWebViewClient(this.iuo);
        setContentView((View) this.uuU);
        this.uuU.loadUrl(stringExtra);
        AppMethodBeat.m2505o(7806);
    }

    public final int getLayoutId() {
        return -1;
    }
}
