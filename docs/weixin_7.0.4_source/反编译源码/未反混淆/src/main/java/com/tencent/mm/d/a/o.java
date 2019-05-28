package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

final class o extends n {
    f chr;

    o(f fVar) {
        this.chr = fVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(final l lVar, V8Object v8Object) {
        AppMethodBeat.i(113860);
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113857);
                ab.i("V8DirectApiBuffer", "generateId:%d", Integer.valueOf(o.this.chr.Cv()));
                AppMethodBeat.o(113857);
                return Integer.valueOf(o.this.chr.Cv());
            }
        }, "getNativeBufferId");
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113858);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    ab.w("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
                    AppMethodBeat.o(113858);
                    return null;
                }
                ab.i("V8DirectApiBuffer", "getNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                ByteBuffer gq = o.this.chr.gq(v8Array.getInteger(0));
                if (gq == null) {
                    ab.w("V8DirectApiBuffer", "getNativeBuffer bb null");
                    AppMethodBeat.o(113858);
                    return null;
                }
                Object newV8ArrayBuffer = lVar.CB().newV8ArrayBuffer(gq);
                AppMethodBeat.o(113858);
                return newV8ArrayBuffer;
            }
        }, "getNativeBuffer");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113859);
                if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 10) {
                    ab.w("V8DirectApiBuffer", "setNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                    V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) v8Array.get(1);
                    if (v8ArrayBuffer != null) {
                        o.this.chr.a(v8Array.getInteger(0), v8ArrayBuffer.getBackingStore());
                        v8ArrayBuffer.release();
                        AppMethodBeat.o(113859);
                        return;
                    }
                    ab.w("V8DirectApiBuffer", "setNativeBuffer buffer null");
                    AppMethodBeat.o(113859);
                    return;
                }
                ab.w("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
                AppMethodBeat.o(113859);
            }
        }, "setNativeBuffer");
        AppMethodBeat.o(113860);
    }

    public final void cleanup() {
    }
}
