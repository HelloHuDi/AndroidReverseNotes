package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable.StringFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze implements StringFilter {
    zze() {
    }

    public final boolean matches(String str, String str2) {
        AppMethodBeat.m2504i(61202);
        if (!str.startsWith(str2)) {
            String str3 = " ";
            String valueOf = String.valueOf(str2);
            if (!str.contains(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3))) {
                AppMethodBeat.m2505o(61202);
                return false;
            }
        }
        AppMethodBeat.m2505o(61202);
        return true;
    }
}
