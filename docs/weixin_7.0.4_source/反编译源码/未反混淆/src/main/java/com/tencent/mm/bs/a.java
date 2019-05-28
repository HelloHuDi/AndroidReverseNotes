package com.tencent.mm.bs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Integer> fW(Context context) {
        AppMethodBeat.i(79960);
        HashMap hashMap = new HashMap();
        if (context != null) {
            try {
                for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    hashMap.put(runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ProcessOperator", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(79960);
        return hashMap;
    }

    public static boolean f(Context context, String... strArr) {
        AppMethodBeat.i(79961);
        if (context == null) {
            AppMethodBeat.o(79961);
            return false;
        }
        Map fW = fW(context);
        for (int i = 0; i < 9; i++) {
            Integer num = (Integer) fW.get(strArr[i]);
            if (num != null) {
                ab.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", num, r5);
                Process.killProcess(num.intValue());
            }
        }
        AppMethodBeat.o(79961);
        return true;
    }

    public static void jB(Context context) {
        AppMethodBeat.i(139139);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
        Process.killProcess(myPid);
        AppMethodBeat.o(139139);
    }
}
