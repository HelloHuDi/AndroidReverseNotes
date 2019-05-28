package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd extends GservicesValue<Double> {
    zzd(String str, Double d) {
        super(str, d);
    }

    private static Double zza(Context context, String str, Double d) {
        AppMethodBeat.i(89545);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                d = Double.valueOf(Double.parseDouble(string));
                AppMethodBeat.o(89545);
            } catch (NumberFormatException e) {
            }
            return d;
        }
        AppMethodBeat.o(89545);
        return d;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieve(String str) {
        AppMethodBeat.i(89547);
        Double zza = GservicesValue.zzmu.zza(this.mKey, (Double) this.mDefaultValue);
        AppMethodBeat.o(89547);
        return zza;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        AppMethodBeat.i(89546);
        Double zza = zza(context, str, (Double) obj);
        AppMethodBeat.o(89546);
        return zza;
    }
}
