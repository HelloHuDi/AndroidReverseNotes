package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.e.i */
final class C25521i {
    private final int baE;
    int baF;
    int baG;
    private final byte[] data;

    public C25521i(byte[] bArr) {
        AppMethodBeat.m2504i(95051);
        this.data = bArr;
        this.baE = bArr.length;
        AppMethodBeat.m2505o(95051);
    }

    /* renamed from: rl */
    public final boolean mo42782rl() {
        AppMethodBeat.m2504i(95052);
        boolean z = (((this.data[this.baF] & 255) >> this.baG) & 1) == 1;
        mo42781ee(1);
        AppMethodBeat.m2505o(95052);
        return z;
    }

    /* renamed from: ed */
    public final int mo42780ed(int i) {
        AppMethodBeat.m2504i(95053);
        int i2 = this.baF;
        int min = Math.min(i, 8 - this.baG);
        int i3 = i2 + 1;
        i2 = ((this.data[i2] & 255) >> this.baG) & (255 >> (8 - min));
        while (min < i) {
            i2 |= (this.data[i3] & 255) << min;
            min += 8;
            i3++;
        }
        i2 &= -1 >>> (32 - i);
        mo42781ee(i);
        AppMethodBeat.m2505o(95053);
        return i2;
    }

    /* renamed from: ee */
    public final void mo42781ee(int i) {
        AppMethodBeat.m2504i(95054);
        int i2 = i / 8;
        this.baF += i2;
        this.baG = (i - (i2 * 8)) + this.baG;
        if (this.baG > 7) {
            this.baF++;
            this.baG -= 8;
        }
        m40328rm();
        AppMethodBeat.m2505o(95054);
    }

    /* renamed from: rm */
    private void m40328rm() {
        AppMethodBeat.m2504i(95055);
        boolean z = this.baF >= 0 && (this.baF < this.baE || (this.baF == this.baE && this.baG == 0));
        C45039a.checkState(z);
        AppMethodBeat.m2505o(95055);
    }
}
