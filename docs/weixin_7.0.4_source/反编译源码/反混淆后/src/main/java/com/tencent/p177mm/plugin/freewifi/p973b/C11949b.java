package com.tencent.p177mm.plugin.freewifi.p973b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32552fe;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiManufacturerLoadingUI;
import com.tencent.p177mm.plugin.freewifi.p973b.C43103a.C20778a;
import com.tencent.p177mm.plugin.freewifi.p973b.C43103a.C20779b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.freewifi.b.b */
public final class C11949b {

    /* renamed from: com.tencent.mm.plugin.freewifi.b.b$a */
    public static class C11950a {
        private static C11949b mvi = new C11949b();

        static {
            AppMethodBeat.m2504i(20670);
            AppMethodBeat.m2505o(20670);
        }
    }

    /* synthetic */ C11949b(byte b) {
        this();
    }

    private C11949b() {
    }

    /* renamed from: a */
    public final synchronized void mo23794a(C32552fe c32552fe) {
        AppMethodBeat.m2504i(20671);
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String Mv = C34189m.m56057Mv(c32552fe.cyA.ssid);
        final String str = c32552fe.cyA.bssid;
        if (C34189m.isEmpty(Mv)) {
            C11949b.m19840a(c32552fe, 1141, "Ssid is empty.");
            AppMethodBeat.m2505o(20671);
        } else if (C34189m.isEmpty(str)) {
            C11949b.m19840a(c32552fe, 1142, "Bssid is empty.");
            AppMethodBeat.m2505o(20671);
        } else {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + c32552fe.cyA.ssid + "; bssid=" + c32552fe.cyA.bssid + "; version=" + c32552fe.cyA.version);
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            C20779b eq = C20778a.mve.mo68616eq(Mv, str);
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (eq != null) {
                final String str2 = eq.cuH;
                int i = eq.mue;
                if (i == 4) {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(20668);
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", C34189m.bys());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            C25985d.m41467b(C4996ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                            AppMethodBeat.m2505o(20668);
                        }
                    });
                    C11949b.m19840a(c32552fe, 1, null);
                    AppMethodBeat.m2505o(20671);
                } else if (i == 31) {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(20669);
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", Mv);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(C4996ah.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(268435456);
                            C4996ah.getContext().startActivity(intent);
                            AppMethodBeat.m2505o(20669);
                        }
                    });
                    C11949b.m19840a(c32552fe, 1, null);
                    AppMethodBeat.m2505o(20671);
                } else {
                    C11949b.m19840a(c32552fe, 1143, "Wechant installed Currently doesn't support connect protocol ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(20671);
                }
            } else if (C20778a.mve.size() == 0) {
                C11949b.m19840a(c32552fe, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
                AppMethodBeat.m2505o(20671);
            } else {
                C11949b.m19840a(c32552fe, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
                AppMethodBeat.m2505o(20671);
            }
        }
    }

    /* renamed from: a */
    private static void m19840a(C32552fe c32552fe, int i, String str) {
        AppMethodBeat.m2504i(20672);
        c32552fe.cyB.cyE = i;
        c32552fe.cyB.cyF = str;
        c32552fe.cyB.cyD = 1;
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", Integer.valueOf(i), str);
        if (c32552fe.callback != null) {
            c32552fe.callback.run();
        }
        AppMethodBeat.m2505o(20672);
    }
}
