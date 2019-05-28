package com.tencent.mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.sdk.platformtools.ab;

public class AppBrandTaskPreloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(132873);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        intent.setExtrasClassLoader(AppBrandPreloadProfiler.class.getClassLoader());
        b.a(g.H(intent), (AppBrandPreloadProfiler) intent.getParcelableExtra("preloadProfiler"));
        ab.i("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile] Receiver cost [%d]ms, at [%d]", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Long.valueOf(elapsedRealtime));
        AppMethodBeat.o(132873);
    }
}
