package com.tencent.p177mm.plugin.normsg.p474b;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.normsg.b.g */
public final class C43350g {
    public static boolean oVi;

    static {
        AppMethodBeat.m2504i(10441);
        oVi = false;
        long nanoTime = System.nanoTime();
        try {
            oVi = false;
            if (VERSION.SDK_INT < 21) {
                oVi = false;
            } else {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List recentTasks = ((ActivityManager) C4996ah.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    oVi = false;
                } else if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                    oVi = true;
                }
            }
            C4990ab.m7417i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(oVi), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.m2505o(10441);
        } catch (Throwable th) {
            C4990ab.m7417i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(oVi), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.m2505o(10441);
        }
    }
}
