package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkd extends zzaby<zzkd> {
    private static volatile zzkd[] zzark;
    public Integer zzarl;
    public zzkh[] zzarm;
    public zzke[] zzarn;

    public zzkd() {
        AppMethodBeat.i(69645);
        this.zzarl = null;
        this.zzarm = zzkh.zzlh();
        this.zzarn = zzke.zzlf();
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69645);
    }

    public static zzkd[] zzle() {
        if (zzark == null) {
            synchronized (zzacc.zzbxg) {
                if (zzark == null) {
                    zzark = new zzkd[0];
                }
            }
        }
        return zzark;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69646);
        if (obj == this) {
            AppMethodBeat.o(69646);
            return true;
        } else if (obj instanceof zzkd) {
            zzkd zzkd = (zzkd) obj;
            if (this.zzarl == null) {
                if (zzkd.zzarl != null) {
                    AppMethodBeat.o(69646);
                    return false;
                }
            } else if (!this.zzarl.equals(zzkd.zzarl)) {
                AppMethodBeat.o(69646);
                return false;
            }
            if (!zzacc.equals(this.zzarm, zzkd.zzarm)) {
                AppMethodBeat.o(69646);
                return false;
            } else if (!zzacc.equals(this.zzarn, zzkd.zzarn)) {
                AppMethodBeat.o(69646);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkd.zzbww);
                AppMethodBeat.o(69646);
                return equals;
            } else if (zzkd.zzbww == null || zzkd.zzbww.isEmpty()) {
                AppMethodBeat.o(69646);
                return true;
            } else {
                AppMethodBeat.o(69646);
                return false;
            }
        } else {
            AppMethodBeat.o(69646);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69647);
        int hashCode = ((((((this.zzarl == null ? 0 : this.zzarl.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31) + zzacc.hashCode(this.zzarm)) * 31) + zzacc.hashCode(this.zzarn)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69647);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        int i = 0;
        AppMethodBeat.i(69649);
        int zza = super.zza();
        if (this.zzarl != null) {
            zza += zzabw.zzf(1, this.zzarl.intValue());
        }
        if (this.zzarm != null && this.zzarm.length > 0) {
            int i2 = zza;
            for (zzace zzace : this.zzarm) {
                if (zzace != null) {
                    i2 += zzabw.zzb(2, zzace);
                }
            }
            zza = i2;
        }
        if (this.zzarn != null && this.zzarn.length > 0) {
            while (i < this.zzarn.length) {
                zzace zzace2 = this.zzarn[i];
                if (zzace2 != null) {
                    zza += zzabw.zzb(3, zzace2);
                }
                i++;
            }
        }
        AppMethodBeat.o(69649);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        int i = 0;
        AppMethodBeat.i(69648);
        if (this.zzarl != null) {
            zzabw.zze(1, this.zzarl.intValue());
        }
        if (this.zzarm != null && this.zzarm.length > 0) {
            for (zzace zzace : this.zzarm) {
                if (zzace != null) {
                    zzabw.zza(2, zzace);
                }
            }
        }
        if (this.zzarn != null && this.zzarn.length > 0) {
            while (i < this.zzarn.length) {
                zzace zzace2 = this.zzarn[i];
                if (zzace2 != null) {
                    zzabw.zza(3, zzace2);
                }
                i++;
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(69648);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69650);
        while (true) {
            int zzuw = zzabv.zzuw();
            int zzb;
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69650);
                    break;
                case 8:
                    this.zzarl = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 18:
                    zzb = zzach.zzb(zzabv, 18);
                    zzuw = this.zzarm == null ? 0 : this.zzarm.length;
                    zzkh[] zzkhArr = new zzkh[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzarm, 0, zzkhArr, 0, zzuw);
                    }
                    while (zzuw < zzkhArr.length - 1) {
                        zzkhArr[zzuw] = new zzkh();
                        zzabv.zza(zzkhArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkhArr[zzuw] = new zzkh();
                    zzabv.zza(zzkhArr[zzuw]);
                    this.zzarm = zzkhArr;
                    continue;
                case 26:
                    zzb = zzach.zzb(zzabv, 26);
                    zzuw = this.zzarn == null ? 0 : this.zzarn.length;
                    zzke[] zzkeArr = new zzke[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzarn, 0, zzkeArr, 0, zzuw);
                    }
                    while (zzuw < zzkeArr.length - 1) {
                        zzkeArr[zzuw] = new zzke();
                        zzabv.zza(zzkeArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkeArr[zzuw] = new zzke();
                    zzabv.zza(zzkeArr[zzuw]);
                    this.zzarn = zzkeArr;
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69650);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
