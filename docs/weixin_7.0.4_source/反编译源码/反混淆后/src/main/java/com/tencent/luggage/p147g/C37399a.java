package com.tencent.luggage.p147g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.luggage.g.a */
public final class C37399a extends InputStream {
    public final ByteBuffer bRy;
    private int bRz;

    public C37399a(ByteBuffer byteBuffer) {
        this.bRy = byteBuffer;
    }

    public final int available() {
        AppMethodBeat.m2504i(90864);
        int remaining = this.bRy.remaining();
        AppMethodBeat.m2505o(90864);
        return remaining;
    }

    public final int read() {
        AppMethodBeat.m2504i(90865);
        if (this.bRy.hasRemaining()) {
            int i = this.bRy.get() & 255;
            AppMethodBeat.m2505o(90865);
            return i;
        }
        AppMethodBeat.m2505o(90865);
        return -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(90866);
        if (this.bRy.hasRemaining()) {
            int min = Math.min(i2, this.bRy.remaining());
            this.bRy.get(bArr, i, min);
            AppMethodBeat.m2505o(90866);
            return min;
        }
        AppMethodBeat.m2505o(90866);
        return -1;
    }

    public final void close() {
        AppMethodBeat.m2504i(90867);
        super.close();
        C37399a.m63003j(this.bRy);
        AppMethodBeat.m2505o(90867);
    }

    public final synchronized void mark(int i) {
        AppMethodBeat.m2504i(90868);
        this.bRz = this.bRy.position();
        AppMethodBeat.m2505o(90868);
    }

    public final synchronized void seek(int i) {
        AppMethodBeat.m2504i(90869);
        this.bRy.position(i);
        AppMethodBeat.m2505o(90869);
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(90870);
        this.bRy.position(this.bRz);
        AppMethodBeat.m2505o(90870);
    }

    public final boolean markSupported() {
        return true;
    }

    public final long getLength() {
        AppMethodBeat.m2504i(90871);
        long limit = (long) this.bRy.limit();
        AppMethodBeat.m2505o(90871);
        return limit;
    }

    /* renamed from: j */
    public static void m63003j(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(90872);
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                C4990ab.m7411d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", e);
            }
        }
        System.gc();
        AppMethodBeat.m2505o(90872);
    }
}
