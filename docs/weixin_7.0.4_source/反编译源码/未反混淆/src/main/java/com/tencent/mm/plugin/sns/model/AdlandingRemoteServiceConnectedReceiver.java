package com.tencent.mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AdlandingRemoteServiceConnectedReceiver extends BroadcastReceiver {
    private Runnable fZM;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(36097);
        if (!(intent == null || !"com.tencnet.mm.action.adlanding.connected".equals(intent.getAction()) || this.fZM == null)) {
            this.fZM.run();
        }
        AppMethodBeat.o(36097);
    }

    public static void b(d dVar) {
        AppMethodBeat.i(36098);
        dVar.c(new Intent("com.tencnet.mm.action.adlanding.connected"));
        AppMethodBeat.o(36098);
    }
}
