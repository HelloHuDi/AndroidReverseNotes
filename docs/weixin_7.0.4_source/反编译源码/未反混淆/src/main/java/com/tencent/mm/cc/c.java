package com.tencent.mm.cc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c extends BroadcastReceiver {
    a<Boolean> xHL;
    a<Boolean> xHM;

    c(Context context) {
        boolean z = false;
        AppMethodBeat.i(58950);
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
        this.xHL = new a(str, Boolean.valueOf(z));
        this.xHM = new a("interactive", Boolean.valueOf(((PowerManager) context.getSystemService("power")).isScreenOn()));
        AppMethodBeat.o(58950);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(58951);
        String action = intent.getAction();
        if (action == null) {
            AppMethodBeat.o(58951);
            return;
        }
        a aVar = null;
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
                aVar = this.xHM;
                break;
            case 1:
                this.xHM.set(Boolean.FALSE);
                aVar = this.xHM;
                break;
            case 2:
                this.xHL.set(Boolean.TRUE);
                aVar = this.xHL;
                break;
            case 3:
                this.xHL.set(Boolean.FALSE);
                aVar = this.xHL;
                break;
        }
        if (aVar != null) {
            ab.i("MicroMsg.SystemStatus", "System status changed: %s = %s", aVar.name(), aVar.get().toString());
        }
        AppMethodBeat.o(58951);
    }
}
