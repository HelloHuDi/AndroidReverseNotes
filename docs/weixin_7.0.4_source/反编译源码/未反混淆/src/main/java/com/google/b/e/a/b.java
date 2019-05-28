package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b {
    final byte[] bAL;
    private int bAM = 0;

    b(int i) {
        AppMethodBeat.i(57157);
        this.bAL = new byte[i];
        AppMethodBeat.o(57157);
    }

    /* Access modifiers changed, original: final */
    public final void d(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3;
            int i4 = this.bAM;
            this.bAM = i4 + 1;
            byte[] bArr = this.bAL;
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            bArr[i4] = (byte) i3;
        }
    }
}
