package com.tencent.p177mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.p057v4.content.C37116d;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver */
public class AdlandingRemoteServiceConnectedReceiver extends BroadcastReceiver {
    private Runnable fZM;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(36097);
        if (!(intent == null || !"com.tencnet.mm.action.adlanding.connected".equals(intent.getAction()) || this.fZM == null)) {
            this.fZM.run();
        }
        AppMethodBeat.m2505o(36097);
    }

    /* renamed from: b */
    public static void m46133b(C37116d c37116d) {
        AppMethodBeat.m2504i(36098);
        c37116d.mo59172c(new Intent("com.tencnet.mm.action.adlanding.connected"));
        AppMethodBeat.m2505o(36098);
    }
}
