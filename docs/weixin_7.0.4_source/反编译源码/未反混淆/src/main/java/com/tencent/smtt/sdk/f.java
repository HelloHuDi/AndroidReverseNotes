package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class f implements ValueCallback<String> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ a b;

    f(a aVar, ValueCallback valueCallback) {
        this.b = aVar;
        this.a = valueCallback;
    }

    public void a(String str) {
        AppMethodBeat.i(63959);
        this.a.onReceiveValue(null);
        AppMethodBeat.o(63959);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(63960);
        a((String) obj);
        AppMethodBeat.o(63960);
    }
}
