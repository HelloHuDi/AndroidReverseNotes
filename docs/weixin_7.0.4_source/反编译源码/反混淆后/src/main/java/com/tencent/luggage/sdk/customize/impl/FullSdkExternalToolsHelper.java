package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.BaseActivity;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38402w;
import com.tencent.p177mm.protocal.protobuf.bzx;

public final class FullSdkExternalToolsHelper implements C38402w {

    public static class SimpleWebViewActivity extends BaseActivity {
        private WebView webView;

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            AppMethodBeat.m2503at(this, z);
        }

        public void onCreate(Bundle bundle) {
            AppMethodBeat.m2504i(101627);
            super.onCreate(bundle);
            this.webView = (WebView) findViewById(2131822360);
            m15853j(getIntent());
            AppMethodBeat.m2505o(101627);
        }

        public void onNewIntent(Intent intent) {
            AppMethodBeat.m2504i(101628);
            super.onNewIntent(intent);
            m15853j(intent);
            AppMethodBeat.m2505o(101628);
        }

        /* renamed from: j */
        private void m15853j(Intent intent) {
            AppMethodBeat.m2504i(101629);
            String stringExtra = intent.getStringExtra("_url_");
            this.webView.stopLoading();
            this.webView.loadUrl(stringExtra);
            AppMethodBeat.m2505o(101629);
        }
    }

    /* renamed from: a */
    public final void mo20078a(Context context, String str, bzx bzx) {
        AppMethodBeat.m2504i(101630);
        C45124d.m82926d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", str);
        Intent intent = new Intent(context, SimpleWebViewActivity.class);
        intent.putExtra("_url_", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(101630);
    }
}
