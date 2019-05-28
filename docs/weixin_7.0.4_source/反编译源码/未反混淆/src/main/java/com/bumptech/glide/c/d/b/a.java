package com.bumptech.glide.c.d.b;

import com.bumptech.glide.c.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a implements e<ByteBuffer> {
    private final ByteBuffer buffer;

    public static class a implements com.bumptech.glide.c.a.e.a<ByteBuffer> {
        public final /* synthetic */ e T(Object obj) {
            AppMethodBeat.i(92281);
            a aVar = new a((ByteBuffer) obj);
            AppMethodBeat.o(92281);
            return aVar;
        }

        public final Class<ByteBuffer> mg() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public final void cleanup() {
    }

    public final /* synthetic */ Object mj() {
        AppMethodBeat.i(92282);
        this.buffer.position(0);
        ByteBuffer byteBuffer = this.buffer;
        AppMethodBeat.o(92282);
        return byteBuffer;
    }
}
