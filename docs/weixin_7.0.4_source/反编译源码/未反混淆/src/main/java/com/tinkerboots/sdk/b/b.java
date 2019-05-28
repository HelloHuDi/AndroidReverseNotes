package com.tinkerboots.sdk.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean jG(Context context) {
        AppMethodBeat.i(65554);
        if (VERSION.SDK_INT < 23) {
            AppMethodBeat.o(65554);
            return true;
        }
        boolean z = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        boolean z2;
        if (context.checkSelfPermission("android.permission.INTERNET") == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            AppMethodBeat.o(65554);
            return true;
        }
        AppMethodBeat.o(65554);
        return false;
    }
}
