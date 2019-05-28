package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.k */
public final class C32064k {
    private int baE;
    public int baF;
    public int baG;
    public byte[] data;

    public C32064k(byte[] bArr) {
        this(bArr, bArr.length);
        AppMethodBeat.m2504i(95893);
        AppMethodBeat.m2505o(95893);
    }

    public C32064k(byte[] bArr, int i) {
        this.data = bArr;
        this.baE = i;
    }

    /* renamed from: n */
    public final void mo52356n(byte[] bArr, int i) {
        this.data = bArr;
        this.baF = 0;
        this.baG = 0;
        this.baE = i;
    }

    /* renamed from: tx */
    public final int mo52362tx() {
        return ((this.baE - this.baF) * 8) - this.baG;
    }

    /* renamed from: ty */
    public final int mo52363ty() {
        AppMethodBeat.m2504i(95894);
        C45039a.checkState(this.baG == 0);
        int i = this.baF;
        AppMethodBeat.m2505o(95894);
        return i;
    }

    public final void setPosition(int i) {
        AppMethodBeat.m2504i(95895);
        this.baF = i / 8;
        this.baG = i - (this.baF * 8);
        mo52359rm();
        AppMethodBeat.m2505o(95895);
    }

    /* renamed from: tz */
    private void m52126tz() {
        AppMethodBeat.m2504i(95896);
        int i = this.baG + 1;
        this.baG = i;
        if (i == 8) {
            this.baG = 0;
            this.baF++;
        }
        mo52359rm();
        AppMethodBeat.m2505o(95896);
    }

    /* renamed from: ee */
    public final void mo52355ee(int i) {
        AppMethodBeat.m2504i(95897);
        int i2 = i / 8;
        this.baF += i2;
        this.baG = (i - (i2 * 8)) + this.baG;
        if (this.baG > 7) {
            this.baF++;
            this.baG -= 8;
        }
        mo52359rm();
        AppMethodBeat.m2505o(95897);
    }

    /* renamed from: rl */
    public final boolean mo52358rl() {
        AppMethodBeat.m2504i(95898);
        boolean z = (this.data[this.baF] & (128 >> this.baG)) != 0;
        m52126tz();
        AppMethodBeat.m2505o(95898);
        return z;
    }

    /* renamed from: ed */
    public final int mo52354ed(int i) {
        AppMethodBeat.m2504i(95899);
        if (i == 0) {
            AppMethodBeat.m2505o(95899);
            return 0;
        }
        this.baG += i;
        int i2 = 0;
        while (this.baG > 8) {
            this.baG -= 8;
            byte[] bArr = this.data;
            int i3 = this.baF;
            this.baF = i3 + 1;
            i2 |= (bArr[i3] & 255) << this.baG;
        }
        i2 = (i2 | ((this.data[this.baF] & 255) >> (8 - this.baG))) & (-1 >>> (32 - i));
        if (this.baG == 8) {
            this.baG = 0;
            this.baF++;
        }
        mo52359rm();
        AppMethodBeat.m2505o(95899);
        return i2;
    }

    /* renamed from: tA */
    public final void mo52361tA() {
        AppMethodBeat.m2504i(95900);
        if (this.baG == 0) {
            AppMethodBeat.m2505o(95900);
            return;
        }
        this.baG = 0;
        this.baF++;
        mo52359rm();
        AppMethodBeat.m2505o(95900);
    }

    /* renamed from: p */
    public final void mo52357p(byte[] bArr, int i) {
        boolean z;
        AppMethodBeat.m2504i(95901);
        if (this.baG == 0) {
            z = true;
        } else {
            z = false;
        }
        C45039a.checkState(z);
        System.arraycopy(this.data, this.baF, bArr, 0, i);
        this.baF += i;
        mo52359rm();
        AppMethodBeat.m2505o(95901);
    }

    /* renamed from: rm */
    public final void mo52359rm() {
        AppMethodBeat.m2504i(95902);
        boolean z = this.baF >= 0 && (this.baF < this.baE || (this.baF == this.baE && this.baG == 0));
        C45039a.checkState(z);
        AppMethodBeat.m2505o(95902);
    }
}
