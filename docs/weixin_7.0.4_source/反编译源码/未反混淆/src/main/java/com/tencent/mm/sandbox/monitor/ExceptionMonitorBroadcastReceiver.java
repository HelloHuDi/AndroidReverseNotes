package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;

public class ExceptionMonitorBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(28786);
        intent.setClass(context, ExceptionMonitorService.class);
        d.j(intent, "sandbox");
        AppMethodBeat.o(28786);
    }
}
