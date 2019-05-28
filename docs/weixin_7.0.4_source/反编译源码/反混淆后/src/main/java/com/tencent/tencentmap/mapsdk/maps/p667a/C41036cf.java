package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cf */
final class C41036cf extends BroadcastReceiver {
    C41036cf() {
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(98633);
        C46772bt.m88746j().post(new C46774cg(this));
        AppMethodBeat.m2505o(98633);
    }
}
