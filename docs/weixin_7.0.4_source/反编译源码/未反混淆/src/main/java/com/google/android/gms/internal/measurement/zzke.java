package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzke extends zzaby<zzke> {
    private static volatile zzke[] zzaro;
    public Integer zzarp;
    public String zzarq;
    public zzkf[] zzarr;
    private Boolean zzars;
    public zzkg zzart;

    public zzke() {
        AppMethodBeat.i(69651);
        this.zzarp = null;
        this.zzarq = null;
        this.zzarr = zzkf.zzlg();
        this.zzars = null;
        this.zzart = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69651);
    }

    public static zzke[] zzlf() {
        if (zzaro == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaro == null) {
                    zzaro = new zzke[0];
                }
            }
        }
        return zzaro;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69652);
        if (obj == this) {
            AppMethodBeat.o(69652);
            return true;
        } else if (obj instanceof zzke) {
            zzke zzke = (zzke) obj;
            if (this.zzarp == null) {
                if (zzke.zzarp != null) {
                    AppMethodBeat.o(69652);
                    return false;
                }
            } else if (!this.zzarp.equals(zzke.zzarp)) {
                AppMethodBeat.o(69652);
                return false;
            }
            if (this.zzarq == null) {
                if (zzke.zzarq != null) {
                    AppMethodBeat.o(69652);
                    return false;
                }
            } else if (!this.zzarq.equals(zzke.zzarq)) {
                AppMethodBeat.o(69652);
                return false;
            }
            if (zzacc.equals(this.zzarr, zzke.zzarr)) {
                if (this.zzars == null) {
                    if (zzke.zzars != null) {
                        AppMethodBeat.o(69652);
                        return false;
                    }
                } else if (!this.zzars.equals(zzke.zzars)) {
                    AppMethodBeat.o(69652);
                    return false;
                }
                if (this.zzart == null) {
                    if (zzke.zzart != null) {
                        AppMethodBeat.o(69652);
                        return false;
                    }
                } else if (!this.zzart.equals(zzke.zzart)) {
                    AppMethodBeat.o(69652);
                    return false;
                }
                if (this.zzbww != null && !this.zzbww.isEmpty()) {
                    boolean equals = this.zzbww.equals(zzke.zzbww);
                    AppMethodBeat.o(69652);
                    return equals;
                } else if (zzke.zzbww == null || zzke.zzbww.isEmpty()) {
                    AppMethodBeat.o(69652);
                    return true;
                } else {
                    AppMethodBeat.o(69652);
                    return false;
                }
            }
            AppMethodBeat.o(69652);
            return false;
        } else {
            AppMethodBeat.o(69652);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69653);
        int hashCode = (this.zzars == null ? 0 : this.zzars.hashCode()) + (((((this.zzarq == null ? 0 : this.zzarq.hashCode()) + (((this.zzarp == null ? 0 : this.zzarp.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzarr)) * 31);
        zzkg zzkg = this.zzart;
        hashCode = ((zzkg == null ? 0 : zzkg.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69653);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69655);
        int zza = super.zza();
        if (this.zzarp != null) {
            zza += zzabw.zzf(1, this.zzarp.intValue());
        }
        if (this.zzarq != null) {
            zza += zzabw.zzc(2, this.zzarq);
        }
        if (this.zzarr != null && this.zzarr.length > 0) {
            int i = zza;
            for (zzace zzace : this.zzarr) {
                if (zzace != null) {
                    i += zzabw.zzb(3, zzace);
                }
            }
            zza = i;
        }
        if (this.zzars != null) {
            this.zzars.booleanValue();
            zza += zzabw.zzaq(4) + 1;
        }
        if (this.zzart != null) {
            zza += zzabw.zzb(5, this.zzart);
        }
        AppMethodBeat.o(69655);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69654);
        if (this.zzarp != null) {
            zzabw.zze(1, this.zzarp.intValue());
        }
        if (this.zzarq != null) {
            zzabw.zzb(2, this.zzarq);
        }
        if (this.zzarr != null && this.zzarr.length > 0) {
            for (zzace zzace : this.zzarr) {
                if (zzace != null) {
                    zzabw.zza(3, zzace);
                }
            }
        }
        if (this.zzars != null) {
            zzabw.zza(4, this.zzars.booleanValue());
        }
        if (this.zzart != null) {
            zzabw.zza(5, this.zzart);
        }
        super.zza(zzabw);
        AppMethodBeat.o(69654);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69656);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69656);
                    break;
                case 8:
                    this.zzarp = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 18:
                    this.zzarq = zzabv.readString();
                    continue;
                case 26:
                    int zzb = zzach.zzb(zzabv, 26);
                    zzuw = this.zzarr == null ? 0 : this.zzarr.length;
                    zzkf[] zzkfArr = new zzkf[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzarr, 0, zzkfArr, 0, zzuw);
                    }
                    while (zzuw < zzkfArr.length - 1) {
                        zzkfArr[zzuw] = new zzkf();
                        zzabv.zza(zzkfArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkfArr[zzuw] = new zzkf();
                    zzabv.zza(zzkfArr[zzuw]);
                    this.zzarr = zzkfArr;
                    continue;
                case 32:
                    this.zzars = Boolean.valueOf(zzabv.zzux());
                    continue;
                case 42:
                    if (this.zzart == null) {
                        this.zzart = new zzkg();
                    }
                    zzabv.zza(this.zzart);
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69656);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
