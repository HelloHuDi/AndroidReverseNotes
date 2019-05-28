package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends n {
    final e chP;

    public q(e eVar) {
        super("WeixinArrayBuffer");
        this.chP = eVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(l lVar, V8Object v8Object) {
        AppMethodBeat.i(113869);
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113868);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    ab.w("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
                    AppMethodBeat.o(113868);
                    return null;
                }
                ab.i("MicroMsg.V8DirectApiSharedBuffer", "get, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                Object go = q.this.chP.go(r0);
                AppMethodBeat.o(113868);
                return go;
            }
        }, "get");
        AppMethodBeat.o(113869);
    }

    /* Access modifiers changed, original: final */
    public final void cleanup() {
    }
}
