package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkn extends zzaby<zzkn> {
    private static volatile zzkn[] zzasz;
    public Integer count;
    public String name;
    public zzko[] zzata;
    public Long zzatb;
    public Long zzatc;

    public zzkn() {
        AppMethodBeat.m2504i(69707);
        this.zzata = zzko.zzlm();
        this.name = null;
        this.zzatb = null;
        this.zzatc = null;
        this.count = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.m2505o(69707);
    }

    public static zzkn[] zzll() {
        if (zzasz == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasz == null) {
                    zzasz = new zzkn[0];
                }
            }
        }
        return zzasz;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(69708);
        if (obj == this) {
            AppMethodBeat.m2505o(69708);
            return true;
        } else if (obj instanceof zzkn) {
            zzkn zzkn = (zzkn) obj;
            if (zzacc.equals(this.zzata, zzkn.zzata)) {
                if (this.name == null) {
                    if (zzkn.name != null) {
                        AppMethodBeat.m2505o(69708);
                        return false;
                    }
                } else if (!this.name.equals(zzkn.name)) {
                    AppMethodBeat.m2505o(69708);
                    return false;
                }
                if (this.zzatb == null) {
                    if (zzkn.zzatb != null) {
                        AppMethodBeat.m2505o(69708);
                        return false;
                    }
                } else if (!this.zzatb.equals(zzkn.zzatb)) {
                    AppMethodBeat.m2505o(69708);
                    return false;
                }
                if (this.zzatc == null) {
                    if (zzkn.zzatc != null) {
                        AppMethodBeat.m2505o(69708);
                        return false;
                    }
                } else if (!this.zzatc.equals(zzkn.zzatc)) {
                    AppMethodBeat.m2505o(69708);
                    return false;
                }
                if (this.count == null) {
                    if (zzkn.count != null) {
                        AppMethodBeat.m2505o(69708);
                        return false;
                    }
                } else if (!this.count.equals(zzkn.count)) {
                    AppMethodBeat.m2505o(69708);
                    return false;
                }
                if (this.zzbww != null && !this.zzbww.isEmpty()) {
                    boolean equals = this.zzbww.equals(zzkn.zzbww);
                    AppMethodBeat.m2505o(69708);
                    return equals;
                } else if (zzkn.zzbww == null || zzkn.zzbww.isEmpty()) {
                    AppMethodBeat.m2505o(69708);
                    return true;
                } else {
                    AppMethodBeat.m2505o(69708);
                    return false;
                }
            }
            AppMethodBeat.m2505o(69708);
            return false;
        } else {
            AppMethodBeat.m2505o(69708);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(69709);
        int hashCode = ((this.count == null ? 0 : this.count.hashCode()) + (((this.zzatc == null ? 0 : this.zzatc.hashCode()) + (((this.zzatb == null ? 0 : this.zzatb.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzacc.hashCode(this.zzata)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(69709);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        AppMethodBeat.m2504i(69711);
        int zza = super.zza();
        if (this.zzata != null && this.zzata.length > 0) {
            for (zzace zzace : this.zzata) {
                if (zzace != null) {
                    zza += zzabw.zzb(1, zzace);
                }
            }
        }
        if (this.name != null) {
            zza += zzabw.zzc(2, this.name);
        }
        if (this.zzatb != null) {
            zza += zzabw.zzc(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zza += zzabw.zzc(4, this.zzatc.longValue());
        }
        if (this.count != null) {
            zza += zzabw.zzf(5, this.count.intValue());
        }
        AppMethodBeat.m2505o(69711);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        AppMethodBeat.m2504i(69710);
        if (this.zzata != null && this.zzata.length > 0) {
            for (zzace zzace : this.zzata) {
                if (zzace != null) {
                    zzabw.zza(1, zzace);
                }
            }
        }
        if (this.name != null) {
            zzabw.zzb(2, this.name);
        }
        if (this.zzatb != null) {
            zzabw.zzb(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zzabw.zzb(4, this.zzatc.longValue());
        }
        if (this.count != null) {
            zzabw.zze(5, this.count.intValue());
        }
        super.zza(zzabw);
        AppMethodBeat.m2505o(69710);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.m2504i(69712);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.m2505o(69712);
                    break;
                case 10:
                    int zzb = zzach.zzb(zzabv, 10);
                    zzuw = this.zzata == null ? 0 : this.zzata.length;
                    zzko[] zzkoArr = new zzko[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzata, 0, zzkoArr, 0, zzuw);
                    }
                    while (zzuw < zzkoArr.length - 1) {
                        zzkoArr[zzuw] = new zzko();
                        zzabv.zza(zzkoArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkoArr[zzuw] = new zzko();
                    zzabv.zza(zzkoArr[zzuw]);
                    this.zzata = zzkoArr;
                    continue;
                case 18:
                    this.name = zzabv.readString();
                    continue;
                case 24:
                    this.zzatb = Long.valueOf(zzabv.zzuz());
                    continue;
                case 32:
                    this.zzatc = Long.valueOf(zzabv.zzuz());
                    continue;
                case 40:
                    this.count = Integer.valueOf(zzabv.zzuy());
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.m2505o(69712);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
