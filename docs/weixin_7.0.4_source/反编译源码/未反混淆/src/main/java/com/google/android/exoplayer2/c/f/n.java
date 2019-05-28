package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n {
    private boolean bbV;
    private final int bcT;
    boolean bcU;
    public byte[] bcV = new byte[131];
    public int bcW;

    public n(int i) {
        AppMethodBeat.i(95140);
        this.bcT = i;
        this.bcV[2] = (byte) 1;
        AppMethodBeat.o(95140);
    }

    public final void reset() {
        this.bbV = false;
        this.bcU = false;
    }

    public final void ei(int i) {
        boolean z = true;
        AppMethodBeat.i(95141);
        a.checkState(!this.bbV);
        if (i != this.bcT) {
            z = false;
        }
        this.bbV = z;
        if (this.bbV) {
            this.bcW = 3;
            this.bcU = false;
        }
        AppMethodBeat.o(95141);
    }

    public final void f(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95142);
        if (this.bbV) {
            int i3 = i2 - i;
            if (this.bcV.length < this.bcW + i3) {
                this.bcV = Arrays.copyOf(this.bcV, (this.bcW + i3) * 2);
            }
            System.arraycopy(bArr, i, this.bcV, this.bcW, i3);
            this.bcW = i3 + this.bcW;
            AppMethodBeat.o(95142);
            return;
        }
        AppMethodBeat.o(95142);
    }

    public final boolean ej(int i) {
        if (!this.bbV) {
            return false;
        }
        this.bcW -= i;
        this.bbV = false;
        this.bcU = true;
        return true;
    }
}
