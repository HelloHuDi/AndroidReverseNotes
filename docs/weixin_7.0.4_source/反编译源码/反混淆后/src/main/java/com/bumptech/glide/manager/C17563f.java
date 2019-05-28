package com.bumptech.glide.manager;

import android.content.Context;
import android.support.p057v4.content.C0380b;
import android.util.Log;
import com.bumptech.glide.manager.C31979c.C31980a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.manager.f */
public final class C17563f implements C37198d {
    /* renamed from: a */
    public final C31979c mo31994a(Context context, C31980a c31980a) {
        AppMethodBeat.m2504i(92383);
        Object obj = C0380b.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null;
        Log.isLoggable("ConnectivityMonitor", 3);
        if (obj != null) {
            C45003e c45003e = new C45003e(context, c31980a);
            AppMethodBeat.m2505o(92383);
            return c45003e;
        }
        C31979c c36678j = new C36678j();
        AppMethodBeat.m2505o(92383);
        return c36678j;
    }
}
