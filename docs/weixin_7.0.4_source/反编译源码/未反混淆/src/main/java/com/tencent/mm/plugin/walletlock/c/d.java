package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d implements b {
    private static d tWR = null;

    public static d cTU() {
        AppMethodBeat.i(51691);
        if (tWR == null) {
            tWR = new d();
        }
        d dVar = tWR;
        AppMethodBeat.o(51691);
        return dVar;
    }

    private d() {
    }

    public final boolean ae(Activity activity) {
        Object className;
        AppMethodBeat.i(51690);
        ComponentName componentName = ((RunningTaskInfo) ((ActivityManager) ah.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        if (componentName != null) {
            className = componentName.getClassName();
        } else {
            className = "";
        }
        ab.d("MicroMsg.WalletGuardFilter", "coveredPage: ".concat(String.valueOf(className)));
        if (className == null || className.equals(activity.getClass().getName()) || !className.contains(ah.doz()) || !(className.contains("plugin.mall") || className.contains("plugin.card") || className.contains("plugin.wallet") || className.contains("plugin.wallet_index") || className.contains("plugin.webview") || className.contains("plugin.offline") || className.contains("plugin.recharge"))) {
            AppMethodBeat.o(51690);
            return true;
        }
        AppMethodBeat.o(51690);
        return false;
    }
}
