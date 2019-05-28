package com.tencent.mm.plugin.normsg.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.util.List;

public final class g {
    public static boolean oVi;

    static {
        AppMethodBeat.i(10441);
        oVi = false;
        long nanoTime = System.nanoTime();
        try {
            oVi = false;
            if (VERSION.SDK_INT < 21) {
                oVi = false;
            } else {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List recentTasks = ((ActivityManager) ah.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    oVi = false;
                } else if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                    oVi = true;
                }
            }
            ab.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(oVi), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(10441);
        } catch (Throwable th) {
            ab.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(oVi), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(10441);
        }
    }
}
