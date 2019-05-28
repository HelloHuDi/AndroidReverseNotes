package com.tencent.mm.plugin.freewifi;

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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    Lock aCZ;
    private WifiManager bJj;
    private BroadcastReceiver broadcastReceiver;
    Condition cbS;
    private Context context;
    private long ftP = 15000;
    boolean mtC = false;
    boolean mtD = false;
    String ssid;

    public b(String str, Context context) {
        AppMethodBeat.i(20561);
        this.ssid = str;
        this.aCZ = new ReentrantLock();
        this.cbS = this.aCZ.newCondition();
        this.bJj = (WifiManager) context.getSystemService("wifi");
        this.context = context;
        AppMethodBeat.o(20561);
    }

    public final int byd() {
        AppMethodBeat.i(20562);
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.byO())) {
            AppMethodBeat.o(20562);
            return 0;
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
            AppMethodBeat.o(20562);
            throw runtimeException;
        } else {
            this.broadcastReceiver = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(20560);
                    NetworkInfo networkInfo;
                    if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                        networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", b.this.ssid, m.Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                        }
                        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && b.this.ssid.equals(m.Mv(networkInfo.getExtraInfo()))) {
                            try {
                                b.this.aCZ.lock();
                                b.this.mtC = true;
                                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                                b.this.cbS.signalAll();
                                return;
                            } finally {
                                b.this.aCZ.unlock();
                                AppMethodBeat.o(20560);
                            }
                        } else {
                            AppMethodBeat.o(20560);
                            return;
                        }
                    }
                    if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", b.this.ssid, m.Mx("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                        }
                        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && b.this.ssid.equals(m.Mv(networkInfo.getExtraInfo()))) {
                            try {
                                b.this.aCZ.lock();
                                b.this.mtD = true;
                                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                                b.this.cbS.signalAll();
                                return;
                            } finally {
                                b.this.aCZ.unlock();
                                AppMethodBeat.o(20560);
                            }
                        }
                    }
                    AppMethodBeat.o(20560);
                }
            };
            try {
                int bye;
                this.aCZ.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.context.registerReceiver(this.broadcastReceiver, intentFilter);
                if (!this.bJj.isWifiEnabled()) {
                    bye = new f(this.context).bye();
                    ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(bye)));
                    if (bye != 0) {
                        byc();
                        this.aCZ.unlock();
                        AppMethodBeat.o(20562);
                        return bye;
                    }
                }
                bye = d.ME(this.ssid);
                if (bye != 0) {
                    byc();
                    byc();
                    this.aCZ.unlock();
                    AppMethodBeat.o(20562);
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
                        ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.ftP);
                        this.ftP = this.ftP > 0 ? this.ftP : 3000;
                    } else {
                        break;
                    }
                }
                if (z) {
                    byc();
                    this.aCZ.unlock();
                    AppMethodBeat.o(20562);
                    return 0;
                }
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20562);
                return -16;
            } catch (InterruptedException e) {
                ab.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", e.getMessage());
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20562);
                return -17;
            } catch (Throwable th) {
                byc();
                this.aCZ.unlock();
                AppMethodBeat.o(20562);
            }
        }
    }

    private void byc() {
        AppMethodBeat.i(20563);
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(20563);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(20563);
        }
    }
}
