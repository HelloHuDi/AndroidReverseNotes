package com.tencent.p177mm.plugin.freewifi;

import android.app.Activity;
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

/* renamed from: com.tencent.mm.plugin.freewifi.e */
public final class C39108e {
    Lock aCZ = new ReentrantLock();
    private Activity activity;
    private WifiManager bJj = ((WifiManager) C4996ah.getContext().getSystemService("wifi"));
    private BroadcastReceiver broadcastReceiver;
    Condition cbS = this.aCZ.newCondition();
    private int mtM = 10;

    /* renamed from: com.tencent.mm.plugin.freewifi.e$1 */
    class C391091 extends BroadcastReceiver {
        C391091() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(20571);
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("wifi_state", 0);
                C4990ab.m7416i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(intExtra)));
                if (intExtra == 3) {
                    try {
                        C39108e.this.aCZ.lock();
                        C39108e.this.cbS.signalAll();
                        return;
                    } finally {
                        C39108e.this.byc();
                        C39108e.this.aCZ.unlock();
                        AppMethodBeat.m2505o(20571);
                    }
                }
            }
            AppMethodBeat.m2505o(20571);
        }
    }

    public C39108e(Activity activity) {
        AppMethodBeat.m2504i(20572);
        this.activity = activity;
        AppMethodBeat.m2505o(20572);
    }

    public final int bye() {
        AppMethodBeat.m2504i(20573);
        if (3 == this.bJj.getWifiState()) {
            AppMethodBeat.m2505o(20573);
            return 0;
        }
        this.broadcastReceiver = new C391091();
        try {
            this.aCZ.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.activity.registerReceiver(this.broadcastReceiver, intentFilter);
            this.bJj.setWifiEnabled(true);
            if (this.cbS.await((long) this.mtM, TimeUnit.SECONDS)) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20573);
                return 0;
            }
            byc();
            this.aCZ.unlock();
            AppMethodBeat.m2505o(20573);
            return 1;
        } catch (InterruptedException e) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.m2505o(20573);
            return 2;
        } catch (Throwable th) {
            byc();
            this.aCZ.unlock();
            AppMethodBeat.m2505o(20573);
        }
    }

    public final void byc() {
        AppMethodBeat.m2504i(20574);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.m2505o(20574);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(20574);
        }
    }
}
