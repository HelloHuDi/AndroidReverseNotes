package com.tencent.p177mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.freewifi.b */
public final class C11953b {
    Lock aCZ;
    private WifiManager bJj;
    private BroadcastReceiver broadcastReceiver;
    Condition cbS;
    private Context context;
    private long ftP = 15000;
    boolean mtC = false;
    boolean mtD = false;
    String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.b$1 */
    class C119541 extends BroadcastReceiver {
        C119541() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(20560);
            NetworkInfo networkInfo;
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", C11953b.this.ssid, C34189m.m56059Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                }
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && C11953b.this.ssid.equals(C34189m.m56057Mv(networkInfo.getExtraInfo()))) {
                    try {
                        C11953b.this.aCZ.lock();
                        C11953b.this.mtC = true;
                        C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                        C11953b.this.cbS.signalAll();
                        return;
                    } finally {
                        C11953b.this.aCZ.unlock();
                        AppMethodBeat.m2505o(20560);
                    }
                } else {
                    AppMethodBeat.m2505o(20560);
                    return;
                }
            }
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", C11953b.this.ssid, C34189m.m56059Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                }
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && C11953b.this.ssid.equals(C34189m.m56057Mv(networkInfo.getExtraInfo()))) {
                    try {
                        C11953b.this.aCZ.lock();
                        C11953b.this.mtD = true;
                        C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                        C11953b.this.cbS.signalAll();
                        return;
                    } finally {
                        C11953b.this.aCZ.unlock();
                        AppMethodBeat.m2505o(20560);
                    }
                }
            }
            AppMethodBeat.m2505o(20560);
        }
    }

    public C11953b(String str, Context context) {
        AppMethodBeat.m2504i(20561);
        this.ssid = str;
        this.aCZ = new ReentrantLock();
        this.cbS = this.aCZ.newCondition();
        this.bJj = (WifiManager) context.getSystemService("wifi");
        this.context = context;
        AppMethodBeat.m2505o(20561);
    }

    public final int byd() {
        AppMethodBeat.m2504i(20562);
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(C45957d.byO())) {
            AppMethodBeat.m2505o(20562);
            return 0;
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
            AppMethodBeat.m2505o(20562);
            throw runtimeException;
        } else {
            this.broadcastReceiver = new C119541();
            try {
                int bye;
                this.aCZ.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.context.registerReceiver(this.broadcastReceiver, intentFilter);
                if (!this.bJj.isWifiEnabled()) {
                    bye = new C45953f(this.context).bye();
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(bye)));
                    if (bye != 0) {
                        byc();
                        this.aCZ.unlock();
                        AppMethodBeat.m2505o(20562);
                        return bye;
                    }
                }
                bye = C45957d.m85349ME(this.ssid);
                if (bye != 0) {
                    byc();
                    byc();
                    this.aCZ.unlock();
                    AppMethodBeat.m2505o(20562);
                    return bye;
                }
                boolean z = false;
                while (true) {
                    if (!this.mtC || !this.mtD) {
                        long currentTimeMillis = System.currentTimeMillis();
                        z = this.cbS.await(this.ftP, TimeUnit.MILLISECONDS);
                        if (!z) {
                            break;
                        }
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        this.ftP -= currentTimeMillis;
                        C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.ftP);
                        this.ftP = this.ftP > 0 ? this.ftP : 3000;
                    } else {
                        break;
                    }
                }
                if (z) {
                    byc();
                    this.aCZ.unlock();
                    AppMethodBeat.m2505o(20562);
                    return 0;
                }
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20562);
                return -16;
            } catch (InterruptedException e) {
                C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", e.getMessage());
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20562);
                return -17;
            } catch (Throwable th) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20562);
            }
        }
    }

    private void byc() {
        AppMethodBeat.m2504i(20563);
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.m2505o(20563);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(20563);
        }
    }
}
