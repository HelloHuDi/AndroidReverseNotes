package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable.StringFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc implements StringFilter {
    zzc() {
    }

    public final boolean matches(String str, String str2) {
        AppMethodBeat.i(61200);
        boolean contains = str.contains(str2);
        AppMethodBeat.o(61200);
        return contains;
    }
}
