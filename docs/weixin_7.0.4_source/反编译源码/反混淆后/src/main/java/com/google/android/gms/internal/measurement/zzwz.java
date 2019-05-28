package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwz extends zzws<Double> {
    zzwz(zzxc zzxc, String str, Double d) {
        super(zzxc, str, d, null);
    }

    private final Double zzfb(String str) {
        AppMethodBeat.m2504i(69769);
        try {
            Double valueOf = Double.valueOf(Double.parseDouble(str));
            AppMethodBeat.m2505o(69769);
            return valueOf;
        } catch (NumberFormatException e) {
            String str2 = this.zzbnh;
            new StringBuilder((String.valueOf(str2).length() + 27) + String.valueOf(str).length()).append("Invalid double value for ").append(str2).append(": ").append(str);
            AppMethodBeat.m2505o(69769);
            return null;
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object zzey(String str) {
        AppMethodBeat.m2504i(69770);
        Double zzfb = zzfb(str);
        AppMethodBeat.m2505o(69770);
        return zzfb;
    }
}
