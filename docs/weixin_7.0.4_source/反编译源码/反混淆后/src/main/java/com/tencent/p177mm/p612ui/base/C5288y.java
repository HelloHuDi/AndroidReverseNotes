package com.tencent.p177mm.p612ui.base;

import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ui.base.y */
public final class C5288y {
    public static int yAS = -1;

    public static void activateBroadcast(boolean z) {
        AppMethodBeat.m2504i(107085);
        C5288y.m8058d(z, null);
        AppMethodBeat.m2505o(107085);
    }

    /* renamed from: d */
    public static void m8058d(boolean z, Intent intent) {
        AppMethodBeat.m2504i(107086);
        if (C5288y.m8059qf(z)) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setAction(z ? "com.tencent.mm.ui.ACTION_ACTIVE" : "com.tencent.mm.ui.ACTION_DEACTIVE");
            intent.putExtra("_application_context_process_", C4996ah.getProcessName());
            intent.putExtra("process_id", Process.myPid());
            intent.putExtra("process_is_mm", C4996ah.bqo());
            C4996ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            AppMethodBeat.m2505o(107086);
            return;
        }
        C4990ab.m7420w("MicroMsg.UIStatusUtil", "isRealSend = false,just return!");
        AppMethodBeat.m2505o(107086);
    }

    /* renamed from: qf */
    private static boolean m8059qf(boolean z) {
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
