package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class y implements ValueCallback<String[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ SystemWebChromeClient b;

    y(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.b = systemWebChromeClient;
        this.a = valueCallback;
    }

    public void a(String[] strArr) {
        AppMethodBeat.i(64149);
        this.a.onReceiveValue(strArr);
        AppMethodBeat.o(64149);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(64150);
        a((String[]) obj);
        AppMethodBeat.o(64150);
    }
}
