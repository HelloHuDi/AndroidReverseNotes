package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    Lock aCZ = new ReentrantLock();
    private WifiManager bJj = ((WifiManager) ah.getContext().getSystemService("wifi"));
    private BroadcastReceiver broadcastReceiver;
    Condition cbS = this.aCZ.newCondition();
    private Context context;
    private int mtM = 10;

    public f(Context context) {
        AppMethodBeat.i(20576);
        this.context = context;
        AppMethodBeat.o(20576);
    }

    public final int bye() {
        AppMethodBeat.i(20577);
        if (3 == this.bJj.getWifiState()) {
            AppMethodBeat.o(20577);
            return 0;
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(20575);
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    ab.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(intExtra)));
                    if (intExtra == 3) {
                        try {
                            f.this.aCZ.lock();
                            f.this.cbS.signalAll();
                            return;
                        } finally {
                            f.this.byc();
                            f.this.aCZ.unlock();
                            AppMethodBeat.o(20575);
                        }
                    }
                }
                AppMethodBeat.o(20575);
            }
        };
        try {
            this.aCZ.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.broadcastReceiver, intentFilter);
            this.bJj.setWifiEnabled(true);
            if (this.cbS.await((long) this.mtM, TimeUnit.SECONDS)) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20577);
                return 0;
            }
            byc();
            this.aCZ.unlock();
            AppMethodBeat.o(20577);
            return 1;
        } catch (InterruptedException e) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.o(20577);
            return 2;
        } catch (Throwable th) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.o(20577);
        }
    }

    public final void byc() {
        AppMethodBeat.i(20578);
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(20578);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(20578);
        }
    }
}
