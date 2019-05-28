package com.tencent.p177mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.platformtools.o */
public final class C40618o {
    private static BroadcastReceiver broadcastReceiver = null;
    private static int xyj = 0;
    private static int xyk = -1;
    private static C30295b xyl = new C40617a();

    /* renamed from: com.tencent.mm.sdk.platformtools.o$b */
    public interface C30295b {
        /* renamed from: go */
        boolean mo48499go(Context context);
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.o$a */
    static class C40617a implements C30295b {
        Field xym = null;

        C40617a() {
            AppMethodBeat.m2504i(51992);
            if (VERSION.SDK_INT >= 21) {
                try {
                    if (this.xym == null) {
                        Field declaredField = RunningAppProcessInfo.class.getDeclaredField("processState");
                        declaredField.setAccessible(true);
                        this.xym = declaredField;
                    }
                    AppMethodBeat.m2505o(51992);
                    return;
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(51992);
        }

        /* renamed from: go */
        public final boolean mo48499go(Context context) {
            AppMethodBeat.m2504i(51993);
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                AppMethodBeat.m2505o(51993);
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                    int i;
                    if (VERSION.SDK_INT >= 21 && this.xym != null) {
                        try {
                            C4990ab.m7417i("MicroMsg.GreenManUtil", "isAppForeground processState %s", Integer.valueOf(this.xym.getInt(runningAppProcessInfo)));
                            if (this.xym.getInt(runningAppProcessInfo) <= 2) {
                                AppMethodBeat.m2505o(51993);
                                return true;
                            }
                            i = 0;
                            if (i != 0 && runningAppProcessInfo.importance == 100) {
                                AppMethodBeat.m2505o(51993);
                                return true;
                            }
                        } catch (Throwable th) {
                            C4990ab.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                        }
                    }
                    i = 1;
                    AppMethodBeat.m2505o(51993);
                    return true;
                }
            }
            AppMethodBeat.m2505o(51993);
            return false;
        }
    }

    /* renamed from: gl */
    public static boolean m70062gl(Context context) {
        AppMethodBeat.m2504i(51994);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean isInteractive;
            if (VERSION.SDK_INT >= 20) {
                isInteractive = powerManager.isInteractive();
                AppMethodBeat.m2505o(51994);
                return isInteractive;
            }
            isInteractive = powerManager.isScreenOn();
            AppMethodBeat.m2505o(51994);
            return isInteractive;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(51994);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(52000);
        AppMethodBeat.m2505o(52000);
    }

    /* renamed from: eA */
    public static boolean m70061eA(Context context) {
        AppMethodBeat.m2504i(51995);
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.m2505o(51995);
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                AppMethodBeat.m2505o(51995);
                return true;
            }
        }
        AppMethodBeat.m2505o(51995);
        return false;
    }

    /* renamed from: a */
    public static int m70059a(RunningAppProcessInfo runningAppProcessInfo) {
        AppMethodBeat.m2504i(51996);
        if (xyl instanceof C40617a) {
            Field field = ((C40617a) xyl).xym;
            if (VERSION.SDK_INT >= 21 && field != null) {
                try {
                    int i = field.getInt(runningAppProcessInfo);
                    AppMethodBeat.m2505o(51996);
                    return i;
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(51996);
            return -1;
        }
        AppMethodBeat.m2505o(51996);
        return -1;
    }

    /* renamed from: gm */
    public static void m70063gm(Context context) {
        AppMethodBeat.m2504i(51997);
        List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(10);
        if (runningServices == null) {
            AppMethodBeat.m2505o(51997);
            return;
        }
        for (RunningServiceInfo runningServiceInfo : runningServices) {
            C4990ab.m7417i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", runningServiceInfo.service, Boolean.valueOf(runningServiceInfo.foreground), Long.valueOf(runningServiceInfo.activeSince));
        }
        AppMethodBeat.m2505o(51997);
    }

    /* renamed from: gn */
    public static boolean m70064gn(Context context) {
        AppMethodBeat.m2504i(51998);
        boolean go = xyl.mo48499go(context);
        AppMethodBeat.m2505o(51998);
        return go;
    }

    /* renamed from: cc */
    public static String m70060cc(Context context) {
        AppMethodBeat.m2504i(51999);
        String str;
        if (C40618o.m70061eA(context)) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (VERSION.SDK_INT >= 23) {
                    List appTasks = activityManager.getAppTasks();
                    if (appTasks == null || appTasks.size() <= 0) {
                        str = "";
                        AppMethodBeat.m2505o(51999);
                        return str;
                    }
                    Iterator it = appTasks.iterator();
                    if (it.hasNext()) {
                        ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                        if (componentName == null) {
                            AppMethodBeat.m2505o(51999);
                            return null;
                        }
                        str = componentName.getClassName();
                        AppMethodBeat.m2505o(51999);
                        return str;
                    }
                    str = "";
                    AppMethodBeat.m2505o(51999);
                    return str;
                }
                str = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
                AppMethodBeat.m2505o(51999);
                return str;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", e.getMessage(), C5046bo.m7574l(e));
            }
        } else {
            str = "";
            AppMethodBeat.m2505o(51999);
            return str;
        }
    }
}
