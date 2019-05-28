package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;

/* renamed from: com.tencent.smtt.sdk.bn */
class C46739bn extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f18016a;
    /* renamed from: b */
    final /* synthetic */ WebView f18017b;

    C46739bn(WebView webView, Context context) {
        this.f18017b = webView;
        this.f18016a = context;
    }

    public void run() {
        AppMethodBeat.m2504i(64832);
        try {
            QbSdk.f16243e = Apn.getApnType(this.f18016a) == 3;
            QbSdk.f16244f = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f18016a.getApplicationContext().registerReceiver(WebView.f13869n, intentFilter);
            AppMethodBeat.m2505o(64832);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64832);
        }
    }
}
