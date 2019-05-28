package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class s implements ValueCallback<Uri> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ q b;

    s(q qVar, ValueCallback valueCallback) {
        this.b = qVar;
        this.a = valueCallback;
    }

    public void a(Uri uri) {
        AppMethodBeat.i(64081);
        this.a.onReceiveValue(new Uri[]{uri});
        AppMethodBeat.o(64081);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(64082);
        a((Uri) obj);
        AppMethodBeat.o(64082);
    }
}
