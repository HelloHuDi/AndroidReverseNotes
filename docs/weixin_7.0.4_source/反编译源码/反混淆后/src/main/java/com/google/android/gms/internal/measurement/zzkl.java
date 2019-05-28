package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkl extends zzaby<zzkl> {
    private static volatile zzkl[] zzasu;
    public String value;
    public String zzny;

    public zzkl() {
        AppMethodBeat.m2504i(69695);
        this.zzny = null;
        this.value = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.m2505o(69695);
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
        AppMethodBeat.m2504i(69696);
        if (obj == this) {
            AppMethodBeat.m2505o(69696);
            return true;
        } else if (obj instanceof zzkl) {
            zzkl zzkl = (zzkl) obj;
            if (this.zzny == null) {
                if (zzkl.zzny != null) {
                    AppMethodBeat.m2505o(69696);
                    return false;
                }
            } else if (!this.zzny.equals(zzkl.zzny)) {
                AppMethodBeat.m2505o(69696);
                return false;
            }
            if (this.value == null) {
                if (zzkl.value != null) {
                    AppMethodBeat.m2505o(69696);
                    return false;
                }
            } else if (!this.value.equals(zzkl.value)) {
                AppMethodBeat.m2505o(69696);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkl.zzbww);
                AppMethodBeat.m2505o(69696);
                return equals;
            } else if (zzkl.zzbww == null || zzkl.zzbww.isEmpty()) {
                AppMethodBeat.m2505o(69696);
                return true;
            } else {
                AppMethodBeat.m2505o(69696);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(69696);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(69697);
        int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzny == null ? 0 : this.zzny.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(69697);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.m2504i(69699);
        int zza = super.zza();
        if (this.zzny != null) {
            zza += zzabw.zzc(1, this.zzny);
        }
        if (this.value != null) {
            zza += zzabw.zzc(2, this.value);
        }
        AppMethodBeat.m2505o(69699);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.m2504i(69698);
        if (this.zzny != null) {
            zzabw.zzb(1, this.zzny);
        }
        if (this.value != null) {
            zzabw.zzb(2, this.value);
        }
        super.zza(zzabw);
        AppMethodBeat.m2505o(69698);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.m2504i(69700);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.m2505o(69700);
                    break;
                case 10:
                    this.zzny = zzabv.readString();
                    continue;
                case 18:
                    this.value = zzabv.readString();
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.m2505o(69700);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
