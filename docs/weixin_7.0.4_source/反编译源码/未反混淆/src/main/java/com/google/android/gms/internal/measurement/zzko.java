package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;

public final class zzko extends zzaby<zzko> {
    private static volatile zzko[] zzatd;
    public String name;
    public String zzajf;
    private Float zzarb;
    public Double zzarc;
    public Long zzate;

    public zzko() {
        AppMethodBeat.i(69713);
        this.name = null;
        this.zzajf = null;
        this.zzate = null;
        this.zzarb = null;
        this.zzarc = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69713);
    }

    public static zzko[] zzlm() {
        if (zzatd == null) {
            synchronized (zzacc.zzbxg) {
                if (zzatd == null) {
                    zzatd = new zzko[0];
                }
            }
        }
        return zzatd;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69714);
        if (obj == this) {
            AppMethodBeat.o(69714);
            return true;
        } else if (obj instanceof zzko) {
            zzko zzko = (zzko) obj;
            if (this.name == null) {
                if (zzko.name != null) {
                    AppMethodBeat.o(69714);
                    return false;
                }
            } else if (!this.name.equals(zzko.name)) {
                AppMethodBeat.o(69714);
                return false;
            }
            if (this.zzajf == null) {
                if (zzko.zzajf != null) {
                    AppMethodBeat.o(69714);
                    return false;
                }
            } else if (!this.zzajf.equals(zzko.zzajf)) {
                AppMethodBeat.o(69714);
                return false;
            }
            if (this.zzate == null) {
                if (zzko.zzate != null) {
                    AppMethodBeat.o(69714);
                    return false;
                }
            } else if (!this.zzate.equals(zzko.zzate)) {
                AppMethodBeat.o(69714);
                return false;
            }
            if (this.zzarb == null) {
                if (zzko.zzarb != null) {
                    AppMethodBeat.o(69714);
                    return false;
                }
            } else if (!this.zzarb.equals(zzko.zzarb)) {
                AppMethodBeat.o(69714);
                return false;
            }
            if (this.zzarc == null) {
                if (zzko.zzarc != null) {
                    AppMethodBeat.o(69714);
                    return false;
                }
            } else if (!this.zzarc.equals(zzko.zzarc)) {
                AppMethodBeat.o(69714);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzko.zzbww);
                AppMethodBeat.o(69714);
                return equals;
            } else if (zzko.zzbww == null || zzko.zzbww.isEmpty()) {
                AppMethodBeat.o(69714);
                return true;
            } else {
                AppMethodBeat.o(69714);
                return false;
            }
        } else {
            AppMethodBeat.o(69714);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69715);
        int hashCode = ((this.zzarc == null ? 0 : this.zzarc.hashCode()) + (((this.zzarb == null ? 0 : this.zzarb.hashCode()) + (((this.zzate == null ? 0 : this.zzate.hashCode()) + (((this.zzajf == null ? 0 : this.zzajf.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69715);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69717);
        int zza = super.zza();
        if (this.name != null) {
            zza += zzabw.zzc(1, this.name);
        }
        if (this.zzajf != null) {
            zza += zzabw.zzc(2, this.zzajf);
        }
        if (this.zzate != null) {
            zza += zzabw.zzc(3, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            this.zzarb.floatValue();
            zza += zzabw.zzaq(4) + 4;
        }
        if (this.zzarc != null) {
            this.zzarc.doubleValue();
            zza += zzabw.zzaq(5) + 8;
        }
        AppMethodBeat.o(69717);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69716);
        if (this.name != null) {
            zzabw.zzb(1, this.name);
        }
        if (this.zzajf != null) {
            zzabw.zzb(2, this.zzajf);
        }
        if (this.zzate != null) {
            zzabw.zzb(3, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            zzabw.zza(4, this.zzarb.floatValue());
        }
        if (this.zzarc != null) {
            zzabw.zza(5, this.zzarc.doubleValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(69716);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69718);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69718);
                    break;
                case 10:
                    this.name = zzabv.readString();
                    continue;
                case 18:
                    this.zzajf = zzabv.readString();
                    continue;
                case 24:
                    this.zzate = Long.valueOf(zzabv.zzuz());
                    continue;
                case g.CTRL_INDEX /*37*/:
                    this.zzarb = Float.valueOf(Float.intBitsToFloat(zzabv.zzva()));
                    continue;
                case 41:
                    this.zzarc = Double.valueOf(Double.longBitsToDouble(zzabv.zzvb()));
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69718);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
