package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32509ab;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBReceiver */
public class BakOldUSBReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(17754);
        try {
            String action = intent.getAction();
            if ("MMBakchatServiceStart".equalsIgnoreCase(action)) {
                C25985d.m41463aH(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", intent.getStringExtra("url")));
                C4990ab.m7410d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
                AppMethodBeat.m2505o(17754);
                return;
            }
            if ("MMBakchatServiceStop".equalsIgnoreCase(action)) {
                C32509ab c32509ab = new C32509ab();
                c32509ab.csW.csX = context;
                C4879a.xxA.mo10055m(c32509ab);
                C4990ab.m7410d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
            }
            AppMethodBeat.m2505o(17754);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BakOldUSBReceiver", e, "onReceive:", new Object[0]);
            AppMethodBeat.m2505o(17754);
        }
    }
}
