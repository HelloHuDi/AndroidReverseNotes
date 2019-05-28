package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg extends GservicesValue<String> {
    zzg(String str, String str2) {
        super(str, str2);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieve(String str) {
        AppMethodBeat.m2504i(89554);
        String zzb = GservicesValue.zzmu.zzb(this.mKey, (String) this.mDefaultValue);
        AppMethodBeat.m2505o(89554);
        return zzb;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        AppMethodBeat.m2504i(89553);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, (String) obj);
        AppMethodBeat.m2505o(89553);
        return string;
    }
}
