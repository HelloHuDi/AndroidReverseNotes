package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.JavaCallback;
import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8ArrayBuffer;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.d.a.o */
final class C1487o extends C9265n {
    C9256f chr;

    /* renamed from: com.tencent.mm.d.a.o$1 */
    class C14891 implements JavaCallback {
        C14891() {
        }

        public final Object invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113857);
            C4990ab.m7417i("V8DirectApiBuffer", "generateId:%d", Integer.valueOf(C1487o.this.chr.mo20675Cv()));
            AppMethodBeat.m2505o(113857);
            return Integer.valueOf(C1487o.this.chr.mo20675Cv());
        }
    }

    /* renamed from: com.tencent.mm.d.a.o$3 */
    class C14903 implements JavaVoidCallback {
        C14903() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113859);
            if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 10) {
                C4990ab.m7421w("V8DirectApiBuffer", "setNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) v8Array.get(1);
                if (v8ArrayBuffer != null) {
                    C1487o.this.chr.mo20676a(v8Array.getInteger(0), v8ArrayBuffer.getBackingStore());
                    v8ArrayBuffer.release();
                    AppMethodBeat.m2505o(113859);
                    return;
                }
                C4990ab.m7420w("V8DirectApiBuffer", "setNativeBuffer buffer null");
                AppMethodBeat.m2505o(113859);
                return;
            }
            C4990ab.m7420w("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
            AppMethodBeat.m2505o(113859);
        }
    }

    C1487o(C9256f c9256f) {
        this.chr = c9256f;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo4940a(final C32488l c32488l, V8Object v8Object) {
        AppMethodBeat.m2504i(113860);
        v8Object.registerJavaMethod(new C14891(), "getNativeBufferId");
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.m2504i(113858);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    C4990ab.m7420w("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
                    AppMethodBeat.m2505o(113858);
                    return null;
                }
                C4990ab.m7417i("V8DirectApiBuffer", "getNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                ByteBuffer gq = C1487o.this.chr.mo20677gq(v8Array.getInteger(0));
                if (gq == null) {
                    C4990ab.m7420w("V8DirectApiBuffer", "getNativeBuffer bb null");
                    AppMethodBeat.m2505o(113858);
                    return null;
                }
                Object newV8ArrayBuffer = c32488l.mo53119CB().newV8ArrayBuffer(gq);
                AppMethodBeat.m2505o(113858);
                return newV8ArrayBuffer;
            }
        }, "getNativeBuffer");
        v8Object.registerJavaMethod(new C14903(), "setNativeBuffer");
        AppMethodBeat.m2505o(113860);
    }

    public final void cleanup() {
    }
}
