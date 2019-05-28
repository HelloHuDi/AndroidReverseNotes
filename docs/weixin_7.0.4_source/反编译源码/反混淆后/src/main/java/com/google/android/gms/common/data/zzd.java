package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable.StringFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd implements StringFilter {
    zzd() {
    }

    public final boolean matches(String str, String str2) {
        AppMethodBeat.m2504i(61201);
        boolean startsWith = str.startsWith(str2);
        AppMethodBeat.m2505o(61201);
        return startsWith;
    }
}
