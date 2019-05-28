package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class cf extends BroadcastReceiver {
    cf() {
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(98633);
        bt.j().post(new cg(this));
        AppMethodBeat.o(98633);
    }
}
