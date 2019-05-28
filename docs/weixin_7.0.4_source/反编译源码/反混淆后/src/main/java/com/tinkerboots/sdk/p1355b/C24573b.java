package com.tinkerboots.sdk.p1355b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tinkerboots.sdk.b.b */
public final class C24573b {
    /* renamed from: jG */
    public static boolean m38229jG(Context context) {
        AppMethodBeat.m2504i(65554);
        if (VERSION.SDK_INT < 23) {
            AppMethodBeat.m2505o(65554);
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
            AppMethodBeat.m2505o(65554);
            return true;
        }
        AppMethodBeat.m2505o(65554);
        return false;
    }
}
