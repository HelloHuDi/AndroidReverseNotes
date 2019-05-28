package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzeq {
    final String name;
    final long zzafr;
    final long zzafs;
    final long zzaft;
    final long zzafu;
    final Long zzafv;
    final Long zzafw;
    final Boolean zzafx;
    final String zzti;

    zzeq(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        AppMethodBeat.i(68725);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j4 >= 0);
        this.zzti = str;
        this.name = str2;
        this.zzafr = j;
        this.zzafs = j2;
        this.zzaft = j3;
        this.zzafu = j4;
        this.zzafv = l;
        this.zzafw = l2;
        this.zzafx = bool;
        AppMethodBeat.o(68725);
    }

    /* Access modifiers changed, original: final */
    public final zzeq zza(Long l, Long l2, Boolean bool) {
        AppMethodBeat.i(68729);
        Boolean bool2 = (bool == null || bool.booleanValue()) ? bool : null;
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, this.zzafu, l, l2, bool2);
        AppMethodBeat.o(68729);
        return zzeq;
    }

    /* Access modifiers changed, original: final */
    public final zzeq zzac(long j) {
        AppMethodBeat.i(68727);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, j, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
        AppMethodBeat.o(68727);
        return zzeq;
    }

    /* Access modifiers changed, original: final */
    public final zzeq zzad(long j) {
        AppMethodBeat.i(68728);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, j, this.zzafv, this.zzafw, this.zzafx);
        AppMethodBeat.o(68728);
        return zzeq;
    }

    /* Access modifiers changed, original: final */
    public final zzeq zzie() {
        AppMethodBeat.i(68726);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr + 1, this.zzafs + 1, this.zzaft, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
        AppMethodBeat.o(68726);
        return zzeq;
    }
}
