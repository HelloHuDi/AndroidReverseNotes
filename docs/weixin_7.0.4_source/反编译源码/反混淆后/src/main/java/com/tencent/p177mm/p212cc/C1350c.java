package com.tencent.p177mm.p212cc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p212cc.C1349b.C1348a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.cc.c */
final class C1350c extends BroadcastReceiver {
    C6391a<Boolean> xHL;
    C6391a<Boolean> xHM;

    C1350c(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(58950);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this, intentFilter);
        String str = "charging";
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        }
        this.xHL = new C6391a(str, Boolean.valueOf(z));
        this.xHM = new C6391a("interactive", Boolean.valueOf(((PowerManager) context.getSystemService("power")).isScreenOn()));
        AppMethodBeat.m2505o(58950);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(58951);
        String action = intent.getAction();
        if (action == null) {
            AppMethodBeat.m2505o(58951);
            return;
        }
        C1348a c1348a = null;
        int i = -1;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    i = 1;
                    break;
                }
                break;
            case -1886648615:
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    i = 3;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    i = 0;
                    break;
                }
                break;
            case 1019184907:
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                this.xHM.set(Boolean.TRUE);
                c1348a = this.xHM;
                break;
            case 1:
                this.xHM.set(Boolean.FALSE);
                c1348a = this.xHM;
                break;
            case 2:
                this.xHL.set(Boolean.TRUE);
                c1348a = this.xHL;
                break;
            case 3:
                this.xHL.set(Boolean.FALSE);
                c1348a = this.xHL;
                break;
        }
        if (c1348a != null) {
            C4990ab.m7417i("MicroMsg.SystemStatus", "System status changed: %s = %s", c1348a.name(), c1348a.get().toString());
        }
        AppMethodBeat.m2505o(58951);
    }
}
