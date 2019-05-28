package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzh extends zzn<zzh> {
    private static volatile zzh[] zzfz;
    public String name;
    public zzi zzga;

    public zzh() {
        AppMethodBeat.i(70685);
        this.name = "";
        this.zzga = null;
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(70685);
    }

    public static zzh[] zzh() {
        if (zzfz == null) {
            synchronized (zzr.zzhk) {
                if (zzfz == null) {
                    zzfz = new zzh[0];
                }
            }
        }
        return zzfz;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70686);
        if (obj == this) {
            AppMethodBeat.o(70686);
            return true;
        } else if (obj instanceof zzh) {
            zzh zzh = (zzh) obj;
            if (this.name == null) {
                if (zzh.name != null) {
                    AppMethodBeat.o(70686);
                    return false;
                }
            } else if (!this.name.equals(zzh.name)) {
                AppMethodBeat.o(70686);
                return false;
            }
            if (this.zzga == null) {
                if (zzh.zzga != null) {
                    AppMethodBeat.o(70686);
                    return false;
                }
            } else if (!this.zzga.equals(zzh.zzga)) {
                AppMethodBeat.o(70686);
                return false;
            }
            if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzh.zzhc);
                AppMethodBeat.o(70686);
                return equals;
            } else if (zzh.zzhc == null || zzh.zzhc.isEmpty()) {
                AppMethodBeat.o(70686);
                return true;
            } else {
                AppMethodBeat.o(70686);
                return false;
            }
        } else {
            AppMethodBeat.o(70686);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(70687);
        int hashCode = (this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31);
        zzi zzi = this.zzga;
        hashCode = ((zzi == null ? 0 : zzi.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.zzhc == null || this.zzhc.isEmpty())) {
            i = this.zzhc.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(70687);
        return hashCode;
    }

    public final void zza(zzl zzl) {
        AppMethodBeat.i(70688);
        zzl.zza(1, this.name);
        if (this.zzga != null) {
            zzl.zza(2, this.zzga);
        }
        super.zza(zzl);
        AppMethodBeat.o(70688);
    }

    /* Access modifiers changed, original: protected|final */
    public final int zzg() {
        AppMethodBeat.i(70689);
        int zzg = super.zzg() + zzl.zzb(1, this.name);
        if (this.zzga != null) {
            zzg += zzl.zzb(2, this.zzga);
        }
        AppMethodBeat.o(70689);
        return zzg;
    }
}
