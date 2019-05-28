package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;

class bn extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ WebView b;

    bn(WebView webView, Context context) {
        this.b = webView;
        this.a = context;
    }

    public void run() {
        AppMethodBeat.i(64832);
        try {
            QbSdk.e = Apn.getApnType(this.a) == 3;
            QbSdk.f = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.a.getApplicationContext().registerReceiver(WebView.n, intentFilter);
            AppMethodBeat.o(64832);
        } catch (Throwable th) {
            AppMethodBeat.o(64832);
        }
    }
}
