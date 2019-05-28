package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkm extends zzaby<zzkm> {
    private static volatile zzkm[] zzasv;
    public Integer zzarl;
    public zzkr zzasw;
    public zzkr zzasx;
    public Boolean zzasy;

    public zzkm() {
        AppMethodBeat.m2504i(69701);
        this.zzarl = null;
        this.zzasw = null;
        this.zzasx = null;
        this.zzasy = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.m2505o(69701);
    }

    public static zzkm[] zzlk() {
        if (zzasv == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasv == null) {
                    zzasv = new zzkm[0];
                }
            }
        }
        return zzasv;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(69702);
        if (obj == this) {
            AppMethodBeat.m2505o(69702);
            return true;
        } else if (obj instanceof zzkm) {
            zzkm zzkm = (zzkm) obj;
            if (this.zzarl == null) {
                if (zzkm.zzarl != null) {
                    AppMethodBeat.m2505o(69702);
                    return false;
                }
            } else if (!this.zzarl.equals(zzkm.zzarl)) {
                AppMethodBeat.m2505o(69702);
                return false;
            }
            if (this.zzasw == null) {
                if (zzkm.zzasw != null) {
                    AppMethodBeat.m2505o(69702);
                    return false;
                }
            } else if (!this.zzasw.equals(zzkm.zzasw)) {
                AppMethodBeat.m2505o(69702);
                return false;
            }
            if (this.zzasx == null) {
                if (zzkm.zzasx != null) {
                    AppMethodBeat.m2505o(69702);
                    return false;
                }
            } else if (!this.zzasx.equals(zzkm.zzasx)) {
                AppMethodBeat.m2505o(69702);
                return false;
            }
            if (this.zzasy == null) {
                if (zzkm.zzasy != null) {
                    AppMethodBeat.m2505o(69702);
                    return false;
                }
            } else if (!this.zzasy.equals(zzkm.zzasy)) {
                AppMethodBeat.m2505o(69702);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkm.zzbww);
                AppMethodBeat.m2505o(69702);
                return equals;
            } else if (zzkm.zzbww == null || zzkm.zzbww.isEmpty()) {
                AppMethodBeat.m2505o(69702);
                return true;
            } else {
                AppMethodBeat.m2505o(69702);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(69702);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(69703);
        int hashCode = (this.zzarl == null ? 0 : this.zzarl.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31);
        zzkr zzkr = this.zzasw;
        hashCode = (zzkr == null ? 0 : zzkr.hashCode()) + (hashCode * 31);
        zzkr = this.zzasx;
        hashCode = ((this.zzasy == null ? 0 : this.zzasy.hashCode()) + (((zzkr == null ? 0 : zzkr.hashCode()) + (hashCode * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(69703);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.m2504i(69705);
        int zza = super.zza();
        if (this.zzarl != null) {
            zza += zzabw.zzf(1, this.zzarl.intValue());
        }
        if (this.zzasw != null) {
            zza += zzabw.zzb(2, this.zzasw);
        }
        if (this.zzasx != null) {
            zza += zzabw.zzb(3, this.zzasx);
        }
        if (this.zzasy != null) {
            this.zzasy.booleanValue();
            zza += zzabw.zzaq(4) + 1;
        }
        AppMethodBeat.m2505o(69705);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.m2504i(69704);
        if (this.zzarl != null) {
            zzabw.zze(1, this.zzarl.intValue());
        }
        if (this.zzasw != null) {
            zzabw.zza(2, this.zzasw);
        }
        if (this.zzasx != null) {
            zzabw.zza(3, this.zzasx);
        }
        if (this.zzasy != null) {
            zzabw.zza(4, this.zzasy.booleanValue());
        }
        super.zza(zzabw);
        AppMethodBeat.m2505o(69704);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.m2504i(69706);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.m2505o(69706);
                    break;
                case 8:
                    this.zzarl = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 18:
                    if (this.zzasw == null) {
                        this.zzasw = new zzkr();
                    }
                    zzabv.zza(this.zzasw);
                    continue;
                case 26:
                    if (this.zzasx == null) {
                        this.zzasx = new zzkr();
                    }
                    zzabv.zza(this.zzasx);
                    continue;
                case 32:
                    this.zzasy = Boolean.valueOf(zzabv.zzux());
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.m2505o(69706);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
