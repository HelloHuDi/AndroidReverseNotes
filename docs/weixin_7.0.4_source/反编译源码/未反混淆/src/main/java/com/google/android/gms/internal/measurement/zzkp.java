package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkp extends zzaby<zzkp> {
    public zzkq[] zzatf;

    public zzkp() {
        AppMethodBeat.i(69719);
        this.zzatf = zzkq.zzln();
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69719);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69720);
        if (obj == this) {
            AppMethodBeat.o(69720);
            return true;
        } else if (obj instanceof zzkp) {
            zzkp zzkp = (zzkp) obj;
            if (!zzacc.equals(this.zzatf, zzkp.zzatf)) {
                AppMethodBeat.o(69720);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkp.zzbww);
                AppMethodBeat.o(69720);
                return equals;
            } else if (zzkp.zzbww == null || zzkp.zzbww.isEmpty()) {
                AppMethodBeat.o(69720);
                return true;
            } else {
                AppMethodBeat.o(69720);
                return false;
            }
        } else {
            AppMethodBeat.o(69720);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(69721);
        int hashCode = (((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzacc.hashCode(this.zzatf)) * 31;
        int hashCode2 = (this.zzbww == null || this.zzbww.isEmpty()) ? 0 : this.zzbww.hashCode();
        hashCode2 += hashCode;
        AppMethodBeat.o(69721);
        return hashCode2;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69723);
        int zza = super.zza();
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (zzace zzace : this.zzatf) {
                if (zzace != null) {
                    zza += zzabw.zzb(1, zzace);
                }
            }
        }
        AppMethodBeat.o(69723);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69722);
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (zzace zzace : this.zzatf) {
                if (zzace != null) {
                    zzabw.zza(1, zzace);
                }
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(69722);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69724);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69724);
                    break;
                case 10:
                    int zzb = zzach.zzb(zzabv, 10);
                    zzuw = this.zzatf == null ? 0 : this.zzatf.length;
                    zzkq[] zzkqArr = new zzkq[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzatf, 0, zzkqArr, 0, zzuw);
                    }
                    while (zzuw < zzkqArr.length - 1) {
                        zzkqArr[zzuw] = new zzkq();
                        zzabv.zza(zzkqArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkqArr[zzuw] = new zzkq();
                    zzabv.zza(zzkqArr[zzuw]);
                    this.zzatf = zzkqArr;
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69724);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
