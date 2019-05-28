package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkf extends zzaby<zzkf> {
    private static volatile zzkf[] zzaru;
    public zzki zzarv;
    public zzkg zzarw;
    public Boolean zzarx;
    public String zzary;

    public zzkf() {
        AppMethodBeat.i(69657);
        this.zzarv = null;
        this.zzarw = null;
        this.zzarx = null;
        this.zzary = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69657);
    }

    public static zzkf[] zzlg() {
        if (zzaru == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaru == null) {
                    zzaru = new zzkf[0];
                }
            }
        }
        return zzaru;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69658);
        if (obj == this) {
            AppMethodBeat.o(69658);
            return true;
        } else if (obj instanceof zzkf) {
            zzkf zzkf = (zzkf) obj;
            if (this.zzarv == null) {
                if (zzkf.zzarv != null) {
                    AppMethodBeat.o(69658);
                    return false;
                }
            } else if (!this.zzarv.equals(zzkf.zzarv)) {
                AppMethodBeat.o(69658);
                return false;
            }
            if (this.zzarw == null) {
                if (zzkf.zzarw != null) {
                    AppMethodBeat.o(69658);
                    return false;
                }
            } else if (!this.zzarw.equals(zzkf.zzarw)) {
                AppMethodBeat.o(69658);
                return false;
            }
            if (this.zzarx == null) {
                if (zzkf.zzarx != null) {
                    AppMethodBeat.o(69658);
                    return false;
                }
            } else if (!this.zzarx.equals(zzkf.zzarx)) {
                AppMethodBeat.o(69658);
                return false;
            }
            if (this.zzary == null) {
                if (zzkf.zzary != null) {
                    AppMethodBeat.o(69658);
                    return false;
                }
            } else if (!this.zzary.equals(zzkf.zzary)) {
                AppMethodBeat.o(69658);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkf.zzbww);
                AppMethodBeat.o(69658);
                return equals;
            } else if (zzkf.zzbww == null || zzkf.zzbww.isEmpty()) {
                AppMethodBeat.o(69658);
                return true;
            } else {
                AppMethodBeat.o(69658);
                return false;
            }
        } else {
            AppMethodBeat.o(69658);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69659);
        int hashCode = getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX;
        zzki zzki = this.zzarv;
        hashCode = (zzki == null ? 0 : zzki.hashCode()) + (hashCode * 31);
        zzkg zzkg = this.zzarw;
        hashCode = ((this.zzary == null ? 0 : this.zzary.hashCode()) + (((this.zzarx == null ? 0 : this.zzarx.hashCode()) + (((zzkg == null ? 0 : zzkg.hashCode()) + (hashCode * 31)) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69659);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69661);
        int zza = super.zza();
        if (this.zzarv != null) {
            zza += zzabw.zzb(1, this.zzarv);
        }
        if (this.zzarw != null) {
            zza += zzabw.zzb(2, this.zzarw);
        }
        if (this.zzarx != null) {
            this.zzarx.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzary != null) {
            zza += zzabw.zzc(4, this.zzary);
        }
        AppMethodBeat.o(69661);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69660);
        if (this.zzarv != null) {
            zzabw.zza(1, this.zzarv);
        }
        if (this.zzarw != null) {
            zzabw.zza(2, this.zzarw);
        }
        if (this.zzarx != null) {
            zzabw.zza(3, this.zzarx.booleanValue());
        }
        if (this.zzary != null) {
            zzabw.zzb(4, this.zzary);
        }
        super.zza(zzabw);
        AppMethodBeat.o(69660);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69662);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69662);
                    break;
                case 10:
                    if (this.zzarv == null) {
                        this.zzarv = new zzki();
                    }
                    zzabv.zza(this.zzarv);
                    continue;
                case 18:
                    if (this.zzarw == null) {
                        this.zzarw = new zzkg();
                    }
                    zzabv.zza(this.zzarw);
                    continue;
                case 24:
                    this.zzarx = Boolean.valueOf(zzabv.zzux());
                    continue;
                case 34:
                    this.zzary = zzabv.readString();
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69662);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
