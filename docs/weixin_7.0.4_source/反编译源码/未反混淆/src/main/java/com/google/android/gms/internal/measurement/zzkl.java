package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkl extends zzaby<zzkl> {
    private static volatile zzkl[] zzasu;
    public String value;
    public String zzny;

    public zzkl() {
        AppMethodBeat.i(69695);
        this.zzny = null;
        this.value = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69695);
    }

    public static zzkl[] zzlj() {
        if (zzasu == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasu == null) {
                    zzasu = new zzkl[0];
                }
            }
        }
        return zzasu;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69696);
        if (obj == this) {
            AppMethodBeat.o(69696);
            return true;
        } else if (obj instanceof zzkl) {
            zzkl zzkl = (zzkl) obj;
            if (this.zzny == null) {
                if (zzkl.zzny != null) {
                    AppMethodBeat.o(69696);
                    return false;
                }
            } else if (!this.zzny.equals(zzkl.zzny)) {
                AppMethodBeat.o(69696);
                return false;
            }
            if (this.value == null) {
                if (zzkl.value != null) {
                    AppMethodBeat.o(69696);
                    return false;
                }
            } else if (!this.value.equals(zzkl.value)) {
                AppMethodBeat.o(69696);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkl.zzbww);
                AppMethodBeat.o(69696);
                return equals;
            } else if (zzkl.zzbww == null || zzkl.zzbww.isEmpty()) {
                AppMethodBeat.o(69696);
                return true;
            } else {
                AppMethodBeat.o(69696);
                return false;
            }
        } else {
            AppMethodBeat.o(69696);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69697);
        int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzny == null ? 0 : this.zzny.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69697);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69699);
        int zza = super.zza();
        if (this.zzny != null) {
            zza += zzabw.zzc(1, this.zzny);
        }
        if (this.value != null) {
            zza += zzabw.zzc(2, this.value);
        }
        AppMethodBeat.o(69699);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69698);
        if (this.zzny != null) {
            zzabw.zzb(1, this.zzny);
        }
        if (this.value != null) {
            zzabw.zzb(2, this.value);
        }
        super.zza(zzabw);
        AppMethodBeat.o(69698);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69700);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69700);
                    break;
                case 10:
                    this.zzny = zzabv.readString();
                    continue;
                case 18:
                    this.value = zzabv.readString();
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69700);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
