package com.tencent.p177mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p1401f.C34187b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.freewifi.model.b */
public final class C3141b {
    C3143a mvB;
    BroadcastReceiver mvC;

    /* renamed from: com.tencent.mm.plugin.freewifi.model.b$1 */
    class C31421 extends BroadcastReceiver {
        C31421() {
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0156=Splitter:B:39:0x0156, B:51:0x01b6=Splitter:B:51:0x01b6} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(20688);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo == null) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                        AppMethodBeat.m2505o(20688);
                        return;
                    }
                    C4990ab.m7419v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable()));
                    if (!networkInfo.isConnected()) {
                        C4990ab.m7418v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                        AppMethodBeat.m2505o(20688);
                        return;
                    } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                        C4990ab.m7418v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                        AppMethodBeat.m2505o(20688);
                        return;
                    } else if (context == null) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                        AppMethodBeat.m2505o(20688);
                        return;
                    } else if (networkInfo.getType() == 1) {
                        String Mv = C34189m.m56057Mv(C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
                        String toLowerCase = C34189m.m56060My("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", C34189m.m56057Mv(C34189m.m56058Mw(networkInfo.getExtraInfo())), Mv, toLowerCase);
                        if (!C34189m.m56058Mw(C34189m.m56057Mv(C34189m.m56058Mw(networkInfo.getExtraInfo()))).equals(Mv)) {
                            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                            AppMethodBeat.m2505o(20688);
                            return;
                        } else if (C3141b.this.mvB.type == 1 && C34189m.m56058Mw(C3141b.this.mvB.ssid).equals(Mv) && C34189m.m56058Mw(C3141b.this.mvB.bssid).equals(toLowerCase)) {
                            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                            AppMethodBeat.m2505o(20688);
                            return;
                        } else {
                            C3143a c3143a = new C3143a();
                            c3143a.mvE = System.currentTimeMillis();
                            c3143a.type = 1;
                            c3143a.ssid = Mv;
                            c3143a.bssid = toLowerCase;
                            c3143a.mvF = "";
                            C3141b.m5379b(C3141b.this.mvB.byG(), c3143a);
                            C3141b.this.mvB = c3143a;
                            AppMethodBeat.m2505o(20688);
                            return;
                        }
                    } else if (networkInfo.getType() != 0) {
                        AppMethodBeat.m2505o(20688);
                        return;
                    } else if (C3141b.this.mvB.type == 0 && C34189m.m56058Mw(C3141b.this.mvB.mvF).equals(C34189m.m56058Mw(networkInfo.getExtraInfo()))) {
                        C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                        AppMethodBeat.m2505o(20688);
                        return;
                    } else {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                            AppMethodBeat.m2505o(20688);
                            return;
                        }
                        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                        if (networkInfo2 == null) {
                            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                            AppMethodBeat.m2505o(20688);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", networkInfo2.getState(), networkInfo2.getDetailedState());
                        if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                            AppMethodBeat.m2505o(20688);
                            return;
                        }
                        C3143a c3143a2 = new C3143a();
                        c3143a2.mvE = System.currentTimeMillis();
                        c3143a2.type = 0;
                        c3143a2.ssid = "";
                        c3143a2.bssid = "";
                        c3143a2.mvF = C34189m.m56058Mw(networkInfo.getExtraInfo());
                        C3141b.m5378a(C3141b.this.mvB.byG(), c3143a2);
                        C3141b.this.mvB = c3143a2;
                        AppMethodBeat.m2505o(20688);
                        return;
                    }
                } catch (Exception e) {
                    C11967a byo = C11966k.byo();
                    byo.cuH = "UnExpectedException";
                    byo.result = -1;
                    byo.ehr = C34189m.m56077g(e);
                    byo.byq().byp();
                    C4990ab.m7412e("MicroMsg.FreeWifi.UnExcepctedException", C34189m.m56078h(e));
                }
            }
            AppMethodBeat.m2505o(20688);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.b$a */
    static class C3143a {
        String bssid;
        long mvE;
        String mvF;
        String ssid;
        int type;

        private C3143a() {
            this.ssid = "";
            this.bssid = "";
            this.mvF = "";
        }

        /* synthetic */ C3143a(byte b) {
            this();
        }

        public final C3143a byG() {
            AppMethodBeat.m2504i(20689);
            C3143a c3143a = new C3143a();
            c3143a.mvE = this.mvE;
            c3143a.type = this.type;
            c3143a.ssid = this.ssid;
            c3143a.bssid = this.bssid;
            c3143a.mvF = this.mvF;
            AppMethodBeat.m2505o(20689);
            return c3143a;
        }

        public final String toString() {
            AppMethodBeat.m2504i(20690);
            String format = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.mvE), Integer.valueOf(this.type), this.ssid, this.bssid, this.mvF});
            AppMethodBeat.m2505o(20690);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.b$b */
    static class C3144b {
        private static C3141b mvG = new C3141b();

        static {
            AppMethodBeat.m2504i(20691);
            AppMethodBeat.m2505o(20691);
        }
    }

    /* synthetic */ C3141b(byte b) {
        this();
    }

    private C3141b() {
        AppMethodBeat.m2504i(20692);
        this.mvB = new C3143a();
        this.mvC = new C31421();
        AppMethodBeat.m2505o(20692);
    }

    public final void byc() {
        AppMethodBeat.m2504i(20693);
        try {
            C4996ah.getContext().unregisterReceiver(this.mvC);
            AppMethodBeat.m2505o(20693);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(20693);
        }
    }

    /* renamed from: a */
    static void m5378a(C3143a c3143a, C3143a c3143a2) {
        AppMethodBeat.m2504i(20694);
        C34189m.m56056MA("on mobile connected.");
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", c3143a.toString(), c3143a2.toString());
        C34187b.m56054kT(0);
        AppMethodBeat.m2505o(20694);
    }

    /* renamed from: b */
    static void m5379b(C3143a c3143a, C3143a c3143a2) {
        AppMethodBeat.m2504i(20695);
        C34189m.m56056MA("on wifi connected.");
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", c3143a.toString(), c3143a2.toString());
        if (c3143a.type == 1 && c3143a.ssid.equals(c3143a2.ssid) && !c3143a.bssid.equals(c3143a2.bssid)) {
            String str = c3143a.ssid;
            String str2 = c3143a.bssid;
            String str3 = c3143a2.bssid;
            C34189m.m56056MA("on wifi roaming.");
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", str, str2, str3);
        }
        C34187b.m56054kT(1);
        AppMethodBeat.m2505o(20695);
    }
}
