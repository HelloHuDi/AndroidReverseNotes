package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjz {
    final String name;
    final String origin;
    final Object value;
    final long zzaqz;
    final String zzti;

    zzjz(String str, String str2, String str3, long j, Object obj) {
        AppMethodBeat.m2504i(69497);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.zzti = str;
        this.origin = str2;
        this.name = str3;
        this.zzaqz = j;
        this.value = obj;
        AppMethodBeat.m2505o(69497);
    }
}
