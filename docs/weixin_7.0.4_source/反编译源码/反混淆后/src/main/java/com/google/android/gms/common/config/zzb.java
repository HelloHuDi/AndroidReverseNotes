package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends GservicesValue<Long> {
    zzb(String str, Long l) {
        super(str, l);
    }

    private static Long zza(Context context, String str, Long l) {
        AppMethodBeat.m2504i(89539);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                l = Long.valueOf(Long.parseLong(string));
                AppMethodBeat.m2505o(89539);
            } catch (NumberFormatException e) {
            }
            return l;
        }
        AppMethodBeat.m2505o(89539);
        return l;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieve(String str) {
        AppMethodBeat.m2504i(89541);
        Long l = GservicesValue.zzmu.getLong(this.mKey, (Long) this.mDefaultValue);
        AppMethodBeat.m2505o(89541);
        return l;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        AppMethodBeat.m2504i(89540);
        Long zza = zza(context, str, (Long) obj);
        AppMethodBeat.m2505o(89540);
        return zza;
    }
}
