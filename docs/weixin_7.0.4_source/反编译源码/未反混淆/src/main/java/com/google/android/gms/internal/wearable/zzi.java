package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzi extends zzn<zzi> {
    private static volatile zzi[] zzgb;
    public int type;
    public zzj zzgc;

    public zzi() {
        AppMethodBeat.i(70691);
        this.type = 1;
        this.zzgc = null;
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(70691);
    }

    private final zzi zzb(zzk zzk) {
        AppMethodBeat.i(70696);
        while (true) {
            int zzj = zzk.zzj();
            switch (zzj) {
                case 0:
                    AppMethodBeat.o(70696);
                    break;
                case 8:
                    int position = zzk.getPosition();
                    try {
                        int zzk2 = zzk.zzk();
                        if (zzk2 <= 0 || zzk2 > 15) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(zzk2 + " is not a valid enum Type");
                            AppMethodBeat.o(70696);
                            throw illegalArgumentException;
                        }
                        this.type = zzk2;
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzk.zzg(position);
                        zza(zzk, zzj);
                        break;
                    }
                    break;
                case 18:
                    if (this.zzgc == null) {
                        this.zzgc = new zzj();
                    }
                    zzk.zza(this.zzgc);
                    continue;
                default:
                    if (!super.zza(zzk, zzj)) {
                        AppMethodBeat.o(70696);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }

    public static zzi[] zzi() {
        if (zzgb == null) {
            synchronized (zzr.zzhk) {
                if (zzgb == null) {
                    zzgb = new zzi[0];
                }
            }
        }
        return zzgb;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70692);
        if (obj == this) {
            AppMethodBeat.o(70692);
            return true;
        } else if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (this.type != zzi.type) {
                AppMethodBeat.o(70692);
                return false;
            }
            if (this.zzgc == null) {
                if (zzi.zzgc != null) {
                    AppMethodBeat.o(70692);
                    return false;
                }
            } else if (!this.zzgc.equals(zzi.zzgc)) {
                AppMethodBeat.o(70692);
                return false;
            }
            if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzi.zzhc);
                AppMethodBeat.o(70692);
                return equals;
            } else if (zzi.zzhc == null || zzi.zzhc.isEmpty()) {
                AppMethodBeat.o(70692);
                return true;
            } else {
                AppMethodBeat.o(70692);
                return false;
            }
        } else {
            AppMethodBeat.o(70692);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(70693);
        int hashCode = ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.type;
        zzj zzj = this.zzgc;
        hashCode = ((zzj == null ? 0 : zzj.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.zzhc == null || this.zzhc.isEmpty())) {
            i = this.zzhc.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(70693);
        return hashCode;
    }

    public final void zza(zzl zzl) {
        AppMethodBeat.i(70694);
        zzl.zzd(1, this.type);
        if (this.zzgc != null) {
            zzl.zza(2, this.zzgc);
        }
        super.zza(zzl);
        AppMethodBeat.o(70694);
    }

    /* Access modifiers changed, original: protected|final */
    public final int zzg() {
        AppMethodBeat.i(70695);
        int zzg = super.zzg() + zzl.zze(1, this.type);
        if (this.zzgc != null) {
            zzg += zzl.zzb(2, this.zzgc);
        }
        AppMethodBeat.o(70695);
        return zzg;
    }
}
