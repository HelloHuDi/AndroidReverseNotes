package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaap<T> implements zzaav<T> {
    private final zzaal zzbtk;
    private final zzabj<?, ?> zzbtl;
    private final boolean zzbtm;
    private final zzzj<?> zzbtn;

    private zzaap(zzabj<?, ?> zzabj, zzzj<?> zzzj, zzaal zzaal) {
        AppMethodBeat.m2504i(3348);
        this.zzbtl = zzabj;
        this.zzbtm = zzzj.zza(zzaal);
        this.zzbtn = zzzj;
        this.zzbtk = zzaal;
        AppMethodBeat.m2505o(3348);
    }

    static <T> zzaap<T> zza(zzabj<?, ?> zzabj, zzzj<?> zzzj, zzaal zzaal) {
        AppMethodBeat.m2504i(3349);
        zzaap zzaap = new zzaap(zzabj, zzzj, zzaal);
        AppMethodBeat.m2505o(3349);
        return zzaap;
    }

    public final boolean equals(T t, T t2) {
        AppMethodBeat.m2504i(3350);
        if (!this.zzbtl.zzu(t).equals(this.zzbtl.zzu(t2))) {
            AppMethodBeat.m2505o(3350);
            return false;
        } else if (this.zzbtm) {
            boolean equals = this.zzbtn.zzs(t).equals(this.zzbtn.zzs(t2));
            AppMethodBeat.m2505o(3350);
            return equals;
        } else {
            AppMethodBeat.m2505o(3350);
            return true;
        }
    }

    public final int hashCode(T t) {
        AppMethodBeat.m2504i(3351);
        int hashCode = this.zzbtl.zzu(t).hashCode();
        if (this.zzbtm) {
            hashCode = (hashCode * 53) + this.zzbtn.zzs(t).hashCode();
        }
        AppMethodBeat.m2505o(3351);
        return hashCode;
    }
}
