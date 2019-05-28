package com.tencent.p177mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C19015b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver */
public class AppBrandTaskPreloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(132873);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        intent.setExtrasClassLoader(AppBrandPreloadProfiler.class.getClassLoader());
        C19015b.m29592a(C38519g.m65220H(intent), (AppBrandPreloadProfiler) intent.getParcelableExtra("preloadProfiler"));
        C4990ab.m7417i("MicroMsg.AppBrandTaskPreloadReceiver", "[PreloadProfile] Receiver cost [%d]ms, at [%d]", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Long.valueOf(elapsedRealtime));
        AppMethodBeat.m2505o(132873);
    }
}
