package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class e {
    public static void aL(Intent intent) {
        AppMethodBeat.i(93387);
        if (d.iW(26)) {
            intent.setPackage(ah.getPackageName());
        }
        AppMethodBeat.o(93387);
    }
}
