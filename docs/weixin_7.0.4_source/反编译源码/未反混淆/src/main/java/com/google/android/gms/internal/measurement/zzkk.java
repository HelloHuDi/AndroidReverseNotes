package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkk extends zzaby<zzkk> {
    public String zzadm;
    public Long zzasp;
    private Integer zzasq;
    public zzkl[] zzasr;
    public zzkj[] zzass;
    public zzkd[] zzast;

    public zzkk() {
        AppMethodBeat.i(69689);
        this.zzasp = null;
        this.zzadm = null;
        this.zzasq = null;
        this.zzasr = zzkl.zzlj();
        this.zzass = zzkj.zzli();
        this.zzast = zzkd.zzle();
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69689);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69690);
        if (obj == this) {
            AppMethodBeat.o(69690);
            return true;
        } else if (obj instanceof zzkk) {
            zzkk zzkk = (zzkk) obj;
            if (this.zzasp == null) {
                if (zzkk.zzasp != null) {
                    AppMethodBeat.o(69690);
                    return false;
                }
            } else if (!this.zzasp.equals(zzkk.zzasp)) {
                AppMethodBeat.o(69690);
                return false;
            }
            if (this.zzadm == null) {
                if (zzkk.zzadm != null) {
                    AppMethodBeat.o(69690);
                    return false;
                }
            } else if (!this.zzadm.equals(zzkk.zzadm)) {
                AppMethodBeat.o(69690);
                return false;
            }
            if (this.zzasq == null) {
                if (zzkk.zzasq != null) {
                    AppMethodBeat.o(69690);
                    return false;
                }
            } else if (!this.zzasq.equals(zzkk.zzasq)) {
                AppMethodBeat.o(69690);
                return false;
            }
            if (!zzacc.equals(this.zzasr, zzkk.zzasr)) {
                AppMethodBeat.o(69690);
                return false;
            } else if (!zzacc.equals(this.zzass, zzkk.zzass)) {
                AppMethodBeat.o(69690);
                return false;
            } else if (!zzacc.equals(this.zzast, zzkk.zzast)) {
                AppMethodBeat.o(69690);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkk.zzbww);
                AppMethodBeat.o(69690);
                return equals;
            } else if (zzkk.zzbww == null || zzkk.zzbww.isEmpty()) {
                AppMethodBeat.o(69690);
                return true;
            } else {
                AppMethodBeat.o(69690);
                return false;
            }
        } else {
            AppMethodBeat.o(69690);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69691);
        int hashCode = ((((((((this.zzasq == null ? 0 : this.zzasq.hashCode()) + (((this.zzadm == null ? 0 : this.zzadm.hashCode()) + (((this.zzasp == null ? 0 : this.zzasp.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzasr)) * 31) + zzacc.hashCode(this.zzass)) * 31) + zzacc.hashCode(this.zzast)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69691);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(69693);
        int zza = super.zza();
        if (this.zzasp != null) {
            zza += zzabw.zzc(1, this.zzasp.longValue());
        }
        if (this.zzadm != null) {
            zza += zzabw.zzc(2, this.zzadm);
        }
        if (this.zzasq != null) {
            zza += zzabw.zzf(3, this.zzasq.intValue());
        }
        if (this.zzasr != null && this.zzasr.length > 0) {
            i = zza;
            for (zzace zzace : this.zzasr) {
                if (zzace != null) {
                    i += zzabw.zzb(4, zzace);
                }
            }
            zza = i;
        }
        if (this.zzass != null && this.zzass.length > 0) {
            i = zza;
            for (zzace zzace2 : this.zzass) {
                if (zzace2 != null) {
                    i += zzabw.zzb(5, zzace2);
                }
            }
            zza = i;
        }
        if (this.zzast != null && this.zzast.length > 0) {
            while (i2 < this.zzast.length) {
                zzace zzace3 = this.zzast[i2];
                if (zzace3 != null) {
                    zza += zzabw.zzb(6, zzace3);
                }
                i2++;
            }
        }
        AppMethodBeat.o(69693);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        int i = 0;
        AppMethodBeat.i(69692);
        if (this.zzasp != null) {
            zzabw.zzb(1, this.zzasp.longValue());
        }
        if (this.zzadm != null) {
            zzabw.zzb(2, this.zzadm);
        }
        if (this.zzasq != null) {
            zzabw.zze(3, this.zzasq.intValue());
        }
        if (this.zzasr != null && this.zzasr.length > 0) {
            for (zzace zzace : this.zzasr) {
                if (zzace != null) {
                    zzabw.zza(4, zzace);
                }
            }
        }
        if (this.zzass != null && this.zzass.length > 0) {
            for (zzace zzace2 : this.zzass) {
                if (zzace2 != null) {
                    zzabw.zza(5, zzace2);
                }
            }
        }
        if (this.zzast != null && this.zzast.length > 0) {
            while (i < this.zzast.length) {
                zzace zzace3 = this.zzast[i];
                if (zzace3 != null) {
                    zzabw.zza(6, zzace3);
                }
                i++;
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(69692);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69694);
        while (true) {
            int zzuw = zzabv.zzuw();
            int zzb;
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69694);
                    break;
                case 8:
                    this.zzasp = Long.valueOf(zzabv.zzuz());
                    continue;
                case 18:
                    this.zzadm = zzabv.readString();
                    continue;
                case 24:
                    this.zzasq = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 34:
                    zzb = zzach.zzb(zzabv, 34);
                    zzuw = this.zzasr == null ? 0 : this.zzasr.length;
                    zzkl[] zzklArr = new zzkl[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzasr, 0, zzklArr, 0, zzuw);
                    }
                    while (zzuw < zzklArr.length - 1) {
                        zzklArr[zzuw] = new zzkl();
                        zzabv.zza(zzklArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzklArr[zzuw] = new zzkl();
                    zzabv.zza(zzklArr[zzuw]);
                    this.zzasr = zzklArr;
                    continue;
                case 42:
                    zzb = zzach.zzb(zzabv, 42);
                    zzuw = this.zzass == null ? 0 : this.zzass.length;
                    zzkj[] zzkjArr = new zzkj[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzass, 0, zzkjArr, 0, zzuw);
                    }
                    while (zzuw < zzkjArr.length - 1) {
                        zzkjArr[zzuw] = new zzkj();
                        zzabv.zza(zzkjArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkjArr[zzuw] = new zzkj();
                    zzabv.zza(zzkjArr[zzuw]);
                    this.zzass = zzkjArr;
                    continue;
                case 50:
                    zzb = zzach.zzb(zzabv, 50);
                    zzuw = this.zzast == null ? 0 : this.zzast.length;
                    zzkd[] zzkdArr = new zzkd[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzast, 0, zzkdArr, 0, zzuw);
                    }
                    while (zzuw < zzkdArr.length - 1) {
                        zzkdArr[zzuw] = new zzkd();
                        zzabv.zza(zzkdArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkdArr[zzuw] = new zzkd();
                    zzabv.zza(zzkdArr[zzuw]);
                    this.zzast = zzkdArr;
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69694);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
