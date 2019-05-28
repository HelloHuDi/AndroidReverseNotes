package com.tencent.p177mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.freewifi.f */
final class C45953f {
    Lock aCZ = new ReentrantLock();
    private WifiManager bJj = ((WifiManager) C4996ah.getContext().getSystemService("wifi"));
    private BroadcastReceiver broadcastReceiver;
    Condition cbS = this.aCZ.newCondition();
    private Context context;
    private int mtM = 10;

    /* renamed from: com.tencent.mm.plugin.freewifi.f$1 */
    class C431121 extends BroadcastReceiver {
        C431121() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(20575);
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("wifi_state", 0);
                C4990ab.m7416i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(intExtra)));
                if (intExtra == 3) {
                    try {
                        C45953f.this.aCZ.lock();
                        C45953f.this.cbS.signalAll();
                        return;
                    } finally {
                        C45953f.this.byc();
                        C45953f.this.aCZ.unlock();
                        AppMethodBeat.m2505o(20575);
                    }
                }
            }
            AppMethodBeat.m2505o(20575);
        }
    }

    public C45953f(Context context) {
        AppMethodBeat.m2504i(20576);
        this.context = context;
        AppMethodBeat.m2505o(20576);
    }

    public final int bye() {
        AppMethodBeat.m2504i(20577);
        if (3 == this.bJj.getWifiState()) {
            AppMethodBeat.m2505o(20577);
            return 0;
        }
        this.broadcastReceiver = new C431121();
        try {
            this.aCZ.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.broadcastReceiver, intentFilter);
            this.bJj.setWifiEnabled(true);
            if (this.cbS.await((long) this.mtM, TimeUnit.SECONDS)) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20577);
                return 0;
            }
            byc();
            this.aCZ.unlock();
            AppMethodBeat.m2505o(20577);
            return 1;
        } catch (InterruptedException e) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.m2505o(20577);
            return 2;
        } catch (Throwable th) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.m2505o(20577);
        }
    }

    public final void byc() {
        AppMethodBeat.m2504i(20578);
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.m2505o(20578);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(20578);
        }
    }
}
