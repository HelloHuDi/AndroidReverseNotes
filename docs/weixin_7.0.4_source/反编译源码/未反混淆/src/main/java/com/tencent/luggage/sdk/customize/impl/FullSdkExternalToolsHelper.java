package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.ui.BaseActivity;

public final class FullSdkExternalToolsHelper implements w {

    public static class SimpleWebViewActivity extends BaseActivity {
        private WebView webView;

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            AppMethodBeat.at(this, z);
        }

        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(101627);
            super.onCreate(bundle);
            this.webView = (WebView) findViewById(R.id.al2);
            j(getIntent());
            AppMethodBeat.o(101627);
        }

        public void onNewIntent(Intent intent) {
            AppMethodBeat.i(101628);
            super.onNewIntent(intent);
            j(intent);
            AppMethodBeat.o(101628);
        }

        private void j(Intent intent) {
            AppMethodBeat.i(101629);
            String stringExtra = intent.getStringExtra("_url_");
            this.webView.stopLoading();
            this.webView.loadUrl(stringExtra);
            AppMethodBeat.o(101629);
        }
    }

    public final void a(Context context, String str, bzx bzx) {
        AppMethodBeat.i(101630);
        d.d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", str);
        Intent intent = new Intent(context, SimpleWebViewActivity.class);
        intent.putExtra("_url_", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.o(101630);
    }
}
