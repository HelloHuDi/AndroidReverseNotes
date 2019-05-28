package com.bumptech.glide.manager;

import android.content.Context;
import android.support.v4.content.b;
import android.util.Log;
import com.bumptech.glide.manager.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f implements d {
    public final c a(Context context, a aVar) {
        AppMethodBeat.i(92383);
        Object obj = b.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null;
        Log.isLoggable("ConnectivityMonitor", 3);
        if (obj != null) {
            e eVar = new e(context, aVar);
            AppMethodBeat.o(92383);
            return eVar;
        }
        c jVar = new j();
        AppMethodBeat.o(92383);
        return jVar;
    }
}
