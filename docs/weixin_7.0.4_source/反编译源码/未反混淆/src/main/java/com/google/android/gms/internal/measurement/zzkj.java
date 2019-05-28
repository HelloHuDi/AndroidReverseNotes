package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkj extends zzaby<zzkj> {
    private static volatile zzkj[] zzasl;
    public String name;
    public Boolean zzasm;
    public Boolean zzasn;
    public Integer zzaso;

    public zzkj() {
        AppMethodBeat.i(69683);
        this.name = null;
        this.zzasm = null;
        this.zzasn = null;
        this.zzaso = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69683);
    }

    public static zzkj[] zzli() {
        if (zzasl == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasl == null) {
                    zzasl = new zzkj[0];
                }
            }
        }
        return zzasl;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69684);
        if (obj == this) {
            AppMethodBeat.o(69684);
            return true;
        } else if (obj instanceof zzkj) {
            zzkj zzkj = (zzkj) obj;
            if (this.name == null) {
                if (zzkj.name != null) {
                    AppMethodBeat.o(69684);
                    return false;
                }
            } else if (!this.name.equals(zzkj.name)) {
                AppMethodBeat.o(69684);
                return false;
            }
            if (this.zzasm == null) {
                if (zzkj.zzasm != null) {
                    AppMethodBeat.o(69684);
                    return false;
                }
            } else if (!this.zzasm.equals(zzkj.zzasm)) {
                AppMethodBeat.o(69684);
                return false;
            }
            if (this.zzasn == null) {
                if (zzkj.zzasn != null) {
                    AppMethodBeat.o(69684);
                    return false;
                }
            } else if (!this.zzasn.equals(zzkj.zzasn)) {
                AppMethodBeat.o(69684);
                return false;
            }
            if (this.zzaso == null) {
                if (zzkj.zzaso != null) {
                    AppMethodBeat.o(69684);
                    return false;
                }
            } else if (!this.zzaso.equals(zzkj.zzaso)) {
                AppMethodBeat.o(69684);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkj.zzbww);
                AppMethodBeat.o(69684);
                return equals;
            } else if (zzkj.zzbww == null || zzkj.zzbww.isEmpty()) {
                AppMethodBeat.o(69684);
                return true;
            } else {
                AppMethodBeat.o(69684);
                return false;
            }
        } else {
            AppMethodBeat.o(69684);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69685);
        int hashCode = ((this.zzaso == null ? 0 : this.zzaso.hashCode()) + (((this.zzasn == null ? 0 : this.zzasn.hashCode()) + (((this.zzasm == null ? 0 : this.zzasm.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69685);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69687);
        int zza = super.zza();
        if (this.name != null) {
            zza += zzabw.zzc(1, this.name);
        }
        if (this.zzasm != null) {
            this.zzasm.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        if (this.zzasn != null) {
            this.zzasn.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzaso != null) {
            zza += zzabw.zzf(4, this.zzaso.intValue());
        }
        AppMethodBeat.o(69687);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69686);
        if (this.name != null) {
            zzabw.zzb(1, this.name);
        }
        if (this.zzasm != null) {
            zzabw.zza(2, this.zzasm.booleanValue());
        }
        if (this.zzasn != null) {
            zzabw.zza(3, this.zzasn.booleanValue());
        }
        if (this.zzaso != null) {
            zzabw.zze(4, this.zzaso.intValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(69686);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69688);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69688);
                    break;
                case 10:
                    this.name = zzabv.readString();
                    continue;
                case 16:
                    this.zzasm = Boolean.valueOf(zzabv.zzux());
                    continue;
                case 24:
                    this.zzasn = Boolean.valueOf(zzabv.zzux());
                    continue;
                case 32:
                    this.zzaso = Integer.valueOf(zzabv.zzuy());
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69688);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
