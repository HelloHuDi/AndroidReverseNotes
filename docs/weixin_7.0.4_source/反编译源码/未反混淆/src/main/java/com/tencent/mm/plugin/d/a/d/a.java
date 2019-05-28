package com.tencent.mm.plugin.d.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    final a jIS;
    public final BroadcastReceiver jIT = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(18496);
            if (intent == null) {
                ab.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
                AppMethodBeat.o(18496);
                return;
            }
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                ab.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    a.this.jIS.rS(intExtra);
                }
            }
            AppMethodBeat.o(18496);
        }
    };

    public interface a {
        void rS(int i);
    }

    public a(a aVar) {
        AppMethodBeat.i(18497);
        ab.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.jIS = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ah.getContext().registerReceiver(this.jIT, intentFilter);
        AppMethodBeat.o(18497);
    }
}
