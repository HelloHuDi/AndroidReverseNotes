package com.tencent.luggage.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class a extends InputStream {
    public final ByteBuffer bRy;
    private int bRz;

    public a(ByteBuffer byteBuffer) {
        this.bRy = byteBuffer;
    }

    public final int available() {
        AppMethodBeat.i(90864);
        int remaining = this.bRy.remaining();
        AppMethodBeat.o(90864);
        return remaining;
    }

    public final int read() {
        AppMethodBeat.i(90865);
        if (this.bRy.hasRemaining()) {
            int i = this.bRy.get() & 255;
            AppMethodBeat.o(90865);
            return i;
        }
        AppMethodBeat.o(90865);
        return -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(90866);
        if (this.bRy.hasRemaining()) {
            int min = Math.min(i2, this.bRy.remaining());
            this.bRy.get(bArr, i, min);
            AppMethodBeat.o(90866);
            return min;
        }
        AppMethodBeat.o(90866);
        return -1;
    }

    public final void close() {
        AppMethodBeat.i(90867);
        super.close();
        j(this.bRy);
        AppMethodBeat.o(90867);
    }

    public final synchronized void mark(int i) {
        AppMethodBeat.i(90868);
        this.bRz = this.bRy.position();
        AppMethodBeat.o(90868);
    }

    public final synchronized void seek(int i) {
        AppMethodBeat.i(90869);
        this.bRy.position(i);
        AppMethodBeat.o(90869);
    }

    public final synchronized void reset() {
        AppMethodBeat.i(90870);
        this.bRy.position(this.bRz);
        AppMethodBeat.o(90870);
    }

    public final boolean markSupported() {
        return true;
    }

    public final long getLength() {
        AppMethodBeat.i(90871);
        long limit = (long) this.bRy.limit();
        AppMethodBeat.o(90871);
        return limit;
    }

    public static void j(ByteBuffer byteBuffer) {
        AppMethodBeat.i(90872);
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                ab.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", e);
            }
        }
        System.gc();
        AppMethodBeat.o(90872);
    }
}
