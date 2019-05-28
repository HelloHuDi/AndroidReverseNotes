package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc extends GservicesValue<Integer> {
    zzc(String str, Integer num) {
        super(str, num);
    }

    private static Integer zza(Context context, String str, Integer num) {
        AppMethodBeat.m2504i(89542);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                num = Integer.valueOf(Integer.parseInt(string));
                AppMethodBeat.m2505o(89542);
            } catch (NumberFormatException e) {
            }
            return num;
        }
        AppMethodBeat.m2505o(89542);
        return num;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieve(String str) {
        AppMethodBeat.m2504i(89544);
        Integer zza = GservicesValue.zzmu.zza(this.mKey, (Integer) this.mDefaultValue);
        AppMethodBeat.m2505o(89544);
        return zza;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        AppMethodBeat.m2504i(89543);
        Integer zza = zza(context, str, (Integer) obj);
        AppMethodBeat.m2505o(89543);
        return zza;
    }
}
