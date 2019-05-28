package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class zzj extends zzn<zzj> {
    public byte[] zzgd;
    public String zzge;
    public double zzgf;
    public float zzgg;
    public long zzgh;
    public int zzgi;
    public int zzgj;
    public boolean zzgk;
    public zzh[] zzgl;
    public zzi[] zzgm;
    public String[] zzgn;
    public long[] zzgo;
    public float[] zzgp;
    public long zzgq;

    public zzj() {
        AppMethodBeat.i(70698);
        this.zzgd = zzw.zzhy;
        this.zzge = "";
        this.zzgf = 0.0d;
        this.zzgg = 0.0f;
        this.zzgh = 0;
        this.zzgi = 0;
        this.zzgj = 0;
        this.zzgk = false;
        this.zzgl = zzh.zzh();
        this.zzgm = zzi.zzi();
        this.zzgn = zzw.zzhw;
        this.zzgo = zzw.zzhs;
        this.zzgp = zzw.zzht;
        this.zzgq = 0;
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(70698);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70699);
        if (obj == this) {
            AppMethodBeat.o(70699);
            return true;
        } else if (obj instanceof zzj) {
            zzj zzj = (zzj) obj;
            if (Arrays.equals(this.zzgd, zzj.zzgd)) {
                if (this.zzge == null) {
                    if (zzj.zzge != null) {
                        AppMethodBeat.o(70699);
                        return false;
                    }
                } else if (!this.zzge.equals(zzj.zzge)) {
                    AppMethodBeat.o(70699);
                    return false;
                }
                if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(zzj.zzgf)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(zzj.zzgg)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (this.zzgh != zzj.zzgh) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (this.zzgi != zzj.zzgi) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (this.zzgj != zzj.zzgj) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (this.zzgk != zzj.zzgk) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (!zzr.equals(this.zzgl, zzj.zzgl)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (!zzr.equals(this.zzgm, zzj.zzgm)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (!zzr.equals(this.zzgn, zzj.zzgn)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (!zzr.equals(this.zzgo, zzj.zzgo)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (!zzr.equals(this.zzgp, zzj.zzgp)) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (this.zzgq != zzj.zzgq) {
                    AppMethodBeat.o(70699);
                    return false;
                } else if (this.zzhc != null && !this.zzhc.isEmpty()) {
                    boolean equals = this.zzhc.equals(zzj.zzhc);
                    AppMethodBeat.o(70699);
                    return equals;
                } else if (zzj.zzhc == null || zzj.zzhc.isEmpty()) {
                    AppMethodBeat.o(70699);
                    return true;
                } else {
                    AppMethodBeat.o(70699);
                    return false;
                }
            }
            AppMethodBeat.o(70699);
            return false;
        } else {
            AppMethodBeat.o(70699);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(70700);
        int hashCode = (this.zzge == null ? 0 : this.zzge.hashCode()) + ((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzgd)) * 31);
        long doubleToLongBits = Double.doubleToLongBits(this.zzgf);
        hashCode = ((((((((((((((this.zzgk ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzgg)) * 31) + ((int) (this.zzgh ^ (this.zzgh >>> 32)))) * 31) + this.zzgi) * 31) + this.zzgj) * 31)) * 31) + zzr.hashCode(this.zzgl)) * 31) + zzr.hashCode(this.zzgm)) * 31) + zzr.hashCode(this.zzgn)) * 31) + zzr.hashCode(this.zzgo)) * 31) + zzr.hashCode(this.zzgp)) * 31) + ((int) (this.zzgq ^ (this.zzgq >>> 32)))) * 31;
        if (!(this.zzhc == null || this.zzhc.isEmpty())) {
            i = this.zzhc.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(70700);
        return hashCode;
    }

    public final void zza(zzl zzl) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(70701);
        if (!Arrays.equals(this.zzgd, zzw.zzhy)) {
            byte[] bArr = this.zzgd;
            zzl.zzf(1, 2);
            zzl.zzl(bArr.length);
            zzl.zzc(bArr);
        }
        if (!(this.zzge == null || this.zzge.equals(""))) {
            zzl.zza(2, this.zzge);
        }
        if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0d)) {
            double d = this.zzgf;
            zzl.zzf(3, 1);
            zzl.zzb(Double.doubleToLongBits(d));
        }
        if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0f)) {
            zzl.zza(4, this.zzgg);
        }
        if (this.zzgh != 0) {
            zzl.zza(5, this.zzgh);
        }
        if (this.zzgi != 0) {
            zzl.zzd(6, this.zzgi);
        }
        if (this.zzgj != 0) {
            int i3 = this.zzgj;
            zzl.zzf(7, 0);
            zzl.zzl(zzl.zzn(i3));
        }
        if (this.zzgk) {
            boolean z = this.zzgk;
            zzl.zzf(8, 0);
            if (!z) {
                i = 0;
            }
            zzl.zza((byte) i);
        }
        if (this.zzgl != null && this.zzgl.length > 0) {
            for (zzt zzt : this.zzgl) {
                if (zzt != null) {
                    zzl.zza(9, zzt);
                }
            }
        }
        if (this.zzgm != null && this.zzgm.length > 0) {
            for (zzt zzt2 : this.zzgm) {
                if (zzt2 != null) {
                    zzl.zza(10, zzt2);
                }
            }
        }
        if (this.zzgn != null && this.zzgn.length > 0) {
            for (String str : this.zzgn) {
                if (str != null) {
                    zzl.zza(11, str);
                }
            }
        }
        if (this.zzgo != null && this.zzgo.length > 0) {
            for (long zza : this.zzgo) {
                zzl.zza(12, zza);
            }
        }
        if (this.zzgq != 0) {
            zzl.zza(13, this.zzgq);
        }
        if (this.zzgp != null && this.zzgp.length > 0) {
            while (i2 < this.zzgp.length) {
                zzl.zza(14, this.zzgp[i2]);
                i2++;
            }
        }
        super.zza(zzl);
        AppMethodBeat.o(70701);
    }

    /* Access modifiers changed, original: protected|final */
    public final int zzg() {
        int i;
        AppMethodBeat.i(70702);
        int zzg = super.zzg();
        if (!Arrays.equals(this.zzgd, zzw.zzhy)) {
            byte[] bArr = this.zzgd;
            zzg += (bArr.length + zzl.zzm(bArr.length)) + zzl.zzk(1);
        }
        if (!(this.zzge == null || this.zzge.equals(""))) {
            zzg += zzl.zzb(2, this.zzge);
        }
        if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0d)) {
            zzg += zzl.zzk(3) + 8;
        }
        if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0f)) {
            zzg += zzl.zzk(4) + 4;
        }
        if (this.zzgh != 0) {
            zzg += zzl.zzb(5, this.zzgh);
        }
        if (this.zzgi != 0) {
            zzg += zzl.zze(6, this.zzgi);
        }
        if (this.zzgj != 0) {
            zzg += zzl.zzm(zzl.zzn(this.zzgj)) + zzl.zzk(7);
        }
        if (this.zzgk) {
            zzg += zzl.zzk(8) + 1;
        }
        if (this.zzgl != null && this.zzgl.length > 0) {
            i = zzg;
            for (zzt zzt : this.zzgl) {
                if (zzt != null) {
                    i += zzl.zzb(9, zzt);
                }
            }
            zzg = i;
        }
        if (this.zzgm != null && this.zzgm.length > 0) {
            i = zzg;
            for (zzt zzt2 : this.zzgm) {
                if (zzt2 != null) {
                    i += zzl.zzb(10, zzt2);
                }
            }
            zzg = i;
        }
        if (this.zzgn != null && this.zzgn.length > 0) {
            i = 0;
            int i2 = 0;
            for (String str : this.zzgn) {
                if (str != null) {
                    i2++;
                    i += zzl.zzg(str);
                }
            }
            zzg = (zzg + i) + (i2 * 1);
        }
        if (this.zzgo != null && this.zzgo.length > 0) {
            i = 0;
            for (long j : this.zzgo) {
                int i3 = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
                i += i3;
            }
            zzg = (zzg + i) + (this.zzgo.length * 1);
        }
        if (this.zzgq != 0) {
            zzg += zzl.zzb(13, this.zzgq);
        }
        if (this.zzgp != null && this.zzgp.length > 0) {
            zzg = (zzg + (this.zzgp.length * 4)) + (this.zzgp.length * 1);
        }
        AppMethodBeat.o(70702);
        return zzg;
    }
}
