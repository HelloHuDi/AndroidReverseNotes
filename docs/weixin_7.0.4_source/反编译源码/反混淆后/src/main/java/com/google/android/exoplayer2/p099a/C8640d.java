package com.google.android.exoplayer2.p099a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.google.android.exoplayer2.a.d */
public interface C8640d {
    public static final ByteBuffer aPG = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* renamed from: com.google.android.exoplayer2.a.d$a */
    public static final class C8641a extends Exception {
        public C8641a(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
            AppMethodBeat.m2504i(94651);
            AppMethodBeat.m2505o(94651);
        }
    }

    void flush();

    /* renamed from: g */
    void mo19130g(ByteBuffer byteBuffer);

    boolean isActive();

    /* renamed from: qf */
    boolean mo19132qf();

    /* renamed from: qk */
    int mo19133qk();

    /* renamed from: ql */
    void mo19134ql();

    /* renamed from: qm */
    ByteBuffer mo19135qm();

    /* renamed from: r */
    boolean mo19136r(int i, int i2, int i3);

    void reset();
}
