package com.tencent.p177mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;

/* renamed from: com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver */
public class ExceptionMonitorBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(28786);
        intent.setClass(context, ExceptionMonitorService.class);
        C25985d.m41477j(intent, "sandbox");
        AppMethodBeat.m2505o(28786);
    }
}
