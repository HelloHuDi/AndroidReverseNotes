package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkr extends zzaby<zzkr> {
    public long[] zzauk;
    public long[] zzaul;

    public zzkr() {
        AppMethodBeat.i(69731);
        this.zzauk = zzach.zzbxm;
        this.zzaul = zzach.zzbxm;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69731);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69732);
        if (obj == this) {
            AppMethodBeat.o(69732);
            return true;
        } else if (obj instanceof zzkr) {
            zzkr zzkr = (zzkr) obj;
            if (!zzacc.equals(this.zzauk, zzkr.zzauk)) {
                AppMethodBeat.o(69732);
                return false;
            } else if (!zzacc.equals(this.zzaul, zzkr.zzaul)) {
                AppMethodBeat.o(69732);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkr.zzbww);
                AppMethodBeat.o(69732);
                return equals;
            } else if (zzkr.zzbww == null || zzkr.zzbww.isEmpty()) {
                AppMethodBeat.o(69732);
                return true;
            } else {
                AppMethodBeat.o(69732);
                return false;
            }
        } else {
            AppMethodBeat.o(69732);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(69733);
        int hashCode = (((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzacc.hashCode(this.zzauk)) * 31) + zzacc.hashCode(this.zzaul)) * 31;
        int hashCode2 = (this.zzbww == null || this.zzbww.isEmpty()) ? 0 : this.zzbww.hashCode();
        hashCode2 += hashCode;
        AppMethodBeat.o(69733);
        return hashCode2;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        int i;
        int i2;
        AppMethodBeat.i(69735);
        int zza = super.zza();
        if (this.zzauk == null || this.zzauk.length <= 0) {
            i = zza;
        } else {
            i2 = 0;
            for (long zzao : this.zzauk) {
                i2 += zzabw.zzao(zzao);
            }
            i = (zza + i2) + (this.zzauk.length * 1);
        }
        if (this.zzaul != null && this.zzaul.length > 0) {
            zza = 0;
            for (long zzao2 : this.zzaul) {
                zza += zzabw.zzao(zzao2);
            }
            i = (i + zza) + (this.zzaul.length * 1);
        }
        AppMethodBeat.o(69735);
        return i;
    }

    public final void zza(zzabw zzabw) {
        int i = 0;
        AppMethodBeat.i(69734);
        if (this.zzauk != null && this.zzauk.length > 0) {
            for (long zza : this.zzauk) {
                zzabw.zza(1, zza);
            }
        }
        if (this.zzaul != null && this.zzaul.length > 0) {
            while (i < this.zzaul.length) {
                zzabw.zza(2, this.zzaul[i]);
                i++;
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(69734);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69736);
        while (true) {
            int zzuw = zzabv.zzuw();
            int zzb;
            long[] jArr;
            int zzaf;
            long[] jArr2;
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69736);
                    break;
                case 8:
                    zzb = zzach.zzb(zzabv, 8);
                    zzuw = this.zzauk == null ? 0 : this.zzauk.length;
                    jArr = new long[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzauk, 0, jArr, 0, zzuw);
                    }
                    while (zzuw < jArr.length - 1) {
                        jArr[zzuw] = zzabv.zzuz();
                        zzabv.zzuw();
                        zzuw++;
                    }
                    jArr[zzuw] = zzabv.zzuz();
                    this.zzauk = jArr;
                    continue;
                case 10:
                    zzaf = zzabv.zzaf(zzabv.zzuy());
                    zzb = zzabv.getPosition();
                    zzuw = 0;
                    while (zzabv.zzvc() > 0) {
                        zzabv.zzuz();
                        zzuw++;
                    }
                    zzabv.zzam(zzb);
                    zzb = this.zzauk == null ? 0 : this.zzauk.length;
                    jArr2 = new long[(zzuw + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzauk, 0, jArr2, 0, zzb);
                    }
                    while (zzb < jArr2.length) {
                        jArr2[zzb] = zzabv.zzuz();
                        zzb++;
                    }
                    this.zzauk = jArr2;
                    zzabv.zzal(zzaf);
                    continue;
                case 16:
                    zzb = zzach.zzb(zzabv, 16);
                    zzuw = this.zzaul == null ? 0 : this.zzaul.length;
                    jArr = new long[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzaul, 0, jArr, 0, zzuw);
                    }
                    while (zzuw < jArr.length - 1) {
                        jArr[zzuw] = zzabv.zzuz();
                        zzabv.zzuw();
                        zzuw++;
                    }
                    jArr[zzuw] = zzabv.zzuz();
                    this.zzaul = jArr;
                    continue;
                case 18:
                    zzaf = zzabv.zzaf(zzabv.zzuy());
                    zzb = zzabv.getPosition();
                    zzuw = 0;
                    while (zzabv.zzvc() > 0) {
                        zzabv.zzuz();
                        zzuw++;
                    }
                    zzabv.zzam(zzb);
                    zzb = this.zzaul == null ? 0 : this.zzaul.length;
                    jArr2 = new long[(zzuw + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzaul, 0, jArr2, 0, zzb);
                    }
                    while (zzb < jArr2.length) {
                        jArr2[zzb] = zzabv.zzuz();
                        zzb++;
                    }
                    this.zzaul = jArr2;
                    zzabv.zzal(zzaf);
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69736);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
