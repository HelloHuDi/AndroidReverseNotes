package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf extends GservicesValue<String> {
    zzf(String str, String str2) {
        super(str, str2);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieve(String str) {
        AppMethodBeat.i(89552);
        String string = GservicesValue.zzmu.getString(this.mKey, (String) this.mDefaultValue);
        AppMethodBeat.o(89552);
        return string;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        AppMethodBeat.i(89551);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, (String) obj);
        AppMethodBeat.o(89551);
        return string;
    }
}
