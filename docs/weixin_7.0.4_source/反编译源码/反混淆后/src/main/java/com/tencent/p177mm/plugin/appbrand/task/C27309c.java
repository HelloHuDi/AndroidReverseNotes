package com.tencent.p177mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5510e.C5505l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveServiceInTools;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandInToolsUI;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.task.c */
final class C27309c extends C45695j {
    C27309c() {
        super(AppBrandInToolsUI.class, null, C25985d.m41450Qb() ? null : AppBrandKeepAliveServiceInTools.class);
        AppMethodBeat.m2504i(132779);
        AppMethodBeat.m2505o(132779);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo6386a(C38519g c38519g) {
        return c38519g != C38519g.WAGAME;
    }

    /* Access modifiers changed, original: final */
    public final void aLJ() {
        AppMethodBeat.m2504i(132780);
        ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
        if (activityManager == null) {
            AppMethodBeat.m2505o(132780);
            return;
        }
        List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.m2505o(132780);
            return;
        }
        Intent intent;
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if ((C4996ah.getPackageName() + ":toolsmp").equals(runningAppProcessInfo.processName)) {
                if (runningAppProcessInfo.importance == 100) {
                    AppMethodBeat.m2505o(132780);
                    return;
                }
                intent = new Intent();
                intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                C4996ah.getContext().sendBroadcast(intent);
                AppMethodBeat.m2505o(132780);
            }
        }
        intent = new Intent();
        intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(132780);
    }
}
