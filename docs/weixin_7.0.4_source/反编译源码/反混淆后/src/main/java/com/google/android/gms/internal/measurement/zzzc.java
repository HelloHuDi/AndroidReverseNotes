package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

class zzzc extends zzzb {
    protected final byte[] zzbrc;

    zzzc(byte[] bArr) {
        this.zzbrc = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(3555);
        boolean zza;
        if (obj == this) {
            AppMethodBeat.m2505o(3555);
            return true;
        } else if (!(obj instanceof zzyw)) {
            AppMethodBeat.m2505o(3555);
            return false;
        } else if (size() != ((zzyw) obj).size()) {
            AppMethodBeat.m2505o(3555);
            return false;
        } else if (size() == 0) {
            AppMethodBeat.m2505o(3555);
            return true;
        } else if (obj instanceof zzzc) {
            zzzc zzzc = (zzzc) obj;
            int zzsx = zzsx();
            int zzsx2 = zzzc.zzsx();
            if (zzsx == 0 || zzsx2 == 0 || zzsx == zzsx2) {
                zza = zza((zzzc) obj, 0, size());
                AppMethodBeat.m2505o(3555);
                return zza;
            }
            AppMethodBeat.m2505o(3555);
            return false;
        } else {
            zza = obj.equals(this);
            AppMethodBeat.m2505o(3555);
            return zza;
        }
    }

    public int size() {
        return this.zzbrc.length;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza(int i, int i2, int i3) {
        AppMethodBeat.m2504i(3557);
        int zza = zzzr.zza(i, this.zzbrc, zzsy(), i3);
        AppMethodBeat.m2505o(3557);
        return zza;
    }

    /* Access modifiers changed, original: final */
    public final boolean zza(zzyw zzyw, int i, int i2) {
        AppMethodBeat.m2504i(3556);
        IllegalArgumentException illegalArgumentException;
        if (i2 > zzyw.size()) {
            illegalArgumentException = new IllegalArgumentException("Length too large: " + i2 + size());
            AppMethodBeat.m2505o(3556);
            throw illegalArgumentException;
        } else if (i2 > zzyw.size()) {
            illegalArgumentException = new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzyw.size());
            AppMethodBeat.m2505o(3556);
            throw illegalArgumentException;
        } else if (zzyw instanceof zzzc) {
            zzzc zzzc = (zzzc) zzyw;
            byte[] bArr = this.zzbrc;
            byte[] bArr2 = zzzc.zzbrc;
            int zzsy = zzsy() + i2;
            int zzsy2 = zzsy();
            int zzsy3 = zzzc.zzsy();
            while (zzsy2 < zzsy) {
                if (bArr[zzsy2] != bArr2[zzsy3]) {
                    AppMethodBeat.m2505o(3556);
                    return false;
                }
                zzsy2++;
                zzsy3++;
            }
            AppMethodBeat.m2505o(3556);
            return true;
        } else {
            boolean equals = zzyw.zzb(0, i2).equals(zzb(0, i2));
            AppMethodBeat.m2505o(3556);
            return equals;
        }
    }

    public byte zzae(int i) {
        return this.zzbrc[i];
    }

    public final zzyw zzb(int i, int i2) {
        AppMethodBeat.m2504i(3554);
        int zzb = zzyw.zzb(0, i2, size());
        if (zzb == 0) {
            zzyw zzyw = zzyw.zzbqx;
            AppMethodBeat.m2505o(3554);
            return zzyw;
        }
        zzyz zzyz = new zzyz(this.zzbrc, zzsy(), zzb);
        AppMethodBeat.m2505o(3554);
        return zzyz;
    }

    /* Access modifiers changed, original: protected */
    public int zzsy() {
        return 0;
    }
}
