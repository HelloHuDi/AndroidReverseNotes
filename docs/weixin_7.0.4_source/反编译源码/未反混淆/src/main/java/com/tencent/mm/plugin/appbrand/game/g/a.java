package com.tencent.mm.plugin.appbrand.game.g;

import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart;", "", "()V", "prepare_restart", "", "selfRestart", "suicide", "plugin-appbrand-integration_release"})
public final class a {
    public static final a huo = new a();

    static {
        AppMethodBeat.i(134638);
        AppMethodBeat.o(134638);
    }

    private a() {
    }

    public static void aBH() {
        AppMethodBeat.i(134636);
        Object systemService = ah.getContext().getSystemService("activity");
        if (systemService == null) {
            v vVar = new v("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(134636);
            throw vVar;
        }
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        j.o(runningAppProcesses, "am.runningAppProcesses");
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            String str = runningAppProcessInfo.processName;
            j.o(str, "it.processName");
            if (a.k.v.a((CharSequence) str, (CharSequence) "com.tencent.mm:", false)) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(134636);
    }

    public static void aBI() {
        AppMethodBeat.i(134637);
        Context context = ah.getContext();
        j.o(context, "context");
        PendingIntent activity = PendingIntent.getActivity(context, -1, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            j.dWJ();
        }
        alarmManager.set(1, System.currentTimeMillis() + 100, activity);
        AppMethodBeat.o(134637);
    }
}
