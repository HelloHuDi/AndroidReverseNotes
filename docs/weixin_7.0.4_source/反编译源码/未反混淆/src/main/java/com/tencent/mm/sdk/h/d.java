package com.tencent.mm.sdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static boolean ha(Context context) {
        AppMethodBeat.i(65376);
        if (context == null) {
            AppMethodBeat.o(65376);
            return false;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        AppMethodBeat.o(65376);
        return hasSystemFeature;
    }
}
