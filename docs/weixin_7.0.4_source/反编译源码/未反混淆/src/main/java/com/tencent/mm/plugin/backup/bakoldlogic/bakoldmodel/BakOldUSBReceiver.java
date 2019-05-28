package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class BakOldUSBReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(17754);
        try {
            String action = intent.getAction();
            if ("MMBakchatServiceStart".equalsIgnoreCase(action)) {
                d.aH(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", intent.getStringExtra("url")));
                ab.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
                AppMethodBeat.o(17754);
                return;
            }
            if ("MMBakchatServiceStop".equalsIgnoreCase(action)) {
                com.tencent.mm.g.a.ab abVar = new com.tencent.mm.g.a.ab();
                abVar.csW.csX = context;
                a.xxA.m(abVar);
                ab.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
            }
            AppMethodBeat.o(17754);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BakOldUSBReceiver", e, "onReceive:", new Object[0]);
            AppMethodBeat.o(17754);
        }
    }
}
