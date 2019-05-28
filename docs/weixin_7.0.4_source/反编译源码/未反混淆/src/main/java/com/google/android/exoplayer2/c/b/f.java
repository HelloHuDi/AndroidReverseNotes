package com.google.android.exoplayer2.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f {
    private static final long[] aVp = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] aTA = new byte[8];
    int length;
    private int state;

    public f() {
        AppMethodBeat.i(94917);
        AppMethodBeat.o(94917);
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long a(com.google.android.exoplayer2.c.f fVar, boolean z, boolean z2, int i) {
        AppMethodBeat.i(94918);
        if (this.state == 0) {
            if (fVar.a(this.aTA, 0, 1, z)) {
                this.length = dR(this.aTA[0] & 255);
                if (this.length == -1) {
                    IllegalStateException illegalStateException = new IllegalStateException("No valid varint length mask found");
                    AppMethodBeat.o(94918);
                    throw illegalStateException;
                }
                this.state = 1;
            } else {
                AppMethodBeat.o(94918);
                return -1;
            }
        }
        if (this.length > i) {
            this.state = 0;
            AppMethodBeat.o(94918);
            return -2;
        }
        if (this.length != 1) {
            fVar.readFully(this.aTA, 1, this.length - 1);
        }
        this.state = 0;
        long b = b(this.aTA, this.length, z2);
        AppMethodBeat.o(94918);
        return b;
    }

    public static int dR(int i) {
        for (int i2 = 0; i2 < aVp.length; i2++) {
            if ((aVp[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long b(byte[] bArr, int i, boolean z) {
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
