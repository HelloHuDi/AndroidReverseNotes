package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public final class HomeKeyMonitor {
    boolean lMy;

    public class MonitorReceiver extends BroadcastReceiver {
        final /* synthetic */ HomeKeyMonitor lMz;

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(73372);
            if (this.lMz.lMy) {
                this.lMz.lMy = false;
                if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra("reason");
                    if (stringExtra != null) {
                        if (stringExtra.equals("homekey")) {
                            ab.i("HomeKeyMonitor", "habbyge-homeKey ------------------ " + Process.myPid());
                            AppMethodBeat.o(73372);
                            return;
                        } else if (stringExtra.equals("recentapps")) {
                            ab.i("HomeKeyMonitor", "habbyge-multiTaskKey ------------------ " + Process.myPid());
                        }
                    }
                }
                AppMethodBeat.o(73372);
                return;
            }
            AppMethodBeat.o(73372);
        }
    }
}
