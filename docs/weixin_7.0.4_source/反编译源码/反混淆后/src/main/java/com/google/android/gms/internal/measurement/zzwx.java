package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwx extends zzws<Integer> {
    zzwx(zzxc zzxc, String str, Integer num) {
        super(zzxc, str, num, null);
    }

    private final Integer zzfa(String str) {
        AppMethodBeat.m2504i(69766);
        try {
            Integer valueOf = Integer.valueOf(Integer.parseInt(str));
            AppMethodBeat.m2505o(69766);
            return valueOf;
        } catch (NumberFormatException e) {
            String str2 = this.zzbnh;
            new StringBuilder((String.valueOf(str2).length() + 28) + String.valueOf(str).length()).append("Invalid integer value for ").append(str2).append(": ").append(str);
            AppMethodBeat.m2505o(69766);
            return null;
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object zzey(String str) {
        AppMethodBeat.m2504i(69767);
        Integer zzfa = zzfa(str);
        AppMethodBeat.m2505o(69767);
        return zzfa;
    }
}
