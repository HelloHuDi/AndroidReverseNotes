package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveServiceInTools;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.e.l;
import java.util.List;

final class c extends j {
    c() {
        super(AppBrandInToolsUI.class, null, d.Qb() ? null : AppBrandKeepAliveServiceInTools.class);
        AppMethodBeat.i(132779);
        AppMethodBeat.o(132779);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(g gVar) {
        return gVar != g.WAGAME;
    }

    /* Access modifiers changed, original: final */
    public final void aLJ() {
        AppMethodBeat.i(132780);
        ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
        if (activityManager == null) {
            AppMethodBeat.o(132780);
            return;
        }
        List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(132780);
            return;
        }
        Intent intent;
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if ((ah.getPackageName() + ":toolsmp").equals(runningAppProcessInfo.processName)) {
                if (runningAppProcessInfo.importance == 100) {
                    AppMethodBeat.o(132780);
                    return;
                }
                intent = new Intent();
                intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                ah.getContext().sendBroadcast(intent);
                AppMethodBeat.o(132780);
            }
        }
        intent = new Intent();
        intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(132780);
    }
}
