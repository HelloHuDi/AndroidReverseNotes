package com.tencent.mm.sdk.platformtools;

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

public final class o {
    private static BroadcastReceiver broadcastReceiver = null;
    private static int xyj = 0;
    private static int xyk = -1;
    private static b xyl = new a();

    public interface b {
        boolean go(Context context);
    }

    static class a implements b {
        Field xym = null;

        a() {
            AppMethodBeat.i(51992);
            if (VERSION.SDK_INT >= 21) {
                try {
                    if (this.xym == null) {
                        Field declaredField = RunningAppProcessInfo.class.getDeclaredField("processState");
                        declaredField.setAccessible(true);
                        this.xym = declaredField;
                    }
                    AppMethodBeat.o(51992);
                    return;
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                }
            }
            AppMethodBeat.o(51992);
        }

        public final boolean go(Context context) {
            AppMethodBeat.i(51993);
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                AppMethodBeat.o(51993);
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                    int i;
                    if (VERSION.SDK_INT >= 21 && this.xym != null) {
                        try {
                            ab.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", Integer.valueOf(this.xym.getInt(runningAppProcessInfo)));
                            if (this.xym.getInt(runningAppProcessInfo) <= 2) {
                                AppMethodBeat.o(51993);
                                return true;
                            }
                            i = 0;
                            if (i != 0 && runningAppProcessInfo.importance == 100) {
                                AppMethodBeat.o(51993);
                                return true;
                            }
                        } catch (Throwable th) {
                            ab.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                        }
                    }
                    i = 1;
                    AppMethodBeat.o(51993);
                    return true;
                }
            }
            AppMethodBeat.o(51993);
            return false;
        }
    }

    public static boolean gl(Context context) {
        AppMethodBeat.i(51994);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean isInteractive;
            if (VERSION.SDK_INT >= 20) {
                isInteractive = powerManager.isInteractive();
                AppMethodBeat.o(51994);
                return isInteractive;
            }
            isInteractive = powerManager.isScreenOn();
            AppMethodBeat.o(51994);
            return isInteractive;
        } catch (Exception e) {
            ab.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", bo.l(e));
            AppMethodBeat.o(51994);
            return false;
        }
    }

    static {
        AppMethodBeat.i(52000);
        AppMethodBeat.o(52000);
    }

    public static boolean eA(Context context) {
        AppMethodBeat.i(51995);
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(51995);
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                AppMethodBeat.o(51995);
                return true;
            }
        }
        AppMethodBeat.o(51995);
        return false;
    }

    public static int a(RunningAppProcessInfo runningAppProcessInfo) {
        AppMethodBeat.i(51996);
        if (xyl instanceof a) {
            Field field = ((a) xyl).xym;
            if (VERSION.SDK_INT >= 21 && field != null) {
                try {
                    int i = field.getInt(runningAppProcessInfo);
                    AppMethodBeat.o(51996);
                    return i;
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                }
            }
            AppMethodBeat.o(51996);
            return -1;
        }
        AppMethodBeat.o(51996);
        return -1;
    }

    public static void gm(Context context) {
        AppMethodBeat.i(51997);
        List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(10);
        if (runningServices == null) {
            AppMethodBeat.o(51997);
            return;
        }
        for (RunningServiceInfo runningServiceInfo : runningServices) {
            ab.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", runningServiceInfo.service, Boolean.valueOf(runningServiceInfo.foreground), Long.valueOf(runningServiceInfo.activeSince));
        }
        AppMethodBeat.o(51997);
    }

    public static boolean gn(Context context) {
        AppMethodBeat.i(51998);
        boolean go = xyl.go(context);
        AppMethodBeat.o(51998);
        return go;
    }

    public static String cc(Context context) {
        AppMethodBeat.i(51999);
        String str;
        if (eA(context)) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (VERSION.SDK_INT >= 23) {
                    List appTasks = activityManager.getAppTasks();
                    if (appTasks == null || appTasks.size() <= 0) {
                        str = "";
                        AppMethodBeat.o(51999);
                        return str;
                    }
                    Iterator it = appTasks.iterator();
                    if (it.hasNext()) {
                        ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                        if (componentName == null) {
                            AppMethodBeat.o(51999);
                            return null;
                        }
                        str = componentName.getClassName();
                        AppMethodBeat.o(51999);
                        return str;
                    }
                    str = "";
                    AppMethodBeat.o(51999);
                    return str;
                }
                str = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
                AppMethodBeat.o(51999);
                return str;
            } catch (Exception e) {
                ab.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bo.l(e));
            }
        } else {
            str = "";
            AppMethodBeat.o(51999);
            return str;
        }
    }
}
