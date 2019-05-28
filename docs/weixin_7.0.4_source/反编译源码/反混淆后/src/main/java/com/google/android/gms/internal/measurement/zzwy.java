package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwy extends zzws<Boolean> {
    zzwy(zzxc zzxc, String str, Boolean bool) {
        super(zzxc, str, bool, null);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object zzey(String str) {
        AppMethodBeat.m2504i(69768);
        Boolean bool;
        if (zzwn.zzbmi.matcher(str).matches()) {
            bool = Boolean.TRUE;
            AppMethodBeat.m2505o(69768);
            return bool;
        } else if (zzwn.zzbmj.matcher(str).matches()) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(69768);
            return bool;
        } else {
            String str2 = this.zzbnh;
            new StringBuilder((String.valueOf(str2).length() + 28) + String.valueOf(str).length()).append("Invalid boolean value for ").append(str2).append(": ").append(str);
            AppMethodBeat.m2505o(69768);
            return null;
        }
    }
}
