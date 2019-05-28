package com.tencent.p177mm.p1638bs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.bs.a */
public final class C45273a {
    /* renamed from: fW */
    private static Map<String, Integer> m83445fW(Context context) {
        AppMethodBeat.m2504i(79960);
        HashMap hashMap = new HashMap();
        if (context != null) {
            try {
                for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    hashMap.put(runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ProcessOperator", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(79960);
        return hashMap;
    }

    /* renamed from: f */
    public static boolean m83444f(Context context, String... strArr) {
        AppMethodBeat.m2504i(79961);
        if (context == null) {
            AppMethodBeat.m2505o(79961);
            return false;
        }
        Map fW = C45273a.m83445fW(context);
        for (int i = 0; i < 9; i++) {
            Integer num = (Integer) fW.get(strArr[i]);
            if (num != null) {
                C4990ab.m7417i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", num, r5);
                Process.killProcess(num.intValue());
            }
        }
        AppMethodBeat.m2505o(79961);
        return true;
    }

    /* renamed from: jB */
    public static void m83446jB(Context context) {
        AppMethodBeat.m2504i(139139);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
        Process.killProcess(myPid);
        AppMethodBeat.m2505o(139139);
    }
}
