package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class e implements ValueCallback<String> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ a b;

    e(a aVar, ValueCallback valueCallback) {
        this.b = aVar;
        this.a = valueCallback;
    }

    public void a(String str) {
        AppMethodBeat.i(63957);
        this.a.onReceiveValue(str);
        AppMethodBeat.o(63957);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(63958);
        a((String) obj);
        AppMethodBeat.o(63958);
    }
}
