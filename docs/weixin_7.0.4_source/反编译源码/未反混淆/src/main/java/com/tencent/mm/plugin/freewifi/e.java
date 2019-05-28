package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
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

public final class e {
    Lock aCZ = new ReentrantLock();
    private Activity activity;
    private WifiManager bJj = ((WifiManager) ah.getContext().getSystemService("wifi"));
    private BroadcastReceiver broadcastReceiver;
    Condition cbS = this.aCZ.newCondition();
    private int mtM = 10;

    public e(Activity activity) {
        AppMethodBeat.i(20572);
        this.activity = activity;
        AppMethodBeat.o(20572);
    }

    public final int bye() {
        AppMethodBeat.i(20573);
        if (3 == this.bJj.getWifiState()) {
            AppMethodBeat.o(20573);
            return 0;
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(20571);
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    ab.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(intExtra)));
                    if (intExtra == 3) {
                        try {
                            e.this.aCZ.lock();
                            e.this.cbS.signalAll();
                            return;
                        } finally {
                            e.this.byc();
                            e.this.aCZ.unlock();
                            AppMethodBeat.o(20571);
                        }
                    }
                }
                AppMethodBeat.o(20571);
            }
        };
        try {
            this.aCZ.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.activity.registerReceiver(this.broadcastReceiver, intentFilter);
            this.bJj.setWifiEnabled(true);
            if (this.cbS.await((long) this.mtM, TimeUnit.SECONDS)) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20573);
                return 0;
            }
            byc();
            this.aCZ.unlock();
            AppMethodBeat.o(20573);
            return 1;
        } catch (InterruptedException e) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.o(20573);
            return 2;
        } catch (Throwable th) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.o(20573);
        }
    }

    public final void byc() {
        AppMethodBeat.i(20574);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(20574);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(20574);
        }
    }
}
