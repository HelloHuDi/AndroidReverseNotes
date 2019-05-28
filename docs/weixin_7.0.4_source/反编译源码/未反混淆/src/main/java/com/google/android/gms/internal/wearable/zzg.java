package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzg extends zzn<zzg> {
    public zzh[] zzfy;

    public zzg() {
        AppMethodBeat.i(70678);
        this.zzfy = zzh.zzh();
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(70678);
    }

    public static zzg zza(byte[] bArr) {
        AppMethodBeat.i(70683);
        zzg zzg = (zzg) zzt.zza(new zzg(), bArr, 0, bArr.length);
        AppMethodBeat.o(70683);
        return zzg;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70679);
        if (obj == this) {
            AppMethodBeat.o(70679);
            return true;
        } else if (obj instanceof zzg) {
            zzg zzg = (zzg) obj;
            if (!zzr.equals(this.zzfy, zzg.zzfy)) {
                AppMethodBeat.o(70679);
                return false;
            } else if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzg.zzhc);
                AppMethodBeat.o(70679);
                return equals;
            } else if (zzg.zzhc == null || zzg.zzhc.isEmpty()) {
                AppMethodBeat.o(70679);
                return true;
            } else {
                AppMethodBeat.o(70679);
                return false;
            }
        } else {
            AppMethodBeat.o(70679);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(70680);
        int hashCode = (((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzr.hashCode(this.zzfy)) * 31;
        int hashCode2 = (this.zzhc == null || this.zzhc.isEmpty()) ? 0 : this.zzhc.hashCode();
        hashCode2 += hashCode;
        AppMethodBeat.o(70680);
        return hashCode2;
    }

    public final void zza(zzl zzl) {
        AppMethodBeat.i(70681);
        if (this.zzfy != null && this.zzfy.length > 0) {
            for (zzt zzt : this.zzfy) {
                if (zzt != null) {
                    zzl.zza(1, zzt);
                }
            }
        }
        super.zza(zzl);
        AppMethodBeat.o(70681);
    }

    /* Access modifiers changed, original: protected|final */
    public final int zzg() {
        AppMethodBeat.i(70682);
        int zzg = super.zzg();
        if (this.zzfy != null && this.zzfy.length > 0) {
            for (zzt zzt : this.zzfy) {
                if (zzt != null) {
                    zzg += zzl.zzb(1, zzt);
                }
            }
        }
        AppMethodBeat.o(70682);
        return zzg;
    }
}
