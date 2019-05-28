package com.tencent.mm.plugin.freewifi;

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
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    Lock aCZ;
    Activity activity;
    private WifiManager bJj;
    private BroadcastReceiver broadcastReceiver;
    Condition cbS;
    private long ftP;
    boolean mtC = false;
    boolean mtD = false;
    String ssid;

    public interface a {
        void onFail(int i);

        void onSuccess();
    }

    public a(String str, Activity activity) {
        AppMethodBeat.i(20557);
        this.activity = activity;
        this.ftP = 15000;
        this.ssid = str;
        this.aCZ = new ReentrantLock();
        this.cbS = this.aCZ.newCondition();
        this.bJj = (WifiManager) ah.getContext().getSystemService("wifi");
        AppMethodBeat.o(20557);
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(20558);
        AnonymousClass1 anonymousClass1 = new a() {
            public final void onSuccess() {
                AppMethodBeat.i(20554);
                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", m.V(a.this.activity.getIntent()), Integer.valueOf(m.W(a.this.activity.getIntent())));
                aVar.onSuccess();
                AppMethodBeat.o(20554);
            }

            public final void onFail(int i) {
                AppMethodBeat.i(20555);
                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", m.V(a.this.activity.getIntent()), Integer.valueOf(m.W(a.this.activity.getIntent())), Integer.valueOf(i));
                aVar.onFail(i);
                AppMethodBeat.o(20555);
            }
        };
        if (((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.byO())) {
            anonymousClass1.onSuccess();
            AppMethodBeat.o(20558);
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
            AppMethodBeat.o(20558);
            throw runtimeException;
        } else {
            this.broadcastReceiver = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(20556);
                    NetworkInfo networkInfo;
                    if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                        networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", a.this.ssid, m.Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                        }
                        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && a.this.ssid.equals(m.Mv(networkInfo.getExtraInfo()))) {
                            try {
                                a.this.aCZ.lock();
                                a.this.mtC = true;
                                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                                a.this.cbS.signalAll();
                                return;
                            } finally {
                                a.this.aCZ.unlock();
                                AppMethodBeat.o(20556);
                            }
                        } else {
                            AppMethodBeat.o(20556);
                            return;
                        }
                    }
                    if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", a.this.ssid, m.Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                        }
                        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && a.this.ssid.equals(m.Mv(networkInfo.getExtraInfo()))) {
                            try {
                                a.this.aCZ.lock();
                                a.this.mtD = true;
                                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                                a.this.cbS.signalAll();
                                return;
                            } finally {
                                a.this.aCZ.unlock();
                                AppMethodBeat.o(20556);
                            }
                        }
                    }
                    AppMethodBeat.o(20556);
                }
            };
            try {
                int bye;
                this.aCZ.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.activity.registerReceiver(this.broadcastReceiver, intentFilter);
                if (!this.bJj.isWifiEnabled()) {
                    bye = new e(this.activity).bye();
                    ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(bye)));
                    if (bye != 0) {
                        anonymousClass1.onFail(bye);
                        byc();
                        this.aCZ.unlock();
                        AppMethodBeat.o(20558);
                        return;
                    }
                }
                bye = d.ME(this.ssid);
                if (bye != 0) {
                    byc();
                    anonymousClass1.onFail(bye);
                    byc();
                    this.aCZ.unlock();
                    AppMethodBeat.o(20558);
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
                        ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.ftP);
                        this.ftP = this.ftP > 0 ? this.ftP : 3000;
                    } else {
                        break;
                    }
                }
                if (z) {
                    anonymousClass1.onSuccess();
                } else {
                    anonymousClass1.onFail(-16);
                }
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20558);
            } catch (InterruptedException e) {
                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", m.V(this.activity.getIntent()), Integer.valueOf(m.W(this.activity.getIntent())), e.getMessage());
                anonymousClass1.onFail(-17);
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20558);
            } catch (Throwable th) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20558);
                throw th;
            }
        }
    }

    private void byc() {
        AppMethodBeat.i(20559);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(20559);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(20559);
        }
    }
}
