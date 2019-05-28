package com.tencent.p177mm.plugin.appbrand.game.p895g;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart;", "", "()V", "prepare_restart", "", "selfRestart", "suicide", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.g.a */
public final class C38229a {
    public static final C38229a huo = new C38229a();

    static {
        AppMethodBeat.m2504i(134638);
        AppMethodBeat.m2505o(134638);
    }

    private C38229a() {
    }

    public static void aBH() {
        AppMethodBeat.m2504i(134636);
        Object systemService = C4996ah.getContext().getSystemService("activity");
        if (systemService == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.m2505o(134636);
            throw c44941v;
        }
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        C25052j.m39375o(runningAppProcesses, "am.runningAppProcesses");
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            String str = runningAppProcessInfo.processName;
            C25052j.m39375o(str, "it.processName");
            if (C31820v.m51526a((CharSequence) str, (CharSequence) "com.tencent.mm:", false)) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(134636);
    }

    public static void aBI() {
        AppMethodBeat.m2504i(134637);
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "context");
        PendingIntent activity = PendingIntent.getActivity(context, -1, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            C25052j.dWJ();
        }
        alarmManager.set(1, System.currentTimeMillis() + 100, activity);
        AppMethodBeat.m2505o(134637);
    }
}
