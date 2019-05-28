package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@Deprecated
/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.HomeKeyMonitor */
public final class HomeKeyMonitor {
    boolean lMy;

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.HomeKeyMonitor$MonitorReceiver */
    public class MonitorReceiver extends BroadcastReceiver {
        final /* synthetic */ HomeKeyMonitor lMz;

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(73372);
            if (this.lMz.lMy) {
                this.lMz.lMy = false;
                if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra("reason");
                    if (stringExtra != null) {
                        if (stringExtra.equals("homekey")) {
                            C4990ab.m7416i("HomeKeyMonitor", "habbyge-homeKey ------------------ " + Process.myPid());
                            AppMethodBeat.m2505o(73372);
                            return;
                        } else if (stringExtra.equals("recentapps")) {
                            C4990ab.m7416i("HomeKeyMonitor", "habbyge-multiTaskKey ------------------ " + Process.myPid());
                        }
                    }
                }
                AppMethodBeat.m2505o(73372);
                return;
            }
            AppMethodBeat.m2505o(73372);
        }
    }
}
