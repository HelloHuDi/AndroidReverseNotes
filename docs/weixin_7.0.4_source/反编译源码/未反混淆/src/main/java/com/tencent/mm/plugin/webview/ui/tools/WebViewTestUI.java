package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;

public class WebViewTestUI extends MMActivity {
    private s iuo = new s() {
        public final void b(WebView webView, String str) {
            AppMethodBeat.i(7804);
            super.b(webView, str);
            AppMethodBeat.o(7804);
        }
    };
    MMWebViewWithJsApi uuU;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewTestUI() {
        AppMethodBeat.i(7805);
        AppMethodBeat.o(7805);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7806);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.uuU = a.fw(this);
        this.uuU.setWebViewClient(this.iuo);
        setContentView((View) this.uuU);
        this.uuU.loadUrl(stringExtra);
        AppMethodBeat.o(7806);
    }

    public final int getLayoutId() {
        return -1;
    }
}
