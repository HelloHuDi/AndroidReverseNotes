package com.tencent.mm.ui.base;

import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class y {
    public static int yAS = -1;

    public static void activateBroadcast(boolean z) {
        AppMethodBeat.i(107085);
        d(z, null);
        AppMethodBeat.o(107085);
    }

    public static void d(boolean z, Intent intent) {
        AppMethodBeat.i(107086);
        if (qf(z)) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setAction(z ? "com.tencent.mm.ui.ACTION_ACTIVE" : "com.tencent.mm.ui.ACTION_DEACTIVE");
            intent.putExtra("_application_context_process_", ah.getProcessName());
            intent.putExtra("process_id", Process.myPid());
            intent.putExtra("process_is_mm", ah.bqo());
            ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            AppMethodBeat.o(107086);
            return;
        }
        ab.w("MicroMsg.UIStatusUtil", "isRealSend = false,just return!");
        AppMethodBeat.o(107086);
    }

    private static boolean qf(boolean z) {
        int i;
        boolean z2 = true;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (yAS == i) {
            z2 = false;
        }
        yAS = i;
        return z2;
    }
}
