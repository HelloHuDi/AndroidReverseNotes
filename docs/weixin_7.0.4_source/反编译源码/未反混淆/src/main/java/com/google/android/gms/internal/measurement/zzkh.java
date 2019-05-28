package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkh extends zzaby<zzkh> {
    private static volatile zzkh[] zzase;
    public Integer zzarp;
    public String zzasf;
    public zzkf zzasg;

    public zzkh() {
        AppMethodBeat.i(69670);
        this.zzarp = null;
        this.zzasf = null;
        this.zzasg = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69670);
    }

    public static zzkh[] zzlh() {
        if (zzase == null) {
            synchronized (zzacc.zzbxg) {
                if (zzase == null) {
                    zzase = new zzkh[0];
                }
            }
        }
        return zzase;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69671);
        if (obj == this) {
            AppMethodBeat.o(69671);
            return true;
        } else if (obj instanceof zzkh) {
            zzkh zzkh = (zzkh) obj;
            if (this.zzarp == null) {
                if (zzkh.zzarp != null) {
                    AppMethodBeat.o(69671);
                    return false;
                }
            } else if (!this.zzarp.equals(zzkh.zzarp)) {
                AppMethodBeat.o(69671);
                return false;
            }
            if (this.zzasf == null) {
                if (zzkh.zzasf != null) {
                    AppMethodBeat.o(69671);
                    return false;
                }
            } else if (!this.zzasf.equals(zzkh.zzasf)) {
                AppMethodBeat.o(69671);
                return false;
            }
            if (this.zzasg == null) {
                if (zzkh.zzasg != null) {
                    AppMethodBeat.o(69671);
                    return false;
                }
            } else if (!this.zzasg.equals(zzkh.zzasg)) {
                AppMethodBeat.o(69671);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkh.zzbww);
                AppMethodBeat.o(69671);
                return equals;
            } else if (zzkh.zzbww == null || zzkh.zzbww.isEmpty()) {
                AppMethodBeat.o(69671);
                return true;
            } else {
                AppMethodBeat.o(69671);
                return false;
            }
        } else {
            AppMethodBeat.o(69671);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69672);
        int hashCode = (this.zzasf == null ? 0 : this.zzasf.hashCode()) + (((this.zzarp == null ? 0 : this.zzarp.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31);
        zzkf zzkf = this.zzasg;
        hashCode = ((zzkf == null ? 0 : zzkf.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69672);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69674);
        int zza = super.zza();
        if (this.zzarp != null) {
            zza += zzabw.zzf(1, this.zzarp.intValue());
        }
        if (this.zzasf != null) {
            zza += zzabw.zzc(2, this.zzasf);
        }
        if (this.zzasg != null) {
            zza += zzabw.zzb(3, this.zzasg);
        }
        AppMethodBeat.o(69674);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69673);
        if (this.zzarp != null) {
            zzabw.zze(1, this.zzarp.intValue());
        }
        if (this.zzasf != null) {
            zzabw.zzb(2, this.zzasf);
        }
        if (this.zzasg != null) {
            zzabw.zza(3, this.zzasg);
        }
        super.zza(zzabw);
        AppMethodBeat.o(69673);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69675);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69675);
                    break;
                case 8:
                    this.zzarp = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 18:
                    this.zzasf = zzabv.readString();
                    continue;
                case 26:
                    if (this.zzasg == null) {
                        this.zzasg = new zzkf();
                    }
                    zzabv.zza(this.zzasg);
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69675);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
