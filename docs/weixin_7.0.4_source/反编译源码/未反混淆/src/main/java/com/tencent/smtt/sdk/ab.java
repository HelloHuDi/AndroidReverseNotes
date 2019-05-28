package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ab implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ SystemWebChromeClient b;

    ab(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.b = systemWebChromeClient;
        this.a = valueCallback;
    }

    public void a(Uri[] uriArr) {
        AppMethodBeat.i(64154);
        this.a.onReceiveValue(uriArr);
        AppMethodBeat.o(64154);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(64155);
        a((Uri[]) obj);
        AppMethodBeat.o(64155);
    }
}
