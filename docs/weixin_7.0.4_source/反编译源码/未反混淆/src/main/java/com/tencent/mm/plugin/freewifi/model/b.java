package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    a mvB;
    BroadcastReceiver mvC;

    static class a {
        String bssid;
        long mvE;
        String mvF;
        String ssid;
        int type;

        private a() {
            this.ssid = "";
            this.bssid = "";
            this.mvF = "";
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final a byG() {
            AppMethodBeat.i(20689);
            a aVar = new a();
            aVar.mvE = this.mvE;
            aVar.type = this.type;
            aVar.ssid = this.ssid;
            aVar.bssid = this.bssid;
            aVar.mvF = this.mvF;
            AppMethodBeat.o(20689);
            return aVar;
        }

        public final String toString() {
            AppMethodBeat.i(20690);
            String format = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.mvE), Integer.valueOf(this.type), this.ssid, this.bssid, this.mvF});
            AppMethodBeat.o(20690);
            return format;
        }
    }

    static class b {
        private static b mvG = new b();

        static {
            AppMethodBeat.i(20691);
            AppMethodBeat.o(20691);
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        AppMethodBeat.i(20692);
        this.mvB = new a();
        this.mvC = new BroadcastReceiver() {
            /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0156=Splitter:B:39:0x0156, B:51:0x01b6=Splitter:B:51:0x01b6} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(20688);
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo == null) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                            AppMethodBeat.o(20688);
                            return;
                        }
                        ab.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable()));
                        if (!networkInfo.isConnected()) {
                            ab.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                            AppMethodBeat.o(20688);
                            return;
                        } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                            ab.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                            AppMethodBeat.o(20688);
                            return;
                        } else if (context == null) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                            AppMethodBeat.o(20688);
                            return;
                        } else if (networkInfo.getType() == 1) {
                            String Mv = m.Mv(m.Mx("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
                            String toLowerCase = m.My("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
                            ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", m.Mv(m.Mw(networkInfo.getExtraInfo())), Mv, toLowerCase);
                            if (!m.Mw(m.Mv(m.Mw(networkInfo.getExtraInfo()))).equals(Mv)) {
                                ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                                AppMethodBeat.o(20688);
                                return;
                            } else if (b.this.mvB.type == 1 && m.Mw(b.this.mvB.ssid).equals(Mv) && m.Mw(b.this.mvB.bssid).equals(toLowerCase)) {
                                ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                                AppMethodBeat.o(20688);
                                return;
                            } else {
                                a aVar = new a();
                                aVar.mvE = System.currentTimeMillis();
                                aVar.type = 1;
                                aVar.ssid = Mv;
                                aVar.bssid = toLowerCase;
                                aVar.mvF = "";
                                b.b(b.this.mvB.byG(), aVar);
                                b.this.mvB = aVar;
                                AppMethodBeat.o(20688);
                                return;
                            }
                        } else if (networkInfo.getType() != 0) {
                            AppMethodBeat.o(20688);
                            return;
                        } else if (b.this.mvB.type == 0 && m.Mw(b.this.mvB.mvF).equals(m.Mw(networkInfo.getExtraInfo()))) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                            AppMethodBeat.o(20688);
                            return;
                        } else {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager == null) {
                                ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                                AppMethodBeat.o(20688);
                                return;
                            }
                            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                            if (networkInfo2 == null) {
                                ab.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                                AppMethodBeat.o(20688);
                                return;
                            }
                            ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", networkInfo2.getState(), networkInfo2.getDetailedState());
                            if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                                ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                                AppMethodBeat.o(20688);
                                return;
                            }
                            a aVar2 = new a();
                            aVar2.mvE = System.currentTimeMillis();
                            aVar2.type = 0;
                            aVar2.ssid = "";
                            aVar2.bssid = "";
                            aVar2.mvF = m.Mw(networkInfo.getExtraInfo());
                            b.a(b.this.mvB.byG(), aVar2);
                            b.this.mvB = aVar2;
                            AppMethodBeat.o(20688);
                            return;
                        }
                    } catch (Exception e) {
                        com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
                        byo.cuH = "UnExpectedException";
                        byo.result = -1;
                        byo.ehr = m.g(e);
                        byo.byq().byp();
                        ab.e("MicroMsg.FreeWifi.UnExcepctedException", m.h(e));
                    }
                }
                AppMethodBeat.o(20688);
            }
        };
        AppMethodBeat.o(20692);
    }

    public final void byc() {
        AppMethodBeat.i(20693);
        try {
            ah.getContext().unregisterReceiver(this.mvC);
            AppMethodBeat.o(20693);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(20693);
        }
    }

    static void a(a aVar, a aVar2) {
        AppMethodBeat.i(20694);
        m.MA("on mobile connected.");
        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        com.tencent.mm.plugin.freewifi.f.b.kT(0);
        AppMethodBeat.o(20694);
    }

    static void b(a aVar, a aVar2) {
        AppMethodBeat.i(20695);
        m.MA("on wifi connected.");
        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.MA("on wifi roaming.");
            ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", str, str2, str3);
        }
        com.tencent.mm.plugin.freewifi.f.b.kT(1);
        AppMethodBeat.o(20695);
    }
}
