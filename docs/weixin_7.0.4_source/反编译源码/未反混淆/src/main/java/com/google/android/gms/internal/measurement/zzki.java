package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzki extends zzaby<zzki> {
    public Integer zzash;
    public String zzasi;
    public Boolean zzasj;
    public String[] zzask;

    public zzki() {
        AppMethodBeat.i(69676);
        this.zzash = null;
        this.zzasi = null;
        this.zzasj = null;
        this.zzask = zzach.zzbxq;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(69676);
    }

    private final zzki zze(zzabv zzabv) {
        int position;
        AppMethodBeat.i(69681);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(69681);
                    break;
                case 8:
                    position = zzabv.getPosition();
                    try {
                        int zzuy = zzabv.zzuy();
                        if (zzuy < 0 || zzuy > 6) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(zzuy + " is not a valid enum MatchType");
                            AppMethodBeat.o(69681);
                            throw illegalArgumentException;
                        }
                        this.zzash = Integer.valueOf(zzuy);
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzabv.zzam(position);
                        zza(zzabv, zzuw);
                        break;
                    }
                    break;
                case 18:
                    this.zzasi = zzabv.readString();
                    continue;
                case 24:
                    this.zzasj = Boolean.valueOf(zzabv.zzux());
                    continue;
                case 34:
                    position = zzach.zzb(zzabv, 34);
                    zzuw = this.zzask == null ? 0 : this.zzask.length;
                    String[] strArr = new String[(position + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzask, 0, strArr, 0, zzuw);
                    }
                    while (zzuw < strArr.length - 1) {
                        strArr[zzuw] = zzabv.readString();
                        zzabv.zzuw();
                        zzuw++;
                    }
                    strArr[zzuw] = zzabv.readString();
                    this.zzask = strArr;
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.o(69681);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69677);
        if (obj == this) {
            AppMethodBeat.o(69677);
            return true;
        } else if (obj instanceof zzki) {
            zzki zzki = (zzki) obj;
            if (this.zzash == null) {
                if (zzki.zzash != null) {
                    AppMethodBeat.o(69677);
                    return false;
                }
            } else if (!this.zzash.equals(zzki.zzash)) {
                AppMethodBeat.o(69677);
                return false;
            }
            if (this.zzasi == null) {
                if (zzki.zzasi != null) {
                    AppMethodBeat.o(69677);
                    return false;
                }
            } else if (!this.zzasi.equals(zzki.zzasi)) {
                AppMethodBeat.o(69677);
                return false;
            }
            if (this.zzasj == null) {
                if (zzki.zzasj != null) {
                    AppMethodBeat.o(69677);
                    return false;
                }
            } else if (!this.zzasj.equals(zzki.zzasj)) {
                AppMethodBeat.o(69677);
                return false;
            }
            if (!zzacc.equals(this.zzask, zzki.zzask)) {
                AppMethodBeat.o(69677);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzki.zzbww);
                AppMethodBeat.o(69677);
                return equals;
            } else if (zzki.zzbww == null || zzki.zzbww.isEmpty()) {
                AppMethodBeat.o(69677);
                return true;
            } else {
                AppMethodBeat.o(69677);
                return false;
            }
        } else {
            AppMethodBeat.o(69677);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(69678);
        int hashCode = ((((this.zzasj == null ? 0 : this.zzasj.hashCode()) + (((this.zzasi == null ? 0 : this.zzasi.hashCode()) + (((this.zzash == null ? 0 : this.zzash.intValue()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzask)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(69678);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.i(69680);
        int zza = super.zza();
        if (this.zzash != null) {
            zza += zzabw.zzf(1, this.zzash.intValue());
        }
        if (this.zzasi != null) {
            zza += zzabw.zzc(2, this.zzasi);
        }
        if (this.zzasj != null) {
            this.zzasj.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzask != null && this.zzask.length > 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < this.zzask.length) {
                int zzfm;
                String str = this.zzask[i];
                if (str != null) {
                    i3++;
                    zzfm = zzabw.zzfm(str) + i2;
                } else {
                    zzfm = i2;
                }
                i++;
                i2 = zzfm;
            }
            zza = (zza + i2) + (i3 * 1);
        }
        AppMethodBeat.o(69680);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(69679);
        if (this.zzash != null) {
            zzabw.zze(1, this.zzash.intValue());
        }
        if (this.zzasi != null) {
            zzabw.zzb(2, this.zzasi);
        }
        if (this.zzasj != null) {
            zzabw.zza(3, this.zzasj.booleanValue());
        }
        if (this.zzask != null && this.zzask.length > 0) {
            for (String str : this.zzask) {
                if (str != null) {
                    zzabw.zzb(4, str);
                }
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(69679);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(69682);
        zzki zze = zze(zzabv);
        AppMethodBeat.o(69682);
        return zze;
    }
}
