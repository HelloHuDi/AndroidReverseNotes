package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzww extends zzws<Long> {
    zzww(zzxc zzxc, String str, Long l) {
        super(zzxc, str, l, null);
    }

    private final Long zzez(String str) {
        AppMethodBeat.m2504i(69764);
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            AppMethodBeat.m2505o(69764);
            return valueOf;
        } catch (NumberFormatException e) {
            String str2 = this.zzbnh;
            new StringBuilder((String.valueOf(str2).length() + 25) + String.valueOf(str).length()).append("Invalid long value for ").append(str2).append(": ").append(str);
            AppMethodBeat.m2505o(69764);
            return null;
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object zzey(String str) {
        AppMethodBeat.m2504i(69765);
        Long zzez = zzez(str);
        AppMethodBeat.m2505o(69765);
        return zzez;
    }
}
