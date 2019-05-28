package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkg extends zzaby<zzkg> {
    public Integer zzarz;
    public Boolean zzasa;
    public String zzasb;
    public String zzasc;
    public String zzasd;

    public zzkg() {
        AppMethodBeat.i(69663);
        this.zzarz = null;
        this.zzasa = null;
        this.zzasb = null;
        this.zzasc = null;
        this.zzasd = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69663);
    }

    private final zzkg zzd(zzabv zzabv) {
        AppMethodBeat.i(69668);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69668);
                    break;
                case 8:
                    int position = zzabv.getPosition();
                    try {
                        int zzuy = zzabv.zzuy();
                        if (zzuy < 0 || zzuy > 4) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(zzuy + " is not a valid enum ComparisonType");
                            AppMethodBeat.o(69668);
                            throw illegalArgumentException;
                        }
                        this.zzarz = Integer.valueOf(zzuy);
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzabv.zzam(position);
                        zza(zzabv, zzuw);
                        break;
                    }
                    break;
                case 16:
                    this.zzasa = Boolean.valueOf(zzabv.zzux());
                    continue;
                case 26:
                    this.zzasb = zzabv.readString();
                    continue;
                case 34:
                    this.zzasc = zzabv.readString();
                    continue;
                case 42:
                    this.zzasd = zzabv.readString();
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69668);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69664);
        if (obj == this) {
            AppMethodBeat.o(69664);
            return true;
        } else if (obj instanceof zzkg) {
            zzkg zzkg = (zzkg) obj;
            if (this.zzarz == null) {
                if (zzkg.zzarz != null) {
                    AppMethodBeat.o(69664);
                    return false;
                }
            } else if (!this.zzarz.equals(zzkg.zzarz)) {
                AppMethodBeat.o(69664);
                return false;
            }
            if (this.zzasa == null) {
                if (zzkg.zzasa != null) {
                    AppMethodBeat.o(69664);
                    return false;
                }
            } else if (!this.zzasa.equals(zzkg.zzasa)) {
                AppMethodBeat.o(69664);
                return false;
            }
            if (this.zzasb == null) {
                if (zzkg.zzasb != null) {
                    AppMethodBeat.o(69664);
                    return false;
                }
            } else if (!this.zzasb.equals(zzkg.zzasb)) {
                AppMethodBeat.o(69664);
                return false;
            }
            if (this.zzasc == null) {
                if (zzkg.zzasc != null) {
                    AppMethodBeat.o(69664);
                    return false;
                }
            } else if (!this.zzasc.equals(zzkg.zzasc)) {
                AppMethodBeat.o(69664);
                return false;
            }
            if (this.zzasd == null) {
                if (zzkg.zzasd != null) {
                    AppMethodBeat.o(69664);
                    return false;
                }
            } else if (!this.zzasd.equals(zzkg.zzasd)) {
                AppMethodBeat.o(69664);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkg.zzbww);
                AppMethodBeat.o(69664);
                return equals;
            } else if (zzkg.zzbww == null || zzkg.zzbww.isEmpty()) {
                AppMethodBeat.o(69664);
                return true;
            } else {
                AppMethodBeat.o(69664);
                return false;
            }
        } else {
            AppMethodBeat.o(69664);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69665);
        int hashCode = ((this.zzasd == null ? 0 : this.zzasd.hashCode()) + (((this.zzasc == null ? 0 : this.zzasc.hashCode()) + (((this.zzasb == null ? 0 : this.zzasb.hashCode()) + (((this.zzasa == null ? 0 : this.zzasa.hashCode()) + (((this.zzarz == null ? 0 : this.zzarz.intValue()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69665);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69667);
        int zza = super.zza();
        if (this.zzarz != null) {
            zza += zzabw.zzf(1, this.zzarz.intValue());
        }
        if (this.zzasa != null) {
            this.zzasa.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        if (this.zzasb != null) {
            zza += zzabw.zzc(3, this.zzasb);
        }
        if (this.zzasc != null) {
            zza += zzabw.zzc(4, this.zzasc);
        }
        if (this.zzasd != null) {
            zza += zzabw.zzc(5, this.zzasd);
        }
        AppMethodBeat.o(69667);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69666);
        if (this.zzarz != null) {
            zzabw.zze(1, this.zzarz.intValue());
        }
        if (this.zzasa != null) {
            zzabw.zza(2, this.zzasa.booleanValue());
        }
        if (this.zzasb != null) {
            zzabw.zzb(3, this.zzasb);
        }
        if (this.zzasc != null) {
            zzabw.zzb(4, this.zzasc);
        }
        if (this.zzasd != null) {
            zzabw.zzb(5, this.zzasd);
        }
        super.zza(zzabw);
        AppMethodBeat.o(69666);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69669);
        zzkg zzd = zzd(zzabv);
        AppMethodBeat.o(69669);
        return zzd;
    }
}
