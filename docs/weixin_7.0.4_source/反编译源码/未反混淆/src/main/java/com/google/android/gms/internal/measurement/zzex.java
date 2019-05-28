package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zzex<V> {
    private final zzws<V> zzaid;
    private final String zzny;

    private zzex(String str, zzws<V> zzws) {
        AppMethodBeat.i(68751);
        Preconditions.checkNotNull(zzws);
        this.zzaid = zzws;
        this.zzny = str;
        AppMethodBeat.o(68751);
    }

    static zzex<Double> zza(String str, double d, double d2) {
        AppMethodBeat.i(68756);
        zzex zzex = new zzex(str, zzew.zzagc.zzb(str, -3.0d));
        AppMethodBeat.o(68756);
        return zzex;
    }

    static zzex<Long> zzb(String str, long j, long j2) {
        AppMethodBeat.i(68754);
        zzex zzex = new zzex(str, zzew.zzagc.zze(str, j));
        AppMethodBeat.o(68754);
        return zzex;
    }

    static zzex<Boolean> zzb(String str, boolean z, boolean z2) {
        AppMethodBeat.i(68752);
        zzex zzex = new zzex(str, zzew.zzagc.zzf(str, z));
        AppMethodBeat.o(68752);
        return zzex;
    }

    static zzex<Integer> zzc(String str, int i, int i2) {
        AppMethodBeat.i(68755);
        zzex zzex = new zzex(str, zzew.zzagc.zzd(str, i));
        AppMethodBeat.o(68755);
        return zzex;
    }

    static zzex<String> zzd(String str, String str2, String str3) {
        AppMethodBeat.i(68753);
        zzex zzex = new zzex(str, zzew.zzagc.zzv(str, str2));
        AppMethodBeat.o(68753);
        return zzex;
    }

    public final V get() {
        AppMethodBeat.i(68757);
        Object obj = this.zzaid.get();
        AppMethodBeat.o(68757);
        return obj;
    }

    public final V get(V v) {
        AppMethodBeat.i(68758);
        if (v != null) {
            AppMethodBeat.o(68758);
            return v;
        }
        Object obj = this.zzaid.get();
        AppMethodBeat.o(68758);
        return obj;
    }

    public final String getKey() {
        return this.zzny;
    }
}
