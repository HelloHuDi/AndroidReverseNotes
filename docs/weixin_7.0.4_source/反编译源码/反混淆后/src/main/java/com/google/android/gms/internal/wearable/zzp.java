package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzp implements Cloneable {
    private static final zzq zzhe = new zzq();
    private int mSize;
    private boolean zzhf;
    private int[] zzhg;
    private zzq[] zzhh;

    static {
        AppMethodBeat.m2504i(70758);
        AppMethodBeat.m2505o(70758);
    }

    zzp() {
        this(10);
    }

    private zzp(int i) {
        AppMethodBeat.m2504i(70752);
        this.zzhf = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzhg = new int[idealIntArraySize];
        this.zzhh = new zzq[idealIntArraySize];
        this.mSize = 0;
        AppMethodBeat.m2505o(70752);
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

    private final int zzq(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzhg[i4];
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
        AppMethodBeat.m2504i(70757);
        int i = this.mSize;
        zzp zzp = new zzp(i);
        System.arraycopy(this.zzhg, 0, zzp.zzhg, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzhh[i2] != null) {
                zzp.zzhh[i2] = (zzq) this.zzhh[i2].clone();
            }
        }
        zzp.mSize = i;
        AppMethodBeat.m2505o(70757);
        return zzp;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70755);
        if (obj == this) {
            AppMethodBeat.m2505o(70755);
            return true;
        } else if (obj instanceof zzp) {
            zzp zzp = (zzp) obj;
            if (this.mSize != zzp.mSize) {
                AppMethodBeat.m2505o(70755);
                return false;
            }
            int i;
            boolean z;
            int[] iArr = this.zzhg;
            int[] iArr2 = zzp.zzhg;
            int i2 = this.mSize;
            for (i = 0; i < i2; i++) {
                if (iArr[i] != iArr2[i]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                zzq[] zzqArr = this.zzhh;
                zzq[] zzqArr2 = zzp.zzhh;
                i2 = this.mSize;
                for (i = 0; i < i2; i++) {
                    if (!zzqArr[i].equals(zzqArr2[i])) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    AppMethodBeat.m2505o(70755);
                    return true;
                }
            }
            AppMethodBeat.m2505o(70755);
            return false;
        } else {
            AppMethodBeat.m2505o(70755);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70756);
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzhg[i2]) * 31) + this.zzhh[i2].hashCode();
        }
        AppMethodBeat.m2505o(70756);
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
    public final void zza(int i, zzq zzq) {
        AppMethodBeat.m2504i(70754);
        int zzq2 = zzq(i);
        if (zzq2 >= 0) {
            this.zzhh[zzq2] = zzq;
            AppMethodBeat.m2505o(70754);
            return;
        }
        zzq2 ^= -1;
        if (zzq2 >= this.mSize || this.zzhh[zzq2] != zzhe) {
            zzq[] zzqArr;
            if (this.mSize >= this.zzhg.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzqArr = new zzq[idealIntArraySize];
                System.arraycopy(this.zzhg, 0, iArr, 0, this.zzhg.length);
                System.arraycopy(this.zzhh, 0, zzqArr, 0, this.zzhh.length);
                this.zzhg = iArr;
                this.zzhh = zzqArr;
            }
            if (this.mSize - zzq2 != 0) {
                int[] iArr2 = this.zzhg;
                System.arraycopy(iArr2, zzq2, iArr2, zzq2 + 1, this.mSize - zzq2);
                zzqArr = this.zzhh;
                System.arraycopy(zzqArr, zzq2, zzqArr, zzq2 + 1, this.mSize - zzq2);
            }
            this.zzhg[zzq2] = i;
            this.zzhh[zzq2] = zzq;
            this.mSize++;
            AppMethodBeat.m2505o(70754);
            return;
        }
        this.zzhg[zzq2] = i;
        this.zzhh[zzq2] = zzq;
        AppMethodBeat.m2505o(70754);
    }

    /* Access modifiers changed, original: final */
    public final zzq zzo(int i) {
        AppMethodBeat.m2504i(70753);
        int zzq = zzq(i);
        if (zzq < 0 || this.zzhh[zzq] == zzhe) {
            AppMethodBeat.m2505o(70753);
            return null;
        }
        zzq zzq2 = this.zzhh[zzq];
        AppMethodBeat.m2505o(70753);
        return zzq2;
    }

    /* Access modifiers changed, original: final */
    public final zzq zzp(int i) {
        return this.zzhh[i];
    }
}
