package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaca implements Cloneable {
    private static final zzacb zzbxa = new zzacb();
    private int mSize;
    private boolean zzbxb;
    private int[] zzbxc;
    private zzacb[] zzbxd;

    static {
        AppMethodBeat.m2504i(3493);
        AppMethodBeat.m2505o(3493);
    }

    zzaca() {
        this(10);
    }

    private zzaca(int i) {
        AppMethodBeat.m2504i(3487);
        this.zzbxb = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbxc = new int[idealIntArraySize];
        this.zzbxd = new zzacb[idealIntArraySize];
        this.mSize = 0;
        AppMethodBeat.m2505o(3487);
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    private final int zzav(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbxc[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(3492);
        int i = this.mSize;
        zzaca zzaca = new zzaca(i);
        System.arraycopy(this.zzbxc, 0, zzaca.zzbxc, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzbxd[i2] != null) {
                zzaca.zzbxd[i2] = (zzacb) this.zzbxd[i2].clone();
            }
        }
        zzaca.mSize = i;
        AppMethodBeat.m2505o(3492);
        return zzaca;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(3490);
        if (obj == this) {
            AppMethodBeat.m2505o(3490);
            return true;
        } else if (obj instanceof zzaca) {
            zzaca zzaca = (zzaca) obj;
            if (this.mSize != zzaca.mSize) {
                AppMethodBeat.m2505o(3490);
                return false;
            }
            int i;
            boolean z;
            int[] iArr = this.zzbxc;
            int[] iArr2 = zzaca.zzbxc;
            int i2 = this.mSize;
            for (i = 0; i < i2; i++) {
                if (iArr[i] != iArr2[i]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                zzacb[] zzacbArr = this.zzbxd;
                zzacb[] zzacbArr2 = zzaca.zzbxd;
                i2 = this.mSize;
                for (i = 0; i < i2; i++) {
                    if (!zzacbArr[i].equals(zzacbArr2[i])) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    AppMethodBeat.m2505o(3490);
                    return true;
                }
            }
            AppMethodBeat.m2505o(3490);
            return false;
        } else {
            AppMethodBeat.m2505o(3490);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(3491);
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbxc[i2]) * 31) + this.zzbxd[i2].hashCode();
        }
        AppMethodBeat.m2505o(3491);
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* Access modifiers changed, original: final */
    public final int size() {
        return this.mSize;
    }

    /* Access modifiers changed, original: final */
    public final void zza(int i, zzacb zzacb) {
        AppMethodBeat.m2504i(3489);
        int zzav = zzav(i);
        if (zzav >= 0) {
            this.zzbxd[zzav] = zzacb;
            AppMethodBeat.m2505o(3489);
            return;
        }
        zzav ^= -1;
        if (zzav >= this.mSize || this.zzbxd[zzav] != zzbxa) {
            zzacb[] zzacbArr;
            if (this.mSize >= this.zzbxc.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzacbArr = new zzacb[idealIntArraySize];
                System.arraycopy(this.zzbxc, 0, iArr, 0, this.zzbxc.length);
                System.arraycopy(this.zzbxd, 0, zzacbArr, 0, this.zzbxd.length);
                this.zzbxc = iArr;
                this.zzbxd = zzacbArr;
            }
            if (this.mSize - zzav != 0) {
                int[] iArr2 = this.zzbxc;
                System.arraycopy(iArr2, zzav, iArr2, zzav + 1, this.mSize - zzav);
                zzacbArr = this.zzbxd;
                System.arraycopy(zzacbArr, zzav, zzacbArr, zzav + 1, this.mSize - zzav);
            }
            this.zzbxc[zzav] = i;
            this.zzbxd[zzav] = zzacb;
            this.mSize++;
            AppMethodBeat.m2505o(3489);
            return;
        }
        this.zzbxc[zzav] = i;
        this.zzbxd[zzav] = zzacb;
        AppMethodBeat.m2505o(3489);
    }

    /* Access modifiers changed, original: final */
    public final zzacb zzat(int i) {
        AppMethodBeat.m2504i(3488);
        int zzav = zzav(i);
        if (zzav < 0 || this.zzbxd[zzav] == zzbxa) {
            AppMethodBeat.m2505o(3488);
            return null;
        }
        zzacb zzacb = this.zzbxd[zzav];
        AppMethodBeat.m2505o(3488);
        return zzacb;
    }

    /* Access modifiers changed, original: final */
    public final zzacb zzau(int i) {
        return this.zzbxd[i];
    }
}
