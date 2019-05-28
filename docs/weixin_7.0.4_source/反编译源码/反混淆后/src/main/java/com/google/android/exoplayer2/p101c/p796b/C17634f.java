package com.google.android.exoplayer2.p101c.p796b;

import com.google.android.exoplayer2.p101c.C45026f;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.b.f */
final class C17634f {
    private static final long[] aVp = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] aTA = new byte[8];
    int length;
    private int state;

    public C17634f() {
        AppMethodBeat.m2504i(94917);
        AppMethodBeat.m2505o(94917);
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    /* renamed from: a */
    public final long mo32318a(C45026f c45026f, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(94918);
        if (this.state == 0) {
            if (c45026f.mo59478a(this.aTA, 0, 1, z)) {
                this.length = C17634f.m27459dR(this.aTA[0] & 255);
                if (this.length == -1) {
                    IllegalStateException illegalStateException = new IllegalStateException("No valid varint length mask found");
                    AppMethodBeat.m2505o(94918);
                    throw illegalStateException;
                }
                this.state = 1;
            } else {
                AppMethodBeat.m2505o(94918);
                return -1;
            }
        }
        if (this.length > i) {
            this.state = 0;
            AppMethodBeat.m2505o(94918);
            return -2;
        }
        if (this.length != 1) {
            c45026f.readFully(this.aTA, 1, this.length - 1);
        }
        this.state = 0;
        long b = C17634f.m27458b(this.aTA, this.length, z2);
        AppMethodBeat.m2505o(94918);
        return b;
    }

    /* renamed from: dR */
    public static int m27459dR(int i) {
        for (int i2 = 0; i2 < aVp.length; i2++) {
            if ((aVp[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static long m27458b(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= aVp[i - 1] ^ -1;
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
