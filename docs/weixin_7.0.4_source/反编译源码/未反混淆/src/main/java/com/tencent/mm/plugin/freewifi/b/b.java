package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public final class b {

    public static class a {
        private static b mvi = new b();

        static {
            AppMethodBeat.i(20670);
            AppMethodBeat.o(20670);
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public final synchronized void a(fe feVar) {
        AppMethodBeat.i(20671);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String Mv = m.Mv(feVar.cyA.ssid);
        final String str = feVar.cyA.bssid;
        if (m.isEmpty(Mv)) {
            a(feVar, 1141, "Ssid is empty.");
            AppMethodBeat.o(20671);
        } else if (m.isEmpty(str)) {
            a(feVar, 1142, "Bssid is empty.");
            AppMethodBeat.o(20671);
        } else {
            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + feVar.cyA.ssid + "; bssid=" + feVar.cyA.bssid + "; version=" + feVar.cyA.version);
            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            com.tencent.mm.plugin.freewifi.b.a.b eq = a.mve.eq(Mv, str);
            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (eq != null) {
                final String str2 = eq.cuH;
                int i = eq.mue;
                if (i == 4) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(20668);
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.bys());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            d.b(ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                            AppMethodBeat.o(20668);
                        }
                    });
                    a(feVar, 1, null);
                    AppMethodBeat.o(20671);
                } else if (i == 31) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(20669);
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", Mv);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(ah.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(268435456);
                            ah.getContext().startActivity(intent);
                            AppMethodBeat.o(20669);
                        }
                    });
                    a(feVar, 1, null);
                    AppMethodBeat.o(20671);
                } else {
                    a(feVar, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
                    AppMethodBeat.o(20671);
                }
            } else if (a.mve.size() == 0) {
                a(feVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
                AppMethodBeat.o(20671);
            } else {
                a(feVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
                AppMethodBeat.o(20671);
            }
        }
    }

    private static void a(fe feVar, int i, String str) {
        AppMethodBeat.i(20672);
        feVar.cyB.cyE = i;
        feVar.cyB.cyF = str;
        feVar.cyB.cyD = 1;
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", Integer.valueOf(i), str);
        if (feVar.callback != null) {
            feVar.callback.run();
        }
        AppMethodBeat.o(20672);
    }
}
