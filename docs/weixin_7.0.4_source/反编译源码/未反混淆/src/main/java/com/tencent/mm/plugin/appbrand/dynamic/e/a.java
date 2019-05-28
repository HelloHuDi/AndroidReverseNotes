package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.r;
import com.tencent.mm.z.b.d;

public final class a implements d {
    public c hoa = new c();

    public a(Object obj) {
        AppMethodBeat.i(10902);
        this.hoa.addJavascriptInterface(obj, "WeixinJSCore");
        AppMethodBeat.o(10902);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(10903);
        if (this.hoa != null) {
            this.hoa.evaluateJavascript(str, valueCallback);
        }
        AppMethodBeat.o(10903);
    }

    public final void cleanup() {
        AppMethodBeat.i(10904);
        if (this.hoa != null) {
            this.hoa.destroy();
        }
        AppMethodBeat.o(10904);
    }

    public final void pause() {
        AppMethodBeat.i(10905);
        if (this.hoa != null) {
            ((r) this.hoa.af(r.class)).pause();
        }
        AppMethodBeat.o(10905);
    }

    public final void resume() {
        AppMethodBeat.i(10906);
        if (this.hoa != null) {
            ((r) this.hoa.af(r.class)).resume();
        }
        AppMethodBeat.o(10906);
    }
}
