package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class aa implements ValueCallback<Uri> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ SystemWebChromeClient b;

    aa(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.b = systemWebChromeClient;
        this.a = valueCallback;
    }

    public void a(Uri uri) {
        AppMethodBeat.i(64152);
        this.a.onReceiveValue(uri);
        AppMethodBeat.o(64152);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(64153);
        a((Uri) obj);
        AppMethodBeat.o(64153);
    }
}
