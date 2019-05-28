package com.bumptech.glide.p086c.p092d.p1135b;

import com.bumptech.glide.p086c.p087a.C8511e;
import com.bumptech.glide.p086c.p087a.C8511e.C8512a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.c.d.b.a */
public final class C16506a implements C8511e<ByteBuffer> {
    private final ByteBuffer buffer;

    /* renamed from: com.bumptech.glide.c.d.b.a$a */
    public static class C16507a implements C8512a<ByteBuffer> {
        /* renamed from: T */
        public final /* synthetic */ C8511e mo2195T(Object obj) {
            AppMethodBeat.m2504i(92281);
            C16506a c16506a = new C16506a((ByteBuffer) obj);
            AppMethodBeat.m2505o(92281);
            return c16506a;
        }

        /* renamed from: mg */
        public final Class<ByteBuffer> mo2196mg() {
            return ByteBuffer.class;
        }
    }

    public C16506a(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public final void cleanup() {
    }

    /* renamed from: mj */
    public final /* synthetic */ Object mo2194mj() {
        AppMethodBeat.m2504i(92282);
        this.buffer.position(0);
        ByteBuffer byteBuffer = this.buffer;
        AppMethodBeat.m2505o(92282);
        return byteBuffer;
    }
}
