package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze extends GservicesValue<Float> {
    zze(String str, Float f) {
        super(str, f);
    }

    private static Float zza(Context context, String str, Float f) {
        AppMethodBeat.i(89548);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                f = Float.valueOf(Float.parseFloat(string));
                AppMethodBeat.o(89548);
            } catch (NumberFormatException e) {
            }
            return f;
        }
        AppMethodBeat.o(89548);
        return f;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieve(String str) {
        AppMethodBeat.i(89550);
        Float zza = GservicesValue.zzmu.zza(this.mKey, (Float) this.mDefaultValue);
        AppMethodBeat.o(89550);
        return zza;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        AppMethodBeat.i(89549);
        Float zza = zza(context, str, (Float) obj);
        AppMethodBeat.o(89549);
        return zza;
    }
}
