package com.tencent.p177mm.plugin.walletlock.p1319c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40169b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.walletlock.c.d */
public final class C29711d implements C40169b {
    private static C29711d tWR = null;

    public static C29711d cTU() {
        AppMethodBeat.m2504i(51691);
        if (tWR == null) {
            tWR = new C29711d();
        }
        C29711d c29711d = tWR;
        AppMethodBeat.m2505o(51691);
        return c29711d;
    }

    private C29711d() {
    }

    /* renamed from: ae */
    public final boolean mo47948ae(Activity activity) {
        Object className;
        AppMethodBeat.m2504i(51690);
        ComponentName componentName = ((RunningTaskInfo) ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        if (componentName != null) {
            className = componentName.getClassName();
        } else {
            className = "";
        }
        C4990ab.m7410d("MicroMsg.WalletGuardFilter", "coveredPage: ".concat(String.valueOf(className)));
        if (className == null || className.equals(activity.getClass().getName()) || !className.contains(C4996ah.doz()) || !(className.contains("plugin.mall") || className.contains("plugin.card") || className.contains("plugin.wallet") || className.contains("plugin.wallet_index") || className.contains("plugin.webview") || className.contains("plugin.offline") || className.contains("plugin.recharge"))) {
            AppMethodBeat.m2505o(51690);
            return true;
        }
        AppMethodBeat.m2505o(51690);
        return false;
    }
}
