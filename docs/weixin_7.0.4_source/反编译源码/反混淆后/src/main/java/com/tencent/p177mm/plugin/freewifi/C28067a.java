package com.tencent.p177mm.plugin.freewifi;

import android.app.Activity;
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
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.freewifi.a */
public final class C28067a {
    Lock aCZ;
    Activity activity;
    private WifiManager bJj;
    private BroadcastReceiver broadcastReceiver;
    Condition cbS;
    private long ftP;
    boolean mtC = false;
    boolean mtD = false;
    String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.a$a */
    public interface C20777a {
        void onFail(int i);

        void onSuccess();
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.a$2 */
    class C280692 extends BroadcastReceiver {
        C280692() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(20556);
            NetworkInfo networkInfo;
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", C28067a.this.ssid, C34189m.m56059Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                }
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && C28067a.this.ssid.equals(C34189m.m56057Mv(networkInfo.getExtraInfo()))) {
                    try {
                        C28067a.this.aCZ.lock();
                        C28067a.this.mtC = true;
                        C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                        C28067a.this.cbS.signalAll();
                        return;
                    } finally {
                        C28067a.this.aCZ.unlock();
                        AppMethodBeat.m2505o(20556);
                    }
                } else {
                    AppMethodBeat.m2505o(20556);
                    return;
                }
            }
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", C28067a.this.ssid, C34189m.m56059Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                }
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && C28067a.this.ssid.equals(C34189m.m56057Mv(networkInfo.getExtraInfo()))) {
                    try {
                        C28067a.this.aCZ.lock();
                        C28067a.this.mtD = true;
                        C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                        C28067a.this.cbS.signalAll();
                        return;
                    } finally {
                        C28067a.this.aCZ.unlock();
                        AppMethodBeat.m2505o(20556);
                    }
                }
            }
            AppMethodBeat.m2505o(20556);
        }
    }

    public C28067a(String str, Activity activity) {
        AppMethodBeat.m2504i(20557);
        this.activity = activity;
        this.ftP = 15000;
        this.ssid = str;
        this.aCZ = new ReentrantLock();
        this.cbS = this.aCZ.newCondition();
        this.bJj = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        AppMethodBeat.m2505o(20557);
    }

    /* renamed from: a */
    public final void mo45989a(final C20777a c20777a) {
        AppMethodBeat.m2504i(20558);
        C280681 c280681 = new C20777a() {
            public final void onSuccess() {
                AppMethodBeat.m2504i(20554);
                C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", C34189m.m56063V(C28067a.this.activity.getIntent()), Integer.valueOf(C34189m.m56064W(C28067a.this.activity.getIntent())));
                c20777a.onSuccess();
                AppMethodBeat.m2505o(20554);
            }

            public final void onFail(int i) {
                AppMethodBeat.m2504i(20555);
                C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", C34189m.m56063V(C28067a.this.activity.getIntent()), Integer.valueOf(C34189m.m56064W(C28067a.this.activity.getIntent())), Integer.valueOf(i));
                c20777a.onFail(i);
                AppMethodBeat.m2505o(20555);
            }
        };
        if (((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(C45957d.byO())) {
            c280681.onSuccess();
            AppMethodBeat.m2505o(20558);
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
            AppMethodBeat.m2505o(20558);
            throw runtimeException;
        } else {
            this.broadcastReceiver = new C280692();
            try {
                int bye;
                this.aCZ.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.activity.registerReceiver(this.broadcastReceiver, intentFilter);
                if (!this.bJj.isWifiEnabled()) {
                    bye = new C39108e(this.activity).bye();
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(bye)));
                    if (bye != 0) {
                        c280681.onFail(bye);
                        byc();
                        this.aCZ.unlock();
                        AppMethodBeat.m2505o(20558);
                        return;
                    }
                }
                bye = C45957d.m85349ME(this.ssid);
                if (bye != 0) {
                    byc();
                    c280681.onFail(bye);
                    byc();
                    this.aCZ.unlock();
                    AppMethodBeat.m2505o(20558);
                    return;
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
                    c280681.onSuccess();
                } else {
                    c280681.onFail(-16);
                }
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20558);
            } catch (InterruptedException e) {
                C4990ab.m7417i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", C34189m.m56063V(this.activity.getIntent()), Integer.valueOf(C34189m.m56064W(this.activity.getIntent())), e.getMessage());
                c280681.onFail(-17);
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20558);
            } catch (Throwable th) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.m2505o(20558);
                throw th;
            }
        }
    }

    private void byc() {
        AppMethodBeat.m2504i(20559);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.m2505o(20559);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(20559);
        }
    }
}
