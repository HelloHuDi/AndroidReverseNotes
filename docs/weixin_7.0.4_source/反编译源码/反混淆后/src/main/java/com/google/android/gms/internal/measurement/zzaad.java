package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaad implements zzaaw {
    private static final zzaak zzbte = new zzaae();
    private final zzaak zzbtd;

    static {
        AppMethodBeat.m2504i(3334);
        AppMethodBeat.m2505o(3334);
    }

    public zzaad() {
        this(new zzaaf(zzzp.zztl(), zzts()));
        AppMethodBeat.m2504i(3329);
        AppMethodBeat.m2505o(3329);
    }

    private zzaad(zzaak zzaak) {
        AppMethodBeat.m2504i(3330);
        this.zzbtd = (zzaak) zzzr.zza(zzaak, "messageInfoFactory");
        AppMethodBeat.m2505o(3330);
    }

    private static boolean zza(zzaaj zzaaj) {
        AppMethodBeat.m2504i(3332);
        if (zzaaj.zztw() == zzb.zzbsk) {
            AppMethodBeat.m2505o(3332);
            return true;
        }
        AppMethodBeat.m2505o(3332);
        return false;
    }

    private static zzaak zzts() {
        AppMethodBeat.m2504i(3333);
        zzaak zzaak;
        try {
            zzaak = (zzaak) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.m2505o(3333);
            return zzaak;
        } catch (Exception e) {
            zzaak = zzbte;
            AppMethodBeat.m2505o(3333);
            return zzaak;
        }
    }

    public final <T> zzaav<T> zzg(Class<T> cls) {
        AppMethodBeat.m2504i(3331);
        zzaax.zzh(cls);
        zzaaj zze = this.zzbtd.zze(cls);
        zzaao zza;
        if (zze.zztx()) {
            zzaap zza2;
            if (zzzq.class.isAssignableFrom(cls)) {
                zza2 = zzaap.zza(zzaax.zzug(), zzzl.zztg(), zze.zzty());
                AppMethodBeat.m2505o(3331);
                return zza2;
            }
            zza2 = zzaap.zza(zzaax.zzue(), zzzl.zzth(), zze.zzty());
            AppMethodBeat.m2505o(3331);
            return zza2;
        } else if (zzzq.class.isAssignableFrom(cls)) {
            if (zza(zze)) {
                zza = zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), zzzl.zztg(), zzaai.zztu());
                AppMethodBeat.m2505o(3331);
                return zza;
            }
            zza = zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), null, zzaai.zztu());
            AppMethodBeat.m2505o(3331);
            return zza;
        } else if (zza(zze)) {
            zza = zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzue(), zzzl.zzth(), zzaai.zztt());
            AppMethodBeat.m2505o(3331);
            return zza;
        } else {
            zza = zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzuf(), null, zzaai.zztt());
            AppMethodBeat.m2505o(3331);
            return zza;
        }
    }
}
