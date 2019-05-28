package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class t implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ q b;

    t(q qVar, ValueCallback valueCallback) {
        this.b = qVar;
        this.a = valueCallback;
    }

    public void a(Uri[] uriArr) {
        AppMethodBeat.i(64083);
        this.a.onReceiveValue(uriArr);
        AppMethodBeat.o(64083);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(64084);
        a((Uri[]) obj);
        AppMethodBeat.o(64084);
    }
}
