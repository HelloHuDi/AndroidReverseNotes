package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface d {
    public static final ByteBuffer aPG = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a extends Exception {
        public a(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
            AppMethodBeat.i(94651);
            AppMethodBeat.o(94651);
        }
    }

    void flush();

    void g(ByteBuffer byteBuffer);

    boolean isActive();

    boolean qf();

    int qk();

    void ql();

    ByteBuffer qm();

    boolean r(int i, int i2, int i3);

    void reset();
}
